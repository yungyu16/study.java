package com.github.study.demo.mapstruct;

import io.protostuff.GraphIOUtil;
import io.protostuff.LinkedBuffer;
import io.protostuff.runtime.RuntimeSchema;

public class ProtostuffTest2 {
    public static void main(String[] args) {
        ResponseV2 responseV2 = new ResponseV2();
        Target target = new Target(999);
        responseV2.setTarget1(target);
        responseV2.setTarget2(target);
        responseV2.setPadding(new Padding());
        responseV2.setFoo(new FooV2(new Padding(), new Padding()));
        byte[] bytes = GraphIOUtil.toByteArray(responseV2, RuntimeSchema.getSchema(ResponseV2.class), LinkedBuffer.allocate());
        ResponseV1 responseV1 = new ResponseV1();
        GraphIOUtil.mergeFrom(bytes, responseV1, RuntimeSchema.getSchema(ResponseV1.class));
        System.out.println(responseV1.getTarget2().getState());
//        ResponseV2 responseV21 = ResponseMapping.INSTANCE.convertDetailCore(responseV1);
//        Target target2 = responseV21.getTarget2();
//        System.out.println(target2.getState());
    }
}



