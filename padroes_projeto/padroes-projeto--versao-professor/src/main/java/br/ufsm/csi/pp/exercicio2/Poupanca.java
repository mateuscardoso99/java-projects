package br.ufsm.csi.pp.exercicio2;

import lombok.AllArgsConstructor;
import lombok.Builder;

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
