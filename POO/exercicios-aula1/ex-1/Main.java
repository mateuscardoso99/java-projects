/*
 * Crie uma classe Retângulo. A classe possui os atributos altura
e largura. Ela possui métodos para calcular a área e o
perímetro do retângulo.
Detalhes:
- Todos os atributos devem ser privados.
- Devem existir métodos get e set para todos os atributos.
- Os valores válidos para altura e largura devem estar no intervalo [0,20].
Escreva um programa para testar a classe Retângulo.
 */
package ex_1;

public class Main {
    public static void main(String[] args) {
        Retangulo r = new Retangulo();
        r.setLargura(34);
        r.setAltura(10);
        r.setAltura(12);
        System.out.println("altura: "+r.getAltura()+", largura: "+r.getLargura());
    }
}
