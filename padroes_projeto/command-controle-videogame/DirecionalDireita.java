package com.example;

public class DirecionalDireita implements Command{

    private JogoReceiver jogo;

    public DirecionalDireita(JogoReceiver jogo) {
        this.jogo = jogo;
    }

    @Override
    public void execute() {
        jogo.pressDirecionalDireita();
    }
    
}