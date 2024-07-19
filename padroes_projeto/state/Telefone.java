package com.example;

import com.example.state.Desligado;
import com.example.state.State;

public class Telefone {
    private State state;

    public Telefone() {
        state = new Desligado(this);
    }

    public void setState(State state) {
        this.state = state;
    }

    public String bloquear() {
        return "Bloqueando o telefone e desligando a tela";
    }

    public String homeScreen() {
        return "Indo para a tela inicial";
    }

    public String desbloquear() {
        return "Desbloqueando o telefone e indo pra tela inicial";
    }

    public String ligar() {
        return "Ligando a tela, o dispositivo ainda está bloqueado";
    }

    public String clickHome() {
        return state.onHome();
    }

    public String clickPower() {
        return state.onOffOn();
    }
}
