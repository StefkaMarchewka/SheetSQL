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
import java.util.stream.Collectors;


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

            List<List<String>> casted = castListElements(spreadSheetContent);

            List<String> dataToPass = casted.stream()
                    .map(x-> String.join(",", x))
                    .collect(Collectors.toList());


            List processedData = processorService.getDataReader(query, dataToPass);
            model.addAttribute("resultList", processedData);

        }catch (Exception exc){
            System.out.println("Exception in GoogleSpreadSheetRepository");
            exc.printStackTrace();
        }
        return "queryResultTable";
    }

    public List<List<String>> castListElements(List<List<Object>> listToCast){
       List<List<String>> castedLists = new ArrayList<>();
        for (int i = 0; i < listToCast.size(); i++) {
            List<Object> listToProcess = listToCast.get(i);
            List<String> listToAdd = new ArrayList<>();

            for (Object o: listToProcess) {
                String castedWord = o.toString();
                listToAdd.add(castedWord);
            }
            castedLists.add(listToAdd);
        }
        return castedLists;
    }
}
