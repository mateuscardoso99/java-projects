package com.example;

public class PES2020 implements JogoReceiver{

    @Override
    public void pressBotaoA() {
        System.out.println("chute");
    }

    @Override
    public void pressBotaoB() {
        System.out.println("passe");
    }

    @Override
    public void pressDirecionalPracima() {
        System.out.println("anda para cima");
    }

    @Override
    public void pressDirecionalPrabaixo() {
        System.out.println("anda para baixo");
    }

    @Override
    public void pressDirecionalEsquerda() {
        System.out.println("anda pra esquerda");
    }

    @Override
    public void pressDirecionalDireita() {
        System.out.println("anda pra direita");
    }
    
}
