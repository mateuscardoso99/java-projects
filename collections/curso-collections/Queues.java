import java.util.LinkedList;

//é implementada pela classe linkedlist
//semelhante a uma fila, primeiro que entra primeiro que sai
//nao permite alteração, se quiser alterar tem q tirar, alterar, e inserir denovo
//nao permite ordenação, pois esta vai mudar a ordem dos elementos
import java.util.Queue;

public class Queues {
    public static void main(String[] args) {
        Queue<String> filaBanco = new LinkedList<>();
        filaBanco.add("joao");
        filaBanco.add("maria");
        filaBanco.add("roberto");
        filaBanco.add("emerson");
        System.out.println(filaBanco);

        String clienteAserAtendido = filaBanco.poll();
        System.out.println(clienteAserAtendido);
        System.out.println(filaBanco);
        //poll remove o primeiro elemento e retira ele
    
        System.out.println(filaBanco.peek());//retorna o primero elemento mas não remove
        System.out.println(filaBanco);

        System.out.println(filaBanco.element());//retorna o 1o elemento e não remove ele, se a lista estiver vazia lança uma exceção
        filaBanco.add("carlos");//adiciona sempre no final
        filaBanco.forEach(f -> System.out.println(f));
    }
}
