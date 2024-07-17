package com.example;

public interface Strategy {

    void collectPaymentDetails();

    boolean validatePaymentDetails();

    void pay(int amount);

}