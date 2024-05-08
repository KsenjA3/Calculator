package face;

import calculate.CalculateInput;
import calculate.CalculateBasic;
import calculate.Operations;
import calculate.calculate;
import fitting.MyColors;
import fitting.MyFonts;
import org.apache.commons.lang3.StringUtils;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.util.HashMap;

public class ButtonsBasic extends ButtonsAll{

    private PanelTextLog textPanel;

    /**
     * restriction amount  input figures to number
     */
    protected int N;
    protected int countSqrt;        //no more than 3
    protected int countBrace;
    /**
     * in number
     */
    protected String strNumber;
    protected Double dNumber;

    /**
     * type function
     */
    protected calculate func;
    /**
     * for calculator.calculate.calculate Percent
     *  divide for 0, input number after %
     * number after %
     * result before former sign
     */
    protected String nameSign;
    protected String strPersentFrom;
    protected String strBeforePersent;

    /**
     * object for calculation
     */
    protected CalculateInput calculateCurrent;
    protected CalculateBasic calculateBasic;
    private HashMap<String,JButton> listButtons;
    protected Double dResult;

    protected String countResult;




    protected ButtonsBasic(PanelTextLog textPanel) {
        this.textPanel=textPanel;

        N = 0;
        strNumber = "0";
        dNumber = 0.0;
        dResult=0.0;
        func = null;
        nameSign = "";
        strInput="   ";
        strResult="0";
                        //create object for calculation
        calculateCurrent = new CalculateInput();
        calculateBasic= new CalculateBasic();
        listButtons = new HashMap<>();
        makeButtons();
    }

    /**
     * get map of buttons
     * @return list of buttons with  name keys
     */
    protected HashMap <String,JButton>  getButtons () {
        return listButtons;
    }

