import java.util.ArrayList;
//interface que é implementada por arraylist, vector e linkedlist
//vector é bom para threads
//linkedlist pra quando é preciso fazer varias insercoes e remoções
//arraylist é mais rapido pra leituras
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

public class Lists{
    public static void main(String[] args) {
        List<String> nomes = new ArrayList<>();
        nomes.add("joao");
        nomes.add("maria");
        nomes.add("bruna");
        nomes.add("flavio");
        nomes.add("carlos");
        System.out.println(nomes);
        Collections.sort(nomes);//metodo de ordenação
        System.out.println(nomes);
        nomes.set(1, "marcio");//altera o valor do indice 1
        System.out.println(nomes);
        nomes.remove(0);//remove posição 0
        System.out.println(nomes);
        nomes.remove("marcio");//remove o elemento passado
        System.out.println(nomes);
        System.out.println(nomes.contains("silvio"));//verifica se valor existe
        System.out.println(nomes.isEmpty());//verifica se esta vazio
        System.out.println(nomes.indexOf("joao"));//retorna a posição do valor da lista ou -1 se nao existir
        
        //iterar
        for(String s:nomes)
            System.out.println(s);

        Iterator<String> i = nomes.iterator();
        while(i.hasNext()){
            System.out.println(i.next());
        }
        
        nomes.clear();//limpa a lista

        //VECTOR
        List<String> vector = new Vector<>();
        vector.add("1");
        vector.add("2");
        vector.add("3");
        vector.add("4");

        List<String> vector2 = new Vector<>();
        vector.add("5");
        vector.add("6");

        System.out.println(vector.get(0));//retorna valor na posicao 0
        //os metodos e utilizações deles sao os mesmos tanto pra vector e arraylist
        vector.addAll(vector2);//adiciona uma lista dentro de outra
        System.out.println(vector);
    }
}