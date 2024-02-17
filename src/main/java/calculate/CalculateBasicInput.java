package calculate;

import java.math.BigDecimal;

import java.math.RoundingMode;
import java.util.ArrayList;

public class CalculateBasicInput {
    private ArrayList<BigDecimal> arrD;
    private ArrayList <calculate> arrSign;

    private String strNumber;      //inner number
    calculate func;

    private BigDecimal dNumber;
    private BigDecimal  dResult;         //for calculation
    private BigDecimal dNSqrt;              //service sqrt
    private BigDecimal dResultPercent;
    private int figureSqrt;
    private boolean wasNumber;
    private boolean wasSqrt;
    private double doubleResult;
    private double doubleNumber;

    private boolean wasNegativeNumber;

    /**
     * calculator.calculate.calculate result from string
     * @param strInput string with task to calculator.calculate.calculate
     * @return double result of calculation
     */
    public double calculateInput (String strInput) {

        func=null;
        strNumber = "0";

        dResult=new BigDecimal(0.0);

        figureSqrt=1;
        dNSqrt=new BigDecimal(1);
        wasNumber = false;
        wasSqrt = false;

            // delete space
        strInput= strInput.replaceAll(" ", "");

        arrD = new ArrayList<>();
        arrSign=new ArrayList<>();

                //begin from Negative number
        if (strInput.charAt(0)=='-') {
            strInput = strInput.substring(1);
            wasNegativeNumber = true;
        }

        for (int i=0; i<strInput.length(); i++) {

            switch (strInput.charAt(i)) {
                case '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '.'-> {
                        //create number
                    strNumber = strNumber + strInput.charAt(i);

                        //if sqrt before number
                    if (wasSqrt) {
                        doubleNumber= Double.parseDouble(strNumber);
                        dNumber = new BigDecimal (doubleNumber);

                        for (int j = 0; j < figureSqrt; j++){
                            dNumber = Operations.sqrt(dNumber);
                        }
                        dNumber= Operations.multiply(dNSqrt,dNumber);
                    } else {          // число после -+*/
                        doubleNumber= Double.parseDouble(strNumber);
                        dNumber = new BigDecimal (doubleNumber);
                    }
                        //write last number
                    if (i == strInput.length() - 1) {
                        arrD.add(dNumber);
                    }

                    wasNumber = true;
                }case'√'->{

                    if (wasNumber) {
                        //if the last sign sqrt
                        if ((i + 1) == strInput.length()) {
                            arrD.add(dNumber);
                        }
                        else             // dNumber * √
                            dNSqrt = dNumber;

                    }else           // если знак после sqrt

                        if (wasSqrt) // если несколько sqrt подряд
                            figureSqrt++;

                    wasNumber= false;
                    wasSqrt=true;
                    strNumber=" ";

                }case '+' -> {
                    arrSign.add(Operations::plus);
                    arrD.add(dNumber);
                    strNumber=" ";
                    wasNumber=false;
                    wasSqrt=false;
                    dNSqrt=new BigDecimal(1);
                }case '-' -> {
                    arrSign.add(Operations::minus);
                    arrD.add(dNumber);
                    strNumber=" ";
                    wasNumber=false;
                    wasSqrt=false;
                    dNSqrt=new BigDecimal(1);
                }case '*' -> {
                    arrSign.add(Operations::multiply);
                    arrD.add(dNumber);
                    strNumber=" ";
                    wasNumber=false;
                    wasSqrt=false;
                    dNSqrt=new BigDecimal(1);
                }case '/' -> {
                    arrSign.add(Operations::divide);
                    arrD.add(dNumber);
                    strNumber=" ";
                    wasNumber=false;
                    wasSqrt=false;
                    dNSqrt=new BigDecimal(1);
                }

            }
        }

/*
        System.out.println("+Number ="+dNumber);
        System.out.println(func);

        System.out.print("arrD.size()>1= " );
        System.out.println(arrD.size()>1);

        for (int i = 0; i<arrD.size(); i++)
            System.out.println(i+" - "+ arrD.get(i));

        for (int i = 0; i<arrSign.size(); i++)
            System.out.println(i+" - "+ arrSign.get(i));
*/


            //calculator.calculate.calculate the resultate
        if (arrD.size()>0) {
            dResult = arrD.get(0);
            if(wasNegativeNumber)       //begin from Negative number
                dResult=dResult.negate();
        }



        if (arrD.size()>1){
            int j;
            for (int i = 1; i<arrD.size(); i++) {
                j = i - 1;
                if (j < arrSign.size())
                    dResult = Operations.result(arrSign.get(j), dResult, arrD.get(i));
            }
        }

        dResult=dResult.setScale(14,RoundingMode.HALF_UP);

        doubleResult = dResult.doubleValue();

//System.out.println("ответ - "+dResult);
//System.out.println("ответ - "+doubleResult);
        return doubleResult;
    }

    /**
     * calculator.calculate.calculate result Percent
     * @param funcPerc precеding function to Percent
     * @param nameSign string presentation precеding function to Percent
     * @param dResultPercentIn result before precеding function to Percent in double format
     * @param dNumberIn number between precеding function and function Percent
     * @return double result of calculation
     */
    public double calculatePersent (calculate funcPerc, String nameSign, double dResultPercentIn, double dNumberIn) {

        dNumber= new BigDecimal(dNumberIn);
        dResultPercent = new BigDecimal(dResultPercentIn);
        func=funcPerc;

        if (func == null) {
            dResult = Operations.divide(dNumber, new BigDecimal(100) );

        } else {
            switch (nameSign) {
                case " + ", " - " -> dNumber = Operations.divide(
                        Operations.multiply(dResultPercent,dNumber),
                        new BigDecimal(100));

                case " * ", " / " -> dNumber = Operations.divide(dNumber, new BigDecimal(100));
            }
            dResult = Operations.result(func, dResultPercent, dNumber);

        }


        doubleResult = dResult.doubleValue();
        return doubleResult;
    }

}


