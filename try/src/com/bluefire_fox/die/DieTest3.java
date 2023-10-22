package com.bluefire_fox.die;

import java.util.Random;
import java.util.Scanner;

public class DieTest3 {
    public static void main(String[] args) {
    Die_main();
    }

    public static void Die_main(){
        //提示用户使用方法
        System.out.println("""
                请输入需要的色子次数
                如输入 5 则会输出5次色子的数
                和总点数
                """);
        //定义扫描器
        Scanner sc = new Scanner(System.in);
        //初始化次数
        int dies = 0;
        //死循环
        while (true){
            //获取用户选择模式
            int choose = sc.nextInt();
            //初始化求和
            int sum = 0;
            //初始化循环次数
            int times = 1;
            //次数加一
            dies++;
            //提示用户次数
            System.out.println("第" + dies + "输出");
            //重复获取随机数
            while (times <= choose) {
                //获取随机数
                int temp = die();
                //输出随机数
                out(temp,times);
                //次数加一
                times++;
                //求和增加
                sum += temp;
            }
            //判断色子数是否大于1
            if (choose > 1){
                System.out.println("和为" + sum);
            }
        }
    }

    //定义色子（随机数）方法
    public static int die(){
        //定义随机数
        Random r = new Random();
        //返回随机数
        return r.nextInt(1,7);
    }
    //定义输出
    public static void out(int number,int times){
        System.out.println("第" + times + "个色子的点数为" + number + " ");
    }
}