package com.shopping.cart.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Cart {

    private List<Product> products;

    public Cart() {
        this.products = new ArrayList<>();
    }

    public void addProduct(Product product,int qty){
        IntStream.range(0,qty).forEach(e->{
            products.add(product);
        });
        System.out.println("Adding "+qty+" unit :"+product);
    }

    public long getQtyByProduct(Product product){
       return products.stream().filter(prod->prod==product).count();
    }

    public int getCartSize(){
        return products.size();
    }

    public double getTotalPrice(){
      return products.stream().map(Product::getValue)
              .collect(Collectors.summarizingDouble(val->val))
              .getSum();
    }

}
