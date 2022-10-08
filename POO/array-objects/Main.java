
public class Main {
    public static void main(String[] args) {
        Professor p = new Professor();
        p.setNome("joao");
        p.setMatricula("5345345");

        Aluno a = new Aluno();
        a.setNome("jonas");
        a.setMatricula("567567567");

        Aluno a2 = new Aluno();
        a2.setNome("carlos");
        a2.setMatricula("567567567");

        Aluno a3 = new Aluno();
        a3.setNome("maria");
        a3.setMatricula("567567567");

        Aluno[] alunos = new Aluno[3];
        
        alunos[0] = a;
        alunos[1] = a2;
        alunos[2] = a3;

        Disciplina disc = new Disciplina();
        disc.setNome("poo");
        disc.setCurso("engenharia");
        disc.setProfessor(p);
        disc.setAluno(alunos);

        disc.imprime();
    }
}
