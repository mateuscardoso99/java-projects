package br.ufsm.csi.pp.exercicio1;

public class Losango implements Forma2D {

    private Float d1;
    private Float d2;

    public Float getD1() {
        return d1;
    }

    public void setD1(Float d1) {
        this.d1 = d1;
    }

    public Float getD2() {
        return d2;
    }

    public void setD2(Float d2) {
        this.d2 = d2;
    }

    @Override
    public Float getArea() {
        return d1 * d2 / 2;
    }
}
