package br.ufsm.csi.pp.exercicio_3_2;

public class Produto implements TreeComponent {

    public Produto(Double preco) {
        this.preco = preco;
    }

    private Double preco;
    @Override
    public Double getPreco() {
        return preco;
    }
}
