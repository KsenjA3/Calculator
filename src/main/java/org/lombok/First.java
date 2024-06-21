package org.lombok;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class First {
    int number;
    public static void main(String[] args) {
        var ob = new First();
        ob.setNumber(5);
        int i= ob.number;
        int iSet= ob.getNumber();
        System.out.println(i);
        System.out.println(iSet);
    }

}
