package com.example;

public abstract class Handler {
    private Handler next; //ponteiro para o próximo manipulador da cadeia

    public Handler setNextHandler(Handler next) { //define o ponteiro pro próximo manipulador
        this.next = next;
        return next;
    }

    public abstract boolean handle(String username, String password); //método que processa a solicitação, deve ser implementado por cada manipulador individualmente com a lógica própria dele

    protected boolean handleNext(String username, String password) {
        if (next == null) { //se caso não existir um próximo manipulador na cadeia, terá que processar a solicitação
            return true;
        }
        return next.handle(username, password); //chama o próximo manipulador
    }
}
