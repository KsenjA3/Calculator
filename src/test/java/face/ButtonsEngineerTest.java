package face;


import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import javax.swing.*;
import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

import static org.junit.jupiter.api.Assertions.*;


//@ExtendWith(MockitoExtension.class)
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
        Mockito.doNothing().when(textPanel).setTextInput(Mockito.any());
        Mockito.doNothing().when(textPanel).setTextResult(Mockito.any());

        Mockito.when(textPanel.getSbLog()).thenReturn(new StringBuffer(" "));
        Mockito.when(textPanel.getTextInput()).thenReturn(txt);
        Mockito.when(textPanel.getTextResult()).thenReturn(lable);
    }
    @AfterAll
     void hideFrame() {
        frame.setVisible(false);
    }
    @BeforeEach
    void init()  {
        panelKey.buttonsEngineer.strNumber=" ";
        txt.setText("");
//        panelKey.buttonsEngineer.strInput="";

        panelKey.buttonsEngineer.unblockedAll(panelKey.buttonsEngineer.b0,panelKey.buttonsEngineer.b1,panelKey.buttonsEngineer.b2,
                panelKey.buttonsEngineer.b3,panelKey.buttonsEngineer.b4,panelKey.buttonsEngineer.b5,panelKey.buttonsEngineer.b6,
                panelKey.buttonsEngineer.b7,panelKey.buttonsEngineer.b8,panelKey.buttonsEngineer.b9,panelKey.buttonsEngineer.bPoint,
                panelKey.buttonsEngineer.bPi,panelKey.buttonsEngineer.bPercent,panelKey.buttonsEngineer.bRadical);

    }



    @Test //2+PI
    void PI_afterSign()  {

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
        try{Thread.sleep(25);}catch(InterruptedException e){}

        txt.setText(panelKey.buttonsEngineer.strInput.trim());
        locate=panelKey.buttonsEngineer.bPi.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        try{Thread.sleep(25);}catch(InterruptedException e){}

        //2+PI
        assertEquals("2+3.141592653589793", panelKey.buttonsEngineer.strInput);
        assertEquals(5.1415926535, panelKey.buttonsEngineer.dResult, 0.0000000001);
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
        assertEquals(11.283185307, panelKey.buttonsEngineer.dResult, 0.000000001);
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
        assertEquals(6.283185307, panelKey.buttonsEngineer.dResult, 0.000000001);
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
        try{Thread.sleep(25);}catch(InterruptedException e){}

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
        assertEquals(31.415926535, panelKey.buttonsEngineer.dResult, 0.000000001);
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
        assertEquals(25, panelKey.buttonsEngineer.dResult, 0.000000001);
    }
    @Test //2²+3²
    void x2_plus_x2()  {
        bot.keyPress(KeyEvent.VK_2);
        try {Thread.sleep(10);} catch (InterruptedException e) {}
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
        assertEquals(13, panelKey.buttonsEngineer.dResult, 0.000000001);
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
        assertEquals(50, panelKey.buttonsEngineer.dResult, 0.000000001);
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
        assertEquals(26, panelKey.buttonsEngineer.dResult, 0.000000001);
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
        assertEquals(-5, panelKey.buttonsEngineer.dResult, 0.000000001);
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
        assertEquals(6, panelKey.buttonsEngineer.dResult, 0.000000001);
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
        assertEquals(125, panelKey.buttonsEngineer.dResult, 0.000000001);
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
        assertEquals(0.2, panelKey.buttonsEngineer.dResult, 0.000000001);
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




//    @ParameterizedTest
//    @CsvSource( value =  {
//            " =1,   1",
//            " =2,   2",
//            " =3,   6",
//            " =5,   120",
//            " =0,   1",
//
//    })
//     void factorial(String strResult, double expectedResult)  {
////        Mockito.when(textPanel.getStrResult()).thenReturn(strResult);
//
//        locate=panelKey.buttonsEngineer.bFactorial.getLocationOnScreen();
//        bot.mouseMove(locate.x+10,locate.y+10);
//        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
//        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
//        try{Thread.sleep(50);}catch(InterruptedException e){}
//
//        assertEquals(expectedResult, panelKey.buttonsEngineer.dResult, 0.000000001);
//    }
//
//    @Test
//    void factorial_Exception()  {
////        Mockito.when(textPanel.getStrResult()).thenReturn("2.5");
//        Throwable ex = assertThrows(
//                NumberFormatException.class,
//                ()->{
//                    locate=panelKey.buttonsEngineer.bFactorial.getLocationOnScreen();
//                    bot.mouseMove(locate.x+10,locate.y+10);
//                    bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
//                    bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
//                    try{Thread.sleep(50);}catch(InterruptedException e){}
//                }
//        );
//    }






//    @ParameterizedTest
//    @CsvSource( value =  {
//            " 8,    2",
//            " -27,   -3",
//            " 15.625,   2.5",
//            " -15.625,   -2.5",
//    })
//     void sqrt3(String strResult, double expectedResult)  {
//        txt.setText(strResult);
//        Mockito.when(textPanel.getTextInput()).thenReturn(txt);
//
//        locate=panelKey.buttonsEngineer.bSqrt3.getLocationOnScreen();
//        bot.mouseMove(locate.x+10,locate.y+10);
//        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
//        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
//        try{Thread.sleep(50);}catch(InterruptedException e){}
//
//        assertEquals(expectedResult, panelKey.buttonsEngineer.dResult, 0.000000001);
//    }








//    @ParameterizedTest
//    @CsvSource( value =  {
//            " 30.0,   0.5",
//            " 90,   1.0",
//            " 0,   0.0",
//            " 45,   0.707106781",
//            " 60,   0.866025403",
//            " 120,   0.866025403",
//            " 135,   0.707106781",
//            " 270,   -1.0",
//            " 180,   0.0",
//    })
//     void sin( String strResult, double expectedResult)  {
//        txt.setText(strResult);
//        Mockito.when(textPanel.getTextInput()).thenReturn(txt);
//
//        locate=panelKey.buttonsEngineer.bSin.getLocationOnScreen();
//        bot.mouseMove(locate.x+10,locate.y+10);
//        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
//        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
//        try{Thread.sleep(50);}catch(InterruptedException e){}
//
//        assertEquals(expectedResult, panelKey.buttonsEngineer.dResult, 0.000000001);
//    }
//
//    @ParameterizedTest
//    @CsvSource( value =  {
//            " 30,    0.866025403",
//            " 90,   0.0",
//            " 0,   1.0",
//            " 45,   0.707106781",
//            " 60,   0.5",
//            " 120,   -0.5",
//            " 135,   -0.707106781",
//            " 270,   0.0",
//            " 180,   -1.0",
//            " 150,   -0.866025403",
//    })
//     void cos(String strResult, double expectedResult)  {
//        txt.setText(strResult);
//        Mockito.when(textPanel.getTextInput()).thenReturn(txt);
//
//        locate=panelKey.buttonsEngineer.bCos.getLocationOnScreen();
//        bot.mouseMove(locate.x+10,locate.y+10);
//        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
//        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
//        try{Thread.sleep(50);}catch(InterruptedException e){}
//
//        assertEquals(expectedResult, panelKey.buttonsEngineer.dResult, 0.000000001);
//    }
//
//    @ParameterizedTest
//    @CsvSource( value =  {
//            " 0,    0.0",
//            " 30,   0.577350269",
//            " 45,   1.0",
//            " 60,   1.732050807",
//            " 120,  -1.732050807",
//            " 135,  -1.0",
//            " 150,  -0.577350269",
//            " 180,  0.0",
//    })
//     void tg(String strResult, double expectedResult)  {
//        txt.setText(strResult);
//        Mockito.when(textPanel.getTextInput()).thenReturn(txt);
//
//        locate=panelKey.buttonsEngineer.bTg.getLocationOnScreen();
//        bot.mouseMove(locate.x+10,locate.y+10);
//        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
//        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
//        try{Thread.sleep(50);}catch(InterruptedException e){}
//
//        assertEquals(expectedResult, panelKey.buttonsEngineer.dResult, 0.000000001);
//    }
//
//
//
//    @ParameterizedTest
//    @CsvSource( value =  {
//            " 100,   2",
//            " 20,   1.301029995",
//            " 10000,   4",
//            " 25,   1.397940008",
//            " 0.25,   -0.602059991",
//    })
//     void lg(String strResult, double expectedResult)  {
//        txt.setText(strResult);
//        Mockito.when(textPanel.getTextInput()).thenReturn(txt);
//
//        locate=panelKey.buttonsEngineer.bLg.getLocationOnScreen();
//        bot.mouseMove(locate.x+10,locate.y+10);
//        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
//        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
//        try{Thread.sleep(50);}catch(InterruptedException e){}
//
//        assertEquals(expectedResult, panelKey.buttonsEngineer.dResult, 0.000000001);
//    }
//
//    @ParameterizedTest
//    @CsvSource( value =  {
//            " 1,   0",
//            " 2.718281828459,   1",
//            " 25,   3.218875824",
//            " 0.25,   -1.386294361",
//
//    })
//     void ln(String strResult, double expectedResult)  {
//        txt.setText(strResult);
//        Mockito.when(textPanel.getTextInput()).thenReturn(txt);
//
//        locate=panelKey.buttonsEngineer.bLn.getLocationOnScreen();
//        bot.mouseMove(locate.x+10,locate.y+10);
//        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
//        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
//        try{Thread.sleep(50);}catch(InterruptedException e){}
//
//        assertEquals(expectedResult, panelKey.buttonsEngineer.dResult, 0.000000001);
//    }
//    @Test
//    void ln_Exception(){
//        Throwable ex = assertThrows(
//                MyException.class,
//                ()->{
//                     txt.setText("-2");
//                     Mockito.when(textPanel.getTextInput()).thenReturn(txt);
//
//                    locate=panelKey.buttonsEngineer.bLn.getLocationOnScreen();
//                        bot.mouseMove(locate.x+10,locate.y+10);
//                        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
//                        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
//                        try{Thread.sleep(50);}catch(InterruptedException e){}
//                },
//                "no throws"
//        );
//
//        assertEquals("ln не существует", ex.getMessage());
//
//    }
//
//



}