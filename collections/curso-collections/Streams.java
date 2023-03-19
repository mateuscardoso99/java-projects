import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

//manipulação de coleções de um modo funcional, com melhor performance
//não altera a coleção original, sempre cria uma nova coleção

class Streams {
    public static void main(String[] args) {
        List<String> ests = new ArrayList<>();
        ests.add("joao");
        ests.add("marcos");
        ests.add("carlos");
        ests.add("sara");
        ests.add("joana");
        ests.add("juan");
        System.out.println("total elementos "+ests.stream().count());

        System.out.println("elemento com mais letras: "+ests.stream().max(Comparator.comparingInt(String::length)));

        System.out.println("elemento com menor letras: "+ests.stream().min(Comparator.comparingInt(String::length)));

        System.out.println("elemento com letra R no nome: "
            +ests.stream().filter((est)-> est.toLowerCase().contains("r"))
            .collect(Collectors.toList()));//.collect(Collectors.toList()) converte pra List

        System.out.println("qtd letras de cada nome "
            +ests.stream().map((est)-> est.concat(" - ").concat(String.valueOf(est.length())))
            .collect(Collectors.toList()));//map retorna uma nova coleção com o mesmo tamanho mas com os dados alterados

        System.out.println("2 primeiros "+ests.stream().limit(2).collect(Collectors.toList()));

        ests.stream().forEach(System.out::print);//foreach faz algum processamento mas não retorna nada

        //peek faz algum processamento em cada elemento e retorna a coleção original
        System.out.println(ests.stream().peek(el -> System.out.println(el)).collect(Collectors.toList()));

        System.out.println(ests.stream().allMatch(el->el.contains("a")));//verifica se todos os elementos tem uma mesma caracteristica e retorna true ou false

        System.out.println(ests.stream().anyMatch(el->el.contains("t")));//verifica se pelo menos 1 elemento tem a caracteristica e retorna true ou false

        System.out.println(ests.stream().noneMatch(el->el.contains("t")));//verifica se nenhum elemento tem a mesma caracteristica e retorna true ou false

        ests.stream().findFirst().ifPresent(el -> System.out.println(el));//retorna 1o elemento, como se fizesse array[0]

        //juntando varias funcoes, porque cada uma retorna uma collection entao da pra usar varias funcoes juntas
        System.out.println(
            ests.stream()
            .peek(el -> System.out.println(el))
            .map((est)-> est.concat(" - ").concat(String.valueOf(est.length())))
            .peek(System.out::println)
            .filter((est)-> est.toLowerCase().contains("r"))
            .collect(Collectors.joining(", "))//retornando string separando por virgula
        );

        List<String> numerosAleatorios = Arrays.asList("1", "0", "4", "1", "2", "3", "9", "9", "6", "5");
        numerosAleatorios.stream().forEach(System.out::println);
        numerosAleatorios.stream().mapToInt(Integer::parseInt).forEach(System.out::println); //converte pra inteiro
        System.out.println("Ignore os 3 primeiros elementos da lista e imprima o restante:");
        numerosAleatorios.stream()
                .skip(3)
                .forEach(System.out::println);

        System.out.println("sem numeros repetidos:");
        numerosAleatorios.stream().distinct().forEach(System.out::println);

        System.out.println("Agrupe os valores ímpares múltiplos de 3 ou de 5:");
        List<Integer> numerosAleatoriosInteger = numerosAleatorios.stream()
                .map(Integer::parseInt)
                .collect(Collectors.toList());
//        dica: collect(Collectors.groupingBy(new Function())
        Map<Boolean, List<Integer>> collectNumerosMultiplosDe3E5 = numerosAleatoriosInteger.stream().collect(Collectors.groupingBy(i -> (i % 3 == 0 || i % 5 == 0)));
        System.out.println(collectNumerosMultiplosDe3E5);

        System.out.println("Mostre a média dos números: ");
        numerosAleatorios.stream()
               .mapToInt(Integer::parseInt)
               .average()
               .ifPresent(System.out::println);

        System.out.println("Remova os valores ímpares: ");
        numerosAleatoriosInteger.removeIf(integer -> integer % 2 != 0);

        System.out.print("Mostre o menor valor da lista: ");
        numerosAleatorios.stream()
                .mapToInt(Integer::parseInt)
                .min()
                .ifPresent(System.out::println);
    }
}
