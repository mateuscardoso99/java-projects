package newpackage;

public class Livro {
    private String nomeLivro;
    private String autor;
    private String editora;
    private double preco;

    public Livro(String nomeLivro, String autor, String editora, double preco) {
        this.nomeLivro = nomeLivro;
        this.autor = autor;
        this.editora = editora;
        this.preco = preco;
    }

    public Livro() {
    }

    public String getNomeLivro() {
        return nomeLivro;
    }

    public void setNomeLivro(String nomeLivro) {
        this.nomeLivro = nomeLivro;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getEditora() {
        return editora;
    }

    public void setEditora(String editora) {
        this.editora = editora;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }
    
    
}
