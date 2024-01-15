package com.github.study.demo.system;

import javax.script.Compilable;
import javax.script.CompiledScript;
import javax.script.Invocable;
import javax.script.ScriptContext;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineFactory;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

/**
 * CreatedDate: 2020/11/17
 * Author: songjialin
 */
public class ScriptEnginTest {
    public static final Pattern REGISTRY_SPLIT_PATTERN = Pattern
            .compile("\\s*[|;]+\\s*");

    public static void main(String[] args) throws ScriptException, IOException, NoSuchMethodException {
        Arrays.stream(REGISTRY_SPLIT_PATTERN.split("aa; bb;   cc"))
                .forEach(it -> System.out.println(it));

        ScriptEngineManager manager = new ScriptEngineManager();
        // 得到所有的脚本引擎工厂
        List<ScriptEngineFactory> engineFactories = manager.getEngineFactories();
        // 这是Java SE 5 和Java SE 6的新For语句语法

        for (ScriptEngineFactory factory : engineFactories) {
            // 打印脚本信息
            System.out.printf("Name: %s%n" +
                            "Version: %s%n" +
                            "Language name: %s%n" +
                            "Language version: %s%n" +
                            "Extensions: %s%n" +
                            "Mime types: %s%n" +
                            "Names: %s%n",
                    factory.getEngineName(),
                    factory.getEngineVersion(),
                    factory.getLanguageName(),
                    factory.getLanguageVersion(),
                    factory.getExtensions(),
                    factory.getMimeTypes(),
                    factory.getNames());
            System.out.println("=====================================");
            // 得到当前的脚本引擎
            ScriptEngine engine = factory.getScriptEngine();
        }
        ScriptEngine js = manager.getEngineByExtension("js");
        js.getContext().setAttribute("i", 0, ScriptContext.GLOBAL_SCOPE);
        System.out.println(js.eval("print(new Date())"));
        System.out.println(js.eval("i++"));
        System.out.println(js.eval("print(new Date())"));
        System.out.println(js.eval("i++"));
        Path path = null;
        assert path != null;
        String code = String.join("\n", Files.readAllLines(path));
        js.eval(code);

        System.out.println(((Invocable) js).invokeFunction("hello", "+852 6569-8900"));
        System.out.println(((Invocable) js).invokeFunction("hello", "+852 6569-8900"));

        Compilable jsc = (Compilable) js;
        CompiledScript compile = jsc.compile(code);
    }
}
