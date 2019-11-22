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
        for (String chosenColumn : chosenColumns) {
            columnIndex = findColumnIndex(headers, chosenColumn);
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

    public List<String> getContentOfChosenColumn(List<String> data, String columnName){
        String[] headers = getTableHeaders(data).split(",");
        int columnIndex = findColumnIndex(headers, columnName);

        List<String> result = data.stream()
                .map(row -> row.split(","))
                .map(arr -> getNColumn(arr, columnIndex))
                .collect(Collectors.toList());

        return result;
    }


    public List<String> countResults(List<String> data, String columnName, String valueToFind){
        String[] headers = getTableHeaders(data).split(",");
        int columnIndex = findColumnIndex(headers, columnName);
        List<String> result = new ArrayList<>();

        long countResult =
                data.stream()
                        .map(row -> row.split(","))
                        .filter(array -> array[columnIndex].equals(valueToFind))
                        .map(array -> String.join(" ", array))
                        .count();

        result.add(String.valueOf(countResult));
        return result;
    }

    public List<String> getRowByChosenColumnValue(List<String> data, String columnName, String valueToFind){
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
