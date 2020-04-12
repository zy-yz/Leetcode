package com.zy.leet.单例模式.懒汉模式;

/**
 * @ClassName LazySingleton
 * @Description 懒汉模式:就是延迟加载
 *                双重检验，使用volatile，synchronized
 *                   1.保证线程安全
 *                   2.防止指令重排(防止空指针异常)  //还没有初始化就引用了
 *                   3.双重检验优化加锁过程
 * @Author peppers
 * @Date 2020/4/12
 * @Version 1.0
 **/
public class LazySingleton {

    private static volatile LazySingleton instance;

    public static LazySingleton getInstance(){
        if (instance == null){
            synchronized (LazySingleton.class){
                if(instance == null){
                    instance = new LazySingleton();
                }
            }
        }
        return instance;
    }

    private LazySingleton(){ }
}
