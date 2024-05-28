package org.example;

import java.lang.reflect.InvocationTargetException;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, InvocationTargetException, NoSuchMethodException {
        Fabrica fabrica = Fabrica.getInstance();
        Classe1 c1 = (Classe1) fabrica.criarInstancia("org.example.Classe1");
        Classe2 c2 = (Classe2) fabrica.criarInstancia("org.example.Classe2");
        Classe3 c3 = (Classe3) fabrica.criarInstancia("org.example.Classe3");

        Classe2 c22 = (Classe2) fabrica.criarInstancia("org.example.Classe2");
        c22.executar();
    }
}
