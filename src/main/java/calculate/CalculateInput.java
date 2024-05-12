package calculate;

import face.MyException;
import org.apache.commons.lang3.StringUtils;


/*
ORDER COUNT
1 Braces
2 ³√, sin, cos, tg, lg, ln
3 ², ³, !
4 √
5 *,/,^
6 +, -

 */


public class CalculateInput {
    private final CalculateBasic calculateBasic;
    private final CalculateEngineer calculateEngineer;

    public CalculateInput() {
         calculateBasic = new CalculateBasic();
         calculateEngineer= new CalculateEngineer();
    }


    public String calculateInput (String strInput) throws MyException {

        System.out.println("in= "+strInput);

//Delete spaces
        strInput=StringUtils.deleteWhitespace(strInput);
        if (StringUtils.isEmpty(strInput))
            return "";

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


        while (StringUtils.containsAny(strInput,"³√", "cos", "sin", "tg", "ln","lg")){
            if (StringUtils.contains(strInput,"³√")) {
                try {
                    strInput = calculateEngineer.calculateEngineer(strInput, "³√");
                } catch (MyException exc) {
                    System.out.println("³√ catch");
                    throw new MyException("³√ недозволеного большого числа");
                }

            }
            if (StringUtils.contains(strInput,"cos")) {
                try {
                    strInput = calculateEngineer.calculateEngineer(strInput, "cos");
                }
                catch (MyException exc) {
                    System.out.println("cos catch");
                    throw new MyException ("cos не существует");
                }
            }
            if (StringUtils.contains(strInput,"sin")) {
                try {
                    strInput = calculateEngineer.calculateEngineer(strInput, "sin");
                }
                catch (MyException exc) {
                    System.out.println("sin catch");
                    throw new MyException ("sin не существует");
                }
            }
            if (StringUtils.contains(strInput,"tg")) {
                strInput = calculateEngineer.calculateEngineer(strInput, "tg");
            }
            if (StringUtils.contains(strInput,"ln")) {
                strInput = calculateEngineer.calculateEngineer(strInput, "ln");
            }
            if (StringUtils.contains(strInput,"lg")) {
                strInput = calculateEngineer.calculateEngineer(strInput, "lg");
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
//                    System.out.println("factorial catch");
                    throw new MyException ("неверный формат ввода факториала");
                }
            }
        }


       System.out.println("before basic= "+strInput);
        countResult =calculateBasic.calculateBasicInput(strInput);


        countResult=Operations.printStringNumber(countResult);
        return countResult;
    }


}
