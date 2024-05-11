package calculate;

import org.apache.commons.lang3.StringUtils;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.HashMap;

public class CalculateEngineer {

    private String strReturn;
    final double threshold = 0.000000001;

    public String calculateEngineer (String strInput, String name ) {


        HashMap<Integer, Double> hashMap;
        int placeNumber;
        BigDecimal dResult;
        Double dNumber;
        int n;
        switch (name){

            case "²" ->{
                boolean isNegative = false;
                n = StringUtils.indexOf(strInput, "²");

                hashMap =Operations.findNumber_beforeSign(strInput.substring(0, n));
                placeNumber = hashMap.keySet().stream().findFirst().get();
                dNumber = hashMap.get(placeNumber);
                dResult = new BigDecimal(dNumber);
                dResult=dResult.pow(2);

                if((placeNumber ==1   &&   strInput.charAt(0)=='-')  |
                        (placeNumber >1   &&   strInput.charAt(placeNumber -1)=='-')   &&
                        !StringUtils.endsWithAny(strInput.substring(0, placeNumber -1), "0","1","2","3","4","5","6","7","8","9",".") )
                {
                    isNegative =true;
                }
                if (isNegative){
                    if (strInput.length() > n + 1)
                        strReturn = strInput.substring(0, placeNumber -1) + dResult + strInput.substring(n + 1);
                    else
                        strReturn = strInput.substring(0, placeNumber -1) + dResult;

                }else {

                    if (strInput.length() > n + 1)
                        strReturn = strInput.substring(0, placeNumber) + dResult + strInput.substring(n + 1);
                    else
                        strReturn = strInput.substring(0, placeNumber) + dResult;
                }

                return strReturn;
            }
            case  "³" ->{
                n =StringUtils.indexOf(strInput, "³");

                hashMap =Operations.findNumber_beforeSign(strInput.substring(0, n));
                placeNumber = hashMap.keySet().stream().findFirst().get();
                dNumber = hashMap.get(placeNumber);
                dResult = new BigDecimal(dNumber);
                dResult=dResult.pow(3);

                if (strInput.length()> n +1)
                    strReturn=strInput.substring(0, placeNumber)+dResult+strInput.substring(n +1);
                else
                    strReturn=strInput.substring(0, placeNumber)+dResult;

                return strReturn;
            }

            case "!" -> {
                n = StringUtils.indexOf(strInput, "!");
                hashMap = Operations.findNumber_beforeSign(strInput.substring(0, n));
                placeNumber = hashMap.keySet().stream().findFirst().get();
                dNumber = hashMap.get(placeNumber);
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



//        case  "³√" ->{
//            dResult = calculateCurrent.calculateInput( textPanel.getTextInput().getText());
//            dResult=Math.cbrt(dResult);
//            printResult ();
//            textPanel.setSbLog("³√("+textPanel.getTextInput().getText().trim()+")");
//            print_SbLog_Input();
//        }


//            case "1/x" ->{
//            try {
//                dResult = calculateCurrent.calculateInput( textPanel.getTextInput().getText());
//                if (dResult==0.0){
//                    throw new ArithmeticException();
//                }else {
//                    dResult = 1 / dResult;
//                    printResult ();
//                    textPanel.setSbLog("1 / ("+textPanel.getTextInput().getText().trim()+")");
//                    print_SbLog_Input();
//                }
//            } catch (ArithmeticException ex) {
//                textPanel.setStrResult("делить на ноль нельзя");
//                //                        textPanel.setFontBoldResult ();          //alter font
//                textPanel.setTextRezult(textPanel.getStrResult());
//                textPanel.setSbLog("1/ ("+textPanel.getTextInput().getText().trim()+")");
//                print_SbLog_Input();
//            }
//        }


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
//        case "sin" ->{
//            dResult = calculateCurrent.calculateInput(textPanel.getTextInput().getText() );
//            b = Math.toRadians(dResult);
//            dResult = Math.round(Math.sin(b)*scale)/scale;
//            printResult ();
//            textPanel.setSbLog("sin("+textPanel.getTextInput().getText().trim()+")");
//            print_SbLog_Input();
//        }
//        case "cos" ->{
//            dResult = calculateCurrent.calculateInput( textPanel.getTextInput().getText());
//            b = Math.toRadians(dResult);
//            dResult = Math.round(Math.cos(b)*scale)/scale;
//            printResult ();
//            textPanel.setSbLog("cos("+textPanel.getTextInput().getText().trim()+")");
//            print_SbLog_Input();
//        }
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
//
        }
        return strReturn;
    }
}
