package com.zy.leet.并发.Lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * @ClassName MyLockSync
 * @Description TODO
 * @Author peppers
 * @Date 2020/4/11
 * @Version 1.0
 **/
public class MyLockSync implements Lock {

    private Sync sync;

    public MyLockSync() {
        sync = new Sync();
    }

    private static class Sync extends AbstractQueuedSynchronizer {

        // 尝试获取独占锁
        @Override
        protected boolean tryAcquire(int arg) {
            // 获取当前线程
            Thread current = Thread.currentThread();
            // 获取锁的状态
            int c = getState();
            if (c == 0) {
                // 如果锁的状态是0则以CAS的形式将状态变量设置为1
                if (compareAndSetState(0, 1)) {
                    setExclusiveOwnerThread(Thread.currentThread());
                    return true;
                }
            } else if (current == getExclusiveOwnerThread()) {
                // 因为是独占锁,所以同一时刻只能有一个线程能获取到锁,如果当前的锁是被当前线程获取过了,则将状态变量+1
                int nextC = c + arg;
                // 设置新的状态变量
                setState(nextC);
                return true;
            }
            return false;
        }

        // 尝试是否独占锁
        @Override
        protected boolean tryRelease(int arg) {
            // 判断当前锁释放是当前线程锁独占的,如果判断不成立则抛出异常
            if (Thread.currentThread() != getExclusiveOwnerThread())
                throw new IllegalMonitorStateException();
            int c = getState() - arg;
            boolean free = false;
            if (c == 0){
                // 如果状态为0了则说明当前线程可以释放对锁的持有了
                setExclusiveOwnerThread(null);
                free = true;
            }
            setState(c);
            return free;
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
