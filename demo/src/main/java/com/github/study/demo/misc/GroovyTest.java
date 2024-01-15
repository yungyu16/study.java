package com.github.study.demo.misc;

import groovy.lang.Binding;
import groovy.lang.GroovyClassLoader;
import groovy.lang.GroovyShell;
import groovy.lang.Script;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

/**
 * CreatedDate: 2020/7/8
 * Author: songjialin
 */
public class GroovyTest {
    public static void main(String[] args) {
        Binding binding = new Binding() {
            @Override
            public Object invokeMethod(String name, Object args) {
                System.out.println(name);
                System.out.println("呵呵");
                System.out.println(args);
                return 1;
            }
        };
        GroovyShell shell = new GroovyShell();
        shell.setVariable("test", "hahahah");
        Script parse = shell.parse("int a=1;println(test);");
        parse.printf("he", 2);
        parse.run();
        GroovyClassLoader groovyClassLoader = new GroovyClassLoader();
        ScriptEngineManager factory = new ScriptEngineManager();
        ScriptEngine engine = factory.getEngineByName("groovy");
    }
}
