package org.example.classes.Pecas;

public class Losango extends Peca{
    private Double diagonalMaior;
    private Double diagonalMenor;

    public Losango(Integer codigo, Double diagonalMaior, Double diagonalMenor) {
        super(codigo);
        this.diagonalMaior = diagonalMaior;
        this.diagonalMenor = diagonalMenor;
        calcularArea();
    }

    public Double getDiagonalMaior() {
        return diagonalMaior;
    }

    public void setDiagonalMaior(Double diagonalMaior) {
        this.diagonalMaior = diagonalMaior;
    }

    public Double getDiagonalMenor() {
        return diagonalMenor;
    }

    public void setDiagonalMenor(Double diagonalMenor) {
        this.diagonalMenor = diagonalMenor;
    }

    @Override
    public void calcularArea() {
        this.area = this.diagonalMaior * this.diagonalMenor;
    }

    
}
