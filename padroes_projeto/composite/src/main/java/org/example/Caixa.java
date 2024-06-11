package org.example;

import java.util.ArrayList;
import java.util.List;

public class Caixa implements Order{
    private List<Order> produtos = new ArrayList<>();
    private Double valorCaixa;

    public Caixa(Double valor){
        this.valorCaixa = valor;
    }
    
    public List<Order> getProdutos() {
        return produtos;
    }
    
    public void setProdutos(List<Order> produtos) {
        this.produtos = produtos;
    }    
    
    @Override
    public Double calcularPreco() {
        //Order::calcularPreco funciona pois tanto Caixa.class quando Produto.class são Order.class, então tanto faz, referencia-se pela interface
        return this.produtos.stream().mapToDouble(Order::calcularPreco).sum() + valorCaixa;
    }
}
