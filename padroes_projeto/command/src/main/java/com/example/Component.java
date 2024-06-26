package com.example;

//INVOKER (REMETENTE), Classe que armazena os Commands que devem ser executados. e os executa
//responsável por iniciar solicitações, deve ter um campo para armazenar uma referência a um objeto de comando
public abstract class Component {

    //poderia ter uma lista de commands ao invés de só 1
    private Command command;

    public void setCommand(Command command) {
        this.command = command;
    }

    //aqui o invoker envia a solicitação para o command destinatario, LigarLuzCommand, AbrirCortinaCommand etc...
    public void executeCommand() {
        //aqui poderia ter um loop chamando os N comandos
        command.execute();
    }

}
