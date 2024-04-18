package face;

import fitting.MyColors;
import fitting.MyFonts;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import javax.swing.*;
import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import static org.junit.jupiter.api.Assertions.*;


//@ExtendWith(MockitoExtension.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class ButtonsEngineerTest {
    Point locate;
    JFrame frame;
    PanelKeyEngineer panelKey;
    Robot bot;
    @Mock
    PanelTextLog textPanel;

    @BeforeAll
    public  void initFrame() throws AWTException {
        MockitoAnnotations.openMocks(this);
        frame = new JFrame();
        frame.setSize(new Dimension(500, 300));
        panelKey =new PanelKeyEngineer(textPanel);
        frame.add(panelKey.getKeyPanel());
        frame.setVisible(true);

        bot = new Robot();
        Mockito.doNothing().when(textPanel).setSbLog(Mockito.any());
        Mockito.when(textPanel.getStrInput()).thenReturn("= ");
        Mockito.when(textPanel.getSbLog()).thenReturn(new StringBuffer(" "));

    }

    @AfterAll
    public void hideFrame() {
        frame.setVisible(false);
    }

    @ParameterizedTest
    @CsvSource( value =  {
            " =30,   0.5",
            " =90,   1.0",
            " =0,   0.0",
            " =45,   0.707106781",
            " =60,   0.866025403",
            " =120,   0.866025403",
            " =135,   0.707106781",
            " =270,   -1.0",
            " =180,   0.0",
    })
    public void testSin(String strResult, double expectedResult)  {
        Mockito.when(textPanel.getStrResult()).thenReturn(strResult);

        locate=panelKey.buttonsEngineer.bSin.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        try{Thread.sleep(50);}catch(InterruptedException e){}

        assertEquals(expectedResult, panelKey.buttonsEngineer.dResult, 0.000000001);
    }

    @ParameterizedTest
    @CsvSource( value =  {
            " =30,    0.866025403",
            " =90,   0.0",
            " =0,   1.0",
            " =45,   0.707106781",
            " =60,   0.5",
            " =120,   -0.5",
            " =135,   -0.707106781",
            " =270,   0.0",
            " =180,   -1.0",
            " =150,   -0.866025403",
    })
    public void testCos(String strResult, double expectedResult)  {
        Mockito.when(textPanel.getStrResult()).thenReturn(strResult);

        locate=panelKey.buttonsEngineer.bCos.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        try{Thread.sleep(50);}catch(InterruptedException e){}

        assertEquals(expectedResult, panelKey.buttonsEngineer.dResult, 0.000000001);
    }

    @ParameterizedTest
    @CsvSource( value =  {
            " =0,    0.0",
            " =30,   0.577350269",
            " =45,   1.0",
            " =60,   1.732050807",
            " =120,  -1.732050807",
            " =135,  -1.0",
            " =150,  -0.577350269",
            " =180,  0.0",
    })
    public void testTg(String strResult, double expectedResult)  {
        Mockito.when(textPanel.getStrResult()).thenReturn(strResult);

        locate=panelKey.buttonsEngineer.bTg.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        try{Thread.sleep(50);}catch(InterruptedException e){}

        assertEquals(expectedResult, panelKey.buttonsEngineer.dResult, 0.000000001);
    }

    @ParameterizedTest
    @CsvSource( value =  {
            " =6,    -6",
            " =-30,   30",
            " =45.55,   -45.55",
            " =-66.25,   66.25",
    })
    public void testChangeSign(String strResult, double expectedResult)  {
        Mockito.when(textPanel.getStrResult()).thenReturn(strResult);

        locate=panelKey.buttonsEngineer.bChageSign.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        try{Thread.sleep(50);}catch(InterruptedException e){}

        assertEquals(expectedResult, panelKey.buttonsEngineer.dResult, 0.000000001);
    }
    @ParameterizedTest
    @CsvSource( value =  {
            " =2,    4",
            " =-3,   9",
            " =2.5,   6.25",
            " =-2.5,   6.25",
    })

    public void testX2(String strResult, double expectedResult)  {
        Mockito.when(textPanel.getStrResult()).thenReturn(strResult);

        locate=panelKey.buttonsEngineer.bx2.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        try{Thread.sleep(50);}catch(InterruptedException e){}

        assertEquals(expectedResult, panelKey.buttonsEngineer.dResult, 0.000000001);
    }

    @ParameterizedTest
    @CsvSource( value =  {
            " =2,    8",
            " =-3,   -27",
            " =2.5,   15.625",
            " =-2.5,   -15.625",
    })
    public void testX3(String strResult, double expectedResult)  {
        Mockito.when(textPanel.getStrResult()).thenReturn(strResult);

        locate=panelKey.buttonsEngineer.bx3.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        try{Thread.sleep(50);}catch(InterruptedException e){}

        assertEquals(expectedResult, panelKey.buttonsEngineer.dResult, 0.000000001);
    }

    @ParameterizedTest
    @CsvSource( value =  {
            " =8,    2",
            " =-27,   -3",
            " =15.625,   2.5",
            " =-15.625,   -2.5",
    })
    public void testSqrt3(String strResult, double expectedResult)  {
        Mockito.when(textPanel.getStrResult()).thenReturn(strResult);

        locate=panelKey.buttonsEngineer.bSqrt3.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        try{Thread.sleep(50);}catch(InterruptedException e){}

        assertEquals(expectedResult, panelKey.buttonsEngineer.dResult, 0.000000001);
    }

}