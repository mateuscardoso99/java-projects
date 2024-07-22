package com.example;

import javax.swing.DefaultListModel;

/**
 * Mediador é um padrão de design comportamental que reduz o acoplamento entre componentes de um programa, 
 * fazendo com que eles se comuniquem indiretamente, por meio de um objeto mediador especial, que nesse exemplo é a classe Editor
 * 
 * O Mediator facilita a modificação, extensão e reutilização de componentes individuais porque eles não dependem mais de dezenas de outras classes.
 * 
 * O uso mais popular do padrão Mediator em código Java é facilitar comunicações entre componentes GUI de um aplicativo. O sinônimo do Mediator é a parte Controller do padrão MVC.
 * 
 * Aqui estão alguns exemplos do padrão nas principais bibliotecas Java:
 *      java.util.Timer(todos scheduleXXX()os métodos)
 *      java.util.concurrent.Executor#execute()
 *      java.util.concurrent.ExecutorService( invokeXXX() submit() métodos)
 *      java.util.concurrent.ScheduledExecutorService(todos scheduleXXX() métodos)
 *      java.lang.reflect.Method#invoke()
 * 
 * Este exemplo mostra como organizar muitos elementos da GUI para que eles cooperem com a ajuda de um mediador, mas não dependam uns dos outros.
 */
public class Main {
    public static void main(String[] args) {
        Mediator mediator = new Editor();

        mediator.registerComponent(new Title());
        mediator.registerComponent(new TextBox());
        mediator.registerComponent(new AddButton());
        mediator.registerComponent(new DeleteButton());
        mediator.registerComponent(new SaveButton());
        mediator.registerComponent(new List(new DefaultListModel()));
        mediator.registerComponent(new Filter());

        mediator.createGUI();
    }
}
