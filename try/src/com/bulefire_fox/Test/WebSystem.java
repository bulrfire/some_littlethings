package com.bulefire_fox.Test;

import java.util.Date;
import java.util.Random;
import java.util.Scanner;


public class WebSystem {
    /**
     *md鬼知道这玩意我写了多久啊
     * 不想写了啊
     * 挖矿那块快把我搞崩溃了
     * 什么哈希值
     * 什么多线程
     * 什么共享变量
     * 什么捕获异常
     * 啊啊啊啊啊啊啊啊啊啊啊啊啊
     * GPU还没做完啊
     * 全是抄AI的好叭
     * 学了数据库马上就把main方法删了
     * 什么静态数据库
     * 一重启直接一夜回到解放前
     * 为了这个我还去翻了好久的API文档
     * 我就不应该做这个的
     * 跟老师走多好啊
     * md自己写直接原地爆炸
     * 一个方法近十几个形参
     * 又屎山的感觉了好叭
     * 补注释又补了好久.....
     * 下次一定写注释
     * 一定，一定写注释
     * 不然我自己的不知道在写什么（虽然写了也不知道
     * 但丢给AI的时候可以帮助AI更好的理解我的代码
     * 从而更好的抄..啊不，学习AI给出的示例代码
     * 最近好多AI都用不了了...
     * 还是万卷稳定
     * 就是有时候容易抽风
     * 但至少能用
     * AI还都是从网站找到
     * 我甚至还真的学习到了一些代码.....奇迹！
     */
    //这个主方法只是充当数据库
    public static void main(String[] args) {
        //用户名
        String[] Username = new String[100];
        //密码
        String[] PassWorld = new String[100];
        String[] user = new String[100];
        //用户拥有的GPU
        String[] userGPU = new String[100];
        //GPU用户
        String[] GPUUser = new String[100];
        //拥有的GPU数量
        int[] GPUNumber = new int[100];
        //拥有的钱数
        double[] money = new double[100];
        //通用索引
        int number = 0;
        //密码索引
        int userLoginNumber = 0;
        //没啥卵用但不敢删
        boolean[] luckNumber = new boolean[100];
        //进主方法
        choose(null,user,money,number,Username,PassWorld,
                userLoginNumber,luckNumber,GPUNumber,userGPU,GPUUser);
    }

    //这个才是真正的主方法
    public static void choose(String name,String[] user,double[] money,int number,String[] Username, String[] PassWorld,int userLoginNumber,boolean[] luckNumber, int[] GPUNumber,String[] userGPU,String[] GPUUser){
        Scanner sc = new Scanner(System.in);
        //进死循环
        while (true) {
            //tips
            System.out.println("操作");
            //如果用户名为null及为登录，则只能注册和登录
            if (name == null){
                System.out.println("你还没有登录，\n请[登录]或[注册]");
                //获取操作
                String choose = sc.next();
                switch (choose) {
                    case "登录":
                        //登录
                        System.out.println("{登录}");
                        LongIn.login(Username, PassWorld, user, money, number,
                                userLoginNumber, luckNumber, GPUNumber, userGPU, GPUUser);
                        break;
                    case "注册":
                        //注册
                        System.out.println("{注册}");
                        LongIn.login(Username, PassWorld, user, money, number,
                                userLoginNumber, luckNumber, GPUNumber, userGPU, GPUUser,0);
                        break;
                    default:
                        System.out.println("error1:未知操作！");
                        break;
                }
                //退出
                return;
            }
            System.out.println("进入系统");
            System.out.println("""
                                你当前可以
                                [退出登录]
                                [查看钱包]
                                [幸运数字]
                                [日期]
                                [挖矿](慎入，基本负收益)
                                """);
            //获取操作
            String choose = sc.next();
            //过登录检测，进主系统
            switch (choose){
                case "退出登录":
                    System.out.println("已退出登录");
                    choose(null,user,money,number,Username,PassWorld, userLoginNumber,luckNumber,GPUNumber,userGPU,GPUUser);
                    break;
                case "查看钱包":
                    //获取回传的布尔值
                    boolean go = Money.money(name,user,money,number);
                    //决定是否递归
                    if (go){Money.money(name,user,money,number);}
                    break;
                case "幸运数字":
                    luckyNumber();
                    break;
                case "日期":
                    time();
                    break;
                case "挖矿":
                    WK.wk(GPUNumber,userGPU,number,name,GPUUser,money);
                    break;
                default:
                    //异常处理
                    System.out.println("error1:未知操作！");
                    //懒得写递归，反正他自己也会在跑一遍的
                    break;
            }
        }
    }
    //时间
    public static void time() {
        Date d = new Date();
        //获取当前时间
        System.out.println("当前时间是");
        System.out.println(d);
    }
    //幸运数字
    public static void luckyNumber(){
        Random r = new Random();
        //随机幸运数字
        int luckNumber = r.nextInt(0,101);
        System.out.println("你今天的幸运数字是：" + luckNumber);
    }
}
