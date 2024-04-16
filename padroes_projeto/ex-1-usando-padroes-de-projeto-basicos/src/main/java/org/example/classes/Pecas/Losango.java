package org.example.classes.Pecas;

public class Losango extends Peca{
    private final Double diagonalMaior; //padrão de projeto: immutable object, se quiser alterar o valor precisa criar outro objeto, pois é final e não pode ser alterado mais
    private final Double diagonalMenor;

    public Losango(Integer codigo, Double diagonalMaior, Double diagonalMenor) {
        super(codigo);
        this.diagonalMaior = diagonalMaior;
        this.diagonalMenor = diagonalMenor;
        calcularArea();
    }

    //só é possível acessar o valor, pelo fato de ser da classe Double que é uma classe imutável, não poderá ser alterado também
    public Double getDiagonalMaior() {
        return diagonalMaior;
    }

    //public void setDiagonalMaior(Double diagonalMaior) {
    //    this.diagonalMaior = diagonalMaior;
    //}

    public Double getDiagonalMenor() {
        return diagonalMenor;
    }

    //public void setDiagonalMenor(Double diagonalMenor) {
    //    this.diagonalMenor = diagonalMenor;
    //}

    @Override
    public void calcularArea() {
        this.area = this.diagonalMaior * this.diagonalMenor;
    }

    
}
