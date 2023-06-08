import java.util.ArrayList;

public class Disciplina {
    private String nome;
    private ArrayList<Turma> turmas = new ArrayList<>();

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public ArrayList<Turma> getTurmas() {
        return turmas;
    }

    public void setTurmas(ArrayList<Turma> turmas) {
        this.turmas = turmas;
    }

    public void addTurma(Turma t){
        this.turmas.add(t);
    }
}
