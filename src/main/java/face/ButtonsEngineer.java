package face;

import calculate.Operations;
import fitting.MyColors;
import fitting.MyFonts;

import javax.swing.*;
import java.awt.event.ActionEvent;

public  class ButtonsEngineer extends ButtonsBasic {
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

        createButton(new CreateEngineerButton(")"),")",
                MyColors.COLOR_SIGN.get(), MyFonts.FONT_BUTTON.get() );
        createButton(new CreateEngineerButton("x²"),"x²",
                MyColors.COLOR_SIGN.get(), MyFonts.FONT_BUTTON_MIDDLE.get() );
        createButton(new CreateEngineerButton("x³"),"x³",
                MyColors.COLOR_SIGN.get(), MyFonts.FONT_BUTTON_MIDDLE.get() );
        createButton(new CreateEngineerButton("xⁿ"),"xⁿ",
                MyColors.COLOR_SIGN.get(), MyFonts.FONT_BUTTON_MIDDLE.get() );
        createButton(new CreateEngineerButton("³√"),"³√",
                MyColors.COLOR_SIGN.get(), MyFonts.FONT_BUTTON_MIDDLE.get() );


        createButton(new CreateEngineerButton("("),"(",
                MyColors.COLOR_SIGN.get(), MyFonts.FONT_BUTTON.get() );
        createButton(new CreateEngineerButton("ln"),"ln",
                MyColors.COLOR_SIGN.get(), MyFonts.FONT_BUTTON_MIDDLE.get() );
        createButton(new CreateEngineerButton("lg"),"lg",
                MyColors.COLOR_SIGN.get(), MyFonts.FONT_BUTTON_MIDDLE.get() );
        createButton(new CreateEngineerButton("x!"),"x!",
                MyColors.COLOR_SIGN.get(), MyFonts.FONT_BUTTON_MIDDLE.get() );
        createButton(new CreateEngineerButton("1/x"),"1/x",
                MyColors.COLOR_SIGN.get(), MyFonts.FONT_BUTTON_BOTTOM.get() );


        createButton(new CreateEngineerButton("±"),"±",
                MyColors.COLOR_SIGN.get(), MyFonts.FONT_BUTTON_MIDDLE.get() );
        createButton(new CreateEngineerButton("sin"),"sin",
                MyColors.COLOR_SIGN.get(), MyFonts.FONT_BUTTON_LOW.get() );
        createButton(new CreateEngineerButton("cos"),"cos",
                MyColors.COLOR_SIGN.get(), MyFonts.FONT_BUTTON_LOW.get() );
        createButton(new CreateEngineerButton("tg"),"tg",
                MyColors.COLOR_SIGN.get(), MyFonts.FONT_BUTTON_MIDDLE.get() );
        createButton(new CreateEngineerButton("π"),"π",
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
            switch (name){
                case "±"-> {

                    textPanel.setSbLog(textPanel.getStrInput());
                    textPanel.setSbLog("\n");
                    textPanel.setSbLog(textPanel.getStrResult());
                    textPanel.setSbLog("\n");
                    textPanel.setTextLog( textPanel.getSbLog().toString());
//                    PanelTextLog.sbLog.append(PanelText.strInput).append("\n").append(PanelText.strResult).append("\n");
//                    PanelTextLog.textLog.setText(PanelTextLog.sbLog.toString());


                    dResult = -dResult;

//                    PanelText.strResult = "=" + Operations.printNumber(dResult);
                    textPanel.setStrResult("=" + Operations.printNumber(dResult));
                    textPanel.setFontBoldResult ();          //alter font
//                    PanelText.textRezult.setText(PanelText.strResult);
//                    PanelText.textInput.setText(PanelText.strInput= Operations.printNumber(dResult));
                    textPanel.setTextRezult(textPanel.getStrResult());
                    textPanel.setStrInput(Operations.printNumber(dResult));
                    textPanel.setTextInput(textPanel.getStrInput());

       //             unblockedAll(bPercent);       // work  % without mistakes

                    strNumber = "0";              // if after = go "."
                    func = null;
                    textPanel.setStrInput("   ");
//                    PanelText.strInput = "   ";   // input number after =
                }
            }
        }
    }
}
