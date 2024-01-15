package com.github.study.demo.serialization;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;
import lombok.Data;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.Serializable;

/**
 * CreatedDate: 2020/11/13
 * Author: songjialin
 */
public class KryoTest {
    public static void main(String[] args) throws Exception {
        Kryo kryo = new Kryo();
        Output output = new Output(new FileOutputStream("student.db"));
        kryo.writeObject(output, new Student1());
        output.close();
        Input input = new Input(new FileInputStream("student.db"));
        System.out.println(kryo.readObject(input, Student2.class));
        input.close();
    }

    @Data
    static class Student1 implements Serializable {
        private String name = "yungyu";
        private int age = 1;
        private boolean gender = false;
    }

    @Data
    static class Student2 implements Serializable {
        private int age = 2;
        // private String name = "yungyu2";
        private boolean gender = false;
    }
}
