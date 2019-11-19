package com.codecool.sheetSQL.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ParticularColumnsService implements ParticularColumnsInterface, DataProcessingHelper {


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
}
