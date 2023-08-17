package com.bluefire_fox.die;

import java.util.Scanner;

public class CalculatorTest2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("""
                加1
                减2
                乘3
                除4
                """);
        System.out.println("模式");

        while (true) {
            int choose = sc.nextInt();

            //初始化求和变量
            double sum = 0;
            double cheng = 1;
            switch (choose) {
                case (1):
                    sumOut(sum);
                    break;

                case (2):
                    double jian = sc.nextDouble();
                    jianOut(jian);
                    break;

                case (3):
                    chengOut(cheng);
                    break;

                case (4):
                    double chu = sc.nextDouble();
                    chuOut(chu);
                    break;
            }
        }

    }
    //加法调用
    public static void sumOut(double sum){
        Scanner sc = new Scanner(System.in);
        //重复输入
        while (true) {
            //输入
            double in = sc.nextDouble();
            sum += in;
            //退出循环控制
            if (in == 0){
                break;
            }
        }
        //输出
        System.out.println("out "+sum);
    }
    //加法调用
    public static void jianOut(double jian){
        Scanner sc = new Scanner(System.in);
        //重复输入
        while (true) {
            //输入
            double in = sc.nextDouble();
            jian -= in;
            //退出循环控制
            if (in == 0){
                break;
            }
        }
        //输出
        System.out.println("out "+jian);
    }
    //乘法
    public static void chengOut(double cheng){
        Scanner sc = new Scanner(System.in);
        //重复输入
        while (true) {
            //输入
            double in = sc.nextDouble();
            //退出循环控制
            if (in == 0){
                break;
            }
            //运算
            cheng  *= in;
        }
        //输出
        System.out.println("out "+cheng);
    }
    //除法
    public static void chuOut(double chu){
        Scanner sc = new Scanner(System.in);
        //重复输入
        while (true) {
            //输入
            double in = sc.nextDouble();
            //退出循环控制
            if (in == 0){
                break;
            }
            //运算
            chu  /= in;
        }
        //输出
        System.out.println("out "+chu);
    }
}
