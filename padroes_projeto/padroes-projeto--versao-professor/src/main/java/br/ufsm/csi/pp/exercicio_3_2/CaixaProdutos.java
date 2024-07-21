package br.ufsm.csi.pp.exercicio_3_2;

import java.util.ArrayList;
import java.util.Collection;

public class CaixaProdutos implements TreeComponent {

    public CaixaProdutos(Double valorCaixa) {
        this.valorCaixa = valorCaixa;
    }

    private Collection<TreeComponent> produtosCaixa = new ArrayList<>();

    public Collection<TreeComponent> getProdutosCaixa() {
        return produtosCaixa;
    }

    private Double valorCaixa;

    @Override
    public Double getPreco() {
        Double valor = valorCaixa;
        for (TreeComponent produto : produtosCaixa) {
            valor += produto.getPreco();
        }
        return valor;
    }
}
