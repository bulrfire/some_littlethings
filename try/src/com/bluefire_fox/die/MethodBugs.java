package com.bluefire_fox.die;

public class MethodBugs {
    public static void a(){
        b();
    }

    public static void b(){
        a();
    }

    public static void main(String[] args) {
        a();
    }
}
