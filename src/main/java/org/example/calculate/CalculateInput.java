package org.example.calculate;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;
import org.apache.logging.log4j.Level;
import org.example.face.MyException;
import org.apache.commons.lang3.StringUtils;
import org.example.fitting.MyFormatNumbers;


/*
ORDER COUNT
1 Braces
2 ³√, sin, cos, tg, lg, ln
3 ², ³, !
4 √
5 *,/,^
6 +, -
 */

@Log4j2
public class CalculateInput {

    private final CalculateBasic calculateBasic;
    private final CalculateEngineer calculateEngineer;
    private final CalculateIT calculateIT;

    @Getter
    @Setter
    private String format;

    public CalculateInput() {
         calculateBasic = new CalculateBasic();
         calculateEngineer= new CalculateEngineer();
         calculateIT= new CalculateIT();
    }


    public String calculateInput (String strInput) throws MyException {

//Delete spaces
        strInput=StringUtils.deleteWhitespace(strInput);
        if (StringUtils.isEmpty(strInput))
            return "";

        switch (format)  {
            case "hex"-> {
                log.info("hex");
            }
            case "dec", "dec_int"->{
                log.info("dec or int");
            }
            case "bin"->{
                log.info("bin");
            }
        }




//Braces
        String str;
        String countResult;
        while (StringUtils.contains(strInput,")")){
            int nLast = StringUtils.indexOf(strInput, ")");
            str =strInput.substring(0, nLast);
            int nFirst = StringUtils.lastIndexOf(str, "(");
            str = str.substring(nFirst +1);

            countResult =calculateInput(str);
            str =strInput.substring(nLast +1);
            strInput=strInput.substring(0, nFirst) + countResult+ str;
        }
        while (StringUtils.contains(strInput,"(")){
            int nBrace = StringUtils.lastIndexOf(strInput, "(");
            if(nBrace ==strInput.length()-1){
                countResult ="";
            }else {
                str = strInput.substring(nBrace + 1);
                countResult =calculateInput(str);
            }
            strInput=strInput.substring(0, nBrace) + countResult;
        }

        log.debug("logger.debug: после расчетов скобок calculateInput: {} ",strInput);

        while (StringUtils.containsAny(strInput,"³√", "cos", "sin", "tg", "ln","lg")){
            if (StringUtils.contains(strInput,"³√")) {
                try {
                    strInput = calculateEngineer.calculateEngineer(strInput, "³√");
                } catch (MyException exc) {
                    log.error("logger.error ³√ недозволеного большого числа: {}",strInput);
                    throw new MyException("³√ недозволеного большого числа");
                }

            }
            if (StringUtils.contains(strInput,"cos")) {
                try {
                    strInput = calculateEngineer.calculateEngineer(strInput, "cos");
                }
                catch (MyException exc) {
                    log.error("logger.error сos недозволеного большого числа: {}",strInput);
                    throw new MyException ("cos недозволеного большого числа");
                }
            }
            if (StringUtils.contains(strInput,"sin")) {
                try {
                    strInput = calculateEngineer.calculateEngineer(strInput, "sin");
                }
                catch (MyException exc) {
                    log.error("logger.error sin недозволеного большого числа: {}",strInput);
                    throw new MyException ("sin недозволеного большого числа");
                }
            }
            if (StringUtils.contains(strInput,"tg")) {
                try {
                    strInput = calculateEngineer.calculateEngineer(strInput, "tg");
                }
                catch (MyException exc) {
                    System.out.println("tg catch");
                    if (exc.getMessage().equals("tg INFINITY")) {
                        log.error("logger.error tg недозволеного большого числа: {}", strInput);
                        throw new MyException("tg недозволеного большого числа");
                    }
                    if (exc.getMessage().equals("tg не определен")) {
                        log.error("logger.error tg не определен: {}", strInput);
                        throw new MyException("tg не определен");
                    }
                }
            }

            if (StringUtils.contains(strInput,"lg")) {
                try {
                    strInput = calculateEngineer.calculateEngineer(strInput, "lg");
                }
                catch (MyException exc) {
                    if (exc.getMessage().equals("lg INFINITY")){
                        log.error("logger.error lg недозволеного большого числа: {}", strInput);
                        throw new MyException ("lg недозволеного большого числа");
                    }

                    if (exc.getMessage().equals("lg NAN") | exc.getMessage().equals("lg 0")){
                        log.error("logger.error lg не определен: {}", strInput);
                        throw new MyException ("lg не определен");
                    }
                }
            }

            if (StringUtils.contains(strInput,"ln")) {
                try {
                    strInput = calculateEngineer.calculateEngineer(strInput, "ln");
                }
                catch (MyException exc) {
                    if (exc.getMessage().equals("ln INFINITY")){
                        log.error("logger.error ln недозволеного большого числа: {}", strInput);
                        throw new MyException ("ln недозволеного большого числа");
                    }

                    if (exc.getMessage().equals("ln NAN") | exc.getMessage().equals("ln 0")){
                        log.error("logger.error ln не определен: {}", strInput);
                        throw new MyException ("ln не определен");
                    }

                }
            }

        }

        while (StringUtils.containsAny(strInput,"²","³", "!")){
            if (StringUtils.contains(strInput,"²")) {
                strInput = calculateEngineer.calculateEngineer(strInput, "²");
            }

            if (StringUtils.contains(strInput,"³")){
                strInput=calculateEngineer.calculateEngineer(strInput,"³");
            }

            if(StringUtils.contains(strInput,"!")){
                try {
                    strInput=calculateEngineer.calculateEngineer(strInput,"!");
                }
                catch (NumberFormatException exc) {
                    log.error("logger.error неверный формат ввода факториала: {}", strInput);
                    throw new MyException ("неверный формат ввода факториала");
                }
            }
        }





        log.log(Level.INFO,"Level.INFO: before basic расчеов calculateInput = {}",strInput);
        countResult =calculateBasic.calculateBasicInput(strInput);
        countResult=Operations.printNumber(countResult);
        log.log(Level.INFO,"Level.INFO: after basic расчеов calculateInput = {}",strInput);
        return countResult;
    }


}
