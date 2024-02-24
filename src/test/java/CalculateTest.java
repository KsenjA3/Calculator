import calculate.CalculateBasicInput;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

public class CalculateTest {
    private CalculateBasicInput sut;

    @BeforeEach
    void setCalculateBasicInput () {
         sut = new CalculateBasicInput();
    }
    @Test
    void sum_Sequence_DoubleNumbers_withSpaces () {

        assertThat(sut.calculateInput("  24.7 +    25.3  ")).isEqualTo(50.0);
    }

    //большие числа
    @Test
    void sum_with_Overflow () {
        BigDecimal dResult=new BigDecimal("99999999999999999999999");
        dResult=dResult.add(dResult);
        assertThat(sut.calculateInput("  99999999999999999999999 +    99999999999999999999999  "))
                .isEqualTo(dResult.doubleValue());
    }

    //переполнение
    @Test
    void minus_Sequence_DoubleNumbers_withSpaces () {
        assertThat(sut.calculateInput("  25.7 -    25.3  ")).isEqualTo(0.4);
    }


    @Test
    void minus_Sequence_NegativeResult () {
        assertThat(sut.calculateInput("25.2-25.8")).isEqualTo(-0.6);
    }

    //первое число отрицательное
    @Test
    void minus_Sequence_NegativeFirstNumber () {
        assertThat(sut.calculateInput("  -24.2 -    25.8  ")).isEqualTo(-50.0);
    }
}
