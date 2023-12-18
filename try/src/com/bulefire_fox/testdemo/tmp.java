package com.bulefire_fox.testdemo;

import com.bulefire_fox.api.RealRandom;

public class tmp {
    public static void main(String[] args) {
        RealRandom rr = new RealRandom();
        for (int i = 0; i < 50; i++) {
            System.out.println(rr.nextInt(10,30));
        }
    }
}
