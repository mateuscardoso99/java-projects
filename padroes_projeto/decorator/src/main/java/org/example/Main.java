package org.example;

/**
 * – O Padrão do Decorator é usado para estender a
    funcionalidade de um objeto dinamicamente sem ter que alterar a origem da classe original ou usar
    herança. Isso é conseguido criando um wrapperde objeto denominado “Decorator” em torno do
    objeto real.

    permite que um objeto cliente (nesse exemplo a classe Banco) interaja com o objeto Decorator
    exatamente da mesma maneira que faria com o objeto real

    O objeto Decorator (nesse exemplo LogBancoDecorator) contém uma referência ao objeto real (que é a classe Banco, recebendo no construtor)

    O objeto Decorator recebe todas as solicitações (chamadas) de
    um cliente (nesse exemplo classe Banco). Ele, por sua vez, encaminha essas chamadas para o
    objeto subjacente
 */
public class Main {
    public static void main(String[] args) {

    }
}