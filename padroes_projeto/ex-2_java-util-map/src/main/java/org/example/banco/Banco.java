package org.example.banco;

import java.util.LinkedHashMap;
import java.util.Map;

import org.example.banco.conta.Conta;
/**
 * Crie uma classe banco que armazene um conjunto de contas e forneça
métodos que permitam que sejam feitos criações de conta, exclusão
de contas, saques (uma conta corrente só pode fazer saques desde
que o valor não exceda o limite de saque -limite + saldo-), depósitos,
emissão de saldo e extrato e transferência entre contas.
 */
public class Banco {
    private Map<Long, Conta> contas = new LinkedHashMap<>();

    public Map<Long, Conta> getContas() {
        return contas;
    }

    public void setContas(Map<Long, Conta> contas) {
        this.contas = contas;
    }

    public void criarConta(Conta conta){
        this.getContas().put(conta.getNumero(), conta);
    }

    public void removerConta(Long numero){
        Conta conta = this.searchConta(numero);
        if(conta == null){
            System.out.println("conta não encontrada");
            return;
        }
        this.getContas().remove(numero);
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
        try{
            Conta conta = this.searchConta(numero);
            if(conta == null){
                System.out.println("conta não encontrada");
                return;
            }
            conta.sacar(valor);
        }catch(Exception ex){
            System.out.println("Erro ao sacar "+ex.getLocalizedMessage());
        }
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
        try{
            Conta origem = this.searchConta(numeroContaOrigem);
            Conta destino = this.searchConta(numeroContaDestino);
            if(origem == null || destino == null){
                System.out.println("conta não encontrada");
                return;
            }
            origem.transferir(destino, valor);
        }catch(Exception e){
            System.out.println("Erro ao transferir "+e.getLocalizedMessage());
        }
    }

    public Conta searchConta(Long numero){
        return this.getContas().get(numero);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((contas == null) ? 0 : contas.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Banco other = (Banco) obj;
        if (contas == null) {
            if (other.contas != null)
                return false;
        } else if (!contas.equals(other.contas))
            return false;
        return true;
    }

    
}
