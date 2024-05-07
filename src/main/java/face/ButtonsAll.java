package face;


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

     void replaceRepeatedSign_always () {
         strInput=StringUtils.removeEnd(strInput, "^");
         strInput=StringUtils.removeEnd(strInput, "tg(");
         strInput=StringUtils.removeEnd(strInput, "sin(");
         strInput=StringUtils.removeEnd(strInput, "cos(");
         strInput=StringUtils.removeEnd(strInput,"ln(" );
         strInput=StringUtils.removeEnd(strInput, "lg(");
         strInput=StringUtils.removeEnd(strInput, "³√");
         strInput=StringUtils.removeEnd(strInput, "√");
         strInput=StringUtils.removeEnd(strInput, "√");
         strInput=StringUtils.removeEnd(strInput, "√");
     }

     void replaceRepeatedSign_simple () {
         strInput=StringUtils.removeEnd(strInput, "-");
         strInput=StringUtils.removeEnd(strInput, "+");
         strInput=StringUtils.removeEnd(strInput, "*");
         strInput=StringUtils.removeEnd(strInput, "/");
     }
     void replaceRepeatedSign_exceptSimple () {
         strInput=StringUtils.removeEnd(strInput, "%");
         strInput=StringUtils.removeEnd(strInput, "²");
         strInput=StringUtils.removeEnd(strInput, "³");
         strInput=StringUtils.removeEnd(strInput, "!");
     }
}
