package com.example;

/**
 * implementar o padrão command para um controle de videogame que possui os seguintes botões: 
 * A e B, Direcional: pra cima, pra baixo, esquerda e direita
 * os receivers são os diferentes jogos que podem ser utilizados com o videogame e na saída padrão quando apertado cada botão, um resultado diferente será apresentado dependendo do jogo
 * EX: futebol: A -> chute, B -> passe
 * EX2: luta: A -> soco, B -> chute, Esquerda -> defesa
 */
public class Main {
    public static void main(String[] args) {
        JogoReceiver pes2020 = new PES2020();
        Videogame videogame = new Videogame(pes2020);
        videogame.pressBotaoB();
        videogame.pressDirecionalEsquerda();
        videogame.pressBotaoA();
        videogame.executarComandos();
    }
}
