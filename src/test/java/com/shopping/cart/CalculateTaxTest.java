package com.shopping.cart;

import com.shopping.cart.entity.Cart;
import com.shopping.cart.entity.Product;
import org.junit.Test;

import static org.junit.Assert.*;

public class CalculateTaxTest {

    private Cart cart;

    @Test
    public void should_cart_contain_2_dove_when_add_2_dove_of_unit_price_39_point_99(){
        cart = new Cart();
        cart.addProduct(Product.DOVE,2);
        assertEquals(2,cart.getQtyByProduct(Product.DOVE));
    }


    @Test
    public void should_cart_contain_2_axe_deo_when_add_2_axe_of_unit_price_99_point_99(){
        cart = new Cart();
        cart.addProduct(Product.AXE,2);
        assertEquals(2,cart.getQtyByProduct(Product.AXE));
    }

    @Test
    public void should_calculate_total_tax_35_when_add_2_axe_and_2_dove(){
        cart = new Cart();
        cart.addProduct(Product.DOVE,2);
        cart.addProduct(Product.AXE,2);
        cart.setTax(12.5);
        assertEquals(35.00,cart.getCalculatedTax(),0.00);
    }




}
