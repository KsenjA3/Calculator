package org.example.calculate;

import org.apache.commons.lang3.StringUtils;

import java.math.BigDecimal;

import java.util.ArrayList;

public class CalculateBasic {
    private ArrayList<BigDecimal> arrD;
    private ArrayList <calculate> arrSign;

    private ArrayList <String> arrNameSign;

    private String strNumber;      //inner number
    private calculate func;

    private BigDecimal dNumber;
    private BigDecimal  dResult;         //for calculation
    private BigDecimal dNSqrt;              //service sqrt
    private BigDecimal dResultPercent;
    private int figureSqrt;
    private boolean wasNumber;
    private boolean wasSqrt;
    private String stringResult;

    private boolean wasNegativeNumber;

    /**
     * calculator.org.example.calculate.calculate result from string
     * @param strInput string with task to calculator.org.example.calculate.calculate
     * @return double result of calculation
     */
    public String calculateBasicInput (String strInput) {
        strInput=StringUtils.deleteWhitespace(strInput);
//System.out.println(strInput);

        wasNegativeNumber=false;
        func=null;
        strNumber = "0";
        dResult= BigDecimal.ZERO;
        figureSqrt=1;
        dNSqrt=new BigDecimal(1);
        wasNumber = false;
        wasSqrt = false;

        arrD = new ArrayList<>();
        arrSign=new ArrayList<>();
        arrNameSign=new ArrayList<>();

//begin from Negative number
        if (strInput.charAt(0)=='-'){
            if (strInput.length()>1 && strInput.charAt(1)=='-'){
                strInput = strInput.substring(2);
                wasNegativeNumber = false;
            }else {
                strInput = strInput.substring(1);
                wasNegativeNumber = true;
            }
        }

        for (int i=0; i<strInput.length(); i++) {

            switch (strInput.charAt(i)) {
                case '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '.'-> {
                        //create number


                    strNumber = strNumber + strInput.charAt(i);

                        //if sqrt before number
                    if (wasSqrt) {
                        dNumber = new BigDecimal (strNumber);
                        for (int j = 0; j < figureSqrt; j++){
                            dNumber = Operations.sqrt(dNumber);
                        }
                        dNumber= Operations.multiply(dNSqrt,dNumber);
                    } else {          // number after -+*/^
                        dNumber = new BigDecimal (strNumber);
                    }
                        //write last number
                    if (i == strInput.length() - 1) {
                        if (wasNegativeNumber){ dNumber=dNumber.negate(); }
                        arrD.add(dNumber);
                    }

                    wasNumber = true;
                }
                case'√'->
                {
                    if (wasNumber) {
                        //if the last sign sqrt
                        if ((i + 1) == strInput.length())
                        {
                            arrD.add(dNumber);
                        }
                        else             // dNumber * √
                            dNSqrt = dNumber;

                    }
                    else           // если знак после sqrt
                        if (wasSqrt) // если несколько sqrt подряд
                            figureSqrt++;
                    wasNumber= false;
                    wasSqrt=true;
                    strNumber="0";
                }
                case '+' ->
                {   arrNameSign.add("+");
                    arrSign.add(Operations::plus);
                    getReadyGoOn ();
                    if(i+1<strInput.length()   &&   strInput.charAt(i+1)=='-'){
                        i++;
                        wasNegativeNumber=true;
                    }
                }
                case '-' ->
                {   arrNameSign.add("-");
                    arrSign.add(Operations::minus);
                    getReadyGoOn ();
                    if(i+1<strInput.length()   &&   strInput.charAt(i+1)=='-'){
                        i++;
                        wasNegativeNumber=true;
                    }
                }
                case '*' -> {
                    arrNameSign.add("*");
                    arrSign.add(Operations::multiply);
                    getReadyGoOn ();
                    if(i+1<strInput.length()   &&   strInput.charAt(i+1)=='-'){
                        i++;
                        wasNegativeNumber=true;
                    }
                }
                case '/' -> {
                    arrNameSign.add("/");
                    arrSign.add(Operations::divide);
                    getReadyGoOn ();
                    if(i+1<strInput.length()   &&   strInput.charAt(i+1)=='-'){
                        i++;
                        wasNegativeNumber=true;
                    }
                }
                case '^' -> {
                    arrNameSign.add("^");
                    arrSign.add(Operations::pow);
                    getReadyGoOn();
                    if(i+1<strInput.length()   &&   strInput.charAt(i+1)=='-'){
                        i++;
                        wasNegativeNumber=true;
                    }
                }
            }
        }

//        System.out.println(arrD);
//        System.out.println(arrNameSign);
//        System.out.println();

//calculator.org.example.calculate.calculate the result
        if (arrD.size()>2   &&   arrSign.size()>1){
            for (int j = 0; j<arrSign.size(); j++) {

                if (arrD.size()>j+1 &&
                    (arrNameSign.get(j).equals("*")  |  arrNameSign.get(j).equals("/") | arrNameSign.get(j).equals("^") ))
                {
                    dNumber=Operations.result(arrSign.get(j), arrD.get(j), arrD.get(j+1));
                    arrNameSign.remove(j);
                    arrSign.remove(j);
                    arrD.remove(j);
                    arrD.remove(j);
                    arrD.add(j,dNumber);
                    j--;
                }
            }
        }

