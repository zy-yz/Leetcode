package com.zy.leet.并发.threadpool.手写;

/**
 * @ClassName DenyPolicyException
 * @Description TODO
 * @Author peppers
 * @Date 2020/4/12
 **/
public class DenyPolicyException extends RuntimeException{
    public  DenyPolicyException(String message){
        super(message);
    }
}
