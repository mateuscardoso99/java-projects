package br.ufsm.csi.pp.exercicio6_2;

public interface PlayerState {

    public PlayerState play();

    public PlayerState previous();

    public PlayerState next();

    public PlayerState lock();

}
