package org.example.face;


import lombok.Getter;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.calculate.CalculateInput;

import javax.swing.*;
@Log4j2
 abstract class ButtonsAll {
    protected int countBrace;
    protected String strInput, strResult;


     /**button simple calculation
     *
     */
    protected JButton b, b1, b2, b3, b4, b5, b6, b7, b8, b9, b0, bPoint;
    protected JButton bPlus, bMinus, bDivide, bMultiply, bPercent, bRadical, bResult;
    protected JButton bMemoryAdd, bMemoryDel, bMemoryHold, bClear, bDel;


     /**button IT calculation
      *
      */
    protected JButton bNot,bAnd, bOr, bXor, bA,bB,bC,bD,bE,bF;


     /** button engineer calculation
      *
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
         strInput=StringUtils.removeEnd(strInput, "³√(");
         strInput=StringUtils.removeEnd(strInput, "√");
         strInput=StringUtils.removeEnd(strInput, "√");
         strInput=StringUtils.removeEnd(strInput, "√");
     }

     void replaceRepeatedSign_simple () {
         strInput=StringUtils.removeEnd(strInput, " -");
         strInput=StringUtils.removeEnd(strInput, " +");
         strInput=StringUtils.removeEnd(strInput, " *");
         strInput=StringUtils.removeEnd(strInput, " /");
     }

     void replaceRepeatedSign_exceptSimple () {
         strInput=StringUtils.removeEnd(strInput, "%");
         strInput=StringUtils.removeEnd(strInput, "²");
         strInput=StringUtils.removeEnd(strInput, "³");
         strInput=StringUtils.removeEnd(strInput, "!");
         strInput=StringUtils.removeEnd(strInput, "^(-1)");
     }

     void replaceRepeatedSign_IT (){
         strInput=StringUtils.removeEnd(strInput, " Xor");
         strInput=StringUtils.removeEnd(strInput, " |");
         strInput=StringUtils.removeEnd(strInput, " &");
         strInput=StringUtils.removeEnd(strInput, "√");
         strInput=StringUtils.removeEnd(strInput, "√");
         strInput=StringUtils.removeEnd(strInput, "√");
     }



    /**
     * block keys on panel calculator
     *
     * @param v blocking keys
     */
    void blockedAll(JButton... v) {
        for (JButton b : v)
            b.setEnabled(false);
    }

    /**
     * unblock keys on panel calculator
     *
     * @param v unblocking keys
     */
    void unblockedAll(JButton... v) {
        for (JButton b : v)
            b.setEnabled(true);
    }



    //blocked buttons
    void myExceptionBlockButtons(MyException myException) {
        if (countBrace == 0) {
            if (myException.getMessage().equals("Формат работает только с целыми числами.")) {
                blockedAll(bPlus, bMinus, bDivide, bMultiply, bPercent, bRadical, bResult, bMemoryAdd, bPoint);
            }
            else if (myException.getMessage().equals("Работает только с положительными числами.")) {
                blockedAll(bPlus, bMinus, bMultiply, bPercent, bRadical, bResult, bMemoryAdd, bPoint);
                try {
                    blockedAll(bNot, bXor, bOr, bAnd);
                } catch (NullPointerException exception) {
                }

            }
            else {
                blockedAll(bPlus, bMinus, bDivide, bMultiply, bPercent, bRadical, bResult, bMemoryAdd,
                        b0, b1, b2, b3, b4, b5, b6, b7, b8, b9, bPoint);
                try {
                    blockedAll(bNot, bXor, bOr, bAnd, bA, bB, bC, bD, bE, bF);
                } catch (NullPointerException exception) {
                }
            }

            try {
                blockedAll(bPi, bSin, bCos, bTg, bLg, bLn, bFactorial, bDivX,
                        bxn, bx2, bx3, bSqrt3, bChageSign, braceOpen, braceClose);
            } catch (NullPointerException exception) {
            }
        }
    }


    // handle ArithmeticException
    void handleArithmeticException(ArithmeticException ex) {

        if(ex.getMessage().equals("Division by zero")){
            strResult = "Делить на 0 нельзя.";
            if (countBrace == 0) {
                blockedAll(bPlus, bMinus, bDivide, bMultiply, bPercent, bRadical, bResult, bMemoryAdd);
                try {
                    blockedAll(
                            bPi, bSin, bCos, bTg, bLg, bLn, bFactorial, bDivX, bxn, bx2, bx3, bSqrt3, bChageSign,
                            braceOpen, braceClose, bChageSign);
                } catch (NullPointerException exception) {
                }

                try {
                    blockedAll(braceOpen, bNot, bXor, bOr, bAnd);
                } catch (NullPointerException exception) {
                }
            }


        }
    }


}
