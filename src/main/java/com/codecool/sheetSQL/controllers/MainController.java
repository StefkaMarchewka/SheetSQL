package com.codecool.sheetSQL.controllers;


import com.codecool.sheetSQL.dao.CSVQueries;
import com.codecool.sheetSQL.dao.FileReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class MainController {
    @Autowired
    private FileReader fileReader;
    @Autowired
    private CSVQueries csvQueries;

    @RequestMapping(value="sheet", method = RequestMethod.GET)
    public String welcome(){
        return "sqlInputForm";
    }

    @RequestMapping(value="sheet", method = RequestMethod.POST)
    public String getQueryResult(){
        //here pout logic of reading queries from input box and generate response
        //bla
        return "there should be query result";
    }


}
