package com.example.state;

import com.example.Telefone;

public abstract class State {
    protected Telefone telefone;

    public State(Telefone telefone) {
        this.telefone = telefone;
    }

    public abstract String onHome(); //executa quando clicar no botão HOME
    public abstract String onOffOn(); //executa quando clicar no botão LIGAR/DESLIGAR
}
