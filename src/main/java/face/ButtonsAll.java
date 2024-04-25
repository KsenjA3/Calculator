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


     /**
      * button engineer calculation
      */
     protected JButton braceOpen, braceClose, bx2, bx3, bxn, bSqrt3, bLn, bLg,
            bFactorial, bDivX, bChageSign, bSin, bCos, bTg, bPi;



     void replaceRepeatedSign_always (PanelTextLog textPanel) {
         textPanel.setStrInput(StringUtils.removeEnd(textPanel.getStrInput(), "^"));
         textPanel.setStrInput(StringUtils.removeEnd(textPanel.getStrInput(), "tg("));
         textPanel.setStrInput(StringUtils.removeEnd(textPanel.getStrInput(), "sin("));
         textPanel.setStrInput(StringUtils.removeEnd(textPanel.getStrInput(), "cos("));
         textPanel.setStrInput(StringUtils.removeEnd(textPanel.getStrInput(), "ln("));
         textPanel.setStrInput(StringUtils.removeEnd(textPanel.getStrInput(), "lg("));
         textPanel.setStrInput(StringUtils.removeEnd(textPanel.getStrInput(), "³√"));
         textPanel.setStrInput(StringUtils.removeEnd(textPanel.getStrInput(), "√"));
         textPanel.setStrInput(StringUtils.removeEnd(textPanel.getStrInput(), "√"));
         textPanel.setStrInput(StringUtils.removeEnd(textPanel.getStrInput(), "√"));
     }

     void replaceRepeatedSign_simple (PanelTextLog textPanel) {
         textPanel.setStrInput(StringUtils.removeEnd(textPanel.getStrInput(), "-"));
         textPanel.setStrInput(StringUtils.removeEnd(textPanel.getStrInput(), "+"));
         textPanel.setStrInput(StringUtils.removeEnd(textPanel.getStrInput(), "*"));
         textPanel.setStrInput(StringUtils.removeEnd(textPanel.getStrInput(), "/"));
     }
     void replaceRepeatedSign_exceptSimple (PanelTextLog textPanel) {
         textPanel.setStrInput(StringUtils.removeEnd(textPanel.getStrInput(), "%"));
         textPanel.setStrInput(StringUtils.removeEnd(textPanel.getStrInput(), "²"));
         textPanel.setStrInput(StringUtils.removeEnd(textPanel.getStrInput(), "³"));
         textPanel.setStrInput(StringUtils.removeEnd(textPanel.getStrInput(), "!"));
     }
}
