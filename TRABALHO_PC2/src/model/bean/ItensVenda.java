package model.bean;

public class ItensVenda {
    private Produto idproduto;
    private Venda idvenda;
    private double totalitem;
    private int quantidade;

    public ItensVenda() {
    }

    public Produto getIdproduto() {
        return idproduto;
    }

    public void setIdproduto(Produto idproduto) {
        this.idproduto = idproduto;
    }

    public Venda getIdvenda() {
        return idvenda;
    }

    public void setIdvenda(Venda idvenda) {
        this.idvenda = idvenda;
    }

    public double getTotalitem() {
        return totalitem;
    }

    public void setTotalitem(double totalitem) {
        this.totalitem = totalitem;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
    
    
}
