package com.example;

//RECEIVER, Define os objetos que terão as chamadas aos seus métodos controladas pelos commands concretos
//é o receiver que faz o trabalho real, o command de ligarLuz chama este receiver para ele ligar/desligar as luzes
//o invoker chama o command e o command chama o receiver. o command então faz o meio de campo entre invoker e receiver
//a lógica está dentro do receiver e não dentro do command
public class Cortina {
    private Boolean aberto = false;

    public void abrirFechar(){
        aberto = !aberto;
    }

    public boolean isOpen(){
        return aberto;
    }
}
