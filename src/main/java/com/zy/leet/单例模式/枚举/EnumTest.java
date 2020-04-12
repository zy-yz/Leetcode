package com.zy.leet.单例模式.枚举;

/**
 * @ClassName EnumTest
 * @Description TODO
 * @Author peppers
 * @Date 2020/4/12
 **/
public class EnumTest {

    public static void main(String[] args) {
        EnumSingleton instance = EnumSingleton.INSTANCE;

        EnumSingleton instance1 = EnumSingleton.INSTANCE;
        System.out.println(instance == instance1);

        instance.print();

        instance1.print();
    }
}
