package com.example;

public class BotaoB implements Command{

    private JogoReceiver jogo;

    public BotaoB(JogoReceiver jogo) {
        this.jogo = jogo;
    }

    @Override
    public void execute() {
        jogo.pressBotaoB();
    }
    
}