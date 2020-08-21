package com.github.study.java;

import org.asynchttpclient.Dsl;
import org.asynchttpclient.Request;
import org.asynchttpclient.Response;

import java.util.concurrent.ExecutionException;

/**
 * CreatedDate: 2020/8/20
 * Author: songjialin
 */
public class AhcTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Request build = Dsl.get("https://www.baidu.com").build();
        Response response = Dsl.asyncHttpClient().executeRequest(build).get();
        System.out.println(response.getResponseBody());
    }
}
