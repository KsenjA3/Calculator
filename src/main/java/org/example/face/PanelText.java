package org.example.face;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import org.example.fitting.*;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import java.awt.*;



public class PanelText {

    private final JPanel textPanel;

    /**for realise Digit Number
     *
     */
    @Getter (AccessLevel.PROTECTED)
    @Setter(AccessLevel.PROTECTED)
    private boolean digitNumber;

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


    void setTextInput(String format,String strInput) {

        if(isDigitNumber()){
            strInput=digitNumbers(format,strInput);
        }
        this.textInput.setText(strInput); }



    void setTextResult(String format,String strResult) {
        if(isDigitNumber()){
            strResult=digitNumbers(format,strResult);
        }
        this.textResult.setText(strResult); }



    protected String digitNumbers(String format, String oldString){
        oldString=oldString.replaceAll(" ", "");
        String newStr="";
        StringBuffer newSB= new StringBuffer();
        int digit=0;
        int limitDigit=0;

        if (format.equals(MyFormatNumbers.FORMAT_BIN.get()) |
                format.equals(MyFormatNumbers.FORMAT_HEX.get())) {
            limitDigit=4;
        }
        else if (format.equals(MyFormatNumbers.FORMAT_DEC.get()) |
                format.equals(MyFormatNumbers.FORMAT_DOUBLE.get())) {
            limitDigit=3;
        }

        for (int i=oldString.length()-1; i>=0; i--){
            switch (oldString.charAt(i)){
                case '0','1','2','3','4','5','6','7','8','9',
                     'A','B','C','D','E','F'->{
                    if (digit<limitDigit) {
                        newSB = newSB.append(oldString.charAt(i));
                        digit++;
                    }
                    else{
                        newSB = newSB.append(" ").append(oldString.charAt(i));
                        digit=1;
                    }
                }
                case '+' ,'-','/','*','&','|','X'-> {
                    newSB = newSB.append(oldString.charAt(i)).append(" ");
                    digit=0;
                }
//                case '³' -> {
//                    newSB = newSB.append(" ").append(oldString.charAt(i));
//                    digit=0;
//                }
                default -> {
                    newSB = newSB.append(oldString.charAt(i));
                    digit=0;
                }
            }
        }





        newStr=newSB.reverse().toString();
        return newStr;
    }


}
