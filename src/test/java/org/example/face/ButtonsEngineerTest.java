package org.example.face;


import org.example.face.PanelKeyEngineer;
import org.example.face.PanelTextLog;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import javax.swing.*;
import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

import static org.junit.jupiter.api.Assertions.*;


@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class ButtonsEngineerTest {
    Point locate;
    JTextPane txt;
    JLabel lable;
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
        lable= new JLabel();
        lable.setText("22");

        Mockito.doNothing().when(textPanel).setSbLog(Mockito.any());
        Mockito.doNothing().when(textPanel).setTextInput(Mockito.any());
        Mockito.doNothing().when(textPanel).setTextResult(Mockito.any());

        Mockito.when(textPanel.getSbLog()).thenReturn(new StringBuffer(" "));
        Mockito.when(textPanel.getTextInput()).thenReturn(txt);
        Mockito.when(textPanel.getTextResult()).thenReturn(lable);



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
    void sqrt3_pressFirst( ) {

        locate = panelKey.buttonsEngineer.bSqrt3.getLocationOnScreen();
        bot.mouseMove(locate.x + 10, locate.y + 10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        try {  Thread.sleep(25); } catch (InterruptedException e) { }

        txt.setText(panelKey.buttonsEngineer.strInput.trim());
        locate = panelKey.buttonsEngineer.b2.getLocationOnScreen();
        bot.mouseMove(locate.x + 10, locate.y + 10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        try {  Thread.sleep(25); } catch (InterruptedException e) { }

        assertEquals("³√(2", panelKey.buttonsEngineer.strInput.trim());
    }
     @Test
    void sin_pressFirst( ) {
        locate = panelKey.buttonsEngineer.bClear.getLocationOnScreen();
        bot.mouseMove(locate.x + 10, locate.y + 10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        try {  Thread.sleep(25); } catch (InterruptedException e) { }

        txt.setText(panelKey.buttonsEngineer.strInput.trim());
        locate = panelKey.buttonsEngineer.bSin.getLocationOnScreen();
        bot.mouseMove(locate.x + 10, locate.y + 10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        try {  Thread.sleep(25); } catch (InterruptedException e) { }

        txt.setText(panelKey.buttonsEngineer.strInput.trim());
        locate = panelKey.buttonsEngineer.b2.getLocationOnScreen();
        bot.mouseMove(locate.x + 10, locate.y + 10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        try {  Thread.sleep(25); } catch (InterruptedException e) { }

        assertEquals("sin(2", panelKey.buttonsEngineer.strInput.trim());
    }

    @Test
    void pow2_pressFirst( ) {

        locate = panelKey.buttonsEngineer.bx2.getLocationOnScreen();
        bot.mouseMove(locate.x + 10, locate.y + 10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        try {  Thread.sleep(25); } catch (InterruptedException e) { }

        txt.setText(panelKey.buttonsEngineer.strInput.trim());
        locate = panelKey.buttonsEngineer.b2.getLocationOnScreen();
        bot.mouseMove(locate.x + 10, locate.y + 10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        try {  Thread.sleep(25); } catch (InterruptedException e) { }

        assertEquals("0²", panelKey.buttonsEngineer.strInput.trim());
    }
     @Test
    void PI_pressFirst( ) {

        locate = panelKey.buttonsEngineer.bPi.getLocationOnScreen();
        bot.mouseMove(locate.x + 10, locate.y + 10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        try {  Thread.sleep(25); } catch (InterruptedException e) { }



        assertEquals("3.141592653589793", panelKey.buttonsEngineer.strInput.trim());
    }

    @Test
    void xn_pressFirst( ) {
        locate = panelKey.buttonsEngineer.bxn.getLocationOnScreen();
        bot.mouseMove(locate.x + 10, locate.y + 10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        try {  Thread.sleep(25); } catch (InterruptedException e) { }

        assertEquals("0^", panelKey.buttonsEngineer.strInput.trim());
    }
    @Test
    void devX_pressFirst( ) {
        locate = panelKey.buttonsEngineer.bDivX.getLocationOnScreen();
        bot.mouseMove(locate.x + 10, locate.y + 10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        try {  Thread.sleep(25); } catch (InterruptedException e) { }

        assertEquals("0^(-1)", panelKey.buttonsEngineer.strInput.trim());
        assertEquals("делить на 0 нельзя", panelKey.buttonsEngineer.strResult);
    }
     @Test
    void factorial_pressFirst( ) {
        locate=panelKey.buttonsEngineer.b5.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);

//        txt.setText(panelKey.buttonsEngineer.strInput.trim());
        locate = panelKey.buttonsEngineer.bFactorial.getLocationOnScreen();
        bot.mouseMove(locate.x + 10, locate.y + 10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        try {  Thread.sleep(50); } catch (InterruptedException e) { }

        assertEquals("0!", panelKey.buttonsEngineer.strInput.trim());
        assertEquals("неверный формат ввода факториала", panelKey.buttonsEngineer.strResult);
    }


    @Test //2+PI
    void PI_afterSign()  {

        locate=panelKey.buttonsEngineer.b2.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        try{Thread.sleep(50);}catch(InterruptedException e){}

        txt.setText(panelKey.buttonsEngineer.strInput.trim());
        locate=panelKey.buttonsEngineer.bPlus.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        try{Thread.sleep(30);}catch(InterruptedException e){}

        txt.setText(panelKey.buttonsEngineer.strInput.trim());
        locate=panelKey.buttonsEngineer.bPi.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        try{Thread.sleep(30);}catch(InterruptedException e){}

        //2+PI
        assertEquals("2+3.141592653589793", panelKey.buttonsEngineer.strInput);
        assertEquals("5.14159265358979", panelKey.buttonsEngineer.countResult);
    }
    @Test //5+2PI
    void PI_afterNumber()  {
        locate=panelKey.buttonsEngineer.b5.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        try{Thread.sleep(50);}catch(InterruptedException e){}

        txt.setText(panelKey.buttonsEngineer.strInput.trim());
        locate=panelKey.buttonsEngineer.bPlus.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        try{Thread.sleep(50);}catch(InterruptedException e){}

        txt.setText(panelKey.buttonsEngineer.strInput.trim());
        locate=panelKey.buttonsEngineer.b2.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        try{Thread.sleep(50);}catch(InterruptedException e){}

        txt.setText(panelKey.buttonsEngineer.strInput.trim());
        locate=panelKey.buttonsEngineer.bPi.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        try{Thread.sleep(50);}catch(InterruptedException e){}

        //5+2PI
        assertEquals("5+2*3.141592653589793", panelKey.buttonsEngineer.strInput);
        assertEquals("11.2831853071796", panelKey.buttonsEngineer.countResult);
    }
    @Test //PI=PI
    void PI_plus_Pi()  {
        locate=panelKey.buttonsEngineer.bPi.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        try{Thread.sleep(50);}catch(InterruptedException e){}

        txt.setText(panelKey.buttonsEngineer.strInput.trim());
        locate=panelKey.buttonsEngineer.bPlus.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        try{Thread.sleep(50);}catch(InterruptedException e){}

        txt.setText(panelKey.buttonsEngineer.strInput.trim());
        locate=panelKey.buttonsEngineer.bPi.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        try{Thread.sleep(50);}catch(InterruptedException e){}

        //PI=PI
        assertEquals("3.141592653589793+3.141592653589793", panelKey.buttonsEngineer.strInput);
        assertEquals("6.28318530717959", panelKey.buttonsEngineer.countResult);
    }
    @Test //2(2+3)PI
    void PI_afterBraces()  {

        locate=panelKey.buttonsEngineer.b2.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        try{Thread.sleep(25);}catch(InterruptedException e){}

        txt.setText(panelKey.buttonsEngineer.strInput.trim());
        locate=panelKey.buttonsEngineer.braceOpen.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        try{Thread.sleep(25);}catch(InterruptedException e){}

        txt.setText(panelKey.buttonsEngineer.strInput.trim());
        locate=panelKey.buttonsEngineer.b2.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        try{Thread.sleep(25);}catch(InterruptedException e){}

        txt.setText(panelKey.buttonsEngineer.strInput.trim());
        locate=panelKey.buttonsEngineer.bPlus.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        try{Thread.sleep(40);}catch(InterruptedException e){}

        txt.setText(panelKey.buttonsEngineer.strInput.trim());
        locate=panelKey.buttonsEngineer.b3.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        try{Thread.sleep(25);}catch(InterruptedException e){}

        txt.setText(panelKey.buttonsEngineer.strInput.trim());
        locate=panelKey.buttonsEngineer.braceClose.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        try{Thread.sleep(25);}catch(InterruptedException e){}

        txt.setText(panelKey.buttonsEngineer.strInput.trim());
        locate=panelKey.buttonsEngineer.bPi.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        try{Thread.sleep(25);}catch(InterruptedException e){}
//2(2+3)PI
        assertEquals("2*(2+3)*3.141592653589793", panelKey.buttonsEngineer.strInput);
        assertEquals("31.4159265358979", panelKey.buttonsEngineer.countResult);
    }


    @Test //5²
    void x2()  {
        locate=panelKey.buttonsEngineer.b5.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        try{Thread.sleep(25);}catch(InterruptedException e){}

        txt.setText(panelKey.buttonsEngineer.strInput.trim());
        locate=panelKey.buttonsEngineer.bx2.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        try{Thread.sleep(25);}catch(InterruptedException e){}

        //5²
        assertEquals("5²", panelKey.buttonsEngineer.strInput.trim());
        assertEquals("25", panelKey.buttonsEngineer.countResult);
    }
    @Test //2²+3²
    void x2_plus_x2()  {
        bot.keyPress(KeyEvent.VK_2);
        try {Thread.sleep(40);} catch (InterruptedException e) {}
        bot.keyRelease(KeyEvent.VK_2);

        txt.setText(panelKey.buttonsEngineer.strInput.trim());
        locate=panelKey.buttonsEngineer.bx2.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        try{Thread.sleep(25);}catch(InterruptedException e){}

        txt.setText(panelKey.buttonsEngineer.strInput.trim());
        bot.keyPress(KeyEvent.VK_ADD);
        try {Thread.sleep(20);} catch (InterruptedException e) {}
        bot.keyRelease(KeyEvent.VK_ADD);


        txt.setText(panelKey.buttonsEngineer.strInput.trim());
        bot.keyPress(KeyEvent.VK_3);
        try {Thread.sleep(10);} catch (InterruptedException e) {}
        bot.keyRelease(KeyEvent.VK_3);

        txt.setText(panelKey.buttonsEngineer.strInput.trim());
        locate=panelKey.buttonsEngineer.bx2.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        try{Thread.sleep(25);}catch(InterruptedException e){}

        //2²+3²
        assertEquals("2²+3²", panelKey.buttonsEngineer.strInput.trim());
        assertEquals("13", panelKey.buttonsEngineer.countResult);
    }
    @Test //2(2+3)²
    void x2_sum()  {
        locate=panelKey.buttonsEngineer.b2.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        try{Thread.sleep(30);}catch(InterruptedException e){}

        txt.setText(panelKey.buttonsEngineer.strInput.trim());
        locate=panelKey.buttonsEngineer.braceOpen.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        try{Thread.sleep(30);}catch(InterruptedException e){}

        txt.setText(panelKey.buttonsEngineer.strInput.trim());
        locate=panelKey.buttonsEngineer.b2.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        try{Thread.sleep(30);}catch(InterruptedException e){}

        txt.setText(panelKey.buttonsEngineer.strInput.trim());
        locate=panelKey.buttonsEngineer.bPlus.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        try{Thread.sleep(30);}catch(InterruptedException e){}

        txt.setText(panelKey.buttonsEngineer.strInput.trim());
        locate=panelKey.buttonsEngineer.b3.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        try{Thread.sleep(30);}catch(InterruptedException e){}

        txt.setText(panelKey.buttonsEngineer.strInput.trim());
        locate=panelKey.buttonsEngineer.braceClose.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        try{Thread.sleep(50);}catch(InterruptedException e){}

        txt.setText(panelKey.buttonsEngineer.strInput.trim());
        locate=panelKey.buttonsEngineer.bx2.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        try{Thread.sleep(50);}catch(InterruptedException e){}

        //2(2+3)²
        assertEquals("2*(2+3)²", panelKey.buttonsEngineer.strInput.trim());
        assertEquals("50", panelKey.buttonsEngineer.countResult);
    }
     @Test //2(2²+3²
    void x2_plus_x2_inBraces()  {
        locate=panelKey.buttonsEngineer.b2.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        try{Thread.sleep(30);}catch(InterruptedException e){}

        txt.setText(panelKey.buttonsEngineer.strInput.trim());
        locate=panelKey.buttonsEngineer.bMultiply.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        try{Thread.sleep(30);}catch(InterruptedException e){}

        txt.setText(panelKey.buttonsEngineer.strInput.trim());
        locate=panelKey.buttonsEngineer.braceOpen.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        try{Thread.sleep(30);}catch(InterruptedException e){}

        txt.setText(panelKey.buttonsEngineer.strInput.trim());
        locate=panelKey.buttonsEngineer.b2.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        try{Thread.sleep(25);}catch(InterruptedException e){}

        txt.setText(panelKey.buttonsEngineer.strInput.trim());
        locate=panelKey.buttonsEngineer.bx2.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        try{Thread.sleep(25);}catch(InterruptedException e){}

        txt.setText(panelKey.buttonsEngineer.strInput.trim());
        locate=panelKey.buttonsEngineer.bPlus.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        try{Thread.sleep(25);}catch(InterruptedException e){}


        txt.setText(panelKey.buttonsEngineer.strInput.trim());
        locate=panelKey.buttonsEngineer.b3.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        try{Thread.sleep(25);}catch(InterruptedException e){}

        txt.setText(panelKey.buttonsEngineer.strInput.trim());
        locate=panelKey.buttonsEngineer.bx2.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        try{Thread.sleep(25);}catch(InterruptedException e){}

        //2(2²+3²
        assertEquals("2*(2²+3²", panelKey.buttonsEngineer.strInput.trim());
        assertEquals("26", panelKey.buttonsEngineer.countResult);
    }


    @Test //±5
    void exchangeSign_positive()  {
        locate=panelKey.buttonsEngineer.b5.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        try{Thread.sleep(25);}catch(InterruptedException e){}

        txt.setText(panelKey.buttonsEngineer.strInput.trim());
        locate=panelKey.buttonsEngineer.bChageSign.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        try{Thread.sleep(25);}catch(InterruptedException e){}

        //±5
        assertEquals("±(5)", panelKey.buttonsEngineer.strInput.trim());
        assertEquals("-5", panelKey.buttonsEngineer.countResult);
    }
    @Test //±2(5-8)
    void exchangeSign_negative()  {
        locate=panelKey.buttonsEngineer.b2.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        try{Thread.sleep(25);}catch(InterruptedException e){}

        txt.setText(panelKey.buttonsEngineer.strInput.trim());
        locate=panelKey.buttonsEngineer.braceOpen.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        try{Thread.sleep(25);}catch(InterruptedException e){}

        txt.setText(panelKey.buttonsEngineer.strInput.trim());
        locate=panelKey.buttonsEngineer.b5.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        try{Thread.sleep(25);}catch(InterruptedException e){}

        txt.setText(panelKey.buttonsEngineer.strInput.trim());
        locate=panelKey.buttonsEngineer.bMinus.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        try{Thread.sleep(50);}catch(InterruptedException e){}

        txt.setText(panelKey.buttonsEngineer.strInput.trim());
        locate=panelKey.buttonsEngineer.b8.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        try{Thread.sleep(25);}catch(InterruptedException e){}

        txt.setText(panelKey.buttonsEngineer.strInput.trim());
        locate=panelKey.buttonsEngineer.braceClose.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        try{Thread.sleep(25);}catch(InterruptedException e){}

        txt.setText(panelKey.buttonsEngineer.strInput.trim());
        locate=panelKey.buttonsEngineer.bChageSign.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        try{Thread.sleep(25);}catch(InterruptedException e){}

        //±2*(5-8)
        assertEquals("±(2*(5-8))", panelKey.buttonsEngineer.strInput.trim());
        assertEquals("6", panelKey.buttonsEngineer.countResult);
    }


    @Test // 5^3
    void powerN()  {
        locate=panelKey.buttonsEngineer.b5.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        try{Thread.sleep(25);}catch(InterruptedException e){}

        txt.setText(panelKey.buttonsEngineer.strInput.trim());
        locate=panelKey.buttonsEngineer.bxn.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        try{Thread.sleep(50);}catch(InterruptedException e){}

        txt.setText(panelKey.buttonsEngineer.strInput.trim());
        locate=panelKey.buttonsEngineer.b3.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        try{Thread.sleep(25);}catch(InterruptedException e){}
        // 5^3
        assertEquals("5^3", panelKey.buttonsEngineer.strInput.trim());
        assertEquals("125", panelKey.buttonsEngineer.countResult);
    }
    @Test // 0^(3-4)
     void powerN_Exception()  {
        locate=panelKey.buttonsEngineer.b0.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        try{Thread.sleep(25);}catch(InterruptedException e){}

        txt.setText(panelKey.buttonsEngineer.strInput.trim());
        locate=panelKey.buttonsEngineer.bxn.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        try{Thread.sleep(50);}catch(InterruptedException e){}

        txt.setText(panelKey.buttonsEngineer.strInput.trim());
        locate=panelKey.buttonsEngineer.braceOpen.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        try{Thread.sleep(25);}catch(InterruptedException e){}

        txt.setText(panelKey.buttonsEngineer.strInput.trim());
        locate=panelKey.buttonsEngineer.b3.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        try{Thread.sleep(25);}catch(InterruptedException e){}

        txt.setText(panelKey.buttonsEngineer.strInput.trim());
        locate=panelKey.buttonsEngineer.bMinus.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        try{Thread.sleep(25);}catch(InterruptedException e){}

        txt.setText(panelKey.buttonsEngineer.strInput.trim());
        locate=panelKey.buttonsEngineer.b4.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        try{Thread.sleep(25);}catch(InterruptedException e){}

        // 0^(3-4)
        assertEquals("0^(3-4", panelKey.buttonsEngineer.strInput.trim());
        assertEquals("делить на 0 нельзя", panelKey.buttonsEngineer.strResult);
    }



    @Test // 5 и 1/x
     void divideForX()  {
        locate=panelKey.buttonsEngineer.b5.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        try{Thread.sleep(25);}catch(InterruptedException e){}

         txt.setText(panelKey.buttonsEngineer.strInput.trim());
        locate=panelKey.buttonsEngineer.bDivX.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        try{Thread.sleep(50);}catch(InterruptedException e){}

        // 5 и 1/x
        assertEquals("5^(-1)", panelKey.buttonsEngineer.strInput.trim());
        assertEquals("0.2", panelKey.buttonsEngineer.countResult);
    }
     @Test // 0^(-1)
    void divideForX_Exception()  {
        locate=panelKey.buttonsEngineer.b0.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        try{Thread.sleep(25);}catch(InterruptedException e){}

        txt.setText(panelKey.buttonsEngineer.strInput.trim());
        locate=panelKey.buttonsEngineer.bDivX.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        try{Thread.sleep(50);}catch(InterruptedException e){}


        // 0^(-1)
        assertEquals("0^(-1)", panelKey.buttonsEngineer.strInput.trim());
        assertEquals("делить на 0 нельзя", panelKey.buttonsEngineer.strResult);
    }



     @Test //5!
    void factorial ()  {
        locate=panelKey.buttonsEngineer.b5.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        try{Thread.sleep(40);}catch(InterruptedException e){}

        txt.setText(panelKey.buttonsEngineer.strInput.trim());
        locate=panelKey.buttonsEngineer.bFactorial.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        try{Thread.sleep(40);}catch(InterruptedException e){}
//5!
        assertEquals("5!", panelKey.buttonsEngineer.strInput.trim());
        assertEquals("120", panelKey.buttonsEngineer.countResult);
    }
     @Test    //5²!
    void x2_factorial()  {
        locate=panelKey.buttonsEngineer.b5.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        try{Thread.sleep(25);}catch(InterruptedException e){}

        txt.setText(panelKey.buttonsEngineer.strInput.trim());
        locate=panelKey.buttonsEngineer.bx2.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        try{Thread.sleep(25);}catch(InterruptedException e){}

        txt.setText(panelKey.buttonsEngineer.strInput.trim());
        locate=panelKey.buttonsEngineer.bFactorial.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        try{Thread.sleep(25);}catch(InterruptedException e){}
//5²!
        assertEquals("5!", panelKey.buttonsEngineer.strInput.trim());
        assertEquals("120", panelKey.buttonsEngineer.countResult);
    }
     @Test //5!²
    void factorial_x2()  {
        locate=panelKey.buttonsEngineer.b5.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        try{Thread.sleep(50);}catch(InterruptedException e){}

        txt.setText(panelKey.buttonsEngineer.strInput.trim());
        locate=panelKey.buttonsEngineer.bFactorial.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        try{Thread.sleep(25);}catch(InterruptedException e){}

        txt.setText(panelKey.buttonsEngineer.strInput.trim());
        locate=panelKey.buttonsEngineer.bx2.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        try{Thread.sleep(25);}catch(InterruptedException e){}
//5!²
        assertEquals("5²", panelKey.buttonsEngineer.strInput.trim());
        assertEquals("25", panelKey.buttonsEngineer.countResult);
    }
     @Test //    3.2!
    void factorial_double()  {
        locate=panelKey.buttonsEngineer.b3.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        try{Thread.sleep(40);}catch(InterruptedException e){}

        txt.setText(panelKey.buttonsEngineer.strInput.trim());
        locate=panelKey.buttonsEngineer.bPoint.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        try{Thread.sleep(25);}catch(InterruptedException e){}

        txt.setText(panelKey.buttonsEngineer.strInput.trim());
        locate=panelKey.buttonsEngineer.b2.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        try{Thread.sleep(25);}catch(InterruptedException e){}

        txt.setText(panelKey.buttonsEngineer.strInput.trim());
        locate=panelKey.buttonsEngineer.bFactorial.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        try{Thread.sleep(50);}catch(InterruptedException e){}
//  3.2!
        assertEquals("3.2!", panelKey.buttonsEngineer.strInput.trim());
        assertEquals("неверный формат ввода факториала", panelKey.buttonsEngineer.strResult);
    }
     @Test //    -2!
    void factorial_negativeNumber()  {
        locate=panelKey.buttonsEngineer.braceOpen.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        try{Thread.sleep(25);}catch(InterruptedException e){}

        txt.setText(panelKey.buttonsEngineer.strInput.trim());
        locate=panelKey.buttonsEngineer.b0.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        try{Thread.sleep(25);}catch(InterruptedException e){}

        txt.setText(panelKey.buttonsEngineer.strInput.trim());
        locate=panelKey.buttonsEngineer.bMinus.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        try{Thread.sleep(25);}catch(InterruptedException e){}

        txt.setText(panelKey.buttonsEngineer.strInput.trim());
        locate=panelKey.buttonsEngineer.b2.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        try{Thread.sleep(25);}catch(InterruptedException e){}

        txt.setText(panelKey.buttonsEngineer.strInput.trim());
        locate=panelKey.buttonsEngineer.braceClose.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        try{Thread.sleep(25);}catch(InterruptedException e){}

        txt.setText(panelKey.buttonsEngineer.strInput.trim());
        locate=panelKey.buttonsEngineer.bFactorial.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        try{Thread.sleep(25);}catch(InterruptedException e){}
//  -2!
        assertEquals("(0-2)!", panelKey.buttonsEngineer.strInput.trim());
        assertEquals("неверный формат ввода факториала", panelKey.buttonsEngineer.strResult);
    }






     @Test //    ³√(9^999
    void sqrt3_bigDecimal_exception()  {
        locate=panelKey.buttonsEngineer.bSqrt3.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        try{Thread.sleep(50);}catch(InterruptedException e){}

        txt.setText(panelKey.buttonsEngineer.strInput.trim());
        locate=panelKey.buttonsEngineer.braceOpen.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        try{Thread.sleep(25);}catch(InterruptedException e){}

        txt.setText(panelKey.buttonsEngineer.strInput.trim());
        locate=panelKey.buttonsEngineer.b9.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        try{Thread.sleep(25);}catch(InterruptedException e){}

        txt.setText(panelKey.buttonsEngineer.strInput.trim());
        locate=panelKey.buttonsEngineer.bxn.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        try{Thread.sleep(40);}catch(InterruptedException e){}

        txt.setText(panelKey.buttonsEngineer.strInput.trim());
        locate=panelKey.buttonsEngineer.b9.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        try{Thread.sleep(25);}catch(InterruptedException e){}

        txt.setText(panelKey.buttonsEngineer.strInput.trim());
        locate=panelKey.buttonsEngineer.b9.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        try{Thread.sleep(25);}catch(InterruptedException e){}

        txt.setText(panelKey.buttonsEngineer.strInput.trim());
        locate=panelKey.buttonsEngineer.b9.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        try{Thread.sleep(50);}catch(InterruptedException e){}

//  ³√(9^999
        assertEquals("³√((9^999", panelKey.buttonsEngineer.strInput.trim());
        assertEquals("³√ недозволеного большого числа", panelKey.buttonsEngineer.strResult);
    }
     @Test //    2³√(8
    void sqrt3_afterNumber()  {
        locate=panelKey.buttonsEngineer.b2.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        try{Thread.sleep(25);}catch(InterruptedException e){}

        txt.setText(panelKey.buttonsEngineer.strInput.trim());
        locate=panelKey.buttonsEngineer.bSqrt3.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        try{Thread.sleep(50);}catch(InterruptedException e){}



        txt.setText(panelKey.buttonsEngineer.strInput.trim());
        locate=panelKey.buttonsEngineer.b8.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        try{Thread.sleep(25);}catch(InterruptedException e){}


//  2³√(8
        assertEquals("2*³√(8", panelKey.buttonsEngineer.strInput.trim());
        assertEquals("=4", panelKey.buttonsEngineer.strResult);
    }

     @Test //    2-cos( 0
    void cos_afterSign()  {
        locate=panelKey.buttonsEngineer.b2.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        try{Thread.sleep(25);}catch(InterruptedException e){}

        txt.setText(panelKey.buttonsEngineer.strInput.trim());
        locate=panelKey.buttonsEngineer.bMinus.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        try{Thread.sleep(25);}catch(InterruptedException e){}

        txt.setText(panelKey.buttonsEngineer.strInput.trim());
        locate=panelKey.buttonsEngineer.bCos.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        try{Thread.sleep(25);}catch(InterruptedException e){}

        txt.setText(panelKey.buttonsEngineer.strInput.trim());
        locate=panelKey.buttonsEngineer.b0.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        try{Thread.sleep(25);}catch(InterruptedException e){}

//  2-cos( 0
        assertEquals("2-cos(0", panelKey.buttonsEngineer.strInput.trim());
        assertEquals("=1", panelKey.buttonsEngineer.strResult);
    }
     @Test //    2cos( 0
    void cos_afterNumber()  {
        locate=panelKey.buttonsEngineer.b2.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        try{Thread.sleep(25);}catch(InterruptedException e){}

        txt.setText(panelKey.buttonsEngineer.strInput.trim());
        locate=panelKey.buttonsEngineer.bCos.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        try{Thread.sleep(25);}catch(InterruptedException e){}

        txt.setText(panelKey.buttonsEngineer.strInput.trim());
        locate=panelKey.buttonsEngineer.b0.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        try{Thread.sleep(25);}catch(InterruptedException e){}

//  2*cos( 0
        assertEquals("2*cos(0", panelKey.buttonsEngineer.strInput.trim());
        assertEquals("=2", panelKey.buttonsEngineer.strResult);
    }
     @Test //    2-sin( 30
    void sin_afterSign()  {
        locate=panelKey.buttonsEngineer.b2.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        try{Thread.sleep(25);}catch(InterruptedException e){}

        txt.setText(panelKey.buttonsEngineer.strInput.trim());
        locate=panelKey.buttonsEngineer.bMinus.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        try{Thread.sleep(25);}catch(InterruptedException e){}

        txt.setText(panelKey.buttonsEngineer.strInput.trim());
        locate=panelKey.buttonsEngineer.bSin.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        try{Thread.sleep(25);}catch(InterruptedException e){}

        txt.setText(panelKey.buttonsEngineer.strInput.trim());
        locate=panelKey.buttonsEngineer.b3.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        try{Thread.sleep(25);}catch(InterruptedException e){}

        txt.setText(panelKey.buttonsEngineer.strInput.trim());
        locate=panelKey.buttonsEngineer.b0.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        try{Thread.sleep(25);}catch(InterruptedException e){}

//  2-sin( 30
        assertEquals("2-sin(30", panelKey.buttonsEngineer.strInput.trim());
        assertEquals("=1.5", panelKey.buttonsEngineer.strResult);
    }
     @Test //    2-sin( 30
    void sin_afterNumber()  {
        locate=panelKey.buttonsEngineer.b2.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        try{Thread.sleep(25);}catch(InterruptedException e){}

        txt.setText(panelKey.buttonsEngineer.strInput.trim());
        locate=panelKey.buttonsEngineer.bSin.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        try{Thread.sleep(25);}catch(InterruptedException e){}

        txt.setText(panelKey.buttonsEngineer.strInput.trim());
        locate=panelKey.buttonsEngineer.b3.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        try{Thread.sleep(25);}catch(InterruptedException e){}

        txt.setText(panelKey.buttonsEngineer.strInput.trim());
        locate=panelKey.buttonsEngineer.b0.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        try{Thread.sleep(25);}catch(InterruptedException e){}

//  2*sin(30
        assertEquals("2*sin(30", panelKey.buttonsEngineer.strInput.trim());
        assertEquals("=1", panelKey.buttonsEngineer.strResult);
    }




     @Test //    2-lg(45
    void tg_afterSign()  {
        locate=panelKey.buttonsEngineer.b2.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        try{Thread.sleep(25);}catch(InterruptedException e){}

        txt.setText(panelKey.buttonsEngineer.strInput.trim());
        locate=panelKey.buttonsEngineer.bMinus.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        try{Thread.sleep(25);}catch(InterruptedException e){}

        txt.setText(panelKey.buttonsEngineer.strInput.trim());
        locate=panelKey.buttonsEngineer.bTg.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        try{Thread.sleep(25);}catch(InterruptedException e){}

        txt.setText(panelKey.buttonsEngineer.strInput.trim());
        locate=panelKey.buttonsEngineer.b4.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        try{Thread.sleep(25);}catch(InterruptedException e){}

        txt.setText(panelKey.buttonsEngineer.strInput.trim());
        locate=panelKey.buttonsEngineer.b5.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        try{Thread.sleep(25);}catch(InterruptedException e){}

//  2-lg(45 (=1)
        assertEquals("2-tg(45", panelKey.buttonsEngineer.strInput.trim());
        assertEquals("=1", panelKey.buttonsEngineer.strResult);
    }
     @Test //    2tg(45
    void tg_afterNumber()  {
        locate=panelKey.buttonsEngineer.b2.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        try{Thread.sleep(25);}catch(InterruptedException e){}

        txt.setText(panelKey.buttonsEngineer.strInput.trim());
        locate=panelKey.buttonsEngineer.bTg.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        try{Thread.sleep(25);}catch(InterruptedException e){}

        txt.setText(panelKey.buttonsEngineer.strInput.trim());
        locate=panelKey.buttonsEngineer.b4.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        try{Thread.sleep(25);}catch(InterruptedException e){}

        txt.setText(panelKey.buttonsEngineer.strInput.trim());
        locate=panelKey.buttonsEngineer.b5.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        try{Thread.sleep(25);}catch(InterruptedException e){}

//  2tg(45
        assertEquals("2*tg(45", panelKey.buttonsEngineer.strInput.trim());
        assertEquals("=2", panelKey.buttonsEngineer.strResult);
    }
     @Test //    tg(9^999
    void tg_exception_overflow()  {
        txt.setText(panelKey.buttonsEngineer.strInput.trim());
        locate=panelKey.buttonsEngineer.b1.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        try{Thread.sleep(25);}catch(InterruptedException e){}

        txt.setText(panelKey.buttonsEngineer.strInput.trim());
        locate=panelKey.buttonsEngineer.bTg.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        try{Thread.sleep(50);}catch(InterruptedException e){}

        txt.setText(panelKey.buttonsEngineer.strInput.trim());
        locate=panelKey.buttonsEngineer.b9.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        try{Thread.sleep(25);}catch(InterruptedException e){}

        txt.setText(panelKey.buttonsEngineer.strInput.trim());
        locate=panelKey.buttonsEngineer.bxn.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        try{Thread.sleep(40);}catch(InterruptedException e){}

        txt.setText(panelKey.buttonsEngineer.strInput.trim());
        locate=panelKey.buttonsEngineer.b9.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        try{Thread.sleep(25);}catch(InterruptedException e){}

        txt.setText(panelKey.buttonsEngineer.strInput.trim());
        locate=panelKey.buttonsEngineer.b9.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        try{Thread.sleep(25);}catch(InterruptedException e){}

        txt.setText(panelKey.buttonsEngineer.strInput.trim());
        locate=panelKey.buttonsEngineer.b9.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        try{Thread.sleep(50);}catch(InterruptedException e){}

//  tg(9^999
        assertEquals("1*tg(9^999", panelKey.buttonsEngineer.strInput.trim());
        assertEquals("tg недозволеного большого числа", panelKey.buttonsEngineer.strResult);
    }
     @Test //    tg(90
    void tg_exception_NaN()  {
        locate=panelKey.buttonsEngineer.bTg.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        try{Thread.sleep(50);}catch(InterruptedException e){}

        txt.setText(panelKey.buttonsEngineer.strInput.trim());
        locate=panelKey.buttonsEngineer.b9.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        try{Thread.sleep(25);}catch(InterruptedException e){}

        txt.setText(panelKey.buttonsEngineer.strInput.trim());
        locate=panelKey.buttonsEngineer.b0.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        try{Thread.sleep(50);}catch(InterruptedException e){}

//   tg(90
        assertEquals("tg(90", panelKey.buttonsEngineer.strInput.trim());
        assertEquals("tg не определен", panelKey.buttonsEngineer.strResult);
    }



     @Test //    2-lg(100
    void lg_afterSign()  {
        locate=panelKey.buttonsEngineer.b2.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        try{Thread.sleep(25);}catch(InterruptedException e){}

        txt.setText(panelKey.buttonsEngineer.strInput.trim());
        locate=panelKey.buttonsEngineer.bMinus.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        try{Thread.sleep(25);}catch(InterruptedException e){}

        txt.setText(panelKey.buttonsEngineer.strInput.trim());
        locate=panelKey.buttonsEngineer.bLg.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        try{Thread.sleep(25);}catch(InterruptedException e){}

        txt.setText(panelKey.buttonsEngineer.strInput.trim());
        locate=panelKey.buttonsEngineer.b1.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        try{Thread.sleep(25);}catch(InterruptedException e){}

        txt.setText(panelKey.buttonsEngineer.strInput.trim());
        locate=panelKey.buttonsEngineer.b0.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        try{Thread.sleep(25);}catch(InterruptedException e){}

        txt.setText(panelKey.buttonsEngineer.strInput.trim());
        locate=panelKey.buttonsEngineer.b0.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        try{Thread.sleep(25);}catch(InterruptedException e){}

//  2-lg(100
        assertEquals("2-lg(100", panelKey.buttonsEngineer.strInput.trim());
        assertEquals("=0", panelKey.buttonsEngineer.strResult);
    }
     @Test //    2lg(100
    void lg_afterNumber()  {
        locate=panelKey.buttonsEngineer.b2.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        try{Thread.sleep(25);}catch(InterruptedException e){}

        txt.setText(panelKey.buttonsEngineer.strInput.trim());
        locate=panelKey.buttonsEngineer.bLg.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        try{Thread.sleep(25);}catch(InterruptedException e){}

        txt.setText(panelKey.buttonsEngineer.strInput.trim());
        locate=panelKey.buttonsEngineer.b1.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        try{Thread.sleep(25);}catch(InterruptedException e){}

        txt.setText(panelKey.buttonsEngineer.strInput.trim());
        locate=panelKey.buttonsEngineer.b0.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        try{Thread.sleep(25);}catch(InterruptedException e){}

        txt.setText(panelKey.buttonsEngineer.strInput.trim());
        locate=panelKey.buttonsEngineer.b0.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        try{Thread.sleep(25);}catch(InterruptedException e){}

//  2lg(100
        assertEquals("2*lg(100", panelKey.buttonsEngineer.strInput.trim());
        assertEquals("=4", panelKey.buttonsEngineer.strResult);
    }
     @Test //    lg(9^999
    void lg_exception_overflow()  {
        locate=panelKey.buttonsEngineer.bLg.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        try{Thread.sleep(50);}catch(InterruptedException e){}

        txt.setText(panelKey.buttonsEngineer.strInput.trim());
        locate=panelKey.buttonsEngineer.b9.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        try{Thread.sleep(25);}catch(InterruptedException e){}

        txt.setText(panelKey.buttonsEngineer.strInput.trim());
        locate=panelKey.buttonsEngineer.bxn.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        try{Thread.sleep(40);}catch(InterruptedException e){}

        txt.setText(panelKey.buttonsEngineer.strInput.trim());
        locate=panelKey.buttonsEngineer.b9.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        try{Thread.sleep(25);}catch(InterruptedException e){}

        txt.setText(panelKey.buttonsEngineer.strInput.trim());
        locate=panelKey.buttonsEngineer.b9.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        try{Thread.sleep(25);}catch(InterruptedException e){}

        txt.setText(panelKey.buttonsEngineer.strInput.trim());
        locate=panelKey.buttonsEngineer.b9.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        try{Thread.sleep(50);}catch(InterruptedException e){}

//  lg(9^999
        assertEquals("lg(9^999", panelKey.buttonsEngineer.strInput.trim());
        assertEquals("lg недозволеного большого числа", panelKey.buttonsEngineer.strResult);
    }
     @Test //    lg(1-4
    void lg_exception_NaN()  {
        locate=panelKey.buttonsEngineer.bLg.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        try{Thread.sleep(50);}catch(InterruptedException e){}

        txt.setText(panelKey.buttonsEngineer.strInput.trim());
        locate=panelKey.buttonsEngineer.b1.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        try{Thread.sleep(25);}catch(InterruptedException e){}

        txt.setText(panelKey.buttonsEngineer.strInput.trim());
        locate=panelKey.buttonsEngineer.bMinus.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        try{Thread.sleep(25);}catch(InterruptedException e){}

        txt.setText(panelKey.buttonsEngineer.strInput.trim());
        locate=panelKey.buttonsEngineer.b4.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        try{Thread.sleep(50);}catch(InterruptedException e){}

//  lg(1-4
        assertEquals("lg(1-4", panelKey.buttonsEngineer.strInput.trim());
        assertEquals("lg не определен", panelKey.buttonsEngineer.strResult);
    }
     @Test //    lg(0
    void lg_exception_0()  {

        locate=panelKey.buttonsEngineer.b1.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        try{Thread.sleep(25);}catch(InterruptedException e){}

        txt.setText(panelKey.buttonsEngineer.strInput.trim());
        locate=panelKey.buttonsEngineer.bLg.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        try{Thread.sleep(50);}catch(InterruptedException e){}

        txt.setText(panelKey.buttonsEngineer.strInput.trim());
        locate=panelKey.buttonsEngineer.b0.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        try{Thread.sleep(25);}catch(InterruptedException e){}

//  lg(0
        assertEquals("1*lg(0", panelKey.buttonsEngineer.strInput.trim());
        assertEquals("lg не определен", panelKey.buttonsEngineer.strResult);
    }




     @Test //    2-ln(1
    void ln_afterSign()  {
        locate=panelKey.buttonsEngineer.b2.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        try{Thread.sleep(25);}catch(InterruptedException e){}

        txt.setText(panelKey.buttonsEngineer.strInput.trim());
        locate=panelKey.buttonsEngineer.bMinus.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        try{Thread.sleep(25);}catch(InterruptedException e){}

        txt.setText(panelKey.buttonsEngineer.strInput.trim());
        locate=panelKey.buttonsEngineer.bLn.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        try{Thread.sleep(25);}catch(InterruptedException e){}

        txt.setText(panelKey.buttonsEngineer.strInput.trim());
        locate=panelKey.buttonsEngineer.b1.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        try{Thread.sleep(25);}catch(InterruptedException e){}

//  2-ln(1
        assertEquals("2-ln(1", panelKey.buttonsEngineer.strInput.trim());
        assertEquals("=2", panelKey.buttonsEngineer.strResult);
    }
     @Test //    2ln(1
    void ln_afterNumber()  {
        locate=panelKey.buttonsEngineer.b2.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        try{Thread.sleep(25);}catch(InterruptedException e){}

        txt.setText(panelKey.buttonsEngineer.strInput.trim());
        locate=panelKey.buttonsEngineer.bLn.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        try{Thread.sleep(25);}catch(InterruptedException e){}

        txt.setText(panelKey.buttonsEngineer.strInput.trim());
        locate=panelKey.buttonsEngineer.b1.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        try{Thread.sleep(25);}catch(InterruptedException e){}


//  2ln(1
        assertEquals("2*ln(1", panelKey.buttonsEngineer.strInput.trim());
        assertEquals("=0", panelKey.buttonsEngineer.strResult);
    }
     @Test //    ln(9^999
    void ln_exception_overflow()  {

        locate=panelKey.buttonsEngineer.b1.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        try{Thread.sleep(25);}catch(InterruptedException e){}

        txt.setText(panelKey.buttonsEngineer.strInput.trim());
        locate=panelKey.buttonsEngineer.bLn.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        try{Thread.sleep(50);}catch(InterruptedException e){}

        txt.setText(panelKey.buttonsEngineer.strInput.trim());
        locate=panelKey.buttonsEngineer.b9.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        try{Thread.sleep(25);}catch(InterruptedException e){}

        txt.setText(panelKey.buttonsEngineer.strInput.trim());
        locate=panelKey.buttonsEngineer.bxn.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        try{Thread.sleep(40);}catch(InterruptedException e){}

        txt.setText(panelKey.buttonsEngineer.strInput.trim());
        locate=panelKey.buttonsEngineer.b9.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        try{Thread.sleep(25);}catch(InterruptedException e){}

        txt.setText(panelKey.buttonsEngineer.strInput.trim());
        locate=panelKey.buttonsEngineer.b9.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        try{Thread.sleep(25);}catch(InterruptedException e){}

        txt.setText(panelKey.buttonsEngineer.strInput.trim());
        locate=panelKey.buttonsEngineer.b9.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        try{Thread.sleep(50);}catch(InterruptedException e){}

//  ln(9^999
        assertEquals("1*ln(9^999", panelKey.buttonsEngineer.strInput.trim());
        assertEquals("ln недозволеного большого числа", panelKey.buttonsEngineer.strResult);
    }
     @Test //    ln(1-4
    void ln_exception_NaN()  {
        locate=panelKey.buttonsEngineer.bLn.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        try{Thread.sleep(50);}catch(InterruptedException e){}

        txt.setText(panelKey.buttonsEngineer.strInput.trim());
        locate=panelKey.buttonsEngineer.b1.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        try{Thread.sleep(25);}catch(InterruptedException e){}

        txt.setText(panelKey.buttonsEngineer.strInput.trim());
        locate=panelKey.buttonsEngineer.bMinus.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        try{Thread.sleep(25);}catch(InterruptedException e){}

        txt.setText(panelKey.buttonsEngineer.strInput.trim());
        locate=panelKey.buttonsEngineer.b4.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        try{Thread.sleep(50);}catch(InterruptedException e){}

//  ln(1-4
        assertEquals("ln(1-4", panelKey.buttonsEngineer.strInput.trim());
        assertEquals("ln не определен", panelKey.buttonsEngineer.strResult);
    }
     @Test //    ln(0
    void ln_exception_0()  {
        locate=panelKey.buttonsEngineer.bLn.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        try{Thread.sleep(50);}catch(InterruptedException e){}

        txt.setText(panelKey.buttonsEngineer.strInput.trim());
        locate=panelKey.buttonsEngineer.b0.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        try{Thread.sleep(25);}catch(InterruptedException e){}

//  ln(0
        assertEquals("ln(0", panelKey.buttonsEngineer.strInput.trim());
        assertEquals("ln не определен", panelKey.buttonsEngineer.strResult);
    }
     @Test //    1*(1*(1+1
    void braces_inLogPanel()  {
        locate=panelKey.buttonsEngineer.b1.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        try{Thread.sleep(50);}catch(InterruptedException e){}

        txt.setText(panelKey.buttonsEngineer.strInput.trim());
        locate=panelKey.buttonsEngineer.braceOpen.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        try{Thread.sleep(25);}catch(InterruptedException e){}

        txt.setText(panelKey.buttonsEngineer.strInput.trim());
        locate=panelKey.buttonsEngineer.b1.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        try{Thread.sleep(50);}catch(InterruptedException e){}

        txt.setText(panelKey.buttonsEngineer.strInput.trim());
        locate=panelKey.buttonsEngineer.braceOpen.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        try{Thread.sleep(25);}catch(InterruptedException e){}

        txt.setText(panelKey.buttonsEngineer.strInput.trim());
        locate=panelKey.buttonsEngineer.b1.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        try{Thread.sleep(50);}catch(InterruptedException e){}

        txt.setText(panelKey.buttonsEngineer.strInput.trim());
        locate=panelKey.buttonsEngineer.bPlus.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        try{Thread.sleep(50);}catch(InterruptedException e){}

        txt.setText(panelKey.buttonsEngineer.strInput.trim());
        locate=panelKey.buttonsEngineer.b1.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        try{Thread.sleep(50);}catch(InterruptedException e){}

//   1*(1*(1+1
        assertEquals("1*(1*(1+1", panelKey.buttonsEngineer.strInput.trim());
        assertEquals(2, panelKey.buttonsEngineer.countBrace);
    }



    @Test //    ±(7)²
    void countSqrt2_after_exchangeSign()  {
        locate=panelKey.buttonsEngineer.b7.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        try{Thread.sleep(50);}catch(InterruptedException e){}

        txt.setText(panelKey.buttonsEngineer.strInput.trim());
        locate=panelKey.buttonsEngineer.bChageSign.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        try{Thread.sleep(25);}catch(InterruptedException e){}

        txt.setText(panelKey.buttonsEngineer.strInput.trim());
        locate=panelKey.buttonsEngineer.bx2.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        try{Thread.sleep(50);}catch(InterruptedException e){}


//   ±(7)²
        assertEquals("(-7)²", panelKey.buttonsEngineer.strInput.trim());
        assertEquals("49", panelKey.buttonsEngineer.countResult);
    }
    @Test //    ±(7)+2
    void countSum_after_exchangeSign()  {
        locate=panelKey.buttonsEngineer.b7.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        try{Thread.sleep(50);}catch(InterruptedException e){}

        txt.setText(panelKey.buttonsEngineer.strInput.trim());
        locate=panelKey.buttonsEngineer.bChageSign.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        try{Thread.sleep(25);}catch(InterruptedException e){}

        txt.setText(panelKey.buttonsEngineer.strInput.trim());
        locate=panelKey.buttonsEngineer.bPlus.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        try{Thread.sleep(50);}catch(InterruptedException e){}

        txt.setText(panelKey.buttonsEngineer.strInput.trim());
        locate=panelKey.buttonsEngineer.b2.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        try{Thread.sleep(50);}catch(InterruptedException e){}


//   ±(7)+2
        assertEquals("-7+2", panelKey.buttonsEngineer.strInput.trim());
        assertEquals("-5", panelKey.buttonsEngineer.countResult);
    }

}