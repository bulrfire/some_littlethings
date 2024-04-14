package com.bulefire_fox.needpassworld;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("pass world in");
        String passWorld = sc.next();
        String EncryptVersion = "v1";
        String[] otherCommand = new String[10];

        PassWorldMemory psm = new PassWorldMemory(passWorld,EncryptVersion);

        System.out.println(PassWorldEncrypt.Encrypt(psm));
    }
}
