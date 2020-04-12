package com.zy.leet.并发.Unsafe;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * @ClassName UnsafeInstance
 * @Description Unsafe是一个魔法类，因为可以绕过虚拟机，直接操作内存
 * @Author peppers
 * @Date 2020/4/12
 * @Version 1.0
 **/
public class UnsafeInstance {
    public static Unsafe reflectGetUnsafe(){
        //Unsage类有个静态方法getUnsafe()来获取Unsafe的实例
        //但是如果尝试调用Unsafe.getUnsafe(),会得到一个secutiryException，因为这个类只有被JDK信任的类实例才可以调用
        //Unsafe unsafe = Unsafe.getUnsafe();
        //System.out.println(unsafe);

        //抛异常的具体原因
        //类加载是基于双亲委派模式的，也就是父类加载器先加载
        //bootstrap类加载器是最顶级的类加载器，Unsafe里面会判断如果不是bootstrap的类加载
        //直接抛出异常，只有通过bootstrap类加载器，才能拿到实例

        //所以Unsafe只能通过反射去拿
        try {
            Field field = Unsafe.class.getDeclaredField("theUnsafe");
            field.setAccessible(true);
            //由于Unsafe是Unsafe类的静态变量，所以参数为null
            //如果是一个实例变量的话，要传对象，也就是要获取这个对象的field

            return (Unsafe) field.get(null);
        }catch (Exception e){
            e.printStackTrace();
        }
    return null;


    }
}
