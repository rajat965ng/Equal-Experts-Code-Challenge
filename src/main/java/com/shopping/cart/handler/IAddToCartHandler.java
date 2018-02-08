package com.shopping.cart.handler;

import com.shopping.cart.entity.Product;

import java.util.List;

public interface IAddToCartHandler {
    public double addProduct(Product product, int qty);
    public void setProductList(List<Product> productList);
}
