package com.zy.leet.并发.Lock;

import com.zy.leet.并发.Lock.utils.SleepUtils;
import java.util.concurrent.locks.Lock;

/**
 * @ClassName TestMyLock
 * @Description 自定义Lock实现类
 * @Author peppers
 * @Date 2020/4/11
 * @Version 1.0
 **/
public class TestMyLock {

    private final Lock lock = new MyLock();

    private volatile int count = 100;

    private static class WorkThread extends Thread {
        private TestMyLock myLock;

        public WorkThread(TestMyLock myLock) {
            this.myLock = myLock;
        }

        @Override
        public void run() {
            myLock.test();
        }
    }

    public void test() {
        lock.lock();
        try {
            SleepUtils.second(500);
            System.out.println(Thread.currentThread().getName() + "获取到的count=" + count--);
            SleepUtils.second(500);
            if (count == 98) {
                //test();
            }
        }finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        TestMyLock myLock = new TestMyLock();
        // 启5个子线程
        for (int i = 0; i < 5; i++) {
            new WorkThread(myLock).start();
        }
        // 主线程没秒打印一行空格
        for (int i = 0; i < 10; i++) {
            SleepUtils.second(1000);
            System.out.println();
        }
    }

}