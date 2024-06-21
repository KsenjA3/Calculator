package org.example.face;

import lombok.AccessLevel;
import lombok.Getter;
import org.example.fitting.*;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import java.awt.*;



public class PanelText {

    private JPanel textPanel;
    /**
     * elements of Result window
     */

    @Getter (AccessLevel.PROTECTED)
    private JPanel panelResult;
    @Getter (AccessLevel.PROTECTED)
    private JLabel textResult;

    /**
     * elements of Input window
     */
    @Getter (AccessLevel.PROTECTED)
    private JScrollPane scrollinput;
    @Getter (AccessLevel.PROTECTED)
    private JTextPane textInput;

    /**
     * FONTs
     */
    private  SimpleAttributeSet textInputAttributes;


    /**
     *show up Result font
     */
     void setFontBoldResult (){
        textResult.setFont(MyFonts.FONT_TEXT_INPUT.get());

        StyleConstants.setAlignment(textInputAttributes, StyleConstants.ALIGN_RIGHT);
        StyleConstants.setFontFamily(textInputAttributes, MyFontNames.FRONT_NAME_TEXT_INPUT.get());
        StyleConstants.setFontSize(textInputAttributes, MyFontSizes.FRONT_SIZE_TEXT_RESULT.get());
        textInput.setParagraphAttributes(textInputAttributes, true);
    }

    /**
     *show up InputPanel font
     */
     void setFontBoldInput (){
        textResult.setFont(MyFonts.FONT_TEXT_RESULT.get());

        StyleConstants.setAlignment(textInputAttributes, StyleConstants.ALIGN_RIGHT);
        StyleConstants.setFontFamily(textInputAttributes, MyFontNames.FRONT_NAME_TEXT_INPUT.get());
        StyleConstants.setFontSize(textInputAttributes,MyFontSizes.FRONT_SIZE_TEXT_INPUT.get());
        textInput.setParagraphAttributes(textInputAttributes, true);
    }

    PanelText(){

        textInputAttributes = new SimpleAttributeSet();

        GridBagLayout gbag = new GridBagLayout();
        Border borderText = BorderFactory.createLineBorder(Color.BLACK, 2);

        textPanel = new JPanel();
        textPanel.setBackground(MyColors.COLOR_PANE.get());
        textPanel.setLayout(gbag);
        //textPanel.setPreferredSize(new Dimension(WidthSize,HeightSizeText)); автоматически
        textPanel.setBorder(borderText);
        textPanel.setLayout(new BoxLayout(textPanel, BoxLayout.Y_AXIS));

        textInput = new JTextPane();
        textInput.setBackground(MyColors.COLOR_INPUT.get());
        StyleConstants.setAlignment(textInputAttributes, StyleConstants.ALIGN_RIGHT);
        StyleConstants.setFontFamily(textInputAttributes, MyFontNames.FRONT_NAME_TEXT_INPUT.get());
        StyleConstants.setFontSize(textInputAttributes,MyFontSizes.FRONT_SIZE_TEXT_INPUT.get());
        textInput.setParagraphAttributes(textInputAttributes, true);
        scrollinput = new JScrollPane(textInput, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollinput.setBorder(null);

        textResult = new JLabel("0");
        textResult.setFont(MyFonts.FONT_TEXT_RESULT.get());
        panelResult = new JPanel(new FlowLayout(FlowLayout.RIGHT, 0, 0));
        panelResult.setBackground(MyColors.COLOR_RESULT.get());
        panelResult.add(textResult);
    }

    /**
     * get TextPanel
     * @param widthSizeText depends on type of keyPanel
     * @return TextPanel
     */
    JPanel getTextPanel (int widthSizeText) {
        textPanel.add(scrollinput);
        scrollinput.setPreferredSize(new Dimension(widthSizeText, MySizePanel.HIEGHT_SIZE_TEXT_INPUT.get()));
        textPanel.add(panelResult, Component.RIGHT_ALIGNMENT);
        panelResult.setPreferredSize(new Dimension(widthSizeText, MySizePanel.HIEGHT_SIZE_TEXT_RESULT.get()));
        return textPanel;
    }

    /**
     *get Height TextPanel
     * @return Height TextPanel
     */
    int getHeightTextPanel ()
    {               return MySizePanel.HIEGHT_SIZE_TEXT_INPUT.get()
            + MySizePanel.HIEGHT_SIZE_TEXT_RESULT.get();
    }




//    JPanel getPanelResult () { return panelResult; }
//    JScrollPane getScrollinput () { return scrollinput; }
//     JLabel getTextResult() { return textResult; }
//     JTextPane getTextInput() { return textInput ;}


    void setTextInput(String strInput) {
        this.textInput.setText(strInput); }
    void setTextResult(String strResult) {
        this.textResult.setText(strResult); }
}
