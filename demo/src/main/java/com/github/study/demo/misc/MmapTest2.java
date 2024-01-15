package com.github.study.demo.misc;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.concurrent.CountDownLatch;

/**
 * @author Yungyu
 * @description Created by Yungyu on 2020/7/14.
 */
public class MmapTest2 {
    public static void main(String[] args) throws IOException, InterruptedException {
                ByteBuffer buffer = ByteBuffer.allocateDirect(1024 * 1024 * 1024);
                System.in.read();
                buffer = null;
                new CountDownLatch(1).await();
    }
}
