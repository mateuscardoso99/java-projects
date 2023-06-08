public class Teste {
    public static void main(String[] args) {
        Professor p1 = new Professor();
        p1.setNome("joao");
        p1.setCpf("202.332.122-78");

        Professor p2 = new Professor();
        p2.setNome("pedro");
        p2.setCpf("564.331.099-78");

        Aluno a1 = new Aluno();
        a1.setNome("jose");
        
        Aluno a2 = new Aluno();
        a2.setNome("maria");

        Aluno a3 = new Aluno();
        a3.setNome("carlos");
        
        Aluno a4 = new Aluno();
        a4.setNome("joao");

        Aluno a5 = new Aluno();
        a5.setNome("jonas");
        
        Aluno a6 = new Aluno();
        a6.setNome("felix");

        Turma t1 = new Turma();
        t1.setNumero(10);
        t1.setProfessor(p1);
        t1.addAluno(a1);
        t1.addAluno(a2);
        t1.addAluno(a3);

        Turma t2 = new Turma();
        t2.setNumero(20);
        t2.setProfessor(p2);
        t2.addAluno(a4);
        t2.addAluno(a5);
        t2.addAluno(a6);

        Disciplina d1 = new Disciplina();
        d1.setNome("poo");
        d1.addTurma(t1);

        Disciplina d2 = new Disciplina();
        d2.setNome("calculo");
        d2.addTurma(t2);

        Curso curso = new Curso();
        curso.setNome("si");
        curso.addDisciplina(d1);
        curso.addDisciplina(d2);

        curso.imprime();
    }
}
