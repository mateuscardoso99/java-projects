import java.util.LinkedList;

/**
 * embora o uso de coleções simples não sincronizadas seja simples no geral, ele também pode se tornar um processo assustador e sujeito a erros ao trabalhar em ambientes multithread 
 * (também conhecido como programação simultânea).
 */

public class Main {
    public static void main(String[] args){
        //retorna uma collection sincronizada
        Collection<Integer> syncCollection = Collections.synchronizedCollection(new ArrayList<>());

        //outra forma
        List<Integer> syncCollection2 = Collections.synchronizedList(new LinkedList<>());

        Runnable listOperations = () -> {
            syncCollection.addAll(Arrays.asList(1, 2, 3, 4, 5, 6));
        };
        
        Thread thread1 = new Thread(listOperations);
        Thread thread2 = new Thread(listOperations);
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        
        //as 2 threads inserem 6 valores na collection e o tamanho sempre será 12 por que é sincronizada, ou seja, o acesso
        //aos métodos da lista (add, remove, get etc..) é sincronizado somente uma thread acessa esses métodos por vez
        //a iteração na lista não é sincronizada, então precisa ser feita dentro de um bloco sincronizado com a instância da Lista sincronizada como monitor do objeto: syncronized(syncCollection){}


        //map syncronized
        Map<Integer, String> syncMap = Collections.synchronizedMap(new HashMap<>());
        Map<Integer, String> syncSortedMap = Collections.synchronizedSortedMap(new TreeMap<>());

        //set syncronized
        Set<Integer> syncSet = Collections.synchronizedSet(new HashSet<>());
        SortedSet<Integer> syncSortedSet = Collections.synchronizedSortedSet(new TreeSet<>());

        /**
         * Coleções sincronizadas como essas acima alcançam segurança de thread por meio de bloqueio intrínseco e todas as coleções são bloqueadas. 
         * O bloqueio intrínseco é implementado por meio de blocos sincronizados nos métodos da coleção agrupada.
         * Como seria de esperar, as coleções sincronizadas garantem a consistência/integridade dos dados em ambientes multithread. 
         * No entanto, eles podem trazer uma penalidade no desempenho, já que apenas um único thread pode acessar a coleção por vez (também conhecido como acesso sincronizado).
         * 
         * As coleções sincronizadas alcançam segurança de thread ao impor a sincronização em cada um de seus métodos publicos disponíveis. 
         * Além disso, garante que o seu estado interno nunca seja publicado. Assim, a única maneira de modificar uma coleção é através dos seus métodos públicos sincronizados!
         * 
         * Pense nas coleções sincronizadas como coleções simples não sincronizadas, além de encapsulamento de estado e métodos públicos sincronizados.
         * 
         * Como todo método público de uma coleção sincronizada é protegido pelo mesmo bloqueio (intrínseco), não há dois threads que possam modificar/ler a coleção ao mesmo tempo
         * 
         * 
         * Coleções simultâneas:
         * Coleções simultâneas (por exemplo, ConcurrentHashMap) alcançam segurança de thread dividindo seus dados em segmentos. 
         * Em um  ConcurrentHashMap , por exemplo, diferentes threads podem adquirir bloqueios em cada segmento, então vários threads podem acessar o Map ao mesmo tempo 
         * (também conhecido como acesso simultâneo).
         * As coleções simultâneas têm muito mais desempenho do que as coleções sincronizadas , devido às vantagens inerentes do acesso simultâneo a threads.
         * 
         * ConcurrentHashMap vs synchronizedMap
         * ConcurrentHashMap bloqueia uma parte do mapa
         * ConcurrentHashMap permite realizar operações simultâneas de leitura e gravação desempenho é relativamente melhor que o synchronizedMap
         * ConcuurentHashMap não permite inserir nulo como chave ou valor
         * synchronizedMap bloqueia todo o mapa
         * synchronizedMap permite inserir nulo como chave
         * synchronizedMap, vários threads não podem acessar o mapa simultaneamente. desempenho é menor que o ConcurrentHashMap.
         */
    }




    /*
     * Embora os métodos expostos a partir de coleções sincronizadas sejam thread-safe, as ações compostas no lado do cliente ainda exigem bloqueio adequado
     * 
     * Este método é inseguro para threads! Mesmo com métodos thread-safe contains() e add(), o método não atinge o que pretendia. 
     * Entre o if() e a adição do nosso método, outro thread pode adicionar o elemento a lista. A guarda de tais ações compostas é de responsabilidade do cliente.
     * isso faz com que ainda seja preciso um bloco syncronized

       o certo seria: 
        public void teste(List<Integer> synchronizedList, Integer elem) {
            syncronized (synchronizedList) {
                if(!synchronizedList.contains()) {
                    synchronizedList.add(elem);
                }
            }
        }

     * É necessário tomar algum cuidado extra ao iterar em uma coleção sincronizada. Ao iterar em uma coleção sincronizada usando iteradores, 
     * quaisquer modificações simultâneas na coleção farão com que o iterador falhe rapidamente. Ao detectar qualquer modificação simultânea, o iterador lançará uma 
     * ConcurrentModificationException.
 
       final Set<String> syncStringSet = Collections.synchronizedSet(new HashSet<>());

        // Pode lançar uma ConcurrentModificationException
        for(String s: syncStringSet) {
            doSomething(s);
        }

     * Para evitar obter uma ConcurrentModificationException, podemos manter um bloqueio na coleção sincronizada durante toda a iteração. 
     * Claramente, esta não é a abordagem de melhor desempenho, pois a iteração pode levar muito tempo e bloqueará o acesso de outros threads em execução à coleção!
     */
    public void teste(List<Integer> synchronizedList, Integer elem) {
        if(!synchronizedList.contains()) {
          synchronizedList.add(elem);
        }
    }
}
