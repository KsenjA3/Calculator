package org.example.face;

import lombok.SneakyThrows;
import org.example.calculate.Operations;
import org.example.fitting.MyFormatNumbers;
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

import static org.junit.jupiter.api.Assertions.assertEquals;


//@NotThreadSafe

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class ButtonsBasicTest {
    Point locate;
    JTextPane txt;
    JLabel label;
    JFrame frame;
    PanelKeyBasic panelKey;
    Robot bot;
    
    @Mock
    PanelTextLog textPanel;

    @AfterAll
    void hideFrame() {
        frame.setVisible(false);
    }

    @BeforeEach
    void initFrame()  {
        panelKey.buttonsBasic.strNumber=" ";
        txt.setText("");
//        panelKey.buttonsBasic.bPoint.setEnabled(true);

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
        panelKey =new PanelKeyBasic(textPanel);

        frame.add(panelKey.getKeyPanel());
        frame.setVisible(true);

        bot = new Robot();
        txt =new JTextPane();
        label= new JLabel();
        label.setText("22");


        Mockito.doNothing().when(textPanel).setSbLog(Mockito.any());
        Mockito.doNothing().when(textPanel).setTextInput(Mockito.any(),Mockito.any());
        Mockito.doNothing().when(textPanel).setTextResult(Mockito.any(),Mockito.any());

        Mockito.when(textPanel.getSbLog()).thenReturn(new StringBuffer(" "));
        Mockito.when(textPanel.getTextInput()).thenReturn(txt);
        Mockito.when(textPanel.getTextResult()).thenReturn(label);

    }


    @Test
    @SneakyThrows (InterruptedException.class)
    void sign_pressFirst( ) {

        locate = panelKey.buttonsBasic.bPlus.getLocationOnScreen();
        bot.mouseMove(locate.x + 10, locate.y + 10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(25);


        txt.setText(panelKey.buttonsBasic.strInput);
        locate = panelKey.buttonsBasic.b2.getLocationOnScreen();
        bot.mouseMove(locate.x + 10, locate.y + 10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(25);

        assertEquals("0+2", panelKey.buttonsBasic.strInput.replaceAll(" ",""));
    }

    @Disabled
    @Test
    @SneakyThrows (InterruptedException.class)
    void point_pressFirst( ) {
        txt.setText("0");
        locate = panelKey.buttonsBasic.bPoint.getLocationOnScreen();
        bot.mouseMove(locate.x + 10, locate.y + 10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(25);


        txt.setText(panelKey.buttonsBasic.strInput);
        locate = panelKey.buttonsBasic.b2.getLocationOnScreen();
        bot.mouseMove(locate.x + 10, locate.y + 10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(25);

        assertEquals("0.2", panelKey.buttonsBasic.strInput.replaceAll(" ",""));
    }

    @Test
    @SneakyThrows (InterruptedException.class)
    void null_point_pressFirst( ) {

        locate = panelKey.buttonsBasic.b5.getLocationOnScreen();
        bot.mouseMove(locate.x + 10, locate.y + 10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(25);

        txt.setText(panelKey.buttonsBasic.strInput);
        locate = panelKey.buttonsBasic.bDivide.getLocationOnScreen();
        bot.mouseMove(locate.x + 10, locate.y + 10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(25);


        txt.setText(panelKey.buttonsBasic.strInput);
        locate = panelKey.buttonsBasic.b0.getLocationOnScreen();
        bot.mouseMove(locate.x + 10, locate.y + 10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(25);

        txt.setText(panelKey.buttonsBasic.strInput);
        locate = panelKey.buttonsBasic.bPoint.getLocationOnScreen();
        bot.mouseMove(locate.x + 10, locate.y + 10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(25);

        txt.setText(panelKey.buttonsBasic.strInput);
        locate = panelKey.buttonsBasic.b2.getLocationOnScreen();
        bot.mouseMove(locate.x + 10, locate.y + 10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(25);

        assertEquals("5/0.2", panelKey.buttonsBasic.strInput.replaceAll(" ",""));
        assertEquals("25", panelKey.buttonsBasic.countResult);
    }

    @Test
    @SneakyThrows (InterruptedException.class)
    void number_press( )  {

        locate=panelKey.buttonsBasic.b1.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(25);
        assertEquals("1", panelKey.buttonsBasic.strNumber.replaceAll(" ",""));

        locate=panelKey.buttonsBasic.b2.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(25);
        assertEquals("12", panelKey.buttonsBasic.strNumber.replaceAll(" ",""));

        locate=panelKey.buttonsBasic.b3.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(25);
        assertEquals("123", panelKey.buttonsBasic.strNumber.replaceAll(" ",""));

        locate=panelKey.buttonsBasic.b4.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(25);
        assertEquals("1234", panelKey.buttonsBasic.strNumber.replaceAll(" ",""));

        locate=panelKey.buttonsBasic.b5.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(25);
        assertEquals("12345", panelKey.buttonsBasic.strNumber.replaceAll(" ",""));

        panelKey.buttonsBasic.strNumber=" ";
        locate=panelKey.buttonsBasic.b6.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(25);
        assertEquals("6", panelKey.buttonsBasic.strNumber.replaceAll(" ",""));

        txt.setText(panelKey.buttonsBasic.strInput);
        locate=panelKey.buttonsBasic.b7.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(25);
        assertEquals("67", panelKey.buttonsBasic.strNumber.replaceAll(" ",""));

        txt.setText(panelKey.buttonsBasic.strInput);
        locate=panelKey.buttonsBasic.b8.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(25);
        assertEquals("678", panelKey.buttonsBasic.strNumber.replaceAll(" ",""));

        txt.setText(panelKey.buttonsBasic.strInput);
        locate=panelKey.buttonsBasic.b9.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(25);
        assertEquals("6789", panelKey.buttonsBasic.strNumber.replaceAll(" ",""));
        assertEquals("6789", panelKey.buttonsBasic.strInput.replaceAll(" ",""));



        panelKey.buttonsBasic.strNumber=" ";
        txt.setText(" ");
        locate=panelKey.buttonsBasic.b0.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(25);
        assertEquals("0", panelKey.buttonsBasic.strNumber.replaceAll(" ",""));
        assertEquals("0", panelKey.buttonsBasic.strInput.replaceAll(" ",""));

    }

    @Test  //2+3.0003
    @SneakyThrows (InterruptedException.class)
    void input_point_atFirst ()  {
        panelKey.buttonsBasic.strNumber="0";
        panelKey.buttonsBasic.strInput=" ";
        locate=panelKey.buttonsBasic.bPoint.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(25);
        assertEquals("0.", panelKey.buttonsBasic.strInput.replaceAll(" ",""));
    }

    @Test  //2+3.0003
    @SneakyThrows (InterruptedException.class)
    void input_number_double ()  {
        locate=panelKey.buttonsBasic.b2.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(25);

        txt.setText(panelKey.buttonsBasic.strInput);
        locate=panelKey.buttonsBasic.bPlus.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(25);

        txt.setText(panelKey.buttonsBasic.strInput);
        locate=panelKey.buttonsBasic.b3.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(25);

        txt.setText(panelKey.buttonsBasic.strInput);
        locate=panelKey.buttonsBasic.bPoint.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(25);

        txt.setText(panelKey.buttonsBasic.strInput);
        locate=panelKey.buttonsBasic.b0.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(25);

        txt.setText(panelKey.buttonsBasic.strInput);
        locate=panelKey.buttonsBasic.b0.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(25);

        txt.setText(panelKey.buttonsBasic.strInput);
        locate=panelKey.buttonsBasic.b0.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(25);

        txt.setText(panelKey.buttonsBasic.strInput);
        locate=panelKey.buttonsBasic.b3.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(25);

//2+3.0003
        assertEquals("2+3.0003", panelKey.buttonsBasic.strInput.replaceAll(" ",""));
        assertEquals("5.0003", panelKey.buttonsBasic.countResult);
    }

    @Test  //200.5+5.0003
    @SneakyThrows (InterruptedException.class)
    void input_ZIRO_inCentre_double ()  {
        locate=panelKey.buttonsBasic.b2.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(25);

        txt.setText(panelKey.buttonsBasic.strInput);
        locate=panelKey.buttonsBasic.b0.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(25);

        txt.setText(panelKey.buttonsBasic.strInput);
        locate=panelKey.buttonsBasic.b0.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(25);

        txt.setText(panelKey.buttonsBasic.strInput);
        locate=panelKey.buttonsBasic.bPoint.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(25);

        txt.setText(panelKey.buttonsBasic.strInput);
        locate=panelKey.buttonsBasic.b5.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(25);

        txt.setText(panelKey.buttonsBasic.strInput);
        locate=panelKey.buttonsBasic.bPlus.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(25);

        txt.setText(panelKey.buttonsBasic.strInput);
        locate=panelKey.buttonsBasic.b5.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(25);

        txt.setText(panelKey.buttonsBasic.strInput);
        locate=panelKey.buttonsBasic.bPoint.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(25);

        txt.setText(panelKey.buttonsBasic.strInput);
        locate=panelKey.buttonsBasic.b0.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(25);

        txt.setText(panelKey.buttonsBasic.strInput);
        locate=panelKey.buttonsBasic.b0.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(25);

        txt.setText(panelKey.buttonsBasic.strInput);
        locate=panelKey.buttonsBasic.b0.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(25);

        txt.setText(panelKey.buttonsBasic.strInput);
        locate=panelKey.buttonsBasic.b3.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(25);

//200.5+5.0003
        assertEquals("200.5+5.0003", panelKey.buttonsBasic.strInput.replaceAll(" ",""));
        assertEquals("205.5003", panelKey.buttonsBasic.countResult);
    }

    @Test  //2+.0003
    @SneakyThrows (InterruptedException.class)
    void input_double_beginWith_Point ()  {
        locate=panelKey.buttonsBasic.b2.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(25);

        txt.setText(panelKey.buttonsBasic.strInput);
        locate=panelKey.buttonsBasic.bPlus.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(25);

        txt.setText(panelKey.buttonsBasic.strInput);
        locate=panelKey.buttonsBasic.bPoint.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(25);

        txt.setText(panelKey.buttonsBasic.strInput);
        locate=panelKey.buttonsBasic.b0.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(25);

        txt.setText(panelKey.buttonsBasic.strInput);
        locate=panelKey.buttonsBasic.b0.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(25);

        txt.setText(panelKey.buttonsBasic.strInput);
        locate=panelKey.buttonsBasic.b0.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(25);

        txt.setText(panelKey.buttonsBasic.strInput);
        locate=panelKey.buttonsBasic.b3.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(25);

//2+0.0003
        assertEquals("2+0.0003", panelKey.buttonsBasic.strInput.replaceAll(" ",""));
        assertEquals("2.0003", panelKey.buttonsBasic.countResult);
    }

    @Test  //00002+3
    @SneakyThrows (InterruptedException.class)
    void input_beginWith_ZERO ()  {
        locate=panelKey.buttonsBasic.b0.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(25);

        txt.setText(panelKey.buttonsBasic.strInput);
        locate=panelKey.buttonsBasic.b0.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(25);

        txt.setText(panelKey.buttonsBasic.strInput);
        locate=panelKey.buttonsBasic.b0.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(25);

        txt.setText(panelKey.buttonsBasic.strInput);
        locate=panelKey.buttonsBasic.b0.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(25);

        txt.setText(panelKey.buttonsBasic.strInput);
        locate=panelKey.buttonsBasic.b2.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(25);

        txt.setText(panelKey.buttonsBasic.strInput);
        locate=panelKey.buttonsBasic.bPlus.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(25);

        txt.setText(panelKey.buttonsBasic.strInput);
        locate=panelKey.buttonsBasic.b3.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(25);



//00002+3
        assertEquals("2+3", panelKey.buttonsBasic.strInput.replaceAll(" ",""));
        assertEquals("5", panelKey.buttonsBasic.countResult);
    }

    @Test  //2+0003.3
    @SneakyThrows (InterruptedException.class)
    void input_double_beginWith_ZERO ()  {
        locate=panelKey.buttonsBasic.b2.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(25);

        txt.setText(panelKey.buttonsBasic.strInput);
        locate=panelKey.buttonsBasic.bPlus.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(25);

        txt.setText(panelKey.buttonsBasic.strInput);
        locate=panelKey.buttonsBasic.b0.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(25);

        txt.setText(panelKey.buttonsBasic.strInput);
        locate=panelKey.buttonsBasic.b0.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(25);

        txt.setText(panelKey.buttonsBasic.strInput);
        locate=panelKey.buttonsBasic.b0.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(25);

        txt.setText(panelKey.buttonsBasic.strInput);
        locate=panelKey.buttonsBasic.b3.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(25);

        txt.setText(panelKey.buttonsBasic.strInput);
        locate=panelKey.buttonsBasic.bPoint.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(25);

        txt.setText(panelKey.buttonsBasic.strInput);
        locate=panelKey.buttonsBasic.b3.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(25);

//2+0003.3
        assertEquals("2+3.3", panelKey.buttonsBasic.strInput.replaceAll(" ",""));
        assertEquals("5.3", panelKey.buttonsBasic.countResult);
    }

    @Test  //2+3= после ввод 8
    @SneakyThrows (InterruptedException.class)
    void input_number_after_result ()  {
        locate=panelKey.buttonsBasic.b2.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(25);

        txt.setText(panelKey.buttonsBasic.strInput);
        locate=panelKey.buttonsBasic.bPlus.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(25);

        txt.setText(panelKey.buttonsBasic.strInput);
        locate=panelKey.buttonsBasic.b3.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(25);

        txt.setText(panelKey.buttonsBasic.strInput);
        locate=panelKey.buttonsBasic.bResult.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(25);

        txt.setText(panelKey.buttonsBasic.strInput);
        locate=panelKey.buttonsBasic.b8.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(25);

        assertEquals("8", panelKey.buttonsBasic.strInput.replaceAll(" ",""));
    }

    @Test  //2+3% после ввод 8
    @SneakyThrows (InterruptedException.class)
    void input_number_after_percent ()  {
        locate=panelKey.buttonsBasic.b2.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(25);

        txt.setText(panelKey.buttonsBasic.strInput);
        locate=panelKey.buttonsBasic.bPlus.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(25);

        txt.setText(panelKey.buttonsBasic.strInput);
        locate=panelKey.buttonsBasic.b3.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(25);

        txt.setText(panelKey.buttonsBasic.strInput);
        locate=panelKey.buttonsBasic.bPercent.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(25);

        txt.setText(panelKey.buttonsBasic.strInput);
        locate=panelKey.buttonsBasic.b8.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(25);

        //2+3% после ввод 8
        assertEquals("8", panelKey.buttonsBasic.strInput.replaceAll(" ",""));

        assertEquals("2", panelKey.buttonsBasic.calculateCurrent.calculateBasic.getStrPersentFrom().replaceAll(" ",""));
        assertEquals("+", panelKey.buttonsBasic.calculateCurrent.calculateBasic.getNameSign());
//        .replaceAll(" ",""));
        assertEquals("3", panelKey.buttonsBasic.calculateCurrent.calculateBasic.getCountNumber());
    }

    @Test // 7√√√+ == 7+
    @SneakyThrows (InterruptedException.class)
    void exchange_fewSqrt_to_plus()  {
        locate=panelKey.buttonsBasic.b7.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(25);

        txt.setText(panelKey.buttonsBasic.strInput);
        locate=panelKey.buttonsBasic.bRadical.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(25);

        txt.setText(panelKey.buttonsBasic.strInput);
        locate=panelKey.buttonsBasic.bRadical.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(25);

        txt.setText(panelKey.buttonsBasic.strInput);
        locate=panelKey.buttonsBasic.bRadical.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(25);

        txt.setText(panelKey.buttonsBasic.strInput);
        locate=panelKey.buttonsBasic.bPlus.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(25);

        assertEquals("7+", panelKey.buttonsBasic.strInput.replaceAll(" ",""));
    }

    @Test  //2-+5
    @SneakyThrows (InterruptedException.class)
    void fewSign_OneByOne ()  {
        locate=panelKey.buttonsBasic.b2.getLocationOnScreen();
            bot.mouseMove(locate.x+10,locate.y+10);
            bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
            bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(25);

        txt.setText(panelKey.buttonsBasic.strInput);
        locate=panelKey.buttonsBasic.bMinus.getLocationOnScreen();
            bot.mouseMove(locate.x+10,locate.y+10);
            bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
            bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(25);

        txt.setText(panelKey.buttonsBasic.strInput);
        locate=panelKey.buttonsBasic.bPlus.getLocationOnScreen();
            bot.mouseMove(locate.x+10,locate.y+10);
            bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
            bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(25);

        txt.setText(panelKey.buttonsBasic.strInput);
        locate=panelKey.buttonsBasic.b5.getLocationOnScreen();
            bot.mouseMove(locate.x+10,locate.y+10);
            bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
            bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(25);

        assertEquals("2+5", panelKey.buttonsBasic.strInput.replaceAll(" ",""));
    }

    @Test //8-+/*3
    @SneakyThrows (InterruptedException.class)
    void fourSign_OneByOne_keyBoard ()  {
//        panelKey.getKeyPanelEngineer().requestFocus();
        bot.keyPress(KeyEvent.VK_8);
        Thread.sleep(10);
        bot.keyRelease(KeyEvent.VK_8);

        txt.setText(panelKey.buttonsBasic.strInput);
        bot.keyPress(KeyEvent.VK_MINUS);
        Thread.sleep(10);

        txt.setText(panelKey.buttonsBasic.strInput);
        bot.keyPress(KeyEvent.VK_ADD);
        Thread.sleep(10);
        bot.keyRelease(KeyEvent.VK_ADD);

        txt.setText(panelKey.buttonsBasic.strInput);
        bot.keyPress(KeyEvent.VK_DIVIDE);
        Thread.sleep(10);
        bot.keyRelease(KeyEvent.VK_DIVIDE);

        txt.setText(panelKey.buttonsBasic.strInput);
        bot.keyPress(KeyEvent.VK_MULTIPLY);
        Thread.sleep(10);
        bot.keyRelease(KeyEvent.VK_MULTIPLY);

        txt.setText(panelKey.buttonsBasic.strInput);
        bot.keyPress(KeyEvent.VK_3);
        Thread.sleep(10);
        bot.keyRelease(KeyEvent.VK_3);

        assertEquals("8*3", panelKey.buttonsBasic.strInput.replaceAll(" ",""));
    }

    @Test //8√√√
    @SneakyThrows (InterruptedException.class)
    void fiveSqrt_OneByOne ()  {
        locate=panelKey.buttonsBasic.b8.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(25);

        txt.setText(panelKey.buttonsBasic.strInput);
        locate=panelKey.buttonsBasic.bRadical.getLocationOnScreen();
        bot.mouseMove(locate.x+10,locate.y+10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(25);

        txt.setText(panelKey.buttonsBasic.strInput);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(25);

        txt.setText(panelKey.buttonsBasic.strInput);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(25);

        txt.setText(panelKey.buttonsBasic.strInput);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(25);

        txt.setText(panelKey.buttonsBasic.strInput);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(25);

        //8√√√
        assertEquals("8√√√", panelKey.buttonsBasic.strInput.replaceAll(" ",""));
    }

    @Test        //200+5%+5
    @SneakyThrows (InterruptedException.class)
    void after_percent_plus5() {
        bot.keyPress(KeyEvent.VK_2);
        Thread.sleep(40);
        bot.keyRelease(KeyEvent.VK_2);

        txt.setText(panelKey.buttonsBasic.strInput);
        bot.keyPress(KeyEvent.VK_0);
        Thread.sleep(20);
        bot.keyRelease(KeyEvent.VK_0);

        txt.setText(panelKey.buttonsBasic.strInput);
        bot.keyPress(KeyEvent.VK_0);
        Thread.sleep(20);
        bot.keyRelease(KeyEvent.VK_0);

        txt.setText(panelKey.buttonsBasic.strInput);
        bot.keyPress(KeyEvent.VK_ADD);
        Thread.sleep(40);
        bot.keyRelease(KeyEvent.VK_ADD);

        txt.setText(panelKey.buttonsBasic.strInput);
        bot.keyPress(KeyEvent.VK_5);
        Thread.sleep(20);
        bot.keyRelease(KeyEvent.VK_5);

        txt.setText(panelKey.buttonsBasic.strInput);
        locate = panelKey.buttonsBasic.bPercent.getLocationOnScreen();
        bot.mouseMove(locate.x + 10, locate.y + 10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(20);

        txt.setText(panelKey.buttonsBasic.strInput);
        bot.keyPress(KeyEvent.VK_ADD);
        Thread.sleep(40);
        bot.keyRelease(KeyEvent.VK_ADD);

        txt.setText(panelKey.buttonsBasic.strInput);
        bot.keyPress(KeyEvent.VK_5);
        Thread.sleep(20);
        bot.keyRelease(KeyEvent.VK_5);

        //200+5%+5
        assertEquals("200", panelKey.buttonsBasic.calculateCurrent.calculateBasic.getStrPersentFrom().replaceAll(" ",""));
        assertEquals("+", panelKey.buttonsBasic.calculateCurrent.calculateBasic.getNameSign().replaceAll(" ",""));
        assertEquals("5", panelKey.buttonsBasic.calculateCurrent.calculateBasic.getCountNumber());
        assertEquals("", panelKey.buttonsBasic.calculateCurrent.calculateBasic.getStrBeforePersent().replaceAll(" ",""));
        assertEquals("210+5", panelKey.buttonsBasic.strInput.replaceAll(" ",""));
        assertEquals("215", panelKey.buttonsBasic.countResult);
    }

    @Test        //200+5%5
    @SneakyThrows (InterruptedException.class)
    void after_percent_number5() {
        bot.keyPress(KeyEvent.VK_2);
        Thread.sleep(10);
        bot.keyRelease(KeyEvent.VK_2        );

        txt.setText(panelKey.buttonsBasic.strInput);
        bot.keyPress(KeyEvent.VK_0);
        Thread.sleep(10);
        bot.keyRelease(KeyEvent.VK_0);

        txt.setText(panelKey.buttonsBasic.strInput);
        bot.keyPress(KeyEvent.VK_0);
        Thread.sleep(10);
        bot.keyRelease(KeyEvent.VK_0);

        txt.setText(panelKey.buttonsBasic.strInput);
        bot.keyPress(KeyEvent.VK_ADD);
        Thread.sleep(25);
        bot.keyRelease(KeyEvent.VK_ADD);

        txt.setText(panelKey.buttonsBasic.strInput);
        bot.keyPress(KeyEvent.VK_5);
        Thread.sleep(10);
        bot.keyRelease(KeyEvent.VK_5);

        txt.setText(panelKey.buttonsBasic.strInput);
        locate = panelKey.buttonsBasic.bPercent.getLocationOnScreen();
        bot.mouseMove(locate.x + 10, locate.y + 10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(25);

        txt.setText(panelKey.buttonsBasic.strInput);
        bot.keyPress(KeyEvent.VK_5);
        Thread.sleep(10);
        bot.keyRelease(KeyEvent.VK_5);

        //200+5%+5
        assertEquals("200", panelKey.buttonsBasic.calculateCurrent.calculateBasic.getStrPersentFrom().replaceAll(" ",""));
        assertEquals("+", panelKey.buttonsBasic.calculateCurrent.calculateBasic.getNameSign().replaceAll(" ",""));
        assertEquals("5", panelKey.buttonsBasic.strNumber);
        assertEquals("", panelKey.buttonsBasic.calculateCurrent.calculateBasic.getStrBeforePersent().replaceAll(" ",""));
        assertEquals("5", panelKey.buttonsBasic.countResult);

    }

    @Test        //200+5%
    @SneakyThrows (InterruptedException.class)
    void after_200_plus_5_percent() {
        bot.keyPress(KeyEvent.VK_2);
        Thread.sleep(40);
        bot.keyRelease(KeyEvent.VK_2);

        txt.setText(panelKey.buttonsBasic.strInput);
        bot.keyPress(KeyEvent.VK_0);
        Thread.sleep(20);
        bot.keyRelease(KeyEvent.VK_0);

        txt.setText(panelKey.buttonsBasic.strInput);
        bot.keyPress(KeyEvent.VK_0);
        Thread.sleep(20);
        bot.keyRelease(KeyEvent.VK_0);

        txt.setText(panelKey.buttonsBasic.strInput);
        bot.keyPress(KeyEvent.VK_ADD);
        Thread.sleep(40);
        bot.keyRelease(KeyEvent.VK_ADD);

        txt.setText(panelKey.buttonsBasic.strInput);
        bot.keyPress(KeyEvent.VK_5);
        Thread.sleep(20);
        bot.keyRelease(KeyEvent.VK_5);

        txt.setText(panelKey.buttonsBasic.strInput);
        locate = panelKey.buttonsBasic.bPercent.getLocationOnScreen();
        bot.mouseMove(locate.x + 10, locate.y + 10);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(20);


        //200+5%+5
//        assertEquals("200", panelKey.buttonsBasic.calculateCurrent.calculateBasic.getStrPersentFrom().replaceAll(" ",""));
//        assertEquals("+", panelKey.buttonsBasic.calculateCurrent.calculateBasic.getNameSign().replaceAll(" ",""));
//        assertEquals("5", panelKey.buttonsBasic.calculateCurrent.calculateBasic.getCountNumber());
//        assertEquals("", panelKey.buttonsBasic.calculateCurrent.calculateBasic.getStrBeforePersent().replaceAll(" ",""));
        assertEquals("200+5%", panelKey.buttonsBasic.strInput.replaceAll(" ",""));
        assertEquals("210", panelKey.buttonsBasic.countResult);
    }









}