package com.example;

public abstract class BaseHandler implements Handler{
    protected Handler next; //ponteiro para o próximo manipulador da cadeia

    public Handler setNextHandler(Handler next) { //define o ponteiro pro próximo manipulador
        this.next = next;
        return next;
    }

    protected boolean handleNext(String nome, String email, String senha) {
        if (next == null) { //se caso não existir um próximo manipulador na cadeia, terá que processar a solicitação
            return true;
        }
        return next.handle(nome, email, senha); //chama o próximo manipulador
    }
}
