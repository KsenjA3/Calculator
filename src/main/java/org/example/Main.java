package org.example;


import calculate.CalculateBasic;
import calculate.Operations;
import org.apache.commons.lang3.StringUtils;

import java.math.BigDecimal;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args)  {

        BigDecimal bd= new BigDecimal("9");
        bd=bd.pow(999);
        String strNumber=bd.toPlainString();
        Double d=Double.parseDouble(strNumber);

        System.out.println(strNumber);
        System.out.println(d==Double.NEGATIVE_INFINITY);
        System.out.println(d==Double.POSITIVE_INFINITY);
    }
}