package org.example.fitting;

public enum MyFormatNumbers {
    FORMAT_DEC ("dec"),
    FORMAT_DEC_INT ("dec_int"),
    FORMAT_HEX ("hex"),
    FORMAT_BIN ("bin");

    private String formatNumbers;

    private  MyFormatNumbers (String formatNumbers){
        this.formatNumbers= formatNumbers;
    }

    public String get (){
        return formatNumbers;
    }
}
