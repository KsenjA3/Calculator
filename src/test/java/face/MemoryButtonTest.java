package face;

import org.junit.jupiter.api.*;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import javax.swing.*;
import java.awt.*;
import java.awt.event.InputEvent;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class MemoryButtonTest {

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
    @BeforeEach //5 MemoryADD
    void initFrame()  {
        panelKey.buttonsEngineer.strNumber=" ";
        txt.setText("");

        panelKey.buttonsEngineer.unblockedAll(panelKey.buttonsEngineer.b0,panelKey.buttonsEngineer.b1,panelKey.buttonsEngineer.b2,
                panelKey.buttonsEngineer.b3,panelKey.buttonsEngineer.b4,panelKey.buttonsEngineer.b5,panelKey.buttonsEngineer.b6,
                panelKey.buttonsEngineer.b7,panelKey.buttonsEngineer.b8,panelKey.buttonsEngineer.b9,panelKey.buttonsEngineer.bPoint,
                panelKey.buttonsEngineer.bPi,panelKey.buttonsEngineer.bPercent,panelKey.buttonsEngineer.bRadical);

        locate=panelKey.buttonsEngineer.b5.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        try{Thread.sleep(25);}catch(InterruptedException e){}

        txt.setText(panelKey.buttonsEngineer.strInput.trim());
        locate=panelKey.buttonsEngineer.bMemoryAdd.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        try{Thread.sleep(25);}catch(InterruptedException e){}


        txt.setText("");
    }
    @BeforeAll
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

    }


    @Test   //2+MR
    void number_plus_MR ()  {
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
        locate=panelKey.buttonsEngineer.bMemoryHold.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        try{Thread.sleep(25);}catch(InterruptedException e){}

        assertEquals("2+5", panelKey.buttonsEngineer.strInput.trim());
        assertEquals("7", panelKey.buttonsEngineer.countResult);
    }
    @Test   //2+235MR
    void number_plus_number_MR ()  {
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
        locate=panelKey.buttonsEngineer.b2.getLocationOnScreen();
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
        locate=panelKey.buttonsEngineer.b5.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        try{Thread.sleep(25);}catch(InterruptedException e){}

        txt.setText(panelKey.buttonsEngineer.strInput.trim());
        locate=panelKey.buttonsEngineer.bMemoryHold.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        try{Thread.sleep(25);}catch(InterruptedException e){}

        assertEquals("2+5", panelKey.buttonsEngineer.strInput.trim());
        assertEquals("7", panelKey.buttonsEngineer.countResult);
    }
    @Test   //2+PI MR
    void number_plus_PI_MR ()  {
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

        txt.setText(panelKey.buttonsEngineer.strInput.trim());
        locate=panelKey.buttonsEngineer.bMemoryHold.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        try{Thread.sleep(25);}catch(InterruptedException e){}

        assertEquals("2+5", panelKey.buttonsEngineer.strInput.trim());
        assertEquals("7", panelKey.buttonsEngineer.countResult);
    }
    @Test   //2+2²MR
    void number_power2_MR ()  {
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
        locate=panelKey.buttonsEngineer.bMemoryHold.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        try{Thread.sleep(25);}catch(InterruptedException e){}
//2+2²MR
        assertEquals("2+2²", panelKey.buttonsEngineer.strInput.trim());
        assertEquals("6", panelKey.buttonsEngineer.countResult);
    }
    @Test   //2^MR
    void number_power_MR ()  {
        locate=panelKey.buttonsEngineer.b2.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        try{Thread.sleep(25);}catch(InterruptedException e){}

        txt.setText(panelKey.buttonsEngineer.strInput.trim());
        locate=panelKey.buttonsEngineer.bxn.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        try{Thread.sleep(25);}catch(InterruptedException e){}

        txt.setText(panelKey.buttonsEngineer.strInput.trim());
        locate=panelKey.buttonsEngineer.bMemoryHold.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        try{Thread.sleep(25);}catch(InterruptedException e){}
//2^MR
        assertEquals("2^5", panelKey.buttonsEngineer.strInput.trim());
        assertEquals("32", panelKey.buttonsEngineer.countResult);
    }
    @Test   //2 1/x MR
    void number_devX_MR ()  {
        locate=panelKey.buttonsEngineer.b2.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        try{Thread.sleep(25);}catch(InterruptedException e){}

        txt.setText(panelKey.buttonsEngineer.strInput.trim());
        locate=panelKey.buttonsEngineer.bDivX.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        try{Thread.sleep(25);}catch(InterruptedException e){}

        txt.setText(panelKey.buttonsEngineer.strInput.trim());
        locate=panelKey.buttonsEngineer.bMemoryHold.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        try{Thread.sleep(25);}catch(InterruptedException e){}
//2 1/x MR
        assertEquals("2^(-1)", panelKey.buttonsEngineer.strInput.trim());
        assertEquals("0.5", panelKey.buttonsEngineer.countResult);
    }
    @Test   //2+(MR
    void number_plus_braceOpen_MR ()  {
        locate=panelKey.buttonsEngineer.b2.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        try{Thread.sleep(40);}catch(InterruptedException e){}

        txt.setText(panelKey.buttonsEngineer.strInput.trim());
        locate=panelKey.buttonsEngineer.bPlus.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        try{Thread.sleep(40);}catch(InterruptedException e){}

        txt.setText(panelKey.buttonsEngineer.strInput.trim());
        locate=panelKey.buttonsEngineer.braceOpen.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        try{Thread.sleep(50);}catch(InterruptedException e){}

        txt.setText(panelKey.buttonsEngineer.strInput.trim());
        locate=panelKey.buttonsEngineer.bMemoryHold.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        try{Thread.sleep(30);}catch(InterruptedException e){}
//2+(MR
        assertEquals("2+(5", panelKey.buttonsEngineer.strInput.trim());
        assertEquals("7", panelKey.buttonsEngineer.countResult);
    }
    @Test   //2+(3-1)MR
    void MR_after_braceClose ()  {
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
        locate=panelKey.buttonsEngineer.b1.getLocationOnScreen();
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
        locate=panelKey.buttonsEngineer.bMemoryHold.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        try{Thread.sleep(25);}catch(InterruptedException e){}
//2+(3-1)MR
        assertEquals("2+(3-1)*5", panelKey.buttonsEngineer.strInput.trim());
        assertEquals("12", panelKey.buttonsEngineer.countResult);
    }

