package com.github.study.demo.javapoet;

import com.squareup.javapoet.ClassName;
import com.squareup.javapoet.JavaFile;
import com.squareup.javapoet.MethodSpec;
import com.squareup.javapoet.ParameterSpec;
import com.squareup.javapoet.TypeSpec;

import javax.lang.model.element.Modifier;
import java.io.IOException;

/**
 * CreatedDate: 2020/11/11
 * Author: songjialin
 */
public class Test1 {
    public static void main(String[] args) {
        ClassName activity = ClassName.get("android.app", "Activity");

        TypeSpec.Builder mainActivityBuilder = TypeSpec.classBuilder("MainActivity")
                .addModifiers(Modifier.PUBLIC)
                .superclass(activity);


        ClassName bundle = ClassName.get("android.os", "Bundle");
        ClassName nullable = ClassName.get("android.support.annotation", "Nullable");
        ParameterSpec savedInstanceState = ParameterSpec.builder(bundle, "savedInstanceState")
                .addAnnotation(nullable)
                .build();

        ClassName override = ClassName.get("java.lang", "Override");
        MethodSpec onCreate = MethodSpec.methodBuilder("onCreate")
                .addAnnotation(override)
                .addModifiers(Modifier.PROTECTED)
                .addParameter(savedInstanceState)
                .addStatement("super.onCreate(savedInstanceState)")
                .addStatement("setContentView(R.layout.activity_main)")
                .build();

        TypeSpec mainActivity = mainActivityBuilder.addMethod(onCreate)
                .build();

        JavaFile file = JavaFile.builder("com.test", mainActivity).build();

        try {
            file.writeTo(System.out);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
