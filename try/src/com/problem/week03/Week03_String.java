package com.problem.week03;

public class Week03_String {
    public static void main(String[] args) {

        String a = "hello";
        String b = "hello";

        String c = new String("hello");
        String d = new String("hello");

        System.out.println(a == b); //true
        System.out.println(c == d); //false
        System.out.println(a == c); //false
        System.out.println(c.equals(d)); //true
    }
}
