package com.codecool.sheetSQL.service;

import java.util.List;
import java.util.stream.Collectors;

public class SelectAllWhereService implements SelectAllWhereInterface, DataProcessingHelper {
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
