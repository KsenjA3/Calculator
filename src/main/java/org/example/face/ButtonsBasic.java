package org.example.face;

import lombok.extern.log4j.Log4j2;
import org.example.calculate.CalculateInput;
import org.example.calculate.Operations;
import org.example.calculate.calculate;
import org.example.fitting.MyColors;
import org.example.fitting.MyFonts;
import org.apache.commons.lang3.StringUtils;
import org.example.fitting.MyFormatNumbers;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.math.BigDecimal;
import java.util.HashMap;
@Log4j2
public class ButtonsBasic extends ButtonsAll {

    private final PanelTextLog textPanel;

    /**
     * restriction amount  input figures to number
     */
    protected int N;
    protected int countSqrt;        //no more than 3


    /**
     * in number
     */
    protected String strNumber;

    /**
     * type function
     */
    protected calculate func;


    /**
     * object for calculation
     */
    protected CalculateInput calculateCurrent;
    private HashMap<String, JButton> listButtons;

    protected String countResult;
    protected BigDecimal bigDecimal;

    protected ButtonsBasic(PanelTextLog textPanel) {
        this.textPanel = textPanel;
        N = 0;
        strNumber = "0";
        countResult = "0";
        func = null;
        strInput = "   ";
        strResult = "0";

        //create object for calculation
        calculateCurrent = new CalculateInput();
        listButtons = new HashMap<>();
        makeButtons();
    }

    /**
     * get map of buttons
     *
     * @return list of buttons with  name keys
     */
    protected HashMap<String, JButton> getButtons() {
        return listButtons;
    }

    /**
     * create ALL Buttons
     */
    protected void makeButtons() {

        //SIMPLE CALCULATOR

        //Numbers
        b1 = createButton(new CreateActionNumberButton("1"),
                "1", KeyStroke.getKeyStroke('1'), MyColors.COLOR_BUTTON.get(), MyFonts.FONT_BUTTON.get());
        b2 = createButton(new CreateActionNumberButton("2"),
                "2", KeyStroke.getKeyStroke('2'), MyColors.COLOR_BUTTON.get(), MyFonts.FONT_BUTTON.get());
        b3 = createButton(new CreateActionNumberButton("3"),
                "3", KeyStroke.getKeyStroke('3'), MyColors.COLOR_BUTTON.get(), MyFonts.FONT_BUTTON.get());
        b4 = createButton(new CreateActionNumberButton("4"),
                "4", KeyStroke.getKeyStroke('4'), MyColors.COLOR_BUTTON.get(), MyFonts.FONT_BUTTON.get());
        b5 = createButton(new CreateActionNumberButton("5"),
                "5", KeyStroke.getKeyStroke('5'), MyColors.COLOR_BUTTON.get(), MyFonts.FONT_BUTTON.get());
        b6 = createButton(new CreateActionNumberButton("6"),
                "6", KeyStroke.getKeyStroke('6'), MyColors.COLOR_BUTTON.get(), MyFonts.FONT_BUTTON.get());
        b7 = createButton(new CreateActionNumberButton("7"),
                "7", KeyStroke.getKeyStroke('7'), MyColors.COLOR_BUTTON.get(), MyFonts.FONT_BUTTON.get());
        b8 = createButton(new CreateActionNumberButton("8"),
                "8", KeyStroke.getKeyStroke('8'), MyColors.COLOR_BUTTON.get(), MyFonts.FONT_BUTTON.get());
        b9 = createButton(new CreateActionNumberButton("9"),
                "9", KeyStroke.getKeyStroke('9'), MyColors.COLOR_BUTTON.get(), MyFonts.FONT_BUTTON.get());
        b0 = createButton(new CreateActionNumberButton("0"),
                "0", KeyStroke.getKeyStroke('0'), MyColors.COLOR_BUTTON.get(), MyFonts.FONT_BUTTON.get());
        bPoint = createButton(new CreateActionNumberButton("."),
                ".", KeyStroke.getKeyStroke('.'), MyColors.COLOR_BUTTON.get(), MyFonts.FONT_BUTTON.get());


        //calculator.org.example.calculate.Operations
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
                " √ ", MyColors.COLOR_SIGN.get(), MyFonts.FONT_BUTTON.get());


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
     * create Button
     * every button is put into HashMap listButtons
     *
     * @param bAction   behavior button
     * @param name      object to link InputMap with ActionMap
     * @param keyStroke name key linked with button
     * @param color     color button
     * @param font      font button
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
            name = nameButton;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            String name = e.getActionCommand();
            strInput = textPanel.getTextInput().getText();
            textPanel.setFontBoldInput();   //alter fonts
            countSqrt = 0;

