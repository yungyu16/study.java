package com.github.study.demo.javapoet;

import io.protostuff.GraphIOUtil;
import io.protostuff.LinkedBuffer;
import io.protostuff.Tag;
import io.protostuff.runtime.RuntimeSchema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

public class ProtostuffTest2 {
    public static void main(String[] args) {
        ResponseV2 responseV2 = new ResponseV2();
        Target target = new Target(999);
        responseV2.setTarget1(target); //重复对象
        responseV2.setTarget2(target); //重复对象
        responseV2.setPadding(new Padding());
        responseV2.setFoo(new FooV2(new Padding(), new Padding()));
        byte[] bytes = GraphIOUtil.toByteArray(responseV2, RuntimeSchema.getSchema(ResponseV2.class), LinkedBuffer.allocate());
        ResponseV1 responseV1 = new ResponseV1();
        GraphIOUtil.mergeFrom(bytes, responseV1, RuntimeSchema.getSchema(ResponseV1.class));
        int state = responseV1.getTarget2().getState();
        System.out.println(state);
    }
}

@Data
class ResponseV1 {
    @Tag(2)
    private FooV1 foo;
    @Tag(5)
    private Target target1;
    @Tag(7)
    private Padding padding;
    @Tag(10)
    private Target target2;
}

@Data
class ResponseV2 {
    @Tag(2)
    private FooV2 foo;
    @Tag(5)
    private Target target1;
    @Tag(7)
    private Padding padding;
    @Tag(10)
    private Target target2;
}

@Data
@AllArgsConstructor
class FooV2 {
    @Tag(1)
    private Padding state1;
    @Tag(2) //新增复杂类型字段
    private Padding state2;
}

@Data
@AllArgsConstructor
class FooV1 {
    @Tag(1)
    private Padding state1;
}

@Data
@AllArgsConstructor
class Padding {

}

@Data
@RequiredArgsConstructor
class Target {
    @Tag(1)
    long a;
    @Tag(2)
    long b;
    @Tag(3)
    long c;
    @Tag(4)
    final int state;
}