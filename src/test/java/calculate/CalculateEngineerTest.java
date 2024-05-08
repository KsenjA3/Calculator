package calculate;

import face.MyException;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class CalculateEngineerTest {
    private static CalculateEngineer sut;

    @BeforeAll
    static void setCalculateBasicInput () {
        sut = new CalculateEngineer();
    }

    @ParameterizedTest
    @CsvSource( value =  {
            " 5²,², 25",
            " 14+5²,², 14+25",
            " 5+5²-8,², 5+25-8",
            " 5+5²-3²,², 5+25-3²",
    })
    void power2_positive  (String strInput,String name, String expectedResult) throws MyException {
        assertEquals (expectedResult,sut.calculateEngineer(strInput, name));
    }

    @ParameterizedTest
    @CsvSource( value =  {
            " -5²,², 25",
            " 14+-5²,², 14+25",
            " 5+-5²-8,², 5+25-8",
            " 5+-5²-3²,², 5+25-3²",
    })
    void power2_negative  (String strInput,String name, String expectedResult) throws MyException {
        assertEquals (expectedResult,sut.calculateEngineer(strInput, name));
    }


    @ParameterizedTest
    @CsvSource( value =  {
            " 2³,³, 8",
            " 14+2³,³, 14+8",
            " 5+2³-8,³, 5+8-8",
            " 5+2³-3³,³, 5+8-3³",
    })
    void power3_positive  (String strInput,String name, String expectedResult) throws MyException {
        assertEquals (expectedResult,sut.calculateEngineer(strInput, name));
    }

    @ParameterizedTest
    @CsvSource( value =  {
            " -2³,³, -8",
            " 14+-2³,³, 14+-8",
            " 5+-2³-8,³, 5+-8-8",
            " 5+-2³-3³,³, 5+-8-3³",
    })
    void power3_negative  (String strInput,String name, String expectedResult) throws MyException {
        assertEquals (expectedResult,sut.calculateEngineer(strInput, name));
    }
    @ParameterizedTest
    @CsvSource( value =  {
            " 2³, 8",
            " 14+2³, 14+8",
            " 5+2³-8, 5+8-8",
            " 5+2³-3³, 5+8-3³",
    })
    void powerN_positive  (String strInput, String expectedResult) throws MyException {
        assertEquals (expectedResult,sut.calculateEngineer(strInput, "³"));
    }

    @ParameterizedTest
    @CsvSource( value =  {
            " -2³, -8",
            " 14+-2³, 14+-8",
            " 5+-2³-8, 5+-8-8",
            " 5+-2³-3³, 5+-8-3³",
    })
    void powerN_negative  (String strInput, String expectedResult) throws MyException {
        assertEquals (expectedResult,sut.calculateEngineer(strInput, "³"));
    }



    @ParameterizedTest
    @CsvSource( value =  {
            " 3!, 6",
            " 2+3!, 2+6",
            " 3!*5, 6*5",
            "10!, 3628800",
    })
    void factorial  (String strInput, String expectedResult) throws MyException{
        assertEquals (expectedResult,sut.calculateEngineer(strInput, "!"));
    }

    @ParameterizedTest
    @CsvSource( value =  {
            "3+-2!",
            "-2!",
            " 3.2!",
            "0!"

    })
    void Exception_factorial(String strInput){
        Throwable ex = assertThrows(
                NumberFormatException.class,
                ()->{
                    sut.calculateEngineer(strInput, "!");

                },
                "!!!НЕТУ!!!"
        );

//        assertEquals("неверный формат ввода факториала", ex.getMessage());

    }



}
