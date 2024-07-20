package org.example.face;

import lombok.extern.log4j.Log4j2;
import org.apache.commons.lang3.StringUtils;
import org.example.fitting.MyColors;
import org.example.fitting.MyFonts;
import org.example.fitting.MyFormatNumbers;

import javax.swing.*;
import java.awt.event.ActionEvent;


@Log4j2
public class ButtonsIT extends ButtonsBasic{
    private PanelTextLog textPanel;

    ButtonsIT(PanelTextLog textPanel) {
        super(textPanel);
        this.textPanel=textPanel;
        makeButtons();
        makeITButtons();
    }


    /**create engineer Buttons
     *
     */
    void makeITButtons() {

        braceClose=createButton(new CreateITButton(")"),")",
                MyColors.COLOR_SIGN.get(), MyFonts.FONT_BUTTON.get() );
        braceOpen=createButton(new CreateITButton("("),"(",
                MyColors.COLOR_SIGN.get(), MyFonts.FONT_BUTTON.get() );


        bNot=createButton(new CreateITButton("Not"),"~",
                MyColors.COLOR_SIGN.get(), MyFonts.FONT_BUTTON_BOTTOM.get() );
        bAnd=createButton(new CreateITButton("And"),"&",
                MyColors.COLOR_SIGN.get(), MyFonts.FONT_BUTTON_BOTTOM.get() );
        bOr=createButton(new CreateITButton("Or"),"|",
                MyColors.COLOR_SIGN.get(), MyFonts.FONT_BUTTON_BOTTOM.get() );
        bXor=createButton(new CreateITButton("Xor"),"Xor",
                MyColors.COLOR_SIGN.get(), MyFonts.FONT_BUTTON_BOTTOM.get() );



        bA=createButton(new CreateITButton("A"),"AA", KeyStroke.getKeyStroke('a') ,
                MyColors.COLOR_BUTTON.get(), MyFonts.FONT_BUTTON.get() );
        bB=createButton(new CreateITButton("B"),"BB", KeyStroke.getKeyStroke('b') ,
                MyColors.COLOR_BUTTON.get(), MyFonts.FONT_BUTTON.get() );
        bC=createButton(new CreateITButton("C"),"CC",KeyStroke.getKeyStroke('c') ,
                MyColors.COLOR_BUTTON.get(), MyFonts.FONT_BUTTON.get() );
        bD=createButton(new CreateITButton("D"),"DD",KeyStroke.getKeyStroke('d') ,
                MyColors.COLOR_BUTTON.get(), MyFonts.FONT_BUTTON.get() );
        bE=createButton(new CreateITButton("E"),"EE",KeyStroke.getKeyStroke('e') ,
                MyColors.COLOR_BUTTON.get(), MyFonts.FONT_BUTTON.get() );
        bF=createButton(new CreateITButton("F"),"FF",KeyStroke.getKeyStroke('f') ,
                MyColors.COLOR_BUTTON.get(), MyFonts.FONT_BUTTON.get() );

    }

    class CreateITButton extends AbstractAction {
        String name;

