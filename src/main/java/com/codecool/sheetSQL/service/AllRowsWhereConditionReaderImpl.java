package com.codecool.sheetSQL.service;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AllRowsWhereConditionReaderImpl implements AllRowsWhereConditionReader, DataProcessingHelper {
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

    @Override
    public List<String> process(List<String> data) {
        return null;
    }

    public List<String> process(){
        return null;
    }
}
