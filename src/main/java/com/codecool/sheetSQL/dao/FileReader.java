package com.codecool.sheetSQL.dao;

import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class FileReader {

    public void readCSV(String fileName) throws IOException {
        List<String> rows = Files.lines(Paths.get(fileName))
                .collect(Collectors.toList());
                rows.forEach(System.out::println);
    }

    public List<String> getDataFromCSV(String fileName) throws IOException {
        List<String> rows = Files.lines(Paths.get("src/main/resources/csv_test.csv"))
                .collect(Collectors.toList());
        return rows;
    }


}
