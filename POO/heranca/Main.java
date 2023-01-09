//OBS: só é possível acessar o método da classe mãe, classes que estão acima na hierarquia não é possível acessar seus métodos
//ex: classe Object tem o método toString, classe A herda de Object e sobrescreve o toString, classe B herda de A e sobrescreve o toString
//nesse caso a classe B só consegue acessar o toString da classe A, o da classe Object ela não acessa, somente a classe A pode acessar o toString
//da classe Object ou seja é sempre no máximo 1 nível acima

public class Main{
    public static void main(String[] args) {
        Gerente g1 = new Gerente();
        g1.setNome("joao");
        g1.setSalario(5000);
        g1.setIdade(39);
        //classe gerente possui nome e salario como se fossem dela mesma, pois recebe por heranca de funcionario

        System.out.println("nome: "+g1.getNome()+"\nsalario: "+g1.getSalario()+"\nidade: "+g1.getIdade());

        Gerente g2 = new Gerente("jonas",4000,23);
        System.out.println("\nnome: "+g2.getNome()+"\nsalario: "+g2.getSalario()+"\nidade: "+g2.getIdade());

        Funcionario func = new Funcionario();
        func.setNome("carlos");
        func.setSalario(2000);

        Gerente g3 = new Gerente(func, 45);
        System.out.println("\nnome: "+g3.getNome()+"\nsalario: "+g3.getSalario()+"\nidade: "+g3.getIdade());
    }
    
}
