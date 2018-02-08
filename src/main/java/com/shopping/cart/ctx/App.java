package com.shopping.cart.ctx;

import java.text.DecimalFormat;

public class App {

    public static void main(String args[]){
        double val = 0.567;
        DecimalFormat decimalFormat = new DecimalFormat("#.##");
        System.out.println(Double.parseDouble(decimalFormat.format(val)));
        val = 0.564;
        System.out.println(decimalFormat.format(val));
        val = 239.94000000000003;
        System.out.println(decimalFormat.format(val));
        val = 199.95000000000002;
        System.out.println(decimalFormat.format(val));
        val = 0.00;
        System.out.println(decimalFormat.format(val));
    }

}
