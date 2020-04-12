package com.zy.leet.并发.Thread;

import com.oracle.tools.packager.Log;

/**
 * @ClassName ThreadTest
 * @Description
 * 1）定义Thread类的子类，并重写该类的run方法，该run方法的方法体就代表了线程要完成的任务。因此把run()方法称为执行体(线程体)。
 *
 * （2）创建Thread子类的实例，即创建了线程对象。
 *
 * （3）调用线程对象的start()方法来启动该线程。
 * @Author peppers
 * @Date 2020/4/12
 **/
public class ThreadTest extends Thread{
    int i=0;

    //重写run方法，run方法的方法体就是现场执行体
    @Override
    public void run(){
        for (;i<100;i++){
            Log.info(getName()+" "+i);
        }
    }

    public static void main(String[] args) {
        for (int i=0;i<100;i++){
            Log.info(Thread.currentThread().getName()+":"+i);
            System.out.println(Thread.currentThread().getName()+":"+i);
            if(i==20){
                new ThreadTest().start();
                new ThreadTest().start();
            }
        }
    }
}
