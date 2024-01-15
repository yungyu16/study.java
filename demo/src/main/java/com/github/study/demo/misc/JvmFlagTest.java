package com.github.study.demo.misc;

/**
 * CreatedDate: 2020/6/29
 * Author: songjialin
 */
public class JvmFlagTest {
    public static void main(String[] args) {
        System.out.println(System.getProperty("PID"));

        Runtime.getRuntime()
                .addShutdownHook(new Thread(() -> {
                    System.out.println("=========================");
                    System.out.println(Thread.currentThread().getName());
                }, "hhhhh"));
        // System.exit(1);

        // Runtime.getRuntime().halt(1);
    }
}
