package com.example;

public class PaymentService {
    private int cost;
    private boolean includeDelivery = true;

    private Strategy strategy; //referencia de uma das estratégias concretas, mas referencia sempre pela interface pra poder trocar de forma de pagamento facilmente

    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

    public void processOrder(int cost) {
        this.cost = cost;
        strategy.collectPaymentDetails();
        if (strategy.validatePaymentDetails()) {
            strategy.pay(getTotal());
        }
    }

    private int getTotal() {
        return includeDelivery ? cost + 10 : cost;
    }
}
