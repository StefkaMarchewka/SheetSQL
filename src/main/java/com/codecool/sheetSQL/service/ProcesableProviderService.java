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
        Arrays.asList(queryWords).forEach(System.out::println);
        //select * from table
        if (query.matches("^select\\s\\*\\sfrom\\s[a-zA-Z]+$") ){
            return processor.getWholeTable(data);
            //select someColumns from table
        }else if (query.matches("^select\\s[a-zA-Z]+\\sfrom\\s[a-zA-Z0-9]+$") ){
            return processor.getContentOfChosenColumn(data, queryWords[1]);
            //select someColumns from table where column like something
        }else if (query.matches("^select\\s[a-zA-Z*]+\\sfrom\\s[a-zA-Z]+\\swhere\\s[a-zA-Z]+\\slike\\s[a-zA-Z0-9]+$") ){
            return processor.getAllColumnsWhere(data, queryWords[1], queryWords[7]);
        }else if(query.matches("^select\\scount\\([a-zA-Z]+\\)\\sfrom\\s[a-zA-Z]+\\swhere\\s[a-zA-Z]+\\slike\\s[a-zA-Z0-9]+$")){
            String columnName = getColumnNameFromArgs(query);
            return processor.countResults(data, columnName, queryWords[7]);
        }


        else throw new IOException("Query error, search for typos");

    }

    private static String getColumnNameFromArgs(String query){
        String[] arguments = query.split(" ");
        int substringEnd = arguments[1].length()-1;
        String column = arguments[1].substring(6, substringEnd);
        return  column;
    }

}
