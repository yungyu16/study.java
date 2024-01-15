package com.github.study.demo.selenium;

import com.google.common.base.CharMatcher;

import java.io.IOException;

/**
 * @Description: 通过selenium操作浏览器打开百度进行搜索
 * selenium版本：3.12.0； 通过maven管理jar包
 * 开发工具：IDEA
 * jdk：1.8
 * 浏览器：chrome 75+
 * @Author: ggf
 * @Date: 2020/03/22
 */
public class BaiduSearch {
    public static void main(String[] args) throws InterruptedException, IOException {
        String cookie = "Cookie: JSESSIONID=0AA3A7CB1C0069B67DE10407E6B61350; BIGipServerPOOL_PACLOUD_PRDR2019120306422=428188119.42107.0000\n";
        System.out.println(cookie.trim());
        System.out.println(cookie.trim().charAt(cookie.trim().length() - 1));
        System.out.println("---");
        System.out.println(CharMatcher.whitespace().removeFrom(cookie));

    }
}
