package com.example.state;

import com.example.Telefone;

public class Bloqueado extends State{
    public Bloqueado(Telefone telefone) {
        super(telefone);
    }

    @Override
    public String onHome() {
        telefone.setState(new Ligado(telefone));
        return telefone.desbloquear();
    }

    @Override
    public String onOffOn() {
        telefone.setState(new Desligado(telefone));
        return telefone.bloquear();
    }

}
