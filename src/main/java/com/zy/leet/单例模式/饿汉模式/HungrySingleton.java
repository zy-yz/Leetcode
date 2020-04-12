package com.zy.leet.单例模式.饿汉模式;

/**
 * @ClassName HungrySingleton
 * @Description 在类加载阶段就完成了实例的初始化，通过类加载机制来保证我们的线程安全
 *               加载 -》 加载对应的二进制文件，并且在方法区，创建对应的数据结构
 *               连接 a,验证，b,准备，c,解析
 *               初始化:给静态属性赋值
 * @Author peppers
 * @Date 2020/4/12
 **/
public class HungrySingleton {

    private static HungrySingleton instance = new HungrySingleton();

    private HungrySingleton(){};

    public static HungrySingleton getInstance(){
        return instance;
    }
}
