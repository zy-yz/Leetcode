package com.zy.leet.并发;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @ClassName LazySingleton
 * @Description 查看volatile关键字
 * @Author peppers
 * @Date 2020/4/8
 * @Version 1.0
 *
 *
 * 可见性:
 *     当一个共享变量被volatile修饰时，
 *     它会保证修改的值会立即被更新到主存，当有其他线程需要读取时，它会去内存中读取新值
 * 有序性：
 *     可以通过volatile来保证一定的有序性，
 *
 *
 *     一旦一个共享变量(类的成员变量，类的静态成员变量)被volatile修饰，那么就具有的两重语义
 *     1.保证了不同线程对这个变量的可见性，即一个线程修改了某个变量的值，这新值对其他线程来说是立即可见的
 *     2.禁止进行指令重排序
 *         1）当程序执行到volatile变量的读操作或者写操作时，在其前面的操作的更改肯定全部已经进行，且结果已经对后面的操作可见；在其后面的操作肯定还没有进行
 *         2）在进行指令优化时，不能将在对volatile变量访问的语句放在其后面执行，也不能把volatile变量后面的语句放到其前面执行
 *
 *    加入volatile关键字时，会多出一个lock前缀指令
 *        lock前缀指令相当于一个内存屏障，内存屏障会提供三个功能
 *        1.确保指令重排序时不会吧其后面的指令排到内存屏障之前的位置，也不会把前面的指令排到内存屏障后面，即在执行到内存屏障这条指令时，在他前面的操作全部完成
 *        2.会强制将对缓存的操作立即写入主存
 *        3.如果是写操作，会导致其他CPU对应的缓存行无效
 **/
public class LazySingleton {
//    private static volatile LazySingleton instance = null;
//
//    public static LazySingleton getInstance(){
//        if(instance == null){
//            instance = new LazySingleton();
//        }
//        return instance;
//    }

    public  volatile int inc = 0;
    public int inc1 = 0;

    public  void increase(){
        inc++;
    }

    public synchronized void increase1(){
        inc1++;
    }

    Lock lock = new ReentrantLock();
    public  void increaseLock(){
        lock.lock();
        try {
            inc1++;
        }finally {
            lock.unlock();
        }

    }

    public AtomicInteger inc2 = new AtomicInteger();
    public  void increaseAto() {
        inc2.getAndIncrement();
    }


    public static void main(String[] args) {
        //LazySingleton.getInstance();



       final LazySingleton test = new LazySingleton();
        for (int i=0;i<10;i++){
            new Thread(){
                @Override
                public void run(){
                    for (int j=0;j<1000;j++){
                        test.increaseLock();
                    }
                };
            }.start();
            System.out.println("1");
        }
        while (Thread.activeCount()>1) //保证前面的都执行wan
        {
            Thread.yield();
        }
        System.out.println("-------------");
        System.out.println(test.inc);
        System.out.println(test.inc1);
        /**
         * 每次的值都不等于10000，因为volatile只能保证可见性，不能保证原子性
         * 要想保证原子性，可以使用synchronize，Lock，AtomicInteger
         * */

    }

}
