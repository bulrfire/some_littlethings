package com.bulefire_fox.Test;

import java.util.Scanner;

public class LongIn {
    //登录
    public static void login(String[] Username,String[] PassWorld,String[] user,double[] money, int number,int userLoginNumber,boolean[] luckyNumber, int[] GPUNumber, String[] userGPU,String[] GPUUser){
        Scanner sc = new Scanner(System.in);
        //获取用户名和密码
        System.out.println("用户名");
        String UserName = sc.next();
        System.out.println("密码");
        String passWorld = sc.next();
        //在Username中寻找用户
        for (int i = 0; i < Username.length; i++) {
            //寻找成功
            if(UserName.equals(Username[i])){
                //判断密码
                if(passWorld.equals(PassWorld[i])){
                    //正确
                    System.out.println("欢迎 " + Username[i]);
                    number = i;
                    //返回主方法（递归
                    WebSystem.choose(Username[i],user,money,number,Username,PassWorld,
                            userLoginNumber,luckyNumber,GPUNumber,userGPU,GPUUser);
                }
                //错误
                else{
                    failToLongin(Username, PassWorld, user, money, number, userLoginNumber, luckyNumber, GPUNumber, userGPU, GPUUser, sc);
                }
                //退出
                return;
            }
        }
        //寻找失败
        failToLongin(Username, PassWorld, user, money, number, userLoginNumber, luckyNumber, GPUNumber, userGPU, GPUUser, sc);
        return;
    }
    //重登录或注册（IDEA自动提的
    public static void failToLongin(String[] Username, String[] PassWorld, String[] user, double[] money, int number, int userLoginNumber, boolean[] luckyNumber, int[] GPUNumber, String[] userGPU, String[] GPUUser, Scanner sc) {
        System.out.println("密码或用户名错误");
        System.out.println("请重新[登录]或[注册]");
        String choose = sc.next();
        if (choose.equals("登录")){
            System.out.println("正在重新登录");
            login(Username, PassWorld, user, money, number,
                    userLoginNumber,luckyNumber,GPUNumber,userGPU,GPUUser);
        }else if (choose.equals("注册")){
            System.out.println("正在前往注册");
            login(Username, PassWorld, user, money, number,
                    userLoginNumber, luckyNumber, GPUNumber, userGPU, GPUUser, 0);
        }
    }

    //注册
    public static void login(String[] Username,String[] PassWorld,String[] user, double[] money,int number,
                             int userLoginNumber,boolean[] luckNumber, int[] GPUNumber,String[] userGPU,String[] GPUUser,int a){
        Scanner sc = new Scanner(System.in);
        //获取用户名和密码
        System.out.println("用户名");
        String UserName = sc.next();
        System.out.println("密码");
        String passWorld = sc.next();
        //判断用户名是否为空
        if (UserName.equals("")){
            System.out.println("用户名或密码不能为空！\n请重新输入");
            //退出
            login(Username,PassWorld,user,money,number,userLoginNumber,luckNumber,GPUNumber,userGPU,GPUUser,0);
        }
        //判断密码是否为空
        if (passWorld.equals("")) {
            System.out.println("用户名或密码不能为空！\n请重新输入");
            //退出
            login(Username, PassWorld, user, money, number, userLoginNumber, luckNumber, GPUNumber, userGPU, GPUUser, 0);
        }
        //检查通过
        //录入用户名和密码
        Username[userLoginNumber] = UserName;
        PassWorld[userLoginNumber] = passWorld;
        System.out.println("录入成功");
        userLoginNumber++;
        System.out.println("请再次登录");
        //返回登录
        login(Username,PassWorld,user, money,number,userLoginNumber,luckNumber,GPUNumber,userGPU,GPUUser);
    }
}
