package com.codecool.sheetSQL.service;

import java.util.List;

public interface WholeTableReader extends Readable {

    List<String> process(List<String> data);


}
