package com.codecool.sheetSQL.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;


@Controller
public class MainController {

    @GetMapping(value="/sheet")
    public String welcome(){
        return "sqlInputForm";
    }

    @RequestMapping(value="sheet", method = RequestMethod.POST)
    public String getQueryResult(HttpServletRequest request, Model model){
        String query = request.getParameter("query");
        String spreadSheetID = request.getParameter("spreadSheetID");
        String sheet = request.getParameter("sheet");
        System.out.println(query + spreadSheetID + sheet);
        //call service and give him user input
        return "there should be query result";
    }
}
