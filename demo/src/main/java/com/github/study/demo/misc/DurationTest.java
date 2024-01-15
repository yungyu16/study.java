package com.github.study.demo.misc;

import java.time.Duration;

public class DurationTest {
    public static void main(String[] args) {
        Duration parse = Duration.parse("400");
        System.out.println(parse.getSeconds());
    }
}