    /**
     * create ALL Buttons
     */
    protected void makeButtons() {

        //SIMPLE CALCULATOR

                            //Numbers
        b1 = createButton(new CreateActionNumberButton("1"),
                "1", KeyStroke.getKeyStroke('1') , MyColors.COLOR_BUTTON.get(), MyFonts.FONT_BUTTON.get());
        b2 = createButton(new CreateActionNumberButton("2"),
                "2", KeyStroke.getKeyStroke('2'),MyColors.COLOR_BUTTON.get(), MyFonts.FONT_BUTTON.get());
        b3 = createButton(new CreateActionNumberButton("3"),
                "3", KeyStroke.getKeyStroke('3'),MyColors.COLOR_BUTTON.get(), MyFonts.FONT_BUTTON.get());
        b4 = createButton(new CreateActionNumberButton("4"),
                "4", KeyStroke.getKeyStroke('4'),MyColors.COLOR_BUTTON.get(), MyFonts.FONT_BUTTON.get());
        b5 = createButton(new CreateActionNumberButton("5"),
                "5", KeyStroke.getKeyStroke('5'),MyColors.COLOR_BUTTON.get(), MyFonts.FONT_BUTTON.get());
        b6 = createButton(new CreateActionNumberButton("6"),
                "6", KeyStroke.getKeyStroke('6'),MyColors.COLOR_BUTTON.get(), MyFonts.FONT_BUTTON.get());
        b7 = createButton(new CreateActionNumberButton("7"),
                "7", KeyStroke.getKeyStroke('7'),MyColors.COLOR_BUTTON.get(), MyFonts.FONT_BUTTON.get());
        b8 = createButton(new CreateActionNumberButton("8"),
                "8", KeyStroke.getKeyStroke('8'),MyColors.COLOR_BUTTON.get(), MyFonts.FONT_BUTTON.get());
        b9 = createButton(new CreateActionNumberButton("9"),
                "9", KeyStroke.getKeyStroke('9'),MyColors.COLOR_BUTTON.get(), MyFonts.FONT_BUTTON.get());
        b0 = createButton(new CreateActionNumberButton("0"),
                "0", KeyStroke.getKeyStroke('0'),MyColors.COLOR_BUTTON.get(), MyFonts.FONT_BUTTON.get());
        bPoint = createButton(new CreateActionNumberButton("."),
                ".", KeyStroke.getKeyStroke('.'),MyColors.COLOR_BUTTON.get(), MyFonts.FONT_BUTTON.get());


                            //calculator.calculate.Operations
        bPlus = createButton(new CreateSignButton(" + "),
                " + ", KeyStroke.getKeyStroke('+'), MyColors.COLOR_SIGN.get(), MyFonts.FONT_BUTTON.get());
        bMinus = createButton(new CreateSignButton(" - "),
                " - ", KeyStroke.getKeyStroke('-'), MyColors.COLOR_SIGN.get(), MyFonts.FONT_BUTTON.get());
        bDivide = createButton(new CreateSignButton(" / "),
                " / ", KeyStroke.getKeyStroke('/'), MyColors.COLOR_SIGN.get(), MyFonts.FONT_BUTTON.get());
        bMultiply = createButton(new CreateSignButton(" * "),
                " * ", KeyStroke.getKeyStroke('*'), MyColors.COLOR_SIGN.get(), MyFonts.FONT_BUTTON.get());
        bPercent = createButton(new CreateSignButton(" % "),
                " % ", KeyStroke.getKeyStroke('%'), MyColors.COLOR_SIGN.get(), MyFonts.FONT_BUTTON.get());
        bResult = createButton(new CreateSignButton(" = "),
                " = ", KeyStroke.getKeyStroke('='), MyColors.COLOR_SIGN.get(), MyFonts.FONT_BUTTON.get());
        bRadical = createButton(new CreateSignButton(" √ "),
                " √ ",  MyColors.COLOR_SIGN.get(), MyFonts.FONT_BUTTON.get());


                                //Delete and Memory
        bClear = createButton(new CreateWorkButton("AC"),
                "AC", KeyStroke.getKeyStroke(KeyEvent.VK_DELETE, 0), MyColors.COLOR_BUTTON_MEMORY.get(), MyFonts.FONT_BUTTON_MEMORY.get());
        bDel = createButton(new CreateWorkButton("C"),
                "C", KeyStroke.getKeyStroke(KeyEvent.VK_BACK_SPACE, 0), MyColors.COLOR_BUTTON_MEMORY.get(), MyFonts.FONT_BUTTON_MEMORY.get());
        bMemoryAdd = createButton(new CreateWorkButton("M+"),
                "M+", KeyStroke.getKeyStroke(KeyEvent.VK_ADD, InputEvent.CTRL_DOWN_MASK), MyColors.COLOR_BUTTON_MEMORY.get(), MyFonts.FONT_BUTTON_MEMORY.get());
        bMemoryDel = createButton(new CreateWorkButton("M-"),
                "M-", KeyStroke.getKeyStroke(KeyEvent.VK_SUBTRACT, InputEvent.CTRL_DOWN_MASK), MyColors.COLOR_BUTTON_MEMORY.get(), MyFonts.FONT_BUTTON_MEMORY.get());
        bMemoryHold = createButton(new CreateWorkButton("MR"),
                "MR", KeyStroke.getKeyStroke(KeyEvent.VK_M, 0), MyColors.COLOR_BUTTON_MEMORY.get(), MyFonts.FONT_BUTTON_MEMORY.get());

        if (textPanel.memoryMR == null)
            blockedAll(bMemoryHold);
        else
            unblockedAll(bMemoryHold);
    }

