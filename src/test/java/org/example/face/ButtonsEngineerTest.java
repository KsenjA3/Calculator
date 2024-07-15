package org.example.face;


import lombok.SneakyThrows;
import org.junit.jupiter.api.*;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import javax.swing.*;
import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

import static org.junit.jupiter.api.Assertions.*;


@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class ButtonsEngineerTest {
    Point locate;
    JTextPane txt;
    JLabel label;
    JFrame frame;
    PanelKeyEngineer panelKey;
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
        frame.setSize(new Dimension(500, 300));
        panelKey =new PanelKeyEngineer(textPanel);

        frame.add(panelKey.getKeyPanel());
        frame.setVisible(true);

        bot = new Robot();
        txt =new JTextPane();
        label= new JLabel();
        label.setText("22");

        Mockito.doNothing().when(textPanel).setSbLog(Mockito.any());
        Mockito.doNothing().when(textPanel).setTextInput(Mockito.any());
        Mockito.doNothing().when(textPanel).setTextResult(Mockito.any());

        Mockito.when(textPanel.getSbLog()).thenReturn(new StringBuffer(" "));
        Mockito.when(textPanel.getTextInput()).thenReturn(txt);
        Mockito.when(textPanel.getTextResult()).thenReturn(label);



//        panelKey.buttonsEngineer.strNumber="0";
//        txt.setText("   ");
//        panelKey.buttonsEngineer.countResult="0";
//        panelKey.buttonsEngineer.strResult="0";
//        panelKey.buttonsEngineer.strInput="   ";

        panelKey.buttonsEngineer.unblockedAll(panelKey.buttonsEngineer.b0,panelKey.buttonsEngineer.b1,panelKey.buttonsEngineer.b2,
                panelKey.buttonsEngineer.b3,panelKey.buttonsEngineer.b4,panelKey.buttonsEngineer.b5,panelKey.buttonsEngineer.b6,
                panelKey.buttonsEngineer.b7,panelKey.buttonsEngineer.b8,panelKey.buttonsEngineer.b9,panelKey.buttonsEngineer.bPoint,
                panelKey.buttonsEngineer.bPi,panelKey.buttonsEngineer.bPercent,panelKey.buttonsEngineer.bRadical);

    }



    @Test
    @SneakyThrows(InterruptedException.class)
    void sqrt3_pressFirst( ) {

        locate = panelKey.buttonsEngineer.bSqrt3.getLocationOnScreen();
        bot.mouseMove(locate.x + 10, locate.y + 10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(25);

        txt.setText(panelKey.buttonsEngineer.strInput);
        locate = panelKey.buttonsEngineer.b2.getLocationOnScreen();
        bot.mouseMove(locate.x + 10, locate.y + 10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(25);

        assertEquals("³√(2", panelKey.buttonsEngineer.strInput.replaceAll(" ",""));
    }
     @Test
     @SneakyThrows (InterruptedException.class)
    void sin_pressFirst( ) {
        locate = panelKey.buttonsEngineer.bClear.getLocationOnScreen();
        bot.mouseMove(locate.x + 10, locate.y + 10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(25);

        txt.setText(panelKey.buttonsEngineer.strInput);
        locate = panelKey.buttonsEngineer.bSin.getLocationOnScreen();
        bot.mouseMove(locate.x + 10, locate.y + 10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(25);

        txt.setText(panelKey.buttonsEngineer.strInput);
        locate = panelKey.buttonsEngineer.b2.getLocationOnScreen();
        bot.mouseMove(locate.x + 10, locate.y + 10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(25);

        assertEquals("sin(2", panelKey.buttonsEngineer.strInput.replaceAll(" ",""));
    }

    @Test
    @SneakyThrows (InterruptedException.class)
    void pow2_pressFirst( ) {

        locate = panelKey.buttonsEngineer.bx2.getLocationOnScreen();
        bot.mouseMove(locate.x + 10, locate.y + 10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(25);

        txt.setText(panelKey.buttonsEngineer.strInput);
        locate = panelKey.buttonsEngineer.b2.getLocationOnScreen();
        bot.mouseMove(locate.x + 10, locate.y + 10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(25);

        assertEquals("0²", panelKey.buttonsEngineer.strInput.replaceAll(" ",""));
    }
     @Test
     @SneakyThrows (InterruptedException.class)
    void PI_pressFirst( ) {

        locate = panelKey.buttonsEngineer.bPi.getLocationOnScreen();
        bot.mouseMove(locate.x + 10, locate.y + 10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(25);



        assertEquals("3.141592653589793", panelKey.buttonsEngineer.strInput.replaceAll(" ",""));
    }

    @Test
    @SneakyThrows (InterruptedException.class)
    void xn_pressFirst( ) {
        locate = panelKey.buttonsEngineer.bxn.getLocationOnScreen();
        bot.mouseMove(locate.x + 10, locate.y + 10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(25);

        assertEquals("0^", panelKey.buttonsEngineer.strInput.replaceAll(" ",""));
    }
    @Test
    @SneakyThrows (InterruptedException.class)
    void devX_pressFirst( ) {
        locate = panelKey.buttonsEngineer.bDivX.getLocationOnScreen();
        bot.mouseMove(locate.x + 10, locate.y + 10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(25);

        assertEquals("0^(-1)", panelKey.buttonsEngineer.strInput.replaceAll(" ",""));
        assertEquals("делить на 0 нельзя", panelKey.buttonsEngineer.strResult);
    }
     @Test
     @SneakyThrows (InterruptedException.class)
    void factorial_pressFirst( ) {
        locate=panelKey.buttonsEngineer.b5.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);

//        txt.setText(panelKey.buttonsEngineer.strInput);
        locate = panelKey.buttonsEngineer.bFactorial.getLocationOnScreen();
        bot.mouseMove(locate.x + 10, locate.y + 10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(50);

        assertEquals("0!", panelKey.buttonsEngineer.strInput.replaceAll(" ",""));
        assertEquals("неверный формат ввода факториала", panelKey.buttonsEngineer.strResult);
    }


    @Test //2+PI
    @SneakyThrows (InterruptedException.class)
    void PI_afterSign()  {

        locate=panelKey.buttonsEngineer.b2.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(50);

        txt.setText(panelKey.buttonsEngineer.strInput);
        locate=panelKey.buttonsEngineer.bPlus.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(30);

        txt.setText(panelKey.buttonsEngineer.strInput);
        locate=panelKey.buttonsEngineer.bPi.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(30);

        //2+PI
        assertEquals("2+3.141592653589793", panelKey.buttonsEngineer.strInput.replaceAll(" ",""));
        assertEquals("5.14159265358979", panelKey.buttonsEngineer.countResult);
    }
    @Test //5+2PI
    @SneakyThrows (InterruptedException.class)
    void PI_afterNumber()  {
        locate=panelKey.buttonsEngineer.b5.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(50);

        txt.setText(panelKey.buttonsEngineer.strInput);
        locate=panelKey.buttonsEngineer.bPlus.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(50);

        txt.setText(panelKey.buttonsEngineer.strInput);
        locate=panelKey.buttonsEngineer.b2.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(50);

        txt.setText(panelKey.buttonsEngineer.strInput);
        locate=panelKey.buttonsEngineer.bPi.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(50);

        //5+2PI
        assertEquals("5+2*3.141592653589793", panelKey.buttonsEngineer.strInput.replaceAll(" ",""));
        assertEquals("11.2831853071796", panelKey.buttonsEngineer.countResult);
    }
    @Test //PI=PI
    @SneakyThrows (InterruptedException.class)
    void PI_plus_Pi()  {
        locate=panelKey.buttonsEngineer.bPi.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(50);

        txt.setText(panelKey.buttonsEngineer.strInput);
        locate=panelKey.buttonsEngineer.bPlus.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(50);

        txt.setText(panelKey.buttonsEngineer.strInput);
        locate=panelKey.buttonsEngineer.bPi.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(50);

        //PI=PI
        assertEquals("3.141592653589793+3.141592653589793", panelKey.buttonsEngineer.strInput.replaceAll(" ",""));
        assertEquals("6.28318530717959", panelKey.buttonsEngineer.countResult);
    }
    @Test //2(2+3)PI
    @SneakyThrows (InterruptedException.class)
    void PI_afterBraces()  {

        locate=panelKey.buttonsEngineer.b2.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(25);

        txt.setText(panelKey.buttonsEngineer.strInput);
        locate=panelKey.buttonsEngineer.braceOpen.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(25);

        txt.setText(panelKey.buttonsEngineer.strInput);
        locate=panelKey.buttonsEngineer.b2.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(25);

        txt.setText(panelKey.buttonsEngineer.strInput);
        locate=panelKey.buttonsEngineer.bPlus.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(40);

        txt.setText(panelKey.buttonsEngineer.strInput);
        locate=panelKey.buttonsEngineer.b3.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(25);

        txt.setText(panelKey.buttonsEngineer.strInput);
        locate=panelKey.buttonsEngineer.braceClose.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(25);

        txt.setText(panelKey.buttonsEngineer.strInput);
        locate=panelKey.buttonsEngineer.bPi.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(25);
//2(2+3)PI
        assertEquals("2*(2+3)*3.141592653589793", panelKey.buttonsEngineer.strInput.replaceAll(" ",""));
        assertEquals("31.4159265358979", panelKey.buttonsEngineer.countResult);
    }


    @Test //5²
    @SneakyThrows (InterruptedException.class)
    void x2()  {
        locate=panelKey.buttonsEngineer.b5.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(25);

        txt.setText(panelKey.buttonsEngineer.strInput);
        locate=panelKey.buttonsEngineer.bx2.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(25);

        //5²
        assertEquals("5²", panelKey.buttonsEngineer.strInput.replaceAll(" ",""));
        assertEquals("25", panelKey.buttonsEngineer.countResult);
    }
    @Test //2²+3²
    @SneakyThrows (InterruptedException.class)
    void x2_plus_x2()  {
        bot.keyPress(KeyEvent.VK_2);
        Thread.sleep(25);
        bot.keyRelease(KeyEvent.VK_2);

        txt.setText(panelKey.buttonsEngineer.strInput);
        locate=panelKey.buttonsEngineer.bx2.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(25);

        txt.setText(panelKey.buttonsEngineer.strInput);
        bot.keyPress(KeyEvent.VK_ADD);
        Thread.sleep(20);
        bot.keyRelease(KeyEvent.VK_ADD);

        txt.setText(panelKey.buttonsEngineer.strInput);
        bot.keyPress(KeyEvent.VK_3);
        Thread.sleep(10);
        bot.keyRelease(KeyEvent.VK_3);

        txt.setText(panelKey.buttonsEngineer.strInput);
        locate=panelKey.buttonsEngineer.bx2.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(25);

        //2²+3²
        assertEquals("2²+3²", panelKey.buttonsEngineer.strInput.replaceAll(" ",""));
        assertEquals("13", panelKey.buttonsEngineer.countResult);
    }
    @Test //2(2+3)²
    @SneakyThrows (InterruptedException.class)
    void x2_sum()  {
        locate=panelKey.buttonsEngineer.b2.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(30);

        txt.setText(panelKey.buttonsEngineer.strInput);
        locate=panelKey.buttonsEngineer.braceOpen.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(30);

        txt.setText(panelKey.buttonsEngineer.strInput);
        locate=panelKey.buttonsEngineer.b2.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(30);

        txt.setText(panelKey.buttonsEngineer.strInput);
        locate=panelKey.buttonsEngineer.bPlus.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(30);

        txt.setText(panelKey.buttonsEngineer.strInput);
        locate=panelKey.buttonsEngineer.b3.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(30);

        txt.setText(panelKey.buttonsEngineer.strInput);
        locate=panelKey.buttonsEngineer.braceClose.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(50);

        txt.setText(panelKey.buttonsEngineer.strInput);
        locate=panelKey.buttonsEngineer.bx2.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(50);

        //2(2+3)²
        assertEquals("2*(2+3)²", panelKey.buttonsEngineer.strInput.replaceAll(" ",""));
        assertEquals("50", panelKey.buttonsEngineer.countResult);
    }
     @Test //2(2²+3²
     @SneakyThrows (InterruptedException.class)
    void x2_plus_x2_inBraces()  {
        locate=panelKey.buttonsEngineer.b2.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(30);

//        txt.setText(panelKey.buttonsEngineer.strInput);
//        locate=panelKey.buttonsEngineer.bMultiply.getLocationOnScreen();
//        bot.mouseMove(locate.x+10,locate.y+10);
//        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
//        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
//        Thread.sleep(30);

        txt.setText(panelKey.buttonsEngineer.strInput);
        locate=panelKey.buttonsEngineer.braceOpen.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(30);

        txt.setText(panelKey.buttonsEngineer.strInput);
        locate=panelKey.buttonsEngineer.b2.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(30);

        txt.setText(panelKey.buttonsEngineer.strInput);
        locate=panelKey.buttonsEngineer.bx2.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(30);

        txt.setText(panelKey.buttonsEngineer.strInput);
        locate=panelKey.buttonsEngineer.bPlus.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(30);


        txt.setText(panelKey.buttonsEngineer.strInput);
        locate=panelKey.buttonsEngineer.b3.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(30);

        txt.setText(panelKey.buttonsEngineer.strInput);
        locate=panelKey.buttonsEngineer.bx2.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(30);

        //2(2²+3²
        assertEquals("2*(2²+3²", panelKey.buttonsEngineer.strInput.replaceAll(" ",""));
        assertEquals("26", panelKey.buttonsEngineer.countResult);
    }


    @Test //±5
    @SneakyThrows (InterruptedException.class)
    void exchangeSign_positive()  {
        locate=panelKey.buttonsEngineer.b5.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(25);

        txt.setText(panelKey.buttonsEngineer.strInput);
        locate=panelKey.buttonsEngineer.bChageSign.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(25);

        //±5
        assertEquals("±(5)", panelKey.buttonsEngineer.strInput.replaceAll(" ",""));
        assertEquals("-5", panelKey.buttonsEngineer.countResult);
    }
    @Test //±2(5-8)
    @SneakyThrows (InterruptedException.class)
    void exchangeSign_negative()  {
        locate=panelKey.buttonsEngineer.b2.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(25);

        txt.setText(panelKey.buttonsEngineer.strInput);
        locate=panelKey.buttonsEngineer.braceOpen.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(25);

        txt.setText(panelKey.buttonsEngineer.strInput);
        locate=panelKey.buttonsEngineer.b5.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(25);

        txt.setText(panelKey.buttonsEngineer.strInput);
        locate=panelKey.buttonsEngineer.bMinus.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(50);

        txt.setText(panelKey.buttonsEngineer.strInput);
        locate=panelKey.buttonsEngineer.b8.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(25);

        txt.setText(panelKey.buttonsEngineer.strInput);
        locate=panelKey.buttonsEngineer.braceClose.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(25);

        txt.setText(panelKey.buttonsEngineer.strInput);
        locate=panelKey.buttonsEngineer.bChageSign.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(25);

        //±2*(5-8)
        assertEquals("±(2*(5-8))", panelKey.buttonsEngineer.strInput.replaceAll(" ",""));
        assertEquals("6", panelKey.buttonsEngineer.countResult);
    }


    @Test // 5^3
    @SneakyThrows (InterruptedException.class)
    void powerN()  {
        locate=panelKey.buttonsEngineer.b5.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(25);

        txt.setText(panelKey.buttonsEngineer.strInput);
        locate=panelKey.buttonsEngineer.bxn.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(50);

        txt.setText(panelKey.buttonsEngineer.strInput);
        locate=panelKey.buttonsEngineer.b3.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(25);
        // 5^3
        assertEquals("5^3", panelKey.buttonsEngineer.strInput.replaceAll(" ",""));
        assertEquals("125", panelKey.buttonsEngineer.countResult);
    }
    @Test // 0^(3-4)
    @SneakyThrows (InterruptedException.class)
     void powerN_Exception()  {
        locate=panelKey.buttonsEngineer.b0.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(25);

        txt.setText(panelKey.buttonsEngineer.strInput);
        locate=panelKey.buttonsEngineer.bxn.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(50);

        txt.setText(panelKey.buttonsEngineer.strInput);
        locate=panelKey.buttonsEngineer.braceOpen.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(25);

        txt.setText(panelKey.buttonsEngineer.strInput);
        locate=panelKey.buttonsEngineer.b3.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(25);

        txt.setText(panelKey.buttonsEngineer.strInput);
        locate=panelKey.buttonsEngineer.bMinus.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(25);

        txt.setText(panelKey.buttonsEngineer.strInput);
        locate=panelKey.buttonsEngineer.b4.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(25);

        // 0^(3-4)
        assertEquals("0^(3-4", panelKey.buttonsEngineer.strInput.replaceAll(" ",""));
        assertEquals("делить на 0 нельзя", panelKey.buttonsEngineer.strResult);
    }



    @Test // 5 и 1/x
    @SneakyThrows (InterruptedException.class)
     void divideForX()  {
        locate=panelKey.buttonsEngineer.b5.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(25);

         txt.setText(panelKey.buttonsEngineer.strInput);
        locate=panelKey.buttonsEngineer.bDivX.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(50);

        // 5 и 1/x
        assertEquals("5^(-1)", panelKey.buttonsEngineer.strInput.replaceAll(" ",""));
        assertEquals("0.2", panelKey.buttonsEngineer.countResult);
    }
     @Test // 0^(-1)
     @SneakyThrows (InterruptedException.class)
    void divideForX_Exception()  {
        locate=panelKey.buttonsEngineer.b0.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(25);

        txt.setText(panelKey.buttonsEngineer.strInput);
        locate=panelKey.buttonsEngineer.bDivX.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(50);


        // 0^(-1)
        assertEquals("0^(-1)", panelKey.buttonsEngineer.strInput.replaceAll(" ",""));
        assertEquals("делить на 0 нельзя", panelKey.buttonsEngineer.strResult);
    }



     @Test //5!
     @SneakyThrows (InterruptedException.class)
    void factorial ()  {
        locate=panelKey.buttonsEngineer.b5.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(40);

        txt.setText(panelKey.buttonsEngineer.strInput);
        locate=panelKey.buttonsEngineer.bFactorial.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(40);
//5!
        assertEquals("5!", panelKey.buttonsEngineer.strInput.replaceAll(" ",""));
        assertEquals("120", panelKey.buttonsEngineer.countResult);
    }
     @Test    //5²!
     @SneakyThrows (InterruptedException.class)
    void x2_factorial()  {
        locate=panelKey.buttonsEngineer.b5.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(25);

        txt.setText(panelKey.buttonsEngineer.strInput);
        locate=panelKey.buttonsEngineer.bx2.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(25);

        txt.setText(panelKey.buttonsEngineer.strInput);
        locate=panelKey.buttonsEngineer.bFactorial.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(25);
//5²!
        assertEquals("5!", panelKey.buttonsEngineer.strInput.replaceAll(" ",""));
        assertEquals("120", panelKey.buttonsEngineer.countResult);
    }
     @Test //5!²
     @SneakyThrows (InterruptedException.class)
    void factorial_x2()  {
        locate=panelKey.buttonsEngineer.b5.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(50);

        txt.setText(panelKey.buttonsEngineer.strInput);
        locate=panelKey.buttonsEngineer.bFactorial.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(25);

        txt.setText(panelKey.buttonsEngineer.strInput);
        locate=panelKey.buttonsEngineer.bx2.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(25);
//5!²
        assertEquals("5²", panelKey.buttonsEngineer.strInput.replaceAll(" ",""));
        assertEquals("25", panelKey.buttonsEngineer.countResult);
    }
     @Test //    3.2!
     @SneakyThrows (InterruptedException.class)
    void factorial_double()  {
        locate=panelKey.buttonsEngineer.b3.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(40);

        txt.setText(panelKey.buttonsEngineer.strInput);
        locate=panelKey.buttonsEngineer.bPoint.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(25);

        txt.setText(panelKey.buttonsEngineer.strInput);
        locate=panelKey.buttonsEngineer.b2.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(25);

        txt.setText(panelKey.buttonsEngineer.strInput);
        locate=panelKey.buttonsEngineer.bFactorial.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(50);
//  3.2!
        assertEquals("3.2!", panelKey.buttonsEngineer.strInput.replaceAll(" ",""));
        assertEquals("неверный формат ввода факториала", panelKey.buttonsEngineer.strResult);
    }
     @Test //    -2!
     @SneakyThrows (InterruptedException.class)
    void factorial_negativeNumber()  {
        locate=panelKey.buttonsEngineer.braceOpen.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(25);

        txt.setText(panelKey.buttonsEngineer.strInput);
        locate=panelKey.buttonsEngineer.b0.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(25);

        txt.setText(panelKey.buttonsEngineer.strInput);
        locate=panelKey.buttonsEngineer.bMinus.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(25);

        txt.setText(panelKey.buttonsEngineer.strInput);
        locate=panelKey.buttonsEngineer.b2.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(25);

        txt.setText(panelKey.buttonsEngineer.strInput);
        locate=panelKey.buttonsEngineer.braceClose.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(25);

        txt.setText(panelKey.buttonsEngineer.strInput);
        locate=panelKey.buttonsEngineer.bFactorial.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(25);
//  -2!
        assertEquals("(0-2)!", panelKey.buttonsEngineer.strInput.replaceAll(" ",""));
        assertEquals("неверный формат ввода факториала", panelKey.buttonsEngineer.strResult);
    }






     @Test //    ³√(9^999
     @SneakyThrows (InterruptedException.class)
    void sqrt3_bigDecimal_exception()  {
        locate=panelKey.buttonsEngineer.bSqrt3.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(50);

        txt.setText(panelKey.buttonsEngineer.strInput);
        locate=panelKey.buttonsEngineer.braceOpen.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(25);

        txt.setText(panelKey.buttonsEngineer.strInput);
        locate=panelKey.buttonsEngineer.b9.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(25);

        txt.setText(panelKey.buttonsEngineer.strInput);
        locate=panelKey.buttonsEngineer.bxn.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(40);

        txt.setText(panelKey.buttonsEngineer.strInput);
        locate=panelKey.buttonsEngineer.b9.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(25);

        txt.setText(panelKey.buttonsEngineer.strInput);
        locate=panelKey.buttonsEngineer.b9.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(25);

        txt.setText(panelKey.buttonsEngineer.strInput);
        locate=panelKey.buttonsEngineer.b9.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(50);

//  ³√(9^999
        assertEquals("³√((9^999", panelKey.buttonsEngineer.strInput.replaceAll(" ",""));
        assertEquals("³√ недозволеного большого числа", panelKey.buttonsEngineer.strResult);
    }
     @Test //    2³√(8
     @SneakyThrows (InterruptedException.class)
    void sqrt3_afterNumber()  {
        locate=panelKey.buttonsEngineer.b2.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(25);

        txt.setText(panelKey.buttonsEngineer.strInput);
        locate=panelKey.buttonsEngineer.bSqrt3.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(50);



        txt.setText(panelKey.buttonsEngineer.strInput);
        locate=panelKey.buttonsEngineer.b8.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(25);


//  2³√(8
        assertEquals("2*³√(8", panelKey.buttonsEngineer.strInput.replaceAll(" ",""));
        assertEquals("=4", panelKey.buttonsEngineer.strResult);
    }

     @Test //    2-cos( 0
     @SneakyThrows (InterruptedException.class)
    void cos_afterSign()  {
        locate=panelKey.buttonsEngineer.b2.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(25);

        txt.setText(panelKey.buttonsEngineer.strInput);
        locate=panelKey.buttonsEngineer.bMinus.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(25);

        txt.setText(panelKey.buttonsEngineer.strInput);
        locate=panelKey.buttonsEngineer.bCos.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(25);

        txt.setText(panelKey.buttonsEngineer.strInput);
        locate=panelKey.buttonsEngineer.b0.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(25);

//  2-cos( 0
        assertEquals("2-cos(0", panelKey.buttonsEngineer.strInput.replaceAll(" ",""));
        assertEquals("=1", panelKey.buttonsEngineer.strResult);
    }
     @Test //    2cos( 0
     @SneakyThrows (InterruptedException.class)
    void cos_afterNumber()  {
        locate=panelKey.buttonsEngineer.b2.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(25);

        txt.setText(panelKey.buttonsEngineer.strInput);
        locate=panelKey.buttonsEngineer.bCos.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(25);

        txt.setText(panelKey.buttonsEngineer.strInput);
        locate=panelKey.buttonsEngineer.b0.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(25);

//  2*cos( 0
        assertEquals("2*cos(0", panelKey.buttonsEngineer.strInput.replaceAll(" ",""));
        assertEquals("=2", panelKey.buttonsEngineer.strResult);
    }
     @Test //    2-sin( 30
     @SneakyThrows (InterruptedException.class)
    void sin_afterSign()  {
        locate=panelKey.buttonsEngineer.b2.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(25);

        txt.setText(panelKey.buttonsEngineer.strInput);
        locate=panelKey.buttonsEngineer.bMinus.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(25);

        txt.setText(panelKey.buttonsEngineer.strInput);
        locate=panelKey.buttonsEngineer.bSin.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(25);

        txt.setText(panelKey.buttonsEngineer.strInput);
        locate=panelKey.buttonsEngineer.b3.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(25);

        txt.setText(panelKey.buttonsEngineer.strInput);
        locate=panelKey.buttonsEngineer.b0.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(25);

//  2-sin( 30
        assertEquals("2-sin(30", panelKey.buttonsEngineer.strInput.replaceAll(" ",""));
        assertEquals("=1.5", panelKey.buttonsEngineer.strResult);
    }
     @Test //    2-sin( 30
     @SneakyThrows (InterruptedException.class)
    void sin_afterNumber()  {
        locate=panelKey.buttonsEngineer.b2.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(25);

        txt.setText(panelKey.buttonsEngineer.strInput);
        locate=panelKey.buttonsEngineer.bSin.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(25);

        txt.setText(panelKey.buttonsEngineer.strInput);
        locate=panelKey.buttonsEngineer.b3.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(25);

        txt.setText(panelKey.buttonsEngineer.strInput);
        locate=panelKey.buttonsEngineer.b0.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(25);

//  2*sin(30
        assertEquals("2*sin(30", panelKey.buttonsEngineer.strInput.replaceAll(" ",""));
        assertEquals("=1", panelKey.buttonsEngineer.strResult);
    }




     @Test //    2-lg(45
     @SneakyThrows (InterruptedException.class)
    void tg_afterSign()  {
        locate=panelKey.buttonsEngineer.b2.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(25);

        txt.setText(panelKey.buttonsEngineer.strInput);
        locate=panelKey.buttonsEngineer.bMinus.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(25);

        txt.setText(panelKey.buttonsEngineer.strInput);
        locate=panelKey.buttonsEngineer.bTg.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(25);

        txt.setText(panelKey.buttonsEngineer.strInput);
        locate=panelKey.buttonsEngineer.b4.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(25);

        txt.setText(panelKey.buttonsEngineer.strInput);
        locate=panelKey.buttonsEngineer.b5.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(25);

//  2-lg(45 (=1)
        assertEquals("2-tg(45", panelKey.buttonsEngineer.strInput.replaceAll(" ",""));
        assertEquals("=1", panelKey.buttonsEngineer.strResult);
    }
     @Test //    2tg(45
     @SneakyThrows (InterruptedException.class)
    void tg_afterNumber()  {
        locate=panelKey.buttonsEngineer.b2.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(25);

        txt.setText(panelKey.buttonsEngineer.strInput);
        locate=panelKey.buttonsEngineer.bTg.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(25);

        txt.setText(panelKey.buttonsEngineer.strInput);
        locate=panelKey.buttonsEngineer.b4.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(25);

        txt.setText(panelKey.buttonsEngineer.strInput);
        locate=panelKey.buttonsEngineer.b5.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(25);

//  2tg(45
        assertEquals("2*tg(45", panelKey.buttonsEngineer.strInput.replaceAll(" ",""));
        assertEquals("=2", panelKey.buttonsEngineer.strResult);
    }
     @Test //    tg(9^999
     @SneakyThrows (InterruptedException.class)
    void tg_exception_overflow()  {
        txt.setText(panelKey.buttonsEngineer.strInput);
        locate=panelKey.buttonsEngineer.b1.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(25);

        txt.setText(panelKey.buttonsEngineer.strInput);
        locate=panelKey.buttonsEngineer.bTg.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(50);

        txt.setText(panelKey.buttonsEngineer.strInput);
        locate=panelKey.buttonsEngineer.b9.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(25);

        txt.setText(panelKey.buttonsEngineer.strInput);
        locate=panelKey.buttonsEngineer.bxn.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(40);

        txt.setText(panelKey.buttonsEngineer.strInput);
        locate=panelKey.buttonsEngineer.b9.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(25);

        txt.setText(panelKey.buttonsEngineer.strInput);
        locate=panelKey.buttonsEngineer.b9.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(25);

        txt.setText(panelKey.buttonsEngineer.strInput);
        locate=panelKey.buttonsEngineer.b9.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(50);

//  tg(9^999
        assertEquals("1*tg(9^999", panelKey.buttonsEngineer.strInput.replaceAll(" ",""));
        assertEquals("tg недозволеного большого числа", panelKey.buttonsEngineer.strResult);
    }
     @Test //    tg(90
     @SneakyThrows (InterruptedException.class)
    void tg_exception_NaN()  {
        locate=panelKey.buttonsEngineer.bTg.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(50);

        txt.setText(panelKey.buttonsEngineer.strInput);
        locate=panelKey.buttonsEngineer.b9.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(25);

        txt.setText(panelKey.buttonsEngineer.strInput);
        locate=panelKey.buttonsEngineer.b0.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(50);

//   tg(90
        assertEquals("tg(90", panelKey.buttonsEngineer.strInput.replaceAll(" ",""));
        assertEquals("tg не определен", panelKey.buttonsEngineer.strResult);
    }



     @Test //    2-lg(100
     @SneakyThrows (InterruptedException.class)
    void lg_afterSign()  {
        locate=panelKey.buttonsEngineer.b2.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(25);

        txt.setText(panelKey.buttonsEngineer.strInput);
        locate=panelKey.buttonsEngineer.bMinus.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(25);

        txt.setText(panelKey.buttonsEngineer.strInput);
        locate=panelKey.buttonsEngineer.bLg.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(25);

        txt.setText(panelKey.buttonsEngineer.strInput);
        locate=panelKey.buttonsEngineer.b1.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(25);

        txt.setText(panelKey.buttonsEngineer.strInput);
        locate=panelKey.buttonsEngineer.b0.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(25);

        txt.setText(panelKey.buttonsEngineer.strInput);
        locate=panelKey.buttonsEngineer.b0.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(25);

//  2-lg(100
        assertEquals("2-lg(100", panelKey.buttonsEngineer.strInput.replaceAll(" ",""));
        assertEquals("=0", panelKey.buttonsEngineer.strResult);
    }
     @Test //    2lg(100
     @SneakyThrows (InterruptedException.class)
    void lg_afterNumber()  {
        locate=panelKey.buttonsEngineer.b2.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(25);

        txt.setText(panelKey.buttonsEngineer.strInput);
        locate=panelKey.buttonsEngineer.bLg.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(25);

        txt.setText(panelKey.buttonsEngineer.strInput);
        locate=panelKey.buttonsEngineer.b1.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(25);

        txt.setText(panelKey.buttonsEngineer.strInput);
        locate=panelKey.buttonsEngineer.b0.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(25);

        txt.setText(panelKey.buttonsEngineer.strInput);
        locate=panelKey.buttonsEngineer.b0.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(25);

//  2lg(100
        assertEquals("2*lg(100", panelKey.buttonsEngineer.strInput.replaceAll(" ",""));
        assertEquals("=4", panelKey.buttonsEngineer.strResult);
    }
     @Test //    lg(9^999
     @SneakyThrows (InterruptedException.class)
    void lg_exception_overflow()  {
        locate=panelKey.buttonsEngineer.bLg.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(50);

        txt.setText(panelKey.buttonsEngineer.strInput);
        locate=panelKey.buttonsEngineer.b9.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(25);

        txt.setText(panelKey.buttonsEngineer.strInput);
        locate=panelKey.buttonsEngineer.bxn.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(40);

        txt.setText(panelKey.buttonsEngineer.strInput);
        locate=panelKey.buttonsEngineer.b9.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(25);

        txt.setText(panelKey.buttonsEngineer.strInput);
        locate=panelKey.buttonsEngineer.b9.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(25);

        txt.setText(panelKey.buttonsEngineer.strInput);
        locate=panelKey.buttonsEngineer.b9.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(50);

//  lg(9^999
        assertEquals("lg(9^999", panelKey.buttonsEngineer.strInput.replaceAll(" ",""));
        assertEquals("lg недозволеного большого числа", panelKey.buttonsEngineer.strResult);
    }
     @Test //    lg(1-4
     @SneakyThrows (InterruptedException.class)
    void lg_exception_NaN()  {
        locate=panelKey.buttonsEngineer.bLg.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(50);

        txt.setText(panelKey.buttonsEngineer.strInput);
        locate=panelKey.buttonsEngineer.b1.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(25);

        txt.setText(panelKey.buttonsEngineer.strInput);
        locate=panelKey.buttonsEngineer.bMinus.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(25);

        txt.setText(panelKey.buttonsEngineer.strInput);
        locate=panelKey.buttonsEngineer.b4.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(50);

//  lg(1-4
        assertEquals("lg(1-4", panelKey.buttonsEngineer.strInput.replaceAll(" ",""));
        assertEquals("lg не определен", panelKey.buttonsEngineer.strResult);
    }
     @Test //    lg(0
     @SneakyThrows (InterruptedException.class)
    void lg_exception_0()  {

        locate=panelKey.buttonsEngineer.b1.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(25);

        txt.setText(panelKey.buttonsEngineer.strInput);
        locate=panelKey.buttonsEngineer.bLg.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(50);

        txt.setText(panelKey.buttonsEngineer.strInput);
        locate=panelKey.buttonsEngineer.b0.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(25);

//  lg(0
        assertEquals("1*lg(0", panelKey.buttonsEngineer.strInput.replaceAll(" ",""));
        assertEquals("lg не определен", panelKey.buttonsEngineer.strResult);
    }




     @Test //    2-ln(1
     @SneakyThrows (InterruptedException.class)
    void ln_afterSign()  {
        locate=panelKey.buttonsEngineer.b2.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(25);

        txt.setText(panelKey.buttonsEngineer.strInput);
        locate=panelKey.buttonsEngineer.bMinus.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(25);

        txt.setText(panelKey.buttonsEngineer.strInput);
        locate=panelKey.buttonsEngineer.bLn.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(25);

        txt.setText(panelKey.buttonsEngineer.strInput);
        locate=panelKey.buttonsEngineer.b1.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(25);

//  2-ln(1
        assertEquals("2-ln(1", panelKey.buttonsEngineer.strInput.replaceAll(" ",""));
        assertEquals("=2", panelKey.buttonsEngineer.strResult);
    }
     @Test //    2ln(1
     @SneakyThrows (InterruptedException.class)
    void ln_afterNumber()  {
        locate=panelKey.buttonsEngineer.b2.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(25);

        txt.setText(panelKey.buttonsEngineer.strInput);
        locate=panelKey.buttonsEngineer.bLn.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(25);

        txt.setText(panelKey.buttonsEngineer.strInput);
        locate=panelKey.buttonsEngineer.b1.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(25);


//  2ln(1
        assertEquals("2*ln(1", panelKey.buttonsEngineer.strInput.replaceAll(" ",""));
        assertEquals("=0", panelKey.buttonsEngineer.strResult);
    }
     @Test //    ln(9^999
     @SneakyThrows (InterruptedException.class)
    void ln_exception_overflow()  {

        locate=panelKey.buttonsEngineer.b1.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(25);

        txt.setText(panelKey.buttonsEngineer.strInput);
        locate=panelKey.buttonsEngineer.bLn.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(50);

        txt.setText(panelKey.buttonsEngineer.strInput);
        locate=panelKey.buttonsEngineer.b9.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(25);

        txt.setText(panelKey.buttonsEngineer.strInput);
        locate=panelKey.buttonsEngineer.bxn.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(40);

        txt.setText(panelKey.buttonsEngineer.strInput);
        locate=panelKey.buttonsEngineer.b9.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(25);

        txt.setText(panelKey.buttonsEngineer.strInput);
        locate=panelKey.buttonsEngineer.b9.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(25);

        txt.setText(panelKey.buttonsEngineer.strInput);
        locate=panelKey.buttonsEngineer.b9.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(50);

//  ln(9^999
        assertEquals("1*ln(9^999", panelKey.buttonsEngineer.strInput.replaceAll(" ",""));
        assertEquals("ln недозволеного большого числа", panelKey.buttonsEngineer.strResult);
    }
     @Test //    ln(1-4
     @SneakyThrows (InterruptedException.class)
    void ln_exception_NaN()  {
        locate=panelKey.buttonsEngineer.bLn.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(50);

        txt.setText(panelKey.buttonsEngineer.strInput);
        locate=panelKey.buttonsEngineer.b1.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(25);

        txt.setText(panelKey.buttonsEngineer.strInput);
        locate=panelKey.buttonsEngineer.bMinus.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(25);

        txt.setText(panelKey.buttonsEngineer.strInput);
        locate=panelKey.buttonsEngineer.b4.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(50);

//  ln(1-4
        assertEquals("ln(1-4", panelKey.buttonsEngineer.strInput.replaceAll(" ",""));
        assertEquals("ln не определен", panelKey.buttonsEngineer.strResult);
    }
     @Test //    ln(0
     @SneakyThrows (InterruptedException.class)
    void ln_exception_0()  {
        locate=panelKey.buttonsEngineer.bLn.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(50);

        txt.setText(panelKey.buttonsEngineer.strInput);
        locate=panelKey.buttonsEngineer.b0.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(25);

//  ln(0
        assertEquals("ln(0", panelKey.buttonsEngineer.strInput.replaceAll(" ",""));
        assertEquals("ln не определен", panelKey.buttonsEngineer.strResult);
    }
     @Test //    1*(1*(1+1
     @SneakyThrows (InterruptedException.class)
    void braces_inLogPanel()  {
        locate=panelKey.buttonsEngineer.b1.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(50);

        txt.setText(panelKey.buttonsEngineer.strInput);
        locate=panelKey.buttonsEngineer.braceOpen.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(25);

        txt.setText(panelKey.buttonsEngineer.strInput);
        locate=panelKey.buttonsEngineer.b1.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(50);

        txt.setText(panelKey.buttonsEngineer.strInput);
        locate=panelKey.buttonsEngineer.braceOpen.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(25);

        txt.setText(panelKey.buttonsEngineer.strInput);
        locate=panelKey.buttonsEngineer.b1.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(50);

        txt.setText(panelKey.buttonsEngineer.strInput);
        locate=panelKey.buttonsEngineer.bPlus.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(50);

        txt.setText(panelKey.buttonsEngineer.strInput);
        locate=panelKey.buttonsEngineer.b1.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(50);

//   1*(1*(1+1
        assertEquals("1*(1*(1+1", panelKey.buttonsEngineer.strInput.replaceAll(" ",""));
        assertEquals(2, panelKey.buttonsEngineer.countBrace);
    }



    @Test //    ±(7)²
    @SneakyThrows (InterruptedException.class)
    void countSqrt2_after_exchangeSign()  {
        locate=panelKey.buttonsEngineer.b7.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(50);

        txt.setText(panelKey.buttonsEngineer.strInput);
        locate=panelKey.buttonsEngineer.bChageSign.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(25);

        txt.setText(panelKey.buttonsEngineer.strInput);
        locate=panelKey.buttonsEngineer.bx2.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(50);


//   ±(7)²
        assertEquals("(-7)²", panelKey.buttonsEngineer.strInput.replaceAll(" ",""));
        assertEquals("49", panelKey.buttonsEngineer.countResult);
    }
    @Test //    ±(7)+2
    @SneakyThrows (InterruptedException.class)
    void countSum_after_exchangeSign()  {
        locate=panelKey.buttonsEngineer.b7.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(50);

        txt.setText(panelKey.buttonsEngineer.strInput);
        locate=panelKey.buttonsEngineer.bChageSign.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(25);

        txt.setText(panelKey.buttonsEngineer.strInput);
        locate=panelKey.buttonsEngineer.bPlus.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(50);

        txt.setText(panelKey.buttonsEngineer.strInput);
        locate=panelKey.buttonsEngineer.b2.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(50);


//   ±(7)+2
        assertEquals("-7+2", panelKey.buttonsEngineer.strInput.replaceAll(" ",""));
        assertEquals("-5", panelKey.buttonsEngineer.countResult);
    }

}