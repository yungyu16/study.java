package com.github.study.demo.reflect;

import com.google.common.reflect.TypeParameter;
import com.google.common.reflect.TypeToken;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.core.type.ClassMetadata;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.SimpleMetadataReaderFactory;
import org.springframework.util.ReflectionUtils;

import java.io.IOException;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @description Created on 2021/1/28.
 */
public class TestMap<T extends InitializingBean & Serializable> extends HashMap<String, T> {
    public static void main(String[] args) throws IOException, NoSuchFieldException {
        Object obj = new Object();
        TypeToken<List<String>> stringListTok = new TypeToken<List<String>>() {
            @Override
            public boolean equals(@Nullable Object o) {
                System.out.println(obj);
                return super.equals(o);
            }
        };
        TypeParameter typeParameter = new TypeParameter() {
        };
        MetadataReader metadataReader = new SimpleMetadataReaderFactory().getMetadataReader(TestMap.class.getName());
        ClassMetadata classMetadata = metadataReader.getClassMetadata();
        String enclosingClassName = classMetadata.getEnclosingClassName();
        System.out.println(enclosingClassName);
        System.out.println("============================");
        Field f = ReflectionUtils.findField(B.class, "list");
        System.out.println(f.toGenericString());
        Type type = f.getGenericType();
        System.out.println(type.getClass());
        Type typeVar = ((ParameterizedType) type).getActualTypeArguments()[0];
        System.out.println(typeVar.getClass());
        System.out.println(Arrays.toString(((TypeVariable) typeVar).getBounds()));

        System.out.println(type.getTypeName());
        System.out.println(A.class.getDeclaredField("list").getGenericType().getTypeName());
        System.out.println("============================");
        System.out.println("============================");

    }

    private <T extends InitializingBean> T hello() {
        return null;
    }
}