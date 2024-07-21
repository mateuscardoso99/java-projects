package br.ufsm.csi.pp.exercicio2;

public interface Observavel {
    void adicionaObserver(Observer observer);
    void removeObserver(Observer observer);
    void notificaObservers();
}
