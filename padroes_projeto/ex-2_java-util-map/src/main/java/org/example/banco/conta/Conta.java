package org.example.banco.conta;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

import org.example.banco.movimentacao.Movimentacao;
import org.example.banco.movimentacao.TipoMovimentacao;

public class Conta {
    private Long numero;
    private Double saldo;
    private Boolean especial;
    private Double limite;
    private Collection<Movimentacao> movimentacoes;
    private TipoConta tipoConta;

    public Conta() {
        this.movimentacoes = new ArrayList<>();
    }

    public java.lang.Long getNumero() {
        return numero;
    }

    public void setNumero(java.lang.Long numero) {
        this.numero = numero;
    }

    public java.lang.Double getSaldo() {
        return saldo;
    }

    public void setSaldo(java.lang.Double saldo) {
        this.saldo = saldo;
    }

    public java.lang.Boolean getEspecial() {
        return especial;
    }

    public void setEspecial(java.lang.Boolean especial) {
        this.especial = especial;
    }

    public java.lang.Double getLimite() {
        return limite;
    }

    public void setLimite(java.lang.Double limite) {
        this.limite = limite;
    }

    public Collection<Movimentacao> getMovimentacoes() {
        return movimentacoes;
    }

    public void setMovimentacoes(Collection<Movimentacao> movimentacoes) {
        this.movimentacoes = movimentacoes;
    }

    public TipoConta getTipoConta() {
        return tipoConta;
    }

    public void setTipoConta(TipoConta tipoConta) {
        this.tipoConta = tipoConta;
    }

    public void depositar(Double valor){
        this.saldo += valor;
        Movimentacao movimentacao = new Movimentacao();
        movimentacao.setDescricao("deposito");
        movimentacao.setTipoMovimentacao(TipoMovimentacao.CREDITO);
        movimentacao.setValor(valor);
        this.movimentacoes.add(movimentacao);
    }

    public boolean sacar(Double valor) throws IllegalArgumentException{
        if(this.saldo < valor){
            throw new IllegalArgumentException("Saldo insuficiente");
        }
        if(this.tipoConta.equals(TipoConta.CONTA_CORRENTE) && valor > this.limite){
            throw new IllegalArgumentException("limite saque conta corrente");
        }
        this.saldo -= valor;
        Movimentacao movimentacao = new Movimentacao();
        movimentacao.setDescricao("saque");
        movimentacao.setTipoMovimentacao(TipoMovimentacao.DEBITO);
        movimentacao.setValor(valor);
        this.movimentacoes.add(movimentacao);
        return true;
    }

    public void transferir(Conta destino, Double valor) throws IllegalArgumentException{
        if(this.sacar(valor)){
            destino.depositar(valor);
        }
    }

    public void extrato(){
        System.out.println("numero: "+this.numero
                        +" saldo: "+this.saldo
                        +" limite: "+this.limite
                        +" movimentações: "+this.movimentacoes.stream().map(mov -> mov.getDescricao() + mov.getValor() + mov.getTipoMovimentacao()).collect(Collectors.joining(","))
                    );
    }

    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        if (!super.equals(object)) return false;

        Conta conta = (Conta) object;

        if (!java.util.Objects.equals(numero, conta.numero)) return false;
        if (!java.util.Objects.equals(saldo, conta.saldo)) return false;
        if (!java.util.Objects.equals(especial, conta.especial)) return false;
        if (!java.util.Objects.equals(limite, conta.limite)) return false;
        if (!java.util.Objects.equals(movimentacoes, conta.movimentacoes))
            return false;
        return tipoConta == conta.tipoConta;
    }

    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (numero != null ? numero.hashCode() : 0);
        result = 31 * result + (saldo != null ? saldo.hashCode() : 0);
        result = 31 * result + (especial != null ? especial.hashCode() : 0);
        result = 31 * result + (limite != null ? limite.hashCode() : 0);
        result = 31 * result + (movimentacoes != null ? movimentacoes.hashCode() : 0);
        result = 31 * result + (tipoConta != null ? tipoConta.hashCode() : 0);
        return result;
    }
}
