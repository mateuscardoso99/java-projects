package com.example;

//manipulador que verifica se o preço do pedido é menor que 100
//se for então aplica o desconto de 5%
//senão passa a solicitação pro próximo manipulador da cadeia
public class StandardOrderHandler extends OrderHandler{

    @Override
    public void handleOrder(Order order) {
        if(order.getTotalPrice() < 100){
            order.setDiscount(order.getTotalPrice() * 0.05);
            System.out.println("aplicando desconto de 5%");
            return;
        }
        this.handleProximoCadeia(order);
    }
    
}
