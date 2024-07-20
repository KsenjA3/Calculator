package org.example.calculate;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.face.MyException;
import org.apache.commons.lang3.StringUtils;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.HashMap;

 class CalculateEngineer {
    private static final Logger logger = LogManager.getLogger(CalculateEngineer.class);

    private String strReturn;
    final double threshold = 0.000000000000001;

    public String calculateEngineer (String strInput, String name ) throws MyException {
        HashMap<Integer, String> hashMap;
        int placeNumber;
        BigDecimal bigdResult;
        String stringNumber;
        Double dNumber;
        int n;
        double scale= Math.pow(10,15);
        double tg_scale= Math.pow(10,14);



        switch (name){

            case "²" ->{
                boolean isNegative = false;
                n = StringUtils.indexOf(strInput, "²");

                hashMap =Operations.findNumber_beforeSign(strInput.substring(0, n));
                placeNumber = hashMap.keySet().stream().findFirst().get();
                stringNumber = hashMap.get(placeNumber);
                bigdResult = new BigDecimal(stringNumber);
                bigdResult=bigdResult.pow(2);

                if((placeNumber ==1   &&   strInput.charAt(0)=='-')  |
                        (placeNumber >1   &&   strInput.charAt(placeNumber -1)=='-')   &&
                        !StringUtils.endsWithAny(strInput.substring(0, placeNumber -1), "0","1","2","3","4","5","6","7","8","9",".") )
                {
                    isNegative =true;
                }
                if (isNegative){
                    if (strInput.length() > n + 1)
                        strReturn = strInput.substring(0, placeNumber -1) + bigdResult + strInput.substring(n + 1);
                    else
                        strReturn = strInput.substring(0, placeNumber -1) + bigdResult;

                }else {

                    if (strInput.length() > n + 1)
                        strReturn = strInput.substring(0, placeNumber) + bigdResult + strInput.substring(n + 1);
                    else
                        strReturn = strInput.substring(0, placeNumber) + bigdResult;
                }

                return strReturn;
            }
            case  "³" ->{
                n =StringUtils.indexOf(strInput, "³");

                hashMap =Operations.findNumber_beforeSign(strInput.substring(0, n));
                placeNumber = hashMap.keySet().stream().findFirst().get();
                stringNumber = hashMap.get(placeNumber);
                bigdResult = new BigDecimal(stringNumber);
                bigdResult=bigdResult.pow(3);

                if (strInput.length()> n +1)
                    strReturn=strInput.substring(0, placeNumber)+bigdResult+strInput.substring(n +1);
                else
                    strReturn=strInput.substring(0, placeNumber)+bigdResult;

                return strReturn;
            }
            case "!" -> {
                n = StringUtils.indexOf(strInput, "!");
                hashMap = Operations.findNumber_beforeSign(strInput.substring(0, n));
                placeNumber = hashMap.keySet().stream().findFirst().get();
                stringNumber = hashMap.get(placeNumber);
                dNumber=Double.parseDouble(stringNumber);

                Integer intNumber = dNumber.intValue();
                if (Math.abs(dNumber-intNumber)>threshold  |   dNumber==0.0)
                    throw new NumberFormatException ();

                if ( (placeNumber==1   &&   strInput.charAt(0)=='-')
                      |  (placeNumber>1   &&   strInput.charAt(placeNumber-1)=='-'     &&
                              StringUtils.startsWithAny(strInput.substring(placeNumber-2),"+","-","/","*" ))
                )
                    throw new NumberFormatException ();

                BigInteger intResult = BigInteger.ONE;
                for (Integer k = 1; k <= intNumber; k++)
                        intResult = intResult.multiply(new BigInteger(k.toString()));

                if (strInput.length() > n + 1)
                    strReturn = strInput.substring(0, placeNumber) + intResult + strInput.substring(n + 1);
                else
                    strReturn = strInput.substring(0, placeNumber) +intResult;

                return strReturn;
            }

            case  "³√" ->{
                n =StringUtils.indexOf(strInput, "³√");

                boolean isNegative ;
                if (strInput.charAt(n+2)=='-'){
                    isNegative = true;
                    strInput=strInput.substring(0,n+2)+strInput.substring(n+3);
                }
                else   isNegative = false;

                hashMap =Operations.findNumber_afterSign(strInput.substring(n+2));
                placeNumber = hashMap.keySet().stream().findFirst().get();
                stringNumber = hashMap.get(placeNumber);
                dNumber=Double.parseDouble(stringNumber);

                if (dNumber.isInfinite() ){
                    throw new MyException("³√ INFINITY ");
                }

                if (isNegative)
                    dNumber=-Math.cbrt(dNumber);
                else
                    dNumber=Math.cbrt(dNumber);

                if (n+2+placeNumber<=strInput.length()-1)
                    strReturn=strInput.substring(0, n)+Operations.printNumber(dNumber)+strInput.substring(n+2+placeNumber );
                else
                    strReturn=strInput.substring(0, n)+Operations.printNumber(dNumber);
                return strReturn;
            }

            case "cos" ->{
                n =StringUtils.indexOf(strInput, "cos");

                boolean isNegative ;
                if (strInput.charAt(n+3)=='-'){
                    isNegative = true;
                    strInput=strInput.substring(0,n+3)+strInput.substring(n+4);
                }
                else   isNegative = false;

                hashMap =Operations.findNumber_afterSign(strInput.substring(n+3));
                placeNumber = hashMap.keySet().stream().findFirst().get();
                stringNumber = hashMap.get(placeNumber);

                dNumber=Double.parseDouble(stringNumber);
                if (dNumber.isInfinite() ){
                    throw new MyException("cos INFINITY ");
                }

                if (isNegative)  dNumber=-dNumber;
                dNumber = Math.toRadians(dNumber);
                dNumber=Math.round(Math.cos(dNumber)*scale)/scale;

                if (n+3+placeNumber<=strInput.length()-1)
                    strReturn=strInput.substring(0, n)+Operations.printNumber(dNumber)+strInput.substring(n+3+placeNumber );
                else
                    strReturn=strInput.substring(0, n)+Operations.printNumber(dNumber);

                return strReturn;
            }
            case "sin" ->{
                n =StringUtils.indexOf(strInput, "sin");

                boolean isNegative ;
                if (strInput.charAt(n+3)=='-'){
                    isNegative = true;
                    strInput=strInput.substring(0,n+3)+strInput.substring(n+4);
                }
                else   isNegative = false;

                hashMap =Operations.findNumber_afterSign(strInput.substring(n+3));
                placeNumber = hashMap.keySet().stream().findFirst().get();
                stringNumber = hashMap.get(placeNumber);

                dNumber=Double.parseDouble(stringNumber);
                if (dNumber.isInfinite() ){
                    throw new MyException("sin INFINITY ");
                }

                if (isNegative)
                    dNumber=-dNumber;
                dNumber = Math.toRadians(dNumber);
                dNumber=Math.round(Math.sin(dNumber)*scale)/scale;

                if (n+3+placeNumber<=strInput.length()-1)
                    strReturn=strInput.substring(0, n)+Operations.printNumber(dNumber)+strInput.substring(n+3+placeNumber );
                else
                    strReturn=strInput.substring(0, n)+Operations.printNumber(dNumber);

                return strReturn;
        }
            case "tg" ->{
            n =StringUtils.indexOf(strInput, "tg");

            boolean isNegative ;
            if (strInput.charAt(n+2)=='-'){
                isNegative = true;
                strInput=strInput.substring(0,n+2)+strInput.substring(n+3);
            }
            else   isNegative = false;

            hashMap =Operations.findNumber_afterSign(strInput.substring(n+2));
            placeNumber = hashMap.keySet().stream().findFirst().get();
            stringNumber = hashMap.get(placeNumber);

            dNumber=Double.parseDouble(stringNumber);
            if (dNumber.isInfinite() ){
                throw new MyException("tg INFINITY");
            }

            long iRez=Math.round(dNumber);
            if(Math.abs(iRez)>180)
                iRez=iRez%180;

            try {
                if (Math.abs(iRez)==90){
                    throw new ArithmeticException();
                }else {
                    if (isNegative)  dNumber=-dNumber;
                    dNumber = Math.toRadians(dNumber);
                    dNumber=Math.round(Math.tan(dNumber)*tg_scale)/tg_scale;

//                    System.out.println("dRez= "+dNumber);

                    if (n+2+placeNumber<=strInput.length()-1)
                        strReturn=strInput.substring(0, n)+Operations.printNumber(dNumber)+strInput.substring(n+2+placeNumber );
                    else
                        strReturn=strInput.substring(0, n)+Operations.printNumber(dNumber);
                }
            } catch (ArithmeticException ex) {
                logger.error("logger.error tg не определен: {}",strInput);
                throw new MyException("tg не определен");
            }
            return strReturn;
        }


            case "lg" ->{
//                System.out.println("in= "+strInput);
                n =StringUtils.indexOf(strInput, "lg");

                boolean isNegative ;
                if (strInput.charAt(n+2)=='-'){
                    isNegative = true;
                    strInput=strInput.substring(0,n+2)+strInput.substring(n+3);
                }
                else   isNegative = false;

                hashMap =Operations.findNumber_afterSign(strInput.substring(n+2));
                placeNumber = hashMap.keySet().stream().findFirst().get();
                stringNumber = hashMap.get(placeNumber);
//                System.out.println("stringNumber= "+stringNumber);
//                System.out.println("length Number= "+placeNumber);

                 dNumber=Double.parseDouble(stringNumber);
                if (dNumber.isInfinite() ){
                    throw new MyException("lg INFINITY");
                }
                if (isNegative)  dNumber=-dNumber;
//                System.out.println("dNumber= "+dNumber);

                dNumber=Math.log10(dNumber);
                if (dNumber.isNaN() ) {
                    throw new MyException("lg NAN");
                }
                if (dNumber.isInfinite() ){
                    throw new MyException("lg 0");
                }
//                System.out.println("dRez= "+dNumber);

                if (n+2+placeNumber<=strInput.length()-1)
                    strReturn=strInput.substring(0, n)+Operations.printNumber(dNumber)+strInput.substring(n+2+placeNumber );
                else
                    strReturn=strInput.substring(0, n)+Operations.printNumber(dNumber);
//                System.out.println("out= "+strReturn);
//                System.out.println();
                return strReturn;
        }
            case "ln" ->{
//                System.out.println("in= "+strInput);
                n =StringUtils.indexOf(strInput, "ln");

                boolean isNegative ;
                if (strInput.charAt(n+2)=='-'){
                    isNegative = true;
                    strInput=strInput.substring(0,n+2)+strInput.substring(n+3);
                }
                else   isNegative = false;

                hashMap =Operations.findNumber_afterSign(strInput.substring(n+2));
                placeNumber = hashMap.keySet().stream().findFirst().get();
                stringNumber = hashMap.get(placeNumber);
//                System.out.println("stringNumber= "+stringNumber);
//                System.out.println("length Number= "+placeNumber);

                dNumber=Double.parseDouble(stringNumber);
                if (dNumber.isInfinite() ){
                    throw new MyException("ln INFINITY");
                }
                if (isNegative)  dNumber=-dNumber;
//                System.out.println("dNumber= "+dNumber);

                dNumber=Math.log(dNumber);
                if (dNumber.isNaN() ) {
                    throw new MyException("ln NAN");
                }
                if (dNumber.isInfinite() ){
                    throw new MyException("ln 0");
                }
//                System.out.println("dRez= "+dNumber);

                if (n+2+placeNumber<=strInput.length()-1)
                    strReturn=strInput.substring(0, n)+Operations.printNumber(dNumber)+strInput.substring(n+2+placeNumber );
                else
                    strReturn=strInput.substring(0, n)+Operations.printNumber(dNumber);
//                System.out.println("out= "+strReturn);
//                System.out.println();
                return strReturn;
            }


        }
        return strReturn;
    }
}
