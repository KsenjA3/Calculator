package org.example.face;

import lombok.SneakyThrows;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import javax.swing.*;
import java.awt.*;
import java.awt.event.InputEvent;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class ButtonsITTest {

    Point locate;
    JTextPane txt;
    JLabel label;
    JFrame frame;
    PanelKeyIT panelKey;
    Robot bot;

    @Mock
    PanelTextLog textPanel;



    @AfterEach
    void hideFrame() {
        frame.setVisible(false);
    }
    @BeforeEach
    void init() throws AWTException {

        MockitoAnnotations.openMocks(this);
        frame = new JFrame();
        frame.setSize(new Dimension(460, 260));
        panelKey =new PanelKeyIT(textPanel);

        frame.add(panelKey.getKeyPanel());
        frame.setVisible(true);

        bot = new Robot();
        txt =new JTextPane();
        label= new JLabel();
        label.setText("22");

        panelKey.buttonsIT.unblockedAll(panelKey.buttonsIT.bPlus, panelKey.buttonsIT.bMinus, panelKey.buttonsIT.bDivide, panelKey.buttonsIT.bMultiply,
                panelKey.buttonsIT.bPercent, panelKey.buttonsIT.bRadical, panelKey.buttonsIT.bResult, panelKey.buttonsIT.bMemoryAdd,panelKey.buttonsIT.bPoint,
                panelKey.buttonsIT.b0,panelKey.buttonsIT.b1,panelKey.buttonsIT.b2,panelKey.buttonsIT.b3,panelKey.buttonsIT.b4,panelKey.buttonsIT.b5,
                panelKey.buttonsIT.b6,panelKey.buttonsIT.b7,panelKey.buttonsIT.b8,panelKey.buttonsIT.b9,panelKey.buttonsIT.bA,panelKey.buttonsIT.bB,
                panelKey.buttonsIT.bC,panelKey.buttonsIT.bD,panelKey.buttonsIT.bE,panelKey.buttonsIT.bF,panelKey.buttonsIT.braceOpen,panelKey.buttonsIT.braceClose);

        Mockito.doNothing().when(textPanel).setSbLog(Mockito.any());
        Mockito.doNothing().when(textPanel).setTextInput(Mockito.any());
        Mockito.doNothing().when(textPanel).setTextResult(Mockito.any());

        Mockito.when(textPanel.getSbLog()).thenReturn(new StringBuffer(" "));
        Mockito.when(textPanel.getTextInput()).thenReturn(txt);
        Mockito.when(textPanel.getTextResult()).thenReturn(label);


    }

    @Test //0F(0C
    @SneakyThrows(InterruptedException.class)
    void null_after_OpenBrace() {
        locate = panelKey.buttonsIT.b0.getLocationOnScreen();
        bot.mouseMove(locate.x + 10, locate.y + 10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(30);

        txt.setText(panelKey.buttonsIT.strInput);
        locate = panelKey.buttonsIT.bF.getLocationOnScreen();
        bot.mouseMove(locate.x + 10, locate.y + 10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(30);

        txt.setText(panelKey.buttonsIT.strInput);
        locate = panelKey.buttonsIT.braceOpen.getLocationOnScreen();
        bot.mouseMove(locate.x + 10, locate.y + 10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(30);


        txt.setText(panelKey.buttonsIT.strInput);
        locate = panelKey.buttonsIT.b0.getLocationOnScreen();
        bot.mouseMove(locate.x + 10, locate.y + 10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(30);

        txt.setText(panelKey.buttonsIT.strInput);
        locate = panelKey.buttonsIT.bC.getLocationOnScreen();
        bot.mouseMove(locate.x + 10, locate.y + 10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(30);

        ///0F(0C
        assertEquals("F*(C", panelKey.buttonsIT.strInput.replaceAll(" ", ""));
    }

}
