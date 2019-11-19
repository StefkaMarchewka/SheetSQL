package com.codecool.sheetSQL.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;


@Controller
public class MainController {

    @GetMapping(value="/sheet")
    public String welcome(){
        return "sqlInputForm";
    }

    @RequestMapping(value="sheet", method = RequestMethod.POST)
    public String getQueryResult(){
        //call service and give him user input
        return "there should be query result";
    }




}
