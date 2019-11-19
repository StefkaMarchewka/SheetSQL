package com.codecool.sheetSQL.service;

import java.util.List;

public interface ParticularColumnsInterface {

     List<String> getChosenColumnsFromRow(List<String> data, List<String> chosenColumns);
}
