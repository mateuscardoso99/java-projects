package br.ufsm.csi.pp.exercicio6_2;

public class EstadoTocando implements PlayerState{
    @Override
    public PlayerState play() {
        System.out.println("pausou a música...");
        return new EstadoParado();
    }

    @Override
    public PlayerState previous() {
        System.out.println("música anterior...");
        return this;
    }

    @Override
    public PlayerState next() {
        System.out.println("próxima música...");
        return this;
    }

    @Override
    public PlayerState lock() {
        System.out.println("bloqueia interface...");
        return new EstadoBloqueado(this);
    }
}
