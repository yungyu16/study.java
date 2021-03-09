package com.github.study.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.File;
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
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\songjialin\\Desktop\\chromedriver.exe");        // 1.创建webdriver驱动
        ChromeDriverService service = new ChromeDriverService.Builder()
                .usingDriverExecutable(new File("C:\\Users\\songjialin\\Desktop\\chromedriver.exe"))
                .usingAnyFreePort()
                .build();
        service.start();
        ChromeOptions options = new ChromeOptions();
        options.setHeadless(true);
        options.setCapability("javascriptEnabled", true);
        WebDriver driver = new RemoteWebDriver(service.getUrl(), new ChromeOptions());
        driver.get("https://hddt.pingan.com/manager/index.html#/login");
        System.out.println(driver.getCurrentUrl());
        System.out.println(driver.getTitle());
        System.out.println(driver.getPageSource());
        System.out.println(driver.findElement(By.id("loginName")));
    }
}
