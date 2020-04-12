package com.zy.leet.并发.threadpool.手写;

/**
 * @ClassName RunnableQueue
 * @Description 定义任务队列接口
 * @Author peppers
 * @Date 2020/4/12
 **/
public interface RunnableQueue {

    void offer(Runnable runnable);
    Runnable take() throws InterruptedException;
    int size();
}
