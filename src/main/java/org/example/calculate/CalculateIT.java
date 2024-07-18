package org.example.calculate;

import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.apache.commons.lang3.StringUtils;
import org.example.face.MyException;

import java.util.Locale;

@Log4j2
@NoArgsConstructor
public class CalculateIT {


    String decimal_to_binary(String numDecimal){
        String binaryNumber=Integer.toBinaryString(Integer.parseInt(numDecimal));
//        String binaryNumber= Integer.toString(In.parseInt(numDecimal), 2);

        return binaryNumber;
    }

    String binary_to_decimal(String numBinary)  {
        int ans = 0, i, p = 0;
        int len = numBinary.length();                    // length of String

        for (i = len - 1; i >= 0; i--) {        // Traversing the String
            if (numBinary.charAt(i) == '1') {
                ans += Math.pow(2, p);          // Calculating Decimal Number
            }
            p++;                                // incrementing value of p
        }

        Integer num= ans;
        return num.toString();
    }



    String decimal_to_hex(String numDecimal){
        String stringHex= Integer.toString(Integer.parseInt(numDecimal), 16).toUpperCase(Locale.ROOT);
        return stringHex;
    }

    String hex_to_decimal (String numHex){
        Integer num = Integer.parseInt(numHex, 16);
        return num.toString();
    }



    String binary_to_hex(String numBinary)  {
        return decimal_to_hex( binary_to_decimal(numBinary));
    }

    String hex_to_binary (String numHex){

        return decimal_to_binary(hex_to_decimal(numHex));
    }


     String shift_format_number (String oldFormat, String newFormat, String oldNumber){
        String newNumber="";

        if (oldFormat.equals("bin") && newFormat.equals("dec")){
            newNumber=binary_to_decimal(oldNumber);
        }
        if (oldFormat.equals("dec") &&newFormat.equals("bin")){
            newNumber=decimal_to_binary(oldNumber);
        }


        if (oldFormat.equals("hex") &&newFormat.equals("dec")){
            newNumber=hex_to_decimal(oldNumber);
        }
        if (oldFormat.equals("dec") &&newFormat.equals("hex")){
            newNumber=decimal_to_hex(oldNumber);
        }


        if (oldFormat.equals("bin") &&newFormat.equals("hex")){
            newNumber=binary_to_hex(oldNumber);
        }
        if (oldFormat.equals("hex") &&newFormat.equals("bin")){
            newNumber=hex_to_binary(oldNumber);
        }

        return newNumber;
    }



    public String shift_format_input_numbers(String oldFormat, String newFormat, String oldString) throws MyException {
        String newString="";
        String oldNum="", newNum="";
        oldString= StringUtils.deleteWhitespace(oldString);
//        System.out.println("!!!! oldString= "+oldString);

        for (int i=0; i<oldString.length(); i++){
            switch (oldString.charAt(i)){
                case '0','1','2','3','4','5','6','7','8','9',
                     'A','B','C','D','E','F'->{
                    oldNum=oldNum+oldString.charAt(i);
                    if(i==oldString.length()-1){
                        newNum=shift_format_number(oldFormat,newFormat,oldNum);
                        newString=newString+newNum;
                    }
                }
                case '+','*','/','%','√', '(', ')' ->{
                    if (oldNum.isEmpty()){
                            newString = newString +  " " + oldString.charAt(i);
                    }else {
                        newNum = shift_format_number(oldFormat, newFormat, oldNum);
                        newString = newString + newNum + " " + oldString.charAt(i);
                        oldNum = "";
                    }
                }
                case '-' -> {
                    try {
                        newNum = shift_format_number(oldFormat, newFormat, oldNum);
                        newString = newString + newNum + " " + oldString.charAt(i);
                        oldNum = "";
                    } catch (NumberFormatException e) {
                        log.error("Формат чисел не может быть отрицательным:  = {}",oldString);
                        throw new MyException("Работает только с положительными числами.");
                    }
                }
                case '.' -> {
                    log.error("Формат чисел не может быть дробным:  = {}",oldString);
                    throw new MyException("Формат работает только с целыми числами.");
                }
                case '&','^','|','~' ->{
                    throw new MyException("Shift format number is band.");
                }
            }
        }
        return newString;
    }

}
