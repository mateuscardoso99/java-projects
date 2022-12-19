package polimorfismo;

public class main {
    public static void main(String[] args) {
        Funcionario p = new Patrao("Marcos",123456,74447);
        Funcionario g = new Gerente("Alex",97754,23455);
        Funcionario e = new Empregado("Joao", 00742, 13766);
        
        p.imprimeCargo();
        p.imprimeSalario();
        
        g.imprimeCargo();
        g.imprimeSalario();
        
        e.imprimeCargo();
        e.imprimeSalario();
    }
}
