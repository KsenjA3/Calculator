package org.example.face;

import org.example.fitting.MyColors;
import org.example.fitting.MySizePanel;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

abstract class PanelKeyGeneral extends JPanel{

    private JPanel keyPanelGeneral;
    protected GridBagLayout gbag;
    protected GridBagConstraints gbc;

    protected PanelKeyGeneral(){
         gbag = new GridBagLayout();
         gbc = new GridBagConstraints();

        gbc.fill = GridBagConstraints.CENTER;
        gbc.weightx = 100;
        gbc.weighty = 100;
    }

    /**get General KeyPanel
     * @return Basic KeyPanel
     */
   JPanel makePanelGeneral (HashMap<String,JButton> listButtons) {

       // create keyPanel
       keyPanelGeneral = new JPanel();
       keyPanelGeneral.setBackground(MyColors.COLOR_PANE.get());
       keyPanelGeneral.setPreferredSize(new Dimension(MySizePanel.WIDTH_SIZE_BASIC.get(), MySizePanel.HIEGHT_SIZE_KEY.get()));
       keyPanelGeneral.setLayout(gbag);

       Set <Map.Entry<String,JButton>> set =listButtons.entrySet();

       for (Map.Entry<String,JButton> button : set) {
           switch (button.getKey()) {

               // line 1
               case "AC" ->{
                   makeGridBagConstraints(0, 0, 1, 1, 0, 10);
                   keyPanelGeneral.add(button.getValue(), gbc);
               }
               case "C" ->{
                   makeGridBagConstraints(0, 1, 1, 1, 0, 29);
                   keyPanelGeneral.add(button.getValue(), gbc);
               }
               case "MR" ->{
                   makeGridBagConstraints(0, 2, 1, 1, 0, 1);
                   keyPanelGeneral.add(button.getValue(), gbc);
               }
               case "M+" ->{
                   makeGridBagConstraints(0, 3, 1, 1, 0, 4);
                   keyPanelGeneral.add(button.getValue(), gbc);
               }
               case "M-" ->{
                   makeGridBagConstraints(0, 4, 1, 1, 0, 11);
                   keyPanelGeneral.add(button.getValue(), gbc);
               }

               //line 2
               case "7" ->{
                   makeGridBagConstraints(1, 0, 1, 1, 0, 20);
                   keyPanelGeneral.add(button.getValue(), gbc);
               }
               case "8" ->{
                   makeGridBagConstraints(1, 1, 1, 1, 0, 20);
                   keyPanelGeneral.add(button.getValue(), gbc);
               }
               case "9" ->{
                   makeGridBagConstraints(1, 2, 1, 1, 0, 20);
                   keyPanelGeneral.add(button.getValue(), gbc);
               }
               case " / " ->{
                   makeGridBagConstraints(1, 3, 1, 1, 0, 8);
                   keyPanelGeneral.add(button.getValue(), gbc);
               }
               case " % " ->{
                   makeGridBagConstraints(1, 4, 1, 1, 0, 0);
                   keyPanelGeneral.add(button.getValue(), gbc);
               }

               //line 3
               case "4" ->{
                   makeGridBagConstraints(2, 0, 1, 1, 0, 20);
                   keyPanelGeneral.add(button.getValue(), gbc);
               }
               case "5" ->{
                   makeGridBagConstraints(2, 1, 1, 1, 0, 20);
                   keyPanelGeneral.add(button.getValue(), gbc);
               }
               case "6" ->{
                   makeGridBagConstraints(2, 2, 1, 1, 0, 20);
                   keyPanelGeneral.add(button.getValue(), gbc);
               }
               case " * " ->{
                   makeGridBagConstraints(2, 3, 1, 1, 0, 6);
                   keyPanelGeneral.add(button.getValue(), gbc);
               }
               case " √ " ->{
                   makeGridBagConstraints(2, 4, 1, 1, 0, 8);
                   keyPanelGeneral.add(button.getValue(), gbc);
               }

               //line 4
               case "1" ->{
                   makeGridBagConstraints(3, 0, 1, 1, 0, 20);
                   keyPanelGeneral.add(button.getValue(), gbc);
               }
               case "2" ->{
                   makeGridBagConstraints(3, 1, 1, 1, 0, 20);
                   keyPanelGeneral.add(button.getValue(), gbc);
               }
               case "3" ->{
                   makeGridBagConstraints(3, 2, 1, 1, 0, 20);
                   keyPanelGeneral.add(button.getValue(), gbc);
               }
               case " + " ->{
                   makeGridBagConstraints(3, 3, 1, 1, 0, 6);
                   keyPanelGeneral.add(button.getValue(), gbc);
               }
               case " = " ->{
                   makeGridBagConstraints(3, 4, 1, 2, 50, 6);
                   keyPanelGeneral.add(button.getValue(), gbc);
               }

               //line 5
               case "0" ->{
                   makeGridBagConstraints(4, 0, 2, 1, 0, 71);
                   keyPanelGeneral.add(button.getValue(), gbc);
               }
               case "." ->{
                   makeGridBagConstraints(4, 2, 1, 1, 0, 30);
                   keyPanelGeneral.add(button.getValue(), gbc);
               }
               case " - " ->{
                   makeGridBagConstraints(4, 3, 1, 1, 0, 16);
                   keyPanelGeneral.add(button.getValue(), gbc);
               }
           }
       }

       return keyPanelGeneral;
    }


    /**
     * setings GridBagConstraints
     * @param gridy row button
     * @param gridx column button
     * @param gridwidth width button
     * @param gridheight height button
     * @param ipady inly filling button along vertical
     * @param ipadx inly filling button along horizontal
     */
    void makeGridBagConstraints(int gridy, int gridx, int gridwidth, int gridheight, int ipady, int ipadx) {
        gbc.gridy = gridy;
        gbc.gridx = gridx;
        gbc.gridwidth = gridwidth;
        gbc.gridheight = gridheight;
        gbc.ipady = ipady;
        gbc.ipadx = ipadx;
    }



}
