package com.github.study.demo.guava;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.Weigher;

/**
 * CreatedDate: 2021/2/19
 * Author: songjialin
 */
public class CacheTest {
    public static void main(String[] args) {
        // 创建1个cache,最大权重是100,如果缓存值是偶数占20个权重,奇数占5个权重
        Cache<Integer, Integer> cache = CacheBuilder.newBuilder()
                .recordStats()
                .concurrencyLevel(8)
                .maximumWeight(100)
                .removalListener(it -> System.out.println(String.join(",", it.getKey().toString(), it.getValue().toString(), it.getCause().toString())))
                .weigher(new Weigher<Integer, Integer>() {
                    @Override
                    public int weigh(Integer key, Integer value) {
                        if (value % 2 == 0) {
                            return 20;
                        } else {
                            return 5;
                        }
                    }
                }).build();
// 放偶数
        for (int i = 0; i < 100; i += 2) {
            System.out.println("put:" + i);
            cache.put(i, i);
        }
// {6=6, 8=8, 2=2, 4=4}
        System.out.println(cache.asMap());
// 清空所有缓存
        cache.invalidateAll();
// 放奇数
        for (int i = 1; i < 100; i += 1) {
            cache.put(i, i);
        }
// {6=6, 5=5, 8=8, 7=7, 2=2, 9=9, 3=3, 4=4}
        System.out.println(cache.asMap());
    }
}
