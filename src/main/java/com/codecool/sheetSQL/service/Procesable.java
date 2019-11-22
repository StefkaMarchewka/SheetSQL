package com.codecool.sheetSQL.service;

import java.util.List;

public interface Procesable {

    List<String> getWholeTable(List<String> data);
    List<String> getChosenColumnsFromRow(List<String> data, List<String> chosenColumns);
    List<String> getAllColumnsWhere(List<String> data, String columnName, String valueToFind);
    List<String> getContentOfChosenColumn(List<String> data, String columnName);
    List<String> countResults(List<String> data, String columnName, String valueToFind);
}
