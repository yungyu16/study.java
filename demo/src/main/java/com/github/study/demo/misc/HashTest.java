package com.github.study.demo.misc;

/**
 * CreatedDate: 2020/6/30
 * Author: songjialin
 */
public class HashTest {
    public static void main(String[] args) {
        int[] arr0 = new int[3];
        int[] arr1 = new int[3];
        arr0.hashCode(); // 触发arr0计算identity hash code
        arr1.hashCode(); // 触发arr1计算identity hash code

        // 试着交换下面两行
        System.out.println(arr0);
        System.out.println(arr1);
    }
}
