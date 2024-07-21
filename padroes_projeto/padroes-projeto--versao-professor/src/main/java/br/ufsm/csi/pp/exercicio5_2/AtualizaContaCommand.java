package br.ufsm.csi.pp.exercicio5_2;

import br.ufsm.csi.pp.exercicio2.ContaBancaria;

public class AtualizaContaCommand implements DaoCommand {

    private DaoContaBancaria dao;
    private ContaBancaria contaBancaria;

    public AtualizaContaCommand(DaoContaBancaria dao, ContaBancaria contaBancaria) {
        this.dao = dao;
        this.contaBancaria = contaBancaria;
    }

    @Override
    public void execute() {
        this.dao.atualizaConta(contaBancaria);
    }
}
