package com.example.concurrency.HashMapEEEE;

import java.util.HashMap;

public class HashMapTest {
    public static void main(String[] args) {
        HashMap hashMap = new HashMap();
        hashMap.put("a", 1);
        hashMap.put("b", 2);
        hashMap.put(null, 3);


        System.out.println(hashMap.get(null));
        System.out.println("a".hashCode());
        System.out.println("null".hashCode());
    }

}
