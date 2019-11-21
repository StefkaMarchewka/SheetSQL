package com.codecool.sheetSQL.controllers;


import com.codecool.sheetSQL.repository.GoogleSpreadSheetRepository;
import com.codecool.sheetSQL.service.Procesable;
import com.codecool.sheetSQL.service.ProcesableProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;


@Controller
public class MainController {
    @Autowired
    ProcesableProviderService processorService;



    @GetMapping(value="/sheet")
    public String welcome(){
        return "sqlInputForm";
    }

    @RequestMapping(value="sheet", method = RequestMethod.POST)
    public String getQueryResult(HttpServletRequest request, Model model){
        String query = request.getParameter("query");
        String spreadSheetID = request.getParameter("spreadSheetID");
        String sheet = request.getParameter("sheet");

        GoogleSpreadSheetRepository spreadSheetRepository = new GoogleSpreadSheetRepository();
        try{
            List<List<Object>> spreadSheetContent = spreadSheetRepository.getDataFromSpreadSheet(spreadSheetID, sheet);
            ArrayList casted = new ArrayList();
            spreadSheetContent.forEach(element -> element.forEach(particle -> casted.add(particle.toString())));
            List processedData = processorService.getDataReader(query, casted);
            model.addAttribute("resultList", processedData);


        }catch (Exception exc){
            System.out.println("Exception in GoogleSpreadSheetRepository");
            exc.printStackTrace();
        }
        return "queryResultTable";
    }
}
