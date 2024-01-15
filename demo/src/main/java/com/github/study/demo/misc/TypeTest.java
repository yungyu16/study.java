package com.github.study.demo.misc;

import sun.jvm.hotspot.utilities.Assert;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.Arrays;
import java.util.List;

/**
 * CreatedDate: 2020/9/9
 * Author: songjialin
 */
public class TypeTest<K extends Comparable & Serializable, V> {
    K key;
    V value;

    public static void main(String[] args) throws Exception {
        Test.main(args);
        System.out.println("=====================");

        // 获取字段的类型
        Field fk = TypeTest.class.getDeclaredField("key");
        Field fv = TypeTest.class.getDeclaredField("value");
        Class<?> type1 = fk.getType();
        Class<?> type2 = fv.getType();
        System.out.println(type1);
        System.out.println(type2);
        Assert.that(fk.getGenericType() instanceof TypeVariable, "必须为TypeVariable类型");
        Assert.that(fv.getGenericType() instanceof TypeVariable, "必须为TypeVariable类型");
        TypeVariable keyType = (TypeVariable) fk.getGenericType();
        TypeVariable valueType = (TypeVariable) fv.getGenericType();
        // getName 方法
        System.out.println(keyType.getName());                 // K
        System.out.println(valueType.getName());               // V
        // getGenericDeclaration 方法
        System.out.println(keyType.getGenericDeclaration());   // class com.test.TypeTest
        System.out.println(valueType.getGenericDeclaration()); // class com.test.TypeTest
        // getBounds 方法
        System.out.println("K 的上界:");                        // 有两个
        for (Type type : keyType.getBounds()) {                // interface java.lang.Comparable
            System.out.println(type);                          // interface java.io.Serializable
        }
        System.out.println("V 的上界:");                        // 没明确声明上界的, 默认上界是 Object
        for (Type type : valueType.getBounds()) {              // class java.lang.Object
            System.out.println(type);
        }
    }
}

class Test<T> {
    public static void main(String[] args) {
        Method method = Arrays.stream(Test.class.getDeclaredMethods()).filter(it -> it.getName().equals("show"))
                .findAny().orElseThrow(NullPointerException::new);
        // public void com.test.Test.show(java.util.List[],java.lang.Object[],java.util.List,java.lang.String[],int[])
        System.out.println(method);
        Type[] types = method.getGenericParameterTypes();  // 这是 Method 中的方法
        for (Type type : types) {
            System.out.println(type.getClass());
            System.out.println(type instanceof GenericArrayType);
        }
    }

    public void show(List<String>[] pTypeArray, T[] vTypeArray, List<String> list, String[] strings, int[] ints) {
    }
}
