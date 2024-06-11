package org.example;

public class Poupanca extends ContaBancaria implements Cloneable {

    private Poupanca() { }

    public static Poupanca newInstance() {
        return new Poupanca();
    }
    @Override
    public Double calculaIR() {
        return 0.0;
    }

}
