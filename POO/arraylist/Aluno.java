package arraylist;

import java.util.Date;

public class Aluno extends Pessoa{
    private float nota;

    public Aluno(String nome, String dataNascimento, float nota) {
        super(nome, dataNascimento);
        this.nota=nota;
    }

    public float getNota() {
        return nota;
    }

    public void setNota(float nota) {
        this.nota = nota;
    }
    
}
