package com.github.study.demo.misc;

import com.github.study.demo.util.JSONs;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

/**
 * CreatedDate: 2020/6/24
 * Author: songjialin
 */
@Slf4j
public class SystemPropTest {
    public static void main(String[] args) {
        String props = JSONs.writeValueAsString(System.getProperties(), true);
        log.info(props);
        System.out.println(StringUtils.repeat("=", 80));
        String envs = JSONs.writeValueAsString(System.getenv(), true);
        log.info(envs);

    }
}
