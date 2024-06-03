package br.ufsm.csi.pp.exercicio2_2;

public class Singleton {

    private static Singleton INSTANCE;

    private Singleton() { }

    public static Singleton getInstance() {
        synchronized (Singleton.class) {
            if (INSTANCE == null) {
                INSTANCE = new Singleton();
            }
        }
        return INSTANCE;
    }

}
