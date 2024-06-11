package org.example;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public abstract class ContaBancaria {
    private String numero;
    private Double saldo;
    private List<Movimentacao> movimentacoes = new LinkedList<>();

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    public List<Movimentacao> getMovimentacoes() {
        return movimentacoes;
    }

    public void setMovimentacoes(List<Movimentacao> movimentacoes) {
        this.movimentacoes = movimentacoes;
    }

    public enum TipoContaBancaria { CONTA_CORRENTE, POUPANCA, FUNDOS_RENDA }
    public static ContaBancaria newInstance(TipoContaBancaria tipoContaBancaria) {
        switch (tipoContaBancaria) {
            case POUPANCA -> {
                return Poupanca.newInstance();
            }
            case FUNDOS_RENDA -> {
                return FundosRenda.newInstance();
            }
            case CONTA_CORRENTE -> {
                return ContaCorrente.newInstance();
            }
        }
        return null;
    }

    public abstract Double calculaIR();

    public void saque(Double valor){
        if (valor <= saldo) {
            saldo = saldo - valor;
            Movimentacao movimentacao = new Movimentacao(Movimentacao.TipoMovimentacao.DEBITO, valor, "SAQUE NA BOCA DO CAIXA", new Date());
            movimentacoes.add(movimentacao);
        }
    }

    public void deposito(Double valor) {
        saldo = saldo + valor;
        Movimentacao movimentacao = new Movimentacao(Movimentacao.TipoMovimentacao.CREDITO, valor, "DEPOSITO NA BOCA DO CAIXA", new Date());
        movimentacoes.add(movimentacao);
    }

    public String extrato() {
        StringBuilder sb = new StringBuilder();
        for (Movimentacao movimentacao : movimentacoes) {
            sb.append(movimentacao.toString());
        }
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ContaBancaria that = (ContaBancaria) o;
        return Objects.equals(numero, that.numero);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numero);
    }
}