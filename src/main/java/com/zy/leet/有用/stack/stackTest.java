package com.zy.leet.有用.stack;

import java.util.Stack;

public class stackTest {
    public static void main(String[] args) {
        Stack stack = new Stack();
        String s = "how are you";
        char[] ch = s.toCharArray();
        for (int i = 0;i<ch.length;i++){
            stack.push(ch[i]);
        }
       while (!stack.isEmpty()){
           System.out.println(stack.pop());
       }
    }
}
