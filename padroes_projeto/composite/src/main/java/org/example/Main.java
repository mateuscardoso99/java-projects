package org.example;

import java.util.List;

/**
 * O uso do padrão Composite faz sentido apenas quando o modelo principal do seu aplicativo pode ser representado como uma árvore.
 * 
 * Por exemplo, imagine que você tem dois tipos de objetos: Produtos e Caixas. Uma Caixa pode conter vários Produtos, 
 * bem como um número menor Caixas. Esses pequenos Caixas também podem conter alguns Produtos ou até Caixas menores, e assim por diante
 * 
 * O padrão Composite sugere que você trabalhe com Produtos e Caixas através de uma interface comum que declare um método para 
 * calcular o preço total. – Para um produto, basta retornar o preço do produto. Para uma caixa, ele examinaria cada item da caixa, 
 * perguntaria seu preço e retornaria um total para essa caixa. – Se um desses itens fosse uma caixa menor, ela também começaria a 
 * repassar seu conteúdo e assim por diante, até que os preços de todos os componentes internos fossem calculados.
 * 
 * O maior benefício dessa abordagem é que você não precisa se preocupar com as classes concretas de objetos que compõem a árvore. 
 * Você não precisa saber se um objeto é um produto simples ou uma caixa sofisticada. 
 * Você pode tratá-los da mesma forma através da interface comum. (nesse exemplo interface ORDER)
 * Quando você chama um método, os próprios objetos passam a solicitação para baixo na árvore
 */
public class Main {
    public static void main(String[] args) {
        Produto p1 = new Produto("banana", 23.89d);
        Produto p2 = new Produto("abacaxi", 34.56d);

        Caixa caixa = new Caixa(8.99);
        caixa.getProdutos().addAll(List.of(p1, p2)); //adicionando produtos na caixa

        Caixa subcaixa = new Caixa(1.99);

        caixa.getProdutos().add(subcaixa); //adicionando outra caixa dentro da caixa

        System.out.println("total caixa: " + caixa.calcularPreco());
    }
}
