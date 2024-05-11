package calculate;

import face.MyException;
import org.apache.commons.lang3.StringUtils;


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



        while (StringUtils.contains(strInput,"²")){
            strInput = calculateEngineer.calculateEngineer(strInput,"²");
        }

        while (StringUtils.contains(strInput,"³")){
            strInput=calculateEngineer.calculateEngineer(strInput,"³");
        }

        while (StringUtils.contains(strInput,"!")){
            try {
            strInput=calculateEngineer.calculateEngineer(strInput,"!");
            }
            catch (NumberFormatException exc) {
                    System.out.println("factorial catch");
                throw new MyException ("неверный формат ввода факториала");
            }
        }


       System.out.println("before basic= "+strInput);
        countResult =calculateBasic.calculateBasicInput(strInput);


        countResult=Operations.printStringNumber(countResult);
        return countResult;
    }


}
