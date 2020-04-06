package com.zy.leet.jdk;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName HashMapTest
 * @Description TODO
 * @Author peppers
 * @Date 2020/4/6
 * @Version 1.0
 **/
public class HashMapTest {
    public static void main(String[] args) {

        Map HashMapTest = new HashMap();
        Map HashMapTest3 = new HashMap(10);
        Map HashMapTest4 = new HashMap(10, (float) 0.75);
        HashMapTest.put("1",1);
        HashMapTest.put("2",2);

        System.out.println(HashMapTest.get("1"));

        Map HashMapTest1 = new HashMap(HashMapTest);
        System.out.println(HashMapTest1.get("1"));
        System.out.println(HashMapTest1.get("2"));

        int f=1,i=2;
        while (i++<5){
            f*=i;
            System.out.println(f);
        }
    }

}
