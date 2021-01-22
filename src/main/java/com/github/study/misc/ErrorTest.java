package com.github.study.misc;

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


        TimeUnit.SECONDS.sleep(5);
        System.out.println("e");
        throw new OutOfMemoryError();
    }
}
