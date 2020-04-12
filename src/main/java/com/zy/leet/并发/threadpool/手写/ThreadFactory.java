package com.zy.leet.并发.threadpool.手写;

/**
 * @ClassName ThreadFactory
 * @Description TODO
 * @Author peppers
 * @Date 2020/4/12
 **/
public interface ThreadFactory {
    Thread createThread(Runnable runable);
}
