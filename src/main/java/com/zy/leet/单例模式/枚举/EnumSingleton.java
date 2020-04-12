package com.zy.leet.单例模式.枚举;

/**
 * @ClassName EnumSingleton
 * @Description TODO
 * @Author peppers
 * @Date 2020/4/12
 **/
public enum EnumSingleton {
    INSTANCE;

    public void  print(){
        System.out.println(INSTANCE.hashCode());
    }
}
