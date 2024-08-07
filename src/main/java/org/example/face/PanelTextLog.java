package org.example.face;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import org.example.fitting.*;

import javax.swing.*;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import java.awt.*;

@Getter(AccessLevel.PROTECTED)
 class PanelTextLog extends PanelText{

     /**
      * to safe into the memory
      */
     protected String memoryMR;


    /**
     * for writing to calculator.org.example.face.PanelTextLog
     */
    private StringBuffer sbLog;
    private final JTextPane  textLog;
    private final JScrollPane  scrollLog;


    public PanelTextLog() {
        super();
        sbLog = new StringBuffer();
        textLog = new JTextPane();
        textLog.setBackground(MyColors.COLOR_BUTTON.get());
        var textLogAttributes = new SimpleAttributeSet();
        StyleConstants.setAlignment(textLogAttributes, StyleConstants.ALIGN_RIGHT);
        StyleConstants.setFontFamily(textLogAttributes, MyFontNames.FRONT_NAME_TEXT_LOG.get() );
        StyleConstants.setFontSize(textLogAttributes, MyFontSizes.FRONT_SIZE_TEXT_LOG.get() );
        StyleConstants.setForeground(textLogAttributes, MyColors.COLOR_LOG.get());
        textLog.setParagraphAttributes(textLogAttributes, true);

        scrollLog = new JScrollPane(textLog,
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollLog.setBorder(null);
    }

    /**
     * get TextPanel
     * @param widthSizeText depends on type of keyPanel
     * @return TextPanel
     * which include Log, Input and Result windows
     */
    @Override
    JPanel getTextPanel (int widthSizeText) {
        super.getTextPanel(widthSizeText).add(scrollLog);
        scrollLog.setPreferredSize(new Dimension(widthSizeText, MySizePanel.HIEGHT_SIZE_TEXT_LOG.get()));

        return super.getTextPanel(widthSizeText);
    }

    /**
     *get Height TextPanel
     * @return Height TextPanel
     */
    @Override
    int getHeightTextPanel (){ return MySizePanel.HIEGHT_SIZE_TEXT_INPUT.get()
            + MySizePanel.HIEGHT_SIZE_TEXT_RESULT.get()
            + MySizePanel.HIEGHT_SIZE_TEXT_LOG.get();}


    /**
     * manage visibility of Log
     * @param state Visible Log is true, unvisible - false
     * @param frame frame of calculator
     * @param widthSizeText depends on type of keyPanel
     */
    int setVisibleTextPanelLog (boolean state, JFrame frame, int widthSizeText) {
        scrollLog.setVisible(state);
        if (state){
            frame.setPreferredSize(new Dimension(widthSizeText,getHeightTextPanel()+MySizePanel.HIEGHT_SIZE_KEY.get()));
            getPanelResult().setPreferredSize(new Dimension(widthSizeText, MySizePanel.HIEGHT_SIZE_TEXT_RESULT.get()));
            getScrollInput().setPreferredSize(new Dimension(widthSizeText,MySizePanel.HIEGHT_SIZE_TEXT_INPUT.get()));
            textLog.setPreferredSize(new Dimension(widthSizeText,MySizePanel.HIEGHT_SIZE_TEXT_LOG.get()));

            return getHeightTextPanel ();
        }
        else {
            frame.setPreferredSize(new Dimension(widthSizeText,super.getHeightTextPanel()+MySizePanel.HIEGHT_SIZE_KEY.get()));
            getPanelResult().setPreferredSize(new Dimension(widthSizeText, MySizePanel.HIEGHT_SIZE_TEXT_RESULT.get()));
            getScrollInput().setPreferredSize(new Dimension(widthSizeText,MySizePanel.HIEGHT_SIZE_TEXT_INPUT.get()));

            return super.getHeightTextPanel();
        }
    }


    void setSbLog(String strLog) {
        sbLog = sbLog.append(strLog);
    }


     void setTextLog(String format, String strSbLog) {
         if(isDigitNumber()){
             strSbLog=digitNumbers(format,strSbLog);
         }
         textLog.setText(strSbLog);
     }



//    StringBuffer getSbLog () {    return  sbLog;    }
//    JTextPane getTextLog() { return textLog; }
//    JScrollPane getScrollLog (){ return scrollLog; }
}
