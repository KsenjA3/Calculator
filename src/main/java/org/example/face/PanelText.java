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

    private final JPanel textPanel;

    @Getter (AccessLevel.PROTECTED)
    private final JPanel panelResult;
    @Getter (AccessLevel.PROTECTED)
    private final JLabel textResult;

    @Getter (AccessLevel.PROTECTED)
    private final JScrollPane scrollInput;
    @Getter (AccessLevel.PROTECTED)
    private final JTextPane textInput;

    /**
     * FONTs
     */
    private final SimpleAttributeSet textInputAttributes;


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
        scrollInput = new JScrollPane(textInput, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollInput.setBorder(null);

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
        textPanel.add(scrollInput);
        scrollInput.setPreferredSize(new Dimension(widthSizeText, MySizePanel.HIEGHT_SIZE_TEXT_INPUT.get()));
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
