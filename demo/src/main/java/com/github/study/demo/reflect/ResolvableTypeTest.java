package com.github.study.demo.reflect;

import org.springframework.core.ResolvableType;

import java.util.HashMap;

/**
 * CreatedDate: 2021/2/2
 * Author: songjialin
 */
public class ResolvableTypeTest extends HashMap<String, String> {
    public static void main(String[] args) {
        ResolvableType resolvableType = ResolvableType.forClass(ResolvableTypeTest.class);
        System.out.println(resolvableType.getGeneric(1, 1).resolve());
    }
}
