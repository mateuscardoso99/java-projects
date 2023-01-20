
class Teste{
    private String nome;
    protected String sobrenome; //se o atributo fosse privado, a classe filha nao ia conseguir acessar diretamente ex: t.nome, só através dos get e set ou super
    public Teste(String n, String sn){
        setNome(n);
        sobrenome=sn;
    }
    public void setNome(String n){
        nome = n;
    }
    public String getNome(){
        return nome;
    }
    public void setSobrenome(String n){
        sobrenome = n;
    }
    public String getSobrenome(){
        return sobrenome;
    }
}

class Teste2 extends Teste{
    protected int idade;
    
    //o construtor da classe mãe recebe 2 parametros String, entao o construtor da classe filha precisa ter tbm 2 parametros String pra passar pra classe mãe
    //se a classe mãe tivesse varios parametros a classe filha deve ter no seu construtor esses parametros tbm pra depois passar pra classe mãe
    public Teste2(String n, String sn, int i){
        super(n,sn);
        idade = i;
    }
    public void setIdade(int i){
        idade = i;
    }
    public int getIdade(){
        return idade;
    }
}

public class Main extends Teste2{
    
    public Main(String n, String sn, int i){
        super(n,sn,i);
    }
    
	public static void main(String[] args) {
	    Main m = new Main("joao","silva",34);
	    //System.out.println(m.nome); //erro pois eh um atributo privado da classe mãe
	    System.out.println(m.getNome());
		System.out.println(m.sobrenome); //a classe mãe tem nome pois herda da classe Teste(avó de Main)
		System.out.println(m.idade); //System.out.println(m.getIdade()); funciona tbm
	}
}
