package com.codecool.sheetSQL.service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DataFunctionApplyer implements Procesable, DataProcessingHelper {
    @Override
    public List<String> getWholeTable(List<String> data) {
        return new ArrayList<>(data);
    }

    @Override
    public List<String> getChosenColumnsFromRow(List<String> data, List<String> chosenColumns) {
        List<Integer> chosenColumnsIndexes = new ArrayList<>();
        String[] headers = getTableHeaders(data).split(",");
        int columnIndex = 0;
        for (int i = 0; i <chosenColumns.size() ; i++) {
            columnIndex = findColumnIndex(headers, chosenColumns.get(i));
            chosenColumnsIndexes.add(columnIndex);
        }

        List<String> result = data.stream()
                .map(row -> row.split(","))
                .map(arr -> getNthColumns(arr, chosenColumnsIndexes))
                .collect(Collectors.toList());

        return result;
    }

    @Override
    public List<String> getAllColumnsWhere(List<String> data, String columnName, String valueToFind) {
        String[] headers = getTableHeaders(data).split(",");
        int columnIndex = findColumnIndex(headers, columnName);

        List<String> resultList =
                data.stream()
                        .map(row -> row.split(","))
                        .filter(array -> array[columnIndex].equals(valueToFind))
                        .map(array -> String.join(" ", array))
                        .collect(Collectors.toList());
        return resultList;
    }


}
