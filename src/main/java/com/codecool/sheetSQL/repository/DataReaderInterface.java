package com.codecool.sheetSQL.repository;

import java.util.List;

public interface DataReaderInterface {

    List<List<Object>> getDataFromSpreadSheet() throws Exception;
}
