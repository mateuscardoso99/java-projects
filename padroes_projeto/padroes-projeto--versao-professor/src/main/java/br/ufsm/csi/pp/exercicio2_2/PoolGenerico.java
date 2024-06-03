package br.ufsm.csi.pp.exercicio2_2;

import lombok.SneakyThrows;

import java.util.ArrayList;
import java.util.List;

public class PoolGenerico<T> implements Pool<T> {

    private Class<T> classe;
    private List<T> objetosCriados = new ArrayList<>();
    private List<T> objetosDisponiveis = new ArrayList<>();

    @SneakyThrows
    public PoolGenerico(Class<T> classe) {
        this.classe = classe;
        for (int i = 0; i < 3; i++) {
            T obj = classe.newInstance();
            objetosCriados.add(obj);
            objetosDisponiveis.add(obj);
        }
    }

    @SneakyThrows
    @Override
    public T acquire() {
        synchronized (this) {
            if (!objetosDisponiveis.isEmpty()) {
                return objetosDisponiveis.removeFirst();
            } else {
                if (objetosCriados.size() < 20) {
                    T obj = classe.newInstance();
                    objetosCriados.add(obj);
                    return obj;
                } else {
                    this.wait();
                    return objetosDisponiveis.removeFirst();
                }
            }
        }
    }

    @Override
    public void release(T t) {
        synchronized (this) {
            if (objetosCriados.contains(t)) {
                objetosDisponiveis.add(t);
                this.notify();
            } else {
                throw new IllegalArgumentException("objeto nao criado por este pool.");
            }
        }
    }
}
