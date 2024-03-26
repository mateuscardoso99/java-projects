package org.example.classes.Pecas;

public class Triangulo extends Peca{
    private Double lado;
    private Double altura;

    public Triangulo(Integer codigo, Double lado, Double altura) {
        super(codigo);
        this.lado = lado;
        this.altura = altura;
        calcularArea();
    }

    @Override
    public void calcularArea() {
        this.area = (this.lado * this.altura) / 2;
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
