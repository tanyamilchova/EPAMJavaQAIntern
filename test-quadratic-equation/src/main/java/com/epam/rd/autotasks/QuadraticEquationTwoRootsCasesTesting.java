package com.epam.rd.autotasks;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;


public class QuadraticEquationTwoRootsCasesTesting {
    protected QuadraticEquation quadraticEquation = new QuadraticEquation();

    @ParameterizedTest
    @CsvSource({
            "1, -5, 6, '3.0 2.0'",
            "2, -4, -6, '3.0 -1.0'",
            "2, -8, 6, '3 1'",
            "6, 7, -3, '0.333 -1.5'"
    })
    public void testCase(double a, double b, double c, String expected) {
        String expectedStr=parceString(expected);
        String expectedStrReverced=parceStringReveerced(expected);
        String actual=parceString(quadraticEquation.solve(a,b,c));
        Assertions.assertTrue(expectedStr.equals(actual) ||
                (expectedStrReverced.equals(actual))) ;
    }

    private String parceStringReveerced(String input) {
        String formatedStr=null;
        String[]parced=input.split(" ");
        if(parced.length==2) {
            double root1 = Double.parseDouble(parced[0]);
            double root2 = Double.parseDouble(parced[1]);
            formatedStr=String.format("%.5s %.5s", root2,root1);
        }
        return formatedStr;
    }

    public String parceString(String input){
        if(input.equals("no roots")){
            return "no roots";
        }
        String[]parced=input.split(" ");
        if(parced.length==2) {
            double root1 = Double.parseDouble(parced[0].trim());
            double root2 = Double.parseDouble(parced[1].trim());
        return String.format("%.5s %.5s",root1,root2);
        }
        return null;
    }
}
