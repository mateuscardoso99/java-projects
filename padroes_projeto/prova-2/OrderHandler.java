package com.example;

public abstract class OrderHandler {
    protected OrderHandler successor;//ponteiro para o próximo manipulador da cadeia, em cada classe concreta será definido o próximo manipulador através do método setSuccessor()

    public abstract void handleOrder(Order order);

    //esse método foi criado pra evitar NullPointerExcepion, verifica se o próximo manipulador é null, se não for então chama o próximo da cadeia 
    public void handleProximoCadeia(Order order){
        if(successor != null){
            successor.handleOrder(order);
        }
    }

    public void setSuccessor(OrderHandler successor) {
        this.successor = successor;
    }    
}
