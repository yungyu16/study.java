package com.github.study.demo.serialization;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.msgpack.MessagePack;
import org.msgpack.annotation.Message;
import org.msgpack.type.Value;

import java.io.IOException;
import java.util.Arrays;

/**
 * CreatedDate: 2020/11/13
 * Author: songjialin
 */
public class MsgPack {
    public static void main(String[] args) throws IOException {
        MessagePack messagePack = new MessagePack();
        byte[] hahahs = messagePack.write("hahah");
        System.out.println(messagePack.read(hahahs, String.class));
        byte[] hahhas = messagePack.write(new Demo(11, "hahha"));
        Value read = messagePack.read(hahhas);
        Arrays.stream(read.asArrayValue().getElementArray()).forEach(it -> it.toString());
        System.out.println(read.getType());
    }

    @Message
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    static class Demo {
        private int age;
        private String name;
    }
}
