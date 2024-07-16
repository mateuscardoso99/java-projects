package br.ufsm.csi.pp.exercicio6_2;

public class EstadoBloqueado implements PlayerState {

    private PlayerState estadoAnterior;

    public EstadoBloqueado(PlayerState estadoAnterior) {
        this.estadoAnterior = estadoAnterior;
    }

    @Override
    public PlayerState play() {
        System.out.println("não faz nada");
        return this;
    }

    @Override
    public PlayerState previous() {
        System.out.println("não faz nada");
        return this;
    }

    @Override
    public PlayerState next() {
        System.out.println("não faz nada");
        return this;
    }

    @Override
    public PlayerState lock() {
        System.out.println("desbloqueia interface");
        return estadoAnterior;
    }
}
