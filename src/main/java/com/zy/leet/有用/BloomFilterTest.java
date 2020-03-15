package com.zy.leet.有用;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * 加快判定一个元素是否在集合中出现的方法。因为其主要是过滤掉了大部分元素间的精确匹配，故称为过滤器
 *
 * 使用场景:海量的集合中查找某个元素是否存在,并且通常这个元素不在集合中
 *
 * 布隆过滤器（Bloom Filter）的核心实现是一个超大的位数组和几个哈希函数
 * */
public class BloomFilterTest {
    public static final int NUM_SLOTS= 2 << 24;
    public static final int NUM_HASH=8;
    private BigInteger bitmap = new BigInteger("0");

    private int getHash(String message,int n){
        try {
            MessageDigest md5 = MessageDigest.getInstance("md5");
            message = message + String.valueOf(n);
            byte[] bytes = message.getBytes();
            md5.update(bytes);
            BigInteger bi = new BigInteger(md5.digest());

            return Math.abs(bi.intValue()) % NUM_SLOTS;
        }catch (NoSuchAlgorithmException ex){
            Logger.getLogger(BloomFilterTest.class.getName()).log(Level.SEVERE,null,ex);
        }
        return -1;
    }

    public void addElement(String message){
        for (int i=0;i<NUM_HASH;i++){
            int hashcode = getHash(message,i);
            if(!bitmap.testBit(hashcode)){
                bitmap = bitmap.or(new BigInteger("1").shiftLeft(hashcode));
            }
        }
    }

    public boolean check(String message){
        for(int i=0;i<NUM_HASH;i++){
            int hashcode = getHash(message,i);
            if(!this.bitmap.testBit(hashcode)){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(NUM_SLOTS);
        //测试代码
        BloomFilterTest bf = new BloomFilterTest();
        ArrayList<String> contents = new ArrayList<>();
        contents.add("sldkjelsjf");
        contents.add("ggl;ker;gekr");
        contents.add("wieoneomfwe");
        contents.add("sldkjelsvrnlkjf");
        contents.add("ksldkflefwefwefe");

        for(int i=0;i<contents.size();i++){
            bf.addElement(contents.get(i));
        }
        System.out.println(bf.check("sldkjelsvrnlkjf"));
        System.out.println(bf.check("sldkjelsvrnkjf"));
    }
}
