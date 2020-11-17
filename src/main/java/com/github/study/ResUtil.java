package com.github.study;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;

/**
 * CreatedDate: 2020/11/17
 * Author: songjialin
 */
public abstract class ResUtil {
    private ResUtil() {
    }

    public static Optional<Path> resolve(String fileName) {
        return Optional.of(Paths.get("res", fileName));
    }
}
