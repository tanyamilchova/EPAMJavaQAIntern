package com.epam.rd.autotasks;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;


public class QuadraticEquationZeroACasesTesting {
    protected QuadraticEquation quadraticEquation = new QuadraticEquation();

    @ParameterizedTest
    @CsvSource({
            "0, 0, 1",
            "0, 4, 6",
            "0, 2, 5",
            "0, 6, 10"
    })
    public void testCase(double a, double b, double c) {
        Assertions.assertThrows(IllegalArgumentException.class,()->quadraticEquation.solve(a,b,c));
    }
}
