package com.github.study.demo.guava;

import io.protostuff.GraphIOUtil;
import io.protostuff.LinkedBuffer;
import io.protostuff.Tag;
import io.protostuff.runtime.RuntimeSchema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.NullValueMappingStrategy;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.factory.Mappers;

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
        //System.out.println(responseV1.getTarget2().getState());
        ResponseV2 responseV21 = ResponseMapping.INSTANCE.convertDetailCore(responseV1);
        Target target2 = responseV21.getTarget2();
        int state = target2.getState();
        System.out.println(state);
    }
}

@Mapper(
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS,
        nullValueMappingStrategy = NullValueMappingStrategy.RETURN_DEFAULT,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE
)
interface ResponseMapping {
    ResponseMapping INSTANCE = Mappers.getMapper(ResponseMapping.class);

    ResponseV2 convertDetailCore(ResponseV1 responseV1);
}

@Data
@NoArgsConstructor
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
@NoArgsConstructor
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
@NoArgsConstructor
@AllArgsConstructor
class FooV2 {
    @Tag(1)
    private Padding state1;
    @Tag(2) //新增复杂类型字段
    private Padding state2;
}

@Data
@NoArgsConstructor
@AllArgsConstructor
class FooV1 {
    @Tag(1)
    private Padding state1;
}

@Data
class Padding {

}

@Data
@NoArgsConstructor
@AllArgsConstructor
class Target {
    @Tag(1)
    private int state;
}