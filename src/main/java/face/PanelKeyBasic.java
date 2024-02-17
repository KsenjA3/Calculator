package face;

import fitting.MySizePanel;

import javax.swing.*;
import java.util.HashMap;

public class PanelKeyBasic extends PanelKeyGeneral{

    ButtonsBasic buttonsBasic;
    private JPanel keyPanelBasic;

    /**
     * Basic PanelKey
     */
    PanelKeyBasic() {

        buttonsBasic =  new ButtonsBasic ();
        HashMap<String,JButton> listButtons= buttonsBasic.getButtons();

        keyPanelBasic = makePanelGeneral(listButtons);
    }


    /**
     * get  KeyPanel
     * @return Basic KeyPanel
     */
    JPanel getKeyPanel() {

        return keyPanelBasic;
    }


    /**
     * get Width Basic KeyPanel
     * @return Width KeyPanel
     */
    int getWidthKeyPanel () {
        return MySizePanel.WIDTH_SIZE_BASIC.get();
    }

}
