package com.example;

/*
 * Implementar o padrão Command para um DAO com métodos simples como: remover, atualizar, inserir e selecionar. 
 * - Cada um destes métodos do DAO gera um comando SQL que precisa ser processado pelo SGBD. 
 * - Implementar o padrão Command para abstrair os comandos SQL, considerando a conexão JDBC como sendo o receiver; 
 * - Implementar um invoker de comandos SQL, que permite a execução em lote. 
 * - Os métodos do DAO devem ser assíncronos, sendo que os retornos são implementados em Callbacks
 * 
 * 
 * Usando o Padrão Command, o Invoker que emite uma solicitação em nome do cliente e o conjunto de objetos Receiver podem ser desacoplados. 
 * - O Padrão Command sugere a criação de uma abstração para o processamento a ser realizado ou a ação a ser tomada em resposta às solicitações do cliente. 
 * – Essa abstração pode ser projetada para declarar uma interface comum a ser implementada por diferentes implementadores concretos referidos como objetos Command. 
 * – Cada objeto Command representa um tipo diferente de solicitação do cliente e o processamento correspondente
 */
public class Main {
    public static void main(String[] args) {
    }
}
