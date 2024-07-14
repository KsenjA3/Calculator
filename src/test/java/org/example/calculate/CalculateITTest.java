package org.example.calculate;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class CalculateITTest {
    private static CalculateIT sut;

    @BeforeAll
    static void setCalculateBasicInput () {
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
        assertEquals(binary.replaceAll(" ",""), CalculateIT.decimal_to_binary(decimal));
    }

    @ParameterizedTest
    @CsvSource( value =  {
            "1110 1001 0110 0101 1110, 955998",
            "1100 1000,200",
            "11 0111,55",
            "11 1011 1011, 955"
    })
    void binary_to_decimal(String binary, String decimal) {
        assertEquals(decimal, CalculateIT.binary_to_decimal(binary.replaceAll(" ","")));
    }

   @ParameterizedTest
   @CsvSource(value = {
           "955998, E965E ",
           "200, C8",
           "55, 37",
           "955, 3BB"
   })
    void decimal_to_hex(String decimal, String hex) {
       assertEquals(hex, CalculateIT.decimal_to_hex(decimal));
    }

    @ParameterizedTest
    @CsvSource(value = {
            "E965E,955998 ",
            "C8,200",
            "37,55",
            "3BB,955"
    })
    void hex_to_decimal( String hex, String decimal) {
        assertEquals(decimal, CalculateIT.hex_to_decimal(hex));
    }

    @ParameterizedTest
    @CsvSource( value =  {
            "1110 1001 0110 0101 1110, E965E",
            "1100 1000,C8",
            "11 0111,37",
            "11 1011 1011, 3BB"
    })
    void binary_to_hex( String binary, String hex) {
        assertEquals(hex,CalculateIT.binary_to_hex(binary.replaceAll(" ","")));
    }

    @ParameterizedTest
    @CsvSource( value =  {
            "E965E,1110 1001 0110 0101 1110 ",
            "C8,1100 1000",
            "37,11 0111",
            "3BB,11 1011 1011"
    })
    void hex_to_binary(String hex, String binary) {
        assertEquals(binary.replaceAll(" ",""), CalculateIT.hex_to_binary(hex));
    }
}