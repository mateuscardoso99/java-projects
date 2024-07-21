package com.example;

public class DirecionalPracima implements Command{

    private JogoReceiver jogo;

    public DirecionalPracima(JogoReceiver jogo) {
        this.jogo = jogo;
    }

    @Override
    public void execute() {
        jogo.pressDirecionalPracima();
    }
    
}