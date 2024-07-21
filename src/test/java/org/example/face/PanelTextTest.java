package org.example.face;

import org.example.calculate.CalculateBasic;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class PanelTextTest {


    private PanelText sut;
    @BeforeAll
    void setCalculateBasicInput() {
        MockitoAnnotations.openMocks(this);
        sut = new PanelText();
    }

    @ParameterizedTest
    @CsvSource(value = {
            "dec, 111222333444555 + 66777888999, 111 222 333 444 555 +66 777 888 999",
            "double, 111222333444555 + 66777888999, 111 222 333 444 555 +66 777 888 999",
            "bin, 1111000011110000 + 110000111100001111, 1111 0000 1111 0000 +11 0000 1111 0000 1111",
            "hex, 1111FDEA3333BCDA5555 + 66ADEF8888DAED9999, 1111 FDEA 3333 BCDA 5555 +66 ADEF 8888 DAED 9999",
    })
    void setDigitNumber(String format, String oldStr, String expectedResult) {
            assertEquals(expectedResult, sut.digitNumbers(format,oldStr));

    }
}