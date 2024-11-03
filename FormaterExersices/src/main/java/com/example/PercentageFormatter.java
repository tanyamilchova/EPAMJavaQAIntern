package com.example;

import java.util.Locale;
import java.util.function.DoubleFunction;

public interface PercentageFormatter {
     DoubleFunction<String> INSTANCE = doubleNumber -> String.format(Locale.FRANCE,"%.2f", doubleNumber*100)
          + " %";
    public static void main(String[] args) {
        System.out.println(PercentageFormatter.INSTANCE.apply(1.567));
        System.out.println(PercentageFormatter.INSTANCE.apply(0.1234));
        System.out.println(PercentageFormatter.INSTANCE.apply(-0.4567));
    }
}
