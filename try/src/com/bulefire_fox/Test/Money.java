package com.bulefire_fox.Test;

import java.util.InputMismatchException;
import java.util.Scanner;
import com.bulefire_fox.Test.WebSystem;

public class Money {
    //钱包主方法
    public static boolean money(String name,String[] user,double[] money,int number){
        Scanner sc = new Scanner(System.in);
        //初始化递归为false
        boolean down = true;
        //寻找用户登录
        for (int i = 0; i < user.length; i++) {
            if(name.equals(user[i])){
                //成功
                System.out.println("欢迎进入钱包系统");
                System.out.println("用户：" + name);
                System.out.println("钱包剩余存款：" + money[i]);
                //取消递归
                down = false;
                break;
            }
        }
        //判断用户是否存在
        if (!down){
            //存在
            System.out.println("""
                               操作
                               你当前可以
                               [存钱]
                               [取钱]
                               [返回]
                               """);
            String choose = sc.next();
            //进分支
            switch (choose){
                case "存钱":
                    //寻找用户
                    for (int i = 0; i < user.length; i++) {
                        if(name.equals(user[i])){
                            //进存钱
                            moneyIn(name,money,i);
                            //递归
                            money(name,user,money,number);
                        }
                    }
                    break;
                case "取钱":
                    for (int i = 0; i < user.length; i++) {
                        //寻找用户
                        if (name.equals(user[i])){
                            //进取钱
                            moneyOut(name,money,i);
                            //递归
                            money(name,user,money,number);
                        }
                    }
                    break;
                case "返回":
                    //退出并取消递归
                    return false;
                default:
                    //异常处理
                    System.out.println("error1:未知操作！");
                    //递归
                    money(name, user, money, number);
                    break;
            }
            return false;
        }
        //用户不存在
        System.out.println("用户不存在,是(yes)/否(no)创建用户？");
        String typename = sc.next();
        switch (typename){
            case "yes":
                //以用户当前的名字注册账号
                user[number] = name;
                //初始化存款为0
                money[number] = 0;
                System.out.println("创建成功");
                //退出并开启递归
                return true;
            case "no":
                System.out.println("以取消创建");
                //退出并取消递归
                return false;
            default:
                System.out.println("error1:未知操作！");
                break;
        }
        //退出并取消递归（意义不明的保险代码
        return false;
    }
    //存钱
    public static void moneyIn(String name,double[] money,int inNumber){
        Scanner sc = new Scanner(System.in);
        System.out.println("存入钱数：");
        //获取存取钱数
        double inMoney = 0;
        //捕获异常
        try {
            inMoney = sc.nextDouble();
        } catch (InputMismatchException error) {
            //报错
            System.out.println("你输入的金额无效！");
            System.out.println("请重新输入");
            //递归
            moneyIn(name, money, inNumber);
        }
        //总钱数加上存款金额
        money[inNumber] += inMoney;
        System.out.println(name + " 成功存入 " + inMoney);
        System.out.println("""
                        操作
                        你当前可以
                        [返回]
                        [继续存钱]
                        """);
        String choose = sc.next();
        //分支
        switch (choose){
            case "返回":
                //退出
                break;
            case "继续存钱":
                //递归
                moneyIn(name, money, inNumber);
                break;
            default:
                //异常处理
                System.out.println("error1:未知操作！");
                //递归
                moneyIn(name, money, inNumber);
                break;
        }
    }
    //取钱
    public static void moneyOut(String name,double[] money,int inNumber){
        Scanner sc = new Scanner(System.in);
        System.out.println("取出钱数");
        //获取取出钱数
        double outMoney = 0;
        //捕获异常
        try {
            outMoney = sc.nextDouble();
        } catch (InputMismatchException error) {
            //报错
            System.out.println("你输入的金额无效！");
            System.out.println("请重新输入");
            //递归
            moneyOut(name, money, inNumber);
        }
        //判断取钱金额是否超过总金额
        if (outMoney > money[inNumber]){
            //是，提示
            System.out.println("余额不足");
            System.out.println("当前余额" + money[inNumber] + "\n取出钱数" + outMoney);
            System.out.println("""
                                你当前可以
                                [重新选择金额]
                                [退出]
                                """);
            String choose = sc.next();
            //分支
            switch (choose){
                case "重新选择金额":
                    //递归
                    moneyOut(name,money,inNumber);
                    break;
                case "退出":
                    //退出
                    break;
                default:
                    //异常处理
                    System.out.println("error1:未知操作！");
                    //递归
                    moneyOut(name, money, inNumber);
                    break;
            }
        }
        //否
        //总钱数减去取出钱数
        money[inNumber] -= outMoney;
        //tips
        System.out.println(name + " 成功取出 " + outMoney);
        System.out.println("""
                           操作
                           你当前可以
                           [返回]
                           [继续取钱]
                            """);
        String choose = sc.next();
        //分支
        switch (choose){
            case "返回":
                //退出
                break;
            case "继续取钱":
                //递归
                moneyOut(name, money, inNumber);
                break;
            default:
                //异常处理
                System.out.println("error1:未知操作！");
                //递归
                moneyOut(name, money, inNumber);
                break;
        }
    }
}
