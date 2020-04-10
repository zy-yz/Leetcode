package com.zy.leet.jdk;

/**
 * @ClassName StackAndHeap
 * @Description TODO
 * @Author peppers
 * @Date 2020/4/9
 * @Version 1.0
 **/
public class StackAndHeap {

    public static final int initData = 666;
    public static User user = new User();

    public int compute(){ //一个方法对应一块栈帧内存区域
        int a = 1;
        int b = 2;
        int c = (a + b)*10;
        return c;
    }

    public static void main(String[] args) {
        StackAndHeap math = new StackAndHeap();
        math.compute();
        System.out.println("test");
    }
}
