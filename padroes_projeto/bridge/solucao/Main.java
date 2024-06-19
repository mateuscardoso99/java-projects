package bridge.solucao_usando_bridge;

/**
 * padrão BRIDGE:
 * 
 * permite dividir uma classe grande ou um conjuto de classes intimamente relacionadas (como as classes da pasta "problema") 
 * em duas hierarquias separadas que podem ser desenvolvidas independentemente uma da outra (que nesse caso é a hierarquia do Restaurante e a hierarquia da Pizza) 
 * são chamadas de abstração e implementação, respectivamente
 * 
 * o padrão bridge permite dividir e organizar uma única classe que possui diversas variantes de alguma funcionalidade
 * em duas hierarquias: abstrações e implementações
 */
public class Main {
    public static void main(String[] args) {
        AmericanRestaurante americanRestaurante = new AmericanRestaurante(new PepperoniPizza());
        americanRestaurante.deliver();
        ItalianRestaurante italianRestaurante = new ItalianRestaurante(new VeggiePizza());
        italianRestaurante.deliver();
    }
}
