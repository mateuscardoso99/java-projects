package br.ufsm.csi.pp.exercicio1;

public class Quadrado implements Forma2D {

    private final Float lado;

    public Quadrado(Float lado) {
        this.lado = lado;
    }

    @Override
    public Float getArea() {
        return lado * lado;
    }
}
