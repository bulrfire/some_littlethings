package com.bulefire_fox.needpassworld;

import com.bulefire_fox.testdemo.tmp;

import java.util.Random;

public class PassWorldEncrypt {
    public static String Encrypt(PassWorldMemory passWorldMemory){
        switch (passWorldMemory.getEncryption()) {
            case "v1":
                return EncryptV1(passWorldMemory.getPassWorld());
        }
        return null;
    }


    private static String EncryptV1(String passWorld){
        //内部密码整合
        String[] tmpS = new String[passWorld.length()];
        //随机加密密钥
        Random r = new Random();
        int EncryptCode = r.nextInt(-2000,2000);
        //头文件
        //输出字符串
        String outPassWorld = EncryptCode + "|";
        //字符依次加密
        char[] pass = passWorld.toCharArray();
        for (int i = 0; i < pass.length; i++) {
            //加密操作
            int tmp = pass[i] + EncryptCode;
            tmpS[i] = tmp + "|";
        }
        //固定密钥
        /**
            1 -> 5
            2 -> 4
            3 -> 9
            4 -> 0
            5 -> 2
            6 -> 8
            7 -> 6
            8 -> 1
            9 -> 3
            0 -> 7
         */
        for (int i = 0; i < tmpS.length; i++) {
            String tmp = tmpS[i];
            tmp = tmp.substring(0,tmp.length()-1);
            System.out.println("tmp" + tmp);
            char[] ctmp = tmp.toCharArray();
            for (int i1 = 0; i1 < ctmp.length; i1++) {
                System.out.println("1" + ctmp[i1]);
                switch (ctmp[i1]){
                    case '0':
                        ctmp[i1] = 7;
                        break;

                    case '1':
                        ctmp[i1] = 5;
                        break;

                    case '2':
                        ctmp[i1] = 4;
                        break;

                    case '3':
                        ctmp[i1] = 9;
                        break;

                    case '4':
                        ctmp[i1] = 0;
                        break;

                    case '5':
                        ctmp[i1] = 2;
                        break;

                    case '6':
                        ctmp[i1] = 8;
                        break;

                    case '7':
                        ctmp[i1] = 6;
                        break;

                    case '8':
                        ctmp[i1] = 1;
                        break;

                    case '9':
                        ctmp[i1] = 3;
                        break;

                }
                System.out.println("final" + ctmp[i1]);
            }
        }

        for (int i = 0; i < tmpS.length; i++) {
            outPassWorld += tmpS[i];
        }

        return outPassWorld;
    }
}
