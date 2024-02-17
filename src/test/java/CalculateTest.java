import calculate.CalculateBasicInput;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

public class CalculateTest {
    @Test
    void evaluatesExpression1 () {
        CalculateBasicInput calculator = new CalculateBasicInput();
        assertThat(calculator.calculateInput("  24.7 +    25.3  ")).isEqualTo(50.0);
    }

    //большие числа
    @Test
    void evaluatesExpression2 () {
        CalculateBasicInput calculator = new CalculateBasicInput();
        BigDecimal dResult=new BigDecimal("99999999999999999999999");
        dResult=dResult.add(dResult);
        assertThat(calculator.calculateInput("  99999999999999999999999 +    99999999999999999999999  "))
                .isEqualTo(dResult.doubleValue());
    }

    //переполнение
    @Test
    void substractionExpression1 () {
        CalculateBasicInput calculator = new CalculateBasicInput();
        assertThat(calculator.calculateInput("  25.7 -    25.3  ")).isEqualTo(0.4);
    }


    @Test
    void substractionExpression2 () {
        CalculateBasicInput calculator = new CalculateBasicInput();
        assertThat(calculator.calculateInput("  25.2 -    25.8  ")).isEqualTo(-0.6);
    }

    //первое число отрицательное
    @Test
    void substractionExpression3 () {
        CalculateBasicInput calculator = new CalculateBasicInput();
        assertThat(calculator.calculateInput("  -24.2 -    25.8  ")).isEqualTo(-50.0);
    }
}
