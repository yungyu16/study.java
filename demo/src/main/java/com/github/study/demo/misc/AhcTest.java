package com.github.study.demo.misc;

import com.sun.tools.attach.VirtualMachine;
import okio.Timeout;
import org.asynchttpclient.Dsl;
import org.asynchttpclient.Request;
import org.asynchttpclient.Response;

import java.io.IOException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * CreatedDate: 2020/8/20
 * Author: songjialin
 */
public class AhcTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException, IOException {
        Request build = Dsl.get("https://www.baidu.com").build();
        Response response = Dsl.asyncHttpClient().executeRequest(build).get();
        System.out.println(response.getResponseBody());
        Timeout timeout = new Timeout();
        timeout.timeout(5, TimeUnit.SECONDS);
        timeout.throwIfReached();

        Exception exception = new Exception();
        fill(exception);
        exception.printStackTrace();

    }

    private static void fill(Exception exception) {
        exception.fillInStackTrace();
        exception.addSuppressed(new NullPointerException("111"));
        exception.addSuppressed(new NullPointerException("222"));
        exception.initCause(new NullPointerException("3333"));
    }

    public static void test(String[] args) throws Exception {
        String pid = "12345"; // 12345改成你想attach的java进程id
        String agentPath = "/path_to_agent"; // path_to_agent为你编译的agent的路径
        VirtualMachine virtualMachine = com.sun.tools.attach.VirtualMachine.attach(pid);
        virtualMachine.loadAgentPath(agentPath, null);
        virtualMachine.detach();
    }
}
