package face;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class KeyboardInputTest {
    JTextPane txt;
    JLabel lable;
    KeyboardInput keyboardIn;
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
        Mockito.doNothing().when(textPanel).setTextInput(Mockito.any());
        Mockito.doNothing().when(textPanel).setTextResult(Mockito.any());

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