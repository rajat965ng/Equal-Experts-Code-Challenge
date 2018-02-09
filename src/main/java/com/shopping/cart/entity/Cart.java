package com.shopping.cart.entity;

import com.shopping.cart.handler.AddToCartHandler;
import com.shopping.cart.handler.GenericTaxHandler;
import com.shopping.cart.handler.IAddToCartHandler;
import com.shopping.cart.handler.ITaxHandler;

import java.util.ArrayList;
import java.util.List;

public class Cart {

    private List<Product> productList;
    private double totalPrice;

    private IAddToCartHandler addToCartHandler;
    private ITaxHandler taxHandler;

    public Cart() {
        this.productList = new ArrayList<>();
        setAddToCartHandler(new AddToCartHandler());
        setTaxHandler(new GenericTaxHandler(),0);
    }


    public void setTax(double taxRate) {
            taxHandler.setTaxRate(taxRate);
    }

    public double getCalculatedTax(){
        return taxHandler.getTaxOnTotalPrice(totalPrice);
    }


    public void addProduct(Product product, int qty){
        double price = addToCartHandler.addProduct(product,qty);
        totalPrice+=price;
    }

    public long getQtyByProduct(Product product){
        return productList.stream().filter(prod->prod==product).count();
    }

    public int getCartSize(){
        return productList.size();
    }

    public double getTotalPrice(){
        return taxHandler.getPriceAfterTax(totalPrice);
    }


    public void setAddToCartHandler(IAddToCartHandler addToCartHandler) {
        if(addToCartHandler instanceof IAddToCartHandler) {
            this.addToCartHandler = addToCartHandler;
            this.addToCartHandler.setProductList(productList);
        }
    }

    public void setTaxHandler(ITaxHandler taxHandler,double taxRate){
        if (taxHandler instanceof ITaxHandler){
            this.taxHandler = taxHandler;
            setTax(taxRate);
        }
    }


}
