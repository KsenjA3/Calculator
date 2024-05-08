package face;

import calculate.Operations;
import fitting.MyColors;
import fitting.MyFonts;
import org.apache.commons.lang3.StringUtils;

import javax.swing.*;
import java.awt.event.ActionEvent;

class ButtonsEngineer extends ButtonsBasic {
    private PanelTextLog textPanel;

    protected ButtonsEngineer(PanelTextLog textPanel) {
        super(textPanel);
        this.textPanel=textPanel;
        makeButtons();
        makeEngineerButtons();

        countBrace=0;
        blockedAll(braceClose);
    }

    /**
     * create engineer Buttons
     */
     void makeEngineerButtons() {

        braceClose=createButton(new CreateEngineerButton(")"),")",KeyStroke.getKeyStroke(')'),
                MyColors.COLOR_SIGN.get(), MyFonts.FONT_BUTTON.get() );
        bx2=createButton(new CreateEngineerButton("x²"),"x²",
                MyColors.COLOR_SIGN.get(), MyFonts.FONT_BUTTON_MIDDLE.get() );
        bx3=createButton(new CreateEngineerButton("x³"),"x³",
                MyColors.COLOR_SIGN.get(), MyFonts.FONT_BUTTON_MIDDLE.get() );
        bxn=createButton(new CreateEngineerButton("xⁿ"),"xⁿ",
                MyColors.COLOR_SIGN.get(), MyFonts.FONT_BUTTON_MIDDLE.get() );
        bSqrt3=createButton(new CreateEngineerButton("³√"),"³√",
                MyColors.COLOR_SIGN.get(), MyFonts.FONT_BUTTON_MIDDLE.get() );

        braceOpen=createButton(new CreateEngineerButton("("),"(",KeyStroke.getKeyStroke('('),
                MyColors.COLOR_SIGN.get(), MyFonts.FONT_BUTTON.get() );
        bLn=createButton(new CreateEngineerButton("ln"),"ln",
                MyColors.COLOR_SIGN.get(), MyFonts.FONT_BUTTON_MIDDLE.get() );
        bLg=createButton(new CreateEngineerButton("lg"),"lg",
                MyColors.COLOR_SIGN.get(), MyFonts.FONT_BUTTON_MIDDLE.get() );
        bFactorial=createButton(new CreateEngineerButton("x!"),"x!",KeyStroke.getKeyStroke('!'),
                MyColors.COLOR_SIGN.get(), MyFonts.FONT_BUTTON_MIDDLE.get() );
        bDivX=createButton(new CreateEngineerButton("1/x"),"1/x",
                MyColors.COLOR_SIGN.get(), MyFonts.FONT_BUTTON_BOTTOM.get() );

        bChageSign=createButton(new CreateEngineerButton("±"),"±",
                MyColors.COLOR_SIGN.get(), MyFonts.FONT_BUTTON_MIDDLE.get() );
        bSin=createButton(new CreateEngineerButton("sin"),"sin",
                MyColors.COLOR_SIGN.get(), MyFonts.FONT_BUTTON_LOW.get() );
        bCos=createButton(new CreateEngineerButton("cos"),"cos",
                MyColors.COLOR_SIGN.get(), MyFonts.FONT_BUTTON_LOW.get() );
        bTg=createButton(new CreateEngineerButton("tg"),"tg",
                MyColors.COLOR_SIGN.get(), MyFonts.FONT_BUTTON_MIDDLE.get() );
        bPi=createButton(new CreateEngineerButton("π"),"π",
                MyColors.COLOR_SIGN.get(), MyFonts.FONT_BUTTON_MIDDLE.get() );
    }

    class CreateEngineerButton extends AbstractAction {
        String name;

