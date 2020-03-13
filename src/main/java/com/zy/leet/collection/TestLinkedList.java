package com.zy.leet.collection;

import java.util.LinkedList;
import java.util.List;

public class TestLinkedList {

     volatile static int s = 4;
    public static void main(String[] args) {

        List<String> linkedList = new LinkedList<>();
        linkedList.add("3");
        System.out.println(linkedList.get(0));

        //s=0;
        System.out.println(s);



    }
}
