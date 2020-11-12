package com.github.study.spring;

import org.springframework.core.annotation.AliasFor;

import java.lang.annotation.*;

/**
 * CreatedDate: 2020/11/12
 * Author: songjialin
 */
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface A {
    @AliasFor("str")
    String value() default "";

    @AliasFor("value")
    String str() default "";
}
