package com.github.study.retrofit;

import retrofit2.http.GET;

/**
 * CreatedDate: 2020/9/30
 * Author: songjialin
 */
public interface Test {
    @GET("/")
    String main();
}
