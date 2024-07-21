package com.example;

/*
 * O Bridge é um padrão de projeto estrutural que divide a lógica de negócio ou uma enorme classe em hierarquias de classe separadas que podem ser desenvolvidas independentemente.
 * Uma dessas hierarquias (geralmente chamada de Abstração) obterá uma referência a um objeto da segunda hierarquia (Implementação). 
 * A abstração poderá delegar algumas (às vezes, a maioria) de suas chamadas para o objeto de implementações. 
 * Como todas as implementações terão uma interface comum, elas são intercambiáveis dentro da abstração.
 * 
 * 
 * Bridge entre dispositivos e controles remotos
 * Este exemplo mostra a separação entre as classes de controles remotos e dispositivos que eles controlam.
 * Os controles remotos atuam como abstrações e os dispositivos são suas implementações. Graças às interfaces comuns, os mesmos controles remotos podem funcionar com dispositivos diferentes e vice-versa.
 * O padrão Bridge permite alterar ou mesmo criar novas classes sem tocar no código da hierarquia oposta.
 */
public class Main {
    public static void main(String[] args) {
        Device device1 = new TV();
        BasicRemote basicRemote = new BasicRemote(device1);
        basicRemote.power();
        device1.printStatus();

        System.out.println("Tests with advanced remote.");
        Device device2 = new Radio();
        AdvancedRemote advancedRemote = new AdvancedRemote(device2);
        advancedRemote.power();
        advancedRemote.mute();
        device2.printStatus();
    }
}
