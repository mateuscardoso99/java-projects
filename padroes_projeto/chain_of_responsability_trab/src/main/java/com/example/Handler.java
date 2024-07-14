package com.example;

public interface Handler {
    boolean handle(String nome, String email, String senha);//método que processa a solicitação, deve ser implementado por cada manipulador individualmente com a lógica própria dele
}
