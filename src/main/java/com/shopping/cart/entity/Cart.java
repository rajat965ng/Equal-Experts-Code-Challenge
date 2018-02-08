package com.shopping.cart.entity;

import com.shopping.cart.handler.AddToCartHandler;
import com.shopping.cart.handler.IAddToCartHandler;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class Cart {

    private List<Product> productList;
    private double totalPrice;

    private IAddToCartHandler addToCartHandler;

    public Cart() {
        this.productList = new ArrayList<>();
        this.addToCartHandler = new AddToCartHandler(productList);
    }


    public void addProduct(Product product, int qty){
        double price = addToCartHandler.addProduct(product,qty);
        addToTotalPrice(price);
    }

    public long getQtyByProduct(Product product){
       return productList.stream().filter(prod->prod==product).count();
    }

    public int getCartSize(){
        return productList.size();
    }

    public double getTotalPrice(){
        DecimalFormat decimalFormat = new DecimalFormat("#.##");
        return Double.parseDouble(decimalFormat.format(totalPrice));
    }

    private void addToTotalPrice(double totalPrice){
        this.totalPrice+=totalPrice;
    }
}
