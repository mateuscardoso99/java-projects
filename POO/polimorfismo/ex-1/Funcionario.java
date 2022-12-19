package polimorfismo;

public class Funcionario {
    private String nome;
    private int cpf;
    protected double salario;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getCpf() {
        return cpf;
    }

    public void setCpf(int cpf) {
        this.cpf = cpf;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public Funcionario(String nome, int cpf) {
        this.nome = nome;
        this.cpf = cpf;
    }
    
    public void imprimeCargo(){}
    public void imprimeSalario(){}
}
