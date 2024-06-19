package bridge.problema;

/**
 * supondo que fosse adicionar o modo de preparo italiano e americano de preparar pizzas
 * teria que criar as classes AmericanVeggiePizza, ItalianVeggiePizza, ItalianPepperoniPizza e AmericanPepperoniPizza
 * se fosse adicionar mais modos de preparo teria que criar mais classes pra cada um dos modos de preparo
 * ia crescer exponencialmente a hierárquia de classes
 */
public abstract class Pizza {
    protected String sauce;
    protected String toppings;
    protected String crust;

    public abstract void deliver();
}
