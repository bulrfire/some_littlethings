package com.bulefire_fox.importfile;

import java.util.Scanner;

public class ZT {
    public void main(String[] args) {
        What_ZT_is();
    }

    public void What_ZT_is(){
        go = true;
        ZT_is_bot a = new ZT_is_bot();
        a.start();
        ZT_is_people b = new ZT_is_people();
        b.start();
        change_go c = new change_go();
        c.start();
        while (go) {
            System.out.println("people" + ZT_is_people);
            System.out.println("bot" + ZT_is_bot);
        }
    }
    private volatile boolean go;
    private volatile int ZT_is_bot;
    private volatile int ZT_is_people;

    public class ZT_is_people extends Thread{
        public void run() {
            ZT_is_people++;
        }
    }

    public class ZT_is_bot extends Thread{
        public void run() {
            ZT_is_bot++;
        }
    }

    public class change_go extends Thread{
        public void run() {
            Scanner sc = new Scanner(System.in);
            go = true;
            while (go){
                int a = sc.nextInt();
                if (a == 0){
                    go = false;
                }
            }
        }
    }
}
