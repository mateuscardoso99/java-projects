public class Produto {
    public Long codigo;
    public String nome;

    public Produto(long code, String nome){
        this.codigo = code;
        this.nome = nome;
    }

    public String consultaNome(){
        return this.nome;
    }
}
