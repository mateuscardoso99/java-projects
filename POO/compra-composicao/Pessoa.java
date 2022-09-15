public class Pessoa {
    public String nome;
    public String numero;
    public Endereco endereco;

    public Pessoa(String nome, String numero, String logradouro, String cidade, String uf){
        this.nome=nome;
        this.numero=numero;
        this.endereco = new Endereco(logradouro, cidade, uf);
    }

    public void consultaEndereco(){
        System.out.println("logradouro: "+this.endereco.logradouro);
        System.out.println("cidade: "+this.endereco.cidade);
        System.out.println("uf: "+this.endereco.estado);
    }

    public String consultaNome(){
        return this.nome;
    }
}
