package org.example;

public class BooleanCreation {
    public static void main(String[] args) {
        Boolean bool1=Boolean.TRUE;
        Boolean bool2=Boolean.parseBoolean("AbC");
        System.out.println(bool2);
        System.out.println(Boolean.logicalAnd(bool1,bool2));
        System.out.println(Boolean.logicalOr(bool1,bool2));
        System.out.println(Boolean.logicalXor(bool1,bool2));

    }
}

