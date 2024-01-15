package com.github.study.demo.guava;

import com.google.common.math.LinearTransformation;
import com.google.common.math.Quantiles;

/**
 * CreatedDate: 2021/2/18
 * Author: songjialin
 */
public class QuantilesTest {
    public static void main(String[] args) {
        LinearTransformation linearTransformation = LinearTransformation.mapping(1, 3)
                .and(2, 8);
        System.out.println(linearTransformation);
        System.out.println(linearTransformation.inverse().transform(5));
        System.out.println(linearTransformation.transform(5));
    }

    private static void test() {
        double compute = Quantiles.quartiles().index(0).compute(1, 2, 3, 4);
        System.out.println(compute);
    }
}
