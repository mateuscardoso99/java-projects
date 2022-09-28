/*
 * Streams API, recurso que traz novas classes e métodos que ajudam a manipular coleções de maneira mais simples e eficiente
 * em uma Stream o acesso aos elementos é sequencial, não sendo possível alcançá-los através de índices, 
 * pois inexiste uma estrutura de dados para armazenar os elementos que, por sua vez, são processados sob demanda
 */

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class EnumJavaStreams{
    private String nome;
    private int idade;
    private TipoPessoa tipoPessoa;

    public enum TipoPessoa{
        FISICA,
        JURIDICA
    }

    public String getNome(){
        return nome;
    }
    public void setNome(String nome){
        this.nome = nome;
    }
    public int getIdade(){
        return this.idade;
    }
    public void setIdade(int i){
        idade = i;
    }
    public TipoPessoa getTipoPessoa(){
        return tipoPessoa;
    }
    public void setTipoPessoa(TipoPessoa t){
        tipoPessoa = t;
    }
}

//somente uma classe publica por arquivo
class Main{
    public static void main(String[] args){
        EnumJavaStreams p1 = new EnumJavaStreams();
        p1.setIdade(45);
        p1.setNome("joao");
        p1.setTipoPessoa(EnumJavaStreams.TipoPessoa.FISICA);
        
        EnumJavaStreams p2 = new EnumJavaStreams();
        p2.setNome("jonas");
        p2.setIdade(34);
        p2.setTipoPessoa(EnumJavaStreams.TipoPessoa.JURIDICA);

        EnumJavaStreams p3 = new EnumJavaStreams();
        p3.setNome("carlos");
        p3.setIdade(70);
        p3.setTipoPessoa(EnumJavaStreams.TipoPessoa.FISICA);

        List<EnumJavaStreams> listPessoas = new ArrayList<EnumJavaStreams>();
        listPessoas.add(p1);
        listPessoas.add(p2);
        listPessoas.add(p3);

        System.out.println(listPessoas.stream().count()); //retorna tamanho
        
        Stream a = listPessoas.stream().limit(1); //limit - Retorna uma nova stream que contém apenas os N primeiros elementos da stream original.
        listPessoas.stream().skip(2); //skip - Retorna uma nova stream que não contém os N primeiros elementos da stream original.
        
        //forEach - Realiza uma iteração sobre todos os elementos de uma stream e executa algum tipo de processamento. 
        //semelhante ao forEach do js, equivalente ao for (Cliente cliente: clientes)
        listPessoas.stream().forEach(p -> {
            System.out.println(p.getNome());
        });

        //reduce - Realiza uma operação de redução que leva uma sequência de elementos de entrada e os combina em um único resultado, como acumular valores.
        int somaidades = listPessoas.stream().map(EnumJavaStreams::getIdade).reduce(0,(subtotal ,element) -> subtotal + element);
        System.out.println("soma idades: "+somaidades);

        String juntarNomes = listPessoas.stream().map(EnumJavaStreams::getNome).reduce("",(parcialString, elementAtual) -> parcialString + elementAtual);
        System.out.println(juntarNomes);

        //map - Retorna uma stream consistindo no resultado da aplicação de uma função de mapeamento nos elementos da stream.
        Stream<String> nomes = listPessoas.stream().map(EnumJavaStreams::getNome);
        nomes.forEach(r -> System.out.println(r));

        //filter - Filtra os elementos de acordo com uma condição retornando uma nova stream
        Stream<EnumJavaStreams> b = listPessoas.stream().filter(pessoa -> pessoa.getTipoPessoa() == EnumJavaStreams.TipoPessoa.FISICA);
        b.forEach(p -> {
            System.out.println(p.getNome());
        });

        //sorted - Retorna uma nova stream contendo os elementos da stream original ordenados pela forma natural em ordem crescente.
        listPessoas.stream().sorted();

        //allMatch - Retorna true se todos os elementos da stream correspondem ao predicado fornecido.
        listPessoas.stream().allMatch(p -> p.getNome() == "joao");

        //anyMatch - Retorna true se qualquer um dos elementos da stream corresponde ao predicado fornecido.
        listPessoas.stream().anyMatch(p -> p.getNome() == "joao");

        //noneMatch - Retorna true se nenhum dos elementos da stream corresponde ao predicado fornecido.
        listPessoas.stream().noneMatch(p -> p.getTipoPessoa() == EnumJavaStreams.TipoPessoa.FISICA);

        //collect - Permite coletar o conteúdo da stream, por exemplo como uma lista (converte o retorno para List)
        List<String> nomes2 = listPessoas.stream().map(EnumJavaStreams::getNome).toList();

        //ofNullable - Retorna uma stream com o elemento informado ou uma stream vazia caso o elemento seja nulo.
        //Stream.ofNullable(clientes);

        /**
         * obter o nome dos 5 clientes do tipo pessoa física com maior limite. 
         * Podemos implementar essa tarefa com os 5 passos abaixo:
         * Filtrar os clientes do tipo pessoa física com filter
         * Ordenar os clientes por limite de forma decrescente com sorted.reversed
         * Limitar aos 5 primeiros clientes usando limit
            Obter o nome de cada cliente com map
            Armazenar o resultado em uma lista com collect
         */

        // List<String> nomes = clientes.stream().
        // filter(c -> c.getTipo() == Tipo.PESSOA_FISICA).
        // sorted(comparing(Cliente::getLimite).reversed()).limit(5).
        // map(Cliente::getNome).collect(toList());
    }
}