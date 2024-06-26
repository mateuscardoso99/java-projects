package com.example;

public class Main {
    public static void main(String[] args) {
        Banco b = Banco.getInstance();
        b.criarConta(123l, 22d, 5000d, TipoConta.CONTA_CORRENTE);
        b.criarConta(456l, 78d, 3000d, TipoConta.POUPANCA);
        b.transferir(123l, 456l, 32d);
    }
}