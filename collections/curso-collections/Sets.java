//é implementado pelas classes HashSet, TreeSet, LinkedHashSet
//não permite itens repetidos
//não permite ordenação
//bom para grande quantidade de dados
//não permite atualização e nem busca por item pois não tem indices, é somente leitura
//bom para quando precisa de performance
//não possui indices [0],[1] etc..

//HashSet
//usar quando não é preciso ter ordenação
//não é ordenado e não permite valores repetidos
//permite no máximo 1 elemento nulo
//não mantem ordem de insercao

//LinkedHashSet
//usar quando precisa-se manter a ordem de inserção
//mantem a ordem de inserção
//permite no máximo 1 elemento nulo

//TreeSet
//usar quando precisa mudar a ordem dos elementos através de comparators
//pode ser reordenado
//semelhante a arvore binaria
//não permite elementos nulos
//quando os valores for string faz ordem alfabética, quando numeros ordem crescente

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class Sets {
    public static void main(String[] args) {
        Set<Double> notasAlunos = new HashSet<>();
        notasAlunos.add(6.8);
        notasAlunos.add(9.8);
        notasAlunos.add(5.7);
        notasAlunos.add(10.0);
        notasAlunos.add(7.4);
        System.out.println(notasAlunos);//ao imprimir a ordem de inserção não é respeitada, isso acontece pra melhorar a performance
        notasAlunos.remove(5.7);
        notasAlunos.forEach(n -> System.out.println(n));
    
        Set<Integer> sequenciaNumerica = new LinkedHashSet<>();
        sequenciaNumerica.add(1);
        sequenciaNumerica.add(2);
        sequenciaNumerica.add(4);
        sequenciaNumerica.add(8);
        sequenciaNumerica.add(16);
        System.out.println(sequenciaNumerica);//conserva a ordem de inserção
        sequenciaNumerica.remove(4);
        for(Integer n:sequenciaNumerica){
            System.out.println(n);
        }

        TreeSet<String> treeCapitais = new TreeSet<>();
        treeCapitais.add("porto alegre");
        treeCapitais.add("recife");
        treeCapitais.add("curitiba");
        treeCapitais.add("bh");
        treeCapitais.add("florianopolis");
        System.out.println(treeCapitais);
        System.out.println(treeCapitais.first());//retorno o topo da arvore
        System.out.println(treeCapitais.last());//retorna o ultimo elemento da arvore
        System.out.println(treeCapitais.lower("recife"));//retorna elemento abaixo do parametro passado
        System.out.println(treeCapitais.higher("recife"));//retorna elemento acima do parametro passado
        for(String s:treeCapitais){
            System.out.println(s);
        }
        //pollFirst() retorna e remove o 1o elemento, pollLast() faz o mesmo só que no ultimo
        //toda remoção em treeSet faz com que a arvore seja reordenada dando problemas de performance


        Set<Double> nums = new HashSet<>(Arrays.asList(1.5,8d,9d,3.3,0d,1.5));
        System.out.println(nums.toString());

        //procurando elemento
        System.out.println(nums.stream().filter(num -> num == 9d).collect(Collectors.toSet()));
        System.out.println(nums.contains(1.5));//verifica se valor existe
        System.out.println(Collections.max(nums));//maior valor
        double soma = 0;
        for(Double d : nums)
            soma+=d;
        System.out.println(soma);//soma

        nums.remove(8d);//remove
        System.out.println(nums);

        //nums.clear();//apaga tudo

        Set<Double> numsOrdenado = new TreeSet<>(nums);//pra ordenar precisa de treeset, nums pertence a classe Double que implementa Comparable, senão nao funcionaria
        System.out.println(numsOrdenado);



        //ordenacao

        System.out.println("--\tOrdem aleatória\t--");
        Set<Serie> minhasSeries = new HashSet<>(){{
            add(new Serie("got", "fantasia", 60));
            add(new Serie("dark", "drama", 60));
            add(new Serie("that '70s show", "comédia", 25));
        }};
        for (Serie serie: minhasSeries) 
            System.out.println(serie.getNome() + " - " + serie.getGenero() + " - " + serie.getTempoEpisodio());


        System.out.println("--\tOrdem inserção\t--");
        Set<Serie> minhasSeries1 = new LinkedHashSet<>() {{
            add(new Serie("got", "fantasia", 60));
            add(new Serie("dark", "drama", 60));
            add(new Serie("that '70s show", "comédia", 25));
        }};
        for (Serie serie: minhasSeries1) 
            System.out.println(serie.getNome() + " - " + serie.getGenero() + " - " + serie.getTempoEpisodio());


        System.out.println("--\tOrdem natural (TempoEpisodio)\t--");
        Set<Serie> minhasSeries2 = new TreeSet<>(minhasSeries1);
        for (Serie serie: minhasSeries2) 
            System.out.println(serie.getNome() + " - " + serie.getGenero() + " - " + serie.getTempoEpisodio());


        System.out.println("--\tOrdem Nome/Gênero/TempoEpisodio\t--");
        Set<Serie> minhasSeries3 = new TreeSet<>(new ComparatorNomeGeneroTempoEpisodio());
        minhasSeries3.addAll(minhasSeries);//ao adicionar será ordenado com base na classe ComparatorNomeGeneroTempoEpisodio pois na linha acima treeset foi criado usando esse comparator
        for (Serie serie: minhasSeries3)
            System.out.println(serie.getNome() + " - " + serie.getGenero() + " - " + serie.getTempoEpisodio());
    }
    
}


class Serie implements Comparable<Serie>{
    private String nome;
    private String genero;
    private Integer tempoEpisodio;

    public Serie(String nome, String genero, Integer tempoEpisodio) {
        this.nome = nome;
        this.genero = genero;
        this.tempoEpisodio = tempoEpisodio;
    }

    public String getNome() {
        return nome;
    }

    public String getGenero() {
        return genero;
    }

    public Integer getTempoEpisodio() {
        return tempoEpisodio;
    }

    @Override
    public String toString() {
        return "{" +
                "nome='" + nome + '\'' +
                ", genero='" + genero + '\'' +
                ", tempoEpisodio=" + tempoEpisodio +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Serie serie = (Serie) o;
        return nome.equals(serie.nome) && genero.equals(serie.genero) && tempoEpisodio.equals(serie.tempoEpisodio);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, genero, tempoEpisodio);
    }

    @Override
    public int compareTo(Serie serie) {
        int tempoEpisodio = Integer.compare(this.getTempoEpisodio(), serie.getTempoEpisodio());
        if (tempoEpisodio != 0) return tempoEpisodio;

        return this.getGenero().compareTo(serie.getGenero());
    }
}

class ComparatorNomeGeneroTempoEpisodio implements Comparator<Serie>{

    @Override
    public int compare(Serie s1, Serie s2) {
        int nome = s1.getNome().compareTo(s2.getNome());
        if (nome != 0) return nome;

        int genero = s1.getGenero().compareTo(s2.getGenero());
        if (genero != 0) return genero;

        return Integer.compare(s1.getTempoEpisodio(), s2.getTempoEpisodio());
    }
}