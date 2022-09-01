import java.util.Comparator;

//compara objetos Aluno pelo nome
public class ComparaAluno implements Comparator<Aluno> {
  public int compare(Aluno a, Aluno b) {
    return a.getNome().compareTo(b.getNome());
  }
}
