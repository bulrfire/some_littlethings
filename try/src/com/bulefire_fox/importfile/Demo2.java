package com.bulefire_fox.importfile;

import com.bulefire_fox.testdemo.ZT;

import java.util.Random;

public class Demo2 {
    public static void main(String[] args) {
        ZT.main(args);
    }

    public static class RandomAnyThing {
        public static void main(String[] args) {
            //目标：完成生成随机验证码
            System.out.println(creatCode(1000));
        }

        public static String creatCode(int number){
            Random r = new Random();
            //3.定义一个String类型的变量用于记住产生的每位随机字符
            String code = "";
            //定义一个for循环用于控制生成多少位随机字符
            for (int i = 1; i <= number; i++) {
                //2.为每个位置生成一个随机字符：可能数字，大小写字符
                //思路，随机一个0，1，2之间的数字，0代表随机一个数字字符1，2随机大写或小写字母
                int type = r.nextInt(4);//0,1,2
                switch (type) {
                    case 0:
                        //随机一个数字字符
                        code += r.nextInt(10);//0 ~ 9
                        break;
                    case 1:
                        //随机一个大写字符
                        //A = 65 Z = 65 + 25 (0 - 25) + 65
                        char ch1 = (char) (r.nextInt(26) + 65);
                        code += ch1;
                        break;
                    case 2:
                        //随机一个小写字符
                        //a = 97 z = 97 + 25 (0 - 25) + 97
                        char ch2 = (char) (r.nextInt(26) + 97);
                        code += ch2;
                        break;
                    case 3:
                        //随机生成汉字
                        StringBuilder sb = new StringBuilder();
                        Random random = new Random();
                        char c = (char) (0x4e00 + random.nextInt(0x9fa5 - 0x4e00 + 1));
                        sb.append(c);
                        code += sb;
                }
            }
            return code;
        }
    }
}