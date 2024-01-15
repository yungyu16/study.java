package com.github.study.demo.reflect;

import com.google.common.reflect.TypeToken;

/**
 * CreatedDate: 2021/1/28
 * Author: songjialin
 */
public class WildcardTypeTest {

    public static void main(String[] args) {
        IKnowMyType<String> iKnowMyType = new IKnowMyType<String>() {
        };
        System.out.println(TypeToken.of(iKnowMyType.getClass()));
    }
}

abstract class IKnowMyType<T> {
}