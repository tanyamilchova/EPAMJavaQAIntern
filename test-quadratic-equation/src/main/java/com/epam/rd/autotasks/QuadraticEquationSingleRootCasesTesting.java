package com.epam.rd.autotasks;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class QuadraticEquationSingleRootCasesTesting {
    protected QuadraticEquation quadraticEquation = new QuadraticEquation();

    @ParameterizedTest
    @CsvSource({
            "1, 6, 9, -3",
            "1, -4, 4, 2",
            "3, -12, 12, 2",
            "1, -2, 1, 1"
    })
    public void testCase(double a, double b, double c, double expected) {

        String expectedStr=String.valueOf(expected);
        Assertions.assertEquals(expectedStr,quadraticEquation.solve(a,b,c));
    }
}