package com.bluefire_fox.die;

public class MethodDemo {
    public static void a(){b();}

    public static void b(){c();}

    public static void c(){a();}

    public static void main(String[] args) {
        a();
    }
}