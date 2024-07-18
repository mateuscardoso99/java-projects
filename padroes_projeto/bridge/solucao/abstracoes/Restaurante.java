package bridge.solucao_usando_bridge;

public abstract class Restaurante {
    protected Pizza pizza; //funciona com uma ponte entre as classes Pizza e Restaurante

    protected Restaurante(Pizza pizza){
        this.pizza = pizza;
    }

    abstract void addSauce();
    abstract void addToppings();
    abstract void makeCrust();

    public void deliver(){
        makeCrust();
        addSauce();
        addToppings();
        pizza.montar();
        pizza.qualityCheck();
        System.out.println("pedido em progresso!");
    }
}
