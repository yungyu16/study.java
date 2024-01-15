package com.github.study.demo.misc;

import javax.tools.JavaCompiler;
import javax.tools.ToolProvider;
import java.io.IOException;
import java.util.ServiceLoader;

/**
 * CreatedDate: 2020/6/24
 * Author: songjialin
 */
public class CompilerTest {
    public static final String SRC_FILE = "src/main/java/com/github/study/java/AsmTest.java";

    public static void main(String[] args) throws IOException {
        ServiceLoader<JavaCompiler> load = ServiceLoader.load(JavaCompiler.class);
        load.forEach(System.out::println);
        JavaCompiler systemJavaCompiler = ToolProvider.getSystemJavaCompiler();
        int retCode = systemJavaCompiler.run(System.in, System.out, System.err, SRC_FILE);
        System.out.println(retCode);
    }
}
