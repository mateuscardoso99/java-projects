package FinalStatic;

public class Main {
    public static void main(String[] args) {
        Carro c1 = new Carro();
        Carro c2 = new Carro();

        c1.setNome("gol");

        //objeto pode acessar e manipular propriedade e metodos estaticos
        //mas ela sera igual pra todos os objetos, se um objeto alterar essa propriedade
        //a mudança refletira pra todos os outros objetos, pois static pertence a classe e nao a cada objeto
        System.out.println(c1.getNome());//gol
        System.out.println(c2.getNome());//gol
        c2.setNome("fusca");

        System.out.println(c1.getNome());//fusca
        System.out.println(c2.getNome());//fusca

        Carro.setNome("uno");
        System.out.println(c1.getNome());//uno
        System.out.println(c2.getNome());//uno

        //Carro.nome; //erro propriedade nome eh privada entao nao pode ser acessada diretamente
        
        //classe final nao pode ser herdada
        //metodo final nao pode ser sobrescrito (override)
        //propriedade final nao pode ser alterada (constante)

        //se não coloca static nas variáveis, elas ficam com uma cópia diferente pra cada objeto

        //Método de instância (nao estaticos)
        //Métodos de instância são métodos que exigem que um objeto de sua classe seja criado antes de poder ser chamado.
        //Para invocar um método de instância, temos que criar um objeto da classe na qual o método está definido. 
        //O método de instância (nao estaticos) podem acessar variáveis ​​estáticas e métodos estáticos diretamente

        //propriedade estatica
        //Quando uma variável é declarada como estática, uma única cópia da variável é criada e compartilhada entre todos os objetos no nível de classe. 
        //Variáveis ​​estáticas são, essencialmente, variáveis ​​globais. Todas as instâncias da classe compartilham a mesma variável estática

        //metodo static são projetados com o objetivo de serem compartilhados entre todos os objetos criados a partir da mesma classe
        //metodos static acessam apenas outros atributos e metodos estaticos

        //herança metodos static
        //diferença entre métodos estáticos (classe) herdados e métodos não estáticos (instância) herdados
        //é que quando você escreve um novo método estático com a mesma assinatura, o método estático antigo é apenas oculto, não substituído.
        //Da página sobre a diferença entre substituir e ocultar.
        //A distinção entre ocultar e ignorar tem implicações importantes. A versão do método substituído que é invocado é a da subclasse. 
        //A versão do método oculto que é invocado depende se ele é invocado da superclasse ou da subclasse
    }
}
