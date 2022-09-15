public class Fabricante {
    private String nome;
    private String endereco;
    private String documento;

    public Fabricante(String nome, String endereco, String documento){
        this.nome = nome;
        this.endereco = endereco;
        this.documento = documento;
    }

    public String getNome(){
        return this.nome;
    }

    public void setNome(String n){
        this.nome = n;
    }

    public String getEndereco(){
        return this.endereco;
    }

    public void setEndereco(String e){
        this.endereco = e;
    }

    public String getDocumento(){
        return this.documento;
    }

    public void setDocumento(String doc){
        this.documento = doc;
    }
}
