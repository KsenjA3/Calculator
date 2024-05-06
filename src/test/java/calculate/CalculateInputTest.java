package calculate;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
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


    @ParameterizedTest
    @CsvSource( value =  {
            " 8-(5-8), 11",
            " (8-6)*(5-8), -6",
    })
    void negative_in_braces (String strInput, double expectedResult) {
        assertEquals (expectedResult,sut.calculateInput(strInput));
    }


    @ParameterizedTest
    @CsvSource( value =  {
            " 2 - (5-8, 5",
            " 2+(3-(5-8, 8",
            " 5-(2-(3-(5-8, 9",
            " 8-(5-4)+(2-(3-(5-8, 3",
    })
    void differentNumber_openANDclose_braces (String strInput, double expectedResult) {
        assertEquals (expectedResult,sut.calculateInput(strInput));
    }

    @ParameterizedTest
    @CsvSource( value =  {
            "3², 9",
            "(6-8)², 4",
            "2-(6-8)², -2",
            "5+(6-8)², 9",
            "5*(6-8)², 20",
            "3²+2, 11",
            "3²+2², 13",
            "2²*(3-1), 8",
            "9-3²+2²+5, 9",
            "2*(3²+2²), 26",
            "2*(3+2)², 50",
            "(2+4)²+(3+2)², 61",
            "(2+4)²-(3²+2²), 23",
    })
    void power2 (String strInput, double expectedResult) {
        assertEquals (expectedResult,sut.calculateInput(strInput));
    }

    @ParameterizedTest
    @CsvSource( value =  {
            "3³, 27",
            "3³+2, 29",
            "3³+2³, 35",
            "(8-5)³, 27",
            "(6-8)³, -8",
            "2-(6-8)³, 10",
            "5+(6-8)³,-3",
            "5*(6-8)³, -40",
            "(3³-2³)²-300, 61",
            "2*(3²-2²)³, 250",
            "2+(3-3)³, 2",
            "(4+2)³+(3+2)², 241",
            "(4-2)³-(3³+2²), -23",
    })
    void power3 (String strInput, double expectedResult) {
        assertEquals (expectedResult,sut.calculateInput(strInput));
    }

    @ParameterizedTest
    @CsvSource( value =  {
            " 10-(3-5)^3, 18",
            " 10-(2-5)^2, 1",
            " (7-5)^2, 4",
            " (3-5)^2, 4",
            "2+(-3)^2, 11",
            "2+(-3)^3, -25",
            "2*3+(-3)^2, 15",
            "2^(-1), 0.5",
            "2+2^(-2), 2.25",
            "0^2, 0",
            "0^1, 0",
    })
    void powerN (String strInput, double expectedResult) {
        assertEquals (expectedResult,sut.calculateInput(strInput), 0.000000001);
    }

    @ParameterizedTest
    @CsvSource( value =  {
            "0^(-1)",
            "5/0",
            "(10-5*2)^(5-6)",
            "(25-8)/(6*2-12)",
    })
    void Exception_division_by_zero(String strInput){
        Throwable ex = assertThrows(
                ArithmeticException.class,
                ()->{
                    sut.calculateInput(strInput);

                },
                "no throws"
        );

        assertEquals("Division by zero", ex.getMessage());

    }



}