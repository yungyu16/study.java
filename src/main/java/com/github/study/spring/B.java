package com.github.study.spring;

import org.springframework.stereotype.Component;

import java.lang.annotation.*;

/**
 * CreatedDate: 2020/11/12
 * Author: songjialin
 */
@A(value = "B", str = "B")
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Component
public @interface B {
}
