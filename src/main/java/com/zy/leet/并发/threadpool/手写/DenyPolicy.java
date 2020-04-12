package com.zy.leet.并发.threadpool.手写;

/**
 * @ClassName DenyPolicy
 * @Description 定义拒绝策略
 *              实现三种策略
 *              第一种直接丢任务
 *              第二种跑出异常
 *              第三种将任务由提供者的线程处理
 * @Author peppers
 * @Date 2020/4/12
 **/
public interface DenyPolicy {

    public void reject(ThreadPool threadPool,Runnable runnable);

    class DisCardDenyPolicy implements DenyPolicy{

        @Override
        public void reject(ThreadPool threadPool, Runnable runnable) {

        }
    }

    class AbortDenyPolicy implements DenyPolicy{

        @Override
        public void reject(ThreadPool threadPool, Runnable runnable) {

            new DenyPolicyException("the runnable" + runnable + "will be abort");
        }
    }
    class RunnerDenyPolicy implements DenyPolicy{

        @Override
        public void reject(ThreadPool threadPool, Runnable runnable) {
            if(!threadPool.isShutDown()){
                runnable.run();
            }

        }
    }
}
