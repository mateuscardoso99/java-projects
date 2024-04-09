package br.ufsm.csi.pp.exercicio2;

import lombok.AllArgsConstructor;
import lombok.Builder;

@AllArgsConstructor
@Builder
public class Poupanca extends ContaBancaria {
    @Override
    public Double calculaIR() {
        return 0.0;
    }
}
