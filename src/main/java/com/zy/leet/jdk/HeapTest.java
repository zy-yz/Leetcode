package com.zy.leet.jdk;

import java.util.ArrayList;

/**
 * @ClassName HeapTest
 * @Description TODO
 * @Author peppers
 * @Date 2020/4/9
 * @Version 1.0
 **/
public class HeapTest {

    byte[] a = new byte[1024*100];

    public static void main(String[] args) throws InterruptedException{
        ArrayList<HeapTest> heapTests = new ArrayList<>();
        while (true){
            heapTests.add(new HeapTest());
            Thread.sleep(10);
        }

    }
}
