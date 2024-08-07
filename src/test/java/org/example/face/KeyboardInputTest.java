package org.example.face;

import org.example.face.PanelTextLog;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import javax.swing.*;
import java.awt.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class KeyboardInputTest {
    JTextPane txt;
    JLabel lable;
    Robot bot;

    @Mock
    PanelTextLog textPanel;

    @BeforeAll
    void init() throws AWTException {
        MockitoAnnotations.openMocks(this);
        txt =new JTextPane();
        lable= new JLabel();
        lable.setText("22");

        bot = new Robot();

        Mockito.doNothing().when(textPanel).setSbLog(Mockito.any());
        Mockito.doNothing().when(textPanel).setTextInput(Mockito.any(), Mockito.any());
        Mockito.doNothing().when(textPanel).setTextResult(Mockito.any(), Mockito.any());

        Mockito.when(textPanel.getSbLog()).thenReturn(new StringBuffer(" "));
        Mockito.when(textPanel.getTextResult()).thenReturn(lable);

    }
    @Test
    void workKeyInput () {

//        txt.setText("2+8");
//        Mockito.when(textPanel.getTextInput()).thenReturn(txt);
//        keyboardIn= new KeyboardInput(textPanel);
//
//textPanel.getTextInput().requestFocus(true);
//
//        bot.keyPress(KeyEvent.VK_ENTER);
//        try{Thread.sleep(10);}catch(InterruptedException e){}
//        bot.keyRelease(KeyEvent.VK_ENTER);


//        assertEquals("2+8", keyboardIn.str);
//        assertEquals(10, keyboardIn.dResult, 0.000001);
    }

}