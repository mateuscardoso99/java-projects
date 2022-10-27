public class Gerente extends Funcionario {
    private int idade;

    public Gerente(){}

    public Gerente(String nome, double salario, int idade){
        //super(nome,salario);/chama construtor da classe mae passando os parametros
        
        this.setNome(nome); //classe filha nao acessa os atributos da classe mae diretamente, a nao ser que se use protected na classe mae
        //super.setNome(nome);//mesmo efeito da linha anterior        
    
        this.salario = salario; //acessa diretamente atributo da classe mae porque la esta como protected
        this.idade = idade;
    }

    public Gerente(Funcionario func, int idade){
        this.setNome(func.getNome());
        this.setSalario(func.getSalario());
        this.idade = idade;
    }//esse construtor tem o mesmo resultado que o anterior

    public int getIdade(){
        return this.idade;
    }
    
    public void setIdade(int i){
        this.idade = i;
    }

    //sobrescreve metodo da classe mae, altera o seu comportamento
    @Override
    public double getBonificacao(){
        //super.getBonificacao(); chama metodo da classe mae

        return this.getSalario() + 1000;
    }

}
