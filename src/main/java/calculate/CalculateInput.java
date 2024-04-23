package calculate;

import org.apache.commons.lang3.StringUtils;

import java.math.BigDecimal;

public class CalculateInput {
    private double dResult;         //for calculation




    public double calculateInput (String strInput) {
        StringUtils.deleteWhitespace(strInput);

        if (StringUtils.isEmpty(strInput))
            return 0.0;





        for (int i=0; i<strInput.length(); i++) {

        }

        return dResult;
    }
}
