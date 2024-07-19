package com.example.state;

import com.example.Telefone;

public class Desligado extends State{

    public Desligado(Telefone telefone) {
        super(telefone);
    }

    @Override
    public String onHome() {
        telefone.setState(new Bloqueado(telefone));
        return telefone.ligar();
    }

    @Override
    public String onOffOn() {
        telefone.setState(new Bloqueado(telefone));
        return telefone.ligar();
    }

}
