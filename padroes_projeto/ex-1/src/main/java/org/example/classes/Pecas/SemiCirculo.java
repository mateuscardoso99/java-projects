package org.example.classes.Pecas;

public class SemiCirculo extends Peca{
    private Double raio;

    public SemiCirculo(Integer codigo, Double raio) {
        super(codigo);
        this.raio = raio;
        this.calcularArea();
    }

    @Override
    public void calcularArea() {
        this.area = 3.14 * (this.raio * this.raio);
    }

    public Double getRaio() {
        return raio;
    }

    public void setRaio(Double raio) {
        this.raio = raio;
    }
}
