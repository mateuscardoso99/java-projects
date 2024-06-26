package com.example;

import java.util.HashSet;
import java.util.Set;


public class Banco{
    public static Banco instanciaUnica;
    //private static Singleton uniqueInstance = new Singleton(); outra forma de usar singleton, nesse caso o método getInstance() apenas retorna a instancia e não cria uma nova e não precisa usar syncronized

    private Set<Conta> contas = new HashSet<>();
    private Serasa serasa;

    private Banco(){
        this.serasa = new Serasa();
    }

    public static synchronized Banco getInstance(){
        if(instanciaUnica == null){
            instanciaUnica = new Banco();
        }
        return instanciaUnica;
    }

    public Set<Conta> getContas() {
        return contas;
    }

    public void setContas(Set<Conta> contas) {
        this.contas = contas;
    }

    public void criarConta(Long numero, Double saldo, Double limite, TipoConta tipoConta){
        Conta c = null;
        if(tipoConta.equals(TipoConta.CONTA_CORRENTE)){
            c = new ContaCorrente();
            c.setTipoConta(TipoConta.CONTA_CORRENTE);
        }
        else if(tipoConta.equals(TipoConta.POUPANCA)){
            c = new ContaPoupanca();
            c.setTipoConta(TipoConta.POUPANCA);
        }
        c.setNumero(numero);
        c.setSaldo(saldo);
        c.setLimite(limite);
        this.getContas().add(c);
        c.adicionaObserver(serasa);
    }

    public void removerConta(Long numero){
        Conta conta = this.searchConta(numero);
        if(conta == null){
            System.out.println("conta não encontrada");
            return;
        }
        this.getContas().remove(conta);
    }

    public void deposito(Long numero, Double valor){
        Conta conta = this.searchConta(numero);
        if(conta == null){
            System.out.println("conta não encontrada");
            return;
        }
        conta.depositar(valor);
    }

    public void saque(Long numero, Double valor){
        Conta conta = this.searchConta(numero);
        if(conta == null){
            System.out.println("conta não encontrada");
            return;
        }
        conta.sacar(valor);
    }

    public void extrato(Long numero){
        Conta conta = this.searchConta(numero);
        if(conta == null){
            System.out.println("conta não encontrada");
            return;
        }
        conta.extrato();
    }

    public void transferir(Long numeroContaOrigem, Long numeroContaDestino, Double valor){
        Conta origem = this.searchConta(numeroContaOrigem);
        Conta destino = this.searchConta(numeroContaDestino);
        if(origem == null || destino == null){
            System.out.println("conta não encontrada");
            return;
        }
        origem.transferir(destino, valor);
    }

    public Conta searchConta(Long numero){
        return this.getContas().stream().filter(c -> c.getNumero().equals(numero)).findFirst().orElse(null);
    }
}
