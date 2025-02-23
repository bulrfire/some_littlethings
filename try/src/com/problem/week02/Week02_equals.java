package com.problem.week02;

public class Week02_equals {
    public static void main(String[] args) {
        Number n1 = new Number();
        n1.number = 10;

        Number n2 = new Number();
        n2.number = 10;

        System.out.println(n1.equals(n2)); //false
    }
}
