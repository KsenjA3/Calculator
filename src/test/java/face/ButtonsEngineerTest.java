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
import static org.junit.jupiter.api.Assertions.*;


//@ExtendWith(MockitoExtension.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class ButtonsEngineerTest {
    Point locate;
    JTextPane txt;
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

        Mockito.doNothing().when(textPanel).setSbLog(Mockito.any());
//        Mockito.when(textPanel.getStrInput()).thenReturn("= ");
        Mockito.when(textPanel.getSbLog()).thenReturn(new StringBuffer(" "));
        Mockito.when(textPanel.getTextInput()).thenReturn(txt);
    }

    @AfterAll
     void hideFrame() {
        frame.setVisible(false);
    }


    @Test
    void ln_Exception(){
        Throwable ex = assertThrows(
                MyException.class,
                ()->{
                     txt.setText("-2");
                     Mockito.when(textPanel.getTextInput()).thenReturn(txt);

                    locate=panelKey.buttonsEngineer.bLn.getLocationOnScreen();
                        bot.mouseMove(locate.x+10,locate.y+10);
                        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
                        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
                        try{Thread.sleep(50);}catch(InterruptedException e){}
                },
                "no throws"
        );

        assertEquals("ln не существует", ex.getMessage());

    }
    @Test
    void testExpectedExceptionWithParentType() {

        Assertions.assertThrows(ArithmeticException.class, () -> {
            double d =1/0;
        });
    }



    @Test
    void factorial_Exception()  {
//        Mockito.when(textPanel.getStrResult()).thenReturn("2.5");
        Throwable ex = assertThrows(
                NumberFormatException.class,
                ()->{
                    locate=panelKey.buttonsEngineer.bFactorial.getLocationOnScreen();
                    bot.mouseMove(locate.x+10,locate.y+10);
                    bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
                    bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
                    try{Thread.sleep(50);}catch(InterruptedException e){}
                }
        );
    }


    @ParameterizedTest
    @CsvSource( value =  {
            " =1,   1",
            " =2,   2",
            " =3,   6",
            " =5,   120",
            " =0,   1",

    })
     void factorial(String strResult, double expectedResult)  {
//        Mockito.when(textPanel.getStrResult()).thenReturn(strResult);

        locate=panelKey.buttonsEngineer.bFactorial.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        try{Thread.sleep(50);}catch(InterruptedException e){}

        assertEquals(expectedResult, panelKey.buttonsEngineer.dResult, 0.000000001);
    }

    @ParameterizedTest
    @CsvSource( value =  {
            " 2-1,   1",
            " 2,   0.5",
            " -4,   -0.25",
            " 0.5,   2",

    })
     void divideForX(String strResult, double expectedResult)  {
        txt.setText(strResult);
        Mockito.when(textPanel.getTextInput()).thenReturn(txt);

        locate=panelKey.buttonsEngineer.bDivX.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        try{Thread.sleep(50);}catch(InterruptedException e){}

        assertEquals(expectedResult, panelKey.buttonsEngineer.dResult, 0.000000001);
    }
    @ParameterizedTest
    @CsvSource( value =  {
            " 30.0,   0.5",
            " 90,   1.0",
            " 0,   0.0",
            " 45,   0.707106781",
            " 60,   0.866025403",
            " 120,   0.866025403",
            " 135,   0.707106781",
            " 270,   -1.0",
            " 180,   0.0",
    })
     void sin( String strResult, double expectedResult)  {
        txt.setText(strResult);
        Mockito.when(textPanel.getTextInput()).thenReturn(txt);

        locate=panelKey.buttonsEngineer.bSin.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        try{Thread.sleep(50);}catch(InterruptedException e){}

        assertEquals(expectedResult, panelKey.buttonsEngineer.dResult, 0.000000001);
    }

    @ParameterizedTest
    @CsvSource( value =  {
            " 30,    0.866025403",
            " 90,   0.0",
            " 0,   1.0",
            " 45,   0.707106781",
            " 60,   0.5",
            " 120,   -0.5",
            " 135,   -0.707106781",
            " 270,   0.0",
            " 180,   -1.0",
            " 150,   -0.866025403",
    })
     void cos(String strResult, double expectedResult)  {
        txt.setText(strResult);
        Mockito.when(textPanel.getTextInput()).thenReturn(txt);

        locate=panelKey.buttonsEngineer.bCos.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        try{Thread.sleep(50);}catch(InterruptedException e){}

        assertEquals(expectedResult, panelKey.buttonsEngineer.dResult, 0.000000001);
    }

    @ParameterizedTest
    @CsvSource( value =  {
            " 0,    0.0",
            " 30,   0.577350269",
            " 45,   1.0",
            " 60,   1.732050807",
            " 120,  -1.732050807",
            " 135,  -1.0",
            " 150,  -0.577350269",
            " 180,  0.0",
    })
     void tg(String strResult, double expectedResult)  {
        txt.setText(strResult);
        Mockito.when(textPanel.getTextInput()).thenReturn(txt);

        locate=panelKey.buttonsEngineer.bTg.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        try{Thread.sleep(50);}catch(InterruptedException e){}

        assertEquals(expectedResult, panelKey.buttonsEngineer.dResult, 0.000000001);
    }

    @ParameterizedTest
    @CsvSource( value =  {
            " 6,    -6",
            " -30,   30",
            " 45.55,   -45.55",
            " -66.25,   66.25",
    })
     void changeSign(String strResult, double expectedResult)  {
        txt.setText(strResult);
        Mockito.when(textPanel.getTextInput()).thenReturn(txt);

        locate=panelKey.buttonsEngineer.bChageSign.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        try{Thread.sleep(50);}catch(InterruptedException e){}

        assertEquals(expectedResult, panelKey.buttonsEngineer.dResult, 0.000000001);
    }
    @ParameterizedTest
    @CsvSource( value =  {
            " 2,    4",
            " -3,   9",
            " 2.5,   6.25",
            " -2.5,   6.25",
    })

     void testX2(String strResult, double expectedResult)  {
        txt.setText(strResult);
        Mockito.when(textPanel.getTextInput()).thenReturn(txt);

        locate=panelKey.buttonsEngineer.bx2.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        try{Thread.sleep(50);}catch(InterruptedException e){}

        assertEquals(expectedResult, panelKey.buttonsEngineer.dResult, 0.000000001);
    }

    @ParameterizedTest
    @CsvSource( value =  {
            " 2,    8",
            " -3,   -27",
            " 2.5,   15.625",
            " -2.5,   -15.625",
    })
     void testX3(String strResult, double expectedResult)  {
        txt.setText(strResult);
        Mockito.when(textPanel.getTextInput()).thenReturn(txt);

        locate=panelKey.buttonsEngineer.bx3.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        try{Thread.sleep(50);}catch(InterruptedException e){}

        assertEquals(expectedResult, panelKey.buttonsEngineer.dResult, 0.000000001);
    }

    @ParameterizedTest
    @CsvSource( value =  {
            " 8,    2",
            " -27,   -3",
            " 15.625,   2.5",
            " -15.625,   -2.5",
    })
     void sqrt3(String strResult, double expectedResult)  {
        txt.setText(strResult);
        Mockito.when(textPanel.getTextInput()).thenReturn(txt);

        locate=panelKey.buttonsEngineer.bSqrt3.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        try{Thread.sleep(50);}catch(InterruptedException e){}

        assertEquals(expectedResult, panelKey.buttonsEngineer.dResult, 0.000000001);
    }

    @ParameterizedTest
    @CsvSource( value =  {
            " 100,   2",
            " 20,   1.301029995",
            " 10000,   4",
            " 25,   1.397940008",
            " 0.25,   -0.602059991",
    })
     void lg(String strResult, double expectedResult)  {
        txt.setText(strResult);
        Mockito.when(textPanel.getTextInput()).thenReturn(txt);

        locate=panelKey.buttonsEngineer.bLg.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        try{Thread.sleep(50);}catch(InterruptedException e){}

        assertEquals(expectedResult, panelKey.buttonsEngineer.dResult, 0.000000001);
    }

    @ParameterizedTest
    @CsvSource( value =  {
            " 1,   0",
            " 2.718281828459,   1",
            " 25,   3.218875824",
            " 0.25,   -1.386294361",

    })
     void ln(String strResult, double expectedResult)  {
        txt.setText(strResult);
        Mockito.when(textPanel.getTextInput()).thenReturn(txt);

        locate=panelKey.buttonsEngineer.bLn.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        try{Thread.sleep(50);}catch(InterruptedException e){}

        assertEquals(expectedResult, panelKey.buttonsEngineer.dResult, 0.000000001);
    }

}