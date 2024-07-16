package com.example;

public class CEO extends Autorizador{
    public void autoriza(Reembolso reembolso) {
        System.out.println("CEO aprovou reembolso");
    }
}
