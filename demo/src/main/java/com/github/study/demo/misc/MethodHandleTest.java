package com.github.study.demo.misc;

public class MethodHandleTest {
    public static void main(String[] args) throws Throwable {
//        MethodType mt = MethodType.methodType(int.class, Boolean.class);
//        MethodHandles.Lookup lookup = MethodHandles.lookup();
//
//        MethodHandle mh = MethodHandles.lookup().findVirtual(MHSuper.class, "x", mt);
//        PolymorphicSignature         mh.
//        Object a;
////        mh.bindTo(null).invoke(false); // NullPointerException
////        mh.invoke(false); // WrongMethodTypeException: cannot convert MethodHandle(MHSuper,Boolean)int to (boolean)void
////        mh.bindTo(new Object()).invoke(false); // ClassCastException: Cannot cast java.lang.Object to MHSuper
//        mh.bindTo(new MHSuper()).invoke(false); // super::boxed
//        mh.bindTo(new MHSuper()).invoke(Boolean.FALSE); // super::boxed
//        a = (int)mh.bindTo(new MHSuper()).invokeExact(Boolean.FALSE); // super::boxed
////        a = (Number)mh.bindTo(new MHSuper()).invokeExact(Boolean.FALSE); // WrongMethodTypeException: expected (Boolean)int but found (Boolean)Number
////        a = (Integer)mh.bindTo(new MHSuper()).invokeExact(Boolean.FALSE); // WrongMethodTypeException: expected (Boolean)int but found (Boolean)Integer
////        mh.bindTo(new MHSuper()).invokeExact(Boolean.FALSE); // WrongMethodTypeException: expected (Boolean)int but found (Boolean)void
//
//        mh.bindTo(new MHSub()).invoke(false); // sub::boxed
//        mh.bindTo(new MHSub()).invoke(Boolean.FALSE); // sub::boxed
//        a = (int)mh.bindTo(new MHSub()).invokeExact(Boolean.FALSE); // sub::boxed
//        MethodHandles.Lookup
//        mh = MethodHandles.lookup().findStatic(MHSuper.class, "y", mt);
//        mh.invoke(false); // super::static
//        a = (int)mh.invokeExact(Boolean.FALSE); // super::static
//
//        mh = MethodHandles.lookup().findStatic(MHSuper.class, "z", MethodType.methodType(int.class, MHSuper.class));
//        MHSuper sup = new MHSub();
//        a = (int)mh.invokeExact(sup); // class MHSub
////        MHSub sub = new MHSub();a = (int)mh.invokeExact(sub); // WrongMethodTypeException: expected (MHSuper)int but found (MHSub)int
//
    }
}

class MHSuper {
    public static int y(Boolean a) {
        System.out.println("super::static");
        return 1;
    }

    public static int z(MHSuper a) {
        System.out.println(a.getClass());
        return 1;
    }

    public int x(boolean a) {
        System.out.println("super::primitive");
        return 1;
    }

    public int x(Boolean a) {
        System.out.println("super::boxed");
        return 1;
    }
}

class MHSub extends MHSuper {
    public static int y(Boolean a) {
        System.out.println("sub::static");
        return 1;
    }

    public int x(boolean a) {
        System.out.println("sub::primitive");
        return 1;
    }

    public int x(Boolean a) {
        System.out.println("sub::boxed");
        return 1;
    }
}
