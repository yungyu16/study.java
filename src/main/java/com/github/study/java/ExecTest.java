package com.github.study.java;

import org.apache.commons.exec.CommandLine;
import org.apache.commons.exec.DefaultExecutor;

import java.io.IOException;

/**
 * CreatedDate: 2020/6/24
 * Author: songjialin
 */
public class ExecTest {
    public static void main(String[] args) throws IOException {
        String cmdStr = "ping www.baidu.com -t";
        final CommandLine cmdLine = CommandLine.parse(cmdStr);
        DefaultExecutor executor = new DefaultExecutor();
        int exitValue = executor.execute(cmdLine);
    }
}
