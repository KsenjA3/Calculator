package org.example.face;

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
     private JPanel keyPanelIT, keyPanel;
    PanelTextLog textPanel;
    HashMap<String,JButton> listButtons;
    ButtonsIT buttonsIT;
    JRadioButton  bDec;

     PanelKeyIT(PanelTextLog textPanel) {
         this.textPanel=textPanel;

         /**create IT KeyPanel
          *
          */
         keyPanelIT = new JPanel();
         keyPanelIT.setBackground(MyColors.COLOR_PANE.get());
         keyPanelIT.setPreferredSize(new Dimension(MySizePanel.WIDTH_SIZE_IT.get(), MySizePanel.HIEGHT_SIZE_KEY.get()));
         keyPanelIT.setLayout(gbag);

         /**create IT buttons
          *
          */
         buttonsIT =  new ButtonsIT(textPanel);
         listButtons= buttonsIT.getButtons();
         Set<Map.Entry<String,JButton>> set =listButtons.entrySet();

        /**create digitPanel format number
         *
         */
         var digitPanel = new JPanel();
         digitPanel.setBackground(MyColors.COLOR_PANE.get());
         digitPanel.setLayout(new BoxLayout(digitPanel,BoxLayout.X_AXIS));
         var bg = new ButtonGroup();

            var  bHex = new JRadioButton ("Hex");
                bHex.setBackground(MyColors.COLOR_PANE.get());
                bHex.setFont(MyFonts.FONT_CHECKBOX.get());
                bHex.setAlignmentX(Component.CENTER_ALIGNMENT);
                bHex.addActionListener(new ActionListener() {
                     @Override
                     public void actionPerformed(ActionEvent e) {
                         String oldFormatNumber= buttonsIT.calculateCurrent.getFormat();

                         buttonsIT.calculateCurrent.setFormat(MyFormatNumbers.FORMAT_HEX.get());
                         buttonsIT.blockedAll( buttonsIT.bAnd, buttonsIT.bOr, buttonsIT.bXor, buttonsIT.bNot,buttonsIT.bPoint);
                         buttonsIT.unblockedAll(buttonsIT.bA, buttonsIT.bB, buttonsIT.bC, buttonsIT.bD, buttonsIT.bE, buttonsIT.bF,
                                 buttonsIT.b2, buttonsIT.b3, buttonsIT.b4, buttonsIT.b5,
                                 buttonsIT.b6, buttonsIT.b7, buttonsIT.b8, buttonsIT.b9);

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
                         buttonsIT.calculateCurrent.setFormat(MyFormatNumbers.FORMAT_DEC.get());
                         buttonsIT.blockedAll(buttonsIT.bA, buttonsIT.bB, buttonsIT.bC, buttonsIT.bD, buttonsIT.bE, buttonsIT.bF,
                                 buttonsIT.bAnd, buttonsIT.bOr, buttonsIT.bXor, buttonsIT.bNot,buttonsIT.bPoint);
                         buttonsIT.unblockedAll( buttonsIT.b2, buttonsIT.b3, buttonsIT.b4, buttonsIT.b5,
                                                 buttonsIT.b6, buttonsIT.b7, buttonsIT.b8, buttonsIT.b9);
                     }
                });
            digitPanel.add(bDec);
            bg.add(bDec);

            var  bBin = new JRadioButton ("Bin");
                bBin.setBackground(MyColors.COLOR_PANE.get());
                bBin.setFont(MyFonts.FONT_CHECKBOX.get());
                bBin.addActionListener(new ActionListener() {
                     @Override
                     public void actionPerformed(ActionEvent e) {
                         buttonsIT.calculateCurrent.setFormat(MyFormatNumbers.FORMAT_BIN.get());
                         buttonsIT.blockedAll(buttonsIT.bA, buttonsIT.bB, buttonsIT.bC, buttonsIT.bD, buttonsIT.bE, buttonsIT.bF,
                                 buttonsIT.b2, buttonsIT.b3, buttonsIT.b4, buttonsIT.b5,buttonsIT.bPoint,
                                 buttonsIT.b6, buttonsIT.b7, buttonsIT.b8, buttonsIT.b9);
                         buttonsIT.unblockedAll(buttonsIT.bAnd, buttonsIT.bOr, buttonsIT.bXor, buttonsIT.bNot);
                     }
               });
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
                 case "And" -> {
                     makeGridBagConstraints(1, 0, 1, 1, 12, 10);
                     keyPanelIT.add(button.getValue(), gbc);
                 }case "A"-> {
                     makeGridBagConstraints(1, 1, 1, 1, 0, 20);
                     keyPanelIT.add(button.getValue(), gbc);
                 }case "B"-> {
                     makeGridBagConstraints(1, 2, 1, 1, 0, 20);
                     keyPanelIT.add(button.getValue(), gbc);
                 }


                 // line 3
                 case "Or" -> {
                     makeGridBagConstraints(2, 0, 1, 1, 12, 20);
                     keyPanelIT.add(button.getValue(), gbc);
                 }case "С"-> {
                     makeGridBagConstraints(2, 1, 1, 1, 0, 20);
                     keyPanelIT.add(button.getValue(), gbc);
                 }case "D"-> {
                     makeGridBagConstraints(2, 2, 1, 1, 0, 20);
                     keyPanelIT.add(button.getValue(), gbc);
                 }


                 // line 4
                 case "Xor"-> {
                     makeGridBagConstraints(3, 0, 1, 1, 12, 10);
                     keyPanelIT.add(button.getValue(), gbc);
                 }case "E"->{
                     makeGridBagConstraints(3, 1, 1, 1, 0, 20);
                     keyPanelIT.add(button.getValue(), gbc);
                 }case "F" -> {
                     makeGridBagConstraints(3, 2, 1, 1, 0, 20);
                     keyPanelIT.add(button.getValue(), gbc);
                 }


                 // line 5
                 case "Not"-> {
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


 }
