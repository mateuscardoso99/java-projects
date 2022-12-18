package model;

public class ItemPedido {
    private Produto produto;
    private int qtd;
    private double total;

    public ItemPedido(Produto p, int qtd){
        this.produto = p;
        this.qtd = qtd;
        this.total = produto.getPreco() * this.qtd;
    }

    public Produto getProduto(){
        return produto;
    }
    public void setProduto(Produto prod){
        produto = prod;
    }
    public int getQtd(){
        return qtd;
    }
    public void setQtd(int qtd){
        this.qtd = qtd;
    }
    public double getTotal(){
        return total;
    }
    public void setTotal(double total){
        this.total = total;
    }
}
