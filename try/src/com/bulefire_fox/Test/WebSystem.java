package com.bulefire_fox.Test;

import java.util.Date;
import java.util.Random;
import java.util.Scanner;

public class WebSystem {
    public static void main(String[] args) {
        //用户名
        String[] Username = new String[100];
        //密码
        String[] PassWorld = new String[100];
        String[] user = new String[100];

        String[] userGPU = new String[100];
        String[] GPUUser = new String[100];
        int[] GPUNumber = new int[100];

        double[] money = new double[100];
        int number = 0;
        int userLoginNumber = 0;
        boolean[] luckNumber = new boolean[100];
        choose(null,user,money,number,Username,PassWorld,
                userLoginNumber,luckNumber,GPUNumber,userGPU,GPUUser);
    }

    //登录
    public static void login(String[] Username,String[] PassWorld,String[] user,double[] money,
                             int number,int userLoginNumber,boolean[] luckyNumber,
                             int[] GPUNumber,String[] userGPU,String[] GPUUser){
        Scanner sc = new Scanner(System.in);
        System.out.println("用户名");
        String UserName = sc.next();
        System.out.println("密码");
        String passWorld = sc.next();
        for (int i = 0; i < Username.length; i++) {
            if(UserName.equals(Username[i])){
                if(passWorld.equals(PassWorld[i])){
                    System.out.println("欢迎 " + Username[i]);
                    choose(Username[i],user,money,number,Username,PassWorld,
                            userLoginNumber,luckyNumber,GPUNumber,userGPU,GPUUser);
                }
                else{
                    System.out.println("密码或用户名错误");
                }
                return;
            }
        }
        System.out.println("密码或用户名错误");
    }

    public static void login(String[] Username,String[] PassWorld,String[] user,
                             double[] money,int number,int userLoginNumber,boolean[] luckNumber,
                             int[] GPUNumber,String[] userGPU,String[] GPUUser,int a){
        Scanner sc = new Scanner(System.in);
        System.out.println("用户名");
        String UserName = sc.next();
        Username[userLoginNumber] = UserName;
        System.out.println("密码");
        String passWorld = sc.next();
        PassWorld[userLoginNumber] = passWorld;
        System.out.println("录入成功");
        System.out.println("请再次登录");
        login(Username,PassWorld,user, money,number,userLoginNumber,luckNumber,GPUNumber,userGPU,GPUUser);
    }

    public static void choose(String name,String[] user,double[] money,int number,String[] Username,
                              String[] PassWorld,int userLoginNumber,boolean[] luckNumber,
                              int[] GPUNumber,String[] userGPU,String[] GPUUser){
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("操作");
            String choose = sc.next();
            switch (choose){
                case "登录":
                    login(Username,PassWorld,user, money,number,
                            userLoginNumber,luckNumber,GPUNumber,userGPU,GPUUser);
                    break;
                case "注册":
                    login(Username,PassWorld,user, money,number,
                            userLoginNumber,luckNumber,GPUNumber,userGPU,GPUUser,0);
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
                case "日期":
                    time();
                    break;
                case "挖矿":
                    wk(GPUNumber,userGPU,number,name,GPUUser);
                    break;
            }
        }
    }

    private static void wk(int[] GPUNumber,String[] userGPU,int number,String name,String[] GPUUser) {
        String[] NvidiaGPU = {"690","960","1010","1020",
                "1030","1040","1050","1060","1070","1080",
                "1090","2010","2020","2030","2040",
                "2050","2060","2070","2080","2090","3010",
                "3020","3030","3040","3050","3060","3070",
                "3080","3090","4010","4020","4030","4040",
                "4050","4060","4070","4080","4090"};

        String[] NvidiaGPUSuper = {"2050s","2060s","2070s",
                "2080s","2090s","4060s","4070s","4080s","4090s"};

        double[] NvidiaGPUAllW = {100};

        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < GPUUser.length; i++) {
            if (name.equals(GPUUser[number])){
                System.out.println("用户" + GPUUser[number]);
                if (userGPU[number] == null){
                    System.out.println("你还没有显卡");
                    System.out.println("是(y)/(n)否购买");
                    String choose = sc.next();
                    switch (choose){
                        case "y":
                            System.out.println("正在前往购买显卡");
                            GPUIn();
                            break;
                        case "n":
                            System.out.println("以取消购买");
                            return;
                    }
                    return;
                }
                System.out.println("拥有" + GPUNumber[number] + "张" + userGPU[number] + "显卡");
                System.out.println("是(y)/否(n)开始");
                if (sc.next().equals("y")) {
                    startWk(userGPU[number],NvidiaGPUAllW[0]);
                }
                else if (sc.next().equals("n")){
                    System.out.println("以退出矿场");
                    return;
                }
            }
            return;
        }
        System.out.println("用户不存在，是(y)/否(n)创建用户？");
        String choose = sc.next();
        switch (choose){
            case "y":
                GPUUser[number] = name;
                GPUNumber[number] = 0;
                userGPU[number] = null;
                System.out.println("创建成功");
                break;
            case "n":
                System.out.println("以取消创建");
                return;
        }
    }

    public static void GPUIn() {

    }

    public static void startWk(String userGPU,double NvidiaGPUAllW){

    }

    public static void time() {
        Date d = new Date();
        System.out.println(d);
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
                System.out.println("以取消创建");
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
