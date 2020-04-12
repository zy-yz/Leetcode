package com.zy.leet.单例模式.内部类;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * @ClassName InnerTest
 * @Description TODO
 * @Author peppers
 * @Date 2020/4/12
 **/
public class InnerTest {

    public static void main(String[] args) throws IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchMethodException {
        Constructor<InnerClassSingleton> declaredConstructor = InnerClassSingleton.class.getDeclaredConstructor();
        declaredConstructor.setAccessible(true);
        InnerClassSingleton innerClassSingleton = declaredConstructor.newInstance();

        InnerClassSingleton instance = InnerClassSingleton.getInstance();
        System.out.println(innerClassSingleton == instance);


    }
}
