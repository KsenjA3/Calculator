package face;

import calculate.Operations;
import fitting.MyColors;
import fitting.MyFonts;
import org.apache.commons.lang3.StringUtils;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.math.BigDecimal;

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

            strInput= textPanel.getTextInput().getText();

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

                    if (!strInput.trim().equals("") &&
                         StringUtils.endsWithAny(strInput,"0","1","2","3","4","5","6","7","8","9",".")) {
// логика замены цифры, находящейся перед PI, на число PI
//                        hashMap = Operations.findNumber_beforeSign(str);
//                        placeNumber = hashMap.keySet().stream().findFirst().get();
//                        strNumber = hashMap.get(placeNumber);
//                        str = str.substring(0, str.length() - strNumber.length());

// логика перемножения цифры, находящейся перед PI, на  само число PI
                        strInput = strInput +"*";
                    }
                    if (strInput.endsWith("%")   |   strInput.startsWith("±")
                            | ( strInput.trim().equals(strResult.substring(1).trim()) &&  strNumber.equals("0")  && func==null)
                    ) strInput="   ";
                    if (strInput.endsWith(")"))
                        strInput=strInput+"*";

                    double dNumber = Math.PI;
                    strInput= strInput +dNumber;
                    textPanel.setTextInput(strInput);

                    try {
                        countResult = calculateCurrent.calculateInput(strInput);
                        strResult="=" + countResult;
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
                    if (strInput.trim().equals(""))  strInput="0";
                    textPanel.setFontBoldInput ();
                    replaceRepeatedSign_always ();
                    replaceRepeatedSign_simple();
                    replaceRepeatedSign_exceptSimple();
                    printSign("²");
                    try {
                        countResult = calculateCurrent.calculateInput(strInput);
                        bigDecimal=new BigDecimal(countResult,Operations.mathContext);
                        strResult="=" + bigDecimal;
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
                    if (strInput.trim().equals(""))  strInput="0";
                    textPanel.setFontBoldInput ();
                    replaceRepeatedSign_always ();
                    replaceRepeatedSign_simple();
                    replaceRepeatedSign_exceptSimple();
                    printSign("³");
                    try {
                        countResult = calculateCurrent.calculateInput(strInput);
                        bigDecimal=new BigDecimal(countResult,Operations.mathContext);
                        strResult="=" + bigDecimal;
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
                    try {
                        countResult = calculateCurrent.calculateInput( strInput);
                        countResult = calculateCurrent.calculateInput( "-"+countResult);
                        printResult ();
                        strInput="±("+textPanel.getTextInput().getText().trim()+")";
                        textPanel.setTextInput(strInput);
                        textPanel.setSbLog(strInput);
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
                    if (strInput.trim().equals(""))  strInput="0";
                    textPanel.setFontBoldInput ();
                    replaceRepeatedSign_always ();
                    replaceRepeatedSign_simple();
                    replaceRepeatedSign_exceptSimple();
                    printSign("^");
                    func = Operations::pow;
                }
                case "1/x" ->{
                    if (strInput.trim().equals(""))  strInput="0";
                    textPanel.setFontBoldInput ();
                    replaceRepeatedSign_always ();
                    replaceRepeatedSign_simple();
                    replaceRepeatedSign_exceptSimple();

                    printSign("^(-1)");
                    try {
                        countResult = calculateCurrent.calculateInput(strInput);
                        bigDecimal=new BigDecimal(countResult,Operations.mathContext);
                        strResult="=" + bigDecimal;
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
                    if (strInput.trim().equals(""))  {
                        strInput="0";
                    }

                    textPanel.setFontBoldInput ();
                    replaceRepeatedSign_always ();
                    replaceRepeatedSign_simple();
                    replaceRepeatedSign_exceptSimple();
                    printSign("!");

                    try {
                        countResult = calculateCurrent.calculateInput(strInput);
                        bigDecimal=new BigDecimal(countResult,Operations.mathContext);
                        strResult="=" + bigDecimal;
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

// limit variable double
                case  "³√" ->{
                    replaceRepeatedSign_always ();
                    replaceRepeatedSign_simple();
                    replaceRepeatedSign_exceptSimple();
                    if (!strInput.trim().equals("") &&
                        StringUtils.endsWithAny(strInput,"0","1","2","3","4","5","6","7","8","9",".")) {
                        strInput = strInput +"*";
                    }
                    printSign("³√(");
                }

                case "ln" ->{
                    textPanel.setFontBoldInput ();
                    replaceRepeatedSign_always ();
                    replaceRepeatedSign_exceptSimple();
                    if (!strInput.trim().equals("") &&
                            StringUtils.endsWithAny(strInput,"0","1","2","3","4","5","6","7","8","9",".")) {
                        strInput = strInput +"*";
                    }
                    printSign("ln(");
                }
                case "lg" ->{
                    textPanel.setFontBoldInput ();
                    replaceRepeatedSign_always ();
                    replaceRepeatedSign_exceptSimple();
                    if (!strInput.trim().equals("") &&
                            StringUtils.endsWithAny(strInput,"0","1","2","3","4","5","6","7","8","9",".")) {
                        strInput = strInput +"*";
                    }
                    printSign("lg(");
                }

                case "sin" ->{
                    textPanel.setFontBoldInput ();
                    replaceRepeatedSign_always ();
                    replaceRepeatedSign_exceptSimple();
                    if (!strInput.trim().equals("") &&
                            StringUtils.endsWithAny(strInput,"0","1","2","3","4","5","6","7","8","9",".")) {
                        strInput = strInput +"*";
                    }
                    printSign("sin(");
                }
                case "cos" ->{
                    textPanel.setFontBoldInput ();
                    replaceRepeatedSign_always ();
                    replaceRepeatedSign_exceptSimple();
                    if (!strInput.trim().equals("") &&
                            StringUtils.endsWithAny(strInput,"0","1","2","3","4","5","6","7","8","9",".")) {
                        strInput = strInput +"*";
                    }
                    printSign("cos(");
                }
                case "tg" -> {
                    textPanel.setFontBoldInput ();
                    replaceRepeatedSign_always ();
                    replaceRepeatedSign_exceptSimple();
                    if (!strInput.trim().equals("") &&
                            StringUtils.endsWithAny(strInput,"0","1","2","3","4","5","6","7","8","9",".")) {
                        strInput = strInput +"*";
                    }
                    printSign("tg(");
                }
            }
        }
    }
}
