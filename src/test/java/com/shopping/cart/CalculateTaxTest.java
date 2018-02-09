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
        assertEquals(2,cart.getCartSize());
        assertEquals(2,cart.getQtyByProduct(Product.DOVE));
    }


    @Test
    public void should_cart_contain_2_axe_deo_when_add_2_axe_of_unit_price_99_point_99(){
        cart = new Cart();
        cart.addProduct(Product.AXE,2);
        assertEquals(2,cart.getCartSize());
        assertEquals(2,cart.getQtyByProduct(Product.AXE));
    }

    @Test
    public void should_calculate_total_tax_35_when_add_2_axe_and_2_dove_at_12_point_5_tax(){
        cart = new Cart();
        cart.addProduct(Product.DOVE,2);
        cart.addProduct(Product.AXE,2);
        cart.setTax(12.5);

        assertEquals(4,cart.getCartSize());
        assertEquals(35.00,cart.getCalculatedTax(),0.00);
    }

    @Test
    public void should_not_calculate_total_tax_35_when_add_5_axe_and_2_dove_at_12_point_5_tax(){
        cart = new Cart();
        cart.addProduct(Product.DOVE,5);
        cart.addProduct(Product.AXE,2);
        cart.setTax(12.5);

        assertNotEquals(4,cart.getCartSize());
        assertNotEquals(35.00,cart.getCalculatedTax(),0.00);
    }

    @Test
    public void should_calculate_total_price_314_point_96_when_add_2_axe_and_2_dove_at_12_point_5_tax(){
        cart = new Cart();
        cart.addProduct(Product.AXE,2);
        cart.addProduct(Product.DOVE,2);
        cart.setTax(12.5);

        assertEquals(4,cart.getCartSize());
        assertEquals(314.96,cart.getTotalPrice(),0.00);
    }


    @Test
    public void should_not_calculate_total_price_314_point_96_when_add_5_axe_and_2_dove_at_12_point_5_tax(){
        cart = new Cart();
        cart.addProduct(Product.AXE,5);
        cart.addProduct(Product.DOVE,2);
        cart.setTax(12.5);
        assertNotEquals(314.96,cart.getTotalPrice(),0.00);
    }


    @Test
    public void should_calculate_0_tax_when_no_product_is_added(){
        cart = new Cart();
        assertEquals(0,cart.getCalculatedTax(),0.00);
    }
}
