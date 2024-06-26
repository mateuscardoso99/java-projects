package com.example;

public class LuminariaPiso extends Component{
    private final Luz luz;

    public LuminariaPiso(){
        this.luz = new Luz();
    }

    public Luz getLuz() {
        return luz;
    }

    public boolean isLigado(){
        return luz.isLigado();
    }
}
