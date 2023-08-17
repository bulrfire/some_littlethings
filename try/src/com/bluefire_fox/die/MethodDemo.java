package com.bluefire_fox.die;

public class MethodDemo {
    public static double bug(double a,double b){
        double c = a / b;
        return c;
    }

    public static void main(String[] args) {
        double l = bug(3.0,4.5);
        System.out.println(l);
    }
}