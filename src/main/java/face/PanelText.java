package face;

import fitting.*;

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
    private JPanel panelRezult;
    private JLabel textRezult;
    private String strResult;

    /**
     * elements of Input window
     */
    private JScrollPane scrollinput;
    private JTextPane textInput;
    private String strInput;

    /**
     * FONTs
     */
    private  SimpleAttributeSet textInputAttributes;


    /**
     *show up Result font
     */
     void setFontBoldResult (){
        textRezult.setFont(MyFonts.FONT_TEXT_INPUT.get());

        StyleConstants.setAlignment(textInputAttributes, StyleConstants.ALIGN_RIGHT);
        StyleConstants.setFontFamily(textInputAttributes, MyFontNames.FRONT_NAME_TEXT_INPUT.get());
        StyleConstants.setFontSize(textInputAttributes, MyFontSizes.FRONT_SIZE_TEXT_RESULT.get());
        textInput.setParagraphAttributes(textInputAttributes, true);
    }

    /**
     *show up InputPanel font
     */
     void setFontBoldInput (){
        textRezult.setFont(MyFonts.FONT_TEXT_RESULT.get());

        StyleConstants.setAlignment(textInputAttributes, StyleConstants.ALIGN_RIGHT);
        StyleConstants.setFontFamily(textInputAttributes, MyFontNames.FRONT_NAME_TEXT_INPUT.get());
        StyleConstants.setFontSize(textInputAttributes,MyFontSizes.FRONT_SIZE_TEXT_INPUT.get());
        textInput.setParagraphAttributes(textInputAttributes, true);
    }

    PanelText(){

        strInput = "   ";
        strResult = "0.0";
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

        textRezult = new JLabel("0");
        textRezult.setFont(MyFonts.FONT_TEXT_RESULT.get());
        panelRezult = new JPanel(new FlowLayout(FlowLayout.RIGHT, 0, 0));
        panelRezult.setBackground(MyColors.COLOR_RESULT.get());
        panelRezult.add(textRezult);
    }

    /**
     * get TextPanel
     * @param widthSizeText depends on type of keyPanel
     * @return TextPanel
     */
    JPanel getTextPanel (int widthSizeText) {
        textPanel.add(scrollinput);
        scrollinput.setPreferredSize(new Dimension(widthSizeText, MySizePanel.HIEGHT_SIZE_TEXT_INPUT.get()));
        textPanel.add(panelRezult, Component.RIGHT_ALIGNMENT);
        panelRezult.setPreferredSize(new Dimension(widthSizeText, MySizePanel.HIEGHT_SIZE_TEXT_RESULT.get()));
        return textPanel;
    }

    /**
     * get PanelRezult
     * @return getPanelRezult
     */
    JPanel getPanelRezult () { return panelRezult; }

    /**
     * get PanelInput
     * @return PanelInput
     */
    JScrollPane getScrollinput () { return scrollinput; }

    /**
     *get Height TextPanel
     * @return Height TextPanel
     */
    int getHeightTextPanel ()
    {               return MySizePanel.HIEGHT_SIZE_TEXT_INPUT.get()
                        + MySizePanel.HIEGHT_SIZE_TEXT_RESULT.get();
    }

     JLabel getTextRezult() { return textRezult; }
     String getStrResult() { return strResult; }
     JTextPane getTextInput() { return textInput ;}
     String getStrInput() { return strInput; }

     void setTextRezult(JLabel textRezult) {  this.textRezult=textRezult; }
    void setStrResult(String strResult) {  this.strResult=strResult; }
    void setTextInput(JTextPane textInput) {  this.textInput=textInput ;}
    void  setStrInput(String strInput) {  this.strInput=strInput; }

    String getAndSetTextInput(String strInput){
       return this.strInput= strInput;
    }

    void setTextInput(String strInput) {
        this.textInput.setText(strInput); }

    void setTextRezult(String strResult) {
        this.textRezult.setText(strResult); }
}
