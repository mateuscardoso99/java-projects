package polimorfismo;

public class Gerente extends Funcionario{
    
    public Gerente(String nome, int cpf, double salario) {
        super(nome, cpf);
        this.salario=salario;
    }
    
    @Override
    public void imprimeCargo(){
        System.out.println("cargo: gerente");
    }
    
    @Override
    public void imprimeSalario(){
        System.out.println("salario: "+getSalario());
    }
    
}
