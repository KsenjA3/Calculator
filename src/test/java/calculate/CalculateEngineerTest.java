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



    @ParameterizedTest
    @CsvSource( value =  {
            " ³√27, 3",
            " ³√27+5, 3+5",
            " 55+³√27, 55+3",
            " 23-³√27*66, 23-3*66",
    })
    void sqrt3  (String strInput, String expectedResult) throws MyException {
        assertEquals (expectedResult,sut.calculateEngineer(strInput, "³√"));
    }


    @ParameterizedTest
    @CsvSource( value =  {
            " cos30,    0.866025403784439",
            " cos90,   0",
            " cos0,   1",
            " cos45,   0.707106781186548",
            " cos60,   0.5",
            " cos120,   -0.5",
            " cos135,   -0.707106781186547",
            " cos270,   0",
            " cos180,   -1",
            " cos150,   -0.866025403784439",
    })
    void cos  (String strInput, String expectedResult) throws MyException {
        assertEquals (expectedResult,sut.calculateEngineer(strInput, "cos"));
    }
    @ParameterizedTest
    @CsvSource( value =  {
            " sin30,   0.5",
            " sin90,   1",
            " sin0,   0",
            " sin45,   0.707106781186548",
            " sin60,   0.866025403784439",
            " sin120,   0.866025403784439",
            " sin135,   0.707106781186548",
            " sin270,   -1",
            " sin180,   0",
    })
    void sin  (String strInput, String expectedResult) throws MyException {
        assertEquals (expectedResult,sut.calculateEngineer(strInput, "sin"));
    }
    @ParameterizedTest
    @CsvSource( value =  {
            " tg0,    0",
            " tg30,   0.57735026918963",
            " tg45,   1",
            " tg60,   1.73205080756888",
            " tg120,  -1.73205080756888",
            " tg135,  -1",
            " tg150,  -0.57735026918963",
            " tg180,  0",
    })
    void tg  (String strInput, String expectedResult) throws MyException {
        assertEquals (expectedResult,sut.calculateEngineer(strInput, "tg"));
    }
    @ParameterizedTest
    @CsvSource( value =  {
            " tg90",
            " tg-90",
            " tg270",
            " tg-270",
    })
    void tg_exception  (String strInput){
        Throwable ex = assertThrows(
                MyException.class,
                ()->{
                    sut.calculateEngineer(strInput, "tg");
                },
                "!!!НЕТУ!!!"
        );
        assertEquals("tg не определен", ex.getMessage());
    }




    @ParameterizedTest
    @CsvSource( value =  {
            " lg100,   2",
            " lg20,   1.3010299956639813",
            " lg10000,   4",
            " lg25,   1.3979400086720377",
            " lg0.25,   -0.6020599913279624",
    })
    void lg  (String strInput, String expectedResult) throws MyException {
        assertEquals (expectedResult,sut.calculateEngineer(strInput, "lg"));
    }
    @ParameterizedTest
    @CsvSource( value =  {
            " ln1,   0",
            " ln2.718281828459045235360287471352,   1",
            " ln25,   3.2188758248682006",
            " ln0.25,   -1.3862943611198906",
    })
    void ln  (String strInput, String expectedResult) throws MyException {
        assertEquals (expectedResult,sut.calculateEngineer(strInput, "ln"));
    }
    @ParameterizedTest
    @CsvSource( value =  {
            " ln-90, ln",
            " ln-2000, ln",
            " lg-90, lg",
            " lg-2000, lg",
    })
    void log_exception_NAN  (String strInput, String name){
        Throwable ex = assertThrows(
                MyException.class,
                ()->{
                    sut.calculateEngineer(strInput, name);
                },
                "!!!НЕТУ!!!"
        );
        assertEquals(name+" NAN", ex.getMessage());
    }
    @ParameterizedTest
    @CsvSource( value =  {
            " ln0, ln",
            " lg0, lg",
    })
    void log_exception_INFINITY  (String strInput, String name){
        Throwable ex = assertThrows(
                MyException.class,
                ()->{
                    sut.calculateEngineer(strInput, name);
                },
                "!!!НЕТУ!!!"
        );
        assertEquals(name+" 0", ex.getMessage());
    }

}
