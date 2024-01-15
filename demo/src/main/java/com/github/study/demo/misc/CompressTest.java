package com.github.study.demo.misc;

import cn.hutool.core.io.IoUtil;
import org.apache.commons.compress.compressors.CompressorException;
import org.apache.commons.compress.compressors.CompressorInputStream;
import org.apache.commons.compress.compressors.CompressorOutputStream;
import org.apache.commons.compress.compressors.CompressorStreamFactory;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * CreatedDate: 2020/6/24
 * Author: songjialin
 */
public class CompressTest {
    public static void main(String[] args) throws Exception {
        out();
        in();
    }

    private static void in() throws IOException, CompressorException {
        InputStream in = Files.newInputStream(Paths.get("testCompress.zip"));
        System.out.println(in);
        CompressorInputStream input = new CompressorStreamFactory()
                .createCompressorInputStream(in);
        OutputStream out = Files.newOutputStream(Paths.get("out.txt"));
        IoUtil.copy(in, out);
        out.flush();
        out.close();
        input.close();
        in.close();
    }

    private static void out() throws Exception {
        OutputStream out = Files.newOutputStream(Paths.get("testCompress.zip"));
        CompressorOutputStream gzippedOut = new CompressorStreamFactory()
                .createCompressorOutputStream(CompressorStreamFactory.BZIP2, out);
        gzippedOut.write("hello world".getBytes());
        gzippedOut.flush();
        gzippedOut.close();
    }
}
