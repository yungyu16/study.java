package com.github.study.java;

import io.leego.banana.BananaUtils;
import oshi.SystemInfo;

/**
 * CreatedDate: 2020/9/9
 * Author: songjialin
 */
public class BananaTest {
    public static void main(String[] args) {
        System.out.println(BananaUtils.bananaify("Hello, Banana!"));
        SystemInfo systemInfo = new SystemInfo();
        System.out.println(systemInfo.getOperatingSystem());
        System.out.println(systemInfo.getHardware());
    }
}
