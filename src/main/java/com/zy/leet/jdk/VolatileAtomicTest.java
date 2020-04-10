package com.zy.leet.jdk;

/**
 * @ClassName VolatileAtomicTest
 * @Description TODO
 * @Author peppers
 * @Date 2020/4/10
 * @Version 1.0
 **/
public class VolatileAtomicTest {

    public static volatile int num =0;

    public static void increase(){
        num++;
    }

    public static void main(String[] args) throws InterruptedException{
        Thread[] threads = new Thread[10];
        for (int i=0;i<threads.length;i++){
            threads[i] = new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int i=0;i<1000;i++){
                        increase();
                    }
                }
            });
            threads[i].start();
        }

        for (Thread t : threads){
            t.join();
        }
        System.out.println(num);
    }
}
