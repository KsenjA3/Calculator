package org.example;


import calculate.Operations;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args)  {
        String str="qwe+568-uyt5";

        System.out.println(str);
        if (str.trim()!="" &&
                StringUtils.endsWithAny(str,"0","1","2","3","4","5","6","7","8","9",".")) {

            System.out.println("+");
        }

    }
}