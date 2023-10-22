package com.bluefire_fox.die;

import java.util.Scanner;

public class CalculatorTest3 {

    private static volatile String operator_old;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean go = true;
        double result = 0;
        while (go) {
            System.out.print("请输入一个数字：");
            double num1 = scanner.nextDouble();
            System.out.print("请输入运算符（+、-、*、/、=）：");
            String operator = scanner.next();
            if (!operator.equals("=")){
                operator_old = operator;
            }
            switch (operator) {
                case "+":
                    result += num1;
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
                    go = false;
                    result = if5(operator_old,result,num1);
                    break;
                default:
                    System.out.println("无效的运算符");
                    return;
            }
        }
        System.out.println("计算结果：" + result);
    }

    public static double if5(String operator_old,double result,double num1){
        result = CalculatorTest4.getRe(result, operator_old, num1);
        return result;
    }
}