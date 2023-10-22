package com.bluefire_fox.die;

import java.util.Scanner;

public class CalculatorTest4 {
    public static void main(String[] args) {
        Calculator();
    }

    public static void Calculator(){
        Scanner sc = new Scanner(System.in);
        double re = sc.nextInt();
        while (true) {
            String op = sc.next();
            if (op.equals("=")){
                break;
            }
            double number = sc.nextInt();
            re = getRe(re, op, number);
        }
        System.out.println(re);
    }

    public static double getRe(double re, String op, double number) {
        switch (op){
            case "+":
                re += number;
                break;
            case "-":
                re -= number;
                break;
            case "*":
                re *= number;
                break;
            case "/":
                re /= number;
                break;
        }
        return re;
    }
}
