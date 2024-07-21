package com.example;

public class BotaoA implements Command{

    private JogoReceiver jogo;

    public BotaoA(JogoReceiver jogo) {
        this.jogo = jogo;
    }

    @Override
    public void execute() {
        jogo.pressBotaoA();
    }
    
}