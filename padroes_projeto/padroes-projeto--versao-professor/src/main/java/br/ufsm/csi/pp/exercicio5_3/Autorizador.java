package br.ufsm.csi.pp.exercicio5_3;

public abstract class Autorizador {

    private Autorizador proximoCadeia;

    public abstract void autoriza(Reembolso reembolso);

    public Autorizador getProximoCadeia() {
        return proximoCadeia;
    }

    public void setProximoCadeia(Autorizador proximoCadeia) {
        this.proximoCadeia = proximoCadeia;
    }
}
