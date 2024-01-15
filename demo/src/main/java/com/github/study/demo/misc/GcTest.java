package com.github.study.demo.misc;

import net.bramp.unsafe.UnsafeHelper;
import sun.misc.Unsafe;

import java.util.Arrays;

/**
 * CreatedDate: 2020/7/2
 * Author: songjialin
 */
public class GcTest {
    private int a = 1;

    public static void main(String[] args) throws InterruptedException, NoSuchFieldException {
        GcTest gcTest = new GcTest();
        Unsafe unsafe = UnsafeHelper.getUnsafe();
        byte[] longs = new byte[100];
//        System.out.println(unsafe.arrayIndexScale(longs.getClass()));
//        System.out.println(unsafe.arrayBaseOffset(longs.getClass()));
//        unsafe.setMemory();
        unsafe.setMemory(longs, Unsafe.ARRAY_BYTE_BASE_OFFSET, 88 * 1, (byte) 8);
        System.out.println(Arrays.toString(longs));
    }
}
