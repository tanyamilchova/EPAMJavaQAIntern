package com.epam.rd.autotasks;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class FactorialBadInputTesting {

    Factorial factorial = new Factorial();

    @Test
    void testNullInput(){
        String expected="1";
        Assertions.assertEquals(expected,factorial.factorial("0"));
    }

    @Test
    void testNegativeInput(){
        String input="-5";
        Assertions.assertThrows(IllegalArgumentException.class,()->factorial.factorial(input));
    }

    @Test
    void testFractionalInput(){
        String input = "5.5";
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            factorial.factorial(input);
        });
    }

    @Test
    void testNonDigitalInput(){
        String input="a";
        Assertions.assertThrows(IllegalArgumentException.class,()->factorial.factorial(input));
    }
}
