package face;

import calculate.CalculateBasicInput;
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

import static face.PanelText.strInput;
import static face.PanelText.textInput;
import static face.PanelText.strResult;
import static face.PanelText.textRezult;

public class ButtonsBasic {

    /**
     * button simple calculation
     */
    protected JButton b, b1, b2, b3, b4, b5, b6, b7, b8, b9, b0, bPoint;
    protected JButton bPlus, bMinus, bDivide, bMultiply, bPercent, bRadical, bResult;
    protected JButton bMemoryAdd, bMemoryDel, bMemoryHold, bClear, bDel;

    /**
     * restriction amount  input figures to number
     */
    private int N;

    /**
     * inly number
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
    protected String strInputFormerSign;
    protected double dResultPercent;

    /**
     * to safe into the memory
     */
    private Double memory;

    /**
     * object for calculation
     */
    private CalculateBasicInput calculateCurrent;

    /**
     * result of calculation
     */
    protected Double dResult;


    private HashMap<String,JButton> listButtons;

    protected ButtonsBasic() {
        N = 0;
        strNumber = "0";
        dNumber = 0.0;
        dResult=0.0;
        func = null;

        /*
         * for calculator.calculate.calculate Percent
         * % and divide for 0, input number after %
         * for % because number changed after %
         * for % under mltidigited number
         */
        nameSign = "";
        strInputFormerSign = "";
        dResultPercent = 0.0;

        //create object for calculation
        calculateCurrent = new CalculateBasicInput();

        listButtons =new  HashMap <String,JButton> ();
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

        blockedAll(bMemoryHold);

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

            //alter fonts
            PanelText.setFontBoldInput ();

            if (N < 15) {
                N++;

                strNumber = strNumber + name;             // create input number type String
                dNumber = Double.parseDouble(strNumber);  // from String to Double


                if (strNumber.equals("0.") && name.equals("."))     //output in begining
                    textInput.setText(strInput = strInput + strNumber);
                else
                    textInput.setText(strInput = strInput + name);

                // except divide for 0
                if ((dNumber == 0.0) && (nameSign.equals(" / "))) {
                    strResult = "деление на 0 не возможно";
                    blockedAll(b1, b2, b3, b4, b5, b6, b7, b8, b9, b0,
                            bPlus, bMinus, bDivide, bMultiply, bPercent, bRadical,
                            bResult, bMemoryAdd, bMemoryDel, bMemoryHold);
                } else {

                    dResult = calculateCurrent.calculateInput(strInput);

                    strResult = "=" + Operations.printNumber(dResult);
                    unblockedAll(bPercent);       // work  % without mistakes
                }

                if (name.equals(".")) {
                    blockedAll(bPoint);   //two points couldn't bу in one number

                    // unblocked keys during attempt divide to  ziro
                    unblockedAll(b1, b2, b3, b4, b5, b6, b7, b8, b9, b0,
                            bResult, bMemoryAdd, bMemoryDel, bDel,
                            bPlus, bMinus, bDivide, bMultiply, bPercent, bRadical);
                }
                textRezult.setText(strResult);

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

            //alter fonts
            PanelText.setFontBoldInput ();

            strNumber = "0";                      //prepare to input new number
            N = 0;

            unblockedAll(bPoint);       // allow double
            blockedAll(bPercent);       // work  % without mistakes

            switch (name) {
                case " √ " -> {
                    textInput.setText( strInput=strInput+name);

                }
                case " + " -> {
                    Print_and_replaceRepeatedSign();
                    func = Operations::plus;
                }
                case " - " -> {
                    Print_and_replaceRepeatedSign();
                    func = Operations::minus;
                }
                case " * " -> {
                    Print_and_replaceRepeatedSign();
                    func = Operations::multiply;
                }
                case " / " -> {
                    Print_and_replaceRepeatedSign();
                    func = Operations::divide;
                }

                case " % " -> {
                    unblockedAll(bPercent);       // work  % without mistakes

                    if (func == null) {
                        dResult = calculateCurrent.calculatePersent(func, nameSign,
                                dResultPercent, dNumber);
                         textInput.setText(Operations.printNumber(dResult));
                    } else {
                        dResult = calculateCurrent.calculatePersent(func, nameSign,
                                dResultPercent, dNumber);

                        textInput.setText( strInput =strInputFormerSign+Operations.printNumber(dNumber)+"%");

                    }
                     strResult = "=" + Operations.printNumber(dResult);
                     textRezult.setText( strResult);

                    func = null;
                     strInput = "   ";            // input number after %
                }
                case " = " -> {
                    PanelText.setFontBoldResult ();          //alter font
                     textRezult.setText( strResult);
                     textInput.setText( strInput);

                    PanelTextLog.sbLog.append( strInput).append("\n").append( strResult).append("\n");
                    PanelTextLog.textLog.setText(PanelTextLog.sbLog.toString());

                    unblockedAll(bPercent);       // work  % without mistakes

                    strNumber = "0";              // if after = go "."
                    func = null;
                     strInput = "   ";   // input number after =
                }
            }
            nameSign = name;
            strInputFormerSign =  strInput;

        }

        void Print_and_replaceRepeatedSign () {
            strInput=StringUtils.removeEnd(strInput, " √ ");
            strInput=StringUtils.removeEnd(strInput, " √ ");
            strInput=StringUtils.removeEnd(strInput, " √ ");
            strInput=StringUtils.removeEnd(strInput," + " );
            strInput=StringUtils.removeEnd(strInput, " - ");
            strInput=StringUtils.removeEnd(strInput, " * ");
            strInput=StringUtils.removeEnd(strInput, " / ");

            if (func==null)
                textInput.setText(strInput = Operations.printNumber(dResult) + name);
            else
                textInput.setText( strInput= strInput+name);

            dResultPercent = dResult;
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

            switch (name) {

                case "M+" -> {
                    memory = dResult;
                    unblockedAll(bMemoryHold);
                }
                case "M-" -> {
                    memory = null;
                    blockedAll(bMemoryHold);
                }
                case "MR" -> {
                    dNumber = memory;

                    switch ( strInput.substring( strInput.length() - 1)) {
                                    // before MR was number
                        case "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "." -> {
                            boolean isFormerNumber = true;

                            while (isFormerNumber) {
                                 strInput =  strInput.substring(0,  strInput.length() - 1);

                                switch ( strInput.substring( strInput.length() - 1)) {
                                    case "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "." -> isFormerNumber = true;
                                    default -> isFormerNumber = false;
                                }
                            }
                             textInput.setText( strInput =  strInput + Operations.printNumber(memory));
                        }
                                // before MR was sign
                        default ->  textInput.setText( strInput =  strInput + Operations.printNumber(memory));
                    }
                                // except divide for 0
                    if ((dNumber == 0.0) && (nameSign.equals(" / "))) {
                         strResult = "деление на 0 не возможно";
                        blockedAll(b1, b2, b3, b4, b5, b6, b7, b8, b9, b0,
                                bPlus, bMinus, bDivide, bMultiply, bPercent, bRadical,
                                bResult, bMemoryAdd, bMemoryDel, bMemoryHold);
                    } else {
                        dResult = calculateCurrent.calculateInput( strInput);
                         strResult = "=" + Operations.printNumber(dResult);
                    }

                     textRezult.setText( strResult);

                    unblockedAll(bPercent);       // work  % without mistakes

                }
                case "AC" -> {
                    unblockedAll(b1, b2, b3, b4, b5, b6, b7, b8, b9, b0, bPoint,
                            bMemoryAdd, bMemoryDel, bDel,
                            bPlus, bMinus, bDivide, bMultiply, bPercent, bRadical);

                    if (memory != null)
                        unblockedAll(bMemoryHold);

                    dNumber = 0.0;
                    strNumber = "0";

                     textRezult.setText("0");
                     textInput.setText( strInput = " ");

                    func = null;
                    dResult = 0.0;                // sign after АС
                     strInput = "   ";   //number after АС
                     strResult = "0";    // AC then =, textRez
                    nameSign = " ";               //after sqrt
                }
                case "C" -> {
                                    // input window
                    switch ( strInput.charAt( strInput.length() - 1)) {
                        case '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '.' -> {
                             textInput.setText( strInput =  strInput.substring(0,  strInput.length() - 1));
                            dResult = calculateCurrent.calculateInput( strInput);
                            if (strNumber.length() > 1)
                                strNumber = strNumber.substring(0, strNumber.length() - 1);
                        }
                        default -> {
                             textInput.setText( strInput =  strInput.substring(0,  strInput.length() - 3));
                            dResult = calculateCurrent.calculateInput( strInput);
                                            //begining work
                            if ( strInput.length()< 3)
                                func=null;
                        }
                    }
                     strResult = "=" + Operations.printNumber(dResult);
                     textRezult.setText( strResult);

                    unblockedAll(b1, b2, b3, b4, b5, b6, b7, b8, b9, b0, bPoint,
                            bMemoryAdd, bMemoryDel, bMemoryHold, bDel,
                            bPlus, bMinus, bDivide, bMultiply, bPercent, bRadical);
                }
            }
        }
    }

    /**
     * block keys on panel calculator
     * @param v blocking keys
     */
    private static void blockedAll(JButton... v) {
        for (JButton b : v)
            b.setEnabled(false);
    }

    /**
     * unblock keys on panel calculator
     * @param v unblocking keys
     */
    private static void unblockedAll(JButton... v) {
        for (JButton b : v)
            b.setEnabled(true);
    }

}
