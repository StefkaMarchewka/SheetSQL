package com.codecool.sheetSQL.repository;

import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
public class CSVQueries {

    public List<String> getAllData(List<String> data){
       return data.stream()
                .collect(Collectors.toList());
    }

    public List<String> getContentOfChosenColumn(List<String> data, String columnName){
        String[] headers = getTableHeaders(data).split(",");
        int columnIndex = findColumnIndex(headers, columnName);

        return data.stream()
                .map(row -> row.split(","))
                .map(arr -> getNColumn(arr, columnIndex))
                .collect(Collectors.toList());
    }



    public String countResults(List<String> data, String columnName, String valueToFind){
        String[] headers = getTableHeaders(data).split(",");
        int columnIndex = findColumnIndex(headers, columnName);

        long countResult =
                data.stream()
                        .map(row -> row.split(","))
                        .filter(array -> array[columnIndex].equals(valueToFind))
                        .map(array -> String.join(" ", array))
                        .count();

        return String.valueOf(countResult);
    }

    public List<String> getRowByChosenColumnValue(List<String> data, String columnName, String valueToFind){
        String[] headers = getTableHeaders(data).split(",");
        int columnIndex = findColumnIndex(headers, columnName);

        List<String> resultList =
                data.stream()
                .map(row -> row.split(","))
                .filter(array -> array[columnIndex].equals(valueToFind))
                .map(array -> String.join(" ", array))
                .collect(Collectors.toList());
        return resultList;
    }

//    public List<String> getChosenColumnsFromRow(List<String> data, List<String> chosenColumns){
//       List<Integer> chosenColumnsIndexes = new ArrayList<>();
//        String[] headers = getTableHeaders(data).split(",");
//        int columnIndex = 0;
//        for (int i = 0; i <chosenColumns.size() ; i++) {
//            columnIndex = findColumnIndex(headers, chosenColumns.get(i));
//            chosenColumnsIndexes.add(columnIndex);
//        }
//
//        List<String> result = data.stream()
//                .map(row -> row.split(","))
//                .map(arr -> getNthColumns(arr, chosenColumnsIndexes))
//                .collect(Collectors.toList());
//
//        return result;
//    }

//    //sth doesnt work here
//    private String getNthColumns(String[] arr, List<Integer> chosenColumns){
//        StringBuilder sb = new StringBuilder();
//        List<String> arrAsList = Arrays.asList(arr);
//
//        for (int i = 0; i < arrAsList.size(); i++) {
//            for (int j = 0; j < chosenColumns.size(); j++) {
//                sb.append(arrAsList.get(chosenColumns.get(j)));
//            }
//
//        }
//        //sb.append(oneColumnContent);
//        return sb.toString();
//    }



    public void getChosenName(List<String> data, String name) throws IOException {
        Stream<String> dataStream = Files.lines(Paths.get("src/main/resources/csv_test.csv"));
        dataStream.map(x -> x.split(","))
                .filter(x -> x[0].equals(name))
                .forEach(x -> System.out.println(x[0] + x[1] + x[2]));
    }

    private String getTableHeaders(List<String> data){
        return data.stream()
                .findFirst() //this it terminal operation
                .orElse("");
    }

    //is it possible to replace it with lambda expresion? or is it only for forEach loop
    private int findColumnIndex(String[] array, String value) throws IndexOutOfBoundsException{
        int result = 0;
        for (int i = 0; i < array.length-1; i++) {
            if(array[i].equals(value)){
                result = i;
            }
        }
        return result;
    }

    private String getNColumn(String[] arr, int index){
        return arr[index];
    }


    //this will not work becouse arrray can have only one type values
//    public List<String> getRecordsFromRange(List<String> data, String column, String fromValue, String toValue){
//        String[] headers = getTableHeaders(data).split(",");
//        int columnIndex = findColumnIndex(headers, column);
//        System.out.println(columnIndex);
//
//        List<String> result = data.stream()
//                .map(row -> row.split(","))
//                .map(row -> Integer.valueOf(row[columnIndex]))
//                .filter(record -> record > Integer.valueOf(fromValue))
//                      //  && record < Integer.parseInt(toValue))
//               // .map(row -> String.join(" ", row))
//                .map(record -> String.valueOf(record))
//                .collect(Collectors.toList());
//        return result;
//    }

    // in this version it doesn see what is x, I totally dont understand why
//    public void getNames(List<String> data, String name) throws IOException {
//        List<String> streamList =
//                data.stream()
//                        .map(x -> x.split(","))
//                        .filter(x -> x[0].equals(name))
//                        .flatMap(Arrays::stream)
//                        .collect(Collectors.toList());
//        streamList.stream()
//                .forEach(System.out::println);
//
//    }

}
