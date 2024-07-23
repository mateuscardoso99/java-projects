package com.example;

import java.text.DecimalFormat;

//padrão escolhido: Chain of Responsability
public class OrderProcessingExample {
    public static void main(String[] args) {
        //criando pedidos
        Order pedido1 = new Order();
        pedido1.setTotalPrice(30d);

        Order pedido2 = new Order();
        pedido2.setTotalPrice(200d);

        Order pedido3 = new Order();
        pedido3.setTotalPrice(1000d);

        Order pedido4 = new Order();
        pedido4.setTotalPrice(35071d);

        Order pedido5 = new Order();
        pedido5.setTotalPrice(2d);

        //montando a cadeia de responsabilidades na seguinte ordem: StandardOrderHandler -> VIPOrderHandler -> SuperVIPOrderHandler
        StandardOrderHandler standardOrderHandler = new StandardOrderHandler();
        VIPOrderHandler vipOrderHandler = new VIPOrderHandler();
        SuperVIPOrderHandler superVIpOrderHandler = new SuperVIPOrderHandler();
        standardOrderHandler.setSuccessor(vipOrderHandler);
        vipOrderHandler.setSuccessor(superVIpOrderHandler);

        DecimalFormat decimalFormat = new DecimalFormat("####.##");

        standardOrderHandler.handleOrder(pedido1);
        System.out.println("PEDIDO 1: Preço total: R$ " + decimalFormat.format(pedido1.getTotalPrice()) + ", desconto: R$ " + decimalFormat.format(pedido1.getDiscount()));

        standardOrderHandler.handleOrder(pedido2);
        System.out.println("PEDIDO 2: Preço total: R$ " + decimalFormat.format(pedido2.getTotalPrice()) + ", desconto: R$ " + decimalFormat.format(pedido2.getDiscount()));

        standardOrderHandler.handleOrder(pedido3);
        System.out.println("PEDIDO 3: Preço total: R$ " + decimalFormat.format(pedido3.getTotalPrice()) + ", desconto: R$ " + decimalFormat.format(pedido3.getDiscount()));

        standardOrderHandler.handleOrder(pedido4);
        System.out.println("PEDIDO 4: Preço total: R$ " + decimalFormat.format(pedido4.getTotalPrice()) + ", desconto: R$ " + decimalFormat.format(pedido4.getDiscount()));

        standardOrderHandler.handleOrder(pedido5);
        System.out.println("PEDIDO 5: Preço total: R$ " + decimalFormat.format(pedido5.getTotalPrice()) + ", desconto: R$ " + decimalFormat.format(pedido5.getDiscount()));
    }
}