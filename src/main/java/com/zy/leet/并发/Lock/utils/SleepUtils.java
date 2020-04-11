package com.zy.leet.并发.Lock.utils;

import java.util.concurrent.TimeUnit;

/**
 * @ClassName SleepUtils
 * @Description TODO
 * @Author peppers
 * @Date 2020/4/11
 * @Version 1.0
 **/
public class SleepUtils {
    public static final void second(long seconds) {
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException ignore) {
        }
    }

    public static final void millisecond(long milliseconds) {
        try {
            TimeUnit.MILLISECONDS.sleep(milliseconds);
        } catch (InterruptedException ignore) {
        }
    }
}
