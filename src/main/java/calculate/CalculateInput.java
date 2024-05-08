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


    public double calculateInput (String strInput) throws MyException {

        System.out.println("in= "+strInput);

//Delete spaces
        strInput=StringUtils.deleteWhitespace(strInput);
        if (StringUtils.isEmpty(strInput))
            return 0.0;

//Braces
        String str;
        double dResult;
        while (StringUtils.contains(strInput,")")){
            int nLast = StringUtils.indexOf(strInput, ")");
            str =strInput.substring(0, nLast);
            int nFirst = StringUtils.lastIndexOf(str, "(");
            str = str.substring(nFirst +1);

            dResult =calculateInput(str);
            str =strInput.substring(nLast +1);
            strInput=strInput.substring(0, nFirst) + Operations.printNumber(dResult)+ str;
        }

        while (StringUtils.contains(strInput,"(")){
            int nBrace = StringUtils.lastIndexOf(strInput, "(");
            if(nBrace ==strInput.length()-1){
                dResult =0.0;
            }else {
                str = strInput.substring(nBrace + 1);
                dResult =calculateInput(str);
            }
            strInput=strInput.substring(0, nBrace) + Operations.printNumber(dResult);
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
        dResult =calculateBasic.calculateBasicInput(strInput);
        return dResult;
    }


}
