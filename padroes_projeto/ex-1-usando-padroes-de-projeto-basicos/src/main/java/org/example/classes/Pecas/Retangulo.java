package org.example.classes.Pecas;

public class Retangulo extends Peca{
    private Double lado;
    private Double altura;

    public Retangulo(Integer codigo, Double lado, Double altura) {
        super(codigo);
        this.lado = lado;
        this.altura = altura;
        calcularArea();
    }

    @Override
    public void calcularArea() {
        this.area = this.lado * this.altura;
    }

    public Double getLado() {
        return lado;
    }

    public void setLado(Double lado) {
        this.lado = lado;
    }

    public Double getAltura() {
        return altura;
    }

    public void setAltura(Double altura) {
        this.altura = altura;
    }
}
