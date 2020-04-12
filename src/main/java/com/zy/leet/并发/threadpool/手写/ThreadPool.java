package com.zy.leet.并发.threadpool.手写;

/**
 * @ClassName ThreadPool
 * @Description 定义线程池接口
 * @Author peppers
 * @Date 2020/4/12
 **/
public interface ThreadPool {

    void execute(Runnable runnable);
    int getInitSize();
    int getCoreSize();
    int getMaxSize();
    int getActiveCount();
    boolean isShutDown();
    void shutDown();
}
