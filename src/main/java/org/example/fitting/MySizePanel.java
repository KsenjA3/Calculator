package org.example.fitting;

public enum MySizePanel {
    HIEGHT_SIZE_TEXT_RESULT (28),
    HIEGHT_SIZE_TEXT_INPUT (101),
    HIEGHT_SIZE_TEXT_LOG (198),

    HIEGHT_SIZE_KEY (260),

    WIDTH_SIZE_BASIC (260 + 20),
    WIDTH_SIZE_ENGINEER (150),
    WIDTH_SIZE_IT (180);


    private int size;

    private  MySizePanel (int size){
        this.size= size;
    }

    public int get (){
        return size;
    }
}
