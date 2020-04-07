package com.zy.leet.jdk;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @ClassName LinkedHashMapTest
 * @Description TODO
 * @Author peppers
 * @Date 2020/4/6
 * @Version 1.0
 **/
public class LinkedHashMapTest {

    class LRUCache<k,v> extends LinkedHashMap<k,v>{
        private final int CACHE_SIZE;

        /**
         * 传递进来最多能存储多少数据
         * */
        public LRUCache(int cacheSize){
            //true表示让linkedHashMap按照访问顺序进行排序，最近访问的放在头部。
            super((int) Math.ceil(cacheSize / 0.75) + 1,0.75f,true);
            CACHE_SIZE = cacheSize;
        }

        @Override
        protected boolean removeEldestEntry(Map.Entry<k,v> eldest){
            //当map中的数据量大于指定缓存个数的时候，就自动删除最老的数据
            return size() > CACHE_SIZE;
        }
    }
}
