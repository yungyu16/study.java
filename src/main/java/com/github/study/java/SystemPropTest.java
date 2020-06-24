package com.github.study.java;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

/**
 * CreatedDate: 2020/6/24
 * Author: songjialin
 */
@Slf4j
public class SystemPropTest {
    public static void main(String[] args) {
        System.getProperties().forEach((key, value) -> log.info("{} : {}", key, value));
        System.out.println(StringUtils.repeat("=", 80));
        System.getenv().forEach((key, value) -> log.info("{} : {}", key, value));
    }
}
