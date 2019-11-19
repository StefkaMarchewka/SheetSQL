package com.codecool.sheetSQL.controllers;


import com.codecool.sheetSQL.repository.CSVQueries;
import com.codecool.sheetSQL.repository.FileReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


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
        //call service and give him user input
        return "there should be query result";
    }

//    public String stefaniasSIMainMenuVersion(){
//        try {
//            List<String> data = csvReader.getDataFromCSV("src/main/resources/csv_test.csv");
//            List<String> argsList = Arrays.asList(args);
//            if(argsList.size() == 4 && argsList.contains("*")){
//                printResults(csvQueries.getAllData(data));
//            } else if(argsList.size() == 4){
//                //show content of one column
//                String columnName = argsList.get(1);
//                List<String> contentOfOneColumn = csvQueries.getContentOfChosenColumn(data, columnName);
//                printResults(contentOfOneColumn);
//            }else if(argsList.size() == 8 && String.join("", args).contains("count")){
//                String columnName = getColumnNameFromArgs(args);
//                String valueToFind = argsList.get(7);
//                System.out.println(csvQueries.countResults(data, columnName, valueToFind));
//            }else if(argsList.size() == 8) {
//                //chose row by selected columns value
//                String column = argsList.get(5);
//                String valueToFind = argsList.get(7);
//                printResults(csvQueries.getRowByChosenColumnValue(data, column, valueToFind));
//            }


////                else {
////                    List<String> columns = new ArrayList<>();
////                    columns.add("city");
////                    columns.add("age");
////                    printResults(csvQueries.getChosenColumnsFromRow(data, columns));
////                }
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }


}
