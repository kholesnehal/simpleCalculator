package com.example.simplecalculator.service;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
@Service
public class Calculator {
    public List<String> getsInput(String a) {

        List<String> inputList = new ArrayList<String>(Arrays.asList(a.split("(?<=\\D)(?=\\d)|(?<=\\d)(?=\\D)")));
        int arrayLength = inputList.size();
        if (inputList.get(0).equals("quit")) {
            System.exit(0);
        } else if (arrayLength == 1) {

        }
        this.calculation(inputList);
        return inputList;
    }


    public double calculation(List<String> expressionList){
        List<String> filteredList;
        int operatorIndex = 1;

        while (expressionList.contains("*") || (expressionList.contains("/")) || (expressionList.contains("+"))
                || (expressionList.contains("-"))) {
            boolean replace = false;
            double numberOne = Double.parseDouble(expressionList.get(operatorIndex - 1));
            double numberTwo = Double.parseDouble(expressionList.get(operatorIndex + 1));

            if (expressionList.contains("*")) {
                if (expressionList.get(operatorIndex).equals("*")) {
                    expressionList.set(operatorIndex + 1, (numberOne * numberTwo) + "");
                    replace = true;
                }
            } else if (expressionList.contains("/")) {
                if (expressionList.get(operatorIndex).equals("/")) {
                    expressionList.set(operatorIndex + 1, (numberOne / numberTwo) + "");
                    replace = true;
                }
            } else if (expressionList.contains("+")) {
                if (expressionList.get(operatorIndex).equals("+")) {
                    expressionList.set(operatorIndex + 1, (numberOne + numberTwo) + "");
                    replace = true;
                }
            } else if (expressionList.contains("-")) {
                if (expressionList.get(operatorIndex).equals("-")) {
                    expressionList.set(operatorIndex + 1, (numberOne - numberTwo) + "");
                    replace = true;
                }
            }

            if (replace == true) {
                expressionList.remove(operatorIndex - 1);
                expressionList.remove(operatorIndex - 1);
            } else {
                operatorIndex = operatorIndex + 2;

            }

            if (operatorIndex >= expressionList.size()) {
                operatorIndex = 1;
            }

        }

        filteredList = expressionList;

        double solution = Double.parseDouble(filteredList.get(0));
        return solution;


    }
}