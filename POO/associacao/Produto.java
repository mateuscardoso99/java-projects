public class Produto {
    private String nome;
    private double preco;
    private Fabricante fabricante;

    public Produto(String nome, double preco, Fabricante fabricante){
        this.nome = nome;
        this.preco = preco;
        this.fabricante = fabricante;
    }

    public String getNome(){
        return this.nome;
    }

    public double getPreco(){
        return this.preco;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public void setPreco(double preco){
        this.preco = preco;
    }

    public Fabricante getFabricante(){
        return this.fabricante;
    }

    public void setFabricante(Fabricante f){
        this.fabricante = f;
    }
}
