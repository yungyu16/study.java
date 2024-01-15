package com.github.study.demo.misc;

import io.github.classgraph.ClassGraph;
import io.github.classgraph.ClassInfo;
import io.github.classgraph.ScanResult;


/**
 * CreatedDate: 2020/6/24
 * Author: songjialin
 */
public class CsvTest {
    public static void main(String[] args) throws Exception {
        String pkg = "com.github.study.java";
        try (ScanResult scanResult =
                     new ClassGraph()
                             .verbose()                   // Log to stderr
                             .enableAllInfo()             // Scan classes, methods, fields, annotations
                             .acceptPackages(pkg)         // Scan com.xyz and subpackages (omit to scan all packages)
                             .scan()) {                   // Start the scan
            for (ClassInfo routeClassInfo : scanResult.getAllClasses()) {
                System.out.println(routeClassInfo);
            }
        }
    }
}
