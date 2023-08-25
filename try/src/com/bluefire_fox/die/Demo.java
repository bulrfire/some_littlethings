package com.bluefire_fox.die;

import java.util.Random;

public class Demo {
    public static void main(String[] args) {
        int length = 5; // 指定生成的汉字位数
        String randomChinese = generateRandomChinese(length);
        System.out.println(randomChinese);
    }

    public static String generateRandomChinese(int length) {
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            char c = (char) (0x4e00 + random.nextInt(0x9fa5 - 0x4e00 + 1));
            sb.append(c);
        }
        return sb.toString();
    }
}