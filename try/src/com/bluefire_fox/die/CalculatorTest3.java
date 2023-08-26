package com.bluefire_fox.die;

import java.util.Scanner;

public class CalculatorTest3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean go = true;
        double result = 0;
        while (go) {
            System.out.print("请输入一个数字：");
            double num1 = scanner.nextDouble();
            System.out.print("请输入运算符（+、-、*、/、=）：");
            String operator = scanner.next();
            in(operator,result,num1,go);
        }

    }

    public static void in(String operator,double result,double num1,boolean go){
        switch (operator) {
            case "+":
                result = result + num1;
                break;
            case "-":
                result -= num1;
                break;
            case "*":
                result *= num1;
                break;
            case "/":
                result /= num1;
                break;
            case "=":
                in(operator,result,num1,go);
                break;
            default:
                System.out.println("无效的运算符");
                return;
        }
        System.out.println("计算结果：" + result);
    }
}