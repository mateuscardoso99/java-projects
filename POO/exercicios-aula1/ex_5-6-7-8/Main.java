/*
 * Crie uma classe para manter os dados de um
professor. Devem ser mantidos os seguintes
dados: matrícula, nome, endereço, titulação,
área de atuação. Exemplifique o uso da classe.
 */

public class Main {
    public static void main(String[] args) {
        Professor p = new Professor();
        p.matricula = 449933;
        p.endereco = "rua a";
        p.areaAtuacao = "odonto";
        p.nome = "jonas";
        p.titulacao = "doutor";

        Aluno a = new Aluno();
        a.matricula = 8674;
        a.endereco = "rua a";
        a.anoIngresso = 1996;
        a.nome = "joao";
        a.semestreIngresso = 1;

        Curso c = new Curso();
        c.nome = "direito";
        c.sigla = "DDD";
        c.turno = "noite";
        c.ingressantes = 40;

        Disciplina d = new Disciplina();
        d.codigo = 4354;
        d.nome = "poo";
        d.preRequisitos = "algoritmo";

        System.out.println("aluno nome: "+a.nome+", matricula: "+a.matricula);
        System.out.println("professor nome: "+p.nome+", matricula: "+p.matricula);
        System.out.println("curso nome: "+c.nome+", turno: "+c.turno);
        System.out.println("discplina nome: "+d.nome+", codigo: "+d.codigo);
    }
}
