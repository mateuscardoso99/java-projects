package br.ufsm.csi.pp.exercicio5_2_ok;

import java.util.ArrayList;
import java.util.List;

public class InvokerSQL {

    private List<CommandSQL> comandos = new ArrayList<>();

    public void adicionaComando(CommandSQL comando) {
        comandos.add(comando);
        if (comandos.size() > 5) {
            //rotina executar todos e esvaziar a lista
        }
    }

}
