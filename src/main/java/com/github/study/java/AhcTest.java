package com.github.study.java;

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
}
