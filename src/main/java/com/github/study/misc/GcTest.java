package com.github.study.misc;

import com.google.common.collect.Lists;

import java.util.ArrayList;

/**
 * CreatedDate: 2020/7/2
 * Author: songjialin
 */
public class GcTest {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("begin");
        ArrayList<Object> objects = Lists.newArrayList();
        for (; ; ) {
            objects.add(new byte[1024 * 1024]);
        }
    }
}
