package com.example;

public class DirecionalEsquerda implements Command{

    private JogoReceiver jogo;

    public DirecionalEsquerda(JogoReceiver jogo) {
        this.jogo = jogo;
    }

    @Override
    public void execute() {
        jogo.pressDirecionalEsquerda();
    }
    
}