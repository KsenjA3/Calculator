package calculate;

import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;

public class CalculateEngineer {

    private String strReturn;

    public String calculateEngineer (String strInput, String name ) {


        HashMap<Integer, Double> hashMap;
        int placeNumber;
        double dResult;
        double dNumber;
        int n;
        switch (name){

            case "²" ->{
                boolean isNegative = false;
                n = StringUtils.indexOf(strInput, "²");

                hashMap =Operations.findNumber_beforeSign(strInput.substring(0, n));
                placeNumber = hashMap.keySet().stream().findFirst().get();
                dNumber = hashMap.get(placeNumber);
                dResult = dNumber * dNumber;

                if((placeNumber ==1   &&   strInput.charAt(0)=='-')  |
                        (placeNumber >1   &&   strInput.charAt(placeNumber -1)=='-')   &&
                        !StringUtils.endsWithAny(strInput.substring(0, placeNumber -1), "0","1","2","3","4","5","6","7","8","9",".") )
                {
                    isNegative =true;
                }
                if (isNegative){
                    if (strInput.length() > n + 1)
                        strReturn = strInput.substring(0, placeNumber -1) + Operations.printNumber(dResult) + strInput.substring(n + 1);
                    else
                        strReturn = strInput.substring(0, placeNumber -1) + Operations.printNumber(dResult);

                }else {

                    if (strInput.length() > n + 1)
                        strReturn = strInput.substring(0, placeNumber) + Operations.printNumber(dResult) + strInput.substring(n + 1);
                    else
                        strReturn = strInput.substring(0, placeNumber) + Operations.printNumber(dResult);
                }

                return strReturn;
            }
            case  "³" ->{
                n =StringUtils.indexOf(strInput, "³");

                hashMap =Operations.findNumber_beforeSign(strInput.substring(0, n));
                placeNumber = hashMap.keySet().stream().findFirst().get();
                dNumber = hashMap.get(placeNumber);
                dResult = dNumber * dNumber * dNumber;

                if (strInput.length()> n +1)
                    strReturn=strInput.substring(0, placeNumber)+Operations.printNumber(dResult)+strInput.substring(n +1);
                else
                    strReturn=strInput.substring(0, placeNumber)+Operations.printNumber(dResult);

                return strReturn;
            }

//            case "x!" ->{
//            int n;
//            try {
//                n = Integer.parseInt(textPanel.getStrResult().substring(1));
//                if (n<0) {
//                    throw new NumberFormatException ();
//                } else {
//                    dResult = 1.0;
//                    for (int k = 1; k <= n; k++) {
//                        dResult = dResult * k;
//                    }
//                    printResult ();
//                    textPanel.setSbLog("("+textPanel.getTextInput().getText().trim()+")!");
//                    print_SbLog_Input();
//                }
//            } catch (NumberFormatException exc) {
//                System.out.println("factorial catch");
//                textPanel.setStrResult("неверный формат ввода");
////                        textPanel.setFontBoldResult ();          //alter font
//                textPanel.setTextRezult(textPanel.getStrResult());
//
//                textPanel.setStrInput(Operations.printNumber(dResult)+"!");
//                textPanel.setTextInput(textPanel.getStrInput());
//
//                textPanel.setSbLog(textPanel.getStrInput());
//                print_SbLog_Input();
//            }
//        }


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