        CreateITButton(String nameButton) {
            super(nameButton);
            name = nameButton;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            if (textPanel.memoryMR == null)   blockedAll(bMemoryHold, bMemoryDel);
            else     unblockedAll(bMemoryHold,bMemoryDel);

            strInput= textPanel.getTextInput().getText();
            if (strInput.startsWith("±"))
                strInput="("+strResult.substring(1)+")";

            String str;
            switch (name) {
                case ")" -> {
                    str = textPanel.getTextInput().getText().trim();
                    switch (str.charAt(str.length() - 1)) {
                        case '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', ')', '²', '³', '!' -> {
                            countBrace--;
                            strInput = strInput + name;
                            textPanel.setTextInput(strInput);
                        }
                    }

                    if (countBrace <= 0) {
                        blockedAll(braceClose);
                        unblockedAll(bPlus, bMinus, bDivide, bMultiply, bPercent, bResult, bMemoryAdd, bMemoryDel, bMemoryHold,
                                        braceOpen, bNot, bXor, bOr, bAnd);
                    }
                }

                case "(" -> {
                    countBrace++;
                    str = textPanel.getTextInput().getText().trim();
                    strNumber="";

                    if (str.length() >= 1)
                        switch (str.charAt(str.length() - 1)) {
                            case '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
                                  'A','B','C','D','E','F',')' -> {
                                strInput = str + "*" + name;
                            }
                            default -> strInput = str + name;
                        }
                    else strInput = str + name;

                    textPanel.setTextInput(strInput);

                    unblockedAll(braceClose, bRadical);
                    blockedAll(bPlus, bDivide, bMultiply, bPercent, bResult, bMemoryAdd,
                            braceOpen, bXor, bOr, bAnd);
                }

                case "A","B","C","D","E","F"-> {
                    textPanel.setFontBoldInput ();   //alter fonts
                    countSqrt=0;

                    if (strInput.endsWith("%")   |   strInput.startsWith("±")  |
                            ( strInput.trim().equals(strResult.substring(1).trim()) &&  strNumber.equals("0")  && func==null))
                        strInput="   ";

                    if (strInput.endsWith(")"))
                        strInput=strInput+"*";


                    if (N < 15) {
                        N++;
                        strNumber = strNumber + name;

                        /** IT panel binary numbers
                         * ввод нуля вначале числа
                         */
                        if (calculateCurrent.getFormat().equals(MyFormatNumbers.FORMAT_BIN.get())){
                            strInput=strInput + name;
                        }
                        else {
                            /**исключить  ноль в начале числа
                             *
                             */
                            if (StringUtils.equalsAny(strNumber.trim(),  "0A","0B","0C","0D","0E","0F")) {
                                strNumber = strNumber.trim().substring(1);
                                if (StringUtils.endsWithAny(strInput, "0", " ")) {
                                    strInput = strInput.substring(0, strInput.length() - 1) + name;
                                    N--;
                                } else strInput = strInput + name;
                            }
                            else {  strInput = strInput + name;    }
                        }

                        textPanel.setTextInput(strInput);

                        /** divide for 0
                         *
                         */
                        try {
                            countResult = calculateCurrent.calculateInput(strInput);
                            strResult="=" + countResult;

                            unblockedAll(bPlus, bMinus, bDivide, bMultiply, bPercent,
                                    bResult, bMemoryAdd, braceOpen);
                        }
                        catch ( ArithmeticException  ex){
                            log.error("When put ABCDEF ArithmeticException: {}",ex.getMessage());
                            handleArithmeticException(ex);
                        }
                        catch (MyException myException){
                            strResult = myException.getMessage();
                            log.error("MyException: {}",myException.getMessage());
                            myExceptionBlockButtons(myException);
                        }

                        textPanel.setTextResult(strResult);

                        if (textPanel.memoryMR == null)   blockedAll(bMemoryHold, bMemoryDel);
                        else     unblockedAll(bMemoryHold,bMemoryDel);
                    }
                }

                case "And"-> {
                    init_IT_sign_button(" &");
                }
                case "Or"-> {
                    init_IT_sign_button(" |");
                }
                case "Xor"-> {
                    init_IT_sign_button(" Xor");
                }
                case "Not"-> {
                    try {
                        countResult = calculateCurrent.calculateInput( strInput);
                        countResult = calculateCurrent.calculateIT.count_not(countResult,calculateCurrent.getFormat());
                        printResult ();

                        strInput="~("+textPanel.getTextInput().getText().trim()+")";
                        for (int i=0; i<countBrace; i++)
                            strInput=strInput+")";
                        textPanel.setTextInput(strInput);

                        textPanel.setSbLog(strInput);
                        textPanel.setSbLog("\n");
                        textPanel.setSbLog(textPanel.getTextResult().getText());
                        textPanel.setSbLog("\n");
                        textPanel.setTextLog( textPanel.getSbLog().toString());

                        countBrace=0;

                    }catch (MyException myException){
                        log.error("MyException ~ : {}",myException.getMessage());
                        strResult = myException.getMessage();
                        textPanel.setTextResult(strResult);
                        myExceptionBlockButtons(myException);

                    }


                }
            }
        }



        void init_IT_sign_button(String sign){
            strInput= textPanel.getTextInput().getText();
            textPanel.setFontBoldInput ();
//            strResult=textPanel.getTextResult().getText();

            if (StringUtils.endsWith(strInput, "%") )
                strInput=countResult;

            replaceRepeatedSign_exceptSimple ();
            replaceRepeatedSign_simple ();
            replaceRepeatedSign_IT ();


            if (StringUtils.containsAny(strInput,"/","*","-","+","&","|","Xor") ) {
                textPanel.setSbLog(strInput.trim());
                print_SbLog();
                strInput = countResult;
            }

            if(strInput.trim().isEmpty())
                strInput="0"+sign;
             else
                strInput=strInput+sign;
            textPanel.setTextInput(strInput);

            blockedAll(bRadical);
            if (textPanel.memoryMR == null)   blockedAll(bMemoryHold, bMemoryDel);
            else     unblockedAll(bMemoryHold,bMemoryDel);
        }

    }
}
