package com.github.study.java;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/**
 * CreatedDate: 2020/7/20
 * Author: songjialin
 */
public class MapTest {
    public static void main(String[] args) {
        LinkedHashMap<String, Integer> linkedHashMap = new LinkedHashMap<>();
        final Set<Map.Entry<String, Integer>> entries = linkedHashMap.entrySet();
        entries.iterator();
    }
}
