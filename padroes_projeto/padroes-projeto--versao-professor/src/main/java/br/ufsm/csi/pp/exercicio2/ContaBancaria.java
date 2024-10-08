package br.ufsm.csi.pp.exercicio2;

import br.ufsm.csi.pp.exercicio3a.Prototype;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.*;

@Data
public abstract class ContaBancaria implements Observavel {

    private String numero;
    private Double saldo;
    private List<Movimentacao> movimentacoes = new LinkedList<>();
    private List<Observer> observers = new ArrayList<>();

    @Override
    public void adicionaObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notificaObservers() {
        for (Observer o : observers) {
            o.update(this);
        }
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

    public void saque(Double valor) throws MovimentacaoException {
        if (valor <= saldo) {
            saldo = saldo - valor;
            Movimentacao movimentacao = new Movimentacao(Movimentacao.TipoMovimentacao.DEBITO, valor, "SAQUE NA BOCA DO CAIXA", new Date());
            movimentacoes.add(movimentacao);
            notificaObservers();
        }
        throw new MovimentacaoException("saldo insuficiente");
    }

    public void deposito(Double valor) {
        saldo = saldo + valor;
        Movimentacao movimentacao = new Movimentacao(Movimentacao.TipoMovimentacao.CREDITO, valor, "DEPOSITO NA BOCA DO CAIXA", new Date());
        movimentacoes.add(movimentacao);
        notificaObservers();
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
