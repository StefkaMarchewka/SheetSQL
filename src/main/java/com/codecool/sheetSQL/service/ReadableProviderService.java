package com.codecool.sheetSQL.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Map;

@Service
public class ReadableProviderService {
    @Autowired
    private List<Readable> readables;
    @Autowired
    private Map<String, Readable> readableMap;

    {
        for (Readable item: readables
             ) {
            readableMap.put(item.getClass().getName(), item);
        }
    }




    public List<String> getDataReader(String query, List<String> data) throws IOException {
        String[] queryWords = query.split("\\s");
        if (queryWords[0].toLowerCase().equals("select") & queryWords[1].toLowerCase().equals("*") ){
            return readableMap.get("WholeTableReaderImpl").process(data);
        }

        else throw new IOException("Query error, search for typos");

    }


}
