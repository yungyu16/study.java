package com.github.study.demo.misc;

import org.luaj.vm2.Globals;
import org.luaj.vm2.LuaValue;
import org.luaj.vm2.lib.jse.JsePlatform;

/**
 * CreatedDate: 2020/7/7
 * Author: songjialin
 */
public class LuajTest {
    public static void main(String[] args) {
        String luaStr = "print 'hello,world!'";
        Globals globals = JsePlatform.standardGlobals();
        LuaValue chunk = globals.load(luaStr);
        chunk.call();
    }
}
