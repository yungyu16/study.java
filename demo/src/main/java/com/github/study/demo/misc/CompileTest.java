package com.github.study.demo.misc;

import org.eclipse.jdt.core.compiler.batch.BatchCompiler;

import javax.tools.ToolProvider;
import java.io.PrintWriter;

/**
 * CreatedDate: 2020/11/3
 * Author: songjialin
 */
public class CompileTest {
    public static void main(String[] args) {
        System.out.println(ToolProvider.getSystemJavaCompiler().run(null, null, System.err, "src/main/java/com/github/study/java/CompressTest.java"));
        boolean compile = BatchCompiler.compile("src/main/java/com/github/study/java/CompressTest.java", new PrintWriter(System.out), new PrintWriter(System.err), null);
        System.out.println(compile);
    }
}
