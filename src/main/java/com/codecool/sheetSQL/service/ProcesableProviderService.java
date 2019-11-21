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
        //select * from table
        if (query.matches("^select\\s\\*\\s[a-zA-Z\\s]+$") ){
            return processor.getWholeTable(data);
            //select someColumns from table
        }else if (query.matches("^select\\s[a-zA-Z]+\\s[a-zA-Z\\s]+$") ){
            return processor.getContentOfChosenColumn(data, queryWords[1]);
            //select someColumns from table where column like something
        }else if (query.matches("^select\\s[a-zA-Z*,]+\\swhere\\s[a-zA-Z]\\slike[a-zA-Z0-9]+$") ){
            return processor.getAllColumnsWhere(data, queryWords[1], queryWords[7]);
        }


        else throw new IOException("Query error, search for typos");

    }


}
