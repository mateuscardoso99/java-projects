package br.ufsm.csi.pp.exercicio2;

import java.util.ArrayList;
import java.util.List;

public class Serasa implements Observer {

    private List<ContaBancaria> devedores = new ArrayList<>();
    @Override
    public void update(Observavel observavel) {
        if (observavel instanceof ContaBancaria contaBancaria) {
            if (contaBancaria.getSaldo() < 0 && !devedores.contains(contaBancaria)) {
                devedores.add(contaBancaria);
            } else {
                devedores.remove(contaBancaria);
            }
         }
    }
}
