package bridge.solucao_usando_bridge;

public class AmericanRestaurante extends Restaurante{

    public AmericanRestaurante(Pizza pizza){
        super(pizza);
    }

    @Override
    void addSauce() {
        pizza.toppings = "Everything";
    }

    @Override
    void addToppings() {
        pizza.sauce = "Super secret recipe";
    }

    @Override
    void makeCrust() {
        pizza.crust = "Thick";
    }
    
}
