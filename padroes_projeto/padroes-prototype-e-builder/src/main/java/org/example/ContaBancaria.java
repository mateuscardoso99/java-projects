package org.example;

import java.math.BigDecimal;

/**
 * Defina uma interface Prototype usando genéricos (class:
    Prototype<T>, method: T clone()). Crie uma classe
    ContaBancaria que implementa Prototype e uma classe
    para teste.
 */
public class ContaBancaria implements Prototype<ContaBancaria>{
    private String numero;
    private BigDecimal saldo;

    public ContaBancaria(){}

    public ContaBancaria(ContaBancaria contaBancaria){
        this.numero = contaBancaria.numero;
        this.saldo = contaBancaria.saldo;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

    public void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }

    @Override
    public ContaBancaria clone(){
        return new ContaBancaria(this);
    }
}
