package com.github.study.demo.reflect;

import com.google.common.reflect.TypeParameter;
import com.google.common.reflect.TypeToken;

import java.math.BigInteger;
import java.util.Map;
import java.util.Queue;

/**
 * @description Created on 2021/1/28.
 */
public class Test {
    static <K, V> TypeToken<Map<K, V>> mapToken(TypeToken<K> keyToken, TypeToken<V> valueToken) {
        return new TypeToken<Map<K, V>>() {
        }
                .where(new TypeParameter<K>() {
                }, keyToken)
                .where(new TypeParameter<V>() {
                }, valueToken);
    }

    public static void main(String[] args) {
        TypeToken<Map<String, BigInteger>> mapToken = mapToken(
                TypeToken.of(String.class),
                TypeToken.of(BigInteger.class)
        );
        System.out.println(mapToken);
        TypeToken<Map<Integer, Queue<String>>> complexToken = mapToken(
                TypeToken.of(Integer.class),
                new TypeToken<Queue<String>>() {
                }
        );
        System.out.println(complexToken);
    }
}
