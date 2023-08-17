package com.bluefire_fox.die;

import java.util.Random;
import java.util.Scanner;

public class DieTest {
    public static void main(String[] args) {
        int times = 0;
        int c =0;
        Random r = new Random();
        Scanner sc = new Scanner(System.in);
        System.out.println("""
                选择模式
                单骰子（1）
                双骰子（2）
                           """);
        int choose = sc.nextInt();
        if (choose == 1){
            c = 1;
        }
        else if (choose == 2){
            c = 2;
        }
        while (true) {
            int number = r.nextInt(1, 7);
            times++;
            System.out.println("第" + times + "次输出(退出9)");
            System.out.println(number);
            if(c == 2){
                int number2 = r.nextInt(1, 7);
                System.out.println(number2);
                System.out.println(number2 + number);
            }
            System.out.println("0继续");

            int a = sc.nextInt();
            if (a == 9) {
                System.out.println("结束");
                break;
            }
            if(a == 2){
                c = 2;
            }
            else if (a == 1) {
                c = 1;
            }
        }
    }
}