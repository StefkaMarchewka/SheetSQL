package com.codecool.sheetSQL.service;

import java.util.ArrayList;
import java.util.List;

public class WholeTableService implements WholeTableInterface {
    @Override
    public List<String> process(List<String> data) {
        return new ArrayList<>(data);
    }
}
