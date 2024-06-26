package com.example;

//publisher, aquilo que será observado
public interface Observavel {
    void adicionaObserver(Observer observer);
    void removeObserver(Observer observer);
    void notificaObservers();
}
