package com.example;

//cliente
public class Videogame {
    private JogoReceiver jogo;
    private Invoker invoker = new Invoker();

    public Videogame(JogoReceiver jogo) {
        this.jogo = jogo;
    }

    public void pressBotaoA() {
        invoker.adicionaCommand(new BotaoA(jogo));
    }

    public void pressBotaoB() {
        invoker.adicionaCommand(new BotaoB(jogo));
    }

    public void pressDirecionalPracima() {
        invoker.adicionaCommand(new DirecionalPracima(jogo));
    }

    public void pressDirecionalPrabaixo() {
        invoker.adicionaCommand(new DirecionalPrabaixo(jogo));
    }

    public void pressDirecionalEsquerda() {
        invoker.adicionaCommand(new DirecionalEsquerda(jogo));
    }

    public void pressDirecionalDireita() {
        invoker.adicionaCommand(new DirecionalDireita(jogo));
    }

    public void executarComandos(){
        invoker.execute();
    }
}
