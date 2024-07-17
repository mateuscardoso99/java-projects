package com.example;

/**
 * o padrão strategy (estratégia) sugere definir uma família de algoritmos, colocar cada um deles em uma classe separada (nesse exemplo os algoritmos são PaymentByCreditCard e PaymentByPayPal)
 * e tornar esses algoritmos intercambiáveis por meio de uma interface comum que todos eles implementam
 * nesse exemplo temos uma estratégia que coloca cada forma de pagamento em sua propria classe
 * isso é melhor do que ter vários IFs pra cada forma de pagamento em um mesmo método pois teria que mexer sempre no código do método pra adicionar uma forma de pagamento 
 * quebrando o princípio "aberto-fechado" que diz que um objeto deve ser aberto para extensões mas fechado para modificações que significa que ele deve poder ter suas funcionalidades extendidas sem precisar mexer no código-fonte
 * agora o método que faz o pagamento no PaymentService não sabe mais qual forma de pagamento será a utlizada e nem deve saber
 * ele agora tem uma refencia do método de pagamento mas o tipo é a interface possibilitando uma troca fácil de método de pagamento se for necessário
 */
public class Main {
    public static void main(String[] args) {
        PaymentService paymentService = new PaymentService();
        //A estratégia agora pode ser facilmente escolhida em tempo de execução

        paymentService.setStrategy(new PaymentByCreditCard());
        paymentService.processOrder(100);

        paymentService.setStrategy(new PaymentByPayPal());
        paymentService.processOrder(100);

    }
}
