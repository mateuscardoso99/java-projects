package com.example;

//manipulador que verifica se o preço do pedido é maior que 500
//se for então aplica o desconto de 15%
//senão passa a solicitação pro próximo manipulador da cadeia
public class SuperVIPOrderHandler extends OrderHandler{

    @Override
    public void handleOrder(Order order) {
        if(order.getTotalPrice() > 500){
            order.setDiscount(order.getTotalPrice() * 0.15);
            System.out.println("aplicando desconto de 15%");
            return;
        }
        this.handleProximoCadeia(order);
    }
    
}
