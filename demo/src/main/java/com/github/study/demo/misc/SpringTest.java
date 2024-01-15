package com.github.study.demo.misc;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;

import java.io.IOException;

/**
 * CreatedDate: 2020/7/3
 * Author: songjialin
 */

@Configuration
public class SpringTest {
    public static void main(String[] args) throws IOException {
        DefaultResourceLoader defaultResourceLoader = new DefaultResourceLoader();
        Resource resource = defaultResourceLoader.getResource("classpath:com\\github\\study\\java\\AsmTest.class");
        System.out.println(resource.getFile());
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        ctx.register(SpringTest.class);
        ctx.refresh();
        MxBeanTest bean = ctx.getBean(MxBeanTest.class);
        System.out.println(bean);
    }
}
