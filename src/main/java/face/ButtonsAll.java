package face;

import calculate.Operations;
import org.apache.commons.lang3.StringUtils;

import javax.swing.*;

 abstract class ButtonsAll {


    /**
     * button simple calculation
     */
    protected JButton b, b1, b2, b3, b4, b5, b6, b7, b8, b9, b0, bPoint;
    protected JButton bPlus, bMinus, bDivide, bMultiply, bPercent, bRadical, bResult;
    protected JButton bMemoryAdd, bMemoryDel, bMemoryHold, bClear, bDel;

    protected String strInput, strResult;

     /**
      * button engineer calculation
      */
     protected JButton braceOpen, braceClose, bx2, bx3, bxn, bSqrt3, bLn, bLg,
            bFactorial, bDivX, bChageSign, bSin, bCos, bTg, bPi;



     void replaceRepeatedSign_always (PanelTextLog textPanel) {
         textPanel.setTextInput(StringUtils.removeEnd(textPanel.getTextInput().getText(), "^"));
         textPanel.setTextInput(StringUtils.removeEnd(textPanel.getTextInput().getText(), "tg("));
         textPanel.setTextInput(StringUtils.removeEnd(textPanel.getTextInput().getText(), "sin("));
         textPanel.setTextInput(StringUtils.removeEnd(textPanel.getTextInput().getText(), "cos("));
         textPanel.setTextInput(StringUtils.removeEnd(textPanel.getTextInput().getText(), "ln("));
         textPanel.setTextInput(StringUtils.removeEnd(textPanel.getTextInput().getText(), "lg("));
         textPanel.setTextInput(StringUtils.removeEnd(textPanel.getTextInput().getText(), "³√"));
         textPanel.setTextInput(StringUtils.removeEnd(textPanel.getTextInput().getText(), "√"));
         textPanel.setTextInput(StringUtils.removeEnd(textPanel.getTextInput().getText(), "√"));
         textPanel.setTextInput(StringUtils.removeEnd(textPanel.getTextInput().getText(), "√"));
     }

     void replaceRepeatedSign_simple (PanelTextLog textPanel) {
         textPanel.setTextInput(StringUtils.removeEnd(textPanel.getTextInput().getText(), "-"));
         textPanel.setTextInput(StringUtils.removeEnd(textPanel.getTextInput().getText(), "+"));
         textPanel.setTextInput(StringUtils.removeEnd(textPanel.getTextInput().getText(), "*"));
         textPanel.setTextInput(StringUtils.removeEnd(textPanel.getTextInput().getText(), "/"));
     }
     void replaceRepeatedSign_exceptSimple (PanelTextLog textPanel) {
         textPanel.setTextInput(StringUtils.removeEnd(textPanel.getTextInput().getText(), "%"));
         textPanel.setTextInput(StringUtils.removeEnd(textPanel.getTextInput().getText(), "²"));
         textPanel.setTextInput(StringUtils.removeEnd(textPanel.getTextInput().getText(), "³"));
         textPanel.setTextInput(StringUtils.removeEnd(textPanel.getTextInput().getText(), "!"));
     }
}
