package org.example.banco;

import java.util.HashSet;
import java.util.Set;

import org.example.banco.conta.Conta;
/**
 * Crie uma classe banco que armazene um conjunto de contas e forneça
métodos que permitam que sejam feitos criações de conta, exclusão
de contas, saques (uma conta corrente só pode fazer saques desde
que o valor não exceda o limite de saque -limite + saldo-), depósitos,
emissão de saldo e extrato e transferência entre contas.
 */
public class Banco {
    private Set<Conta> contas = new HashSet<>();

    public Set<Conta> getContas() {
        return contas;
    }

    public void setContas(Set<Conta> contas) {
        this.contas = contas;
    }

    public void criarConta(Conta conta){
        this.getContas().add(conta);
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
