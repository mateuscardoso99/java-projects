package org.example.banco.conta;

public interface InterfaceFactoryMethod {
    public Conta factoryMethod(Long numero, Double saldo, Boolean especial, Double limite, TipoConta tipoConta);
}
