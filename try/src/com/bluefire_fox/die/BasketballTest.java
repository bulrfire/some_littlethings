package com.bluefire_fox.die;

import java.util.Random;
import java.util.Scanner;

public class BasketballTest {
    public static void main(String[] args) {
        Random r = new Random();
        Scanner sc = new Scanner(System.in);

        while (true){
            int number = r.nextInt(0,101);
            if (number >= 50) {
                System.out.println("yes");
            }
            else {
                System.out.println("no");
            }
            sc.nextInt();
        }
    }
}