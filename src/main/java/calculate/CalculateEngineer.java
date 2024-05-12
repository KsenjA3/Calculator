package calculate;

import face.MyException;
import org.apache.commons.lang3.StringUtils;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.HashMap;

public class CalculateEngineer {

    private String strReturn;
    final double threshold = 0.000000001;

    public String calculateEngineer (String strInput, String name ) throws MyException {
        HashMap<Integer, String> hashMap;
        int placeNumber;
        BigDecimal bigdResult;
        String stringNumber;
        Double dNumber;
        int n;
        double scale= Math.pow(10,15);




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

                if (dNumber==Double.NEGATIVE_INFINITY | dNumber==Double.POSITIVE_INFINITY) {
                    throw new MyException("³√ INFINITY ");
                }

                if (isNegative)
                    dNumber=-Math.cbrt(dNumber);
                else
                    dNumber=Math.cbrt(dNumber);

                if (n+2+placeNumber<=strInput.length()-1)
                    strReturn=strInput.substring(0, n)+Operations.printDoubleNumber(dNumber)+strInput.substring(n+2+placeNumber );
                else
                    strReturn=strInput.substring(0, n)+Operations.printDoubleNumber(dNumber);
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
                if (dNumber==Double.NEGATIVE_INFINITY | dNumber==Double.POSITIVE_INFINITY) {
                    throw new MyException("cos INFINITY ");
                }

                if (isNegative)  dNumber=-dNumber;
                dNumber = Math.toRadians(dNumber);
                dNumber=Math.round(Math.cos(dNumber)*scale)/scale;

                if (n+3+placeNumber<=strInput.length()-1)
                    strReturn=strInput.substring(0, n)+Operations.printDoubleNumber(dNumber)+strInput.substring(n+3+placeNumber );
                else
                    strReturn=strInput.substring(0, n)+Operations.printDoubleNumber(dNumber);

                return strReturn;
            }

            case "sin" ->{
                System.out.println("in= "+strInput);

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

                System.out.println("stringNumber= "+stringNumber);
                System.out.println("length Number= "+placeNumber);

                dNumber=Double.parseDouble(stringNumber);
                if (dNumber==Double.NEGATIVE_INFINITY | dNumber==Double.POSITIVE_INFINITY) {
                    throw new MyException("sin INFINITY ");
                }

                if (isNegative)
                    dNumber=-dNumber;
                dNumber = Math.toRadians(dNumber);
                dNumber=Math.round(Math.sin(dNumber)*scale)/scale;

                System.out.println("dRez= "+dNumber);

                if (n+3+placeNumber<=strInput.length()-1)
                    strReturn=strInput.substring(0, n)+Operations.printDoubleNumber(dNumber)+strInput.substring(n+3+placeNumber );
                else
                    strReturn=strInput.substring(0, n)+Operations.printDoubleNumber(dNumber);

                System.out.println("out= "+strReturn);
                System.out.println();

                return strReturn;
        }
//
//        case "tg" ->{
//            dResult = calculateCurrent.calculateInput( textPanel.getTextInput().getText());
//
//            long iRez=Math.round(dResult);
//            if(Math.abs(iRez)>180)
//                iRez=iRez%180;
//
//            try {
//                if (Math.abs(iRez)==90){
//                    throw new ArithmeticException();
//                }else {
//                    b = Math.toRadians(dResult);
//                    dResult = Math.round(Math.tan(b) * scale) / scale;
//                    printResult();
//                    textPanel.setSbLog("tg(" + textPanel.getTextInput().getText().trim() + ")");
//                    print_SbLog_Input();
//                }
//            } catch (ArithmeticException ex) {
//                textPanel.setStrResult("не существует");
//                textPanel.setTextRezult(textPanel.getStrResult());
//
//                textPanel.setStrInput(Operations.printNumber(dResult));
//                textPanel.setTextInput(textPanel.getStrInput());
//
//                textPanel.setSbLog("tg(" + textPanel.getTextInput().getText().trim()+")");
//                print_SbLog_Input();
//            }

//        case "ln" ->{
//            try {
//                dResult = calculateCurrent.calculateInput( textPanel.getTextInput().getText());
//                if (dResult>0) {
//                    dResult=Math.log(dResult);
//                    printResult();
//                    textPanel.setSbLog("ln(" + textPanel.getTextInput().getText().trim()+")");
//                    print_SbLog_Input();
//                }else {
//                    System.out.println("ln");
//                    throw new MyException("ln не существует");
//                }
//
//            } catch (MyException ex) {
//                System.out.println("перехвачено -" +ex);
//                textPanel.setStrResult("не существует");
//                //                        textPanel.setFontBoldResult ();          //alter font
//                textPanel.setTextRezult(textPanel.getStrResult());
//
//                textPanel.setStrInput(Operations.printNumber(dResult));
//                textPanel.setTextInput(textPanel.getStrInput());
//
//                textPanel.setSbLog("ln(" + textPanel.getTextInput().getText().trim()+")");
//                print_SbLog_Input();
//            }
//        }
//        case "lg" ->{
//            try {
//                dResult = calculateCurrent.calculateInput( textPanel.getTextInput().getText());
//                if (dResult>0) {
//                    dResult=Math.log10(dResult);
//                    printResult();
//                    textPanel.setSbLog("lg(" + textPanel.getTextInput().getText().trim()+")");
//                    print_SbLog_Input();
//                }else {
//                    throw new ArithmeticException();
//                }
//            } catch (ArithmeticException ex) {
//                textPanel.setStrResult("не существует");
//                //                        textPanel.setFontBoldResult ();          //alter font
//                textPanel.setTextRezult(textPanel.getStrResult());
//
//                textPanel.setStrInput(Operations.printNumber(dResult));
//                textPanel.setTextInput(textPanel.getStrInput());
//
//                textPanel.setSbLog("lg(" + textPanel.getTextInput().getText().trim()+")");
//                print_SbLog_Input();
//            }
//        }
//
//
//
//
        }
        return strReturn;
    }
}
