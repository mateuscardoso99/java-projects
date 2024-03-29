package br.ufsm.csi.pp.exercicio2;

import java.util.HashMap;
import java.util.Map;

public class Banco {

    private Map<String, ContaBancaria> contas = new HashMap<>();

    public boolean excluiConta(String numero) {
        return contas.remove(numero) != null;
    }

    public boolean saque(String numero, Double valor) {
        ContaBancaria contaBancaria = contas.get(numero);
        if (contaBancaria == null) return false;
        return contaBancaria.saque(valor);
    }

    public boolean deposito(String numero, Double valor) {
        ContaBancaria contaBancaria = contas.get(numero);
        if (contaBancaria == null) return false;
        contaBancaria.deposito(valor);
        return true;
    }

    public Double saldo(String numero) {
        ContaBancaria contaBancaria = contas.get(numero);
        if (contaBancaria == null) return null;
        return contaBancaria.getSaldo();
    }

    public String extrato(String numero) {
        ContaBancaria contaBancaria = contas.get(numero);
        if (contaBancaria == null) return null;
        return contaBancaria.extrato();
    }

    public boolean transferencia(String contaOrigem, String contaDestino, Double valor) {
        if (!saque(contaOrigem, valor)) return false;
        deposito(contaDestino, valor);
        return true;
    }

    public ContaBancaria criaConta(TipoConta tipo, Double saldoInicial, boolean especial, Double limite) {
        ContaBancaria conta = null;
        if (tipo == TipoConta.CC) {
            ContaCorrente cc = new ContaCorrente(especial, limite);
            cc.setSaldo(saldoInicial);
            cc.setNumero(criaNumeroConta());
            conta = cc;
        } else if (tipo == TipoConta.POUPANCA) {
            Poupanca poupanca = new Poupanca();
            poupanca.setNumero(criaNumeroConta());
            poupanca.setSaldo(saldoInicial);
            conta = poupanca;
        } else if (tipo == TipoConta.RENDA_FIXA) {
            FundosRenda fundosRenda = new FundosRenda(FundosRenda.TipoFundo.RENDA_FIXA);
            fundosRenda.setNumero(criaNumeroConta());
            fundosRenda.setSaldo(saldoInicial);
            conta = fundosRenda;
        } else if (tipo == TipoConta.RENDA_VARIAVEL) {
            FundosRenda fundosRenda = new FundosRenda(FundosRenda.TipoFundo.RENDA_VARIAVEL);
            fundosRenda.setNumero(criaNumeroConta());
            fundosRenda.setSaldo(saldoInicial);
            conta = fundosRenda;
        }
        if (conta != null) {
            contas.put(conta.getNumero(), conta);
        }
        return null;
    }

    private Long numConta = 1l;
    private String criaNumeroConta() {
        synchronized (this) {
            return String.valueOf(numConta++);
        }
    }

    public enum TipoConta {
        CC, POUPANCA, RENDA_FIXA, RENDA_VARIAVEL
    }

}
