package org.study;

import java.util.Locale;

public class Check {
    public static void main(String[] args) {
        String strHex="FFFFFFF2";

//        Long intDecimal =Long.parseLong(strHex,16);
        Integer intDec=hexadecimalToDecimal(strHex);

        String strDec=intDec.toString();




        System.out.println(strDec);

    }
    static int hexadecimalToDecimal(String hexVal)
    {
        // Storing the length of the
        int len = hexVal.length();

        // Initializing base value to 1, i.e 16^0
        int base = 1;

        // Initially declaring and initializing
        // decimal value to zero
        int dec_val = 0;

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
        return dec_val;
    }
    String decimal_to_stringBinary(int number){
        String binaryNumber=Integer.toBinaryString(number);
        return binaryNumber;
    }

    int decimal_to_intBinary(int number){
        int binaryNumber = 0;
        int cnt = 0;
        while (number != 0) {
            int rem = number % 2;
            double c = Math.pow(10, cnt);
            binaryNumber += rem * c;
            number /= 2;

            // Count used to store exponent value
            cnt++;
        }

        return binaryNumber;
    }


    int stringBinary_to_decimal(String s)  {
        int ans = 0, i, p = 0;
        int len = s.length();                    // length of String

        for (i = len - 1; i >= 0; i--) {        // Traversing the String
            if (s.charAt(i) == '1') {
                ans += Math.pow(2, p);          // Calculating Decimal Number
            }
            p++;                                // incrementing value of p
        }
        return ans;
    }

    int integerBinary_to_decimal(int num)
    {
        int ans = 0, rem = 0, temp = num;
        int i = 0;
        while (num != 0) {
            rem = num % 10;                     // remainder when num is divided by 10
            num /= 10;                          // quotient
            ans += rem * Math.pow(2, i);        // Calculating decimal number
            i++;
        }
        return ans;
    }



    String decimal_to_stringHex(int num){
        String stringHex= Integer.toString(num, 16).toUpperCase(Locale.ROOT);
        return stringHex;
    }

    Integer stringHex_to_decimal (String stringHex){
        Integer num = Integer.parseInt(stringHex, 16);
        return num;
    }


    String decimal_to_binary(String number){
        String binaryNumber=Integer.toBinaryString(Integer.parseInt(number));
        return binaryNumber;
    }

    String binary_to_decimal(String number)  {
        int ans = 0, i, p = 0;
        int len = number.length();                    // length of String

        for (i = len - 1; i >= 0; i--) {        // Traversing the String
            if (number.charAt(i) == '1') {
                ans += Math.pow(2, p);          // Calculating Decimal Number
            }
            p++;                                // incrementing value of p
        }

        Integer num= ans;
        return num.toString();
    }


    String decimal_to_hex(String number){
        String stringHex= Integer.toString(Integer.parseInt(number), 16).toUpperCase(Locale.ROOT);
        return stringHex;
    }

    String hex_to_decimal (String number){
        Integer num = Integer.parseInt(number, 16);
        return num.toString();
    }




}
