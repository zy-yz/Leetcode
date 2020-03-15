package com.zy.leet.字符串;


/**
 * 适合用volatile的情况
 * 1..运⾏结果并不依赖变量的当前值，或者能够确保只有单⼀的线程修改变量的值
 * 2.变量不需要与其他的状态变量共同参与不变约束*/


import java.util.HashMap;

/**volatile特性
 * 1.保证变量在线程之间的可⻅性。可⻅性的保证是基于CPU的内存屏障指令，被JSR-133抽象
 * 为happens-before原则
 * 2.阻⽌编译时和运⾏时的指令重排。编译时JVM编译器遵循内存屏障的约束，运⾏时依靠
 * CPU屏障指令来阻⽌重排*/
public class VolatileTest {
    public volatile static int count = 0;

    volatile static int start = 3;
    volatile static int end = 6;

    public static void main(String[] args) {
        HashMap s = new HashMap();
        for(int i=0;i<10;i++){
            new Thread(
                    new Runnable() {
                        @Override
                        public void run() {
                            try {
                                Thread.sleep(1);
                            }catch (InterruptedException e){
                                e.printStackTrace();
                            }

                            for (int j=0;j<100;j++){
                                //count++不是原子操作
                                count++;
                            }
                        }
                    }
            ).start();
        }
        try {
            Thread.sleep(2000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        System.out.println("count="+count);



        /**这种情况下，⼀旦在线程A的循环中执⾏了线程B，start有可能先更新成6，造成了⼀瞬间
         start == end，从⽽跳出while循环的可能性。*/
//        //线程A执⾏如下代码：
//        while (start < end){
//         //do something
//        }
//        //线程B执⾏如下代码：
//        start+=3;
//        end+=3;
    }
}
