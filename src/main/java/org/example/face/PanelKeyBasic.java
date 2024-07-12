package org.example.face;

import org.example.fitting.MySizePanel;

import javax.swing.*;
import java.util.HashMap;

public class PanelKeyBasic extends PanelKeyGeneral{
    PanelTextLog textPanel;
    ButtonsBasic buttonsBasic;
    private JPanel keyPanelBasic;

    /**Basic PanelKey
     *
     */
    PanelKeyBasic(PanelTextLog textPanel) {
        this.textPanel=textPanel;

        buttonsBasic =  new ButtonsBasic (textPanel);
        HashMap<String,JButton> listButtons= buttonsBasic.getButtons();
        keyPanelBasic = makePanelGeneral(listButtons);
    }

    /**get  KeyPanel
     * @return Basic KeyPanel
     */
    JPanel getKeyPanel() {
        return keyPanelBasic;
    }


    /**get Width Basic KeyPanel
     * @return Width KeyPanel
     */
    int getWidthKeyPanel () {
        return MySizePanel.WIDTH_SIZE_BASIC.get();
    }

}
