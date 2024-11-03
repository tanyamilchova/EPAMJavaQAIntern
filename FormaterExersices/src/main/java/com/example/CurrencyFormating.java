package com.example;

import java.util.Locale;
import java.util.function.DoubleFunction;
import java.util.function.Function;

public interface CurrencyFormating {
    DoubleFunction<String>currencyFormating=doubleNumber ->{
        return (doubleNumber<0
                ? String.format(Locale.US,"-$%,.2f", Math.abs(doubleNumber))
                : String.format(Locale.US,"$%,.2f", doubleNumber));
    };
    public static void main(String[] args) {
        System.out.println(CurrencyFormating.currencyFormating.apply(1234.5));
        System.out.println(CurrencyFormating.currencyFormating.apply(100));
        System.out.println(CurrencyFormating.currencyFormating.apply(-245.55));
        System.out.println(CurrencyFormating.currencyFormating.apply(0.256));
    }

}
