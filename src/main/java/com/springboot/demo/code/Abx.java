package com.springboot.demo.code;


import java.util.HashMap;

public class Abx {

    public static void main(String[] args) {
        HashMap map = new HashMap();
//        for (int i = 0; i < 64; i++)
//            map.put(i, i);
//        map.put(2, 2);
        Object x = "2";
        Object y = 50;
        map.put(x, 1);
        map.put(y, 2);
        map.put(23, 2);

        map.put(x, 3);

        map.get(3);
    }
}
