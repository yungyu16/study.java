package com.github.study.java;

import java.time.LocalDate;
import java.time.Period;


/**
 * CreatedDate: 2020/6/24
 * Author: songjialin
 */
public class CsvTest {
    public static void main(String[] args) throws Exception {
        int days = Period.between(LocalDate.now(), LocalDate.now().plusDays(30)).getDays();
        System.out.println(days);
    }
}
