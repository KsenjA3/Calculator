package calculate;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.math.BigDecimal;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

class CalculateBasicInputTest {
    private static CalculateBasic sut;

    @BeforeAll
     static void setCalculateBasicInput () {
        sut = new CalculateBasic();
    }

    @ParameterizedTest
    @CsvSource ( value =  {
            " 5+14, 19",
            " 3-8,  -5",
            " 9-5, 4",
            " 2*3, 6",
            " 9/3, 3",
    })
    void intNumbersCount_PlusMinusDivideMultiply  (String strInput, double expectedResult) {
        assertEquals (expectedResult,sut.calculateBasicInput(strInput));
    }
    @ParameterizedTest
    @CsvSource ( value =  {
            " 50+2*10*2, 90",
            " 50-2*10*2, 10",
            "2*5*4-10*3*2,-20",
            "5*2-3*3,1",
            "2*5*4-10*2,20",
            "100/10*5-2*25,0"
    })
    void oderCount (String strInput, double expectedResult) {
        assertEquals (expectedResult,sut.calculateBasicInput(strInput));
    }

    @ParameterizedTest
    @CsvSource ( value =  {
            " 5.3+14.5, 19.8",
            " 3.9-8.6,  -4.7",
            " 9.6-5.5, 4.1",
            " 2.2*3, 6.6",
            " 9.9/3.3, 3",
            " 9.9/3, 3.3"
    })
    void doubleNumbersCount_PlusMinusDivideMultiply (String strInput, double expectedResult) {
        assertEquals (expectedResult,sut.calculateBasicInput(strInput));
    }

    //переполнение
    @Test
    void overflow_result() {
        BigDecimal dResult=new BigDecimal("99999999999999999999999");

        BigDecimal dResult1=dResult.add(dResult);
        assertThat(sut.calculateBasicInput("99999999999999999999999+99999999999999999999999"))
                .isEqualTo(dResult1.doubleValue());

        BigDecimal dResult2=dResult.multiply(dResult);
        assertThat(sut.calculateBasicInput("99999999999999999999999*99999999999999999999999"))
                .isEqualTo(dResult2.doubleValue());
    }

    @ParameterizedTest
    @CsvSource ( value =  {
            " √25,   5",
            " 2+√4,  4",
            " 2√9,   6",
            " 2+2√4, 6",

            " √√81,    3",
            " 2√√16,    4",
            " 10-√√16,  8",
            " 3+3√√81, 12",

            " √√√256, 2",
    })
    void sqrt (String strInput, double expectedResult) {
        assertEquals (expectedResult,sut.calculateBasicInput(strInput));
    }

    @ParameterizedTest
    @CsvSource ( value =  {
            " 25-15*2+,   -5",
            " 2*2/,  4",
            " 2*√4√, 4",
            " 2*√4+√, 4"
    })
    void ends_with_sign (String strInput, double expectedResult)
    {
        assertEquals (expectedResult,sut.calculateBasicInput(strInput));
    }

    @ParameterizedTest
    @CsvSource ( value =  {
            " 2 ^ 3 +4,   12",
            " 2*2^2,  16",
            " 2^ 4*√4, 32",
            " 0 ^8, 0"
    })
    void pow (String strInput, double expectedResult)
    {
        assertEquals (expectedResult,sut.calculateBasicInput(strInput));
    }

    @ParameterizedTest
    @CsvSource ( value =  {
            " -25+15,  -10",
            " -25-15,  -40",
            " -2*5,  -10",
            " -20/2,  -10",
    })
    void begin_with_negativNumber (String strInput, double expectedResult) {
        assertEquals (expectedResult,sut.calculateBasicInput(strInput));
    }

    private static Stream<Arguments> dataProvider() {
        calculate plus = Operations::plus;
        calculate minus = Operations::minus;
        calculate multiply = Operations::multiply;
        calculate divide = Operations::divide;

        return Stream.of(
                Arguments.of( "+", 200, 5, 210),
                Arguments.of( "-", 200, 5, 190),
                Arguments.of( "*", 200, 5, 10),
                Arguments.of( "/", 200, 5, 4000),

                Arguments.of( "/", 200, 100, 200),
                Arguments.of( "+", 200, 20, 240),
                Arguments.of( "-", 200, 200, -200),
                Arguments.of( "*", 200, 80, 160)
        );

    }
    //In the test package
    @ParameterizedTest
    @MethodSource("dataProvider")
    void calculatePersent(String nameSign, double dResultPercentIn, double dNumberIn, double expectedResult)
    {
        assertEquals(expectedResult, sut.calculatePersent(nameSign, dResultPercentIn, dNumberIn));
    }



}