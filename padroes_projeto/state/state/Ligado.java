package com.example.state;

import com.example.Telefone;

public class Ligado extends State {
    public Ligado(Telefone telefone) {
        super(telefone);
    }

    @Override
    public String onHome() {
        return telefone.homeScreen();
    }

    @Override
    public String onOffOn() {
        telefone.setState(new Desligado(telefone));
        return telefone.bloquear();
    }
}
