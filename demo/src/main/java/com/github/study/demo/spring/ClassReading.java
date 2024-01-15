package com.github.study.demo.spring;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.ClassMetadata;
import org.springframework.core.type.MethodMetadata;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.SimpleMetadataReaderFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.MultiValueMap;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.util.Set;

/**
 * CreatedDate: 2020/11/12
 * Author: songjialin
 */
@B
public class ClassReading {
    public static void main(String[] args) throws IOException {
        A annotation = AnnotationUtils.findAnnotation(ClassReading.class, A.class);
        System.out.println(annotation.str());
        B annotationsByType = ClassReading.class.getAnnotation(B.class);
        Class<? extends Annotation> aClass = annotationsByType.annotationType();
        Class<? extends B> aClass1 = annotationsByType.getClass();
        System.out.println("aClass == aClass1:" + (aClass == aClass1));
        StringBuilder sb = new StringBuilder();
        sb.append("均无").append(",");
        System.out.println(sb.substring(0, sb.length() - 1));
        SimpleMetadataReaderFactory simpleMetadataReaderFactory = new SimpleMetadataReaderFactory();
        MetadataReader metadataReader1 = simpleMetadataReaderFactory.getMetadataReader(ClassReading.class.getName());
        AnnotationMetadata annotationMetadata1 = metadataReader1.getAnnotationMetadata();
        System.out.println(annotationMetadata1.getAllAnnotationAttributes(A.class.getName()));
        System.out.println(annotationMetadata1.getAnnotationAttributes(A.class.getName()));


        System.out.println("===============================");
        System.out.println("===============================");
        System.out.println("===============================");
        MetadataReader metadataReader = simpleMetadataReaderFactory.getMetadataReader("org.springframework.boot.autoconfigure.admin.SpringApplicationAdminJmxAutoConfiguration");
        AnnotationMetadata annotationMetadata = metadataReader.getAnnotationMetadata();
        ClassMetadata classMetadata = metadataReader.getClassMetadata();
        Set<MethodMetadata> annotatedMethods = annotationMetadata.getAnnotatedMethods("org.springframework.context.annotation.Bean");
        System.out.println(annotationMetadata.getAnnotationTypes());
        System.out.println(annotationMetadata.getMetaAnnotationTypes(Configuration.class.getName()));
        System.out.println(annotationMetadata.hasMetaAnnotation(Component.class.getName()));
        System.out.println(annotatedMethods);
        System.out.println(classMetadata.getClassName());
        MultiValueMap<String, Object> allAnnotationAttributes = annotationMetadata.getAllAnnotationAttributes(Component.class.getName());
        System.out.println(allAnnotationAttributes);
    }
}
