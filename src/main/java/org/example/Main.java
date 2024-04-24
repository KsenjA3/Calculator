package org.example;


import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args)  {
        ArrayList <Integer> arr= new ArrayList<>();

        arr.add(0);
        arr.add(1);
        arr.add(-2);
        arr.add(3);
        arr.add(-4);
        arr.add(5);


        for (int i=0; i<arr.size(); i++){
            if (arr.get(i)>0  && (arr.get(i)==1  | arr.get(i)==5))
                System.out.println(arr.get(i));
        }


        arr.remove(1);
        arr.remove(1);
        arr.add(1,99);

        System.out.println(arr);


    }
}