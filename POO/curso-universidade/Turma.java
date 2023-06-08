import java.util.ArrayList;

public class Turma {
    private int numero;
    private ArrayList<Aluno> alunos = new ArrayList<>();
    private Professor professor;

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public ArrayList<Aluno> getAlunos() {
        return alunos;
    }

    public void setAlunos(ArrayList<Aluno> alunos) {
        this.alunos = alunos;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public void addAluno(Aluno a){
        this.alunos.add(a);
    }
}
