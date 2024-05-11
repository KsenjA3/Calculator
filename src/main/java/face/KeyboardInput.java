package face;

import calculate.CalculateBasic;
import calculate.CalculateInput;
import calculate.Operations;
import org.apache.commons.lang3.StringUtils;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class KeyboardInput {
    PanelTextLog textPanel;

    /**
     * result of calculation
     * from calculator.face.PanelText
     */
    protected String countResult;
    protected String str;
    private CalculateInput calculateCurrent;

    KeyboardInput (PanelTextLog textPanel) {
        this.textPanel=textPanel;
        calculateCurrent = new CalculateInput();
        textPanelInputKeys();
    }

    /**
     * behavior keys inputing  to textPanel
     */
    private class TextPanelInputKeysAction extends AbstractAction {
        @Override
        public void actionPerformed(ActionEvent e) {
            str = textPanel.getTextInput().getText();
            str= StringUtils.deleteWhitespace(str);

            for (int i = 0; i < str.length()-1; i++) {
                switch (str.charAt(i)) {
                    case '+', '-', '/', '*' ,'√' -> {
                        switch (str.charAt(i + 1)) {
                            case '+', '-', '/', '*','^','²','³','!' ->
                                    str = str.substring(0, i) + str.substring(i + 1);
                        }
                    }
                    case '^' -> {
                        switch (str.charAt(i + 1)) {
                            case '+', '-', '/', '*','^','²','³','!','√' ->
                                    str = str.substring(0, i) + str.substring(i + 1);
                        }
                    }
                    case '²','³','!' -> {
                        switch (str.charAt(i + 1)) {
                            case '^','²','³','!','√' ->
                                    str = str.substring(0, i) + str.substring(i + 1);
                        }
                    }
                    case '1', '2', '3', '4' ,'5', '6', '7', '8', '9' ,'0' -> {
                        switch (str.charAt(i + 1)) {
                            case '(' -> str = str.substring(0, i+1) + "*"+str.substring(i+1 );
                        }
                    }
                    case '.' -> {
                        switch (str.charAt(i + 1)) {
                            case '(' -> str = str.substring(0, i) + "*"+str.substring(i+1 );
                        }
                    }
                }
            }

            //Change FONT
            textPanel.setFontBoldResult();
            textPanel.setTextInput(str.trim());

            try {
                countResult = calculateCurrent.calculateInput(str);
                textPanel.setTextResult("=" + countResult);

                textPanel.setSbLog(textPanel.getTextInput().getText());
                textPanel.setSbLog("\n");
                textPanel.setSbLog(textPanel.getTextResult().getText());
                textPanel.setSbLog("\n");
                textPanel.setTextLog( textPanel.getSbLog().toString());
            }catch (MyException myException){
                str = myException.getMessage();
                textPanel.setTextResult(str);
            }
//            focus to visible keyPenel
//            focusVisibleKeyPenel ();
        }
    }


    /**
     * inputing Keys to textPanel
     */
    private void textPanelInputKeys() {
        var textPanelInputKeysAction = new TextPanelInputKeysAction();
        textPanel.getTextInput().getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), "focusKeyPanel");
        textPanel.getTextInput().getActionMap().put("focusKeyPanel", textPanelInputKeysAction);

        textPanel.getTextInput().getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_EQUALS, 0), "correctInput");
        textPanel.getTextInput().getActionMap().put("correctInput", textPanelInputKeysAction);

        ignoreLetter(
                'q', 'w', 'e', 'r', 't', 'y', 'u', 'i', 'o', 'p', 'a', 's', 'd', 'f', 'g', 'h', 'j', 'k', 'l', 'z', 'x', 'c', 'v', 'b', 'n', 'm',
                     'Q', 'W', 'E', 'R', 'T', 'Y', 'U', 'I', 'O', 'P', 'A', 'S', 'D', 'F', 'G', 'H', 'J', 'K', 'L', 'Z', 'X', 'C', 'V', 'B', 'N', 'M',
                     '<', '>', '?', '@', '#', '$', '%', '&',  ':', ';', '"', ',', '[', ']', '{', '}', '`', '~',
                     'ё', 'й', 'ц', 'у', 'к', 'е', 'н', 'г', 'ш', 'щ', 'з', 'х', 'ъ', 'ф', 'ы', 'в', 'а', 'п', 'р', 'о', 'л', 'д', 'ж', 'э', 'я', 'ч', 'с', 'м', 'и', 'т', 'ь', 'б', 'ю',
                     'Ё', 'Й', 'Ц', 'У', 'К', 'Е', 'Н', 'Г', 'Ш', 'Щ', 'З', 'Х', 'Ъ', 'Ф', 'Ы', 'В', 'А', 'П', 'Р', 'О', 'Л', 'Д', 'Ж', 'Э', 'Я', 'Ч', 'С', 'М', 'И', 'Т', 'Ь', 'Б', 'Ю'
        );
    }

    /**
     * ignor keys inputing to textInputPanel
     * @param var ignoring keys
     */
    private void ignoreLetter(char... var) {
        for (char c : var) {
            textPanel.getTextInput().getInputMap().put(KeyStroke.getKeyStroke(c), "none");
        }
    }

}
