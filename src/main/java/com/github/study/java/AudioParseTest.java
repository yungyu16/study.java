package com.github.study.java;

import java.nio.ByteBuffer;
import java.nio.channels.SeekableByteChannel;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * CreatedDate: 2020/6/24
 * Author: songjialin
 */
public class AudioParseTest {
    public static void main(String[] args) throws Exception {
        try (SeekableByteChannel channel = Files.newByteChannel(Paths.get("好汉歌.mp3"))) {
            long size = channel.size();
            channel.position(size - 128);
            ByteBuffer buffer = ByteBuffer.allocate(128);
            while (buffer.hasRemaining()) {
                channel.read(buffer);
            }
            System.out.println(buffer.remaining());
            buffer.flip();
            System.out.println(buffer.remaining());
            byte[] tagArr = new byte[3];
            buffer.get(tagArr);
            System.out.println(buffer.remaining());
            System.out.println(new String(tagArr));
            System.out.println("======================");
            channel.position(10);
            ByteBuffer tag = ByteBuffer.allocate(10);
            while (tag.hasRemaining()) {
                channel.read(tag);
            }
            tag.flip();
            byte[] array = tag.array();
            int limit = tag.limit();
            String x = new String(array, 0, 4);
            System.out.println(x);
            System.out.println(x);
            System.out.println(x);
            System.out.println("==========");
            System.out.println(x);
            System.out.println(x);
            System.out.println(x);
            System.out.println(x);
            System.out.println(x);
            System.out.println(x + "hahha");
            String s = new String(new byte[]{65, 65, 65, 13, 65});
            System.out.println(s);
        }
    }
}
