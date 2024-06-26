package org.example.calculate;



import org.apache.commons.lang3.StringUtils;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.HashMap;

public class Operations {
    public static MathContext mathContext= new MathContext(15);

    public static  BigDecimal result (calculate f, BigDecimal d1, BigDecimal d2) {

        return f.func(d1, d2);
    }




    public static BigDecimal plus (BigDecimal d1, BigDecimal d2) {
        return d1.add(d2, mathContext);
    }

    public static  BigDecimal minus (BigDecimal d1, BigDecimal d2) {
        return d1.subtract(d2, mathContext);
    }

    public static  BigDecimal divide (BigDecimal d1, BigDecimal d2) {
        return d1.divide(d2, mathContext);
    }

    public static  BigDecimal multiply(BigDecimal d1, BigDecimal d2) {
        return d1.multiply(d2, mathContext);
    }

    public static  BigDecimal sqrt (BigDecimal d1) { return d1.sqrt(mathContext);}

    public static  BigDecimal pow (BigDecimal d1, BigDecimal d2) {
        int i2= Integer.parseInt(d2.toString());
        return d1.pow(i2, mathContext);
    }






    /**
     * transform  Double number to String,
     * consider that number can be Integer
     * @param d transforming Double number to String
     * @return String form number
     */
    public static String printNumber (Double d) {
        String str =Double.toString(d);

        if(str.contains("E"))
            str = new  BigDecimal(str).toPlainString();

        if(!str.contains("."))
            return str;

        int placePoint = StringUtils.indexOf(str, ".");
        int placeLastNumber=StringUtils.lastIndexOfAny(str, "1","2","3","4","5","6","7","8","9");
        if (placePoint>placeLastNumber)
            str=str.substring(0,placePoint);
        else
            str=str.substring(0,placeLastNumber+1);
        return str;
    }
    public static String printNumber (String str) {
        if(str.contains("E"))
            str = new  BigDecimal(str).toPlainString();

        if(!str.contains("."))
            return str;

        int placePoint = StringUtils.indexOf(str, ".");
        int placeLastNumber=StringUtils.lastIndexOfAny(str, "1","2","3","4","5","6","7","8","9");
        if (placePoint>placeLastNumber)
            str=str.substring(0,placePoint);
        else
            str=str.substring(0,placeLastNumber+1);
        return str;
    }

    public static HashMap findNumber_beforeSign (String strIn){

        HashMap <Integer, String> result = new HashMap<>();

        boolean isSign= false;
        String number= " ";
        int placeNumber=1;

        for (int i=strIn.length()-1; i>=0; i--) {
            switch (strIn.charAt(i)) {
                case '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '.' -> {
                    if (i==0) {
                        number=strIn;
                        placeNumber=0;
                    }
                }
                default -> {
                    number=strIn.substring(i+1);
                    isSign=true;
                    placeNumber=i+1;
                }
            }
            if (isSign)break;
        }
        result.put(placeNumber,number);
        return result;
    }

    public static HashMap findNumber_afterSign (String strIn){

        HashMap <Integer, String> result = new HashMap<>();

        boolean isSign= false;
        String number= "";
        int placeNumber=1;

        for (int i=0; i<strIn.length() ; i++) {
            switch (strIn.charAt(i)) {
                case '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '.' -> {
                    if (i==strIn.length()-1) {
                        number=strIn;
                        placeNumber=strIn.length();
                    }
                }
                default -> {
                    number=strIn.substring(0,i);
                    isSign=true;
                    placeNumber=i;
                }
            }
            if (isSign)break;
        }


        result.put(placeNumber,number);
        return result;
    }
}
