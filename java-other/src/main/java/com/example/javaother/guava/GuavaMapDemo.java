package com.example.javaother.guava;

import com.google.common.collect.ImmutableMap;

import java.util.Map;

public class GuavaMapDemo {
    public static void main(String[] args) {
        Map<String, Integer> map = ImmutableMap.of("a", 1, "b", 2);
        map.put("c", 3);
    }
}
