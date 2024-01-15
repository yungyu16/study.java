package com.github.study.demo.misc;

import sun.nio.ch.DirectBuffer;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @author Yungyu
 * @description Created by Yungyu on 2020/7/14.
 */
public class MmapTest {
    public static void main(String[] args) throws IOException, InterruptedException {
        Path path = Paths.get("test.mmp");
        if (!Files.exists(path)) {
            Files.createFile(path);
        }
        FileChannel a=null;
        RandomAccessFile raf = new RandomAccessFile(path.toFile(), "rw");
        raf.getFD().sync();
        MappedByteBuffer mappedByteBuffer = raf.getChannel().map(FileChannel.MapMode.READ_WRITE, 0, 1024L * 1024 * 1024);
        DirectBuffer mappedByteBuffer1 = (DirectBuffer) mappedByteBuffer;
        mappedByteBuffer1.cleaner().clean();
    }
}
