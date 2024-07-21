package br.ufsm.csi.pp.exercicio_3_2;

public class Teste {

    public static void main(String[] args) {
        CaixaProdutos caixaProdutos = new CaixaProdutos(10.0);
        CaixaProdutos caixaPequena = new CaixaProdutos(5.0);
        Produto produto1 = new Produto(1.0);
        Produto produto2 = new Produto(2.0);
        Produto produto3 = new Produto(3.0);
        Produto produto4 = new Produto(4.0);
        Produto produto5 = new Produto(5.0);
        Produto produto6 = new Produto(6.0);
        caixaPequena.getProdutosCaixa().add(produto1);
        caixaPequena.getProdutosCaixa().add(produto2);
        caixaPequena.getProdutosCaixa().add(produto3);
        caixaProdutos.getProdutosCaixa().add(produto4);
        caixaProdutos.getProdutosCaixa().add(produto5);
        caixaProdutos.getProdutosCaixa().add(produto6);
        caixaProdutos.getProdutosCaixa().add(caixaPequena);
        assert caixaPequena.getPreco() == 6.0;
        assert caixaProdutos.getPreco() == 21.0;
    }

}
