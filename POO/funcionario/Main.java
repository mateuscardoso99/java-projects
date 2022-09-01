package funcionario;

public class Main {
    public static void main(String[] args) {
        Funcionario g = new Gerente("jonas", 459920044, 2000);

        System.out.println("nome: "+g.getNome());
        g.imprimeCargo();
        g.imprimeSalario();
    }
}
