public class Teste{
   public static void main(String args[]){
        /*
        Uma interface funcional é uma interface que possui um único método abstrato. Estas interfaces podem ser usadas como expressões lambda, o que ajuda a tornar o código mais conciso e legível.
        Uma interface funcional é marcada com a anotação @FunctionalInterface, embora essa anotação seja opcional. 
        exemplo:
        @FunctionalInterface
        public interface Operacao {
            int executar(int a, int b);
        }
        Neste exemplo, Operacao é uma interface funcional que define um único método executar.

        Uso de expressões lambda:
        Com uma interface funcional, pode usar expressões lambda para implementá-la. 
        exemplo de como usa-la:
        */
        // Implementação utilizando uma expressão lambda
        Operacao soma = (a, b) -> a + b;
        Operacao subtracao = (a, b) -> a - b;

        System.out.println("Soma: " + soma.executar(5, 3));        // Saída: Soma: 8
        System.out.println("Subtração: " + subtracao.executar(5, 3)); // Saída: Subtração: 2

        //As interfaces funcionais são amplamente utilizadas nas APIs de Java, como nas classes do pacote java.util.function. Alguns exemplos comuns incluem:

        //Function<T, R>: Recebe um argumento do tipo T e retorna um resultado do tipo R.
        //Predicate<T>: Recebe um argumento do tipo T e retorna um booleano.
        //Consumer<T>: Recebe um argumento do tipo T e não retorna nada.
        //Supplier<T>: Não recebe argumentos e retorna um resultado do tipo T.
        //Exemplo com java.util.function
        //Aqui está um exemplo de como você pode usar interfaces funcionais predefinidas:

        // Usando Function
        Function<Integer, Integer> quadrado = x -> x * x;
        System.out.println("Quadrado de 5: " + quadrado.apply(5)); // Saída: Quadrado de 5: 25

        // Usando Predicate
        Predicate<Integer> isPar = x -> x % 2 == 0;
        System.out.println("5 é par? " + isPar.test(5)); // Saída: 5 é par? false
   }

}
