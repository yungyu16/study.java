package com.github.study.java;

import javax.tools.DocumentationTool;
import javax.tools.JavaCompiler;
import javax.tools.ToolProvider;
import java.io.IOException;

/**
 * CreatedDate: 2020/6/24
 * Author: songjialin
 */
public class CompilerTest {
    public static final String SRC_FILE = "src/main/java/com/github/study/java/AsmTest.java";

    public static void main(String[] args) throws IOException {
        JavaCompiler systemJavaCompiler = ToolProvider.getSystemJavaCompiler();
        DocumentationTool systemDocumentationTool = ToolProvider.getSystemDocumentationTool();
        int retCode = systemDocumentationTool.run(System.in, System.out, System.err);
        System.out.println(retCode);
        retCode = systemJavaCompiler.run(System.in, System.out, System.err, SRC_FILE);
        System.out.println(retCode);
    }
}
