package com.zy.leet.jdk;

/**
 * @ClassName VolatileVisibiTest
 * @Description TODO
 * @Author peppers
 * @Date 2020/4/10
 * @Version 1.0
 **/
public class VolatileVisibiTest {

    private static volatile boolean initFlag = false;

    public static void main(String[] args) throws InterruptedException{

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("wainting data...");
                while (!initFlag){
                }
                System.out.println("====success");
            }
        }).start();

        Thread.sleep(2000);
        new Thread(new Runnable() {
            @Override
            public void run() {
                prepareData();
            }
        }).start();

    }

    public static void prepareData(){
        System.out.println("prepareData ...");
        initFlag = true;
        System.out.println("prepare data end...");
    }
}
