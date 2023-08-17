package com.bluefire_fox.die;

import java.util.Scanner;

public class CalculatorTest {
    public static void main(String[] args) {
        //提示用户使用方式
        System.out.println("""
                输入数据并选择运算模式
                1加
                2减
                3乘
                4除
                如 1 2 2 代表1-2
                返回-1
                （可以输入小数）
                """);
        //定义扫描器
        Scanner sc = new Scanner(System.in);
        while (true) {
            //输入第一个数
            System.out.println("请输入第一个数");
            double a = sc.nextInt();
            //输入第二个数
            System.out.println("请输入第二个数");
            double b = sc.nextInt();
            //选择模式
            System.out.println("请选择计算模式");
            int choose = sc.nextInt();
            //判断模式
            if (choose == 1){
                sum(a,b);
            }
            else if (choose == 2){
                subtraction(a,b);
            }
            else if (choose == 3){
                multiplication(a,b);
            }
            else if (choose == 4){
                division(a,b);
            }
        }
    }
    //加法
    public static void sum(double a,double b){
        System.out.println(a + b);
    }
    //减法
    public static void subtraction(double a,double b){
        System.out.println(a - b);
    }
    //乘法
    public static void multiplication(double a,double b){
        System.out.println(a * b);
    }
    //除法
    public static void division(double a,double b){
        System.out.println(a / b);
    }
}
