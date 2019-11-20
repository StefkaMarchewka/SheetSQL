package com.codecool.sheetSQL.service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class WholeTableReaderImpl implements WholeTableReader {
    @Override
    public List<String> process(List<String> data) {
        return new ArrayList<>(data);
    }
}
