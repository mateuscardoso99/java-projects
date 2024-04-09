package br.ufsm.csi.pp.exercicio1;

public class Retangulo implements Forma2D {

    private Float base;
    private Float altura;

    public Float getBase() {
        return base;
    }

    public void setBase(Float base) {
        this.base = base;
    }

    public Float getAltura() {
        return altura;
    }

    public void setAltura(Float altura) {
        this.altura = altura;
    }

    @Override
    public Float getArea() {
        return base * altura;
    }
}