    /**
     *create Button
     * @param bAction behavior button
     * @param name object to link InputMap with ActionMap
     * @param keyStroke name key linked with button
     * @param color color button
     * @param font font button
     * @return button
     */
    protected JButton createButton(Action bAction, String name,
                                 KeyStroke keyStroke, Color color, Font font) {
        b = new JButton(bAction);
        b.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(keyStroke, name);
        b.getActionMap().put(name, bAction);
        b.setBackground(color);
        b.setFont(font);
        var borderButton = BorderFactory.createEtchedBorder(EtchedBorder.RAISED);
        b.setBorder(borderButton);

        listButtons.put(name, b);

        if (name.equals(" = ")) {
            b.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), "name=");
            b.getActionMap().put("name=", bAction);
        }
        return b;
    }
    protected JButton createButton(Action bAction, String name,
                          Color color, Font font) {
        b = new JButton(bAction);
        b.setBackground(color);
        b.setFont(font);
        var borderButton = BorderFactory.createEtchedBorder(EtchedBorder.RAISED);
        b.setBorder(borderButton);

        listButtons.put(name, b);
        return b;
    }



    /**
     * behavior number Buttons
     */
    class CreateActionNumberButton extends AbstractAction {
        String name;
        CreateActionNumberButton(String nameButton) {
            super(nameButton);
            name=nameButton;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            String name = e.getActionCommand();

            strInput= textPanel.getTextInput().getText();
            if (strInput.endsWith("%")   |   strInput.startsWith("±")
                    | ( strInput.trim().equals(strResult.substring(1).trim()) &&  strNumber.equals("0")  && func==null)
               ) strInput="   ";
            if (strInput.endsWith(")"))
                strInput=strInput+"*";


            textPanel.setFontBoldInput ();   //alter fonts
            countSqrt=0;
            if (N < 15) {
                N++;

                strNumber = strNumber + name;
                if (strNumber.equals("0.") && name.equals(".")) {    //output in beginning
                    strInput=strInput + strNumber;
                }
                else if (StringUtils.equalsAny(strNumber.trim(),"00","01","02","03","04","05","06","07","08","09") ) {
                    strNumber = strNumber.trim().substring(1);
                    if ( StringUtils.endsWithAny(strInput,"0", " ")) {
                         strInput = strInput.substring(0, strInput.length() - 1) + name;
                         N--;
                     }else   strInput=strInput + name;
                }
                else{
                    strInput=strInput + name;
                }
                dNumber = Double.parseDouble(strNumber);
                textPanel.setTextInput(strInput);


                try {                                       // except divide for 0
                    dResult = calculateCurrent.calculateInput(strInput);
                    strResult="=" + Operations.printNumber(dResult);

                    unblockedAll(bPlus, bMinus, bDivide, bMultiply, bPercent,
                            bResult, bMemoryAdd);
                    try {
                        unblockedAll(bSin, bCos, bTg, bLg, bLn,bx3, bx2, bxn,
                                bChageSign, bFactorial, bDivX,  bSqrt3, bPi, braceOpen);
                    }catch (NullPointerException exception){  }
                }catch ( ArithmeticException  ex){
                    if (ex.getMessage().equals("Division by zero")) {
                        strResult = "делить на 0 нельзя";
                        blockedAll(bPlus, bMinus, bDivide, bMultiply, bPercent, bRadical,
                                bResult, bMemoryAdd);
                        try {
                            blockedAll(bPi, bSin,bCos,bTg,bLg,bLn,bFactorial,bDivX,bxn,bx2,bx3,bSqrt3,
                                    bChageSign,braceOpen,braceClose);
                        }catch (NullPointerException exception){  }
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

                textPanel.setTextResult(strResult);


                if (name.equals(".")) {
                    blockedAll(bPoint);   //two points couldn't bу in one number
                    unblockedAll(b1, b2, b3, b4, b5, b6, b7, b8, b9, b0,     // unblocked keys during attempt divide to  zero
                            bResult, bMemoryAdd, bDel,
                            bPlus, bMinus, bDivide, bMultiply, bPercent, bRadical);
                }

                if (textPanel.memoryMR == null)   blockedAll(bMemoryHold, bMemoryDel);
                else     unblockedAll(bMemoryHold,bMemoryDel);

            }
        }
    }


    /**
     * behavior operation Buttons
     */
    class CreateSignButton extends AbstractAction {
        String name;

        CreateSignButton(String nameButton) {
            super(nameButton);
            name = nameButton;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            textPanel.setFontBoldInput ();      //alter fonts
            strNumber = "0";                      //prepare to input new number
            N = 0;


            strInput= textPanel.getTextInput().getText();
            if (strInput.endsWith("%")   |   strInput.startsWith("±"))
                strInput=Operations.printNumber(dResult);


            unblockedAll(bPlus, bMinus, bDivide, bMultiply, bPercent, bRadical,    // after blocked x²,x³,1/x,x!
                    b0,b1,b2,b3,b4,b5,b6,b7,b8,b9,bPoint,
                    bResult, bMemoryAdd );
            try {
                unblockedAll(bPi, bSin,bCos,bTg,bLg,bLn,bFactorial,bDivX,bxn,bx2,bx3,bSqrt3,
                        bChageSign,braceOpen);
            }catch (NullPointerException ex){  }

            if (textPanel.memoryMR == null)   blockedAll(bMemoryHold, bMemoryDel);
            else     unblockedAll(bMemoryHold,bMemoryDel);



            switch (name) {
                case " √ " -> {
                    if (countSqrt<3) {
                        strInput=strInput + name.trim();
                        textPanel.setTextInput(strInput);
                    }
                    countSqrt++;
                }
                case " + " -> {
                    replaceRepeatedSign_always ();
                    replaceRepeatedSign_simple();
                    printSign("+");
                    func = Operations::plus;
                }
                case " - " -> {
                    replaceRepeatedSign_always ();
                    replaceRepeatedSign_simple();
                    printSign("-");
                    func = Operations::minus;
                }
                case " * " -> {
                    replaceRepeatedSign_always ();
                    replaceRepeatedSign_simple();
                    printSign("*");
                    func = Operations::multiply;
                }
                case " / " -> {
                    replaceRepeatedSign_always ();
                    replaceRepeatedSign_simple();
                    printSign("/");
                    func = Operations::divide;
                }
                case " % " -> {
                    unblockedAll(bPercent);       // work  % without mistakes
                    textPanel.setFontBoldInput ();
                    replaceRepeatedSign_always ();
                    replaceRepeatedSign_exceptSimple();
                    replaceRepeatedSign_simple();

                    String str=StringUtils.deleteWhitespace(strInput);
//System.out.println();
//System.out.println("begin str= "+str);

                    int nOpenBraces= StringUtils.countMatches(str, "(");
                    int nCloseBraces= StringUtils.countMatches(str, ")");
                    int placeOpen ;
                    int placeClose;
                    boolean isSign= false;
//dNumber and nameSign
                    if (str.endsWith(")")){
                        try {
                            placeOpen=StringUtils.lastIndexOf(str,"(");
                            dNumber=calculateCurrent.calculateInput(str.substring(placeOpen));
                            if (placeOpen==0){
                                nameSign="no";
                                str="  ";
                            }else{
                                nameSign=str.substring(placeOpen-1,placeOpen);
                                str=str.substring(0,placeOpen-1);
                            }

                        }catch (MyException myException){
                            strResult = myException.getMessage();
                            blockedAll(bPlus, bMinus, bDivide, bMultiply, bPercent, bRadical, bResult, bMemoryAdd,
                                    b0,b1,b2,b3,b4,b5,b6,b7,b8,b9,bPoint);
                            try {
                                blockedAll(bPi, bSin,bCos,bTg,bLg,bLn,bFactorial,bDivX,bxn,bx2,bx3,bSqrt3,
                                        bChageSign,braceOpen,braceClose);
                            }catch (NullPointerException exception){  }

                            textPanel.setTextResult(strResult);
                            break;
                        }

                    }
                    else {
                        for (int i=str.length()-1; i>=0; i--) {
                            switch (str.charAt(i)) {
                                case '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '.' -> {
                                    if (i==0) {
                                        dNumber=Double.parseDouble(str);
                                        nameSign="no";
                                        str="  ";
                                    }
                                }
                                default -> {
                                    dNumber=Double.parseDouble(str.substring(i+1));
                                    nameSign=str.substring(i,i+1);
                                    str=str.substring(0,i);
                                    isSign=true;
                                }
                            }
                            if (isSign)break;
                        }
                    }
//System.out.println("from+ before str= "+str);

//вариант, когда % находится от части выражения, например 20+(200+5%)
                    strBeforePersent=" ";
                    strPersentFrom=str;

                    if (nOpenBraces>nCloseBraces){
                        if (nCloseBraces==0){
                            placeOpen=StringUtils.lastIndexOf(str,"(");
                            strBeforePersent = strPersentFrom.substring(0, placeOpen);
                            strPersentFrom=strPersentFrom.substring(placeOpen+1);
                        }


                        for (int i=1; i<=nCloseBraces;i++){
                            placeOpen=StringUtils.lastIndexOf(str,"(");
                            placeClose=StringUtils.lastIndexOf(str,")");
                            if (placeOpen>placeClose) {
                                strBeforePersent = strPersentFrom.substring(0, placeOpen);
                                strPersentFrom=strPersentFrom.substring(placeOpen+1);
                                break;
                            }
                            else
                                str=str.substring(0, placeOpen);
                        }
                    }

                    try {
// от dResult находиться %
                        dResult=calculateCurrent.calculateInput(strPersentFrom);
                        //System.out.println("strBeforePersent= "+strBeforePersent);
                        //System.out.println("strResult= "+strResult);
                        //System.out.println("dResult= "+dResult);
                        //System.out.println("nameSign= "+nameSign);
                        //System.out.println("dNumber= "+dNumber);
//найденный %
                        dResult = calculateBasic.calculatePersent(nameSign,dResult, dNumber);
//окончательный ответ
                        dResult=calculateCurrent.calculateInput(strBeforePersent+Operations.printNumber(dResult));
//printSign("%") отличается if, который влияет на √
                        if (func==null ) {
                            strInput=Operations.printNumber(dResult) + name.trim();
                            textPanel.setTextInput(strInput);
                        }else {
                            strInput=strInput + name.trim();
                            textPanel.setTextInput(strInput);
                        }

                        textPanel.setSbLog(strInput.trim());
                        printResult ();
                        print_SbLog ();
                    }catch (MyException myException){
                        strResult = myException.getMessage();
                        blockedAll(bPlus, bMinus, bDivide, bMultiply, bPercent, bRadical, bResult, bMemoryAdd,
                                b0,b1,b2,b3,b4,b5,b6,b7,b8,b9,bPoint);
                        try {
                            blockedAll(bPi, bSin,bCos,bTg,bLg,bLn,bFactorial,bDivX,bxn,bx2,bx3,bSqrt3,
                                    bChageSign,braceOpen,braceClose);
                        }catch (NullPointerException exception){  }

                        textPanel.setTextResult(strResult);
                    }
                }
                case " = " -> {
                    dResult= Double.parseDouble(textPanel.getTextResult().getText().substring(1));
                    textPanel.setSbLog(strInput.trim());
                    print_SbLog ();
                    printResult ();
                    strInput=Operations.printNumber(dResult);
                    textPanel.setTextInput(strInput);
                }
            }
        }
    }


    /**
     * behavior  remember and delete Buttons
     */
    class CreateWorkButton extends AbstractAction {
        String name;

        CreateWorkButton(String nameButton) {
            super(nameButton);
            name = nameButton;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            strInput= textPanel.getTextInput().getText();

            switch (name) {

                case "M+" -> {
                    textPanel.memoryMR = dResult;
                    unblockedAll(bMemoryHold, bMemoryDel);
                }
                case "M-" -> {
                    textPanel.memoryMR = null;
                    blockedAll(bMemoryHold);
                }
                case "MR" -> {
                    dNumber = textPanel.memoryMR;
                    strInput=textPanel.getTextInput().getText();

                    if (StringUtils.endsWithAny(strInput.trim(), "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", ".")){
                        boolean isFormerNumber = true;

                        while (isFormerNumber) {
                            strInput=strInput.substring(0,  strInput.length() - 1);
                            textPanel.setTextInput(strInput);

                            if (!StringUtils.endsWithAny(strInput.trim(), "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "."))
                                isFormerNumber = false;
                        }
                    }
                    if (strInput.endsWith("%")   |   strInput.startsWith("±")
                            | ( strInput.trim().equals(strResult.substring(1).trim()) &&  strNumber.equals("0")  && func==null)
                    ) strInput="   ";
                    if (strInput.endsWith(")"))
                        strInput=strInput+"*";

                    strInput=strInput+ Operations.printNumber(textPanel.memoryMR);
                    textPanel.setTextInput(strInput);

                    try {                                       // except divide for 0
                        dResult = calculateCurrent.calculateInput(strInput);
                        strResult="=" + Operations.printNumber(dResult);

                        unblockedAll(bPlus, bMinus, bDivide, bMultiply, bPercent,bResult, bMemoryAdd);
                        try {
                            unblockedAll(bSin, bCos, bTg, bLg, bLn,bx3, bx2, bxn,
                                    bChageSign, bFactorial, bDivX,  bSqrt3, bPi, braceOpen);
                        }catch (NullPointerException exception){  }
                    }catch ( ArithmeticException  ex){
                        if (ex.getMessage().equals("Division by zero")) {
                            strResult = "делить на 0 нельзя";
                            blockedAll(bPlus, bMinus, bDivide, bMultiply, bPercent, bRadical,
                                         bResult, bMemoryAdd, bMemoryDel, bMemoryHold);
                            try {
                                blockedAll(bPi, bSin,bCos,bTg,bLg,bLn,bFactorial,bDivX,bxn,bx2,bx3,bSqrt3,
                                        bChageSign,braceOpen,braceClose);
                            }catch (NullPointerException exception){  }
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
                    textPanel.setTextResult(strResult);
                }
                case "AC" -> {
                    unblockedAll(bPlus, bMinus, bDivide, bMultiply, bPercent, bRadical,    // after blocked x²,x³,1/x,x!
                            b0,b1,b2,b3,b4,b5,b6,b7,b8,b9,bPoint, bResult, bMemoryAdd );
                    try {
                        unblockedAll(bPi, bSin,bCos,bTg,bLg,bLn,bFactorial,bDivX,bxn,bx2,bx3,bSqrt3, bChageSign,braceOpen);
                    }catch (NullPointerException ex){  }

                    if (textPanel.memoryMR == null)   blockedAll(bMemoryHold, bMemoryDel);
                    else     unblockedAll(bMemoryHold,bMemoryDel);

                    countBrace=0;
                    dNumber = 0.0;
                    strNumber = "0";
                    N=0;

                    textPanel.setTextResult("0");
                    strInput="   ";   //number after АС
                    textPanel.setTextInput( strInput);
                    func = null;
                    dResult = 0.0;                // sign after АС
                    nameSign = " ";               //after sqrt
                    strResult="0";  // AC then =, textRez
//                    textPanel.setTextResult(strResult);
                }
                case "C" -> {
                    strInput=textPanel.getTextInput().getText();
                    if (strInput.length()==0) break;

                    if (StringUtils.endsWithAny(strInput,"0","1","2","3","4","5","6","7","8","9",".")){
                        if (strNumber.length() > 1)          //beginning work
                            strNumber = strNumber.substring(0, strNumber.length() - 1);
                        N--;
                    }

                    if (strResult.equals("делить на 0 нельзя")) {
                        strInput = strInput.substring(0, strInput.length() - 2);
                        N=0;
                        strNumber="0";
                    } else
                        strInput=strInput.substring(0,  strInput.length() - 1);
                    textPanel.setTextInput(strInput);

                    try {
                        dResult = calculateCurrent.calculateInput( strInput);
                        strResult="=" + Operations.printNumber(dResult);
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



                    unblockedAll(bPlus, bMinus, bDivide, bMultiply, bPercent, bRadical,    // after blocked x²,x³,1/x,x!
                            b0,b1,b2,b3,b4,b5,b6,b7,b8,b9,bPoint,bResult, bMemoryAdd );
                    try {
                        unblockedAll(bPi, bSin,bCos,bTg,bLg,bLn,bFactorial,bDivX,bxn,bx2,bx3,bSqrt3, bChageSign,braceOpen,braceClose);
                    }catch (NullPointerException ex){  }

                    if (textPanel.memoryMR == null)   blockedAll(bMemoryHold, bMemoryDel);
                    else     unblockedAll(bMemoryHold,bMemoryDel);
                }
            }
        }
    }



    /**
     * block keys on panel calculator
     * @param v blocking keys
     */
     static void blockedAll(JButton... v) {
        for (JButton b : v)
            b.setEnabled(false);
    }

    /**
     * unblock keys on panel calculator
     * @param v unblocking keys
     */
     static void unblockedAll(JButton... v) {
        for (JButton b : v)
            b.setEnabled(true);
    }
     void printResult (){
        strResult="=" + Operations.printNumber(dResult);
        textPanel.setFontBoldResult ();          //alter font
        textPanel.setTextResult(strResult);

         unblockedAll(bPercent);       // work  % without mistakes
         strNumber = "0";              // if after = go ".
         N=0;
         func = null;
    }
    void print_SbLog (){
        textPanel.setSbLog("\n");
        textPanel.setSbLog(textPanel.getTextResult().getText());
        textPanel.setSbLog("\n");
        textPanel.setTextLog( textPanel.getSbLog().toString());
    }

    void printSign (String name) {
        if (func==null && strInput.equals("   ")) {
            strInput=Operations.printNumber(dResult) + name;
            textPanel.setTextInput(strInput);
        }else {
            strInput=strInput + name;
            textPanel.setTextInput(strInput);
        }
    }
}
