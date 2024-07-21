package com.example;

public class DirecionalPrabaixo implements Command{

    private JogoReceiver jogo;

    public DirecionalPrabaixo(JogoReceiver jogo) {
        this.jogo = jogo;
    }

    @Override
    public void execute() {
        jogo.pressDirecionalPrabaixo();
    }
    
}