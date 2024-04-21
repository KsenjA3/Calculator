package org.example;


public class Main {
    public static void main(String[] args)  {
        long iRez;
        double dResult = 450.0;


        iRez=Math.round(dResult);
        if(iRez>180)
            iRez=iRez%180;

        if (iRez==90){
            System.out.println(" print");
        }
    }
}