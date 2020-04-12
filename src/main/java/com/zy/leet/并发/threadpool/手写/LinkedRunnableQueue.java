package com.zy.leet.并发.threadpool.手写;

import java.util.LinkedList;

/**
 * @ClassName LinkedRunnableQueue
 * @Description 定义任务队列
 *              提供添加，取出方法
 *              规定任务队列的最大任务数量
 * @Author peppers
 * @Date 2020/4/12
 **/
public class LinkedRunnableQueue implements RunnableQueue{

    private LinkedList<Runnable> linkedList = new LinkedList<>();

    private DenyPolicy denyPolicy;

    private ThreadPool threadPool;

    private int limit;

    public LinkedRunnableQueue(int limit,DenyPolicy denyPolicy,ThreadPool threadPool){
        this.limit = limit;
        this.denyPolicy = denyPolicy;
        this.threadPool = threadPool;
    }
    @Override
    public void offer(Runnable runnable) {
        synchronized (linkedList){
            if(linkedList.size() >=limit){
                denyPolicy.reject(threadPool,runnable);
            }else {
                linkedList.addLast(runnable);
                linkedList.notifyAll();
            }
        }

    }

    @Override
    public Runnable take() throws InterruptedException {
        synchronized (linkedList){
            while (linkedList.isEmpty()){
                try {
                    linkedList.wait();
                }catch (InterruptedException e){
                    System.out.println("wait 状态中段，继续执行");
                }
            }
        }
        return linkedList.removeFirst();
    }

    @Override
    public int size() {
        return linkedList.size();
    }
}
