package com.shopping.cart;

import com.shopping.cart.entity.Cart;
import com.shopping.cart.entity.Product;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;


public class CartTest {

    private Cart cart;

    @Test
    public void should_contain_5_dove_soaps_and_total_equal_to_199_point_95_when_added_5_dove_soaps_to_shopping_cart(){
        cart = new Cart();
        cart.addProduct(Product.DOVE,5);

        assertEquals(5,cart.getQtyByProduct(Product.DOVE));
        assertEquals(199.95,cart.getTotalPrice(),0.00);
        assertEquals(5,cart.getCartSize());
    }

    @Test
    public void should_not_contain_5_dove_soaps_and_total_not_equal_to_199_point_95_when_added_6_dove_soaps_to_shopping_cart(){
        cart = new Cart();
        cart.addProduct(Product.DOVE,6);

        assertNotEquals(5,cart.getQtyByProduct(Product.DOVE));
        assertNotEquals(199.95,cart.getTotalPrice(),0.00);
        assertEquals(6,cart.getCartSize());
    }

}
