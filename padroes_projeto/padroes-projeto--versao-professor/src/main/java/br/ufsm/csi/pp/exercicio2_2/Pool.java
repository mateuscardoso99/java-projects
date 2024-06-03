package br.ufsm.csi.pp.exercicio2_2;

public interface Pool<T> {

    T acquire();
    void release(T t);

}
