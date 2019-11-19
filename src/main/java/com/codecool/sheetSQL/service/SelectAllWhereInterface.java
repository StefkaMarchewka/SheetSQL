package com.codecool.sheetSQL.service;

import java.util.List;

public interface SelectAllWhereInterface {
    List<String> getAllColumnsWhere(List<String> data, String columnName, String valueToFind);
}
