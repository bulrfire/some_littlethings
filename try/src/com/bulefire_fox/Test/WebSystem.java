package com.bulefire_fox.Test;

import java.util.Random;
import java.util.Scanner;

public class WebSystem {
    public static void main(String[] args) {
        //用户名
        String[] Username = new String[100];
        //密码
        String[] PassWorld = new String[100];
        String[] user = new String[100];
        double[] money = new double[100];
        int number = 0;
        int userLoginNumber = 0;
        boolean[] luckNumber = new boolean[100];
        choose(null,user,money,number,Username,PassWorld,userLoginNumber,luckNumber);
    }

    //登录
    public static void login(String[] Username,String[] PassWorld,String[] user,double[] money,int number,int userLoginNumber,boolean[] luckyNumber){
        Scanner sc = new Scanner(System.in);
        System.out.println("用户名");
        String UserName = sc.next();
        System.out.println("密码");
        String passWorld = sc.next();
        for (int i = 0; i < Username.length; i++) {
            if(UserName.equals(Username[i])){
                if(passWorld.equals(PassWorld[i])){
                    System.out.println("欢迎 " + Username[i]);
                    choose(Username[i],user,money,number,Username,PassWorld,userLoginNumber,luckyNumber);
                }
                else{
                    System.out.println("密码或用户名错误");
                }
                return;
            }
        }
        System.out.println("密码或用户名错误");
    }

    public static void login(String[] Username,String[] PassWorld,String[] user,double[] money,int number,int userLoginNumber,boolean[] luckNumber,int a){
        Scanner sc = new Scanner(System.in);
        System.out.println("用户名");
        String UserName = sc.next();
        Username[userLoginNumber] = UserName;
        System.out.println("密码");
        String passWorld = sc.next();
        PassWorld[userLoginNumber] = passWorld;
        System.out.println("录入成功");
        System.out.println("请再次登录");
        login(Username,PassWorld,user, money,number,userLoginNumber,luckNumber);
    }

    public static void choose(String name,String[] user,double[] money,int number,String[] Username,String[] PassWorld,int userLoginNumber,boolean[] luckNumber){
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("操作");
            String choose = sc.next();
            switch (choose){
                case "登录":
                    login(Username,PassWorld,user, money,number,userLoginNumber,luckNumber);
                    break;
                case "注册":
                    login(Username,PassWorld,user, money,number,userLoginNumber,luckNumber,0);
                    break;
                case "退出登录":
                    System.out.println("已退出登录");
                    return;
                case "查看钱包":
                    boolean go = money(name,user,money,number);
                    number++;
                    if (go){
                        money(name,user,money,number);
                    }
                    break;
                case "幸运数字":
                    luckyNumber();
                    break;
            }
        }
    }

    public static boolean money(String name,String[] user,double[] money,int number){
        Scanner sc = new Scanner(System.in);
        boolean down = true;
        for (int i = 0; i < user.length; i++) {
            if(name.equals(user[i])){
                System.out.println("用户：" + name);
                System.out.println("钱包剩余存款：" + money[i]);
                down = false;
                break;
            }
        }
        if (!down){
            System.out.println("操作");
            String choose = sc.next();
            switch (choose){
                case "存钱":
                    for (int i = 0; i < user.length; i++) {
                        if(name.equals(user[i])){

                            moneyIn(name,money,i);
                            money(name,user,money,number);
                        }
                    }
                case "取钱":
                    for (int i = 0; i < user.length; i++) {
                        if (name.equals(user[i])){
                            moneyOut(name,money,i);
                            money(name,user,money,number);
                        }
                    }
            }
            return false;
        }
        System.out.println("用户不存在,是(yes)/否(no)创建用户？");
        String typename = sc.next();
        switch (typename){
            case "yes":
                user[number] = name;
                money[number] = 0;
                System.out.println("创建成功");
                return true;
            case "no":
                return false;
        }
        return false;
    }

    public static void moneyIn(String name,double[] money,int inNumber){
        Scanner sc = new Scanner(System.in);
        System.out.println("存入钱数：");
        double inMoney = sc.nextDouble();
        money[inNumber] += inMoney;
        System.out.println(name + " 成功存入 " + inMoney);
        System.out.println("操作");
        String choose = sc.next();
        switch (choose){
            case "返回":
                return;
            case "继续存钱":
                moneyIn(name, money, inNumber);
        }
    }

    public static void moneyOut(String name,double[] money,int inNumber){
        Scanner sc = new Scanner(System.in);
        System.out.println("取出钱数");
        double outMoney = sc.nextDouble();
        money[inNumber] -= outMoney;
        System.out.println(name + " 成功取出 " + outMoney);
        System.out.println("操作");
        String choose = sc.next();
        switch (choose){
            case "返回":
                return;
            case "继续取钱":
                moneyOut(name, money, inNumber);
        }
    }

    public static void luckyNumber(){
        Random r = new Random();
        int luckNumber = r.nextInt(0,101);
        System.out.println("你今天的幸运数字是：" + luckNumber);
    }
}
