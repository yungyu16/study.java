package com.github.study.demo.spring;

import org.springframework.core.annotation.AliasFor;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

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
