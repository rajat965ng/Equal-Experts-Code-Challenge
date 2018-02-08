package com.shopping.cart.handler;

import com.shopping.cart.entity.Cart;
import com.shopping.cart.entity.Product;

import java.util.List;
import java.util.stream.IntStream;

public class AddToCartHandler implements IAddToCartHandler {

    private List<Product> productList;

    @Override
    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    @Override
    public double addProduct(Product product, int qty) {

        double price =  IntStream.range(0,qty).mapToDouble(i -> {
            productList.add(product);
            return product.getValue();
        }).sum();
        System.out.println("Adding "+qty+" unit of "+product);
        return price;
    }
}
