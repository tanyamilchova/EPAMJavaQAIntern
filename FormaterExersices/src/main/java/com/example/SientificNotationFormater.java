package com.example;

import java.util.function.DoubleFunction;

public interface SientificNotationFormater {
    DoubleFunction<String>sientificFormater=doubleNumber ->{
        double formater= Math.round(doubleNumber);
        return (long)formater == 0 ? String .format("%.2f", doubleNumber*10000) + "E-04"
       : String.format("%.2f",formater/10000) + "E04";
    };

    public static void main(String[] args) {
        System.out.println(SientificNotationFormater.sientificFormater.apply(12345));
        System.out.println(SientificNotationFormater.sientificFormater.apply(-98765.4321));
        System.out.println(SientificNotationFormater.sientificFormater.apply(0.000123));
    }
}