        CreateEngineerButton(String nameButton) {
            super(nameButton);
            name = nameButton;
        }
        @Override
        public void actionPerformed(ActionEvent e) {
//            double scale= Math.pow(10,15);

            if (textPanel.memoryMR == null)   blockedAll(bMemoryHold, bMemoryDel);
            else     unblockedAll(bMemoryHold,bMemoryDel);


            String str;
            switch (name){
                case ")"  ->{
                    str =textPanel.getTextInput().getText().trim();
                    switch (str.charAt(str.length()-1)) {
                        case '0','1','2','3','4','5','6','7','8','9',')','²', '³', '!' -> {
                            countBrace--;
                            strInput=strInput + name;
                            textPanel.setTextInput(strInput);
                        }
                    }

                    if (countBrace<=0) {
                        blockedAll(braceClose);
                        unblockedAll(bPlus, bMinus, bDivide, bMultiply, bPercent,bResult, bMemoryAdd, bMemoryDel, bMemoryHold);
                        unblockedAll(bSin, bCos, bTg, bLg, bLn,bx3, bx2, bxn,bChageSign, bFactorial, bDivX,  bSqrt3);
                    }
                }
                case "(" ->{
                    countBrace ++;
                    str =textPanel.getTextInput().getText().trim();

                    if (str.length()>=1)
                        switch (str.charAt(str.length() - 1)) {
                            case '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', ')', '²', '³', '!' ->{
                                unblockedAll(b0,b1,b2,b3,b4,b5,b6,b7,b8,b9,bPi,bPercent,bRadical); // after blocked x²,x³,1/x,x!
                                strInput = str + "*" + name;
                            }
                            case '.' ->
                                strInput = str.substring(0, str.length() - 1) + "*" + name;
                            default ->
                                strInput = str + name;

                        }
                    else strInput= str +name;

                    textPanel.setTextInput(strInput);

                    unblockedAll(braceClose);
                    blockedAll(bPlus,  bDivide, bMultiply, bPercent,bResult, bMemoryAdd);
                    blockedAll(bSin, bCos, bTg, bLg, bLn,bx3, bx2, bxn,bChageSign, bFactorial, bDivX,  bSqrt3);

                }
                case "π" ->{
                    strInput =textPanel.getTextInput().getText().trim();

                    if (!strInput.trim().equals("") &&
                         StringUtils.endsWithAny(strInput,"0","1","2","3","4","5","6","7","8","9",".")) {
// логика замены цифры, находящейся перед PI, на число PI
//                        hashMap = Operations.findNumber_beforeSign(str);
//                        placeNumber = hashMap.keySet().stream().findFirst().get();
//                        dNumber = hashMap.get(placeNumber);
//                        str = str.substring(0, str.length() - Operations.printNumber(dNumber).length());

// логика перемножения цифры, находящейся перед PI, на  само число PI
                        strInput = strInput +"*";
                    }
                    if (strInput.endsWith("%")   |   strInput.startsWith("±")
                            | ( strInput.trim().equals(strResult.substring(1).trim()) &&  strNumber.equals("0")  && func==null)
                    ) strInput="   ";
                    if (strInput.endsWith(")"))
                        strInput=strInput+"*";

                    dNumber = Math.PI;
                    strInput= strInput +dNumber;
                    textPanel.setTextInput(strInput);

                    try {
                        dResult = calculateCurrent.calculateInput(strInput);
                        strResult="=" + Operations.printNumber(dResult);
                        unblockedAll(bPercent);       // work  % without mistakes
                    }catch (MyException myException){
                        strResult = myException.getMessage();
                        blockedAll(bPlus, bMinus, bDivide, bMultiply, bPercent, bRadical, bResult, bMemoryAdd,
                                        b0,b1,b2,b3,b4,b5,b6,b7,b8,b9,bPoint);
                        try {
                            blockedAll(bPi, bSin,bCos,bTg,bLg,bLn,bFactorial,bDivX,bxn,bx2,bx3,bSqrt3,
                                    bChageSign,braceOpen,braceClose);
                        }catch (NullPointerException exception){  }
                    }
                    textPanel.setTextResult(strResult);
                }
                case "x²" ->{
                    strInput= textPanel.getTextInput().getText();
                    textPanel.setFontBoldInput ();
                    replaceRepeatedSign_always ();
                    replaceRepeatedSign_simple();
                    replaceRepeatedSign_exceptSimple();
                    printSign("²");
                    try {
                        dResult = calculateCurrent.calculateInput(strInput);
                        strResult="=" + Operations.printNumber(dResult);
                        textPanel.setFontBoldResult ();          //alter font
                        blockedAll(b0,b1,b2,b3,b4,b5,b6,b7,b8,b9,bPoint,bPi,bPercent,bRadical,bMemoryHold);
                    }catch (MyException myException){
                        strResult = myException.getMessage();
                        blockedAll(bPlus, bMinus, bDivide, bMultiply, bPercent, bRadical, bResult, bMemoryAdd,
                                b0,b1,b2,b3,b4,b5,b6,b7,b8,b9,bPoint);
                        try {
                            blockedAll(bPi, bSin,bCos,bTg,bLg,bLn,bFactorial,bDivX,bxn,bx2,bx3,bSqrt3,
                                    bChageSign,braceOpen,braceClose);
                        }catch (NullPointerException exception){  }
                    }
                    textPanel.setTextResult(strResult);
                }
                case  "x³" ->{
                    strInput= textPanel.getTextInput().getText();
                    textPanel.setFontBoldInput ();
                    replaceRepeatedSign_always ();
                    replaceRepeatedSign_simple();
                    replaceRepeatedSign_exceptSimple();
                    printSign("³");
                    try {
                        dResult = calculateCurrent.calculateInput(strInput);
                        strResult="=" + Operations.printNumber(dResult);
                        textPanel.setFontBoldResult ();          //alter font
                        blockedAll(b0,b1,b2,b3,b4,b5,b6,b7,b8,b9,bPoint,bPi,bPercent,bRadical,bMemoryHold);
                    }catch (MyException myException){
                        strResult = myException.getMessage();
                        blockedAll(bPlus, bMinus, bDivide, bMultiply, bPercent, bRadical, bResult, bMemoryAdd,
                                b0,b1,b2,b3,b4,b5,b6,b7,b8,b9,bPoint);
                        try {
                            blockedAll(bPi, bSin,bCos,bTg,bLg,bLn,bFactorial,bDivX,bxn,bx2,bx3,bSqrt3,
                                    bChageSign,braceOpen,braceClose);
                        }catch (NullPointerException exception){  }
                    }
                    textPanel.setTextResult(strResult);
                }
                case "±"-> {
                    strInput=textPanel.getTextInput().getText();

                    try {
                        dResult = calculateCurrent.calculateInput( strInput);
                        dResult = -dResult;
                        strInput="±("+textPanel.getTextInput().getText().trim()+")";
                        textPanel.setTextInput(strInput);
                        textPanel.setSbLog(strInput);
                        printResult ();
                        print_SbLog();
                    }catch (MyException myException){
                        strResult = myException.getMessage();
                        textPanel.setTextResult(strResult);
                        blockedAll(bPlus, bMinus, bDivide, bMultiply, bPercent, bRadical, bResult, bMemoryAdd,
                                b0,b1,b2,b3,b4,b5,b6,b7,b8,b9,bPoint);
                        try {
                            blockedAll(bPi, bSin,bCos,bTg,bLg,bLn,bFactorial,bDivX,bxn,bx2,bx3,bSqrt3,
                                    bChageSign,braceOpen,braceClose);
                        }catch (NullPointerException exception){  }

                    }



                }
                case "xⁿ" ->{
                    strInput= textPanel.getTextInput().getText();
                    textPanel.setFontBoldInput ();
                    replaceRepeatedSign_always ();
                    replaceRepeatedSign_simple();
                    replaceRepeatedSign_exceptSimple();
                    printSign("^");
                    func = Operations::pow;
                }
                case "1/x" ->{
                    strInput= textPanel.getTextInput().getText();

                    textPanel.setFontBoldInput ();
                    replaceRepeatedSign_always ();
                    replaceRepeatedSign_simple();
                    replaceRepeatedSign_exceptSimple();

                    printSign("^(-1)");
                    try {
                        dResult = calculateCurrent.calculateInput(strInput);
                        strResult="=" + Operations.printNumber(dResult);
                        blockedAll(b0,b1,b2,b3,b4,b5,b6,b7,b8,b9,bPoint,bPi,bPercent,bRadical,bMemoryHold);
                    }catch ( ArithmeticException  ex){
                        if (ex.getMessage().equals("Division by zero")) {
                            strResult = "делить на 0 нельзя";
                            blockedAll(bPlus, bMinus, bDivide, bMultiply, bPercent, bRadical,
                                    b0,b1,b2,b3,b4,b5,b6,b7,b8,b9,bPoint,bPi,
                                    bResult, bMemoryAdd, bMemoryDel, bMemoryHold,
                                    bSin,bCos,bTg,bLg,bLn,bFactorial,bDivX,bxn,bx2,bx3,bSqrt3,
                                    bChageSign,braceOpen,braceClose
                            );
                        }
                    }catch (MyException myException){
                    strResult = myException.getMessage();
                        blockedAll(bPlus, bMinus, bDivide, bMultiply, bPercent, bRadical, bResult, bMemoryAdd,
                                b0,b1,b2,b3,b4,b5,b6,b7,b8,b9,bPoint);
                    try {
                        blockedAll(bPi, bSin,bCos,bTg,bLg,bLn,bFactorial,bDivX,bxn,bx2,bx3,bSqrt3,
                                bChageSign,braceOpen,braceClose);
                    }catch (NullPointerException exception){  }
                }
                    textPanel.setFontBoldResult ();          //alter font
                    textPanel.setTextResult(strResult);
                }



                case "x!" ->{
                    strInput= textPanel.getTextInput().getText();
                    textPanel.setFontBoldInput ();
                    replaceRepeatedSign_always ();
                    replaceRepeatedSign_simple();
                    replaceRepeatedSign_exceptSimple();
                    printSign("!");

                    try {
                        dResult = calculateCurrent.calculateInput(strInput);
                        strResult="=" + Operations.printNumber(dResult);
                        textPanel.setFontBoldResult ();          //alter font
                        blockedAll(b0,b1,b2,b3,b4,b5,b6,b7,b8,b9,bPoint,bPi,bPercent,bRadical,bMemoryHold);
                    }catch (MyException myException){
                        strResult = myException.getMessage();
                        blockedAll(bPlus, bMinus, bDivide, bMultiply, bPercent, bRadical, bResult, bMemoryAdd,
                                b0,b1,b2,b3,b4,b5,b6,b7,b8,b9,bPoint);
                        try {
                            blockedAll(bPi, bSin,bCos,bTg,bLg,bLn,bFactorial,bDivX,bxn,bx2,bx3,bSqrt3,
                                    bChageSign,braceOpen,braceClose);
                        }catch (NullPointerException exception){  }
                    }
                    textPanel.setTextResult(strResult);


                }

                case  "³√" ->{
                    textPanel.setFontBoldInput ();
                    replaceRepeatedSign_always ();
                    replaceRepeatedSign_exceptSimple();
                    printSign("³√");
                }

                case "ln" ->{
                    textPanel.setFontBoldInput ();
                    replaceRepeatedSign_always ();
                    replaceRepeatedSign_exceptSimple();
                    printSign("ln(");
                }
                case "lg" ->{
                    textPanel.setFontBoldInput ();
                    replaceRepeatedSign_always ();
                    replaceRepeatedSign_exceptSimple();
                    printSign("lg(");
                }
                case "sin" ->{
                    textPanel.setFontBoldInput ();
                    replaceRepeatedSign_always ();
                    replaceRepeatedSign_exceptSimple();
                    printSign("sin(");
                }
                case "cos" ->{
                    textPanel.setFontBoldInput ();
                    replaceRepeatedSign_always ();
                    replaceRepeatedSign_exceptSimple();
                    printSign("cos(");
                }
                case "tg" -> {
                    textPanel.setFontBoldInput ();
                    replaceRepeatedSign_always ();
                    replaceRepeatedSign_exceptSimple();
                    printSign("tg(");
                }



            }
        }
    }
}
