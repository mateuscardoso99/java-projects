package bridge.solucao_usando_bridge;

public class ItalianRestaurante extends Restaurante{

    public ItalianRestaurante(Pizza pizza){
        super(pizza);
    }

    @Override
    void addSauce() {
        pizza.toppings = null;
    }

    @Override
    void addToppings() {
        pizza.sauce = "Oil";
    }

    @Override
    void makeCrust() {
        pizza.crust = "Thin";
    }
    
}
