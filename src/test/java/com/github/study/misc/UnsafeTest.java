package com.github.study.misc;

import net.bramp.unsafe.UnsafeHelper;
import sun.misc.Unsafe;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;

/**
 * CreatedDate: 2020/8/21
 * Author: songjialin
 */
public class UnsafeTest {
    private static Unsafe unsafe = UnsafeHelper.getUnsafe();

    public static void main(String[] args) throws InstantiationException, NoSuchMethodException, IllegalAccessException {
        System.out.println(unsafe.addressSize());
        System.out.println(unsafe.pageSize());
        System.out.println(unsafe.allocateInstance(TTT.class));
        System.out.println(new TTT());
        System.out.println("=========================");
        // MethodType.
        MethodType methodType = MethodType.methodType(void.class);
        MethodHandle mh = MethodHandles.lookup().bind(new TTT(), "test", methodType);
        try {
            System.out.println(mh.invoke());
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }

    static class TTT {
        private int a = 1;

        public void test() {
            System.out.println("fhsdgdskgjdlgj" + a);
        }
    }
}
