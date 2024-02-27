package face;

import fitting.MyColors;
import fitting.MyFonts;

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


    /**
     * create engineer Buttons
     */

    void makeITButtons() {

        createButton(new CreateITButton(")"),")",
                MyColors.COLOR_SIGN.get(), MyFonts.FONT_BUTTON.get() );
        createButton(new CreateITButton("("),"(",
                MyColors.COLOR_SIGN.get(), MyFonts.FONT_BUTTON.get() );

        createButton(new CreateITButton("Not"),"Not",
                MyColors.COLOR_SIGN.get(), MyFonts.FONT_BUTTON_BOTTOM.get() );
        createButton(new CreateITButton("And"),"And",
                MyColors.COLOR_SIGN.get(), MyFonts.FONT_BUTTON_BOTTOM.get() );
        createButton(new CreateITButton("Or"),"Or",
                MyColors.COLOR_SIGN.get(), MyFonts.FONT_BUTTON_BOTTOM.get() );
        createButton(new CreateITButton("Xor"),"Xor",
                MyColors.COLOR_SIGN.get(), MyFonts.FONT_BUTTON_BOTTOM.get() );

        createButton(new CreateITButton("A"),"A",
                MyColors.COLOR_BUTTON.get(), MyFonts.FONT_BUTTON.get() );
        createButton(new CreateITButton("B"),"B",
                MyColors.COLOR_BUTTON.get(), MyFonts.FONT_BUTTON.get() );
        createButton(new CreateITButton("С"),"С",
                MyColors.COLOR_BUTTON.get(), MyFonts.FONT_BUTTON.get() );
        createButton(new CreateITButton("D"),"D",
                MyColors.COLOR_BUTTON.get(), MyFonts.FONT_BUTTON.get() );
        createButton(new CreateITButton("E"),"E",
                MyColors.COLOR_BUTTON.get(), MyFonts.FONT_BUTTON.get() );
        createButton(new CreateITButton("F"),"F",
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

        }

    }
}
