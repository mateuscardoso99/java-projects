package br.ufsm.csi.pp.exercicio6_2;

public class EstadoParado implements PlayerState {

    @Override
    public PlayerState play() {
        System.out.println("começa a tocar...");
        return new EstadoTocando();
    }

    @Override
    public PlayerState previous() {
        System.out.println("volta a musica anterior");
        return new EstadoTocando();
    }

    @Override
    public PlayerState next() {
        System.out.println("vai pra próxima música");
        return new EstadoTocando();
    }

    @Override
    public PlayerState lock() {
        System.out.println("bloqueou interface");
        return new EstadoBloqueado(this);
    }
}
