package com.shopping.cart;

import com.shopping.cart.entity.Cart;
import com.shopping.cart.entity.Product;
import org.junit.Test;

import static org.junit.Assert.*;

public class AddMoreProductTest {

    private Cart cart;

    @Test
    public void should_contain_8_dove_soaps_when_3_more_are_added_after_adding_5_dove_soap(){
        cart = new Cart();
        cart.addProduct(Product.DOVE,5);

        cart.addProduct(Product.DOVE,3);
        assertEquals(8,cart.getQtyByProduct(Product.DOVE));
    }

    @Test
    public void should_not_contain_8_dove_soaps_when_4_more_are_added_after_adding_5_dove_soap(){
        cart = new Cart();
        cart.addProduct(Product.DOVE,5);

        cart.addProduct(Product.DOVE,4);
        assertNotEquals(8,cart.getQtyByProduct(Product.DOVE));
    }

    @Test
    public void should_contain_8_dove_with_total_price_319_point_92_when_unit_price_is_39_point_99(){
        cart = new Cart();
        cart.addProduct(Product.DOVE,5);

        cart.addProduct(Product.DOVE,3);

        assertEquals(319.92,cart.getTotalPrice(),0.00);
        assertEquals(8,cart.getCartSize());
    }


    @Test
    public void should_not_contain_8_dove_with_total_price_not_319_point_92_when_10_more_units_added(){
        cart = new Cart();
        cart.addProduct(Product.DOVE,5);

        cart.addProduct(Product.DOVE,10);

        assertNotEquals(319.92,cart.getTotalPrice(),0.00);
        assertEquals(15,cart.getCartSize());
    }

}
