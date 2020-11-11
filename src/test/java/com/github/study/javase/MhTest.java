package com.github.study.javase;

import java.util.Arrays;

/**
 * CreatedDate: 2020/8/21
 * Author: songjialin
 */
public class MhTest {
    public static void main(String[] args) {
        Runnable r = () -> System.out.println(Arrays.toString(args));
        r.run();
    }
}
