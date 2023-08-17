package com.bluefire_fox.die;

import java.util.Scanner;

public class NumberTest {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("start number");
        int a = sc.nextInt();
        System.out.println("end number");
        int b = sc.nextInt();

        if (a >= b){
            System.out.println("no");
        }

        while (a < b){
            if (a%2==1){
                System.out.println(a);
            }
            a += 1;
        }
    }
}
