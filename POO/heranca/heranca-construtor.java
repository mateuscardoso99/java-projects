class Teste{
    public String nome;
    public int idade;
    
    public Teste(String nome, int idade){
        this.nome=nome;
        this.idade=idade;
    }
}

public class Main extends Teste{
    public Main(){} //erro: construtor da classe mãe recebe 2 parametros, entao classes filhas devem ter o construtor igual ao da mãe
  
    public static void main(String[] args) {
      System.out.println("Hello World");
    }
}
