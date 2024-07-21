package br.ufsm.csi.pp.exercicio5_2_ok;

import br.ufsm.csi.pp.exercicio2.ContaBancaria;

public class DaoConta {

    private InvokerSQL invokerSQL;

    public void criaConta(ContaBancaria contaBancaria) {
        invokerSQL.adicionaComando(new CommandSQL("insert into conta_bancaria (...) (...)"));
    }

    public void atualizaConta(ContaBancaria contaBancaria) {
        invokerSQL.adicionaComando(new CommandSQL("update conta_bancaria set (...) where (...)"));
    }

    public void removeConta(ContaBancaria contaBancaria) {
        invokerSQL.adicionaComando(new CommandSQL("delete conta_bancaria where (...)"));
    }

    public void buscaContaBancaria(String codigo, BuscaContaCallback clbk) {
        invokerSQL.adicionaComando(new CommandSQL("select * from conta_bancaria where (...)"));
    }

    public interface BuscaContaCallback {
        void callback(ContaBancaria conta);
    }
}
