package com.example;

//manipulador que verifica se o preço do pedido é entre 100 e 500
//se for então aplica o desconto de 10%
//senão passa a solicitação pro próximo manipulador da cadeia
public class VIPOrderHandler extends OrderHandler{

    @Override
    public void handleOrder(Order order) {
        if(order.getTotalPrice() >= 100 && order.getTotalPrice() <= 500){
            order.setDiscount(order.getTotalPrice() * 0.10);
            System.out.println("aplicando desconto de 10%");
            return;
        }
        this.handleProximoCadeia(order);
    }
    
}
