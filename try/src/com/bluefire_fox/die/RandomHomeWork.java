package com.bluefire_fox.die;

import java.util.Random;

public class RandomHomeWork {
    public static void main(String[] args) {
        Random r = new Random();
        int is3 = 0;
        float jiLu;
        for (int i = 1; i <= 160; i++) {
            int number = r.nextInt(1,11);
            if (number % 3 == 0){
                is3++;
            }

            if (i == 20 || i == 40 || i == 60 || i == 80 || i == 100 || i == 120 || i == 140 || i == 160){
                jiLu = (float) is3 / i;
                System.out.println("第 " + i +" 次:");
                System.out.println(is3);
                System.out.println(jiLu);
                System.out.println();
            }
        }
    }
}

