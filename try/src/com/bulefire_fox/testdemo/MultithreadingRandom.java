package com.bulefire_fox.testdemo;

import java.util.Scanner;

public class MultithreadingRandom {
    /**
     * 核心原理：
     * 利用CPU线程调度的不确定性充当随机数
     * Java中线程调度的行为受到以下几个因素的影响：
     * CPU核心数量
     * CPU时间片
     * CPU负载
     * CPU缓存
     * CPU调度策略
     * 以及操作系统的调度策略
     * 需要注意的是，CPU中的这些因素是由操作系统和硬件共同决定的，Java程序无法直接控制这些因素。实际的调度仍然由操作系统和硬件决定。
     * 所以，线程调度是非确定性的，即无法预测线程在某个时间点上的具体执行顺序。因此，我们可以利用这一点来编写随机数
     * 执行流程和原理：
     * 利用比大小来生成随机数
     * 通过同时创建两个线程使得他们互相干扰
     * 再让主线程每次将主随机变量+1
     * 通过tmp线程对ZT线程的干扰和抢占资源
     * 这样每次返回的a值就是一个再一定范围内随机的值
     * 具体范围和执行时间有关
     * 将返回的多个a值存储再number数组中
     * 找出最大值
     * 然后返回最大值的索引
     * 及生成了随机数
     */
    //定义循环标识
    static volatile boolean go = true;
    //主随机变量
    static volatile int a = 0;
    //副随机变量
    static volatile int b = 0;
    //主方法
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //获取随机数范围
        int times = sc.nextInt();
        //创建动态数组
        int[] number = new int[times];
        //循环
        for (int i = 0;i < times;i++) {
            //更矮标识符为true
            go = true;
            //
            start();
            //等待子线程执行
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //结束子线程执行
            go = false;
            //记录数值
            number[i] = a;
            //初始化主变量a
            a = 0;
        }
        findMax(number);
    }
    //找最大值(生成随机数
    public static void findMax(int[] number){
        int max = number[0];//最大

        //遍历找数据
        for (int i = 0; i < number.length; i++) {
            //最大
            if (number[i] > max){
                max = number[i];
            }
        }
        //寻找i值输出为随机数
        for (int i = 0; i < number.length; i++) {
            if (max == number[i]){
                System.out.println(i);
            }
        }
    }
    //启动线程
    public static void start(){
        ZT zt = new ZT();
        tmp t = new tmp();
        zt.start();
        t.start();
    }
    //主随机数线程
    public static class ZT extends Thread{
        public void run() {
            while(go){
                a++;
            }
        }
    }
    //干扰主随机数线程的线程
    public static class tmp extends Thread{
        public void run(){
            while(go){
                b++;
            }
        }
    }
}
