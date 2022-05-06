package arraylist;

import java.util.Date;

public class Professor extends Pessoa{
    private float salario;

    public Professor(String nome, String dataNascimento, float salario) {
        super(nome, dataNascimento);
        this.salario=salario;
    }

    public float getSalario() {
        return salario;
    }

    public void setSalario(float salario) {
        this.salario = salario;
    }
    
}
