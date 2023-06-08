import java.util.ArrayList;

public class Curso {
    private String nome;
    private ArrayList<Disciplina> disciplinas = new ArrayList<>();

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public ArrayList<Disciplina> getDisciplinas() {
        return disciplinas;
    }

    public void setDisciplinas(ArrayList<Disciplina> disciplinas) {
        this.disciplinas = disciplinas;
    }

    public void addDisciplina(Disciplina disc){
        this.disciplinas.add(disc);
    }

    public void imprime(){
        System.out.println("curso: "+nome);
        System.out.println("disciplinas:");

        for (int i=0; i<this.disciplinas.size(); i++) {
            System.out.println("nome disciplina: "+this.disciplinas.get(i).getNome());

            for(int j=0; j<this.disciplinas.get(i).getTurmas().size(); j++){
                System.out.println("turma: "+this.disciplinas.get(i).getTurmas().get(j).getNumero());
                System.out.println("professor: "+this.disciplinas.get(i).getTurmas().get(j).getProfessor().getNome());
                
                System.out.println("alunos: ");

                for(int k=0; k<this.disciplinas.get(i).getTurmas().get(j).getAlunos().size(); k++){
                    System.out.println("nome aluno: "+this.disciplinas.get(i).getTurmas().get(j).getAlunos().get(k).getNome());
                }
            }

            System.out.println();
        }

    }

}
