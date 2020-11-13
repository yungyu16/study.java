package com.github.study.serialization;

import org.msgpack.MessagePack;

import java.io.IOException;

/**
 * CreatedDate: 2020/11/13
 * Author: songjialin
 */
public class MsgPack {
    public static void main(String[] args) throws IOException {
        MessagePack messagePack = new MessagePack();
        byte[] hahahs = messagePack.write("hahah");
        System.out.println(messagePack.read(hahahs, String.class));
    }
}
