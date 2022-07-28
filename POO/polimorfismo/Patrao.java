package polimorfismo;

public class Patrao extends Funcionario{
    
    public Patrao(String nome, int cpf, double salario) {
        super(nome, cpf);
        this.salario=salario;
    }
    
    @Override
    public void imprimeCargo(){
        System.out.println("cargo: patrão");
    }
    
    @Override
    public void imprimeSalario(){
        System.out.println("salario: "+getSalario());
    }
    
}
