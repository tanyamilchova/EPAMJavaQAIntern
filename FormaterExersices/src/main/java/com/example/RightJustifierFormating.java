package com.example;

import java.util.function.DoubleFunction;

public interface RightJustifierFormating {
    DoubleFunction<String>rightJustifier=doubleNumber -> {
        return String.format("%010d",(int)doubleNumber);
    };
    public static void main(String[] args) {
        System.out.println("1234567890");
        System.out.println(RightJustifierFormating.rightJustifier.apply(42));
        System.out.println(RightJustifierFormating.rightJustifier.apply(12345));
    }
}
