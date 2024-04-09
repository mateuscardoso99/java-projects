package br.ufsm.csi.pp.exercicio1;

public class Quadrado implements Forma2D {

    private Float lado;

    public Float getLado() {
        return lado;
    }

    public void setLado(Float lado) {
        this.lado = lado;
    }

    @Override
    public Float getArea() {
        return lado * lado;
    }
}
