package com.zy.leet.单例模式.内部类;

/**
 * @ClassName InnerClassSingleton
 * @Description TODO
 * @Author peppers
 * @Date 2020/4/12
 **/
public class InnerClassSingleton {

    static class InnerClass{
        private static InnerClassSingleton instance = new InnerClassSingleton();
    }

    public static InnerClassSingleton getInstance(){
        return InnerClass.instance;
    }

    private InnerClassSingleton(){
        if(InnerClass.instance == null){
            throw new RuntimeException("--");
        }
    }
}
