package com.github.study.demo.reflect;

import com.google.common.reflect.TypeToken;

/**
 * CreatedDate: 2021/1/28
 * Author: songjialin
 */
public class GenericArrayTypeTest {
    public static void main(String[] args) throws NoSuchMethodException {
        System.out.println(new TypeToken<String>() {
        }.getType());
    }
}

class A<T> extends TypeToken<T> {
}

class B<T1, T2> extends A<T2> {
}
