package org.example;


import calculate.CalculateBasic;
import calculate.Operations;
import org.apache.commons.lang3.StringUtils;

import java.math.BigDecimal;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args)  {
        String strNumber="2 ";
        CalculateBasic calc= new CalculateBasic();
        strNumber=calc.calculateBasicInput(strNumber);
        System.out.println(strNumber);
    }
}