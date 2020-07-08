package com.github.study.java;

import groovy.lang.Binding;
import groovy.lang.GroovyClassLoader;
import groovy.lang.GroovyShell;
import groovy.lang.Script;

/**
 * CreatedDate: 2020/7/8
 * Author: songjialin
 */
public class GroovyTest {
    public static void main(String[] args) {
        Binding binding = new Binding();
        GroovyShell shell = new GroovyShell();
        shell.setVariable("test", "hahahah");
        Script parse = shell.parse("int a=1;println(test)");
        parse.printf("he", 2);
        parse.run();
        GroovyClassLoader groovyClassLoader = new GroovyClassLoader();


    }
}
