package com.epam.rd.autotasks;


public class QuadraticEquation {
    public String solve(double a, double b, double c) {
        if(a==0.0){
            throw new IllegalArgumentException();
        }
        double discriminant=b * b - 4 * a * c;
        if(discriminant>0) {
           double  root1 = (-b + Math.sqrt(discriminant)) / (2 * a);
           double  root2 = (-b - Math.sqrt(discriminant)) / (2 * a);
            return String.format("%.5s %.5s",root1, root2);
        }else {
            System.out.println("In single root case");
            if (discriminant == 0) {
            double    root = -b / (2 * a);
            return (String.format("%.5s", root));
            }
            else {
                System.out.println("In no root case");
                return "no roots";
            }
        }
    }
}