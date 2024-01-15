package com.github.study.demo.serialization;

import io.protostuff.LinkedBuffer;
import io.protostuff.ProtobufIOUtil;
import io.protostuff.Schema;
import io.protostuff.runtime.RuntimeSchema;

/**
 * CreatedDate: 2020/11/13
 * Author: songjialin
 */
public class Protostuff {
    public static void main(String[] args) throws InstantiationException, IllegalAccessException {
        byte[] bytes = toBytes("hello world");
        System.out.println(fromBytes(bytes, String.class));
    }

    private static byte[] toBytes(Object o) {
        Schema schema = RuntimeSchema.getSchema(o.getClass());
        return ProtobufIOUtil.toByteArray(o, schema, LinkedBuffer.allocate(256));
    }

    private static <T> T fromBytes(byte[] bytes, Class<T> clazz) throws IllegalAccessException, InstantiationException {
        Schema schema = RuntimeSchema.getSchema(clazz);
        T t = clazz.newInstance();
        ProtobufIOUtil.mergeFrom(bytes, t, schema);
        return t;
    }
}
