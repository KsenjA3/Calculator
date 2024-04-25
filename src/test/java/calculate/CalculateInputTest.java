package calculate;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class CalculateInputTest {
    private static CalculateInput sut;

    @BeforeAll
    static void setCalculateBasicInput () {
        sut = new CalculateInput();
    }

    @ParameterizedTest
    @CsvSource( value =  {
            " 2 - (5-8, 5",
            " (30-8*(2+1))-9/3,  3",
            " 10*(5-3)*(9-6), 60",
            " 40-2*(3+7), 20",
            " 50-2*(3+7)*(5-3), 10",
            " 2*(3+7)*(5-3), 40",
            " 50-2*10*2, 10",
            "2+(50-40)*((25-10)-(15-10)-(10-12))-100,22",
            "22-(11*3), -11"
    })
    void oder_and_braces (String strInput, double expectedResult) {
        assertEquals (expectedResult,sut.calculateInput(strInput));
    }



}