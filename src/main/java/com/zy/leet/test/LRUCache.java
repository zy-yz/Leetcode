package com.zy.leet.test;


import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 手写LRU算法
 * */
public class LRUCache<K,V> extends LinkedHashMap<K,V> {

    private final int CACHE_SIZE;

    //传递进来最多能缓存多少数据
    //cache缓存大小
    public LRUCache(int cacheSize){
        //true表示让linkedHashMap按照顺序访问来排序，最近访问的在头部，最老访问的在尾部
        super((int) Math.ceil(cacheSize / 0.75) + 1, 0.75f,true);
        CACHE_SIZE = cacheSize;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        return size() > CACHE_SIZE;
    }
}
