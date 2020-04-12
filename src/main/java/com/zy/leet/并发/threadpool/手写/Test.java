package com.zy.leet.并发.threadpool.手写;

import java.util.concurrent.TimeUnit;

/**
 * @ClassName Test
 * @Description TODO
 * @Author peppers
 * @Date 2020/4/12
 **/
public class Test {
    public static void main(String[] args) throws InterruptedException {
        BasicThreadPool basicThreadPool = new BasicThreadPool(2,6,4,1000);
        for (int i=0;i<20;i++){
            basicThreadPool.execute(() ->{
                try {
                    TimeUnit.SECONDS.sleep(10);
                    System.out.println(Thread.currentThread().getName()+":"+"执行并且结束了");
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            });
        }
        while(true){
            System.out.println("线程池中的活跃数量是"+basicThreadPool.getActiveCount());
            System.out.println("线程池中任务队列的数量是"+basicThreadPool.getQueueSize());
            TimeUnit.SECONDS.sleep(5);

        }
    }
}
