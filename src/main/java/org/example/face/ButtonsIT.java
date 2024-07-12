package org.example.face;

import org.example.fitting.MyColors;
import org.example.fitting.MyFonts;

import javax.swing.*;
import java.awt.event.ActionEvent;

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

        bNot=createButton(new CreateITButton("Not"),"Not",
                MyColors.COLOR_SIGN.get(), MyFonts.FONT_BUTTON_BOTTOM.get() );
        bAnd=createButton(new CreateITButton("And"),"And",
                MyColors.COLOR_SIGN.get(), MyFonts.FONT_BUTTON_BOTTOM.get() );
        bOr=createButton(new CreateITButton("Or"),"Or",
                MyColors.COLOR_SIGN.get(), MyFonts.FONT_BUTTON_BOTTOM.get() );
        bXor=createButton(new CreateITButton("Xor"),"Xor",
                MyColors.COLOR_SIGN.get(), MyFonts.FONT_BUTTON_BOTTOM.get() );

        bA=createButton(new CreateITButton("A"),"A",
                MyColors.COLOR_BUTTON.get(), MyFonts.FONT_BUTTON.get() );
        bB=createButton(new CreateITButton("B"),"B",
                MyColors.COLOR_BUTTON.get(), MyFonts.FONT_BUTTON.get() );
        bC=createButton(new CreateITButton("С"),"С",
                MyColors.COLOR_BUTTON.get(), MyFonts.FONT_BUTTON.get() );
        bD=createButton(new CreateITButton("D"),"D",
                MyColors.COLOR_BUTTON.get(), MyFonts.FONT_BUTTON.get() );
        bE=createButton(new CreateITButton("E"),"E",
                MyColors.COLOR_BUTTON.get(), MyFonts.FONT_BUTTON.get() );
        bF=createButton(new CreateITButton("F"),"F",
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
                        unblockedAll(bPlus, bMinus, bDivide, bMultiply, bPercent, bResult, bMemoryAdd, bMemoryDel, bMemoryHold);
                    }
                }
                case "(" -> {
                    countBrace++;
                    str = textPanel.getTextInput().getText().trim();

                    if (str.length() >= 1)
                        switch (str.charAt(str.length() - 1)) {
                            case '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', ')', '²', '³', '!' -> {
                                unblockedAll(b0, b1, b2, b3, b4, b5, b6, b7, b8, b9,  bPercent, bRadical); // after blocked x²,x³,1/x,x!
                                strInput = str + "*" + name;
                            }
                            case '.' -> strInput = str.substring(0, str.length() - 1) + "*" + name;
                            default -> strInput = str + name;

                        }
                    else strInput = str + name;

                    textPanel.setTextInput(strInput);

                    unblockedAll(braceClose);
                    blockedAll(bPlus, bDivide, bMultiply, bPercent, bResult, bMemoryAdd);

                }
                case "A" -> {

                }
                case "B" -> {

                }
                case "C" -> {

                }
                case "D" -> {

                }
                case "E" -> {

                }
                case "F" -> {

                }
                case "And" -> {

                }
                case "Or" -> {

                }
                case "Xor" -> {

                }
                case "Not" -> {

                }
            }

        }








    }
}
