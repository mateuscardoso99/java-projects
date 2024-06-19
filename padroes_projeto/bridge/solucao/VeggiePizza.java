package bridge.solucao_usando_bridge;

public class VeggiePizza extends Pizza{

    @Override
    public void montar() {
        System.out.println("adding sauce: " + sauce);
        System.out.println("adding toppings: " + toppings);
        System.out.println("adding cheese");
    }

    @Override
    public void qualityCheck() {
        System.out.println("crust is: " + crust);
    }

}
