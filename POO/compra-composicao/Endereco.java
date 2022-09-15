public class Endereco {
    public String logradouro;
    public String cidade;
    public String estado;

    public Endereco(String logradouro, String cidade, String uf){
        this.cidade=cidade;
        this.estado=uf;
        this.logradouro=logradouro;
    }
}
