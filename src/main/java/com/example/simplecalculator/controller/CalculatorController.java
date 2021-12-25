package com.example.simplecalculator.controller;

import com.example.simplecalculator.service.Calculator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CalculatorController {

    @Autowired
    private Calculator calculator;
@GetMapping(value="/calculator")
@ResponseBody
    public List<String> getsInputCalculator(@RequestParam String a)
    {
        return calculator.getsInput(a);
    }

}
