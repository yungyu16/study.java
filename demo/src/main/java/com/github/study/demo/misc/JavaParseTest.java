package com.github.study.demo.misc;

import com.github.javaparser.JavaParser;

/**
 * CreatedDate: 2020/9/9
 * Author: songjialin
 */
public class JavaParseTest {
    public static void main(String[] args) {
        new JavaParser().parse("public class BananaTest {\n" +
                "    public static void main(String[] args) {\n" +
                "        System.out.println(BananaUtils.bananaify(\"Hello, Banana!\"));\n" +
                "    }\n" +
                "}\n").getResult().orElse(null);
    }
}
