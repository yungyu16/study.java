package jol;

import org.junit.Test;
import org.openjdk.jol.info.ClassLayout;

import java.io.PrintStream;

/**
 * CreatedDate: 2020/6/30
 * Author: songjialin
 */
public class Test1 {
    A a = new A();
    PrintStream out = System.out;

    @Test
    public void name() throws InterruptedException {
        Thread.sleep(5000);
        out.println("befre lock");
        out.println(ClassLayout.parseInstance(a).toPrintable());//无锁

        Thread t1 = new Thread() {
            public void run() {
                synchronized (a) {
                    try {
                        Thread.sleep(5000);
                        System.out.println("t1 release");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        t1.start();
        Thread.sleep(1000);
        out.println("t1 lock ing");
        out.println(ClassLayout.parseInstance(a).toPrintable());//轻量锁
        sync();
        out.println("after lock");
        out.println(ClassLayout.parseInstance(a).toPrintable());//重量锁
        System.gc();
        out.println("after gc()");
        out.println(ClassLayout.parseInstance(a).toPrintable());//无锁---gc
    }


    public void sync() throws InterruptedException {
        synchronized (a) {
            System.out.println("t1 main lock");
            out.println(ClassLayout.parseInstance(a).toPrintable());//重量锁
        }
    }

    class A {

    }
}