            if (strInput.endsWith("%") | strInput.startsWith("±") |
                    (strInput.trim().equals(strResult.substring(1).trim()) && strNumber.equals("0") && func == null))
                strInput = "   ";

            if (strInput.endsWith(")"))
                strInput = strInput + "*";


//            if (N < 15) {
//                N++;
                strNumber = strNumber + name;

                /** IT panel binary numbers
                 * ввод нуля вначале числа
                 */
                if (calculateCurrent.getFormat().equals(MyFormatNumbers.FORMAT_BIN.get())) {
                    strInput = strInput + name;
                }
                else {
                    if (N < 15) {
                        N++;

                        /**начало ввода с точки
                         *
                         */
                        if (strNumber.equals("0.") && name.equals(".")) {    // in beginning
                            if (StringUtils.endsWithAny(strInput, "0", " ")) {
                                strInput = strInput.substring(0, strInput.length() - 1) + strNumber;
                                N--;
                            } else strInput = strInput + strNumber;


                        }
                        /**исключить  ноль в начале числа
                         *
                         */
                        else if (StringUtils.equalsAny(strNumber.trim(), "00", "01", "02", "03", "04", "05", "06", "07", "08", "09")) {
                            strNumber = strNumber.trim().substring(1);
                            if (StringUtils.endsWithAny(strInput, "0", " ")) {
                                strInput = strInput.substring(0, strInput.length() - 1) + name;
                                N--;
                            } else strInput = strInput + name;
                        } else {
                            strInput = strInput + name;
                        }
                    }
                }
                textPanel.setTextInput(calculateCurrent.getFormat(),strInput);

                /** divide for 0
                 *
                 */
                try {
                    countResult = calculateCurrent.calculateInput(strInput);
                    find_StrResult();                            //BigDecimal не работает с hex и binary

                    unblockedAll(bPlus, bMinus, bDivide, bMultiply, bPercent, bRadical, bResult, bMemoryAdd);
                    try {
                        unblockedAll(bSin, bCos, bTg, bLg, bLn, bx3, bx2, bxn, bChageSign, bFactorial, bDivX, bSqrt3, bPi, braceOpen);
                    }
                    catch (NullPointerException exception) {  }

                }
                catch (ArithmeticException ex) {
                    log.error("when put number ArithmeticException: {}", ex.getMessage());
                    handleArithmeticException(ex);
                }
                catch (MyException myException) {
                    strResult = myException.getMessage();
                    log.error("MyException: {}", myException.getMessage());

                    //blocked buttons
                    myExceptionBlockButtons(myException);
                }

                textPanel.setTextResult(calculateCurrent.getFormat(),strResult);

                if (name.equals(".")) {
                    blockedAll(bPoint);   //two points couldn't bу in one number
                    unblockedAll(b1, b2, b3, b4, b5, b6, b7, b8, b9, b0,     // unblocked keys during attempt divide to  zero
                            bResult, bMemoryAdd, bDel, bPlus, bMinus, bDivide, bMultiply, bPercent, bRadical);
                }

                if (textPanel.memoryMR == null) blockedAll(bMemoryHold, bMemoryDel);
                else unblockedAll(bMemoryHold, bMemoryDel);

//            }
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
            textPanel.setFontBoldInput();      //alter fonts
            strNumber = "0";                      //prepare to input new number
            N = 0;

            strInput = textPanel.getTextInput().getText();

            if ( StringUtils.containsAny(strInput,"&","~","|","Xor")) {
                textPanel.setSbLog(strInput.trim());
                print_SbLog();
                strInput = countResult;
            }

            if (strInput.endsWith("%") | strInput.startsWith("±") )
                strInput = countResult;

            //unblocked buttons
            unblocked_buttons_appropriate_format();

