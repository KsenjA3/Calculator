package calculate;

import org.apache.commons.lang3.StringUtils;

public class CalculateInput {
    String str, nameSign;
    double dResult, dNumber;
    int n, nLast, nFirst;
    CalculateBasic calculateBasic;
    CalculateEngineer calculateEngineer;

    public CalculateInput() {
         calculateBasic = new CalculateBasic();
         calculateEngineer= new CalculateEngineer();
    }


    public double calculateInput (String strInput) {

//Delete spaces
        StringUtils.deleteWhitespace(strInput);
        if (StringUtils.isEmpty(strInput))
            return 0.0;

//Braces
        while (StringUtils.contains(strInput,")")){
            nLast = StringUtils.indexOf(strInput, ")");
            str=strInput.substring(0,nLast);
            nFirst=StringUtils.lastIndexOf(str, "(");
            str=str.substring(nFirst+1);

            dResult=calculateBasic.calculateBasicInput(str);

            str=strInput.substring(nLast+1);
            strInput=strInput.substring(0,nFirst) + Operations.printNumber(dResult)+str;
        }

        while (StringUtils.contains(strInput,"(")){
            n=StringUtils.lastIndexOf(strInput, "(");
            str=strInput.substring(n+1);

            System.out.println(str);

            dResult=calculateBasic.calculateBasicInput(str);
            strInput=strInput.substring(0,n) + Operations.printNumber(dResult);
        }






        if (StringUtils.contains(strInput,"%")){
            n = StringUtils.indexOf(strInput, "%");

            str=strInput.substring(0,n);


//                n= str.lastIndexOf('(');
//                str=str.substring(n+1);

            if (str.contains("+")   |   str.contains("-")  |
                str.contains("*")   |   str.contains("/") ){

            }else {
                nameSign="no";
                dNumber=Double.parseDouble(str);
            }







        }



        dResult=calculateBasic.calculateBasicInput(strInput);


//        for (int i=0; i<strInput.length(); i++) {
//
//        }

        return dResult;
    }
}