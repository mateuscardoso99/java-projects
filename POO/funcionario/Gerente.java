package funcionario;

public class Gerente extends Funcionario{
    
    public Gerente(String nome, int cpf, double salario){
        super(nome, cpf);
        this.setSalario(salario);
    }

    public void imprimeCargo(){
        System.out.println("cargo: gerente");
    }
}
