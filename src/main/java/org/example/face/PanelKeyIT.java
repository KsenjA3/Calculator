package org.example.face;

import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.StringUtils;
import org.example.fitting.MyColors;
import org.example.fitting.MyFonts;
import org.example.fitting.MyFormatNumbers;
import org.example.fitting.MySizePanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public  class PanelKeyIT extends PanelKeyGeneral{
    private final JPanel keyPanel;
    private PanelTextLog textPanel;
    protected HashMap<String,JButton> listButtons;
    protected ButtonsIT buttonsIT;
    protected JRadioButton  bDec, bHex, bBin ;
    private String oldFormatNumber, newFormatNumber;
    @Getter
    @Setter
    private String str, strRes;


     PanelKeyIT(PanelTextLog textPanel) {
         this.textPanel=textPanel;

         /**create IT KeyPanel          *
          */
         JPanel keyPanelIT = new JPanel();
         keyPanelIT.setBackground(MyColors.COLOR_PANE.get());
         keyPanelIT.setPreferredSize(new Dimension(MySizePanel.WIDTH_SIZE_IT.get(), MySizePanel.HIEGHT_SIZE_KEY.get()));
         keyPanelIT.setLayout(gbag);

         /**create IT buttons
          *
          */
         buttonsIT =  new ButtonsIT(textPanel);
         listButtons= buttonsIT.getButtons();
         Set<Map.Entry<String,JButton>> set =listButtons.entrySet();
         buttonsIT.blockedAll( buttonsIT.braceClose);
         buttonsIT.countBrace=0;

        /**create digitPanel format number
         *
         */
         var digitPanel = new JPanel();
         digitPanel.setBackground(MyColors.COLOR_PANE.get());
         digitPanel.setLayout(new BoxLayout(digitPanel,BoxLayout.X_AXIS));
         var bg = new ButtonGroup();

         bHex = new JRadioButton ("Hex");
                bHex.setBackground(MyColors.COLOR_PANE.get());
                bHex.setFont(MyFonts.FONT_CHECKBOX.get());
                bHex.setAlignmentX(Component.CENTER_ALIGNMENT);
                bHex.addActionListener(new ActionListener() {
                     @Override
                     public void actionPerformed(ActionEvent e) {
                         newFormatNumber= MyFormatNumbers.FORMAT_HEX.get() ;
                         setFormat_duringShift_JRadioButton();

                         buttonsIT.blockedAll( buttonsIT.bAnd, buttonsIT.bOr, buttonsIT.bXor, buttonsIT.bNot,buttonsIT.bPoint);
                         buttonsIT.unblockedAll(buttonsIT.bA, buttonsIT.bB, buttonsIT.bC, buttonsIT.bD, buttonsIT.bE, buttonsIT.bF,
                                         buttonsIT.bPlus,buttonsIT.bMinus,buttonsIT.bDivide,buttonsIT.bMultiply,
                                         buttonsIT.bRadical,buttonsIT.bPercent,buttonsIT.bResult,buttonsIT.braceOpen,
                                         buttonsIT.b0, buttonsIT.b1,buttonsIT.b2, buttonsIT.b3, buttonsIT.b4,
                                         buttonsIT.b5, buttonsIT.b6, buttonsIT.b7, buttonsIT.b8, buttonsIT.b9);

                     }
                });
            digitPanel.add(bHex);
            bg.add(bHex);

            bDec = new JRadioButton ("Dec");
                bDec.setBackground(MyColors.COLOR_PANE.get());
                bDec.setFont(MyFonts.FONT_CHECKBOX.get());
                bDec.setSelected(true);
                bDec.addActionListener(new ActionListener() {
                     @Override
                     public void actionPerformed(ActionEvent e) {
                         newFormatNumber= MyFormatNumbers.FORMAT_DEC.get() ;
                         setFormat_duringShift_JRadioButton();

                         buttonsIT.blockedAll(buttonsIT.bA, buttonsIT.bB, buttonsIT.bC, buttonsIT.bD, buttonsIT.bE, buttonsIT.bF,
                                 buttonsIT.bAnd, buttonsIT.bOr, buttonsIT.bXor, buttonsIT.bNot,buttonsIT.bPoint);
                         buttonsIT.unblockedAll(buttonsIT.braceOpen, buttonsIT.bMemoryAdd,
                                 buttonsIT.bPlus,buttonsIT.bMinus,buttonsIT.bDivide,buttonsIT.bMultiply,
                                 buttonsIT.bRadical,buttonsIT.bPercent,buttonsIT.bResult,
                                 buttonsIT.b0, buttonsIT.b1,buttonsIT.b2, buttonsIT.b3, buttonsIT.b4,
                                 buttonsIT.b5, buttonsIT.b6, buttonsIT.b7, buttonsIT.b8, buttonsIT.b9);

                     }
                });
            digitPanel.add(bDec);
            bg.add(bDec);

            bBin = new JRadioButton ("Bin");
                bBin.setBackground(MyColors.COLOR_PANE.get());
                bBin.setFont(MyFonts.FONT_CHECKBOX.get());
                bBin.addActionListener(new ActionListener() {
                     @Override
                     public void actionPerformed(ActionEvent e) {
                         newFormatNumber= MyFormatNumbers.FORMAT_BIN.get() ;
                         setFormat_duringShift_JRadioButton();

                         buttonsIT.blockedAll(buttonsIT.bA, buttonsIT.bB, buttonsIT.bC, buttonsIT.bD, buttonsIT.bE, buttonsIT.bF,
                                 buttonsIT.b2, buttonsIT.b3, buttonsIT.b4, buttonsIT.b5,buttonsIT.bPoint,
                                 buttonsIT.b6, buttonsIT.b7, buttonsIT.b8, buttonsIT.b9);
                         buttonsIT.unblockedAll(buttonsIT.bAnd, buttonsIT.bOr, buttonsIT.bXor, buttonsIT.bNot,
                                 buttonsIT.bPlus,buttonsIT.bMinus,buttonsIT.bDivide,buttonsIT.bMultiply,
                                 buttonsIT.bRadical,buttonsIT.bPercent,buttonsIT.bResult, buttonsIT.bMemoryAdd,
                                 buttonsIT.b0, buttonsIT.b1,buttonsIT.braceOpen);
                     }
               });

                buttonsIT.calculateCurrent.setFormat(MyFormatNumbers.FORMAT_DEC.get());
                digitPanel.add(bBin);
                bg.add(bBin);

         // line 1
            makeGridBagConstraints(0, 0, 3, 1, 0, 0);
            keyPanelIT.add(digitPanel, gbc);

         /**locate buttons to IT KeyPanel
          *
          */
         for (Map.Entry<String,JButton> button : set) {
             switch (button.getKey()) {

                 // line 2
                 case "&" -> {
                     makeGridBagConstraints(1, 0, 1, 1, 12, 10);
                     keyPanelIT.add(button.getValue(), gbc);
                 }case "AA"-> {
                     makeGridBagConstraints(1, 1, 1, 1, 0, 20);
                     keyPanelIT.add(button.getValue(), gbc);
                 }case "BB"-> {
                     makeGridBagConstraints(1, 2, 1, 1, 0, 20);
                     keyPanelIT.add(button.getValue(), gbc);
                 }


                 // line 3
                 case "|" -> {
                     makeGridBagConstraints(2, 0, 1, 1, 12, 20);
                     keyPanelIT.add(button.getValue(), gbc);
                 }case "CC"-> {
                     makeGridBagConstraints(2, 1, 1, 1, 0, 20);
                     keyPanelIT.add(button.getValue(), gbc);
                 }case "DD"-> {
                     makeGridBagConstraints(2, 2, 1, 1, 0, 20);
                     keyPanelIT.add(button.getValue(), gbc);
                 }


                 // line 4
                 case "^"-> {
                     makeGridBagConstraints(3, 0, 1, 1, 12, 10);
                     keyPanelIT.add(button.getValue(), gbc);
                 }case "EE"->{
                     makeGridBagConstraints(3, 1, 1, 1, 0, 20);
                     keyPanelIT.add(button.getValue(), gbc);
                 }case "FF" -> {
                     makeGridBagConstraints(3, 2, 1, 1, 0, 20);
                     keyPanelIT.add(button.getValue(), gbc);
                 }


                 // line 5
                 case "~"-> {
                     makeGridBagConstraints(4, 0, 1, 1, 12, 10);
                     keyPanelIT.add(button.getValue(), gbc);
                 }case "("-> {
                     makeGridBagConstraints(4, 1, 1, 1, 0, 25);
                     keyPanelIT.add(button.getValue(), gbc);
                 }case ")" -> {
                     makeGridBagConstraints(4, 2, 1, 1, 0, 25);
                     keyPanelIT.add(button.getValue(), gbc);
                 }
             }
         }

         /**create result Panel
          * included Engineer and Basic keyPanels
          */
         keyPanel = new JPanel();
         keyPanel.setLayout(new BoxLayout(keyPanel, BoxLayout.X_AXIS));
         keyPanel.add(keyPanelIT);
         keyPanel.add(makePanelGeneral(listButtons));

         buttonsIT.blockedAll(buttonsIT.bA, buttonsIT.bB, buttonsIT.bC, buttonsIT.bD, buttonsIT.bE, buttonsIT.bF,
                 buttonsIT.bAnd, buttonsIT.bOr, buttonsIT.bXor, buttonsIT.bNot, buttonsIT.bPoint);

     }


     /**get  KeyPanel
      * @return Engineer KeyPanel
      */
     JPanel getKeyPanel() {
         return keyPanel;
     }


     /**
      * get Width IT KeyPanel
      * @return Width KeyPanel
      */
     int getWidthKeyPanel () {
         return MySizePanel.WIDTH_SIZE_BASIC.get()+MySizePanel.WIDTH_SIZE_IT.get();
     }

     void setFormat_duringShift_JRadioButton() {
         oldFormatNumber= buttonsIT.calculateCurrent.getFormat();
         buttonsIT.calculateCurrent.setFormat(newFormatNumber);

         str=textPanel.getTextInput().getText();
         strRes=textPanel.getTextResult().getText();
         textPanel.setSbLog(str.trim());
         buttonsIT.print_SbLog ();

         try {
             strRes = buttonsIT.calculateCurrent.calculateIT.
                     shift_format_input_numbers(oldFormatNumber, newFormatNumber, strRes.replaceAll(" ", ""));
             textPanel.setTextResult("=" + strRes);
         } catch (MyException e) {
             textPanel.setTextResult(e.getMessage());
         }


         if(oldFormatNumber.equals("bin") && StringUtils.containsAny(str,"^","~","&","|")){
             textPanel.setTextInput(strRes);
         }else {
             try {
                 str=buttonsIT.calculateCurrent.calculateIT.
                         shift_format_input_numbers(oldFormatNumber,newFormatNumber,str.replaceAll(" ",""));
             } catch (MyException e) {
                 str=e.getMessage();
             }
             textPanel.setTextInput(str);
         }

        buttonsIT.countResult=strRes;





     }

 }
