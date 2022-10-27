public class Funcionario {
    private String nome;
    protected double salario;

    public Funcionario() {}
    
    public Funcionario(String nome, double salario){
        this.nome = nome;
        this.salario = salario;
    }

    public String getNome(){
        return this.nome;
    }

    public void setNome(String n){
        this.nome = n;
    }

    public double getSalario(){
        return this.salario;
    }
    
    public void setSalario(double s){
        this.salario = s;
    }

    public double getBonificacao(){
        return this.salario + 500;
    }
}
