package com.epam.rd.autotasks;

public class Factorial {
    public String factorial(String n) {
        if(n==null || n.isEmpty() ||  ! Character.isDigit(n.charAt(0))){
            throw new IllegalArgumentException();
        }
        int num=Integer.parseInt(n);
        if(num<0 ){
            throw new IllegalArgumentException();
        }
        long factoriel=1L;
        for (int i = 1; i <= num; i++) {
            factoriel*=i;
        }
        return String.valueOf(factoriel);

    }
}
