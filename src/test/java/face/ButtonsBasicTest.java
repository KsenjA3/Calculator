package face;

import net.jcip.annotations.NotThreadSafe;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.parallel.Execution;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import javax.swing.*;
import java.awt.*;
import java.awt.event.InputEvent;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.parallel.ExecutionMode.SAME_THREAD;



//@NotThreadSafe
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

    @BeforeEach
    void initFrame()  {
        frame = new JFrame();
        frame.setSize(new Dimension(500, 300));
        panelKey =new PanelKeyEngineer(textPanel);

        frame.add(panelKey.getKeyPanel());
        frame.setVisible(true);
    }
    @BeforeAll
    void init() throws AWTException {
        MockitoAnnotations.openMocks(this);
//        frame = new JFrame();
//        frame.setSize(new Dimension(500, 300));
//        panelKey =new PanelKeyEngineer(textPanel);

//        frame.add(panelKey.getKeyPanel());
//        frame.setVisible(true);

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
        // 7√√√+ == 7+
    void exchange_fewSqrt_to_plus()  {
        locate=panelKey.buttonsEngineer.b7.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        try{Thread.sleep(50);}catch(InterruptedException e){}

        locate=panelKey.buttonsEngineer.bRadical.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        try{Thread.sleep(50);}catch(InterruptedException e){}

        locate=panelKey.buttonsEngineer.bRadical.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        try{Thread.sleep(50);}catch(InterruptedException e){}

        locate=panelKey.buttonsEngineer.bRadical.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        try{Thread.sleep(50);}catch(InterruptedException e){}

        locate=panelKey.buttonsEngineer.bPlus.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        try{Thread.sleep(50);}catch(InterruptedException e){}

        assertEquals("7+", panelKey.buttonsEngineer.strInput.trim());
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
    //2-+5
    void fewSign_OneByOne ()  {
        locate=panelKey.buttonsEngineer.b2.getLocationOnScreen();
            bot.mouseMove(locate.x+10,locate.y+10);
            bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
            bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
            try{Thread.sleep(50);}catch(InterruptedException e){}

        locate=panelKey.buttonsEngineer.bMinus.getLocationOnScreen();
            bot.mouseMove(locate.x+10,locate.y+10);
            bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
            bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
            try{Thread.sleep(50);}catch(InterruptedException e){}

        locate=panelKey.buttonsEngineer.bPlus.getLocationOnScreen();
            bot.mouseMove(locate.x+10,locate.y+10);
            bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
            bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
            try{Thread.sleep(50);}catch(InterruptedException e){}

        locate=panelKey.buttonsEngineer.b5.getLocationOnScreen();
            bot.mouseMove(locate.x+10,locate.y+10);
            bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
            bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
            try{Thread.sleep(50);}catch(InterruptedException e){}

        assertEquals("2+5", panelKey.buttonsEngineer.strInput.trim());
    }
    @Test
        //8-+/*3
    void fourSign_OneByOne ()  {
        locate=panelKey.buttonsEngineer.b8.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        try{Thread.sleep(50);}catch(InterruptedException e){}

        locate=panelKey.buttonsEngineer.bMinus.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        try{Thread.sleep(50);}catch(InterruptedException e){}

        locate=panelKey.buttonsEngineer.bPlus.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        try{Thread.sleep(50);}catch(InterruptedException e){}

        locate=panelKey.buttonsEngineer.bDivide.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        try{Thread.sleep(50);}catch(InterruptedException e){}

        locate=panelKey.buttonsEngineer.bMultiply.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        try{Thread.sleep(50);}catch(InterruptedException e){}

        locate=panelKey.buttonsEngineer.b3.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        try{Thread.sleep(50);}catch(InterruptedException e){}

        assertEquals("8*3", panelKey.buttonsEngineer.strInput.trim());
    }
    @Test
    void fiveSqrt_OneByOne ()  {
        locate=panelKey.buttonsEngineer.bRadical.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        try{Thread.sleep(50);}catch(InterruptedException e){}

        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        try{Thread.sleep(50);}catch(InterruptedException e){}

        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        try{Thread.sleep(50);}catch(InterruptedException e){}

        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        try{Thread.sleep(50);}catch(InterruptedException e){}

        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        try{Thread.sleep(50);}catch(InterruptedException e){}

        assertEquals("√√√", panelKey.buttonsEngineer.strInput.trim());
    }

    @Test
        //2(+3√+ == 2*(3+
    void exchange_Blocked_SymbolsWith_openBrace ()  {
        locate=panelKey.buttonsEngineer.b2.getLocationOnScreen();
            bot.mouseMove(locate.x+10,locate.y+10);
            bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
            bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
            try{Thread.sleep(50);}catch(InterruptedException e){}

        locate=panelKey.buttonsEngineer.braceOpen.getLocationOnScreen();
            bot.mouseMove(locate.x+10,locate.y+10);
            bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
            bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
            try{Thread.sleep(50);}catch(InterruptedException e){}

        locate=panelKey.buttonsEngineer.bPlus.getLocationOnScreen();
            bot.mouseMove(locate.x+10,locate.y+10);
            bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
            bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
            try{Thread.sleep(50);}catch(InterruptedException e){}

        locate=panelKey.buttonsEngineer.b3.getLocationOnScreen();
            bot.mouseMove(locate.x+10,locate.y+10);
            bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
            bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
            try{Thread.sleep(50);}catch(InterruptedException e){}

        locate=panelKey.buttonsEngineer.bRadical.getLocationOnScreen();
            bot.mouseMove(locate.x+10,locate.y+10);
            bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
            bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
            try{Thread.sleep(50);}catch(InterruptedException e){}

        locate=panelKey.buttonsEngineer.bPlus.getLocationOnScreen();
            bot.mouseMove(locate.x+10,locate.y+10);
            bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
            bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
            try{Thread.sleep(50);}catch(InterruptedException e){}

        assertEquals("2*(3+", panelKey.buttonsEngineer.strInput.trim());
    }

    @Test
        //2+8+(9-(2-5)-(2+8)%
    void percent()  {
        locate=panelKey.buttonsEngineer.b2.getLocationOnScreen();
        bot.mouseMove(locate.x,locate.y);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        try{Thread.sleep(50);}catch(InterruptedException e){}

        locate=panelKey.buttonsEngineer.bPlus.getLocationOnScreen();
        bot.mouseMove(locate.x,locate.y);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        try{Thread.sleep(50);}catch(InterruptedException e){}

        locate=panelKey.buttonsEngineer.b8.getLocationOnScreen();
        bot.mouseMove(locate.x,locate.y);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        try{Thread.sleep(50);}catch(InterruptedException e){}

        locate=panelKey.buttonsEngineer.bPlus.getLocationOnScreen();
        bot.mouseMove(locate.x,locate.y);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        try{Thread.sleep(50);}catch(InterruptedException e){}

        locate=panelKey.buttonsEngineer.braceOpen.getLocationOnScreen();
        bot.mouseMove(locate.x,locate.y);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        try{Thread.sleep(50);}catch(InterruptedException e){}

        locate=panelKey.buttonsEngineer.b9.getLocationOnScreen();
        bot.mouseMove(locate.x,locate.y);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        try{Thread.sleep(50);}catch(InterruptedException e){}

        locate=panelKey.buttonsEngineer.bMinus.getLocationOnScreen();
        bot.mouseMove(locate.x,locate.y);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        try{Thread.sleep(50);}catch(InterruptedException e){}

        locate=panelKey.buttonsEngineer.braceOpen.getLocationOnScreen();
        bot.mouseMove(locate.x,locate.y);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        try{Thread.sleep(50);}catch(InterruptedException e){}

        locate=panelKey.buttonsEngineer.b2.getLocationOnScreen();
        bot.mouseMove(locate.x,locate.y);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        try{Thread.sleep(50);}catch(InterruptedException e){}

        locate=panelKey.buttonsEngineer.bMinus.getLocationOnScreen();
        bot.mouseMove(locate.x,locate.y);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        try{Thread.sleep(50);}catch(InterruptedException e){}

        locate=panelKey.buttonsEngineer.b5.getLocationOnScreen();
        bot.mouseMove(locate.x,locate.y);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        try{Thread.sleep(50);}catch(InterruptedException e){}

        locate=panelKey.buttonsEngineer.braceClose.getLocationOnScreen();
        bot.mouseMove(locate.x,locate.y);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        try{Thread.sleep(50);}catch(InterruptedException e){}

        locate=panelKey.buttonsEngineer.bMinus.getLocationOnScreen();
        bot.mouseMove(locate.x,locate.y);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        try{Thread.sleep(50);}catch(InterruptedException e){}

        locate=panelKey.buttonsEngineer.braceOpen.getLocationOnScreen();
        bot.mouseMove(locate.x,locate.y);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        try{Thread.sleep(50);}catch(InterruptedException e){}

        locate=panelKey.buttonsEngineer.b2.getLocationOnScreen();
        bot.mouseMove(locate.x,locate.y);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        try{Thread.sleep(50);}catch(InterruptedException e){}

        locate=panelKey.buttonsEngineer.bPlus.getLocationOnScreen();
        bot.mouseMove(locate.x,locate.y);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        try{Thread.sleep(50);}catch(InterruptedException e){}

        locate=panelKey.buttonsEngineer.b8.getLocationOnScreen();
        bot.mouseMove(locate.x,locate.y);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        try{Thread.sleep(50);}catch(InterruptedException e){}

        locate=panelKey.buttonsEngineer.braceClose.getLocationOnScreen();
        bot.mouseMove(locate.x,locate.y);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        try{Thread.sleep(50);}catch(InterruptedException e){}

        locate=panelKey.buttonsEngineer.bPercent.getLocationOnScreen();
        bot.mouseMove(locate.x,locate.y);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        try{Thread.sleep(50);}catch(InterruptedException e){}

//2+8+(9-(2-5)-(2+8)%
        assertEquals("9-(2-5)", panelKey.buttonsEngineer.strPersentFrom.trim());
        assertEquals("-", panelKey.buttonsEngineer.nameSign.trim());
        assertEquals(10, panelKey.buttonsEngineer.dNumber);
        assertEquals("2+8+", panelKey.buttonsEngineer.strBeforePersent.trim());
        assertEquals(20.8, panelKey.buttonsEngineer.dResult);
    }

    @Test
        //2+8+(9(2-5)-(2*+8%
    void percent_withExchangesSymbols()  {
        locate=panelKey.buttonsEngineer.b2.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        try{Thread.sleep(50);}catch(InterruptedException e){}

        locate=panelKey.buttonsEngineer.bPlus.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        try{Thread.sleep(50);}catch(InterruptedException e){}

        locate=panelKey.buttonsEngineer.b8.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        try{Thread.sleep(50);}catch(InterruptedException e){}

        locate=panelKey.buttonsEngineer.bPlus.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        try{Thread.sleep(50);}catch(InterruptedException e){}

        locate=panelKey.buttonsEngineer.braceOpen.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        try{Thread.sleep(50);}catch(InterruptedException e){}

        locate=panelKey.buttonsEngineer.b9.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        try{Thread.sleep(50);}catch(InterruptedException e){}

        locate=panelKey.buttonsEngineer.braceOpen.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        try{Thread.sleep(50);}catch(InterruptedException e){}

        locate=panelKey.buttonsEngineer.b2.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        try{Thread.sleep(50);}catch(InterruptedException e){}

        locate=panelKey.buttonsEngineer.bMinus.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        try{Thread.sleep(50);}catch(InterruptedException e){}

        locate=panelKey.buttonsEngineer.b5.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        try{Thread.sleep(50);}catch(InterruptedException e){}

        locate=panelKey.buttonsEngineer.braceClose.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        try{Thread.sleep(50);}catch(InterruptedException e){}

        locate=panelKey.buttonsEngineer.bMinus.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        try{Thread.sleep(50);}catch(InterruptedException e){}

        locate=panelKey.buttonsEngineer.braceOpen.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        try{Thread.sleep(50);}catch(InterruptedException e){}

        locate=panelKey.buttonsEngineer.b2.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        try{Thread.sleep(50);}catch(InterruptedException e){}

        locate=panelKey.buttonsEngineer.bMultiply.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        try{Thread.sleep(50);}catch(InterruptedException e){}

        locate=panelKey.buttonsEngineer.bPlus.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        try{Thread.sleep(50);}catch(InterruptedException e){}

        locate=panelKey.buttonsEngineer.b8.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        try{Thread.sleep(50);}catch(InterruptedException e){}

        locate=panelKey.buttonsEngineer.bPercent.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        try{Thread.sleep(50);}catch(InterruptedException e){}

//2+8+(9(2-5)-(2*+8%
        assertEquals("2", panelKey.buttonsEngineer.strPersentFrom.trim());
        assertEquals("+", panelKey.buttonsEngineer.nameSign.trim());
        assertEquals(8, panelKey.buttonsEngineer.dNumber);
        assertEquals("2+8+(9*(2-5)-", panelKey.buttonsEngineer.strBeforePersent.trim());
        assertEquals(-19.16, panelKey.buttonsEngineer.dResult);
    }


}