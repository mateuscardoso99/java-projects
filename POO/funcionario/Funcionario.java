package funcionario;

public class Funcionario {
    private String nome;
    private int cpf;
    private double salario;

    public Funcionario(String nome, int cpf){
        this.nome = nome;
        this.cpf = cpf;
    }

    public String getNome(){
        return this.nome;
    }
    public int getCpf(){
        return this.cpf;
    }
    public double getSalario(){
        return this.salario;
    }
    public void setNome(String n){
        this.nome = n;
    }
    public void setCpf(int cpf){
        this.cpf = cpf;
    }
    public void setSalario(double salario){
        this.salario = salario;
    }

    public void imprimeSalario(){
        System.out.println("salario: "+this.salario);
    }

    public void imprimeCargo(){
        System.out.println("cargo: funcionario");
    }
}
