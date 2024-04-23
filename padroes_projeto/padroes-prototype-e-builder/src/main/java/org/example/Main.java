package org.example;

import java.math.BigDecimal;

/*
 * Defina uma interface Prototype usando genéricos (class:
    Prototype<T>, method: T clone()). Crie uma classe
    ContaBancaria que implementa Prototype e uma classe
    para teste.
 * Implemente um Builder para fazer pizzas, com métodos
    para acrescentar diferentes ingredientes permitindo
    fazer muitos sabores. • Construa também uma classe diretora que utiliza um builder
    para construir os diferentes sabores. • O Builder deve implementar um interface, o que permitiria fazer
    uma implementação do mesmo builder também para calzones e
    construir calzones com os mesmos sabores das pizzas
    reaproveitando o diretor.
 */
public class Main {
    public static void main(String[] args) {
        ContaBancaria c1 = new ContaBancaria();
        c1.setNumero("434-20");
        c1.setSaldo(new BigDecimal(1200));

        ContaBancaria c2 = c1.clone(); //gera um novo objeto apartir de c1
        System.out.println(c2.getNumero());
    }
}
