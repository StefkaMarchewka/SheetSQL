package com.codecool.sheetSQL.service;

import java.util.Arrays;
import java.util.List;

public interface DataProcessingHelper {

    default String getTableHeaders(List<String> data){
        return data.stream()
                .findFirst()
                .orElse("");
    }

    default  String getNthColumns(String[] arr, List<Integer> chosenColumns){
        StringBuilder sb = new StringBuilder();
        List<String> arrAsList = Arrays.asList(arr);
        for (int j = 0; j < chosenColumns.size(); j++) {
            sb.append(arrAsList.get(chosenColumns.get(j)));
            sb.append(" ");
        }
        return sb.toString();
    }

    default String getNColumn(String[] arr, int index)
    {
        System.out.println(arr[index]);
        return arr[index];
    }

    default int findColumnIndex(String[] array, String value) throws IndexOutOfBoundsException{
        int result = 0;
        for (int i = 0; i < array.length; i++) {
            if(array[i].equals(value)){
                result = i;
                return result;
            }
        }
        throw new IndexOutOfBoundsException("array was empty");
    }


}
