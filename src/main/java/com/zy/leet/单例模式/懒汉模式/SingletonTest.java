package com.zy.leet.单例模式.懒汉模式;

import java.sql.SQLOutput;

/**
 * @ClassName SingletonTest
 * @Description TODO
 * @Author peppers
 * @Date 2020/4/12
 * @Version 1.0
 **/
public class SingletonTest {

    public static void main(String[] args) throws InterruptedException {
        new Thread(new Runnable() {
            @Override
            public void run() {
                LazySingleton lazySingleton = LazySingleton.getInstance();
                System.out.println(lazySingleton);
            }
        }).start();


        new Thread(new Runnable() {
            @Override
            public void run() {
                LazySingleton lazySingleton = LazySingleton.getInstance();
                System.out.println(lazySingleton);
            }
        }).start();
    }
}
