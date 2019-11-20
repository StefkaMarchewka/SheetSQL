package com.codecool.sheetSQL.service;

import java.util.List;

public interface ParticularColumnsReader extends Readable{

     List<String> getChosenColumnsFromRow(List<String> data, List<String> chosenColumns);
}
