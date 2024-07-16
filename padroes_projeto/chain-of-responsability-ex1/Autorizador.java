package com.example;

public abstract class Autorizador {
    private Autorizador proximoCadeia;

    public abstract void autoriza(Reembolso reembolso);
    public Autorizador getProximoCadeia(){
        return this.proximoCadeia;
    }
    public void setProximoCadeia(Autorizador proximoCadeia){
        this.proximoCadeia = proximoCadeia;
    }
}
