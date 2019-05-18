package com.tsu.zqy.HashMap;

/**
 * @ClassName HashMapTest
 * @Author Elv1s
 * @Date 2019/5/17 17:03
 * @Description:
 */
public class HashMapTest {

    public static void main(String[] args) {
        MyHashMap<Integer, String> map = new MyHashMap<>();
        for (int i = 0; i < 100; i++) {
            map.put(i, String.valueOf(Math.random()));
        }
        System.out.println(map.get(99));

        System.out.println(map.put(101, "你好啊"));

    }
}
