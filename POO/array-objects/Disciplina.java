

public class Disciplina {
    private String nome;
    private String curso;
    private Professor professor;
    private Aluno[] alunos;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public Aluno[] getAlunos() {
        return alunos;
    }

    public void setAluno(Aluno[] alunos) {
        this.alunos = alunos;
    }

    public void imprime(){
        System.out.println("Disciplina: "+this.nome+", Professor: "+this.getProfessor().getNome());

        for (int i=0;i<3;i++){
            System.out.println(this.alunos[i].getNome());
        }
    }
}
