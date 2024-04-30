package face;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import javax.swing.*;
import java.awt.*;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class KeyboardInputTest {
    JTextPane txt;
    JLabel lable;
    @Mock
    PanelTextLog textPanel;

    @BeforeAll
    void init()   {
        txt =new JTextPane();
        lable= new JLabel();
        lable.setText("22");

        Mockito.doNothing().when(textPanel).setSbLog(Mockito.any());
        Mockito.when(textPanel.getSbLog()).thenReturn(new StringBuffer(" "));
        Mockito.when(textPanel.getTextInput()).thenReturn(txt);
        Mockito.when(textPanel.getTextResult()).thenReturn(lable);
    }
    @Test
    void getOperandCompletesCorrectlyWithNotNumbers () {
        String testedValue = "k";
        ByteArrayInputStream in = new ByteArrayInputStream(testedValue.getBytes());
        ByteArrayOutputStream out = new ByteArrayOutputStream();

        System.setIn(in);
        System.setOut(new PrintStream(out));



        System.setIn(System.in);
        System.setOut(null);
    }

}