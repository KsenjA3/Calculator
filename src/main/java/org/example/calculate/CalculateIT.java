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
        Integer num=Integer.parseUnsignedInt(numBinary,2);
        return  num.toString();
    }



    String decimal_to_hex(String numDecimal){
        Integer intDecimal =Integer.parseInt(numDecimal);
        String stringHex=Integer.toHexString(intDecimal).toUpperCase(Locale.ROOT);

//        String stringHex= Integer.toString(Integer.parseInt(numDecimal), 16).toUpperCase(Locale.ROOT);

        return stringHex;
    }

    String hex_to_decimal (String hexVal){
        // Storing the length of the
        int len = hexVal.length();

        // Initializing base value to 1, i.e 16^0
        int base = 1;

        // Initially declaring and initializing
        // decimal value to zero
        Integer dec_val = 0;

        // Extracting characters as
        // digits from last character

        for (int i = len - 1; i >= 0; i--) {

            // Condition check
            // Case 1
            // If character lies in '0'-'9', converting
            // it to integral 0-9 by subtracting 48 from
            // ASCII value
            if (hexVal.charAt(i) >= '0'
                    && hexVal.charAt(i) <= '9') {
                dec_val += (hexVal.charAt(i) - 48) * base;

                // Incrementing base by power
                base = base * 16;
            }

            // Case 2
            // if case 1 is bypassed

            // Now, if character lies in 'A'-'F' ,
            // converting it to integral 10 - 15 by
            // subtracting 55 from ASCII value
            else if (hexVal.charAt(i) >= 'A'
                    && hexVal.charAt(i) <= 'F') {
                dec_val += (hexVal.charAt(i) - 55) * base;

                // Incrementing base by power
                base = base * 16;
            }
        }

        // Returning the decimal value
        return dec_val.toString();

//        Integer intDec = Integer.parseInt(numHex, 16);
//        return intDec.toString();
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
                    if (oldNum.isEmpty()){
                        oldNum=oldNum+oldString.charAt(i);
                    }else {
                        newNum = shift_format_number(oldFormat, newFormat, oldNum);
                        newString = newString + newNum + " " + oldString.charAt(i);
                        oldNum = "";
                    }
//                    try {
//                        newNum = shift_format_number(oldFormat, newFormat, oldNum);
//                        newString = newString + newNum + " " + oldString.charAt(i);
//                        oldNum = "";
//                    } catch (NumberFormatException e) {
//                        log.error("Формат чисел не может быть отрицательным:  = {}",oldString);
//                        throw new MyException("Работает только с положительными числами.");
//                    }
                }
                case '.' -> {
                    log.error("Формат чисел не может быть дробным:  = {}",oldString);
                    throw new MyException("Формат работает только с целыми числами.");
                }
                case '&','^','|','~' ->{
                    if (oldNum.isEmpty()){
                        newString = newString +  " " + oldString.charAt(i);
                    }else {
                        newNum = shift_format_number(oldFormat, newFormat, oldNum);
                        newString = newString + newNum + " " + oldString.charAt(i);
                        oldNum = "";
                    }
//                    throw new MyException("Shift format number is band.");
                }
            }
        }
        return newString;
    }

    String count_or_xor_and(String str, String format) {
        String strRes="";
        String strNum="";
        int num1=0, num2=0, numRes=0;

        str= StringUtils.deleteWhitespace(str);
        for (int i=0; i<str.length(); i++){
            switch (str.charAt(i)){
                case '0','1','2','3','4','5','6','7','8','9',
                     'A','B','C','D','E','F'->{
                    strNum=strNum+str.charAt(i);
                    if(i==str.length()-1){

                       num2= number_from_string_according_to_format(strNum,format);

                    }
                }
                case '&','|'->{
                    num1=number_from_string_according_to_format(strNum,format);
                    strNum="";
                }
                case 'X'->{
                    num1=number_from_string_according_to_format(strNum,format);
                    strNum="";
                    i=i+2;
                }
            }
        }

        if (StringUtils.contains(str,"&")) {
            numRes = num1 & num2;
        }
        if (StringUtils.contains(str,"|")) {
            numRes = num1 | num2;
        }
        if (StringUtils.contains(str,"Xor")) {
            numRes = num1 ^ num2;
        }

        strRes=strNumber_from_Integer_according_to_format( numRes,  format);
        return strRes;
    }

    public String count_not(String strNum, String format) {
        String strRes="";

        int numRes=number_from_string_according_to_format(strNum,format);
        numRes=~numRes;
        strRes=strNumber_from_Integer_according_to_format( numRes,  format);
        return strRes;
    }

    int number_from_string_according_to_format(String strNum, String format){
        int num=0;
        switch (format){
            case"dec"->{
                num=Integer.parseInt(strNum);
            }
            case"hex"->{
                num= Integer.parseInt(hex_to_decimal(strNum));
            }
            case"bin"->{
                num= Integer.parseInt(binary_to_decimal(strNum));
            }
        }
        return num;
    }

    String strNumber_from_Integer_according_to_format(Integer number, String format){
        String strNumber="";
        switch (format){
            case"dec"->{
                strNumber=Integer.toString(number);
            }
            case"hex"->{
                strNumber=Integer.toString(number,16).toUpperCase();
            }
            case"bin"->{
                strNumber=Integer.toString(number,2);
            }
        }

        return strNumber;
    }
}
