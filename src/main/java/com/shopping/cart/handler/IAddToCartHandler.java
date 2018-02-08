package com.shopping.cart.handler;

import com.shopping.cart.entity.Product;

public interface IAddToCartHandler {
    public double addProduct(Product product, int qty);
}
