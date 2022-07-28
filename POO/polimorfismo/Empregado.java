package polimorfismo;

public class Empregado extends Funcionario{
    
    public Empregado(String nome, int cpf, double salario) {
        super(nome, cpf);
        this.salario=salario;
    }

    @Override
    public void imprimeCargo(){
        System.out.println("cargo: empregado");
    }
    
    @Override
    public void imprimeSalario(){
        System.out.println("salario: "+getSalario());
    }
}
