package com.codecool.sheetSQL.model;

import org.springframework.stereotype.Component;

@Component
public class UserData {
    private String spreadsheetId;
    private String range;

    public void setSpreadsheetId(String spreadsheetId) {
        this.spreadsheetId = spreadsheetId;
    }

    public void setRange(String range) {
        this.range = range;
    }

    public UserData(){
    }


    public String getSpreadsheetId() {
        return spreadsheetId;
    }

    public String getRange() {
        return range;
    }
}
