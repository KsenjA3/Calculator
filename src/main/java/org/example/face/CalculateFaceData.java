package org.example.face;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CalculateFaceData implements Serializable {
    int x;
    int y ;
    String  nameKeyPanel;
    Boolean panelLog_isOpen;
    String textLog;
    String textInput;
    String textResult;
    String formatNumber;
}
