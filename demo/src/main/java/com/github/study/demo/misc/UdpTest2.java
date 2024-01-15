package com.github.study.demo.misc;

import com.wf.captcha.GifCaptcha;
import eu.bitwalker.useragentutils.UserAgent;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.zip.ZipInputStream;

/**
 * CreatedDate: 2020/7/15
 * Author: songjialin
 */
public class UdpTest2 {
    public static void main(String[] args) throws Exception {
        UserAgent ua = UserAgent.parseUserAgentString("Mozilla/5.0 (Linux; Android 5.0; SM-G900P Build/LRX21T) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/84.0.4147.125 Mobile Safari/537.36");
        System.out.println(ua.getBrowser());
        System.out.println(ua.getBrowserVersion());
        System.out.println(ua.getOperatingSystem());
        System.out.println(ua.getId());
        System.out.println(ua);
        GifCaptcha specCaptcha = new GifCaptcha(150, 75, 5);
        System.out.println(specCaptcha.text());
        System.out.println(specCaptcha.toBase64());


        ZipInputStream zipInputStream = new ZipInputStream(Files.newInputStream(Paths.get("C:\\Users\\songjialin\\Desktop", "hello.zip")));
        System.out.println(zipInputStream.getNextEntry());
    }
}
