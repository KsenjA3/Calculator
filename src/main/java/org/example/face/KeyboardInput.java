package org.example.face;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.calculate.CalculateInput;
import org.apache.commons.lang3.StringUtils;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class KeyboardInput {
    PanelTextLog textPanel;

    /**
     * result of calculation
     * from calculator.org.example.face.PanelText
     */
    protected String countResult;
    protected String str;
    private CalculateInput calculateCurrent;
    private ButtonsBasic buttonsBasic;
    private static final Logger logger = LogManager.getLogger(KeyboardInput.class);

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
            textPanel.setTextInput(calculateCurrent.getFormat(),str.trim());

            try {
                countResult = calculateCurrent.calculateInput(str);

                textPanel.setTextResult(calculateCurrent.getFormat(),"=" + countResult);

                textPanel.setSbLog(textPanel.getTextInput().getText());
                textPanel.setSbLog("\n");
                textPanel.setSbLog(textPanel.getTextResult().getText());
                textPanel.setSbLog("\n");
                textPanel.setTextLog(calculateCurrent.getFormat(), textPanel.getSbLog().toString());
            }catch (MyException myException){
                str = myException.getMessage();
                textPanel.setTextResult(calculateCurrent.getFormat(),str);
                logger.error("logger.error: ошибка ввода данных через Keyboard: {}",str);
            }catch (Exception exception){
                str = exception.getMessage();
                logger.error("logger.error: ошибка ввода данных через Keyboard: {}",str);
                if (str.equals("Character array contains more than one decimal point."))
                    str="ошибка ввода данных";
                textPanel.setTextResult(calculateCurrent.getFormat(),str);

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
                'q', 'w', 'r', 't', 'y', 'u', 'i', 'o', 'p', 's', 'g', 'h', 'j', 'k', 'l', 'z', 'x', 'v', 'n', 'm',
                     'Q', 'W', 'R', 'T', 'Y', 'U', 'I', 'O', 'P', 'S', 'G', 'H', 'J', 'K', 'L', 'Z', 'X', 'V', 'N', 'M',
                     '<', '>', '?', '@', '#', '$', '%',  ':', ';', '"', ',', '[', ']', '{', '}', '`',
                     'A', 'B', 'C', 'D','E', 'F',
//                            'a','b','c','d','e','f',
//                            '~','&','|',
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
