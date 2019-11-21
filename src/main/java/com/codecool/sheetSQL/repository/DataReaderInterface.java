package com.codecool.sheetSQL.repository;

import java.util.List;

public interface DataReaderInterface {

    List<List<Object>> getDataFromSpreadSheet(String docId, String spreadsheetName) throws Exception;
}
