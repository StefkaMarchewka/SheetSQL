package com.codecool.sheetSQL.controllers;


import com.codecool.sheetSQL.repository.GoogleSpreadSheetRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;


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
        System.out.println(query + " " + spreadSheetID + " " + sheet);

        GoogleSpreadSheetRepository spreadSheetRepository = new GoogleSpreadSheetRepository();
        try{
            List<List<Object>> spreadSheetContent = spreadSheetRepository.getDataFromSpreadSheet(spreadSheetID, sheet);
           // spreadSheetContent.stream().forEach(System.out::println);

            model.addAttribute("resultList", spreadSheetContent);

        }catch (Exception exc){
            System.out.println("Exception in GoogleSpreadSheetRepository");
            exc.printStackTrace();
        }

        return "queryResultTable";
    }
}
