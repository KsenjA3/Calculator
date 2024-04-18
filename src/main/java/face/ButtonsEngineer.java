package face;

import calculate.Operations;
import fitting.MyColors;
import fitting.MyFonts;
import javax.swing.*;
import java.awt.event.ActionEvent;

  class ButtonsEngineer extends ButtonsBasic {
    protected double b ;
    protected JButton braceOpen;
    protected JButton braceClose;
    protected JButton bx2;
    protected JButton bx3;
    protected JButton bxn;
    protected JButton bSqrt3;
    protected JButton bLn;
    protected JButton bLg;
    protected JButton bFactorial;
    protected JButton bDevX;
    protected JButton bChageSign;
    protected JButton bSin;
    protected JButton bCos;
    protected JButton bTg;
    protected JButton bPi;
    private PanelTextLog textPanel;

    protected ButtonsEngineer(PanelTextLog textPanel) {
        super(textPanel);
        this.textPanel=textPanel;
        makeButtons();
        makeEngineerButtons();
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
        bDevX=createButton(new CreateEngineerButton("1/x"),"1/x",
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
                    dResult= Double.parseDouble(textPanel.getStrResult().substring(1));
                    dResult = -dResult;
                    printResult ();
                    textPanel.setSbLog("±"+textPanel.getStrInput().trim());
                    printSbLog();
                }
                case "x²" ->{
                    dResult= Double.parseDouble(textPanel.getStrResult().substring(1));
                    dResult = dResult*dResult;
                    printResult ();
                    textPanel.setSbLog(textPanel.getStrInput()+"²");
                    printSbLog();
                }
                case  "x³" ->{
                    dResult= Double.parseDouble(textPanel.getStrResult().substring(1));
                    dResult = dResult*dResult*dResult;
                    printResult ();
                    textPanel.setSbLog(textPanel.getStrInput()+"³");
                    printSbLog();
                }
                case "xⁿ" ->{
                    dResult= Double.parseDouble(textPanel.getStrResult().substring(1));

                    dResult = Math.pow(dResult,dNumber);
                    printResult ();
                    textPanel.setSbLog(textPanel.getStrInput()+"n");
                    printSbLog();
                }
                case  "³√" ->{
                    dResult= Double.parseDouble(textPanel.getStrResult().substring(1));
                    dResult=Math.cbrt(dResult);
                    printResult ();
                    textPanel.setSbLog("³√"+textPanel.getStrInput().trim());
                    printSbLog();
                }
                case ")" ->{

                }
                case "(" ->{

                }
                case "ln" ->{

                }
                case "lg" ->{

                }
                case "x!" ->{
                    int n;
                    try {
                        n = Integer.parseInt(textPanel.getStrResult().substring(1));
                        dResult = 1.0;
                        for (int k = 1; k <= n; k++) {
                            dResult = dResult * k;
                        }
                        printResult ();
                        textPanel.setSbLog(textPanel.getStrInput()+"!");
                        printSbLog();
                    } catch (NumberFormatException exc) {
                        textPanel.setStrResult("факториал дробного числа не существует");
//                        textPanel.setFontBoldResult ();          //alter font
                        textPanel.setTextRezult(textPanel.getStrResult());

                        textPanel.setStrInput(Operations.printNumber(dResult));
                        textPanel.setTextInput(textPanel.getStrInput());

                        textPanel.setSbLog(textPanel.getStrInput());
                        printSbLog();
                    }
                }
                case "1/x" ->{
                    dResult= Double.parseDouble(textPanel.getStrResult().substring(1));
                    if (dResult==0.0){
                        textPanel.setStrResult("делить на ноль нельзя");
//                        textPanel.setFontBoldResult ();          //alter font
                        textPanel.setTextRezult(textPanel.getStrResult());

                        textPanel.setStrInput(Operations.printNumber(dResult));
                        textPanel.setTextInput(textPanel.getStrInput());

                        textPanel.setSbLog(textPanel.getStrInput());
                        printSbLog();
                    }else {
                        dResult = 1 / dResult;
                        printResult ();
                        textPanel.setSbLog("1 / "+textPanel.getStrInput().trim());
                        printSbLog();
                    }
                }
                case "π" ->{

                }
                case "sin" ->{
                    dResult= Double.parseDouble(textPanel.getStrResult().substring(1));
                    b = Math.toRadians(dResult);
                    dResult = Math.round(Math.sin(b)*scale)/scale;
                    printResult ();
                    textPanel.setSbLog("sin("+textPanel.getStrInput().trim()+")");
                    printSbLog();
                }
                case "cos" ->{
                    dResult= Double.parseDouble(textPanel.getStrResult().substring(1));
                    b = Math.toRadians(dResult);
                    dResult = Math.round(Math.cos(b)*scale)/scale;
                    printResult ();
                    textPanel.setSbLog("cos("+textPanel.getStrInput().trim()+")");
                    printSbLog();
                }
                case "tg" ->{
                    dResult= Double.parseDouble(textPanel.getStrResult().substring(1));
                    b = Math.toRadians(dResult);
                    dResult = Math.round(Math.tan(b)*scale)/scale;
                    printResult ();
                    textPanel.setSbLog("tg("+textPanel.getStrInput().trim()+")");
                    printSbLog();
                }
            }

            unblockedAll(bPercent);       // work  % without mistakes
            strNumber = "0";              // if after = go "."
            func = null;
            textPanel.setStrInput("   ");    // input number after =
        }

    }
}
