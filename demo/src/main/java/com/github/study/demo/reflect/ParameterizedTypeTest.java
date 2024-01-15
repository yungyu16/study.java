package com.github.study.demo.reflect;

import org.springframework.beans.factory.InitializingBean;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.List;

/**
 * CreatedDate: 2021/1/28
 * Author: songjialin
 */
public class ParameterizedTypeTest {
    public static void main(String[] args) {
        Type genericSuperclass = Test2.class.getGenericSuperclass();
        System.out.println(genericSuperclass.getClass());
        System.out.println(genericSuperclass.getTypeName());
        Type[] actualTypeArguments = ((ParameterizedType) genericSuperclass).getActualTypeArguments();
        System.out.println(actualTypeArguments[0].getClass());
        System.out.println(Arrays.toString(actualTypeArguments));
        List<? super InitializingBean> list = null;
    }

    public <T> T eee(List<? super Serializable> a) {
        return null;
    }
}

class Test1<AA> {

}

class Test2<TT1, TT2> extends Test1<TT2> {

}
