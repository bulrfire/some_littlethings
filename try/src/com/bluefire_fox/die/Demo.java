package com.bluefire_fox.die;

import java.util.Timer;

public class Demo {
    public static void main(String[] args) {
        Timer t = new Timer();
        System.out.println("1");
        int[]a=new int[20];

        for(int i=1;i<=20;i++){

            a[i-1]=i;

            try{
                Thread.sleep(1000);
            }catch(Exception e){}

            System.out.println(a[i-1]);

        }
        System.out.println("2");
    }
}
