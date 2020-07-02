package com.github.study.java;

import java.lang.management.*;
import java.util.List;

/**
 * CreatedDate: 2020/7/2
 * Author: songjialin
 */
public class MxBeanTest {
    public static void main(String[] args) {
        List<MemoryPoolMXBean> memoryPoolMXBeans = ManagementFactory.getMemoryPoolMXBeans();
        ClassLoadingMXBean classLoadingMXBean = ManagementFactory.getClassLoadingMXBean();
        CompilationMXBean compilationMXBean = ManagementFactory.getCompilationMXBean();
        List<GarbageCollectorMXBean> garbageCollectorMXBeans = ManagementFactory.getGarbageCollectorMXBeans();
        garbageCollectorMXBeans.forEach(it -> System.out.println(it.getName() + ":" + it.getMemoryPoolNames()));
        OperatingSystemMXBean operatingSystemMXBean = ManagementFactory.getOperatingSystemMXBean();
        MemoryMXBean memoryMXBean = ManagementFactory.getMemoryMXBean();
        ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();
    }
}
