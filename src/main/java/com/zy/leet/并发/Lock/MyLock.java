package com.zy.leet.并发.Lock;

import com.sun.corba.se.impl.orbutil.concurrent.Sync;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * @ClassName MyLock
 * @Description 自定义Lock实现类
 * @Author peppers
 * @Date 2020/4/11
 * @Version 1.0
 **/
public class MyLock implements Lock {

    private Sync sync;

    public MyLock(){
        sync = new Sync();
    }

    private static class Sync extends AbstractQueuedSynchronizer{
        //尝试获取独占锁
        @Override
        protected boolean tryAcquire(int arg){
            if(compareAndSetState(0,1)){
                setExclusiveOwnerThread(Thread.currentThread());
                return true;
            }
            return false;
        }

        //尝试是否独占锁
        @Override
        protected boolean tryRelease(int arg){
            if(getState() == 0){
                throw new IllegalMonitorStateException();
            }
            setExclusiveOwnerThread(null);
            setState(0);
            return true;
        }
        // 快速判断当前锁释放已被独占
        @Override
        protected boolean isHeldExclusively() {
            return getState() == 1;
        }

        Condition newCondition() {
            return new ConditionObject();
        }
    }
    @Override
    public void lock() {
        sync.acquire(1);

    }

    @Override
    public void lockInterruptibly() throws InterruptedException {
        sync.acquireInterruptibly(1);

    }

    @Override
    public boolean tryLock() {
        return sync.tryAcquire(1);
    }

    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return sync.tryAcquireNanos(1,unit.toNanos(time));
    }

    @Override
    public void unlock() {
        sync.release(1);

    }

    @Override
    public Condition newCondition() {
        return sync.newCondition();
    }
}
