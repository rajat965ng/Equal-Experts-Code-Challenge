package com.shopping.cart;

import java.text.DecimalFormat;

public class App {

    public static void main(String argsp[]){
        DecimalFormat decimalFormat= new DecimalFormat("#.##");
        System.out.println(decimalFormat.format(0.567));
        System.out.println(decimalFormat.format(34.99));

    }

}
