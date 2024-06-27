package org.example.face;

import lombok.Builder;

import java.io.Serializable;

@Builder
public class CalculateFaceData implements Serializable {
    int x;
    int y ;
    String  nameKeyPanel;
    Boolean panelLog_isOpen;
    String textLog;
    String textInput;
    String textResult;
}
