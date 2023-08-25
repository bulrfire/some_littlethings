package com.bulefire_fox.Test;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class WK {
    //挖矿主方法
    static void wk(int[] GPUNumber, String[] userGPU, int number, String name, String[] GPUUser, double[] money) {
        //GPU型号
        String[] NvidiaGPU = {"690"};
        //GPU价格
        double[] NvidiaGPUMoney = {500};
        //GPU算力
        double[] NvidiaGPUComputingPower = {100};
        //只是为了有个索引，后面会改，预计2099年改
        int a = 0;
        //superGPU型号
        String[] NvidiaGPUSuper = {"2050s","2060s","2070s",
                "2080s","2090s","4060s","4070s","4080s","4090s"};
        //GPU算力（重了？
        double[] computingPower = {10};
        //功耗
        double[] NvidiaGPUAllW = {100};

        Scanner sc = new Scanner(System.in);
        //寻找用户
        for (int i = 0; i < GPUUser.length; i++) {
            if (name.equals(GPUUser[i])){
                //成功
                System.out.println("欢迎进入挖矿系统");
                System.out.println("用户" + GPUUser[i]);
                //判断是否拥有显卡
                if (userGPU[number] == null){
                    //否
                    System.out.println("你还没有显卡");
                    System.out.println("是(y)/(n)否购买");
                    String choose = sc.next();
                    //是否购买
                    switch (choose){
                        case "y":
                            System.out.println("正在前往购买显卡");
                            //进分支买显卡
                            GPUIn(NvidiaGPU,NvidiaGPUMoney,money,userGPU,number,GPUNumber);
                            //递归
                            wk(GPUNumber,userGPU,number,name,GPUUser,money);
                            break;
                        case "n":
                            //退出
                            System.out.println("以取消购买");
                            return;
                        default:
                            System.out.println("error1:未知操作！");
                            break;
                    }
                    //意义不明的保险代码
                    return;
                }
                //是
                System.out.println("拥有" + GPUNumber[number] + "张" + userGPU[number] + "显卡");
                System.out.println("是(y)/否(n)开始");
                //选择是否开始挖矿（为啥我要用if？？？？？？？？？？
                if (sc.next().equals("y")) {
                    //是
                    //进分支开始挖矿
                    startWk(userGPU[number],NvidiaGPUAllW[a],NvidiaGPUComputingPower[a],money,number);
                    return;
                }
                else if (sc.next().equals("n")){
                    //否
                    //退出
                    System.out.println("以退出矿场");
                    return;
                }
            }
        }
        //寻找失败
        //注册账户
        System.out.println("用户不存在，是(y)/否(n)创建用户？");
        String choose = sc.next();
        //选择是否创建
        switch (choose){
            case "y":
                //是
                //用当前用户名注册账号
                GPUUser[number] = name;
                //初始化GPU数量为0
                GPUNumber[number] = 0;
                //初始化无GPU
                userGPU[number] = null;
                System.out.println("创建成功");
                //递归
                wk(GPUNumber,userGPU,number,name,GPUUser,money);
                break;
            case "n":
                //退出
                System.out.println("以取消创建");
                //意义不明的保险代码
                return;
            default:
                System.out.println("error1:未知操作！");
                break;
        }
    }
    //购入GPU
    public static void GPUIn(String[] NvidiaGPU,double[] NvidiaGPUMoney, double[] money,String[] userGPU,int number,int[] GPUNumber) {
        System.out.println("目前正在出售的显卡有");
        //打印显卡列表
        for (int i = 0; i < NvidiaGPU.length; i++) {
            //打印格式
            System.out.print(i == NvidiaGPU.length - 1 ? NvidiaGPU[i]:NvidiaGPU[i] + ", ");
        }
        System.out.println("\n" + "选择你想要的型号");
        Scanner sc = new Scanner(System.in);
        //获取用户选择
        String inGPU = sc.next();
        //在GPU列表中寻找用户选择的GPU
        for (int i = 0; i < NvidiaGPU.length; i++) {
            if (inGPU.equals(NvidiaGPU[i])){
                //寻找成功
                System.out.println("售价为"  + NvidiaGPUMoney[i]);
                System.out.println("是(y)/否(n)购买");
                String choose = sc.next();
                //分支选择是否购买
                switch (choose){
                    //是
                    case "y":
                        //判断总钱数是否少于显卡价格
                        if (money[number] < NvidiaGPUMoney[i]){
                            //是
                            //tips
                            System.out.println("你的钱不够购买改显卡");
                            System.out.println("你当前的余额为" + money[number]);
                            System.out.println("取消购买(y)或更换显卡型号(n)");
                            String chooseInGPU = sc.next();
                            //分支取消购买或换
                            switch (chooseInGPU){
                                case "y":
                                    //取消
                                    //退出
                                    System.out.println("以取消购买");
                                    return;
                                case "n":
                                    //递归
                                    GPUIn(NvidiaGPU,NvidiaGPUMoney,money,userGPU,number,GPUNumber);
                                    break;
                                default:
                                    //异常处理
                                    System.out.println("error1:未知操作！");
                                    //递归
                                    GPUIn(NvidiaGPU,NvidiaGPUMoney,money,userGPU,number,GPUNumber);
                                    break;
                            }
                        }
                        //总钱数大于显卡价格
                        else {
                            //tips
                            System.out.println("成功购买显卡: " + NvidiaGPU[i]);
                            //扣钱
                            money[number] -= NvidiaGPUMoney[i];
                            //录入GPU
                            userGPU[number] = NvidiaGPU[i];
                            //GPU数量加一
                            GPUNumber[number] += 1;
                            //退出
                            System.out.println("以返回");
                            return;
                        }
                        //否
                    case "n":
                        //退出
                        System.out.println("以退出购买");
                        return;
                    default:
                        //异常处理
                        System.out.println("error1:未知操作！");
                        //递归
                        GPUIn(NvidiaGPU,NvidiaGPUMoney,money,userGPU,number,GPUNumber);
                        break;
                }
            }
            //寻找失败
            else{
                //退出（敷衍一下
                System.out.println("error35:显卡型号错误，无法购买");
                return;
            }
        }
    }
    //定义共享变量
    private static volatile boolean go = true;
    //定义新的线程获取用户输入用于修改go为false
    public static class  changeGo extends Thread {
        public void run() {
            Scanner sc = new Scanner(System.in);
            //由go控制的死循环
            while (go) {
                //获取输入
                int choose = sc.nextInt();
                //判断是否退出
                if (choose == 0){
                    //修改go
                    go = false;
                }
            }
        }
    }
    //开始挖矿
    public static void startWk(String userGPU, double NvidiaGPUAllW, double computingPower,double[] money,int number) {
        //初始化总瓦数
        double sumW = 0;
        //初始化每瓦价格
        double perWMoney = 0.5;
        //初始化电费
        double moneySumW;
        //初始化比特币市值
        int perBiteMoney = 10;
        //初始化比特币数量
        int biteNumber = 0;
        //比特币总价值（这里又显示'biteMoney' 已被赋值，但从未访问，但我下面明明改变赋值了
        int biteMoney = 0;
        //定义局部钱数
        double InMoney = 0;
        //初始化总时间
        long seconds = 0;
        //获取随机哈希值
        String hash = Hash();
        System.out.println("进入矿场");
        //意义不明的等待（模拟
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("加载内核......");
        //意义不明的等待（模拟
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("加载内核成功！");
        System.out.println("开始挖矿");
        System.out.println("输入0退出挖矿");
        //意义不明的等待（模拟
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //启动线程changeGo
        changeGo changeGo = new changeGo();
        changeGo.start();
        //死循环,使用共享变量go判断是否执行循环
        while (go) {
            //等待一秒
            try {
                Thread.sleep(1000);
            } catch (Exception ignored) {
            }
            //总时间+1秒
            seconds += 1;
            //打印挖矿时间
            System.out.println("挖矿总时间" + TimeConvert(seconds));
            //总瓦数+0.01
            sumW += 0.01;
            //计算电费
            moneySumW = sumW * perWMoney;
            //扣钱
            InMoney -= moneySumW;
            //打印收益
            System.out.println("收益:" + InMoney);
            //判断获取的哈希值是否为空（出现异常
            if (hash == null) {
                //tips
                System.out.println("error405:矿池连接失败");
                //退出
                return;
            }
            //获取计算的随机哈希值
            String InHash = Hash();
            //判断获取的哈希值是否为空
            if (InHash == null) {
                //tips
                System.out.println("内核加载失败");
                //退出
                return;
            }
            //判断哈希值是否吻合并返回判断
            boolean ifWk = ifHash(hash, InHash);
            //如果吻合
            if (ifWk) {
                //加1比特币
                biteNumber += 1;
                //增加收益
                biteMoney += perBiteMoney;
                //增加收益
                InMoney += perBiteMoney;
            }
            //打印比特币数量
            System.out.println("比特币数量" + biteNumber);
            //计算总钱数
            money[number] += InMoney;
        }
        System.out.println("以结束挖矿");
        //初始化go
        go = true;
    }
    //生成哈希值
    public static String Hash(){
        //抄AI的
        try {
            // 创建 MessageDigest 对象，指定使用 SHA-256 算法
            MessageDigest digest = MessageDigest.getInstance("SHA-256");

            // 创建 SecureRandom 对象
            SecureRandom secureRandom = new SecureRandom();

            // 生成随机数的字节数组
            byte[] randomBytes = new byte[32];
            secureRandom.nextBytes(randomBytes);

            // 进行哈希计算
            byte[] byteHash = digest.digest(randomBytes);

            // 将字节数组转换为十六进制字符串
            StringBuilder hexString = new StringBuilder();
            for (byte b : byteHash) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) {
                    hexString.append('0');
                }
                hexString.append(hex);
            }

            String hash = hexString.toString();
            return hash;
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        //返回报错
        return null;
    }
    //判断哈希值是否相同
    public static boolean ifHash(String hash,String InHash){
        //返回是否相同
        return hash.equals(InHash);
    }
    //时间转换
    public static String TimeConvert(long seconds) {
        //不知道什么意思
        //抄AI的
        //时
        long hours = TimeUnit.SECONDS.toHours(seconds);
        //分
        long minutes = TimeUnit.SECONDS.toMinutes(seconds - TimeUnit.HOURS.toSeconds(hours));
        //秒
        long remainingSeconds = seconds - TimeUnit.HOURS.toSeconds(hours) - TimeUnit.MINUTES.toSeconds(minutes);
        //串起来
        String ConvertTime = hours + "时" + minutes + "分" + remainingSeconds + "秒";
        //返回
        return ConvertTime;
    }
}
