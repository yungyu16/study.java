package com.github.study.java;

import java.lang.reflect.Method;

/**
 * @author Yungyu
 * @description Created by Yungyu on 2020/7/7.
 */
public class ReflectTest {
    public static void main(String[] args) throws Throwable {
        Method m = Super.class.getMethod("x", boolean.class);
        m.invoke(new Super(), false); // super::primitive
        m.invoke(new Super(), Boolean.FALSE); // super::primitive
        m.invoke(new Sub(), false); // sub::primitive
        m.invoke(new Sub(), Boolean.FALSE); // sub::primitive

        m = Sub.class.getMethod("x", Boolean.class);
        // m.invoke(new Super(), false); // IllegalArgumentException: object is not an instance of declaring class
        m.invoke(new Sub(), false); // sub::boxed
        m.invoke(new Sub(), Boolean.FALSE); // sub::boxed

        // m.invoke(null, false); // NullPointerException
        // m.invoke(new Sub()); // IllegalArgumentException: wrong number of arguments
    }
}

class Super {
    public int x(boolean a) {
        System.out.println("super::primitive");
        return 1;
    }

    public int x(Boolean a) {
        System.out.println("super::boxed");
        return 1;
    }
}

class Sub extends Super {
    public int x(boolean a) {
        System.out.println("sub::primitive");
        return 1;
    }

    public int x(Boolean a) {
        System.out.println("sub::boxed");
        return 1;
    }
}
