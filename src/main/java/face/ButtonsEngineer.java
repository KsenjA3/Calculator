package face;

import calculate.Operations;
import fitting.MyColors;
import fitting.MyFonts;
import javax.swing.*;
import java.awt.event.ActionEvent;

  class ButtonsEngineer extends ButtonsBasic {
    private   String str;
    protected double b ;

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
        braceClose=createButton(new CreateEngineerButton(")"),")",
                MyColors.COLOR_SIGN.get(), MyFonts.FONT_BUTTON.get() );
        bx2=createButton(new CreateEngineerButton("x²"),"x²",
                MyColors.COLOR_SIGN.get(), MyFonts.FONT_BUTTON_MIDDLE.get() );
        bx3=createButton(new CreateEngineerButton("x³"),"x³",
                MyColors.COLOR_SIGN.get(), MyFonts.FONT_BUTTON_MIDDLE.get() );
        bxn=createButton(new CreateEngineerButton("xⁿ"),"xⁿ",
                MyColors.COLOR_SIGN.get(), MyFonts.FONT_BUTTON_MIDDLE.get() );
        bSqrt3=createButton(new CreateEngineerButton("³√"),"³√",
                MyColors.COLOR_SIGN.get(), MyFonts.FONT_BUTTON_MIDDLE.get() );

        braceOpen=createButton(new CreateEngineerButton("("),"(",
                MyColors.COLOR_SIGN.get(), MyFonts.FONT_BUTTON.get() );
        bLn=createButton(new CreateEngineerButton("ln"),"ln",
                MyColors.COLOR_SIGN.get(), MyFonts.FONT_BUTTON_MIDDLE.get() );
        bLg=createButton(new CreateEngineerButton("lg"),"lg",
                MyColors.COLOR_SIGN.get(), MyFonts.FONT_BUTTON_MIDDLE.get() );
        bFactorial=createButton(new CreateEngineerButton("x!"),"x!",
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

            double scale= Math.pow(10,15);


            switch (name){
                case "±"-> {
                    dResult = calculateCurrent.calculateInput( textPanel.getTextInput().getText());
                        dResult = -dResult;
                        printResult ();
                        textPanel.setSbLog("±("+textPanel.getTextInput().getText().trim()+")");
                        print_SbLog_Input();
                }
                case "x²" ->{
                    dResult = calculateCurrent.calculateInput( textPanel.getTextInput().getText());
                        dResult = dResult*dResult;
                        printResult ();
                        textPanel.setSbLog("("+textPanel.getTextInput().getText().trim()+")²");
                        print_SbLog_Input();
                }
                case  "x³" ->{
                    dResult = calculateCurrent.calculateInput( textPanel.getTextInput().getText());
                        dResult = dResult*dResult*dResult;
                        printResult ();
                        textPanel.setSbLog("("+textPanel.getTextInput().getText().trim()+")³");
                        print_SbLog_Input();
                }
  // пересмотреть Log и м.б. сам алгоритм расчета с учетом скобок
                case "xⁿ" ->{
                    textPanel.setFontBoldInput ();
                    strNumber = "0";                      //prepare to input new number
                    N = 0;
                    unblockedAll(bPoint);       // allow double
                    blockedAll(bPercent);       // work  % without mistakes

                    Print_and_replaceRepeatedSign(" ^ ");
//                    if (func==null && textPanel.getStrInput()=="   ") {
//                        textPanel.setStrInput(Operations.printNumber(dResult) + name);
//                        textPanel.setTextInput(textPanel.getStrInput());
//                    }else {
//                        textPanel.setStrInput(textPanel.getStrInput() + name);
//                        textPanel.setTextInput(textPanel.getStrInput());
//                    }
//                    dResultPercent = dResult;
                    func = Operations::pow;

                    nameSign = " ^ ";
                    strInputFormerSign = textPanel.getStrInput();
                }
                case  "³√" ->{
                    dResult = calculateCurrent.calculateInput( textPanel.getTextInput().getText());
                        dResult=Math.cbrt(dResult);
                        printResult ();
                        textPanel.setSbLog("³√("+textPanel.getTextInput().getText().trim()+")");
                        print_SbLog_Input();
                }
                case "π" ->{
                    str=textPanel.getTextInput().getText();
                    str=str.substring(0,str.length()-strNumber.length());
                    dNumber = Math.PI;

                    textPanel.setStrInput(str+dNumber.toString());
                    textPanel.setTextInput(textPanel.getStrInput());

                    dResult = calculateCurrent.calculateInput(textPanel.getStrInput());
                    textPanel.setStrResult("=" + Operations.printNumber(dResult));
                    unblockedAll(bPercent);       // work  % without mistakes
                    textPanel.setTextRezult(textPanel.getStrResult());
                }
                case ")"  ->{
                    str=textPanel.getTextInput().getText().trim();
                    switch (str.charAt(str.length()-1)) {
                        case '0','1','2','3','4','5','6','7','8','9',')' -> {
                            countBrace--;
                            textPanel.setStrInput(textPanel.getTextInput().getText() + name);
                            textPanel.setTextInput(textPanel.getStrInput());
                        }
                    }

                    if (countBrace<=0) {
                        blockedAll(braceClose);
                        unblockedAll(bPlus, bMinus, bDivide, bMultiply, bPercent,
                                bResult, bMemoryAdd, bMemoryDel, bMemoryHold);
                        unblockedAll(bSin, bCos, bTg, bLg, bLn,bx3, bx2, bxn,
                                bChageSign, bFactorial, bDivX,  bSqrt3);
                    }

                }
                case "(" ->{
                    countBrace ++;
                    str=textPanel.getTextInput().getText().trim();
                    switch (str.charAt(str.length()-1)) {
                        case '0','1','2','3','4','5','6','7','8','9',')'-> {
                            textPanel.setStrInput(str+" * "+name);
                            textPanel.setTextInput(textPanel.getStrInput());
                        }
                        case '.'-> {
                            textPanel.setStrInput(str+"0 * "+name);
                            textPanel.setTextInput(textPanel.getStrInput());
                        }
                        default -> {
                            textPanel.setStrInput(str+name);
                            textPanel.setTextInput(textPanel.getStrInput());
                        }
                    }

                    System.out.println("="+str+"=");
                    unblockedAll(braceClose);
                    blockedAll(bPlus, bMinus, bDivide, bMultiply, bPercent,
                            bResult, bMemoryAdd, bMemoryDel, bMemoryHold);
                    blockedAll(bSin, bCos, bTg, bLg, bLn,bx3, bx2, bxn,
                            bChageSign, bFactorial, bDivX,  bSqrt3);


                }
                case "ln" ->{
                    try {
                        dResult = calculateCurrent.calculateInput( textPanel.getTextInput().getText());
                        if (dResult>0) {
                            dResult=Math.log(dResult);
                            printResult();
                            textPanel.setSbLog("ln(" + textPanel.getTextInput().getText().trim()+")");
                            print_SbLog_Input();
                        }else {
System.out.println("ln");
                            throw new MyException("ln не существует");
                        }

                    } catch (MyException ex) {
System.out.println("перехвачено -" +ex);
                        textPanel.setStrResult("не существует");
                        //                        textPanel.setFontBoldResult ();          //alter font
                        textPanel.setTextRezult(textPanel.getStrResult());

                        textPanel.setStrInput(Operations.printNumber(dResult));
                        textPanel.setTextInput(textPanel.getStrInput());

                        textPanel.setSbLog("ln(" + textPanel.getTextInput().getText().trim()+")");
                        print_SbLog_Input();
                    }
                }
                case "lg" ->{
                    try {
                        dResult = calculateCurrent.calculateInput( textPanel.getTextInput().getText());
                        if (dResult>0) {
                            dResult=Math.log10(dResult);
                            printResult();
                            textPanel.setSbLog("lg(" + textPanel.getTextInput().getText().trim()+")");
                            print_SbLog_Input();
                        }else {
                            throw new ArithmeticException();
                        }
                    } catch (ArithmeticException ex) {
                        textPanel.setStrResult("не существует");
                        //                        textPanel.setFontBoldResult ();          //alter font
                        textPanel.setTextRezult(textPanel.getStrResult());

                        textPanel.setStrInput(Operations.printNumber(dResult));
                        textPanel.setTextInput(textPanel.getStrInput());

                        textPanel.setSbLog("lg(" + textPanel.getTextInput().getText().trim()+")");
                        print_SbLog_Input();
                    }
                }
                case "x!" ->{
                    int n;
                    try {
                        n = Integer.parseInt(textPanel.getStrResult().substring(1));
                        if (n<0) {
                            throw new NumberFormatException ();
                        } else {
                            dResult = 1.0;
                            for (int k = 1; k <= n; k++) {
                                dResult = dResult * k;
                            }
                            printResult ();
                            textPanel.setSbLog("("+textPanel.getTextInput().getText().trim()+")!");
                            print_SbLog_Input();
                        }
                    } catch (NumberFormatException exc) {
System.out.println("factorial catch");
                        textPanel.setStrResult("неверный формат ввода");
//                        textPanel.setFontBoldResult ();          //alter font
                        textPanel.setTextRezult(textPanel.getStrResult());

                        textPanel.setStrInput(Operations.printNumber(dResult)+"!");
                        textPanel.setTextInput(textPanel.getStrInput());

                        textPanel.setSbLog(textPanel.getStrInput());
                        print_SbLog_Input();
                    }
                }
                case "1/x" ->{
                    try {
                        dResult = calculateCurrent.calculateInput( textPanel.getTextInput().getText());
                        if (dResult==0.0){
                            throw new ArithmeticException();
                        }else {
                               dResult = 1 / dResult;
                               printResult ();
                               textPanel.setSbLog("1 / ("+textPanel.getTextInput().getText().trim()+")");
                               print_SbLog_Input();
                        }
                    } catch (ArithmeticException ex) {
                        textPanel.setStrResult("делить на ноль нельзя");
                        //                        textPanel.setFontBoldResult ();          //alter font
                        textPanel.setTextRezult(textPanel.getStrResult());
                        textPanel.setSbLog("1/ ("+textPanel.getTextInput().getText().trim()+")");
                        print_SbLog_Input();
                    }

                }
                case "sin" ->{
                    dResult = calculateCurrent.calculateInput(textPanel.getTextInput().getText() );
                        b = Math.toRadians(dResult);
                        dResult = Math.round(Math.sin(b)*scale)/scale;
                        printResult ();
                        textPanel.setSbLog("sin("+textPanel.getTextInput().getText().trim()+")");
                        print_SbLog_Input();
                }
                case "cos" ->{
                        dResult = calculateCurrent.calculateInput( textPanel.getTextInput().getText());
                        b = Math.toRadians(dResult);
                        dResult = Math.round(Math.cos(b)*scale)/scale;
                        printResult ();
                        textPanel.setSbLog("cos("+textPanel.getTextInput().getText().trim()+")");
                        print_SbLog_Input();
                }
                case "tg" ->{
                    dResult = calculateCurrent.calculateInput( textPanel.getTextInput().getText());

                    long iRez=Math.round(dResult);
                    if(Math.abs(iRez)>180)
                        iRez=iRez%180;

                    try {
                        if (Math.abs(iRez)==90){
                            throw new ArithmeticException();
                        }else {
                            b = Math.toRadians(dResult);
                            dResult = Math.round(Math.tan(b) * scale) / scale;
                            printResult();
                            textPanel.setSbLog("tg(" + textPanel.getTextInput().getText().trim() + ")");
                            print_SbLog_Input();
                        }
                    } catch (ArithmeticException ex) {
                        textPanel.setStrResult("не существует");
                        textPanel.setTextRezult(textPanel.getStrResult());

                        textPanel.setStrInput(Operations.printNumber(dResult));
                        textPanel.setTextInput(textPanel.getStrInput());

                        textPanel.setSbLog("tg(" + textPanel.getTextInput().getText().trim()+")");
                        print_SbLog_Input();
                    }

                }
            }


        }

    }
}
