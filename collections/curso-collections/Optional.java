//usado pra trabalhar com valores que podem ser null e evitar NullPointerException

import java.util.Optional;
import java.util.OptionalDouble;
import java.util.OptionalInt;

class Optionals {
    public static void main(String[] args) {
        Optional<String> op = Optional.of("valor");
        //se valor existir executa o que está no 1o parametro, senão executa o que está no 2o
        op.ifPresentOrElse(System.out::println, () -> System.out.println("vazio"));

        Optional<String> op2 = Optional.ofNullable(null);
        op2.ifPresentOrElse((v) -> System.out.println(v), () -> System.out.println("vazio"));

        Optional<String> op3 = Optional.empty();
        op3.ifPresentOrElse((v) -> System.out.println(v), () -> System.out.println("vazio"));

        //existe tbm optional para tipos primitivos
        OptionalInt.of(89).ifPresent(System.out::println);
        OptionalDouble.of(89.99).ifPresent(System.out::println);

        System.out.println(op.isPresent());//retorna true se existe um valor, false se esta vazio
    }
}