//    @Test   //   2/(MR==0)

//    void MR_exception ()  {
//        locate=panelKey.buttonsEngineer.b0.getLocationOnScreen();
//        bot.mouseMove(locate.x+10,locate.y+10);
//        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
//        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
//        try{Thread.sleep(25);}catch(InterruptedException e){}
//
//        txt.setText(panelKey.buttonsEngineer.strInput.trim());
//        locate=panelKey.buttonsEngineer.bMemoryAdd.getLocationOnScreen();
//        bot.mouseMove(locate.x+10,locate.y+10);
//        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
//        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
//        try{Thread.sleep(25);}catch(InterruptedException e){}
//
//
//        panelKey.buttonsEngineer.strNumber=" ";
//        txt.setText("");
//        locate=panelKey.buttonsEngineer.b2.getLocationOnScreen();
//        bot.mouseMove(locate.x+10,locate.y+10);
//        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
//        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
//        try{Thread.sleep(25);}catch(InterruptedException e){}
//
//        txt.setText(panelKey.buttonsEngineer.strInput.trim());
//        locate=panelKey.buttonsEngineer.bDivide.getLocationOnScreen();
//        bot.mouseMove(locate.x+10,locate.y+10);
//        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
//        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
//        try{Thread.sleep(25);}catch(InterruptedException e){}
//
//        txt.setText(panelKey.buttonsEngineer.strInput.trim());
//        locate=panelKey.buttonsEngineer.bMemoryHold.getLocationOnScreen();
//        bot.mouseMove(locate.x+10,locate.y+10);
//        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
//        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
//        try{Thread.sleep(25);}catch(InterruptedException e){}
//
//
////        Throwable ex = assertThrows(
////                ArithmeticException.class,
////                ()->{
////                    sut.calculateInput(strInput);
////
////                },
////                "no throws"
////        );
////
////        assertEquals("Division by zero", ex.getMessage());
//
//        assertEquals("2/0", panelKey.buttonsEngineer.strInput.trim());
//        assertEquals(0, panelKey.buttonsEngineer.countResult);
//    }






    //exception divide 0
}
