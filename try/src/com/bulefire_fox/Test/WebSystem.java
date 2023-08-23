package com.bulefire_fox.Test;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Date;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class WebSystem {
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

    //登录
    public static void login(String[] Username,String[] PassWorld,String[] user,double[] money,
                             int number,int userLoginNumber,boolean[] luckyNumber,
                             int[] GPUNumber,String[] userGPU,String[] GPUUser){
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
                    //返回主方法（递归
                    choose(Username[i],user,money,number,Username,PassWorld,
                            userLoginNumber,luckyNumber,GPUNumber,userGPU,GPUUser);
                }
                //错误
                else{
                    System.out.println("密码或用户名错误");
                }
                //退出
                return;
            }
        }
        //寻找失败
        System.out.println("密码或用户名错误");
    }
    //注册
    public static void login(String[] Username,String[] PassWorld,String[] user,
                             double[] money,int number,int userLoginNumber,boolean[] luckNumber,
                             int[] GPUNumber,String[] userGPU,String[] GPUUser,int a){
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
        System.out.println("请再次登录");
        //返回登录
        login(Username,PassWorld,user, money,number,userLoginNumber,luckNumber,GPUNumber,userGPU,GPUUser);
    }
    //这个才是真正的主方法
    public static void choose(String name,String[] user,double[] money,int number,String[] Username,
                              String[] PassWorld,int userLoginNumber,boolean[] luckNumber,
                              int[] GPUNumber,String[] userGPU,String[] GPUUser){
        Scanner sc = new Scanner(System.in);
        //进死循环
        while (true) {
            //tips
            System.out.println("操作");
            //获取操作
            String choose = sc.next();
            //如果用户名为null及为登录，则只能注册和登录
            if (name == null){
                switch (choose) {
                    case "登录":
                        //登录
                        login(Username, PassWorld, user, money, number,
                                userLoginNumber, luckNumber, GPUNumber, userGPU, GPUUser);
                        break;
                    case "注册":
                        //注册
                        login(Username, PassWorld, user, money, number,
                                userLoginNumber, luckNumber, GPUNumber, userGPU, GPUUser, 0);
                        break;
                }
                //退出
                return;
            }
            //过登录检测，进主系统
            switch (choose){
                case "退出登录":
                    System.out.println("已退出登录");
                    return;
                case "查看钱包":
                    //获取回传的布尔值
                    boolean go = money(name,user,money,number);
                    //决定是否递归
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
    //挖矿主方法
    private static void wk(int[] GPUNumber,String[] userGPU,int number,String name,String[] GPUUser,double[] money) {
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
                            GPUIn(NvidiaGPU,NvidiaGPUMoney,money[number],userGPU,number,GPUNumber);
                            //递归
                            wk(GPUNumber,userGPU,number,name,GPUUser,money);
                            break;
                        case "n":
                            //退出
                            System.out.println("以取消购买");
                            return;
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
        }
    }
    //购入GPU
    public static void GPUIn(String[] NvidiaGPU,double[] NvidiaGPUMoney,
                             double money,String[] userGPU,int number,int[] GPUNumber) {
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
                        if (money < NvidiaGPUMoney[i]){
                            //是
                            //tips
                            System.out.println("你的钱不够购买改显卡");
                            System.out.println("你当前的余额为" + money);
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
                            }
                        }
                        //总钱数大于显卡价格
                        else {
                            //tips
                            System.out.println("成功购买显卡: " + NvidiaGPU[i]);
                            //扣钱（不知为什，这里money显示NvidiaGPUMoney[i]的值分配给"money"是从未使用过
                            money -= NvidiaGPUMoney[i];
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
                }
            }
            //寻找失败
            else{
                //退出（敷衍一下
                return;
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
        //死循环
        while (true) {
            //等待一秒
            try {
                Thread.sleep(1000);
            } catch (Exception ignored) {
            }
            //总时间+1秒
            seconds += 1;
            //打印挖矿时间
            System.out.println("挖矿时间" + TimeConvert(seconds));
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
    }
    //生成哈希值
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
    //时间
    public static void time() {
        Date d = new Date();
        //获取当前时间
        System.out.println(d);
    }
    //钱包主方法
    public static boolean money(String name,String[] user,double[] money,int number){
        Scanner sc = new Scanner(System.in);
        //初始化递归为false
        boolean down = true;
        //寻找用户登录
        for (int i = 0; i < user.length; i++) {
            if(name.equals(user[i])){
                //成功
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
            System.out.println("操作");
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
        }
        //退出并取消递归（意义不明的保险代码
        return false;
    }
    //存钱
    public static void moneyIn(String name,double[] money,int inNumber){
        Scanner sc = new Scanner(System.in);
        System.out.println("存入钱数：");
        //获取存取钱数
        double inMoney = sc.nextDouble();
        //总钱数加上存款金额
        money[inNumber] += inMoney;
        System.out.println(name + " 成功存入 " + inMoney);
        System.out.println("操作");
        String choose = sc.next();
        //分支
        switch (choose){
            case "返回":
                //退出
                return;
            case "继续存钱":
                //递归
                moneyIn(name, money, inNumber);
        }
    }
    //取钱
    public static void moneyOut(String name,double[] money,int inNumber){
        Scanner sc = new Scanner(System.in);
        System.out.println("取出钱数");
        //获取取出钱数
        double outMoney = sc.nextDouble();
        //判断取钱金额是否超过总金额
        if (outMoney > money[inNumber]){
            //是，提示
            System.out.println("余额不足");
            String choose = sc.next();
            //分支
            switch (choose){
                case "重新选择金额":
                    //递归
                    moneyOut(name,money,inNumber);
                case "退出":
                    //退出
                    return;
            }
        }
        //否
        //总钱数减去取出钱数
        money[inNumber] -= outMoney;
        //tips
        System.out.println(name + " 成功取出 " + outMoney);
        System.out.println("操作");
        String choose = sc.next();
        //分支
        switch (choose){
            case "返回":
                //退出
                return;
            case "继续取钱":
                //递归
                moneyOut(name, money, inNumber);
        }
    }
    //幸运数字
    public static void luckyNumber(){
        Random r = new Random();
        //随机幸运数字
        int luckNumber = r.nextInt(0,101);
        System.out.println("你今天的幸运数字是：" + luckNumber);
    }
}
