package com.github.study.java;

import java.util.BitSet;

/**
 * CreatedDate: 2020/7/20
 * Author: songjialin
 */
public class MapTest {
    public static void main(String[] args) {
        final BitSet bitSet = BitSet.valueOf(new byte[]{1, 2});
        System.out.println(bitSet.get(0));
        System.out.println(bitSet.get(7));
        System.out.println(bitSet.get(14));

    }
}
