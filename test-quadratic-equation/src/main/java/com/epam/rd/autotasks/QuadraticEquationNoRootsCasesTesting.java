package com.epam.rd.autotasks;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class QuadraticEquationNoRootsCasesTesting {

    protected QuadraticEquation quadraticEquation = new QuadraticEquation();

    @ParameterizedTest
    @CsvSource({
            "1, 0, 1",
            "2, 4, 6",
            "1, 2, 5",
            "3, 6, 10"
    })
    public void testCase(double a, double b, double c) {
        Assertions.assertEquals("no roots",quadraticEquation.solve(a,b,c));
    }
}
