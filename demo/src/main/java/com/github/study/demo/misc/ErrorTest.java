package com.github.study.demo.misc;

import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;

/**
 * CreatedDate: 2020/6/28
 * Author: songjialin
 */
public class ErrorTest {
    public static void main(String[] args) throws InterruptedException {
        System.out.println(System.getSecurityManager());
        new Thread(() -> {
            try {
                while (true) {
                    TimeUnit.SECONDS.sleep(1);
                    System.out.println(LocalDateTime.now());
                }
            } catch (InterruptedException e) {
                throw new RuntimeException();
            }
        }, "test").start();
        ExecTest.InnerTest innerTest = new ExecTest().new InnerTest();
        Class<? extends ExecTest.InnerTest> aClass = innerTest.getClass();

        TimeUnit.SECONDS.sleep(5);
        System.out.println("e");
        throw new OutOfMemoryError();
    }
}
