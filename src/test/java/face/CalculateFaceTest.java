package face;

import fitting.MyColors;
import fitting.MyFonts;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import javax.swing.*;
import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

import static org.junit.jupiter.api.Assertions.*;


@ExtendWith(MockitoExtension.class)
public final class CalculateFaceTest {
    JFrame frame;
    PanelKeyEngineer panelKey;
    Robot bot;
    @Mock
    PanelTextLog textPanel;
//
//    @BeforeEach
//    public  void initFrame() throws AWTException {
//        frame = new JFrame();
//        frame.setSize(new Dimension(500, 300));
//        panelKey =new PanelKeyEngineer(textPanel);
//        frame.add(panelKey.getKeyPanel());
//        frame.setVisible(true);
//
//        bot = new Robot();
//
//        Mockito.doNothing().when(textPanel).setSbLog(Mockito.any());
//        Mockito.when(textPanel.getStrInput()).thenReturn("= ");
//        Mockito.when(textPanel.getSbLog()).thenReturn(new StringBuffer(" "));
//    }
//
//    @AfterEach
//    public void hideFrame() {
//        frame.setVisible(false);
//    }
//
//    @ParameterizedTest
//    @CsvSource( value =  {
//            " =30,   0.5",
//            " =90,   1.0",
//            " =0,   0.0",
//            " =90,   1.0",
//            " =45,   0.707106781",
//            " =60,   0.866025403",
//            " =120,   0.866025403",
//            " =135,   0.707106781",
//            " =270,   -1.0",
//            " =180,   0.0",
//    })
//    public void testTest(String strResult, double expectedResult)  {
//        Mockito.when(textPanel.getStrResult()).thenReturn(strResult);
//
//        Point locate=panelKey.buttonsEngineer.bSin.getLocationOnScreen();
//            bot.mouseMove(locate.x+10,locate.y+10);
//            bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
//            bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
//            try{Thread.sleep(25);}catch(InterruptedException e){}
//
//        assertEquals(expectedResult, panelKey.buttonsEngineer.dResult, 0.000000001);
//    }
}






//        int x = locate.x;
//        int y = locate.y;
//        System.out.println(x);
//        System.out.println(y);
//        System.out.println(panelKey.buttonsEngineer.dResult);
//        System.out.println( "b= "+panelKey.buttonsEngineer.b);



//        bot.keyPress(KeyEvent.VK_3);
//        bot.keyRelease(KeyEvent.VK_3);
//        bot.keyPress(KeyEvent.VK_ADD);
//        bot.keyRelease(KeyEvent.VK_ADD);
//        bot.keyPress(KeyEvent.VK_8);
//        bot.keyRelease(KeyEvent.VK_8);
//        bot.keyPress(KeyEvent.VK_ENTER);
//        bot.keyRelease(KeyEvent.VK_ENTER);