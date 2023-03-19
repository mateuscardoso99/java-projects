//é usado para ordenação de dados, implementado pelas class Comparator e Comparable
//usa algoritmos de ordenação
//ordena objetos complexos (Pessoa, Cidade etc..) e não tipos primitivos pois para esses Collections.sort() é suficiente
//usado principalmente pela interface List

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;//define uma classe com regra de ordenação
//Comparable define regra de ordenação para uma classe de dominio

public class Comparators {
    public static void main(String[] args) {
        List<Estudante> ests = new ArrayList<>();
        ests.add(new Estudante("joao",23));
        ests.add(new Estudante("marcos",38));
        ests.add(new Estudante("carlos",13));
        ests.add(new Estudante("sara",29));
        ests.add(new Estudante("joana",43));
        ests.add(new Estudante("juan",67));
        System.out.println(ests);
        ests.sort((e1,e2)->e1.getIdade()-e2.getIdade());//ordem crescente, ordena baseado no resultado da subtracao, se > 1 entao é maior, se == 0 é igual, se < 0 é menor
        System.out.println(ests);
        ests.sort((e1,e2)->e2.getIdade()-e1.getIdade());//ordem decrescente
        System.out.println(ests);
        ests.sort(Comparator.comparingInt(Estudante::getIdade));//ordem crescente usando interface comparator
        System.out.println(ests);
        ests.sort(Comparator.comparingInt(Estudante::getIdade).reversed());//ordem decrescente usando interface comparator
        System.out.println(ests);
        Collections.sort(ests);//usando Collections, nesse caso o parametro precisa ser uma classe que implemente Comparable e sera usado o metodo compareTo da classe que do parametro passado
        System.out.println(ests);
        Collections.sort(ests, new EstudanteOrdemInversaComparator());//passando o objeto e a classe que implementa comparator
        System.out.println(ests);
    }
}

class Estudante implements Comparable<Estudante>{
    private String nome;
    private Integer idade;
    
    public Estudante(String n, int i){
        nome=n;
        idade=i;
    }
    public String getNome(){ return this.nome; }
    public void setNome(String n){ nome = n; }
    public Integer getIdade(){ return this.idade; }
    public void setIdade(int i){ idade = i; }

    @Override //se retorno for > 1 então é maior, se 0 entao igual e se < 0 é menor, com isso o algoritmo de ordenação consegue ordenar
    public int compareTo(Estudante e){
        return this.getIdade() - e.getIdade();
    }

    @Override
    public String toString(){return this.nome + "-"+ this.idade;}
}

//Comparator deve ser usado em uma classe separada que nao seja a de dominio
//deve ser usado tambem quando se tem mais de uma regra de ordenação para uma classe, entao se cria uma classe pra cada comparação e cada classe implementa Comparator e sobreescreve compare
class EstudanteOrdemInversaComparator implements Comparator<Estudante>{
    @Override
    public int compare(Estudante e1, Estudante e2){
        return e2.getIdade() - e1.getIdade();
    }
}
