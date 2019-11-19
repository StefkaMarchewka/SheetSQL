package com.codecool.sheetSQL.service;

import java.util.List;

public interface DataProcessing {


    List<String> getAllData(List<String> data);

    List<String> getContentOfChosenColumn(List<String> data, String columnName);

    String countResults(List<String> data, String columnName, String valueToFind);

    List<String> getChosenColumnsFromRow(List<String> data, List<String> chosenColumns);

}
