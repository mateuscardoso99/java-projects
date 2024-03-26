package br.ufsm.csi.pp.exercicio2;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Poupanca extends ContaBancaria {
    @Override
    public Double calculaIR() {
        return 0.0;
    }
}
