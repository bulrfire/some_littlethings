package com.bulefire_fox.Test;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Date;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

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
        int userLoginNumber = -1;
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
            if (name == null){
                switch (choose) {
                    case "登录":
                        login(Username, PassWorld, user, money, number,
                                userLoginNumber, luckNumber, GPUNumber, userGPU, GPUUser);
                        break;
                    case "注册":
                        login(Username, PassWorld, user, money, number,
                                userLoginNumber, luckNumber, GPUNumber, userGPU, GPUUser, 0);
                        break;
                }
                return;
            }
            switch (choose){
                case "退出登录":
                    System.out.println("已退出登录");
                    return;
                case "查看钱包":
                    boolean go = money(name,user,money,number);
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
                    wk(GPUNumber,userGPU,number,name,GPUUser,money);
                    break;
            }
        }
    }

    private static void wk(int[] GPUNumber,String[] userGPU,int number,String name,String[] GPUUser,double[] money) {
        String[] NvidiaGPU = {"690"};
        double[] NvidiaGPUMoney = {500};
        double[] NvidiaGPUComputingPower = {100};
        int a = 0;

        String[] NvidiaGPUSuper = {"2050s","2060s","2070s",
                "2080s","2090s","4060s","4070s","4080s","4090s"};

        double[] computingPower = {10};

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
                            number++;
                            GPUIn(NvidiaGPU,NvidiaGPUMoney,money[number]);
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
                    startWk(userGPU[number],NvidiaGPUAllW[a],NvidiaGPUComputingPower[a]);
                }
                else if (sc.next().equals("n")){
                    System.out.println("以退出矿场");
                    return;
                }
            }
        }
        System.out.println("用户不存在，是(y)/否(n)创建用户？");
        String choose = sc.next();
        switch (choose){
            case "y":
                number++;
                GPUUser[number] = name;
                GPUNumber[number] = 0;
                userGPU[number] = null;
                System.out.println("创建成功");
                wk(GPUNumber,userGPU,number,name,GPUUser,money);
                break;
            case "n":
                System.out.println("以取消创建");
                return;
        }
    }

    public static void GPUIn(String[] NvidiaGPU,double[] NvidiaGPUMoney,double money) {
        System.out.println("目前正在出售的显卡有");
        for (int i = 0; i < NvidiaGPU.length; i++) {
            System.out.print(i == NvidiaGPU.length - 1 ? NvidiaGPU[i]:NvidiaGPU[i] + ", ");
        }
        System.out.println("选择你想要的型号");
        Scanner sc = new Scanner(System.in);
        String inGPU = sc.next();
        for (int i = 0; i < NvidiaGPU.length; i++) {
            if (inGPU.equals(NvidiaGPU[i])){
                System.out.println("售价为"  + NvidiaGPUMoney[i]);
                System.out.println("是(y)/否(n)购买");
                String choose = sc.next();
                switch (choose){
                    case "y":
                        if (money < NvidiaGPUMoney[i]){
                            System.out.println("你的钱不够购买改显卡");
                            System.out.println("你当前的余额为" + money);
                            System.out.println("取消购买(y)或更换显卡型号(n)");
                            String chooseInGPU = sc.next();
                            switch (chooseInGPU){
                                case "y":
                                    System.out.println("以取消购买");
                                    return;
                                case "n":
                                    GPUIn(NvidiaGPU,NvidiaGPUMoney,money);
                                    break;
                            }
                        }
                    case "n":
                        System.out.println("以退出购买");
                        return;
                }
            }
            else{
                return;
            }
        }
    }

    public static void startWk(String userGPU,double NvidiaGPUAllW,double computingPower){
        double sumW = 0;
        double perWMoney = 0.5;
        double moneySumW;
        int perBiteMoney = 10;
        int biteNumber = 0;
        int biteMoney = 0;

        double money = 0;

        long seconds = 0;
        String hash = Hash();
        while (true) {
            try {
                Thread.sleep(1000);
            } catch (Exception ignored) {
            }

            seconds += 1;
            System.out.println("挖矿时间" + TimeConvert(seconds));

            sumW += 0.01;
            moneySumW = sumW * perWMoney;
            money -= moneySumW;
            System.out.println("收益:" + money);

            if (hash == null){
                System.out.println("error405:矿池连接失败");
                return;
            }

            WebSystem.input thread = new WebSystem.input();
            thread.setPriority(Thread.MAX_PRIORITY); // 设置线程的优先级为最高
            thread.start();

            String InHash = Hash();
            if (InHash == null){
                System.out.println("内核加载失败");
                return;
            }
            boolean ifWk = ifHash(hash,InHash);
            if (ifWk){
                biteNumber += 1;
                biteMoney += perBiteMoney;
                money += perBiteMoney;
            }
            System.out.println("比特币数量" + biteNumber);
        }
    }

    public static class input extends Thread{
        Scanner sc = new Scanner(System.in);
        public void run() {
            int inputNumber = sc.nextInt();
            if (inputNumber == 0) {
                System.out.println("输入为0，退出挖矿");
                System.exit(0);
            }
        }
    }

    public static String TimeConvert(long seconds) {
        long hours = TimeUnit.SECONDS.toHours(seconds);
        long minutes = TimeUnit.SECONDS.toMinutes(seconds - TimeUnit.HOURS.toSeconds(hours));
        long remainingSeconds = seconds - TimeUnit.HOURS.toSeconds(hours) - TimeUnit.MINUTES.toSeconds(minutes);
        String ConvertTime = hours + "时" + minutes + "分" + remainingSeconds + "秒";
        return ConvertTime;
    }

    public static String Hash(){
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
        return null;
    }

    public static boolean ifHash(String hash,String InHash){
        return hash.equals(InHash);
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
                    break;
                case "取钱":
                    for (int i = 0; i < user.length; i++) {
                        if (name.equals(user[i])){
                            moneyOut(name,money,i);
                            money(name,user,money,number);
                        }
                    }
                    break;
                case "返回":
                    return false;
            }
            return false;
        }
        System.out.println("用户不存在,是(yes)/否(no)创建用户？");
        String typename = sc.next();
        switch (typename){
            case "yes":
                number++;
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
