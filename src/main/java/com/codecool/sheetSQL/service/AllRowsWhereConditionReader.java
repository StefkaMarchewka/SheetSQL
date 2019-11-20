package com.codecool.sheetSQL.service;

import java.util.List;

public interface AllRowsWhereConditionReader extends Readable {
    List<String> getAllColumnsWhere(List<String> data, String columnName, String valueToFind);
}