        if (arrD.size()>0)
            dResult = arrD.get(0);

        if (arrD.size()>1){
            int j;
            for (int i = 1; i<arrD.size(); i++) {
                j = i - 1;
                if (j < arrSign.size()){
                    dResult = Operations.result(arrSign.get(j), dResult, arrD.get(i));
                }
            }
        }

//        dResult=dResult.setScale(14,RoundingMode.HALF_UP);
        stringResult = dResult.toString();
        return stringResult;
    }


    void getReadyGoOn () {
        if (wasNegativeNumber  && dNumber!=null){ dNumber=dNumber.negate(); }

        wasNegativeNumber=false;
        arrD.add(dNumber);

        strNumber = "0";
        wasNumber = false;
        wasSqrt = false;
        dNSqrt = new BigDecimal(1);
    }




    /**
     * calculator.org.example.calculate.calculate result Percent
     * @param nameSign string presentation precеding function to Percent
     * @param strResultPercentIn result before precеding function to Percent in double format
     * @param strNumberIn number between precеding function and function Percent
     * @return double result of calculation
     */
    public String calculatePersent (String nameSign, String strResultPercentIn, String strNumberIn) {

        if (strNumberIn.trim().equals(""))
            dNumber=BigDecimal.ZERO;
        else
            dNumber= new BigDecimal(strNumberIn);

        if (strResultPercentIn.trim().equals(""))
            dResultPercent=BigDecimal.ZERO;
        else
            dResultPercent = new BigDecimal(strResultPercentIn);

//        System.out.println();
//        System.out.println(dResultPercent);
//        System.out.println(nameSign);
//        System.out.println(dNumber);

            switch (nameSign.trim()) {
                case "+"-> {
                    System.out.println("in +");
                    func=Operations::plus;
                    dNumber = Operations.divide(Operations.multiply(dResultPercent, dNumber),
                                                new BigDecimal(100));
                    dResult = Operations.result(func, dResultPercent, dNumber);
                }
                case  "-" -> {
                    func=Operations::minus;
                    dNumber = Operations.divide(Operations.multiply(dResultPercent, dNumber),
                                                new BigDecimal(100));
                    dResult = Operations.result(func, dResultPercent, dNumber);
                }
                case "*" -> {
                    func=Operations::multiply;
                    dNumber = Operations.divide(dNumber, new BigDecimal(100));
                    dResult = Operations.result(func, dResultPercent, dNumber);
                }
                case "/" -> {
                    func=Operations::divide;
                    dNumber = Operations.divide(dNumber, new BigDecimal(100));
                    System.out.println("%dNumber%= "+ dNumber);
                    System.out.println("%dResultPercent%= "+ dResultPercent);
                    dResult = Operations.result(func, dResultPercent, dNumber);
                    System.out.println("%dResult%= "+ dResult);
                }
                case "no"->  dResult = Operations.divide(dNumber, new BigDecimal(100) );
            }

        stringResult = dResult.toString();
        return stringResult;
    }

}


