package com.bluefire_fox.die;

import java.util.Random;

public class RandomNumber {

    public static void main(String[] args) {
        int[] number = new int[100];
        for (int i = 0; i < number.length; i++) {
            number[i] = RN();
        }
        System.out.print("[");
        for (int i = 0; i < number.length; i++) {
            System.out.print(i == number.length - 1 ? number[i]:number[i] + ", ");
        }
        System.out.println("]");
    }

    private static int RN() {
        Random r = new Random();
        return r.nextInt(0,10);
    }
}
