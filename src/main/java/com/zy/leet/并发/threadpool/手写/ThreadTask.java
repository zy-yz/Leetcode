package com.zy.leet.并发.threadpool.手写;

/**
 * @ClassName ThreadTask
 * @Description TODO
 * @Author peppers
 * @Date 2020/4/12
 **/
public class ThreadTask {
    Thread thread;
    InternalTask internalTask;
    public ThreadTask(Thread thread,InternalTask internalTask){
        this.internalTask = internalTask;
        this.thread = thread;
    }
}
