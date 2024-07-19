package com.example;

/**
 * O estado de um objeto pode ser definido como sua condição exata em
 * qualquer ponto do tempo, dependendo dos valores de suas
 * propriedades ou atributos.
 *  
 * O padrão State é útil na concepção de uma estrutura eficiente onde
 * podem existir muitos estados diferentes 
 * e exibir comportamentos diferentes dependendo do estado em que se encontra
 * 
 * Na terminologia do padrão State, essa classe é referida como uma classe Context. 
 * Um objeto Context pode alterar seu comportamento quando há uma
 * alteração em seu estado interno e também é referido como um objeto Stateful.

 * SUPONDO UM TELEFONE QUE TEM 2 BOTÔES (LIGAR/DESLIGAR e BOTÂO HOME)
 * ESSES BOTÔES EXECUTAM DIFERENTES COMPORTAMENTOS BASEADO EM UM ESTADO
 * POR EXEMPLO SE A TELA TÁ LIGADA O BOTÃO LIGAR/DESLIGAR APAGA A TELA, 
 * SE A TELA DA DESLIGADA O BOTÃO LIGAR/DESLIGAR LIGA A TELA, E DEIXA A TELA BLOQUEADA
 * ESSE EXEMPLO DEMONSTRA UMA MÁQUINA DE ESTADOS
 * 
 * SÃO 3 ESTADOS POSSÍVEIS LIGADO, DESLIGADO E BLOQUEADO
 * 
 * STATE É UM PADRÃO QUE PERMITE QUE UM OBJETO ALTERE SEU COMPORTAMENTO QUANDO SEU ESTADO INTERNO MUDA
 * 
 * O CONTEXTO (OBJETO QUE MUDA DE ESTADO) É O OBJETO TELEFONE
 */
public class Main {
    public static void main(String[] args) {
        Telefone telefone = new Telefone(); //telefone inicia com estado = desligado (definido no construtor)
        System.out.println(telefone.clickPower()); //ao executar vai chamar state.onOffOn(), vai chamar o método onOffOn de Desligado.class, a classe Desligado ao executar o método vai setar o estado do telefone pra BLOQUEADO e vai invocar o método ligar() do telefone que vai retornar a msg "Ligando a tela, o dispositivo ainda está bloqueado"
        System.out.println(telefone.clickPower()); //ao executar vai chamar state.onOffOn(), vai chamar o método onOffOn de Bloqueado.class, a classe Bloqueado ao executar o método vai setar o estado do telefone pra DESLIGADO e vai invocar o método bloquear() do telefone que vai retornar a msg "Bloqueando o telefone e desligando a tela"
        System.out.println(telefone.clickHome()); //ao executar vai chamar state.onHome(), vai chamar o método onHome de Desligado.class, a classe Desligado ao executar o método vai setar o estado do telefone pra BLOQUEADO e vai invocar o método ligar() do telefone que vai retornar a msg "Ligando a tela, o dispositivo ainda está bloqueado"
        System.out.println(telefone.clickHome()); //ao executar vai chamar state.onHome(), vai chamar o método onHome de Bloqueado.class, a classe Bloqueado ao executar o método vai setar o estado do telefone pra LIGADO e vai invocar o método desbloquear() do telefone que vai retornar a msg "Desbloqueando o telefone e indo pra tela inicial"
        System.out.println(telefone.clickHome()); //ao executar vai chamar state.onHome(), vai chamar o método onHome de Ligado.class, a classe Ligado ao executar o método vai invocar o método homeScreen() do telefone que vai retornar a msg "Indo para a tela inicial"
        System.out.println(telefone.clickPower()); //ao executar vai chamar state.onOffOn(), vai chamar o método onOffOn de Ligado.class, a classe Ligado ao executar o método vai setar o estado do telefone pra DESLIGADO e vai invocar o método bloquear() do telefone que vai retornar a msg "Bloqueando o telefone e desligando a tela"
        System.out.println(telefone.clickPower()); //ao executar vai chamar state.onOffOn(), vai chamar o método onOffOn de Desligado.class, a classe Desligado ao executar o método vai setar o estado do telefone pra BLOQUEADO e vai invocar o método ligar() do telefone que vai retornar a msg "Ligando a tela, o dispositivo ainda está bloqueado"
        System.out.println(telefone.clickHome()); //ao executar vai chamar state.onHome(), vai chamar o método onHome de Bloqueado.class, a classe Bloqueado ao executar o método vai setar o estado do telefone pra LIGADO e vai invocar o método desbloquear() do telefone que vai retornar a msg "Desbloqueando o telefone e indo pra tela inicial"
    }
}
