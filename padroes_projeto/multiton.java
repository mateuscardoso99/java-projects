//O padrão Multiton é um padrão de projeto criacional e é uma extensão do Singleton. 
//Ele permite instanciar um número limitado de objetos de uma classe

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

class Multiton {
    private static final Map<Nome, Multiton> objetosPossiveis;
    private final Nome nome;
    
    public enum Nome {
        JOAO, MARIA, CARLOS, LETICIA, JUAN
    }

    static{
        objetosPossiveis = new ConcurrentHashMap<>();
        objetosPossiveis.put(Nome.JOAO, new Multiton(Nome.JOAO));
        objetosPossiveis.put(Nome.MARIA, new Multiton(Nome.MARIA));
        objetosPossiveis.put(Nome.CARLOS, new Multiton(Nome.CARLOS));
        objetosPossiveis.put(Nome.LETICIA, new Multiton(Nome.LETICIA));
        objetosPossiveis.put(Nome.JUAN, new Multiton(Nome.JUAN));
    }

    //construtor privado pra não poder ser criado objetos fora da classe
    private Multiton(Nome nome){
        this.nome = nome;
    }

    public static Multiton getInstance(Nome nome) {
        return objetosPossiveis.get(nome);
    }

    public Nome getNome(){
        return this.nome;
    }

    public static void main(String args[]){
        System.out.println(Multiton.getInstance(Nome.JOAO).getNome());
    }
}

//outra forma
class Pessoa{
    private String nome;
    private String cpf;

    public static final Pessoa p1 = new Pessoa("joao","453.888.564-44");
    public static final Pessoa p2 = new Pessoa("maria","233.988.430-00");
    public static final Pessoa p3 = new Pessoa("cristian","999.633.922-12");

    private Pessoa(String nome, String cpf){
        this.nome = nome;
        this.cpf = cpf;
    }

    public String getNome(){
        return this.nome;
    }

    public String getCpf(){
        return this.cpf;
    }

    public static void main(String args[]){
        System.out.println(Pessoa.p1.getNome());
    }
}