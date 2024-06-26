package com.example;

/*
 * O Client capta interações do usuário, repassando as intenções deste ao Invoker, que invoca diferentes operações em diferentes objetos. 
 * – O Receiver, recebe requisições e realiza as operações. 
 * 
 * Usando o Padrão Command, o Invoker que emite uma solicitação em nome do cliente e o conjunto de objetos Receiver podem ser desacoplados.
 * 
 * O Padrão Command sugere a criação de uma abstração para o processamento a ser realizado ou a ação a ser tomada em resposta às solicitações do cliente.
 * 
 * Essa abstração pode ser projetada para declarar uma interface comum a ser implementada por diferentes implementadores concretos referidos como objetos Command. 
 * 
 * Cada objeto Command representa um tipo diferente de solicitação do cliente e o processamento correspondente.  
 * 
 * quem fornece o serviço é o receiver, nesse exemplo abrir/fechar cortina, ligar/apagar luz
 */

//este é o cliente
//ele Instancia os Commands associando-os ao Receiver e armazena-os no Invoker.
public class Main {
    public static void main(String[] args) {
        Sala sala = new Sala();
        sala.setCommand(new AbrirFecharCortinaCommand(sala.getCortina())); //Instancia o command (AbrirFecharCortinaCommand.class) associando-o ao Receiver (Cortina.class) e armazena-os no Invoker(Component.class).
        sala.executeCommand();

        LuminariaPiso luminariaPiso = new LuminariaPiso();
        luminariaPiso.setCommand(new LigarDesligarLuzCommand(luminariaPiso.getLuz()));
        luminariaPiso.executeCommand();
    }
}