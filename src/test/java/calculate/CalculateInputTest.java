package calculate;

import face.MyException;
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
    void oder_and_braces (String strInput, String expectedResult) throws MyException {
        assertEquals (expectedResult,sut.calculateInput(strInput));
    }
    @ParameterizedTest
    @CsvSource( value =  {
            " 8-(5-8), 11",
            " (8-6)*(5-8), -6",
    })
    void negative_in_braces (String strInput, String expectedResult) throws MyException {
        assertEquals (expectedResult,sut.calculateInput(strInput));
    }
    @ParameterizedTest
    @CsvSource( value =  {
            " 2 - (5-8, 5",
            " 2+(3-(5-8, 8",
            " 5-(2-(3-(5-8, 9",
            " 8-(5-4)+(2-(3-(5-8, 3",
    })
    void differentNumber_openANDclose_braces (String strInput, String expectedResult)  throws MyException {
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
    void power2 (String strInput, String expectedResult)  throws MyException {
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
    void power3 (String strInput, String expectedResult)  throws MyException {
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
    void powerN (String strInput, String expectedResult)  throws MyException{
        assertEquals (expectedResult,sut.calculateInput(strInput));
    }





    @ParameterizedTest
    @CsvSource( value =  {
            " 3!, 6",
            "10!, 3628800",
            " 2+3!, 8",
            " 3!*5, 30",
            " (2+3)!*(22-21)!, 120",

    })
    void factorial (String strInput, String expectedResult)  throws MyException {
        assertEquals (expectedResult,sut.calculateInput(strInput));
    }

    @ParameterizedTest
    @CsvSource( value =  {
            "3+-2!",
            "-2!",
            " 3.2!",
            "(4+2)!+(5-8)!",
            "2*(-5)!",
            "(8/5)!",
            "8-4.4!",
            "(25-5²)!"
    })
    void Exception_factorial(String strInput) {
        Throwable ex = assertThrows(
                MyException.class,
                () -> {
                    sut.calculateInput(strInput);
                },
                "!!!НЕТУ!!!"
        );
        assertEquals("неверный формат ввода факториала", ex.getMessage());
    }






    @ParameterizedTest
    @CsvSource( value =  {
            " ³√27, 3",
            " ³√27+5, 8",
            " 55+³√27, 58",
            " 23-³√27*11, -10",
            " ³√(3²+2*9), 3",
            "³√(57-30)² ,9",
            " ³√(3²+2*9, 3",
            "³√(3²-2²+5!), 5 ",
            " ³√(3²+2*(27-3*(6, 3",

    })
    void sqrt3_positive (String strInput, String expectedResult)  throws MyException {
        assertEquals (expectedResult,sut.calculateInput(strInput));
    }
    @ParameterizedTest
    @CsvSource( value =  {
            " ³√(30-57), -3",
            " ³√-27, -3",
            " ³√(3²+2*(6-4*(6, -3",
            " 8*³√-27, -24",
            " ³√-27², 9",
    })
    void sqrt3_negative (String strInput, String expectedResult)  throws MyException {
        assertEquals (expectedResult,sut.calculateInput(strInput));
    }
    @ParameterizedTest
    @CsvSource( value =  {
            "³√(9^999)",
            "8*³√(9^999)",
            "³√(9^999)/9",

            "³√(-9^999)",
    })
    void Exception_sqrt3(String strInput)throws MyException{
        Throwable ex = assertThrows(
                MyException.class,
                () -> {
                    sut.calculateInput(strInput);
                },
                "!!!НЕТУ!!!"
        );
        assertEquals("³√ недозволеного большого числа", ex.getMessage());

    }




    @ParameterizedTest
    @CsvSource( value =  {
            " cos(60+120)²-cos(3*30)²,   1",
            " cos (200+160),   1",
            " cos((5*3)²+(3+4)²-4),   0",
    })
    void cos_positive (String strInput, String expectedResult)  throws MyException {
        assertEquals (expectedResult,sut.calculateInput(strInput));
    }

    @ParameterizedTest
    @CsvSource( value =  {
            " cos(-30),    0.866025403784439",
            " cos(90-180),   0",
            " cos(123-123),   1",
            " cos(2*30)+cos(20-7*20),   0",
            " cos(-135),   -0.707106781186547",
            " cos(180)²,   1",
            " cos(3*60)²+cos(60*2)²,   1.25",
    })
    void cos_negative (String strInput, String expectedResult)  throws MyException {
        assertEquals (expectedResult,sut.calculateInput(strInput));
    }
    @ParameterizedTest
    @CsvSource( value =  {
            "cos(9^999)",
            "8*cos(9^999)",
            "cos(9^999)/9",
            "cos(-9^999)",
    })
    void Exception_cos(String strInput)throws MyException{
        Throwable ex = assertThrows(
                MyException.class,
                () -> {
                    sut.calculateInput(strInput);
                },
                "!!!НЕТУ!!!"
        );
        assertEquals("cos не существует", ex.getMessage());

    }


    @ParameterizedTest
    @CsvSource( value =  {
            " sin(60+120)²-sin (3*30)²,   -1",
            " sin (200+160),   0",
            " sin((5*3)²+(3+4)²-4),   -1",
    })
    void sin_positive (String strInput, String expectedResult)  throws MyException {
        assertEquals (expectedResult,sut.calculateInput(strInput));
    }
    @ParameterizedTest
    @CsvSource( value =  {
            " sin(-30),     -0.5",
            " sin(90-180),   -1",
            " sin(123-123),   0",
            " sin(2*30)+sin(20-7*20),   0",
            " sin(-135),   -0.707106781186548",
            " sin(-90)²,   1",
            " sin(-3*30)²+sin(90*3)²,   2",
    })
    void sin_negative (String strInput, String expectedResult)  throws MyException {
        assertEquals (expectedResult,sut.calculateInput(strInput));
    }
    @ParameterizedTest
    @CsvSource( value =  {
            "sin(9^999)",
            "8*sin(9^999)",
            "sin(9^999)/9",
            "sin(-9^999)",
    })
    void sin(String strInput)throws MyException{
        Throwable ex = assertThrows(
                MyException.class,
                () -> {
                    sut.calculateInput(strInput);
                },
                "!!!НЕТУ!!!"
        );
        assertEquals("sin не существует", ex.getMessage());

    }




}



