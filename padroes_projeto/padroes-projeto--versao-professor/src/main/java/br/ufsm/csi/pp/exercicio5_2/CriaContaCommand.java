package br.ufsm.csi.pp.exercicio5_2;

import br.ufsm.csi.pp.exercicio2.ContaBancaria;

public class CriaContaCommand implements DaoCommand {

    private DaoContaBancaria dao;
    private ContaBancaria contaBancaria;

    public CriaContaCommand(DaoContaBancaria dao, ContaBancaria contaBancaria) {
        this.dao = dao;
        this.contaBancaria = contaBancaria;
    }

    @Override
    public void execute() {
        dao.criaConta(contaBancaria);
    }
}
