package com.bluefire_fox.die;

import java.util.Random;
import java.util.Scanner;

public class ElevatorTest {
    public static void main(String[] args) {
        Random r = new Random();
        Scanner sc = new Scanner(System.in);
        int floor = 1;
        System.out.println(floor);
        while (true) {
            int need = sc.nextInt();

            if(floor < need){
                System.out.println(floor);
                while(floor < need){
                    floor++;
                    System.out.println(floor);
                }
            }
            else if(floor > need){
                System.out.println(floor);
                while (floor > need){
                    floor = floor - 1;
                    System.out.println(floor);
                }
            }
            else{
                System.out.println(floor);
            }
        }
    }
}