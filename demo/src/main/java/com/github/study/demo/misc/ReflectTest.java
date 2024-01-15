package com.github.study.demo.misc;

import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Method;

/**
 * @author Yungyu
 * @description Created by Yungyu on 2020/7/7.
 */
public class ReflectTest {
    public static void main(String[] args) throws Throwable {
        Method method = ReflectionUtils.findMethod(Super.class, "test");
        ReflectionUtils.makeAccessible(method);
        method.invoke(new Sub(), null);
    }
}

class Super {
    private void test() {
        System.out.println("test");
    }
}

class Sub extends Super {

}
