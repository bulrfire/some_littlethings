package com.problem.week01;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class Week01_this {
    private ArrayList<String> list;

    public Week01_this() {
        this(10);
    }

//    public Week01_this(int size){
//        ArrayList<String> list = new ArrayList<String>(size);
//        for (int i = 0; i < size; i++) {
//            list.add("0");
//        }
//        this(list); //'this()' 调用必须是构造函数主体中的第一条语句
//    }

    public Week01_this(int size) {
        this(initializeList(size));
    }

    private static @NotNull ArrayList<String> initializeList(int size){
        ArrayList<String> list = new ArrayList<String>(size);
        for (int i = 0; i < size; i++) {
            list.add("0");
        }
        return list;
    }

    public Week01_this(ArrayList<String> list) {
        this.list = list;
    }
}
