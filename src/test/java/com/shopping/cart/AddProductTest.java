package com.shopping.cart;

import com.shopping.cart.entity.Cart;
import com.shopping.cart.entity.Product;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;


public class AddProductTest {

    private Cart cart;

    @Test
    public void should_contain_5_dove_soaps_when_add_5_dove_soap(){
        cart = new Cart();
        cart.addProduct(Product.DOVE,5);
        assertEquals(5,cart.getQtyByProduct(Product.DOVE));
    }


    @Test
    public void should_not_contain_5_dove_soaps_when_add_6_dove_soap(){
        cart = new Cart();
        cart.addProduct(Product.DOVE,6);
        assertNotEquals(5,cart.getQtyByProduct(Product.DOVE));
    }

    @Test
    public void should_contain_5_dove_soaps_and_total_equal_to_199_point_95_when_unit_price_is_39_point_99(){
        cart = new Cart();
        cart.addProduct(Product.DOVE,5);

        assertEquals(5,cart.getQtyByProduct(Product.DOVE));
        assertEquals(199.95,cart.getTotalPrice(),0.00);
        assertEquals(5,cart.getCartSize());
    }

    @Test
    public void should_not_contain_5_dove_soaps_and_total_not_equal_to_199_point_95_when_added_6_with_unit_price_of_39_point_99(){
        cart = new Cart();
        cart.addProduct(Product.DOVE,6);

        assertNotEquals(5,cart.getQtyByProduct(Product.DOVE));
        assertNotEquals(199.95,cart.getTotalPrice(),0.00);
        assertEquals(6,cart.getCartSize());
    }

}
