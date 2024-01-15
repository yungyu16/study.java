package com.github.study.demo.jsoup;

import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.stream.Collectors;

/**
 * @description Created on 2021/5/9.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        OkHttpClient client = new OkHttpClient();
        Files.walk(Paths.get("C:\\Desktop\\衣服"))
                .filter(it -> it.getFileName().endsWith("img.txt"))
                .forEach(path -> {
                    System.out.println(path);
                    try {
                        Files.lines(path)
                                .collect(Collectors.toSet())
                                .forEach(url -> {
                                    Request request = new Request.Builder()
                                            .url(url)
                                            .build();
                                    try {
                                        byte[] imgBytes = client.newCall(request).execute().body().bytes();
                                        HttpUrl httpUrl = request.url();
                                        System.out.println("开始下载：" + httpUrl);
                                        Path imgPath = path.resolveSibling("img");
                                        if (!Files.exists(imgPath)) {
                                            Files.createDirectory(imgPath);
                                        }
                                        Files.write(path.resolveSibling("img/" + httpUrl.pathSegments().get(httpUrl.pathSize() - 1)), imgBytes, StandardOpenOption.CREATE_NEW);
                                    } catch (IOException e) {
                                        e.printStackTrace();
                                    }
                                });
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                });
    }
}
