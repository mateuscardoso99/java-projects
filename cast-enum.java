//A declaração de enum pode ser feita fora de uma classe ou dentro de uma classe, mas não dentro de um método

/*Cada enum é implementado internamente usando Class.
/* internamente acima do enum A cor é convertida para
classe Cor
{
     public static final Color RED = new Color();
     public static final Color AZUL = new Color();
     public static final Color GREEN = new Color();
}
Cada constante enum representa um objeto do tipo enum.*/

// Cada constante enum é sempre implicitamente public static final . 
// Como é estático , podemos acessá-lo usando o enum Name. Como é final , 
// não podemos criar enums filhos

enum Day {
    SUNDAY,
    MONDAY,
    TUESDAY,
    WEDNESDAY,
    THURSDAY,
    FRIDAY,
    SATURDAY;
}

public class Main {
    public static void main(String[] args) {
        // Double datatype
        double d = 100.04;
 
        // Explicit type casting by forcefully getting
        // data from long datatype to integer type
        long l = (long)d;
 
        // Explicit type casting
        int i = (int)l;
 
        // Print statements
        System.out.println("Double value " + d);
 
        // While printing we will see that
        // fractional part lost
        System.out.println("Long value " + l);
 
        // While printing we will see that
        // fractional part lost
        System.out.println("Int value " + i);


        //ENUM
        /*As enumerações servem ao propósito de representar um grupo de constantes nomeadas em uma 
        linguagem de programação. Por exemplo, os 4 naipes em um baralho de cartas podem ser 4 
        enumeradores chamados Paus, Ouros, Copas e Espadas, pertencentes a um tipo enumerado 
        chamado Naipe. Outros exemplos incluem tipos naturais enumerados (como os planetas, 
        dias da semana, cores, direções, etc.). 
        Enums são usados ​​quando conhecemos todos os valores possíveis em tempo de compilação, 
        como opções em um menu, modos de arredondamento, sinalizadores de linha de comando, etc. 
        Não é necessário que o conjunto de constantes em um tipo enum permaneça fixo o tempo todo.
        Uma enumeração Java é um tipo de classe. Embora não precisemos instanciar um enum usando 
        new, ele tem os mesmos recursos de outras classes. Este fato torna a enumeração Java uma 
        ferramenta muito poderosa. Assim como as classes, você pode fornecer construtores, 
        adicionar variáveis ​​e métodos de instância e até mesmo implementar interfaces.
        Uma coisa a ter em mente é que, diferentemente das classes, as enumerações não herdam 
        outras classes nem podem ser estendidas (ou seja, tornam-se superclasses)*/
        
        System.out.println(Day.SATURDAY);
    }
}
