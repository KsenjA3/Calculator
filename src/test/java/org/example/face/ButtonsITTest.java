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
        label.setText("11");

        panelKey.buttonsIT.unblockedAll(panelKey.buttonsIT.bPlus, panelKey.buttonsIT.bMinus, panelKey.buttonsIT.bDivide, panelKey.buttonsIT.bMultiply,
                panelKey.buttonsIT.bPercent, panelKey.buttonsIT.bRadical, panelKey.buttonsIT.bResult, panelKey.buttonsIT.bMemoryAdd,panelKey.buttonsIT.bPoint,
                panelKey.buttonsIT.b0,panelKey.buttonsIT.b1,panelKey.buttonsIT.b2,panelKey.buttonsIT.b3,panelKey.buttonsIT.b4,panelKey.buttonsIT.b5,
                panelKey.buttonsIT.b6,panelKey.buttonsIT.b7,panelKey.buttonsIT.b8,panelKey.buttonsIT.b9,panelKey.buttonsIT.bA,panelKey.buttonsIT.bB,
                panelKey.buttonsIT.bC,panelKey.buttonsIT.bD,panelKey.buttonsIT.bE,panelKey.buttonsIT.bF,panelKey.buttonsIT.braceOpen,panelKey.buttonsIT.braceClose);

        Mockito.doNothing().when(textPanel).setSbLog(Mockito.any());
        Mockito.doNothing().when(textPanel).setTextInput(Mockito.any(), Mockito.any());
        Mockito.doNothing().when(textPanel).setTextResult(Mockito.any(), Mockito.any());

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

        //0F(0C
        assertEquals("F*(C", panelKey.buttonsIT.strInput.replaceAll(" ", ""));
    }


    @Test
    @SneakyThrows(InterruptedException.class)
    void shift_format_input_numbers() {

        txt.setText("955998 + 200");
        locate = panelKey.bBin.getLocationOnScreen();
        bot.mouseMove(locate.x + 10, locate.y + 10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(30);
        assertEquals("1110 1001 0110 0101 1110 + 1100 1000".replaceAll(" ",""),
                panelKey.getStr().replaceAll(" ",""));

        txt.setText("(0011 0111/0011 1011 1011)");
        locate = panelKey.bDec.getLocationOnScreen();
        bot.mouseMove(locate.x + 10, locate.y + 10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(30);
        assertEquals("(55/ 955)".replaceAll(" ",""),
                panelKey.getStr().replaceAll(" ",""));

        txt.setText("955+(55-√200");
        locate = panelKey.bHex.getLocationOnScreen();
        bot.mouseMove(locate.x + 10, locate.y + 10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(30);
        assertEquals("3BB+(37-√C8".replaceAll(" ",""),
                panelKey.getStr().replaceAll(" ",""));

        txt.setText("3BB+(37- C8)+  E965E");
        locate = panelKey.bBin.getLocationOnScreen();
        bot.mouseMove(locate.x + 10, locate.y + 10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(30);
        assertEquals("11 1011 1011+(11 0111-1100 1000)+1110 1001 0110 0101 1110".replaceAll(" ",""),
                panelKey.getStr().replaceAll(" ",""));

        txt.setText("11 0111-11 1011 1011%");
        locate = panelKey.bHex.getLocationOnScreen();
        bot.mouseMove(locate.x + 10, locate.y + 10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(30);
        assertEquals("37- 3BB%".replaceAll(" ",""),
                panelKey.getStr().replaceAll(" ",""));

        txt.setText("3BB/(37+E965E)");
        locate = panelKey.bDec.getLocationOnScreen();
        bot.mouseMove(locate.x + 10, locate.y + 10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(30);
        assertEquals("955/(55+955998)".replaceAll(" ",""),
                panelKey.getStr().replaceAll(" ",""));


    }


    @Test //bin √100=10 and hex =2
    @SneakyThrows(InterruptedException.class)
    void shift_during_sgrt() {
        locate = panelKey.bBin.getLocationOnScreen();
        bot.mouseMove(locate.x + 10, locate.y + 10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(30);


        txt.setText(panelKey.buttonsIT.strInput);
        locate = panelKey.buttonsIT.bRadical.getLocationOnScreen();
        bot.mouseMove(locate.x + 10, locate.y + 10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(30);

        txt.setText(panelKey.buttonsIT.strInput);
        locate = panelKey.buttonsIT.b1.getLocationOnScreen();
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
        locate = panelKey.buttonsIT.b0.getLocationOnScreen();
        bot.mouseMove(locate.x + 10, locate.y + 10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(30);

//bin √100=10
        assertEquals("√100", panelKey.buttonsIT.strInput.replaceAll(" ", ""));
        assertEquals("=10", panelKey.buttonsIT.strResult);

// hex =2
        txt.setText(panelKey.buttonsIT.strInput);
        locate = panelKey.bHex.getLocationOnScreen();
        bot.mouseMove(locate.x + 10, locate.y + 10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(30);

        assertEquals("√4".replaceAll(" ",""),panelKey.getStr().replaceAll(" ",""));
    }

    @Test //021-&*|+9151 = 01+11
    @SneakyThrows(InterruptedException.class)
    void signs_OneByOne() {
        locate = panelKey.bBin.getLocationOnScreen();
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
        locate = panelKey.buttonsIT.b2.getLocationOnScreen();
        bot.mouseMove(locate.x + 10, locate.y + 10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(30);


        txt.setText(panelKey.buttonsIT.strInput);
        locate = panelKey.buttonsIT.b1.getLocationOnScreen();
        bot.mouseMove(locate.x + 10, locate.y + 10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(30);

        txt.setText(panelKey.buttonsIT.strInput);
        locate = panelKey.buttonsIT.bMinus.getLocationOnScreen();
        bot.mouseMove(locate.x + 10, locate.y + 10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(30);

        txt.setText(panelKey.buttonsIT.strInput);
        locate = panelKey.buttonsIT.bAnd.getLocationOnScreen();
        bot.mouseMove(locate.x + 10, locate.y + 10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(30);

        txt.setText(panelKey.buttonsIT.strInput);
        locate = panelKey.buttonsIT.bMultiply.getLocationOnScreen();
        bot.mouseMove(locate.x + 10, locate.y + 10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(30);

        txt.setText(panelKey.buttonsIT.strInput);
        locate = panelKey.buttonsIT.bOr.getLocationOnScreen();
        bot.mouseMove(locate.x + 10, locate.y + 10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(30);

        txt.setText(panelKey.buttonsIT.strInput);
        locate = panelKey.buttonsIT.bPlus.getLocationOnScreen();
        bot.mouseMove(locate.x + 10, locate.y + 10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(30);

        txt.setText(panelKey.buttonsIT.strInput);
        locate = panelKey.buttonsIT.b9.getLocationOnScreen();
        bot.mouseMove(locate.x + 10, locate.y + 10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(30);

        txt.setText(panelKey.buttonsIT.strInput);
        locate = panelKey.buttonsIT.b1.getLocationOnScreen();
        bot.mouseMove(locate.x + 10, locate.y + 10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(30);

        txt.setText(panelKey.buttonsIT.strInput);
        locate = panelKey.buttonsIT.b5.getLocationOnScreen();
        bot.mouseMove(locate.x + 10, locate.y + 10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(30);

        txt.setText(panelKey.buttonsIT.strInput);
        locate = panelKey.buttonsIT.b1.getLocationOnScreen();
        bot.mouseMove(locate.x + 10, locate.y + 10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(30);

// 021-&*|+9151 = 1+11
        assertEquals("1+11", panelKey.buttonsIT.strInput.replaceAll(" ", ""));
    }


    @Test// 01-|+√100 = 01+√100
    @SneakyThrows(InterruptedException.class)
    void radical_used() {
        locate = panelKey.bBin.getLocationOnScreen();
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
        locate = panelKey.buttonsIT.b1.getLocationOnScreen();
        bot.mouseMove(locate.x + 10, locate.y + 10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(30);


        txt.setText(panelKey.buttonsIT.strInput);
        locate = panelKey.buttonsIT.bMinus.getLocationOnScreen();
        bot.mouseMove(locate.x + 10, locate.y + 10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(30);

        txt.setText(panelKey.buttonsIT.strInput);
        locate = panelKey.buttonsIT.bOr.getLocationOnScreen();
        bot.mouseMove(locate.x + 10, locate.y + 10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(30);

        txt.setText(panelKey.buttonsIT.strInput);
        locate = panelKey.buttonsIT.bPlus.getLocationOnScreen();
        bot.mouseMove(locate.x + 10, locate.y + 10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(30);

        txt.setText(panelKey.buttonsIT.strInput);
        locate = panelKey.buttonsIT.bRadical.getLocationOnScreen();
        bot.mouseMove(locate.x + 10, locate.y + 10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(30);

        txt.setText(panelKey.buttonsIT.strInput);
        locate = panelKey.buttonsIT.b1.getLocationOnScreen();
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
        locate = panelKey.buttonsIT.b0.getLocationOnScreen();
        bot.mouseMove(locate.x + 10, locate.y + 10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(30);

// 01-|+√100 = 01+√100
        assertEquals("1+√100", panelKey.buttonsIT.strInput.replaceAll(" ", ""));
    }


    @Test// 01-|√+100 = 01+100
    @SneakyThrows(InterruptedException.class)
    void radical_not_used() {
        locate = panelKey.bBin.getLocationOnScreen();
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
        locate = panelKey.buttonsIT.b1.getLocationOnScreen();
        bot.mouseMove(locate.x + 10, locate.y + 10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(30);


        txt.setText(panelKey.buttonsIT.strInput);
        locate = panelKey.buttonsIT.bMinus.getLocationOnScreen();
        bot.mouseMove(locate.x + 10, locate.y + 10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(30);

        txt.setText(panelKey.buttonsIT.strInput);
        locate = panelKey.buttonsIT.bOr.getLocationOnScreen();
        bot.mouseMove(locate.x + 10, locate.y + 10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(30);

        txt.setText(panelKey.buttonsIT.strInput);
        locate = panelKey.buttonsIT.bRadical.getLocationOnScreen();
        bot.mouseMove(locate.x + 10, locate.y + 10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(30);

        txt.setText(panelKey.buttonsIT.strInput);
        locate = panelKey.buttonsIT.bPlus.getLocationOnScreen();
        bot.mouseMove(locate.x + 10, locate.y + 10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(30);

        txt.setText(panelKey.buttonsIT.strInput);
        locate = panelKey.buttonsIT.b1.getLocationOnScreen();
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
        locate = panelKey.buttonsIT.b0.getLocationOnScreen();
        bot.mouseMove(locate.x + 10, locate.y + 10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(30);

// 01-|√+100 = 01+100
        assertEquals("1+100", panelKey.buttonsIT.strInput.replaceAll(" ", ""));
    }

    @Test// 5√&4 = 5&4
    @SneakyThrows(InterruptedException.class)
    void radical_not_used2() {
        locate = panelKey.bDec.getLocationOnScreen();
        bot.mouseMove(locate.x + 10, locate.y + 10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(30);


        txt.setText(panelKey.buttonsIT.strInput);
        locate = panelKey.buttonsIT.b5.getLocationOnScreen();
        bot.mouseMove(locate.x + 10, locate.y + 10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(30);

        txt.setText(panelKey.buttonsIT.strInput);
        locate = panelKey.buttonsIT.bRadical.getLocationOnScreen();
        bot.mouseMove(locate.x + 10, locate.y + 10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(30);


        txt.setText(panelKey.buttonsIT.strInput);
        locate = panelKey.buttonsIT.bAnd.getLocationOnScreen();
        bot.mouseMove(locate.x + 10, locate.y + 10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(30);

        txt.setText(panelKey.buttonsIT.strInput);
        locate = panelKey.buttonsIT.b4.getLocationOnScreen();
        bot.mouseMove(locate.x + 10, locate.y + 10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(30);


//        5√&4 = 5&4
        assertEquals("5&4", panelKey.buttonsIT.strInput.replaceAll(" ", ""));
    }

    @Test// 5&√4 = 5&4
    @SneakyThrows(InterruptedException.class)
    void radical_not_used3() {
        locate = panelKey.bDec.getLocationOnScreen();
        bot.mouseMove(locate.x + 10, locate.y + 10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(30);


        txt.setText(panelKey.buttonsIT.strInput);
        locate = panelKey.buttonsIT.b5.getLocationOnScreen();
        bot.mouseMove(locate.x + 10, locate.y + 10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(30);

        txt.setText(panelKey.buttonsIT.strInput);
        locate = panelKey.buttonsIT.bAnd.getLocationOnScreen();
        bot.mouseMove(locate.x + 10, locate.y + 10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(30);

        txt.setText(panelKey.buttonsIT.strInput);
        locate = panelKey.buttonsIT.bRadical.getLocationOnScreen();
        bot.mouseMove(locate.x + 10, locate.y + 10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(30);


        txt.setText(panelKey.buttonsIT.strInput);
        locate = panelKey.buttonsIT.b4.getLocationOnScreen();
        bot.mouseMove(locate.x + 10, locate.y + 10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(30);


//        5&√4 = 5&4
        assertEquals("5&4", panelKey.buttonsIT.strInput.replaceAll(" ", ""));
    }

    @Test// 100 % & 3 = 1 & 3
    @SneakyThrows(InterruptedException.class)
    void persent_used1() {
        locate = panelKey.bDec.getLocationOnScreen();
        bot.mouseMove(locate.x + 10, locate.y + 10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(30);


        txt.setText(panelKey.buttonsIT.strInput);
        locate = panelKey.buttonsIT.b1.getLocationOnScreen();
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
        locate = panelKey.buttonsIT.b0.getLocationOnScreen();
        bot.mouseMove(locate.x + 10, locate.y + 10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(30);

        txt.setText(panelKey.buttonsIT.strInput);
        locate = panelKey.buttonsIT.bPercent.getLocationOnScreen();
        bot.mouseMove(locate.x + 10, locate.y + 10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(30);

        txt.setText(panelKey.buttonsIT.strInput);
        locate = panelKey.buttonsIT.bAnd.getLocationOnScreen();
        bot.mouseMove(locate.x + 10, locate.y + 10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(30);

        txt.setText(panelKey.buttonsIT.strInput);
        locate = panelKey.buttonsIT.b3.getLocationOnScreen();
        bot.mouseMove(locate.x + 10, locate.y + 10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(30);


//   100 % & 3 = 1 & 3
        assertEquals("1&3", panelKey.buttonsIT.strInput.replaceAll(" ", ""));
    }

    @Test// 100 & % = 1%
    @SneakyThrows(InterruptedException.class)
    void persent_used2() {
        locate = panelKey.bDec.getLocationOnScreen();
        bot.mouseMove(locate.x + 10, locate.y + 10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(30);


        txt.setText(panelKey.buttonsIT.strInput);
        locate = panelKey.buttonsIT.b1.getLocationOnScreen();
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
        locate = panelKey.buttonsIT.b0.getLocationOnScreen();
        bot.mouseMove(locate.x + 10, locate.y + 10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(30);

        txt.setText(panelKey.buttonsIT.strInput);
        locate = panelKey.buttonsIT.bAnd.getLocationOnScreen();
        bot.mouseMove(locate.x + 10, locate.y + 10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(30);

        txt.setText(panelKey.buttonsIT.strInput);
        locate = panelKey.buttonsIT.bPercent.getLocationOnScreen();
        bot.mouseMove(locate.x + 10, locate.y + 10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(30);


//        100 & % = 1%
        assertEquals("100%", panelKey.buttonsIT.strInput.replaceAll(" ", ""));
        assertEquals("=1", panelKey.buttonsIT.strResult);
    }



    /**hex tests
     *
     */

    @Test //5+BB=C0
    @SneakyThrows(InterruptedException.class)
    void hex_plus_BB() {
        locate = panelKey.bHex.getLocationOnScreen();
        bot.mouseMove(locate.x + 10, locate.y + 10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(30);


        txt.setText(panelKey.buttonsIT.strInput);
        locate = panelKey.buttonsIT.b5.getLocationOnScreen();
        bot.mouseMove(locate.x + 10, locate.y + 10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(30);

        txt.setText(panelKey.buttonsIT.strInput);
        locate = panelKey.buttonsIT.bPlus.getLocationOnScreen();
        bot.mouseMove(locate.x + 10, locate.y + 10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(30);

        txt.setText(panelKey.buttonsIT.strInput);
        locate = panelKey.buttonsIT.bB.getLocationOnScreen();
        bot.mouseMove(locate.x + 10, locate.y + 10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(30);


        txt.setText(panelKey.buttonsIT.strInput);
        locate = panelKey.buttonsIT.bB.getLocationOnScreen();
        bot.mouseMove(locate.x + 10, locate.y + 10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(30);

//5+BB=C0
        assertEquals("5+BB", panelKey.buttonsIT.strInput.replaceAll(" ", ""));
        assertEquals("=C0", panelKey.buttonsIT.strResult);
    }


    @Test//5+B5=BA
    @SneakyThrows(InterruptedException.class)
    void hex_plus_B5() {
            locate = panelKey.bHex.getLocationOnScreen();
            bot.mouseMove(locate.x + 10, locate.y + 10);
            bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
            bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
            Thread.sleep(30);


        locate = panelKey.buttonsIT.b5.getLocationOnScreen();
        bot.mouseMove(locate.x + 10, locate.y + 10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(30);

        txt.setText(panelKey.buttonsIT.strInput);
        locate = panelKey.buttonsIT.bPlus.getLocationOnScreen();
        bot.mouseMove(locate.x + 10, locate.y + 10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(30);

        txt.setText(panelKey.buttonsIT.strInput);
        locate = panelKey.buttonsIT.bB.getLocationOnScreen();
        bot.mouseMove(locate.x + 10, locate.y + 10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(30);


        txt.setText(panelKey.buttonsIT.strInput);
        locate = panelKey.buttonsIT.b5.getLocationOnScreen();
        bot.mouseMove(locate.x + 10, locate.y + 10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(30);

//5+B5=BA
        assertEquals("5+B5", panelKey.buttonsIT.strInput.replaceAll(" ", ""));
        assertEquals("=BA", panelKey.buttonsIT.strResult);


    }

    @Test //F/03=5
    @SneakyThrows(InterruptedException.class)
    void hex_5_divide_0_3() {
        locate = panelKey.bHex.getLocationOnScreen();
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
        locate = panelKey.buttonsIT.bDivide.getLocationOnScreen();
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
        locate = panelKey.buttonsIT.b3.getLocationOnScreen();
        bot.mouseMove(locate.x + 10, locate.y + 10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(30);


//   F/03=5
        assertEquals("F/3", panelKey.buttonsIT.strInput.replaceAll(" ", ""));
        assertEquals("=5".replaceAll(" ", ""), panelKey.buttonsIT.strResult);
    }

    @Test//5*B=37
    @SneakyThrows(InterruptedException.class)
    void hex_5_multiply_B() {
        locate = panelKey.bHex.getLocationOnScreen();
        bot.mouseMove(locate.x + 10, locate.y + 10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(30);


        locate = panelKey.buttonsIT.b5.getLocationOnScreen();
        bot.mouseMove(locate.x + 10, locate.y + 10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(30);

        txt.setText(panelKey.buttonsIT.strInput);
        locate = panelKey.buttonsIT.bMultiply.getLocationOnScreen();
        bot.mouseMove(locate.x + 10, locate.y + 10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(30);

        txt.setText(panelKey.buttonsIT.strInput);
        locate = panelKey.buttonsIT.bB.getLocationOnScreen();
        bot.mouseMove(locate.x + 10, locate.y + 10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(30);

//5*B=37
        assertEquals("5*B", panelKey.buttonsIT.strInput.replaceAll(" ", ""));
        assertEquals("=37", panelKey.buttonsIT.strResult);
    }

    @Test//BB-8=B3
    @SneakyThrows(InterruptedException.class)
    void hex_BB_minus_8() {
        locate = panelKey.bHex.getLocationOnScreen();
        bot.mouseMove(locate.x + 10, locate.y + 10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(30);

        locate = panelKey.buttonsIT.bB.getLocationOnScreen();
        bot.mouseMove(locate.x + 10, locate.y + 10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(30);

        txt.setText(panelKey.buttonsIT.strInput);
        locate = panelKey.buttonsIT.bB.getLocationOnScreen();
        bot.mouseMove(locate.x + 10, locate.y + 10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(30);

        txt.setText(panelKey.buttonsIT.strInput);
        locate = panelKey.buttonsIT.bMinus.getLocationOnScreen();
        bot.mouseMove(locate.x + 10, locate.y + 10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(30);

        txt.setText(panelKey.buttonsIT.strInput);
        locate = panelKey.buttonsIT.b8.getLocationOnScreen();
        bot.mouseMove(locate.x + 10, locate.y + 10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(30);

//BB-8=B3
        assertEquals("BB-8", panelKey.buttonsIT.strInput.replaceAll(" ", ""));
        assertEquals("=B3", panelKey.buttonsIT.strResult);
    }


    @Test//C8+5%=D2
    @SneakyThrows(InterruptedException.class)
    void hex_C8_plus_5_percent() {
        locate = panelKey.bHex.getLocationOnScreen();
        bot.mouseMove(locate.x + 10, locate.y + 10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(30);

        locate = panelKey.buttonsIT.bC.getLocationOnScreen();
        bot.mouseMove(locate.x + 10, locate.y + 10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(30);

        txt.setText(panelKey.buttonsIT.strInput);
        locate = panelKey.buttonsIT.b8.getLocationOnScreen();
        bot.mouseMove(locate.x + 10, locate.y + 10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(30);

        txt.setText(panelKey.buttonsIT.strInput);
        locate = panelKey.buttonsIT.bPlus.getLocationOnScreen();
        bot.mouseMove(locate.x + 10, locate.y + 10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(30);

        txt.setText(panelKey.buttonsIT.strInput);
        locate = panelKey.buttonsIT.b5.getLocationOnScreen();
        bot.mouseMove(locate.x + 10, locate.y + 10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(30);

        txt.setText(panelKey.buttonsIT.strInput);
        locate = panelKey.buttonsIT.bPercent.getLocationOnScreen();
        bot.mouseMove(locate.x + 10, locate.y + 10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(30);

//C8+5%=D2
        assertEquals("C8+5%", panelKey.buttonsIT.strInput.replaceAll(" ", ""));
        assertEquals("=D2", panelKey.buttonsIT.strResult);
    }

    @Test//√√271=5
    @SneakyThrows(InterruptedException.class)
    void hex_sqrt_sqrt_271() {
        locate = panelKey.bHex.getLocationOnScreen();
        bot.mouseMove(locate.x + 10, locate.y + 10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(30);

        locate = panelKey.buttonsIT.bRadical.getLocationOnScreen();
        bot.mouseMove(locate.x + 10, locate.y + 10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(30);

        txt.setText(panelKey.buttonsIT.strInput);
        locate = panelKey.buttonsIT.bRadical.getLocationOnScreen();
        bot.mouseMove(locate.x + 10, locate.y + 10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(30);

        txt.setText(panelKey.buttonsIT.strInput);
        locate = panelKey.buttonsIT.b2.getLocationOnScreen();
        bot.mouseMove(locate.x + 10, locate.y + 10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(30);

        txt.setText(panelKey.buttonsIT.strInput);
        locate = panelKey.buttonsIT.b7.getLocationOnScreen();
        bot.mouseMove(locate.x + 10, locate.y + 10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(30);

        txt.setText(panelKey.buttonsIT.strInput);
        locate = panelKey.buttonsIT.b1.getLocationOnScreen();
        bot.mouseMove(locate.x + 10, locate.y + 10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(30);

//√√271=5
        assertEquals("√√271", panelKey.buttonsIT.strInput.replaceAll(" ", ""));
        assertEquals("=5", panelKey.buttonsIT.strResult);
    }


    @Test//5-A=FFFFFFFB
    @SneakyThrows(InterruptedException.class)
    void hex_5_minus_A() {
        locate = panelKey.bHex.getLocationOnScreen();
        bot.mouseMove(locate.x + 10, locate.y + 10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(30);

        locate = panelKey.buttonsIT.b5.getLocationOnScreen();
        bot.mouseMove(locate.x + 10, locate.y + 10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(30);

        txt.setText(panelKey.buttonsIT.strInput);
        locate = panelKey.buttonsIT.bMinus.getLocationOnScreen();
        bot.mouseMove(locate.x + 10, locate.y + 10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(30);

        txt.setText(panelKey.buttonsIT.strInput);
        locate = panelKey.buttonsIT.bA.getLocationOnScreen();
        bot.mouseMove(locate.x + 10, locate.y + 10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(30);


//5-A=FFFFFFFB
        assertEquals("5-A", panelKey.buttonsIT.strInput.replaceAll(" ", ""));
        assertEquals("=FFFFFFFB", panelKey.buttonsIT.strResult);
    }

    @Test // D-A/A=C
    @SneakyThrows(InterruptedException.class)
    void hex_5_minus_A_divide_A() {
        locate = panelKey.bHex.getLocationOnScreen();
        bot.mouseMove(locate.x + 10, locate.y + 10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(30);

        locate = panelKey.buttonsIT.bD.getLocationOnScreen();
        bot.mouseMove(locate.x + 10, locate.y + 10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(30);

        txt.setText(panelKey.buttonsIT.strInput);
        locate = panelKey.buttonsIT.bMinus.getLocationOnScreen();
        bot.mouseMove(locate.x + 10, locate.y + 10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(30);

        txt.setText(panelKey.buttonsIT.strInput);
        locate = panelKey.buttonsIT.bA.getLocationOnScreen();
        bot.mouseMove(locate.x + 10, locate.y + 10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(30);

        txt.setText(panelKey.buttonsIT.strInput);
        locate = panelKey.buttonsIT.bDivide.getLocationOnScreen();
        bot.mouseMove(locate.x + 10, locate.y + 10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(30);

        txt.setText(panelKey.buttonsIT.strInput);
        locate = panelKey.buttonsIT.bA.getLocationOnScreen();
        bot.mouseMove(locate.x + 10, locate.y + 10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(30);


// D-A/A=C
        assertEquals("D-A/A", panelKey.buttonsIT.strInput.replaceAll(" ", ""));
        assertEquals("=C", panelKey.buttonsIT.strResult);
    }


    @Test  //  FB9/A=Формат работает только с целыми числами.
    @SneakyThrows(InterruptedException.class)
    void hex_FB9_divide_A() {
        locate = panelKey.bHex.getLocationOnScreen();
        bot.mouseMove(locate.x + 10, locate.y + 10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(30);

        locate = panelKey.buttonsIT.bF.getLocationOnScreen();
        bot.mouseMove(locate.x + 10, locate.y + 10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(30);

        txt.setText(panelKey.buttonsIT.strInput);
        locate = panelKey.buttonsIT.bB.getLocationOnScreen();
        bot.mouseMove(locate.x + 10, locate.y + 10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(30);

        txt.setText(panelKey.buttonsIT.strInput);
        locate = panelKey.buttonsIT.b9.getLocationOnScreen();
        bot.mouseMove(locate.x + 10, locate.y + 10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(30);

        txt.setText(panelKey.buttonsIT.strInput);
        locate = panelKey.buttonsIT.bDivide.getLocationOnScreen();
        bot.mouseMove(locate.x + 10, locate.y + 10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(30);

        txt.setText(panelKey.buttonsIT.strInput);
        locate = panelKey.buttonsIT.bA.getLocationOnScreen();
        bot.mouseMove(locate.x + 10, locate.y + 10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(30);


//  FB9/A1=Формат работает только с целыми числами.
        assertEquals("FB9/A", panelKey.buttonsIT.strInput.replaceAll(" ", ""));
        assertEquals("Формат работает только с целыми числами.", panelKey.buttonsIT.strResult);
    }

    @Test  //  FB9/A1=19
    @SneakyThrows(InterruptedException.class)
    void hex_FB9_divide_A1() {
        locate = panelKey.bHex.getLocationOnScreen();
        bot.mouseMove(locate.x + 10, locate.y + 10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(30);

        locate = panelKey.buttonsIT.bF.getLocationOnScreen();
        bot.mouseMove(locate.x + 10, locate.y + 10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(30);

        txt.setText(panelKey.buttonsIT.strInput);
        locate = panelKey.buttonsIT.bB.getLocationOnScreen();
        bot.mouseMove(locate.x + 10, locate.y + 10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(30);

        txt.setText(panelKey.buttonsIT.strInput);
        locate = panelKey.buttonsIT.b9.getLocationOnScreen();
        bot.mouseMove(locate.x + 10, locate.y + 10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(30);

        txt.setText(panelKey.buttonsIT.strInput);
        locate = panelKey.buttonsIT.bDivide.getLocationOnScreen();
        bot.mouseMove(locate.x + 10, locate.y + 10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(30);

        txt.setText(panelKey.buttonsIT.strInput);
        locate = panelKey.buttonsIT.bA.getLocationOnScreen();
        bot.mouseMove(locate.x + 10, locate.y + 10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(30);

        txt.setText(panelKey.buttonsIT.strInput);
        locate = panelKey.buttonsIT.b1.getLocationOnScreen();
        bot.mouseMove(locate.x + 10, locate.y + 10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(30);


//  FB9/A1=19
        assertEquals("FB9/A1", panelKey.buttonsIT.strInput.replaceAll(" ", ""));
        assertEquals("=19", panelKey.buttonsIT.strResult);
    }




    /**binary tests
     *
     */

    @Test //11 +10=101
    @SneakyThrows(InterruptedException.class)
    void binary_plus() {
        locate = panelKey.bBin.getLocationOnScreen();
        bot.mouseMove(locate.x + 10, locate.y + 10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(30);


        txt.setText(panelKey.buttonsIT.strInput);
        locate = panelKey.buttonsIT.b1.getLocationOnScreen();
        bot.mouseMove(locate.x + 10, locate.y + 10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(30);

        txt.setText(panelKey.buttonsIT.strInput);
        locate = panelKey.buttonsIT.b1.getLocationOnScreen();
        bot.mouseMove(locate.x + 10, locate.y + 10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(30);

        txt.setText(panelKey.buttonsIT.strInput);
        locate = panelKey.buttonsIT.bPlus.getLocationOnScreen();
        bot.mouseMove(locate.x + 10, locate.y + 10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(30);

        txt.setText(panelKey.buttonsIT.strInput);
        locate = panelKey.buttonsIT.b1.getLocationOnScreen();
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

//11 +10=101
        assertEquals("11+10", panelKey.buttonsIT.strInput.replaceAll(" ", ""));
        assertEquals("=101", panelKey.buttonsIT.strResult);
    }


    @Test //1100/11=100
    @SneakyThrows(InterruptedException.class)
    void binary_divide() {
        locate = panelKey.bBin.getLocationOnScreen();
        bot.mouseMove(locate.x + 10, locate.y + 10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(30);


        txt.setText(panelKey.buttonsIT.strInput);
        locate = panelKey.buttonsIT.b1.getLocationOnScreen();
        bot.mouseMove(locate.x + 10, locate.y + 10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(30);

        txt.setText(panelKey.buttonsIT.strInput);
        locate = panelKey.buttonsIT.b1.getLocationOnScreen();
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
        locate = panelKey.buttonsIT.b0.getLocationOnScreen();
        bot.mouseMove(locate.x + 10, locate.y + 10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(30);

        txt.setText(panelKey.buttonsIT.strInput);
        locate = panelKey.buttonsIT.bDivide.getLocationOnScreen();
        bot.mouseMove(locate.x + 10, locate.y + 10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(30);

        txt.setText(panelKey.buttonsIT.strInput);
        locate = panelKey.buttonsIT.b1.getLocationOnScreen();
        bot.mouseMove(locate.x + 10, locate.y + 10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(30);

        txt.setText(panelKey.buttonsIT.strInput);
        locate = panelKey.buttonsIT.b1.getLocationOnScreen();
        bot.mouseMove(locate.x + 10, locate.y + 10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(30);


//   1100/11=100
        assertEquals("1100/11", panelKey.buttonsIT.strInput.replaceAll(" ", ""));
        assertEquals("=100", panelKey.buttonsIT.strResult);
    }

    @Test//11*10=110
    @SneakyThrows(InterruptedException.class)
    void binary_multiply() {
        locate = panelKey.bBin.getLocationOnScreen();
        bot.mouseMove(locate.x + 10, locate.y + 10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(30);


        txt.setText(panelKey.buttonsIT.strInput);
        locate = panelKey.buttonsIT.b1.getLocationOnScreen();
        bot.mouseMove(locate.x + 10, locate.y + 10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(30);

        txt.setText(panelKey.buttonsIT.strInput);
        locate = panelKey.buttonsIT.b1.getLocationOnScreen();
        bot.mouseMove(locate.x + 10, locate.y + 10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(30);

        txt.setText(panelKey.buttonsIT.strInput);
        locate = panelKey.buttonsIT.bMultiply.getLocationOnScreen();
        bot.mouseMove(locate.x + 10, locate.y + 10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(30);

        txt.setText(panelKey.buttonsIT.strInput);
        locate = panelKey.buttonsIT.b1.getLocationOnScreen();
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

//11*10=110
        assertEquals("11*10", panelKey.buttonsIT.strInput.replaceAll(" ", ""));
        assertEquals("=110", panelKey.buttonsIT.strResult);
    }

    @Test//1111-110=1001
    @SneakyThrows(InterruptedException.class)
    void binary_minus() {
        locate = panelKey.bBin.getLocationOnScreen();
        bot.mouseMove(locate.x + 10, locate.y + 10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(30);


        txt.setText(panelKey.buttonsIT.strInput);
        locate = panelKey.buttonsIT.b1.getLocationOnScreen();
        bot.mouseMove(locate.x + 10, locate.y + 10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(30);

        txt.setText(panelKey.buttonsIT.strInput);
        locate = panelKey.buttonsIT.b1.getLocationOnScreen();
        bot.mouseMove(locate.x + 10, locate.y + 10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(30);

        txt.setText(panelKey.buttonsIT.strInput);
        locate = panelKey.buttonsIT.b1.getLocationOnScreen();
        bot.mouseMove(locate.x + 10, locate.y + 10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(30);

        txt.setText(panelKey.buttonsIT.strInput);
        locate = panelKey.buttonsIT.b1.getLocationOnScreen();
        bot.mouseMove(locate.x + 10, locate.y + 10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(30);

        txt.setText(panelKey.buttonsIT.strInput);
        locate = panelKey.buttonsIT.bMinus.getLocationOnScreen();
        bot.mouseMove(locate.x + 10, locate.y + 10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(30);

        txt.setText(panelKey.buttonsIT.strInput);
        locate = panelKey.buttonsIT.b1.getLocationOnScreen();
        bot.mouseMove(locate.x + 10, locate.y + 10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(30);

        txt.setText(panelKey.buttonsIT.strInput);
        locate = panelKey.buttonsIT.b1.getLocationOnScreen();
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

//1111-110=1001
        assertEquals("1111-110", panelKey.buttonsIT.strInput.replaceAll(" ", ""));
        assertEquals("=1001", panelKey.buttonsIT.strResult);
    }


    @Test//1100 1000 + 101%= 1101 0010
    @SneakyThrows(InterruptedException.class)
    void binary_percent() {
        locate = panelKey.bBin.getLocationOnScreen();
        bot.mouseMove(locate.x + 10, locate.y + 10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(30);


        txt.setText(panelKey.buttonsIT.strInput);
        locate = panelKey.buttonsIT.b1.getLocationOnScreen();
        bot.mouseMove(locate.x + 10, locate.y + 10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(30);

        txt.setText(panelKey.buttonsIT.strInput);
        locate = panelKey.buttonsIT.b1.getLocationOnScreen();
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
        locate = panelKey.buttonsIT.b0.getLocationOnScreen();
        bot.mouseMove(locate.x + 10, locate.y + 10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(30);

        txt.setText(panelKey.buttonsIT.strInput);
        locate = panelKey.buttonsIT.b1.getLocationOnScreen();
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
        locate = panelKey.buttonsIT.b0.getLocationOnScreen();
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
        locate = panelKey.buttonsIT.bPlus.getLocationOnScreen();
        bot.mouseMove(locate.x + 10, locate.y + 10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(30);

        txt.setText(panelKey.buttonsIT.strInput);
        locate = panelKey.buttonsIT.b1.getLocationOnScreen();
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
        locate = panelKey.buttonsIT.b1.getLocationOnScreen();
        bot.mouseMove(locate.x + 10, locate.y + 10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(30);

        txt.setText(panelKey.buttonsIT.strInput);
        locate = panelKey.buttonsIT.bPercent.getLocationOnScreen();
        bot.mouseMove(locate.x + 10, locate.y + 10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(30);

//1100 1000 + 101%= 1101 0010
        assertEquals("11001000+101%", panelKey.buttonsIT.strInput.replaceAll(" ", ""));
        assertEquals("=11010010", panelKey.buttonsIT.strResult);
    }

    @Test//√√0101 0001=11
    @SneakyThrows(InterruptedException.class)
    void binary_sqrt_sqrt() {
        locate = panelKey.bBin.getLocationOnScreen();
        bot.mouseMove(locate.x + 10, locate.y + 10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(30);

        locate = panelKey.buttonsIT.bRadical.getLocationOnScreen();
        bot.mouseMove(locate.x + 10, locate.y + 10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(30);

        txt.setText(panelKey.buttonsIT.strInput);
        locate = panelKey.buttonsIT.bRadical.getLocationOnScreen();
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
        locate = panelKey.buttonsIT.b1.getLocationOnScreen();
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
        locate = panelKey.buttonsIT.b1.getLocationOnScreen();
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
        locate = panelKey.buttonsIT.b0.getLocationOnScreen();
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
        locate = panelKey.buttonsIT.b1.getLocationOnScreen();
        bot.mouseMove(locate.x + 10, locate.y + 10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(30);

//√√0101 0001=11
        assertEquals("√√01010001", panelKey.buttonsIT.strInput.replaceAll(" ", ""));
        assertEquals("=11", panelKey.buttonsIT.strResult);
    }

    @Test//10-11=11111111111111111111111111111111
    @SneakyThrows(InterruptedException.class)
    void binary_minus_result() {
        locate = panelKey.bBin.getLocationOnScreen();
        bot.mouseMove(locate.x + 10, locate.y + 10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(30);

        locate = panelKey.buttonsIT.b1.getLocationOnScreen();
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
        locate = panelKey.buttonsIT.bMinus.getLocationOnScreen();
        bot.mouseMove(locate.x + 10, locate.y + 10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(30);

        txt.setText(panelKey.buttonsIT.strInput);
        locate = panelKey.buttonsIT.b1.getLocationOnScreen();
        bot.mouseMove(locate.x + 10, locate.y + 10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(30);

        txt.setText(panelKey.buttonsIT.strInput);
        locate = panelKey.buttonsIT.b1.getLocationOnScreen();
        bot.mouseMove(locate.x + 10, locate.y + 10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(30);


//10-11=11111111111111111111111111111111
        assertEquals("10-11", panelKey.buttonsIT.strInput.replaceAll(" ", ""));
        assertEquals("=11111111111111111111111111111111", panelKey.buttonsIT.strResult);
    }

    @Test  //  10/11=Формат работает только с целыми числами.
    @SneakyThrows(InterruptedException.class)
    void binary_exception_divide() {
        locate = panelKey.bBin.getLocationOnScreen();
        bot.mouseMove(locate.x + 10, locate.y + 10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(30);

        locate = panelKey.buttonsIT.b1.getLocationOnScreen();
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
        locate = panelKey.buttonsIT.bDivide.getLocationOnScreen();
        bot.mouseMove(locate.x + 10, locate.y + 10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(30);

        txt.setText(panelKey.buttonsIT.strInput);
        locate = panelKey.buttonsIT.b1.getLocationOnScreen();
        bot.mouseMove(locate.x + 10, locate.y + 10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(30);

        txt.setText(panelKey.buttonsIT.strInput);
        locate = panelKey.buttonsIT.b1.getLocationOnScreen();
        bot.mouseMove(locate.x + 10, locate.y + 10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(30);

//  10/11=Формат работает только с целыми числами.
        assertEquals("10/11", panelKey.buttonsIT.strInput.replaceAll(" ", ""));
        assertEquals("Формат работает только с целыми числами.", panelKey.buttonsIT.strResult);
    }

    @Test  //  101 -1001 /11 =10
    @SneakyThrows(InterruptedException.class)
    void binary_NO_exception_minus() {
        locate = panelKey.bBin.getLocationOnScreen();
        bot.mouseMove(locate.x + 10, locate.y + 10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(30);

        locate = panelKey.buttonsIT.b1.getLocationOnScreen();
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
        locate = panelKey.buttonsIT.b1.getLocationOnScreen();
        bot.mouseMove(locate.x + 10, locate.y + 10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(30);

        txt.setText(panelKey.buttonsIT.strInput);
        locate = panelKey.buttonsIT.bMinus.getLocationOnScreen();
        bot.mouseMove(locate.x + 10, locate.y + 10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(30);

        txt.setText(panelKey.buttonsIT.strInput);
        locate = panelKey.buttonsIT.b1.getLocationOnScreen();
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
        locate = panelKey.buttonsIT.b0.getLocationOnScreen();
        bot.mouseMove(locate.x + 10, locate.y + 10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(30);

        txt.setText(panelKey.buttonsIT.strInput);
        locate = panelKey.buttonsIT.b1.getLocationOnScreen();
        bot.mouseMove(locate.x + 10, locate.y + 10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(30);

        txt.setText(panelKey.buttonsIT.strInput);
        locate = panelKey.buttonsIT.bDivide.getLocationOnScreen();
        bot.mouseMove(locate.x + 10, locate.y + 10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(30);

        txt.setText(panelKey.buttonsIT.strInput);
        locate = panelKey.buttonsIT.b1.getLocationOnScreen();
        bot.mouseMove(locate.x + 10, locate.y + 10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(30);

        txt.setText(panelKey.buttonsIT.strInput);
        locate = panelKey.buttonsIT.b1.getLocationOnScreen();
        bot.mouseMove(locate.x + 10, locate.y + 10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(30);


//  101 -1001 /11 =10
//        assertEquals("101-1001/11", panelKey.buttonsIT.strInput.replaceAll(" ", ""));
        assertEquals("=10", panelKey.buttonsIT.strResult);
    }

/**Or_Xor_And_Not
 *
 */

    @Test  //  27 Xor 4D = 6A
    @SneakyThrows(InterruptedException.class)
    void hex_Xor () {
    locate = panelKey.bHex.getLocationOnScreen();
    bot.mouseMove(locate.x + 10, locate.y + 10);
    bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
    bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
    Thread.sleep(30);

    locate = panelKey.buttonsIT.b2.getLocationOnScreen();
    bot.mouseMove(locate.x + 10, locate.y + 10);
    bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
    bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
    Thread.sleep(30);

    txt.setText(panelKey.buttonsIT.strInput);
    locate = panelKey.buttonsIT.b7.getLocationOnScreen();
    bot.mouseMove(locate.x + 10, locate.y + 10);
    bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
    bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
    Thread.sleep(30);

    txt.setText(panelKey.buttonsIT.strInput);
    locate = panelKey.buttonsIT.bXor.getLocationOnScreen();
    bot.mouseMove(locate.x + 10, locate.y + 10);
    bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
    bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
    Thread.sleep(30);

    txt.setText(panelKey.buttonsIT.strInput);
    locate = panelKey.buttonsIT.b4.getLocationOnScreen();
    bot.mouseMove(locate.x + 10, locate.y + 10);
    bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
    bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
    Thread.sleep(30);

    txt.setText(panelKey.buttonsIT.strInput);
    locate = panelKey.buttonsIT.bD.getLocationOnScreen();
    bot.mouseMove(locate.x + 10, locate.y + 10);
    bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
    bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
    Thread.sleep(30);

//  //  27 Xor 4D = 6A
    assertEquals("27Xor4D", panelKey.buttonsIT.strInput.replaceAll(" ", ""));
    assertEquals("=6A", panelKey.buttonsIT.strResult);
}

    @Test  //  39 Xor 77 = 106
    @SneakyThrows(InterruptedException.class)
    void dec_Xor () {
        locate = panelKey.bDec.getLocationOnScreen();
        bot.mouseMove(locate.x + 10, locate.y + 10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(30);

        locate = panelKey.buttonsIT.b3.getLocationOnScreen();
        bot.mouseMove(locate.x + 10, locate.y + 10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(30);

        txt.setText(panelKey.buttonsIT.strInput);
        locate = panelKey.buttonsIT.b9.getLocationOnScreen();
        bot.mouseMove(locate.x + 10, locate.y + 10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(30);

        txt.setText(panelKey.buttonsIT.strInput);
        locate = panelKey.buttonsIT.bXor.getLocationOnScreen();
        bot.mouseMove(locate.x + 10, locate.y + 10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(30);

        txt.setText(panelKey.buttonsIT.strInput);
        locate = panelKey.buttonsIT.b7.getLocationOnScreen();
        bot.mouseMove(locate.x + 10, locate.y + 10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(30);

        txt.setText(panelKey.buttonsIT.strInput);
        locate = panelKey.buttonsIT.b7.getLocationOnScreen();
        bot.mouseMove(locate.x + 10, locate.y + 10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(30);

//    39 Xor 77 = 106
        assertEquals("39Xor77", panelKey.buttonsIT.strInput.replaceAll(" ", ""));
        assertEquals("=106", panelKey.buttonsIT.strResult);
    }

    @Test  //  110 Xor 101 = 11
    @SneakyThrows(InterruptedException.class)
    void bin_Xor () {
        locate = panelKey.bBin.getLocationOnScreen();
        bot.mouseMove(locate.x + 10, locate.y + 10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(30);

        locate = panelKey.buttonsIT.b1.getLocationOnScreen();
        bot.mouseMove(locate.x + 10, locate.y + 10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(30);

        txt.setText(panelKey.buttonsIT.strInput);
        locate = panelKey.buttonsIT.b1.getLocationOnScreen();
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
        locate = panelKey.buttonsIT.bXor.getLocationOnScreen();
        bot.mouseMove(locate.x + 10, locate.y + 10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(30);

        txt.setText(panelKey.buttonsIT.strInput);
        locate = panelKey.buttonsIT.b1.getLocationOnScreen();
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
        locate = panelKey.buttonsIT.b1.getLocationOnScreen();
        bot.mouseMove(locate.x + 10, locate.y + 10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(30);

//    110 Xor 101 = 11
        assertEquals("110Xor101", panelKey.buttonsIT.strInput.replaceAll(" ", ""));
        assertEquals("=11", panelKey.buttonsIT.strResult);
    }



    @Test  //  27 Or 4D = 6F
    @SneakyThrows(InterruptedException.class)
    void hex_Or () {
        locate = panelKey.bHex.getLocationOnScreen();
        bot.mouseMove(locate.x + 10, locate.y + 10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(30);

        locate = panelKey.buttonsIT.b2.getLocationOnScreen();
        bot.mouseMove(locate.x + 10, locate.y + 10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(30);

        txt.setText(panelKey.buttonsIT.strInput);
        locate = panelKey.buttonsIT.b7.getLocationOnScreen();
        bot.mouseMove(locate.x + 10, locate.y + 10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(30);

        txt.setText(panelKey.buttonsIT.strInput);
        locate = panelKey.buttonsIT.bOr.getLocationOnScreen();
        bot.mouseMove(locate.x + 10, locate.y + 10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(30);

        txt.setText(panelKey.buttonsIT.strInput);
        locate = panelKey.buttonsIT.b4.getLocationOnScreen();
        bot.mouseMove(locate.x + 10, locate.y + 10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(30);

        txt.setText(panelKey.buttonsIT.strInput);
        locate = panelKey.buttonsIT.bD.getLocationOnScreen();
        bot.mouseMove(locate.x + 10, locate.y + 10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(30);

//  //  27 or 4D = 6F
        assertEquals("27|4D", panelKey.buttonsIT.strInput.replaceAll(" ", ""));
        assertEquals("=6F", panelKey.buttonsIT.strResult);
    }

    @Test  //  39 Or 77 = 111
    @SneakyThrows(InterruptedException.class)
    void dec_Or () {
        locate = panelKey.bDec.getLocationOnScreen();
        bot.mouseMove(locate.x + 10, locate.y + 10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(30);

        locate = panelKey.buttonsIT.b3.getLocationOnScreen();
        bot.mouseMove(locate.x + 10, locate.y + 10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(30);

        txt.setText(panelKey.buttonsIT.strInput);
        locate = panelKey.buttonsIT.b9.getLocationOnScreen();
        bot.mouseMove(locate.x + 10, locate.y + 10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(30);

        txt.setText(panelKey.buttonsIT.strInput);
        locate = panelKey.buttonsIT.bOr.getLocationOnScreen();
        bot.mouseMove(locate.x + 10, locate.y + 10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(30);

        txt.setText(panelKey.buttonsIT.strInput);
        locate = panelKey.buttonsIT.b7.getLocationOnScreen();
        bot.mouseMove(locate.x + 10, locate.y + 10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(30);

        txt.setText(panelKey.buttonsIT.strInput);
        locate = panelKey.buttonsIT.b7.getLocationOnScreen();
        bot.mouseMove(locate.x + 10, locate.y + 10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(30);

//    39 or 77 = 111
        assertEquals("39|77", panelKey.buttonsIT.strInput.replaceAll(" ", ""));
        assertEquals("=111", panelKey.buttonsIT.strResult);
    }

    @Test  //  110 Or 101 = 111
    @SneakyThrows(InterruptedException.class)
    void bin_Or () {
        locate = panelKey.bBin.getLocationOnScreen();
        bot.mouseMove(locate.x + 10, locate.y + 10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(30);

        locate = panelKey.buttonsIT.b1.getLocationOnScreen();
        bot.mouseMove(locate.x + 10, locate.y + 10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(30);

        txt.setText(panelKey.buttonsIT.strInput);
        locate = panelKey.buttonsIT.b1.getLocationOnScreen();
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
        locate = panelKey.buttonsIT.bOr.getLocationOnScreen();
        bot.mouseMove(locate.x + 10, locate.y + 10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(30);

        txt.setText(panelKey.buttonsIT.strInput);
        locate = panelKey.buttonsIT.b1.getLocationOnScreen();
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
        locate = panelKey.buttonsIT.b1.getLocationOnScreen();
        bot.mouseMove(locate.x + 10, locate.y + 10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(30);

//    110 or 101 = 111
        assertEquals("110|101", panelKey.buttonsIT.strInput.replaceAll(" ", ""));
        assertEquals("=111", panelKey.buttonsIT.strResult);
    }


    @Test  //  27 And 4D = 5
    @SneakyThrows(InterruptedException.class)
    void hex_And () {
        locate = panelKey.bHex.getLocationOnScreen();
        bot.mouseMove(locate.x + 10, locate.y + 10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(30);

        locate = panelKey.buttonsIT.b2.getLocationOnScreen();
        bot.mouseMove(locate.x + 10, locate.y + 10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(30);

        txt.setText(panelKey.buttonsIT.strInput);
        locate = panelKey.buttonsIT.b7.getLocationOnScreen();
        bot.mouseMove(locate.x + 10, locate.y + 10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(30);

        txt.setText(panelKey.buttonsIT.strInput);
        locate = panelKey.buttonsIT.bAnd.getLocationOnScreen();
        bot.mouseMove(locate.x + 10, locate.y + 10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(30);

        txt.setText(panelKey.buttonsIT.strInput);
        locate = panelKey.buttonsIT.b4.getLocationOnScreen();
        bot.mouseMove(locate.x + 10, locate.y + 10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(30);

        txt.setText(panelKey.buttonsIT.strInput);
        locate = panelKey.buttonsIT.bD.getLocationOnScreen();
        bot.mouseMove(locate.x + 10, locate.y + 10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(30);

//    27 And 4D = 5
        assertEquals("27&4D", panelKey.buttonsIT.strInput.replaceAll(" ", ""));
        assertEquals("=5", panelKey.buttonsIT.strResult);
    }

    @Test  //  39 And 77 = 5
    @SneakyThrows(InterruptedException.class)
    void dec_And () {
        locate = panelKey.bDec.getLocationOnScreen();
        bot.mouseMove(locate.x + 10, locate.y + 10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(30);

        locate = panelKey.buttonsIT.b3.getLocationOnScreen();
        bot.mouseMove(locate.x + 10, locate.y + 10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(30);

        txt.setText(panelKey.buttonsIT.strInput);
        locate = panelKey.buttonsIT.b9.getLocationOnScreen();
        bot.mouseMove(locate.x + 10, locate.y + 10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(30);

        txt.setText(panelKey.buttonsIT.strInput);
        locate = panelKey.buttonsIT.bAnd.getLocationOnScreen();
        bot.mouseMove(locate.x + 10, locate.y + 10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(30);

        txt.setText(panelKey.buttonsIT.strInput);
        locate = panelKey.buttonsIT.b7.getLocationOnScreen();
        bot.mouseMove(locate.x + 10, locate.y + 10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(30);

        txt.setText(panelKey.buttonsIT.strInput);
        locate = panelKey.buttonsIT.b7.getLocationOnScreen();
        bot.mouseMove(locate.x + 10, locate.y + 10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(30);

//    39 And 77 = 5
        assertEquals("39&77", panelKey.buttonsIT.strInput.replaceAll(" ", ""));
        assertEquals("=5", panelKey.buttonsIT.strResult);
    }

    @Test  //  110 And 101 = 100
    @SneakyThrows(InterruptedException.class)
    void bin_And () {
        locate = panelKey.bBin.getLocationOnScreen();
        bot.mouseMove(locate.x + 10, locate.y + 10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(30);

        locate = panelKey.buttonsIT.b1.getLocationOnScreen();
        bot.mouseMove(locate.x + 10, locate.y + 10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(30);

        txt.setText(panelKey.buttonsIT.strInput);
        locate = panelKey.buttonsIT.b1.getLocationOnScreen();
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
        locate = panelKey.buttonsIT.bAnd.getLocationOnScreen();
        bot.mouseMove(locate.x + 10, locate.y + 10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(30);

        txt.setText(panelKey.buttonsIT.strInput);
        locate = panelKey.buttonsIT.b1.getLocationOnScreen();
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
        locate = panelKey.buttonsIT.b1.getLocationOnScreen();
        bot.mouseMove(locate.x + 10, locate.y + 10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(30);

//    110 and 101 = 100
        assertEquals("110&101", panelKey.buttonsIT.strInput.replaceAll(" ", ""));
        assertEquals("=100", panelKey.buttonsIT.strResult);
    }




    @Test  //  100 Not = 1111 1111 1111 1111 1111 1111 1111 1011
    @SneakyThrows(InterruptedException.class)
    void bin_Not1 () {
        locate = panelKey.bBin.getLocationOnScreen();
        bot.mouseMove(locate.x + 10, locate.y + 10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(30);

        locate = panelKey.buttonsIT.b1.getLocationOnScreen();
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
        locate = panelKey.buttonsIT.b0.getLocationOnScreen();
        bot.mouseMove(locate.x + 10, locate.y + 10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(30);

        txt.setText(panelKey.buttonsIT.strInput);
        locate = panelKey.buttonsIT.bNot.getLocationOnScreen();
        bot.mouseMove(locate.x + 10, locate.y + 10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(30);

//    100  Not = 1111 1111 1111 1111 1111 1111 1111 1011
        assertEquals("~(100)", panelKey.buttonsIT.strInput.replaceAll(" ", ""));
        assertEquals("=1111 1111 1111 1111 1111 1111 1111 1011".replaceAll(" ", ""), panelKey.buttonsIT.strResult);
    }

    @Test  //  110 And 101 Not = 1111 1111 1111 1111 1111 1111 1111 1011
    @SneakyThrows(InterruptedException.class)
    void bin_Not () {
        locate = panelKey.bBin.getLocationOnScreen();
        bot.mouseMove(locate.x + 10, locate.y + 10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(30);

        locate = panelKey.buttonsIT.b1.getLocationOnScreen();
        bot.mouseMove(locate.x + 10, locate.y + 10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(30);

        txt.setText(panelKey.buttonsIT.strInput);
        locate = panelKey.buttonsIT.b1.getLocationOnScreen();
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
        locate = panelKey.buttonsIT.bAnd.getLocationOnScreen();
        bot.mouseMove(locate.x + 10, locate.y + 10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(30);

        txt.setText(panelKey.buttonsIT.strInput);
        locate = panelKey.buttonsIT.b1.getLocationOnScreen();
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
        locate = panelKey.buttonsIT.b1.getLocationOnScreen();
        bot.mouseMove(locate.x + 10, locate.y + 10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(30);

        txt.setText(panelKey.buttonsIT.strInput);
        locate = panelKey.buttonsIT.bNot.getLocationOnScreen();
        bot.mouseMove(locate.x + 10, locate.y + 10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(30);

//    110 and 101 Not = 1111 1111 1111 1111 1111 1111 1111 1011
        assertEquals("~(110&101)", panelKey.buttonsIT.strInput.replaceAll(" ", ""));
        assertEquals("=1111 1111 1111 1111 1111 1111 1111 1011".replaceAll(" ", ""), panelKey.buttonsIT.strResult);
    }


    @Test  //  5 Not = -6
    @SneakyThrows(InterruptedException.class)
    void dec_Not () {
        locate = panelKey.bDec.getLocationOnScreen();
        bot.mouseMove(locate.x + 10, locate.y + 10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(30);

        txt.setText(panelKey.buttonsIT.strInput);
        locate = panelKey.buttonsIT.b5.getLocationOnScreen();
        bot.mouseMove(locate.x + 10, locate.y + 10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(30);

        txt.setText(panelKey.buttonsIT.strInput);
        locate = panelKey.buttonsIT.bNot.getLocationOnScreen();
        bot.mouseMove(locate.x + 10, locate.y + 10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(30);

//    5  Not = -6
        assertEquals("~(5)", panelKey.buttonsIT.strInput.replaceAll(" ", ""));
        assertEquals("=-6".replaceAll(" ", ""), panelKey.buttonsIT.strResult);
    }


    @Test  //  C Not = FFFF FFF3
    @SneakyThrows(InterruptedException.class)
    void hex_Not () {
        locate = panelKey.bHex.getLocationOnScreen();
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

        txt.setText(panelKey.buttonsIT.strInput);
        locate = panelKey.buttonsIT.bNot.getLocationOnScreen();
        bot.mouseMove(locate.x + 10, locate.y + 10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(30);

//    C  Not = FFFF FFF3
        assertEquals("~(C)", panelKey.buttonsIT.strInput.replaceAll(" ", ""));
        assertEquals("=FFFF FFF3".replaceAll(" ", ""), panelKey.buttonsIT.strResult);
    }

}





