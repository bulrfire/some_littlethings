package com.bluefire_fox.die;

import java.util.Random;
import java.util.Scanner;

public class DieTest2 {
    public static void main(String[] args) {
        //定义扫描器
        Scanner sc = new Scanner(System.in);
        //输出提示
        System.out.println("""
                模式
                单色子（1）
                双色子（2）
                """);
        //初始化次数
        int frequency = 1;
        //死循环
        while (true) {
            //获取用户选择的模式
            int choose = sc.nextInt();
            //判断模式
            //单色子模式
            if (choose == 1) {
                //获取随机数（1次）
                int a = die();
                //提示用户次数
                System.out.println("第" + frequency + "次输出");
                //输出
                out(a,choose);
                //将次数+1
                frequency++;
            }
            //双色子模式
            else if (choose == 2) {
                //提示用户次数
                System.out.println("第" + frequency + "次输出");
                //将次数+1
                frequency++;
                //初始化求和
                int sum = 0;
                //初始化循环次数
                int a = 0;
                //循环2次
                while (a < 2){
                    //获取随机数
                    int a1 = die();
                    int back = out(a1,choose);
                    //循环次数+1
                    a++;
                    //递增求和
                    sum += back;
                }
                //输出求和
                System.out.println("和为" + sum);
            }
            //模式选择器错误
            else {
                //报错
                System.out.println("no find");
            }
        }
    }
    //定义色子（随机数）方法
    public static int die() {
        //定义随机数
        Random r = new Random();
        //返回随机数
        return r.nextInt(1, 7);
    }
    //定义输出方法
    public static int out(int number,int model){
        //初始化求和变量
        int sum = 0;
        //判断模式
        //单色子模式
        if(model == 1){
            //输出
            System.out.println(number);
        }
        //双色子模式
        else if(model == 2){
            //输出
            System.out.println(number);
            //增加求和变量
            sum +=number;
        }
        //返回求和
        return sum;
    }
}