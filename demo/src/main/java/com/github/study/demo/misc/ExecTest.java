package com.github.study.demo.misc;

import org.apache.commons.exec.CommandLine;
import org.apache.commons.exec.DefaultExecutor;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * CreatedDate: 2020/6/24
 * Author: songjialin
 */
public class ExecTest {
    public static void main(String[] args) throws IOException, InterruptedException {
        String cmdStr = "ping www.baidu.com -t";
        final CommandLine cmdLine = CommandLine.parse(cmdStr);
        DefaultExecutor executor = new DefaultExecutor();
//        int exitValue = executor.execute(cmdLine);

        Thread thread = Thread.currentThread();
        thread.interrupt();
        System.out.println(thread.isInterrupted());

        TimeUnit.SECONDS.sleep(10);


    }

    public class InnerTest {

    }
}
