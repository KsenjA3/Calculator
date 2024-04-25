package face;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import javax.swing.*;
import java.awt.*;
import java.awt.event.InputEvent;

import static org.junit.jupiter.api.Assertions.*;
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class ButtonsBasicTest {
    Point locate;
    JTextPane txt;
    JLabel lable;
    JFrame frame;
    PanelKeyEngineer panelKey;

    Robot bot;
    @Mock
    PanelTextLog textPanel;

    @AfterAll
    void hideFrame() {
        frame.setVisible(false);
    }

    @BeforeAll
    void initFrame() throws AWTException {
        MockitoAnnotations.openMocks(this);
        frame = new JFrame();
        frame.setSize(new Dimension(500, 300));
        panelKey =new PanelKeyEngineer(textPanel);

        frame.add(panelKey.getKeyPanel());
        frame.setVisible(true);

        bot = new Robot();
        txt =new JTextPane();
        lable= new JLabel();
        lable.setText("22");

        Mockito.doNothing().when(textPanel).setSbLog(Mockito.any());
        Mockito.when(textPanel.getSbLog()).thenReturn(new StringBuffer(" "));
        Mockito.when(textPanel.getTextInput()).thenReturn(txt);
        Mockito.when(textPanel.getTextResult()).thenReturn(lable);

    }


    @Test
    void number_press( )  {
        locate=panelKey.buttonsEngineer.b1.getLocationOnScreen();
            bot.mouseMove(locate.x+10,locate.y+10);
            bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
            bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
            try{Thread.sleep(50);}catch(InterruptedException e){}
        assertEquals(1, panelKey.buttonsEngineer.dNumber, 0.000000001);

        locate=panelKey.buttonsEngineer.b2.getLocationOnScreen();
            bot.mouseMove(locate.x+10,locate.y+10);
            bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
            bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
            try{Thread.sleep(50);}catch(InterruptedException e){}
        assertEquals(12, panelKey.buttonsEngineer.dNumber, 0.000000001);

        locate=panelKey.buttonsEngineer.b3.getLocationOnScreen();
            bot.mouseMove(locate.x+10,locate.y+10);
            bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
            bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
            try{Thread.sleep(50);}catch(InterruptedException e){}
        assertEquals(123, panelKey.buttonsEngineer.dNumber, 0.000000001);

        locate=panelKey.buttonsEngineer.b4.getLocationOnScreen();
            bot.mouseMove(locate.x+10,locate.y+10);
            bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
            bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
            try{Thread.sleep(50);}catch(InterruptedException e){}
        assertEquals(1234, panelKey.buttonsEngineer.dNumber, 0.000000001);

        locate=panelKey.buttonsEngineer.b5.getLocationOnScreen();
            bot.mouseMove(locate.x+10,locate.y+10);
            bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
            bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
            try{Thread.sleep(50);}catch(InterruptedException e){}
        assertEquals(12345, panelKey.buttonsEngineer.dNumber, 0.000000001);

        panelKey.buttonsEngineer.strNumber=" ";
        locate=panelKey.buttonsEngineer.b6.getLocationOnScreen();
            bot.mouseMove(locate.x+10,locate.y+10);
            bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
            bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
            try{Thread.sleep(50);}catch(InterruptedException e){}
        assertEquals(6, panelKey.buttonsEngineer.dNumber, 0.000000001);

        locate=panelKey.buttonsEngineer.b7.getLocationOnScreen();
            bot.mouseMove(locate.x+10,locate.y+10);
            bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
            bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
            try{Thread.sleep(50);}catch(InterruptedException e){}
        assertEquals(67, panelKey.buttonsEngineer.dNumber, 0.000000001);

        locate=panelKey.buttonsEngineer.b8.getLocationOnScreen();
            bot.mouseMove(locate.x+10,locate.y+10);
            bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
            bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
            try{Thread.sleep(50);}catch(InterruptedException e){}
        assertEquals(678, panelKey.buttonsEngineer.dNumber, 0.000000001);

        locate=panelKey.buttonsEngineer.b9.getLocationOnScreen();
            bot.mouseMove(locate.x+10,locate.y+10);
            bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
            bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
            try{Thread.sleep(50);}catch(InterruptedException e){}
        assertEquals(6789, panelKey.buttonsEngineer.dNumber, 0.000000001);

        panelKey.buttonsEngineer.strNumber=" ";
        locate=panelKey.buttonsEngineer.b0.getLocationOnScreen();
            bot.mouseMove(locate.x+10,locate.y+10);
            bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
            bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
            try{Thread.sleep(50);}catch(InterruptedException e){}
        assertEquals(0, panelKey.buttonsEngineer.dNumber, 0.000000001);

        locate=panelKey.buttonsEngineer.bResult.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        try{Thread.sleep(50);}catch(InterruptedException e){}
        locate=panelKey.buttonsEngineer.bPoint.getLocationOnScreen();
            bot.mouseMove(locate.x+10,locate.y+10);
            bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
            bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
            try{Thread.sleep(50);}catch(InterruptedException e){}
        assertEquals(0.0, panelKey.buttonsEngineer.dNumber, 0.000000001);
    }

    @Test
    void doSums()  {
        locate=panelKey.buttonsEngineer.b2.getLocationOnScreen();
            bot.mouseMove(locate.x+10,locate.y+10);
            bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
            bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
            try{Thread.sleep(50);}catch(InterruptedException e){}

        System.out.println(panelKey.buttonsEngineer.strInput);

        locate=panelKey.buttonsEngineer.bMinus.getLocationOnScreen();
            bot.mouseMove(locate.x+10,locate.y+10);
            bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
            bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
            try{Thread.sleep(50);}catch(InterruptedException e){}
        System.out.println(panelKey.buttonsEngineer.strInput);
        locate=panelKey.buttonsEngineer.bPlus.getLocationOnScreen();
            bot.mouseMove(locate.x+10,locate.y+10);
            bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
            bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
            try{Thread.sleep(50);}catch(InterruptedException e){}
        System.out.println(panelKey.buttonsEngineer.strInput);
        locate=panelKey.buttonsEngineer.b5.getLocationOnScreen();
            bot.mouseMove(locate.x+10,locate.y+10);
            bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
            bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
            try{Thread.sleep(50);}catch(InterruptedException e){}

        System.out.println(panelKey.buttonsEngineer.strInput);
        assertEquals("2+5", panelKey.buttonsEngineer.strInput);
    }
}