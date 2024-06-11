package org.example;

public interface BancoInterface {
    boolean excluiConta(String numero);

    void saque(String numero, Double valor);

    void deposito(String numero, Double valor);

    Double saldo(String numero);

    String extrato(String numero);

    void transferencia(String contaOrigem, String contaDestino, Double valor);

    ContaBancaria criaConta(Banco.TipoConta tipo, Double saldoInicial, boolean especial, Double limite);
}
