package com.codecool.sheetSQL.service;

import java.util.ArrayList;
import java.util.List;

public class WholeTableReaderImpl implements WholeTableReader {
    @Override
    public List<String> process(List<String> data) {
        return new ArrayList<>(data);
    }
}
