package com.github.study.demo.misc;

import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.BitSet;

/**
 * CreatedDate: 2020/7/20
 * Author: songjialin
 */
public class MapTest {
    public static void main(String[] args) {
        final BitSet bitSet = BitSet.valueOf(new byte[]{1, 2});
        System.out.println(bitSet.get(0));
        System.out.println(bitSet.get(7));
        System.out.println(bitSet.get(14));

        FileSystem fs = FileSystems.getDefault();
        System.out.println(fs.getSeparator());
        Path path = Paths.get("../study.java/./../src/../main");
        System.out.println(path.normalize());
        System.out.println(path.normalize().toAbsolutePath());
        System.out.println(path.normalize().toAbsolutePath().normalize());
        System.out.println(path.toAbsolutePath());
    }
}
