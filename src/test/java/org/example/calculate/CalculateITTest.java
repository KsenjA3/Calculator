package org.example.calculate;

import org.example.face.MyException;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class CalculateITTest {
    private  CalculateIT sut;

    @BeforeAll
     void setCalculateBasicInput () {
        sut = new CalculateIT();
    }

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }



    @ParameterizedTest
    @CsvSource( value =  {
            "955998, 1110 1001 0110 0101 1110 ",
            "200, 1100 1000",
            "55, 11 0111",
            "955, 11 1011 1011"
    })
    void decimal_to_binary(String decimal, String binary) {
        assertEquals(binary.replaceAll(" ",""), sut.decimal_to_binary(decimal));
    }

    @ParameterizedTest
    @CsvSource( value =  {
            "1110 1001 0110 0101 1110, 955998",
            "1100 1000,200",
            "11 0111,55",
            "11 1011 1011, 955"
    })
    void binary_to_decimal(String binary, String decimal) {
        assertEquals(decimal, sut.binary_to_decimal(binary.replaceAll(" ","")));
    }

   @ParameterizedTest
   @CsvSource(value = {
           "955998, E965E ",
           "200, C8",
           "55, 37",
           "955, 3BB"
   })
    void decimal_to_hex(String decimal, String hex) {
       assertEquals(hex, sut.decimal_to_hex(decimal));
    }

    @ParameterizedTest
    @CsvSource(value = {
            "E965E,955998 ",
            "C8,200",
            "37,55",
            "3BB,955"
    })
    void hex_to_decimal( String hex, String decimal) {
        assertEquals(decimal, sut.hex_to_decimal(hex));
    }

    @ParameterizedTest
    @CsvSource( value =  {
            "1110 1001 0110 0101 1110, E965E",
            "1100 1000,C8",
            "11 0111,37",
            "11 1011 1011, 3BB"
    })
    void binary_to_hex( String binary, String hex) {
        assertEquals(hex,sut.binary_to_hex(binary.replaceAll(" ","")));
    }

    @ParameterizedTest
    @CsvSource( value =  {
            "E965E,1110 1001 0110 0101 1110 ",
            "C8,1100 1000",
            "37,11 0111",
            "3BB,11 1011 1011"
    })
    void hex_to_binary(String hex, String binary) {
        assertEquals(binary.replaceAll(" ",""), sut.hex_to_binary(hex));
    }


    @ParameterizedTest
    @CsvSource( value = {
            "dec, bin, 955998, 1110 1001 0110 0101 1110 ",
            "dec, bin,200, 1100 1000",
            "dec, bin,55, 11 0111",
            "dec, bin,955, 11 1011 1011",

            " bin, dec,1110 1001 0110 0101 1110, 955998",
            "bin, dec,1100 1000,200",
            "bin, dec,11 0111,55",
            "bin, dec,11 1011 1011, 955",

            "dec, hex, 955998, E965E ",
            "dec, hex,200, C8",
            "dec, hex,55, 37",
            "dec, hex, 955, 3BB",

            " hex, dec, E965E,955998 ",
            "hex, dec, C8,200",
            "hex, dec, 37,55",
            "hex, dec, 3BB,955",

            "hex, bin, E965E,1110 1001 0110 0101 1110 ",
            "hex, bin,C8,1100 1000",
            "hex, bin,37,11 0111",
            "hex, bin,3BB,11 1011 1011",

            "bin,hex, 1110 1001 0110 0101 1110, E965E",
            "bin,hex,1100 1000,C8",
            "bin,hex,11 0111,37",
            "bin,hex,11 1011 1011, 3BB"

    })
    void shift_format_number( String oldFormat, String newFormat, String oldNumber, String newNumber) {
        assertEquals(newNumber.replaceAll(" ",""),sut.shift_format_number ( oldFormat,  newFormat,  oldNumber.replaceAll(" ","")));
    }

    @ParameterizedTest
    @CsvSource( value = {
            "dec, bin, 955998 + 200, 1110 1001 0110 0101 1110 + 1100 1000 ",
            "dec, bin,55/(955, 11 0111 / (11 1011 1011",

            " bin, dec,1110 1001 0110 0101 1110-1100 1000, 955998-200",
            "bin, dec,(11 0111/11 1011 1011),(55/ 955)",

            "dec, hex, 955998-√200, E965E -√C8",
            "dec, hex, 955+(55-√200, 3BB+(37-√C8",

            "hex, bin, E965E*C8,1110 1001 0110 0101 1110* 1100 1000 ",
            "hex, bin,3BB+(37- C8)+  E965E ,11 1011 1011+(11 0111-1100 1000)+1110 1001 0110 0101 1110",

            "bin,hex, 1110 1001 0110 0101 1110+1100 1000, E965E+C8",
            "bin,hex,11 0111-11 1011 1011%,37- 3BB%",

            " hex, dec, E965E* C8,955998 *200",
            "hex, dec, 3BB/(37+E965E),955/(55+955998)",
    })

    void shift_format_input_numbers_positive( String oldFormat, String newFormat, String oldStr, String newStr) throws MyException {
        assertEquals(newStr.replaceAll(" ",""),sut.shift_format_input_numbers ( oldFormat,  newFormat,  oldStr.replaceAll(" ","")).replaceAll(" ",""));
    }


    @ParameterizedTest
    @CsvSource( value = {
            "dec, bin, -14, 1111 1111 1111 1111 1111 1111 1111 0010",
            "bin, dec,      1111 1111 1111 1111 1111 1111 1111 0010,-14",
            "hex, bin, FFFF FFF2,11111111111111111111111111110010  ",
            "bin, hex,      1111 1111 1111 1111 1111 1111 1111 0010, FFFF FFF2  ",
            "dec,hex ,-14, FFFF FFF2  ",
            "hex, dec,  FFFF FFF2,-14 ",

            "dec, bin, -258699, 1111 1111 1111 1100 0000 1101 0111 0101",
            "bin, dec,          1111 1111 1111 1100 0000 1101 0111 0101,-258699",
            "hex, bin, FFFC 0D75, 1111 1111 1111 1100 0000 1101 0111 0101 ",
            "bin, hex,          1111 1111 1111 1100 0000 1101 0111 0101, FFFC 0D75  ",
            "dec,hex ,-258699, FFFC 0D75  ",
            "hex, dec,  FFFC 0D75,-258699 ",
    })

    void shift_format_input_numbers_negative( String oldFormat, String newFormat, String oldStr, String newStr) throws MyException {
        assertEquals(newStr.replaceAll(" ",""),sut.shift_format_input_numbers ( oldFormat,  newFormat,  oldStr.replaceAll(" ","")).replaceAll(" ",""));
    }
    @ParameterizedTest
    @CsvSource( value =  {
//            "dec, hex, -8, Работает только с положительными числами.",
            "dec, hex, 5.4, Формат работает только с целыми числами.",
//            "dec, bin, -8, Работает только с положительными числами.",
            "dec, bin, 5.4, Формат работает только с целыми числами.",
    })
    void exceptions(String oldFormat, String newFormat, String oldString, String expected){
        Throwable ex = assertThrows(
                MyException.class,
                ()->{
                    sut.shift_format_input_numbers( oldFormat,  newFormat,  oldString);

                },
                "!!!НЕТУ!!!"
        );

        assertEquals(expected, ex.getMessage());

    }


}