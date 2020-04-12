package com.zy.leet.并发.threadpool.手写;

/**
 * @ClassName InternalTask
 * @Description 不断执行任务队列的执行单元
 * @Author peppers
 * @Date 2020/4/12
 **/
public class InternalTask implements Runnable{
    private RunnableQueue linkedRunnableQueue;

    private boolean running = true;

    public InternalTask(RunnableQueue linkedRunnableQueue){
        this.linkedRunnableQueue = linkedRunnableQueue;
    }
    @Override
    public void run() {
        while (running && !Thread.currentThread().isInterrupted()){
            Runnable take = null;
            try {
                take = linkedRunnableQueue.take();
                take.run();
            }catch (InterruptedException e){
                running = false;
                break;
            }
        }

    }

    public void stop(){
        running = false;
    }
}
