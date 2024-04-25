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
//                    dResult = calculateCurrent.calculateInput( textPanel.getTextInput().getText());
//                        dResult = -dResult;
//                        printResult ();
//                        textPanel.setSbLog("±("+textPanel.getTextInput().getText().trim()+")");
//                        print_SbLog_Input();
                }
                case "x²" ->{
                    textPanel.setFontBoldInput ();
                    replaceRepeatedSign_always (textPanel);
                    replaceRepeatedSign_exceptSimple(textPanel);
                    replaceRepeatedSign_simple(textPanel);
                    printSign("²");

                    func = Operations::pow;

                    nameSign = "²";
                }
                case  "x³" ->{
                    textPanel.setFontBoldInput ();
                    replaceRepeatedSign_always (textPanel);
                    replaceRepeatedSign_exceptSimple(textPanel);
                    replaceRepeatedSign_simple(textPanel);
                    printSign("³");

                    func = Operations::pow;

                    nameSign = "³";
                }

                case "xⁿ" ->{
                    textPanel.setFontBoldInput ();
                    replaceRepeatedSign_always (textPanel);
                    replaceRepeatedSign_exceptSimple(textPanel);
                    replaceRepeatedSign_simple(textPanel);
                    printSign("^");

                    func = Operations::pow;

                    nameSign = "^";
                }
                case "1/x" ->{
                    textPanel.setFontBoldInput ();
                    replaceRepeatedSign_always (textPanel);
                    replaceRepeatedSign_exceptSimple(textPanel);
                    replaceRepeatedSign_simple(textPanel);
                    printSign("^(-1)");

                    func = Operations::pow;

                    nameSign = "^(-1)";
                }
                case "x!" ->{
                    textPanel.setFontBoldInput ();
                    replaceRepeatedSign_always (textPanel);
                    replaceRepeatedSign_exceptSimple(textPanel);
                    replaceRepeatedSign_simple(textPanel);
                    printSign("!");

                    func = Operations::pow;

                    nameSign = "!";
                }

                case  "³√" ->{
                    textPanel.setFontBoldInput ();
                    replaceRepeatedSign_always (textPanel);
                    replaceRepeatedSign_exceptSimple(textPanel);
                    printSign("³√");
                }

                case "ln" ->{
                    textPanel.setFontBoldInput ();
                    replaceRepeatedSign_always (textPanel);
                    replaceRepeatedSign_exceptSimple(textPanel);
                    printSign("ln(");
                }
                case "lg" ->{
                    textPanel.setFontBoldInput ();
                    replaceRepeatedSign_always (textPanel);
                    replaceRepeatedSign_exceptSimple(textPanel);
                    printSign("lg(");
                }
                case "sin" ->{
                    textPanel.setFontBoldInput ();
                    replaceRepeatedSign_always (textPanel);
                    replaceRepeatedSign_exceptSimple(textPanel);
                    printSign("sin(");
                }
                case "cos" ->{
                    textPanel.setFontBoldInput ();
                    replaceRepeatedSign_always (textPanel);
                    replaceRepeatedSign_exceptSimple(textPanel);
                    printSign("cos(");
                }
                case "tg" -> {
                    textPanel.setFontBoldInput ();
                    replaceRepeatedSign_always (textPanel);
                    replaceRepeatedSign_exceptSimple(textPanel);
                    printSign("tg(");
                }

                case "π" ->{
                    str=textPanel.getTextInput().getText();
                    str=str.substring(0,str.length()-strNumber.length());
                    dNumber = Math.PI;

                   strInput= str+dNumber.toString();
                    textPanel.setTextInput(strInput);

                    dResult = calculateCurrent.calculateInput(textPanel.getTextInput().getText());
                    strInput="=" + Operations.printNumber(dResult);
                    unblockedAll(bPercent);       // work  % without mistakes
                    textPanel.setTextResult(strInput);
                }
                case ")"  ->{
                    str=textPanel.getTextInput().getText().trim();
                    switch (str.charAt(str.length()-1)) {
                        case '0','1','2','3','4','5','6','7','8','9',')' -> {
                            countBrace--;
                            strInput=textPanel.getTextInput().getText() + name;
                            textPanel.setTextInput(strInput);
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
                            strInput=str+" * "+name;
                            textPanel.setTextInput(strInput);
                        }
                        case '.'-> {
                            strInput=str+"0 * "+name;
                            textPanel.setTextInput(strInput);
                        }
                        default -> {
                            strInput=str+name;
                            textPanel.setTextInput(strInput);
                        }
                    }

                    unblockedAll(braceClose);
                    blockedAll(bPlus, bMinus, bDivide, bMultiply, bPercent,
                            bResult, bMemoryAdd, bMemoryDel, bMemoryHold);
                    blockedAll(bSin, bCos, bTg, bLg, bLn,bx3, bx2, bxn,
                            bChageSign, bFactorial, bDivX,  bSqrt3);
                }
            }
        }
    }
}
