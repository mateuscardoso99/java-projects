package br.ufsm.csi.pp.exercicio1;

public class Retangulo implements Forma2D {

    private final Float base;
    private final Float altura;

    public Retangulo(Float base, Float altura) {
        this.base = base;
        this.altura = altura;
    }

    public Float getBase() {
        return base;
    }

    public void setBase(Float base) { }

    public Float getAltura() {
        return altura;
    }

    public void setAltura(Float altura) { }

    @Override
    public Float getArea() {
        return base * altura;
    }
}
