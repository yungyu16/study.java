package com.github.study.java;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

import java.io.BufferedReader;
import java.nio.file.Files;
import java.nio.file.Paths;


/**
 * CreatedDate: 2020/6/24
 * Author: songjialin
 */
public class CsvTest {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = Files.newBufferedReader(Paths.get("testCsv.csv"));
        Iterable<CSVRecord> records = CSVFormat.DEFAULT.withCommentMarker('#').parse(reader);
        for (CSVRecord record : records) {
            System.out.println(record.toString());
        }
    }
}
