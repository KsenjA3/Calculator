package org.example;


import org.example.face.CalculateFace;

import java.awt.*;

public class Main {
    public static void main(String[] args)  {

        EventQueue.invokeLater(() -> {

            //   new Test ();
            new CalculateFace();


        });
    }
}