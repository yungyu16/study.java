package com.github.study.demo.javassit;

import javassist.ClassPool;
import javassist.CtClass;

/**
 * CreatedDate: 2020/11/11
 * Author: songjialin
 */
public class Test2 {
    public static void main(String[] args) throws Exception {
        ClassPool classPool = ClassPool.getDefault();
        CtClass ctClass = classPool.get("");
    }
}
