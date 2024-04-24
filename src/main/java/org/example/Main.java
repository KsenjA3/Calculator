package org.example;


import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args)  {
        String str=" h j   lko ll   ";
        str=StringUtils.deleteWhitespace(str);

        System.out.println("="+str+"=");

    }
}