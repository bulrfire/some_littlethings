package com.bulefire_fox.api;

public class draw {
    public static void main(String[] args) {
        numberPrint(12,2,false,0);
    }
    //打印主函数
    public static void numberPrint(int number,int printNumber,boolean if0,int noneNumber){
        int none = noneNumber;

        //拆分
        int[] numberSlip = slip(number);

        //循环
        for (int i = 0;i < numberSlip.length;i++) {
            //获取每一位画法
            int[] draw = number_how(numberSlip[i]);
            //绘画
            for (int j = 0; j < draw.length; j++) {
                if (draw[j] == 1) {
                    //打印
                    System.out.print(printNumber);
                } else if (draw[j] == 0) {
                    //打印
                    if (if0) {
                        System.out.print(none);
                    }
                    else if (!if0){
                        System.out.print(' ');
                    }
                } else if (draw[j] == 2) {
                    //打印
                    System.out.print('\n');
                }
                else{
                    System.out.println("error:0 拆分报错");
                }
            }
        }
    }

    public static int[] number_how(int number){
        //报错列表
        int[] error = new int[0];

        //字符画模板
        int[] one = {0,0,0,0,0,1,1,0,0,0,0,0,2,
                     0,0,0,0,1,0,1,0,0,0,0,0,2,
                     0,0,0,1,0,0,1,0,0,0,0,0,2,
                     0,0,0,0,0,0,1,0,0,0,0,0,2,
                     0,0,0,0,0,0,1,0,0,0,0,0,2,
                     0,0,0,0,0,0,1,0,0,0,0,0,2,
                     0,0,1,1,1,1,1,1,1,1,0,0,2,
                     0,0,0,0,0,0,0,0,0,0,0,0,2};

        int[] two = {0,0,0,0,0,0,0,0,0,0,0,0,2,
                     0,0,0,0,1,1,1,1,0,0,0,0,2,
                     0,0,0,1,0,0,0,0,1,0,0,0,2,
                     0,0,0,1,0,0,0,0,1,0,0,0,2,
                     0,0,0,0,0,0,0,1,0,0,0,0,2,
                     0,0,0,0,0,0,1,0,0,0,0,0,2,
                     0,1,1,1,1,1,1,1,1,1,1,0,2,
                     0,0,0,0,0,0,0,0,0,0,0,0,2};
        int[] three = {0,0,0,0,0,0,0,0,0,0,0,0,2,
                       0,0,0,0,0,0,0,0,0,0,0,0,2,
                    };
        int[] four = {};
        int[] five = {};
        int[] six = {};
        int[] seven = {};
        int[] eight = {};
        int[] nine = {};
        int[] zero = {};


        switch (number){
            case 1:
                return one;

            case 2:
                return two;

            case 3:
                return three;

            case 4:
                return four;

            case 5:
                return five;

            case 6:
                return six;

            case 7:
                return seven;

            case 8:
                return eight;

            case 9:
                return nine;

            case 0:
                return zero;

        }

        return error;
    }
    //拆分整数
    public static int[] slip(int number){
        //获取位数
        String numberNumber = String.valueOf(number);
        int digitCount = numberNumber.length();
        //储存
        int[] numbers = new int[digitCount];
        //拆分
        String numberString = String.valueOf(number);
        for (int i = 0; i < numberString.length(); i++) {
            char digitChar = numberString.charAt(i);
            int digit = Character.getNumericValue(digitChar);
            numbers[i] = digit;
        }

        return numbers;
    }
}
