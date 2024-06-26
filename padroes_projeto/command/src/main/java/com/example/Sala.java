package com.example;

public class Sala extends Component{
    private Cortina cortina;

    public Sala(){
        this.cortina = new Cortina();
    }

    public Cortina getCortina() {
        return cortina;
    }
}
