package com.codecool.sheetSQL.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;

@Service
public class ProcesableProviderService {

    @Autowired
    Procesable processor;



    public List<String> getDataReader(String query, List<String> data) throws IOException {
        String[] queryWords = query.split("\\s");
        if (queryWords[0].toLowerCase().equals("select") & queryWords[1].toLowerCase().equals("*") ){
            return processor.getWholeTable(data);
        }else if (queryWords[0].toLowerCase().equals("select") & !queryWords[1].toLowerCase().equals("*") ){
            return processor.getChosenColumnsFromRow(data, Collections.singletonList(queryWords[1]));
        }

        else throw new IOException("Query error, search for typos");

    }


}
