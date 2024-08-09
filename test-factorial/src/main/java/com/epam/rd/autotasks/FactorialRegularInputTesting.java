package com.epam.rd.autotasks;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FactorialRegularInputTesting {

    Factorial factorial = new Factorial();
    @Test
    void testEmptyStringInput(){
       assertThrows(IllegalArgumentException.class,()->factorial.factorial(""));
    }
    @Test
    void testNullStringInput(){
        assertThrows(IllegalArgumentException.class,()->factorial.factorial(null));
    }
    @Test
    void testSymbolInput(){
        assertThrows(IllegalArgumentException.class,()->factorial.factorial("*"));
    }
    @Test
    void testWrongOutput(){
        String input="5";
        String expected="100";
        assertEquals(expected,factorial.factorial(input));
    }
    @Test
    public void testFactorialGreaterThanZero() {
        long result=Long.parseLong(factorial.factorial("0"));
        Assertions.assertTrue(result > 0L);
    }
}