            switch (name) {
                case " √ " -> {
                    if (strInput.equals("0")) strInput = "";

                    if (countSqrt < 3) {
                        strInput = strInput + name.trim();
                        textPanel.setTextInput(calculateCurrent.getFormat(),strInput);
                    }
                    countSqrt++;
                }
                case " + " -> {
                    if (strInput.trim().isEmpty()) strInput = "0";
                    replaceRepeatedSign_always();
                    replaceRepeatedSign_simple();
                    replaceRepeatedSign_IT();
                    printSign(" +");
                    func = Operations::plus;
                }
                case " - " -> {
                    if (strInput.trim().isEmpty()) strInput = "0";
                    replaceRepeatedSign_always();
                    replaceRepeatedSign_simple();
                    replaceRepeatedSign_IT();
                    printSign(" -");
                    func = Operations::minus;
                }
                case " * " -> {
                    if (strInput.trim().isEmpty()) strInput = "0";
                    replaceRepeatedSign_always();
                    replaceRepeatedSign_simple();
                    replaceRepeatedSign_IT();
                    printSign(" *");
                    func = Operations::multiply;
                }
                case " / " -> {
                    if (strInput.trim().isEmpty()) strInput = "0";
                    replaceRepeatedSign_always();
                    replaceRepeatedSign_simple();
                    replaceRepeatedSign_IT();
                    printSign(" /");
                    func = Operations::divide;
                }
                case " % " -> {
                    if (strInput.trim().isEmpty()) strInput = "0";
                    unblockedAll(bPercent);       // work  % without mistakes
                    textPanel.setFontBoldInput();
                    replaceRepeatedSign_always();
                    replaceRepeatedSign_exceptSimple();
                    replaceRepeatedSign_simple();
                    replaceRepeatedSign_IT();

                    try {
                        countResult = calculateCurrent.calculateInput(strInput + "%");
                        log.info("!!! PERCENT countResult= " + countResult);
                        find_StrResult();                 //BigDecimal не работает с hex и binary
//
                       strInput = strInput + name.trim();
                       textPanel.setTextInput(calculateCurrent.getFormat(),strInput);//

                        textPanel.setSbLog(strInput.trim());
                        printResult();
                        print_SbLog();
                    } catch (MyException ex) {
                        myExceptionBlockButtons(ex);

                        textPanel.setTextResult(calculateCurrent.getFormat(),strResult);
                    }
                    countBrace = 0;

                }
                case " = " -> {
                    countResult = textPanel.getTextResult().getText().substring(1);
                    textPanel.setSbLog(strInput.trim());
                    print_SbLog();
                    printResult();
                    strInput = countResult;
                    textPanel.setTextInput(calculateCurrent.getFormat(),strInput);
                    countBrace = 0;
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
            strInput = textPanel.getTextInput().getText();

            switch (name) {

                case "M+" -> {
                    textPanel.memoryMR = countResult;
                    unblockedAll(bMemoryHold, bMemoryDel);
                }
                case "M-" -> {
                    textPanel.memoryMR = null;
                    blockedAll(bMemoryHold);
                }
                case "MR" -> {
                    strInput = textPanel.getTextInput().getText();

                    if (StringUtils.endsWithAny(strInput.trim(), "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", ".")) {
                        boolean isFormerNumber = true;

                        while (isFormerNumber) {
                            strInput = strInput.substring(0, strInput.length() - 1);
                            textPanel.setTextInput(calculateCurrent.getFormat(),strInput);

                            if (!StringUtils.endsWithAny(strInput.trim(), "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "."))
                                isFormerNumber = false;
                        }
                    }
                    if (strInput.endsWith("%") | strInput.startsWith("±")
                            | (strInput.trim().equals(strResult.substring(1).trim()) && strNumber.equals("0") && func == null)
                    ) strInput = "   ";
                    if (strInput.endsWith(")"))
                        strInput = strInput + "*";

                    strInput = strInput + textPanel.memoryMR;
                    textPanel.setTextInput(calculateCurrent.getFormat(),strInput);

                    try {                                       // except divide for 0
                        countResult = calculateCurrent.calculateInput(strInput);
                        find_StrResult();                //BigDecimal не работает с hex и binary

                        unblockedAll(bPlus, bMinus, bDivide, bMultiply, bPercent, bResult, bMemoryAdd);
                        try {
                            unblockedAll(bSin, bCos, bTg, bLg, bLn, bx3, bx2, bxn,
                                    bChageSign, bFactorial, bDivX, bSqrt3, bPi, braceOpen);
                        } catch (NullPointerException exception) {
                        }
                    } catch (ArithmeticException ex) {
                        handleArithmeticException(ex);
                        log.error("When put MR ArithmeticException: {}", ex.getMessage());
                    } catch (MyException myException) {
                        strResult = myException.getMessage();
                        myExceptionBlockButtons(myException);
                    }

                    textPanel.setTextResult(calculateCurrent.getFormat(),strResult);
                }
                case "AC" -> {

                    // unblocked buttons
                    unblocked_buttons_appropriate_format();

                    if (textPanel.memoryMR == null) blockedAll(bMemoryHold, bMemoryDel);
                    else unblockedAll(bMemoryHold, bMemoryDel);

                    //init
                    countBrace = 0;
                    strNumber = "0";
                    N = 0;
                    textPanel.setTextResult(calculateCurrent.getFormat(),"0");
                    strInput = "   ";   //number after АС
                    textPanel.setTextInput(calculateCurrent.getFormat(),strInput);
                    func = null;
                    countResult = "0";                 // sign after АС
                    strResult = "0";  // AC then =, textRez
                }
                case "C" -> {
                    /** find strInput
                     *
                     */
                    strInput = textPanel.getTextInput().getText();
                    if (strInput.isEmpty()) break;
                    if (StringUtils.endsWith(strInput, "(")) {
                        StringUtils.removeEnd(strInput, "(");;
                        countBrace--;
                    }
                    if (StringUtils.endsWith(strInput, ")")) {
                        StringUtils.removeEnd(strInput, ")");;
                        countBrace++;
                    }
                    if (StringUtils.endsWithAny(strInput, "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", ".", "A", "B", "C", "D", "E", "F")) {
                        if (strNumber.length() > 1)          //beginning work,
                            strNumber = strNumber.substring(0, strNumber.length() - 1);
                        strInput = strInput.substring(0, strInput.length() - 1);
                        N--;
                    }

                    strInput = StringUtils.removeEnd(strInput, "Xor");
                    strInput = StringUtils.removeEnd(strInput, " |");
                    strInput = StringUtils.removeEnd(strInput, " &");
                    strInput = StringUtils.removeEnd(strInput, "√");
                    strInput = StringUtils.removeEnd(strInput, "!");
                    strInput = StringUtils.removeEnd(strInput, "³");
                    strInput = StringUtils.removeEnd(strInput, "²");
                    strInput = StringUtils.removeEnd(strInput, "%");
                    strInput = StringUtils.removeEnd(strInput, " /");
                    strInput = StringUtils.removeEnd(strInput, " *");
                    strInput = StringUtils.removeEnd(strInput, " +");
                    strInput = StringUtils.removeEnd(strInput, " -");
                    strInput = StringUtils.removeEnd(strInput, "sin(");
                    strInput = StringUtils.removeEnd(strInput, "cos(");
                    strInput = StringUtils.removeEnd(strInput, "tg(");
                    strInput = StringUtils.removeEnd(strInput, "ln(");
                    strInput = StringUtils.removeEnd(strInput, "lg(");
                    strInput = StringUtils.removeEnd(strInput, "^(-1)");
                    strInput = StringUtils.removeEnd(strInput, "³√(");
                    strInput = StringUtils.removeEnd(strInput, "^");
                    strInput = StringUtils.removeEnd(strInput, "");




//                    "~","±"

                    if (strResult.equals("делить на 0 нельзя")) {
                        strInput = strInput.substring(0, strInput.length() - 2);
                        N = 0;
                        strNumber = "0";
                    }


                    textPanel.setTextInput(calculateCurrent.getFormat(),strInput);


                    /**find strResult
                     *
                     */
                    try {
                        countResult = calculateCurrent.calculateInput(strInput);
                        find_StrResult();                    //BigDecimal не работает с hex и binary
                    }
                    catch (MyException myException) {
                        log.error("MyException in C: {}", myException.getMessage());
                        strResult = myException.getMessage();
                        //blocked buttons
                        myExceptionBlockButtons(myException);
                    }

                    textPanel.setTextResult(calculateCurrent.getFormat(),strResult);

                    // unblocked buttons
                    unblocked_buttons_appropriate_format();

                }
            }
        }
    }


    // unblocked buttons
    void unblocked_buttons_appropriate_format() {
        if (calculateCurrent.getFormat().equals(MyFormatNumbers.FORMAT_BIN.get())) {
            unblockedAll(bPlus, bMinus, bDivide, bMultiply, bPercent, bRadical, bResult, bMemoryAdd, b1, b0);
            try {
                unblockedAll(braceOpen, bNot, bOr, bXor, bAnd);
            } catch (NullPointerException ex) {
            }
        }
        else if (calculateCurrent.getFormat().equals(MyFormatNumbers.FORMAT_DEC.get())) {
            unblockedAll(bPlus, bMinus, bDivide, bMultiply, bPercent, bRadical, bResult, bMemoryAdd,
                    b0, b1, b2, b3, b4, b5, b6, b7, b8, b9);
            try {
                unblockedAll(bNot, bOr, bXor, bAnd, braceOpen);
            } catch (NullPointerException ex) {
            }
        }
        else if (calculateCurrent.getFormat().equals(MyFormatNumbers.FORMAT_HEX.get())) {
            unblockedAll(bPlus, bMinus, bDivide, bMultiply, bPercent, bRadical, bResult, bMemoryAdd,
                    b0, b1, b2, b3, b4, b5, b6, b7, b8, b9);
            try {
                unblockedAll(bNot, bOr, bXor, bAnd,braceOpen, bA, bB, bC, bD, bE, bF);
            } catch (NullPointerException ex) {
            }
        }
        else if (calculateCurrent.getFormat().equals(MyFormatNumbers.FORMAT_DOUBLE.get())) {
            unblockedAll(bPlus, bMinus, bDivide, bMultiply, bPercent, bRadical,
                    bResult, bMemoryAdd,                                                // after blocked x²,x³,1/x,x!
                    b0, b1, b2, b3, b4, b5, b6, b7, b8, b9, bPoint);
            try {
                unblockedAll(bPi, bSin, bCos, bTg, bLg, bLn, bFactorial, bDivX, bxn, bx2, bx3, bSqrt3, bChageSign, braceOpen);
            } catch (NullPointerException ex) {
            }
        }

        if (textPanel.memoryMR == null) blockedAll(bMemoryHold, bMemoryDel);
        else unblockedAll(bMemoryHold, bMemoryDel);
    }

    //BigDecimal не работает с hex и binary
    void find_StrResult() {
        if (calculateCurrent.getFormat().equals(MyFormatNumbers.FORMAT_BIN.get())
                | calculateCurrent.getFormat().equals(MyFormatNumbers.FORMAT_HEX.get())) {
            strResult = "=" + countResult;
        } else {
            bigDecimal = new BigDecimal(countResult, Operations.mathContext);
            strResult = "=" + bigDecimal;
        }
    }


    void printResult() {
        textPanel.setFontBoldResult();          //alter font
        find_StrResult();                        //BigDecimal не работает с hex и binary

        textPanel.setTextResult(calculateCurrent.getFormat(),strResult);

        unblockedAll(bPercent);       // work  % without mistakes
        strNumber = "0";              // if after = go.
        N = 0;
        func = null;
//         strInput="   ";
//         countResult="0";
    }

    void print_SbLog() {
        for (int i = 0; i < countBrace; i++)
            textPanel.setSbLog(")");
        textPanel.setSbLog("\n");
        textPanel.setSbLog(textPanel.getTextResult().getText());
        textPanel.setSbLog("\n");
        String strLog=textPanel.getSbLog().toString();
        textPanel.setTextLog(calculateCurrent.getFormat(),strLog);
    }

    void printSign(String name) {
        find_StrResult();               //BigDecimal не работает с hex и binary

        if (func == null && strInput.equals("  ")) {
            strInput = strResult + name;
            textPanel.setTextInput(calculateCurrent.getFormat(),strInput);
        } else {
            strInput = strInput + name;
            textPanel.setTextInput(calculateCurrent.getFormat(),strInput);
        }
    }


}
