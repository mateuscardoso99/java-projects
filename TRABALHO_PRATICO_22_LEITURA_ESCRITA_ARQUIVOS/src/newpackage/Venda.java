package newpackage;

public class Venda {
    private String dataVenda;
    private double valorTotal;
    private Livro listaLivros;
    private Cliente cliente;

    public Venda() {
    }

    public Venda(String dataVenda, double valorTotal, Livro listaLivros, Cliente cliente) {
        this.dataVenda = dataVenda;
        this.valorTotal = valorTotal;
        this.listaLivros = listaLivros;
        this.cliente = cliente;
    }

    public String getDataVenda() {
        return dataVenda;
    }

    public void setDataVenda(String dataVenda) {
        this.dataVenda = dataVenda;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public Livro getListaLivros() {
        return listaLivros;
    }

    public void setListaLivros(Livro listaLivros) {
        this.listaLivros = listaLivros;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    
    
}
