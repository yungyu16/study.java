package com.github.study.demo.misc;

/**
 * CreatedDate: 2020/9/3
 * Author: songjialin
 */
public class BitOpTest {
    public static void main(String[] args) {
        System.out.println(8 & (8 - 1));
        byte[] bytes = new byte[]{-127, -127};
        System.out.println(bytes2short1(bytes, 0));
        System.out.println(bytes2short2(bytes, 0));
        System.out.println(Integer.toBinaryString(-127 << 8));
        System.out.println(Integer.toBinaryString(-127));
        System.out.println(Byte.toUnsignedInt((byte) -127));
    }

    public static short bytes2short1(byte[] b, int off) {
        return (short) (((b[off + 1] & 0xFF) << 0) +
                ((b[off + 0]) << 8));
    }

    public static short bytes2short2(byte[] b, int off) {
        return (short) ((b[off + 1] & 0xFF) | (b[off] << 8));
    }
}
