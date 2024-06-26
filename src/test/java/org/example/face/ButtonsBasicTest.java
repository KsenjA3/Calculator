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

import static org.junit.jupiter.api.Assertions.assertEquals;


//@NotThreadSafe

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class ButtonsBasicTest {
    Point locate;
    JTextPane txt;
    JLabel label;
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
        panelKey.buttonsEngineer.strNumber=" ";
        txt.setText("");
//        frame = new JFrame();
//        frame.setSize(new Dimension(500, 300));
//        panelKey =new PanelKeyEngineer(textPanel);
//
//        frame.add(panelKey.getKeyPanel());
//        frame.setVisible(true);

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
        label= new JLabel();
        label.setText("22");

        Mockito.doNothing().when(textPanel).setSbLog(Mockito.any());
        Mockito.doNothing().when(textPanel).setTextInput(Mockito.any());
        Mockito.doNothing().when(textPanel).setTextResult(Mockito.any());

        Mockito.when(textPanel.getSbLog()).thenReturn(new StringBuffer(" "));
        Mockito.when(textPanel.getTextInput()).thenReturn(txt);
        Mockito.when(textPanel.getTextResult()).thenReturn(label);

    }


    @Test
    @SneakyThrows (InterruptedException.class)
    void sign_pressFirst( ) {

        locate = panelKey.buttonsEngineer.bPlus.getLocationOnScreen();
        bot.mouseMove(locate.x + 10, locate.y + 10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(25);


        txt.setText(panelKey.buttonsEngineer.strInput.trim());
        locate = panelKey.buttonsEngineer.b2.getLocationOnScreen();
        bot.mouseMove(locate.x + 10, locate.y + 10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(25);

        assertEquals("0+2", panelKey.buttonsEngineer.strInput.trim());
    }


    @Test
    @SneakyThrows (InterruptedException.class)
    void number_press( )  {

        locate=panelKey.buttonsEngineer.b1.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(25);
        assertEquals("1", panelKey.buttonsEngineer.strNumber.trim());

        locate=panelKey.buttonsEngineer.b2.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(25);
        assertEquals("12", panelKey.buttonsEngineer.strNumber.trim());

        locate=panelKey.buttonsEngineer.b3.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(25);
        assertEquals("123", panelKey.buttonsEngineer.strNumber.trim());

        locate=panelKey.buttonsEngineer.b4.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(25);
        assertEquals("1234", panelKey.buttonsEngineer.strNumber.trim());

        locate=panelKey.buttonsEngineer.b5.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(25);
        assertEquals("12345", panelKey.buttonsEngineer.strNumber.trim());

        panelKey.buttonsEngineer.strNumber=" ";
        locate=panelKey.buttonsEngineer.b6.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(25);
        assertEquals("6", panelKey.buttonsEngineer.strNumber.trim());

        txt.setText(panelKey.buttonsEngineer.strInput.trim());
        locate=panelKey.buttonsEngineer.b7.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(25);
        assertEquals("67", panelKey.buttonsEngineer.strNumber.trim());

        txt.setText(panelKey.buttonsEngineer.strInput.trim());
        locate=panelKey.buttonsEngineer.b8.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(25);
        assertEquals("678", panelKey.buttonsEngineer.strNumber.trim());

        txt.setText(panelKey.buttonsEngineer.strInput.trim());
        locate=panelKey.buttonsEngineer.b9.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(25);
        assertEquals("6789", panelKey.buttonsEngineer.strNumber.trim());
        assertEquals("6789", panelKey.buttonsEngineer.strInput.trim());



        panelKey.buttonsEngineer.strNumber=" ";
        txt.setText(" ");
        locate=panelKey.buttonsEngineer.b0.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(25);
        assertEquals("0", panelKey.buttonsEngineer.strNumber.trim());
        assertEquals("0", panelKey.buttonsEngineer.strInput.trim());



        panelKey.buttonsEngineer.strNumber="0";
        panelKey.buttonsEngineer.strInput=" ";
        locate=panelKey.buttonsEngineer.bPoint.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(25);
        assertEquals("0.", panelKey.buttonsEngineer.strInput.trim());
    }

    @Test  //2+3.0003
    @SneakyThrows (InterruptedException.class)
    void input_number_double ()  {
        locate=panelKey.buttonsEngineer.b2.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(25);

        txt.setText(panelKey.buttonsEngineer.strInput.trim());
        locate=panelKey.buttonsEngineer.bPlus.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(25);

        txt.setText(panelKey.buttonsEngineer.strInput.trim());
        locate=panelKey.buttonsEngineer.b3.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(25);

        txt.setText(panelKey.buttonsEngineer.strInput.trim());
        locate=panelKey.buttonsEngineer.bPoint.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(25);

        txt.setText(panelKey.buttonsEngineer.strInput.trim());
        locate=panelKey.buttonsEngineer.b0.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(25);

        txt.setText(panelKey.buttonsEngineer.strInput.trim());
        locate=panelKey.buttonsEngineer.b0.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(25);

        txt.setText(panelKey.buttonsEngineer.strInput.trim());
        locate=panelKey.buttonsEngineer.b0.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(25);

        txt.setText(panelKey.buttonsEngineer.strInput.trim());
        locate=panelKey.buttonsEngineer.b3.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(25);

//2+3.0003
        assertEquals("2+3.0003", panelKey.buttonsEngineer.strInput.trim());
        assertEquals("5.0003", panelKey.buttonsEngineer.countResult);
    }
    @Test  //200.5+5.0003
    @SneakyThrows (InterruptedException.class)
    void input_ZIRO_inCentre_double ()  {
        locate=panelKey.buttonsEngineer.b2.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(25);

        txt.setText(panelKey.buttonsEngineer.strInput.trim());
        locate=panelKey.buttonsEngineer.b0.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(25);

        txt.setText(panelKey.buttonsEngineer.strInput.trim());
        locate=panelKey.buttonsEngineer.b0.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(25);

        txt.setText(panelKey.buttonsEngineer.strInput.trim());
        locate=panelKey.buttonsEngineer.bPoint.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(25);

        txt.setText(panelKey.buttonsEngineer.strInput.trim());
        locate=panelKey.buttonsEngineer.b5.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(25);

        txt.setText(panelKey.buttonsEngineer.strInput.trim());
        locate=panelKey.buttonsEngineer.bPlus.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(25);

        txt.setText(panelKey.buttonsEngineer.strInput.trim());
        locate=panelKey.buttonsEngineer.b5.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(25);

        txt.setText(panelKey.buttonsEngineer.strInput.trim());
        locate=panelKey.buttonsEngineer.bPoint.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(25);

        txt.setText(panelKey.buttonsEngineer.strInput.trim());
        locate=panelKey.buttonsEngineer.b0.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(25);

        txt.setText(panelKey.buttonsEngineer.strInput.trim());
        locate=panelKey.buttonsEngineer.b0.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(25);

        txt.setText(panelKey.buttonsEngineer.strInput.trim());
        locate=panelKey.buttonsEngineer.b0.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(25);

        txt.setText(panelKey.buttonsEngineer.strInput.trim());
        locate=panelKey.buttonsEngineer.b3.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(25);

//200.5+5.0003
        assertEquals("200.5+5.0003", panelKey.buttonsEngineer.strInput.trim());
        assertEquals("205.5003", panelKey.buttonsEngineer.countResult);
    }

    @Test  //2+.0003
    @SneakyThrows (InterruptedException.class)
    void input_double_beginWith_Point ()  {
        locate=panelKey.buttonsEngineer.b2.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(25);

        txt.setText(panelKey.buttonsEngineer.strInput.trim());
        locate=panelKey.buttonsEngineer.bPlus.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(25);

        txt.setText(panelKey.buttonsEngineer.strInput.trim());
        locate=panelKey.buttonsEngineer.bPoint.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(25);

        txt.setText(panelKey.buttonsEngineer.strInput.trim());
        locate=panelKey.buttonsEngineer.b0.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(25);

        txt.setText(panelKey.buttonsEngineer.strInput.trim());
        locate=panelKey.buttonsEngineer.b0.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(25);

        txt.setText(panelKey.buttonsEngineer.strInput.trim());
        locate=panelKey.buttonsEngineer.b0.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(25);

        txt.setText(panelKey.buttonsEngineer.strInput.trim());
        locate=panelKey.buttonsEngineer.b3.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(25);

//2+0.0003
        assertEquals("2+0.0003", panelKey.buttonsEngineer.strInput.trim());
        assertEquals("2.0003", panelKey.buttonsEngineer.countResult);
    }

    @Test  //00002+3
    @SneakyThrows (InterruptedException.class)
    void input_beginWith_ZERO ()  {
        locate=panelKey.buttonsEngineer.b0.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(25);

        txt.setText(panelKey.buttonsEngineer.strInput.trim());
        locate=panelKey.buttonsEngineer.b0.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(25);

        txt.setText(panelKey.buttonsEngineer.strInput.trim());
        locate=panelKey.buttonsEngineer.b0.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(25);

        txt.setText(panelKey.buttonsEngineer.strInput.trim());
        locate=panelKey.buttonsEngineer.b0.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(25);

        txt.setText(panelKey.buttonsEngineer.strInput.trim());
        locate=panelKey.buttonsEngineer.b2.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(25);

        txt.setText(panelKey.buttonsEngineer.strInput.trim());
        locate=panelKey.buttonsEngineer.bPlus.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(25);

        txt.setText(panelKey.buttonsEngineer.strInput.trim());
        locate=panelKey.buttonsEngineer.b3.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(25);



//00002+3
        assertEquals("2+3", panelKey.buttonsEngineer.strInput.trim());
        assertEquals("5", panelKey.buttonsEngineer.countResult);
    }

    @Test  //2+0003.3
    @SneakyThrows (InterruptedException.class)
    void input_double_beginWith_ZERO ()  {
        locate=panelKey.buttonsEngineer.b2.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(25);

        txt.setText(panelKey.buttonsEngineer.strInput.trim());
        locate=panelKey.buttonsEngineer.bPlus.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(25);

        txt.setText(panelKey.buttonsEngineer.strInput.trim());
        locate=panelKey.buttonsEngineer.b0.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(25);

        txt.setText(panelKey.buttonsEngineer.strInput.trim());
        locate=panelKey.buttonsEngineer.b0.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(25);

        txt.setText(panelKey.buttonsEngineer.strInput.trim());
        locate=panelKey.buttonsEngineer.b0.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(25);

        txt.setText(panelKey.buttonsEngineer.strInput.trim());
        locate=panelKey.buttonsEngineer.b3.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(25);

        txt.setText(panelKey.buttonsEngineer.strInput.trim());
        locate=panelKey.buttonsEngineer.bPoint.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(25);

        txt.setText(panelKey.buttonsEngineer.strInput.trim());
        locate=panelKey.buttonsEngineer.b3.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(25);

//2+0003.3
        assertEquals("2+3.3", panelKey.buttonsEngineer.strInput.trim());
        assertEquals("5.3", panelKey.buttonsEngineer.countResult);
    }



    @Test  //2+3= после ввод 8
    @SneakyThrows (InterruptedException.class)
    void input_number_after_result ()  {
        locate=panelKey.buttonsEngineer.b2.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(25);

        txt.setText(panelKey.buttonsEngineer.strInput.trim());
        locate=panelKey.buttonsEngineer.bPlus.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(25);

        txt.setText(panelKey.buttonsEngineer.strInput.trim());
        locate=panelKey.buttonsEngineer.b3.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(25);

        txt.setText(panelKey.buttonsEngineer.strInput.trim());
        locate=panelKey.buttonsEngineer.bResult.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(25);

        txt.setText(panelKey.buttonsEngineer.strInput.trim());
        locate=panelKey.buttonsEngineer.b8.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(25);

        assertEquals("8", panelKey.buttonsEngineer.strInput.trim());
    }
    @Test  //2+3% после ввод 8
    @SneakyThrows (InterruptedException.class)
    void input_number_after_percent ()  {
        locate=panelKey.buttonsEngineer.b2.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(25);

        txt.setText(panelKey.buttonsEngineer.strInput.trim());
        locate=panelKey.buttonsEngineer.bPlus.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(25);

        txt.setText(panelKey.buttonsEngineer.strInput.trim());
        locate=panelKey.buttonsEngineer.b3.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(25);

        txt.setText(panelKey.buttonsEngineer.strInput.trim());
        locate=panelKey.buttonsEngineer.bPercent.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(25);

        txt.setText(panelKey.buttonsEngineer.strInput.trim());
        locate=panelKey.buttonsEngineer.b8.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(25);

        //2+3% после ввод 8
        assertEquals("8", panelKey.buttonsEngineer.strInput.trim());

        assertEquals("2", panelKey.buttonsEngineer.strPersentFrom.trim());
        assertEquals("+", panelKey.buttonsEngineer.nameSign.trim());
        assertEquals("3", panelKey.buttonsEngineer.countNumber);
    }






    @Test // 7√√√+ == 7+
    @SneakyThrows (InterruptedException.class)
    void exchange_fewSqrt_to_plus()  {
        locate=panelKey.buttonsEngineer.b7.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(25);

        txt.setText(panelKey.buttonsEngineer.strInput.trim());
        locate=panelKey.buttonsEngineer.bRadical.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(25);

        txt.setText(panelKey.buttonsEngineer.strInput.trim());
        locate=panelKey.buttonsEngineer.bRadical.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(25);

        txt.setText(panelKey.buttonsEngineer.strInput.trim());
        locate=panelKey.buttonsEngineer.bRadical.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(25);

        txt.setText(panelKey.buttonsEngineer.strInput.trim());
        locate=panelKey.buttonsEngineer.bPlus.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(25);

        assertEquals("7+", panelKey.buttonsEngineer.strInput.trim());
    }
    @Test  //2-+5
    @SneakyThrows (InterruptedException.class)
    void fewSign_OneByOne ()  {
        locate=panelKey.buttonsEngineer.b2.getLocationOnScreen();
            bot.mouseMove(locate.x+10,locate.y+10);
            bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
            bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(25);

        txt.setText(panelKey.buttonsEngineer.strInput.trim());
        locate=panelKey.buttonsEngineer.bMinus.getLocationOnScreen();
            bot.mouseMove(locate.x+10,locate.y+10);
            bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
            bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(25);

        txt.setText(panelKey.buttonsEngineer.strInput.trim());
        locate=panelKey.buttonsEngineer.bPlus.getLocationOnScreen();
            bot.mouseMove(locate.x+10,locate.y+10);
            bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
            bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(25);

        txt.setText(panelKey.buttonsEngineer.strInput.trim());
        locate=panelKey.buttonsEngineer.b5.getLocationOnScreen();
            bot.mouseMove(locate.x+10,locate.y+10);
            bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
            bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(25);

        assertEquals("2+5", panelKey.buttonsEngineer.strInput.trim());
    }
    @Test //8-+/*3
    @SneakyThrows (InterruptedException.class)
    void fourSign_OneByOne_keyBoard ()  {
//        panelKey.getKeyPanelEngineer().requestFocus();
        bot.keyPress(KeyEvent.VK_8);
        Thread.sleep(10);
        bot.keyRelease(KeyEvent.VK_8);

        txt.setText(panelKey.buttonsEngineer.strInput.trim());
        bot.keyPress(KeyEvent.VK_MINUS);
        Thread.sleep(10);

        txt.setText(panelKey.buttonsEngineer.strInput.trim());
        bot.keyPress(KeyEvent.VK_ADD);
        Thread.sleep(10);
        bot.keyRelease(KeyEvent.VK_ADD);

        txt.setText(panelKey.buttonsEngineer.strInput.trim());
        bot.keyPress(KeyEvent.VK_DIVIDE);
        Thread.sleep(10);
        bot.keyRelease(KeyEvent.VK_DIVIDE);

        txt.setText(panelKey.buttonsEngineer.strInput.trim());
        bot.keyPress(KeyEvent.VK_MULTIPLY);
        Thread.sleep(10);
        bot.keyRelease(KeyEvent.VK_MULTIPLY);

        txt.setText(panelKey.buttonsEngineer.strInput.trim());
        bot.keyPress(KeyEvent.VK_3);
        Thread.sleep(10);
        bot.keyRelease(KeyEvent.VK_3);

        assertEquals("8*3", panelKey.buttonsEngineer.strInput.trim());
    }
    @Test //8√√√
    @SneakyThrows (InterruptedException.class)
    void fiveSqrt_OneByOne ()  {
        locate=panelKey.buttonsEngineer.b8.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(25);

        txt.setText(panelKey.buttonsEngineer.strInput.trim());
        locate=panelKey.buttonsEngineer.bRadical.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(25);

        txt.setText(panelKey.buttonsEngineer.strInput.trim());
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(25);

        txt.setText(panelKey.buttonsEngineer.strInput.trim());
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(25);

        txt.setText(panelKey.buttonsEngineer.strInput.trim());
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(25);

        txt.setText(panelKey.buttonsEngineer.strInput.trim());
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(25);

        //8√√√
        assertEquals("8√√√", panelKey.buttonsEngineer.strInput.trim());
    }
    @Test        //2(+3√+ == 2*(3+
    @SneakyThrows (InterruptedException.class)
    void exchange_Blocked_SymbolsWith_openBrace ()  {
        locate=panelKey.buttonsEngineer.b2.getLocationOnScreen();
            bot.mouseMove(locate.x+10,locate.y+10);
            bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
            bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(25);

        txt.setText(panelKey.buttonsEngineer.strInput.trim());
        locate=panelKey.buttonsEngineer.braceOpen.getLocationOnScreen();
            bot.mouseMove(locate.x+10,locate.y+10);
            bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
            bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(25);

        txt.setText(panelKey.buttonsEngineer.strInput.trim());
        locate=panelKey.buttonsEngineer.bPlus.getLocationOnScreen();
            bot.mouseMove(locate.x+10,locate.y+10);
            bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
            bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(25);

        txt.setText(panelKey.buttonsEngineer.strInput.trim());
        locate=panelKey.buttonsEngineer.b3.getLocationOnScreen();
            bot.mouseMove(locate.x+10,locate.y+10);
            bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
            bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(25);

        txt.setText(panelKey.buttonsEngineer.strInput.trim());
        locate=panelKey.buttonsEngineer.bRadical.getLocationOnScreen();
            bot.mouseMove(locate.x+10,locate.y+10);
            bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
            bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(25);

        txt.setText(panelKey.buttonsEngineer.strInput.trim());
        locate=panelKey.buttonsEngineer.bPlus.getLocationOnScreen();
            bot.mouseMove(locate.x+10,locate.y+10);
            bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
            bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(25);

        assertEquals("2*(3+", panelKey.buttonsEngineer.strInput.trim());
    }




    @Test  //((5-7)-2
    @SneakyThrows (InterruptedException.class)
    void negativeNumber_inBraces()  {
        locate=panelKey.buttonsEngineer.braceOpen.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(25);Thread.sleep(25);

        txt.setText(panelKey.buttonsEngineer.strInput.trim());
        locate=panelKey.buttonsEngineer.braceOpen.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(25);

        txt.setText(panelKey.buttonsEngineer.strInput.trim());
        bot.keyPress(KeyEvent.VK_5);
        Thread.sleep(10);
        bot.keyRelease(KeyEvent.VK_5);

        txt.setText(panelKey.buttonsEngineer.strInput.trim());
        bot.keyPress(KeyEvent.VK_MINUS);
        Thread.sleep(10);
        bot.keyRelease(KeyEvent.VK_MINUS);

        txt.setText(panelKey.buttonsEngineer.strInput.trim());
        bot.keyPress(KeyEvent.VK_7);
        Thread.sleep(10);
        bot.keyRelease(KeyEvent.VK_7);

        txt.setText(panelKey.buttonsEngineer.strInput.trim());
        locate=panelKey.buttonsEngineer.braceClose.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(25);

        txt.setText(panelKey.buttonsEngineer.strInput.trim());
        bot.keyPress(KeyEvent.VK_MINUS);
        Thread.sleep(10);
        bot.keyRelease(KeyEvent.VK_MINUS);

        txt.setText(panelKey.buttonsEngineer.strInput.trim());
        bot.keyPress(KeyEvent.VK_2);
        Thread.sleep(10);
        bot.keyRelease(KeyEvent.VK_2);

        //((5-7)-2
        assertEquals("-4", panelKey.buttonsEngineer.countResult);
    }
    @Test  //2(2+3)5
    @SneakyThrows (InterruptedException.class)
    void addMultiply_before_after_Braces ()  {

        locate=panelKey.buttonsEngineer.b2.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(25);

        txt.setText(panelKey.buttonsEngineer.strInput.trim());
        locate=panelKey.buttonsEngineer.braceOpen.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(25);

        txt.setText(panelKey.buttonsEngineer.strInput.trim());
        locate=panelKey.buttonsEngineer.b2.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(25);

        txt.setText(panelKey.buttonsEngineer.strInput.trim());
        locate=panelKey.buttonsEngineer.bPlus.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(25);

        txt.setText(panelKey.buttonsEngineer.strInput.trim());
        locate=panelKey.buttonsEngineer.b3.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(25);

        txt.setText(panelKey.buttonsEngineer.strInput.trim());
        locate=panelKey.buttonsEngineer.braceClose.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(25);

        txt.setText(panelKey.buttonsEngineer.strInput.trim());
        locate=panelKey.buttonsEngineer.b5.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(25);

//2(2+3)5
        assertEquals("2*(2+3)*5", panelKey.buttonsEngineer.strInput.trim());
        assertEquals("50", panelKey.buttonsEngineer.countResult);
    }





    @Test        //2+8+(9-(2-5)-(2+8)%
    @SneakyThrows (InterruptedException.class)
    void percent()  {
        locate=panelKey.buttonsEngineer.b2.getLocationOnScreen();
        bot.mouseMove(locate.x,locate.y);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(25);

        txt.setText(panelKey.buttonsEngineer.strInput.trim());
        locate=panelKey.buttonsEngineer.bPlus.getLocationOnScreen();
        bot.mouseMove(locate.x,locate.y);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(25);

        txt.setText(panelKey.buttonsEngineer.strInput.trim());
        locate=panelKey.buttonsEngineer.b8.getLocationOnScreen();
        bot.mouseMove(locate.x,locate.y);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(25);

        txt.setText(panelKey.buttonsEngineer.strInput.trim());
        locate=panelKey.buttonsEngineer.bPlus.getLocationOnScreen();
        bot.mouseMove(locate.x,locate.y);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(25);

        txt.setText(panelKey.buttonsEngineer.strInput.trim());
        locate=panelKey.buttonsEngineer.braceOpen.getLocationOnScreen();
        bot.mouseMove(locate.x,locate.y);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(25);

        txt.setText(panelKey.buttonsEngineer.strInput.trim());
        locate=panelKey.buttonsEngineer.b9.getLocationOnScreen();
        bot.mouseMove(locate.x,locate.y);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(25);

        txt.setText(panelKey.buttonsEngineer.strInput.trim());
        locate=panelKey.buttonsEngineer.bMinus.getLocationOnScreen();
        bot.mouseMove(locate.x,locate.y);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(25);

        txt.setText(panelKey.buttonsEngineer.strInput.trim());
        locate=panelKey.buttonsEngineer.braceOpen.getLocationOnScreen();
        bot.mouseMove(locate.x,locate.y);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(25);

        txt.setText(panelKey.buttonsEngineer.strInput.trim());
        locate=panelKey.buttonsEngineer.b2.getLocationOnScreen();
        bot.mouseMove(locate.x,locate.y);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(25);

        txt.setText(panelKey.buttonsEngineer.strInput.trim());
        locate=panelKey.buttonsEngineer.bMinus.getLocationOnScreen();
        bot.mouseMove(locate.x,locate.y);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(25);

        txt.setText(panelKey.buttonsEngineer.strInput.trim());
        locate=panelKey.buttonsEngineer.b5.getLocationOnScreen();
        bot.mouseMove(locate.x,locate.y);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(25);

        txt.setText(panelKey.buttonsEngineer.strInput.trim());
        locate=panelKey.buttonsEngineer.braceClose.getLocationOnScreen();
        bot.mouseMove(locate.x,locate.y);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(25);

        txt.setText(panelKey.buttonsEngineer.strInput.trim());
        locate=panelKey.buttonsEngineer.bMinus.getLocationOnScreen();
        bot.mouseMove(locate.x,locate.y);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(25);

        txt.setText(panelKey.buttonsEngineer.strInput.trim());
        locate=panelKey.buttonsEngineer.braceOpen.getLocationOnScreen();
        bot.mouseMove(locate.x,locate.y);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(25);

        txt.setText(panelKey.buttonsEngineer.strInput.trim());
        locate=panelKey.buttonsEngineer.b2.getLocationOnScreen();
        bot.mouseMove(locate.x,locate.y);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(25);

        txt.setText(panelKey.buttonsEngineer.strInput.trim());
        locate=panelKey.buttonsEngineer.bPlus.getLocationOnScreen();
        bot.mouseMove(locate.x,locate.y);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(25);

        txt.setText(panelKey.buttonsEngineer.strInput.trim());
        locate=panelKey.buttonsEngineer.b8.getLocationOnScreen();
        bot.mouseMove(locate.x,locate.y);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(25);

        txt.setText(panelKey.buttonsEngineer.strInput.trim());
        locate=panelKey.buttonsEngineer.braceClose.getLocationOnScreen();
        bot.mouseMove(locate.x,locate.y);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(25);

        txt.setText(panelKey.buttonsEngineer.strInput.trim());
        locate=panelKey.buttonsEngineer.bPercent.getLocationOnScreen();
        bot.mouseMove(locate.x,locate.y);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(25);

//2+8+(9-(2-5)-(2+8)%
        assertEquals("9-(2-5)", panelKey.buttonsEngineer.strPersentFrom.trim());
        assertEquals("-", panelKey.buttonsEngineer.nameSign.trim());
        assertEquals("10", panelKey.buttonsEngineer.countNumber);
        assertEquals("2+8+", panelKey.buttonsEngineer.strBeforePersent.trim());
        assertEquals("20.8", panelKey.buttonsEngineer.countResult);
    }

    @Test         // 2(7+(2*+8%
    @SneakyThrows (InterruptedException.class)
    void percent_Braces_2open_0close()  {
        bot.keyPress(KeyEvent.VK_2);
        Thread.sleep(20);
        bot.keyRelease(KeyEvent.VK_2);

        txt.setText(panelKey.buttonsEngineer.strInput.trim());
        locate=panelKey.buttonsEngineer.braceOpen.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(40);

        txt.setText(panelKey.buttonsEngineer.strInput.trim());
        bot.keyPress(KeyEvent.VK_7);
        Thread.sleep(20);
        bot.keyRelease(KeyEvent.VK_7);

        txt.setText(panelKey.buttonsEngineer.strInput.trim());
        bot.keyPress(KeyEvent.VK_ADD);
        Thread.sleep(40);
        bot.keyRelease(KeyEvent.VK_ADD);

        txt.setText(panelKey.buttonsEngineer.strInput.trim());
        locate=panelKey.buttonsEngineer.braceOpen.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(40);

        txt.setText(panelKey.buttonsEngineer.strInput.trim());
        bot.keyPress(KeyEvent.VK_2);
        Thread.sleep(20);
        bot.keyRelease(KeyEvent.VK_2);

        txt.setText(panelKey.buttonsEngineer.strInput.trim());
        bot.keyPress(KeyEvent.VK_MULTIPLY);
        Thread.sleep(40);
        bot.keyRelease(KeyEvent.VK_MULTIPLY);

        txt.setText(panelKey.buttonsEngineer.strInput.trim());
        bot.keyPress(KeyEvent.VK_ADD);
        Thread.sleep(40);
        bot.keyRelease(KeyEvent.VK_ADD);


        txt.setText(panelKey.buttonsEngineer.strInput.trim());
        bot.keyPress(KeyEvent.VK_8);
        Thread.sleep(20);
        bot.keyRelease(KeyEvent.VK_8);

        txt.setText(panelKey.buttonsEngineer.strInput.trim());
        locate=panelKey.buttonsEngineer.bPercent.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(25);

// 2(7+(2*+8%
        assertEquals("2", panelKey.buttonsEngineer.strPersentFrom.trim());
        assertEquals("+", panelKey.buttonsEngineer.nameSign.trim());
        assertEquals("8", panelKey.buttonsEngineer.countNumber);

        assertEquals("2*(7+", panelKey.buttonsEngineer.strBeforePersent.trim());
        assertEquals("18.32", panelKey.buttonsEngineer.countResult);
    }

    @Test        // 2(2+(7+3)+(2*+8%
    @SneakyThrows (InterruptedException.class)
    void percent_Braces_3open_1close()  {
        locate=panelKey.buttonsEngineer.b2.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(25);

        txt.setText(panelKey.buttonsEngineer.strInput.trim());
        locate=panelKey.buttonsEngineer.braceOpen.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(25);

        txt.setText(panelKey.buttonsEngineer.strInput.trim());
        locate=panelKey.buttonsEngineer.b2.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(25);

        txt.setText(panelKey.buttonsEngineer.strInput.trim());
        locate=panelKey.buttonsEngineer.bPlus.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(25);

        txt.setText(panelKey.buttonsEngineer.strInput.trim());
        locate=panelKey.buttonsEngineer.braceOpen.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(25);

        txt.setText(panelKey.buttonsEngineer.strInput.trim());
        locate=panelKey.buttonsEngineer.b7.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(25);

        txt.setText(panelKey.buttonsEngineer.strInput.trim());
        locate=panelKey.buttonsEngineer.bPlus.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(25);

        txt.setText(panelKey.buttonsEngineer.strInput.trim());
        locate=panelKey.buttonsEngineer.b3.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(25);

        txt.setText(panelKey.buttonsEngineer.strInput.trim());
        locate=panelKey.buttonsEngineer.braceClose.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(25);

        txt.setText(panelKey.buttonsEngineer.strInput.trim());
        locate=panelKey.buttonsEngineer.bPlus.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(25);


        txt.setText(panelKey.buttonsEngineer.strInput.trim());
        locate=panelKey.buttonsEngineer.braceOpen.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(25);

        txt.setText(panelKey.buttonsEngineer.strInput.trim());
        locate=panelKey.buttonsEngineer.b2.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(25);


        txt.setText(panelKey.buttonsEngineer.strInput.trim());
        locate=panelKey.buttonsEngineer.bPlus.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(25);

        txt.setText(panelKey.buttonsEngineer.strInput.trim());
        locate=panelKey.buttonsEngineer.b8.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(25);

        txt.setText(panelKey.buttonsEngineer.strInput.trim());
        locate=panelKey.buttonsEngineer.bPercent.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(25);

// 2(2+(7+3)+(2*+8%
        assertEquals("2", panelKey.buttonsEngineer.strPersentFrom.trim());
        assertEquals("+", panelKey.buttonsEngineer.nameSign.trim());
        assertEquals("8", panelKey.buttonsEngineer.countNumber);
        assertEquals("2*(2+(7+3)+", panelKey.buttonsEngineer.strBeforePersent.trim());
        assertEquals("28.32", panelKey.buttonsEngineer.countResult);
    }

    @Test        //200+5%+5
    @SneakyThrows (InterruptedException.class)
    void after_percent_plus5() {
        bot.keyPress(KeyEvent.VK_2);
        Thread.sleep(40);
        bot.keyRelease(KeyEvent.VK_2);

        txt.setText(panelKey.buttonsEngineer.strInput.trim());
        bot.keyPress(KeyEvent.VK_0);
        Thread.sleep(20);
        bot.keyRelease(KeyEvent.VK_0);

        txt.setText(panelKey.buttonsEngineer.strInput.trim());
        bot.keyPress(KeyEvent.VK_0);
        Thread.sleep(20);
        bot.keyRelease(KeyEvent.VK_0);

        txt.setText(panelKey.buttonsEngineer.strInput.trim());
        bot.keyPress(KeyEvent.VK_ADD);
        Thread.sleep(40);
        bot.keyRelease(KeyEvent.VK_ADD);

        txt.setText(panelKey.buttonsEngineer.strInput.trim());
        bot.keyPress(KeyEvent.VK_5);
        Thread.sleep(20);
        bot.keyRelease(KeyEvent.VK_5);

        txt.setText(panelKey.buttonsEngineer.strInput.trim());
        locate = panelKey.buttonsEngineer.bPercent.getLocationOnScreen();
        bot.mouseMove(locate.x + 10, locate.y + 10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(20);

        txt.setText(panelKey.buttonsEngineer.strInput.trim());
        bot.keyPress(KeyEvent.VK_ADD);
        Thread.sleep(40);
        bot.keyRelease(KeyEvent.VK_ADD);

        txt.setText(panelKey.buttonsEngineer.strInput.trim());
        bot.keyPress(KeyEvent.VK_5);
        Thread.sleep(20);
        bot.keyRelease(KeyEvent.VK_5);

        //200+5%+5
        assertEquals("200", panelKey.buttonsEngineer.strPersentFrom.trim());
        assertEquals("+", panelKey.buttonsEngineer.nameSign.trim());
        assertEquals("5", panelKey.buttonsEngineer.countNumber);
        assertEquals("", panelKey.buttonsEngineer.strBeforePersent.trim());
        assertEquals("210+5", panelKey.buttonsEngineer.strInput);
        assertEquals("215", panelKey.buttonsEngineer.countResult);
    }

    @Test        //200+5%5
    @SneakyThrows (InterruptedException.class)
    void after_percent_number5() {
        bot.keyPress(KeyEvent.VK_2);
        Thread.sleep(10);
        bot.keyRelease(KeyEvent.VK_2        );

        txt.setText(panelKey.buttonsEngineer.strInput.trim());
        bot.keyPress(KeyEvent.VK_0);
        Thread.sleep(10);
        bot.keyRelease(KeyEvent.VK_0);

        txt.setText(panelKey.buttonsEngineer.strInput.trim());
        bot.keyPress(KeyEvent.VK_0);
        Thread.sleep(10);
        bot.keyRelease(KeyEvent.VK_0);

        txt.setText(panelKey.buttonsEngineer.strInput.trim());
        bot.keyPress(KeyEvent.VK_ADD);
        Thread.sleep(25);
        bot.keyRelease(KeyEvent.VK_ADD);

        txt.setText(panelKey.buttonsEngineer.strInput.trim());
        bot.keyPress(KeyEvent.VK_5);
        Thread.sleep(10);
        bot.keyRelease(KeyEvent.VK_5);

        txt.setText(panelKey.buttonsEngineer.strInput.trim());
        locate = panelKey.buttonsEngineer.bPercent.getLocationOnScreen();
        bot.mouseMove(locate.x + 10, locate.y + 10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(25);

        txt.setText(panelKey.buttonsEngineer.strInput.trim());
        bot.keyPress(KeyEvent.VK_5);
        Thread.sleep(10);
        bot.keyRelease(KeyEvent.VK_5);

        //200+5%+5
        assertEquals("200", panelKey.buttonsEngineer.strPersentFrom.trim());
        assertEquals("+", panelKey.buttonsEngineer.nameSign.trim());
        assertEquals("5", panelKey.buttonsEngineer.strNumber);
        assertEquals("", panelKey.buttonsEngineer.strBeforePersent.trim());
        assertEquals("5", panelKey.buttonsEngineer.countResult);

    }
}