package com.problem.week02;

public class Number{
    int number;

    @Override
    public boolean equals(Object o){
        //判断是否为同一个对象
        if (this == o)
            return true;
        //判断是否为同一类型
        if (o == null || getClass() != o.getClass())
            return false;
        // 判断
        Number number1 = (Number) o;
        return number == number1.number;
    }
}
