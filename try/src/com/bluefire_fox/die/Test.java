package com.bluefire_fox.die;

import java.util.Random;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {

        int[] codes = new int[5];

        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < codes.length; i++) {
            System.out.println("NO." + (i + 1 ));
            int code = sc.nextInt();
            codes[i] = code;
        }

        Random r = new Random();
        for (int i = 0; i < codes.length; i++) {
            int number = r.nextInt(5);
            int temp = codes[number];
            codes[number] = codes[i];
            codes[i] = temp;
        }

        for (int i = 0; i < codes.length; i++) {
            System.out.print(codes[i] + " ");
        }
    }
}
