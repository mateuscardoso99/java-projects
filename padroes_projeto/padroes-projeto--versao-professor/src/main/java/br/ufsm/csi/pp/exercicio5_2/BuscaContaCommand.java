package br.ufsm.csi.pp.exercicio5_2;

import br.ufsm.csi.pp.exercicio2.ContaBancaria;

public class BuscaContaCommand implements DaoCommand {

    private DaoContaBancaria dao;
    private ContaBancaria contaBancariaBuscada;
    private String codigo;

    public BuscaContaCommand(DaoContaBancaria dao, String codigo) {
        this.dao = dao;
        this.codigo = codigo;
    }

    @Override
    public void execute() {
        this.contaBancariaBuscada = dao.buscaConta(codigo);
    }

    public ContaBancaria getContaBancariaBuscada() {
        return contaBancariaBuscada;
    }
}
