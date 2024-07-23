package com.example;

public class Main {
    public static void main(String[] args) {
        Routine rotina = new Routine();
        rotina.adicionaCommand(new AbrirPortaCommand(new AbrirPorta()));
        rotina.adicionaCommand(new LigarLuzCommand(new LigarLuz()));
        rotina.adicionaCommand(new FecharPortaCommand(new FecharPorta()));
        rotina.executarCommands();
    }
}
