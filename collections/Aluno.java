public class Aluno {
    private String nome;
    private String curso;
    double nota;
  
    Aluno(String nome, String curso, double nota) {
      this.nome = nome;
      this.curso = curso;
      this.nota = nota;
    }

    public String getNome(){
        return this.nome;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public String getCurso(){
        return this.curso;
    }

    public void setCurso(String curso){
        this.curso = curso;
    }
  
    public String toString() {
      return this.nome;
    }

    // public int comparar(Aluno aluno) {
    //     return this.nome.compareTo(aluno.getNome());
    // }

    public boolean equals(Object o) {
        Aluno a = (Aluno) o;
        return this.nome.equals(a.getNome());
    }
    
    public int hashCode() {
        return this.nome.hashCode();
    }
}