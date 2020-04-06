package com.zy.leet.jdk;

import java.util.LinkedList;
import java.util.List;

/**
 * @ClassName LinkedListTest
 * @Description TODO
 * @Author peppers
 * @Date 2020/4/6
 * @Version 1.0
 **/
public class LinkedListTest {

    public static void main(String[] args) {
        List linkListTest = new LinkedList();
        linkListTest.add("5");
        linkListTest.add("5");
        linkListTest.lastIndexOf("5");
        linkListTest.remove("5");
        System.out.println(linkListTest.get(0));
    }
}
