package com.bluefire_fox.die;

import java.util.Random;
import java.util.Scanner;

public class MusicRandom {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] music = {1,2,3,4,5,6,7,8,9,10};
        int[] no = new int[5];
        while (true) {
            int a = random(music);
            int number = 0;
            no[number] = a;
            number++;
            for (int i = 0; i < music.length; i++) {
                if(music[a] == no[i]){
                    break;
                }
            }
            System.out.println(music[a]);
        }
    }

    public static int random(int[] arr) {
        Random r = new Random();
        return r.nextInt();
    }
}
