package br.uff.qet.cardgame;

public enum Level {
    G("G"),
    F("F"),
    E("E"),
    D("D"),
    C("C"),
    B("B"),
    A("A");

    private final String value;

    Level(String value){
        this.value = value;
    }

    public String getValue(){
        return value;
    }
    
    
}
