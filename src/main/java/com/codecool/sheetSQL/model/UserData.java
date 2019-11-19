package com.codecool.sheetSQL.model;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class UserData {

    @Value("string value")
    private String spreadsheetId;
    @Value("string value")
    private String range;

    public UserData(){
    }


    public String getSpreadsheetId() {
        return spreadsheetId;
    }

    public String getRange() {
        return range;
    }
}
