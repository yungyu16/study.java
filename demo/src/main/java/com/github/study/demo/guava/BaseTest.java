package com.github.study.demo.guava;

import com.google.common.base.CharMatcher;
import com.google.common.base.Splitter;
import com.google.common.net.InternetDomainName;
import okhttp3.OkHttpClient;
import okhttp3.Request;

import java.io.IOException;

/**
 * CreatedDate: 2021/1/26
 * Author: songjialin
 */
public class BaseTest {
    public static void main(String[] args) throws IOException {
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .build();
        System.out.println(okHttpClient.newCall(new Request.Builder().url("https://httpbin.org/get").build())
                .execute()
                .body()
                .string());
        System.out.println("");
    }

    private static void test2() {
        InternetDomainName from = InternetDomainName.from("www.50lion.com");
        System.out.println(from.publicSuffix());
        System.out.println(from.isPublicSuffix());
    }

    private static void charMatcher() {
        CharMatcher charMatcher = CharMatcher.anyOf("$");
        System.out.println(charMatcher.collapseFrom("a$b", '1'));
        System.out.println(charMatcher.retainFrom("1$1$1 1 1 1 1 1 1 "));
        System.out.println(charMatcher.trimFrom("$1$"));
        System.out.println(Splitter.on(',').trimResults(CharMatcher.is('_')).split("_a ,_b_ ,c__"));
    }
}
