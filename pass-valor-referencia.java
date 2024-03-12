import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

//Variáveis ​​locais como primitivas e referências de objetos são criadas na memória Stack
//Os objetos são criados na memória Heap.

//variaveis de tipos primitivos: passagem por valor
//arrays de tipos primitivos, coleções: passagem por referencia
class Teste {
    public static void main(String[] args) {
	    int[] a = new int[2];
	    a[0]=1;
	    a[1]=2;
		Arrays.stream(a).forEach(System.out::println);//1,2
        t1(a);
        IntStream intStream = IntStream.of(a);
        intStream.forEach(System.out::println);//3,2

        List<Integer> i = new ArrayList<>();
        i.addAll(Arrays.asList(1,2,3,4));
        i.stream().forEach(System.out::println);//1,2,3,4
        t2(i);
        i.stream().forEach(System.out::println);//45,2,3,4,90
        t3(i);
        i.stream().forEach(System.out::println);//45,2,3,4,90
	}
    public static void t1(int[] b){
        b[0] = 3;
    }
    public static void t2(List<Integer> i){//parametro i é uma cópia da lista original mas que aponta pro mesmo objeto na memoria heap, portanto as mudancas refletem na lista original
        i.set(0,45);
        i.add(90);
    }

    //Neste caso, utilizamos o operador “new” para alterar a referência da i. i agora aponta para um novo objeto e, portanto, qualquer alteração feita neste objeto não afetará o objeto original da lista de numeros.
    public static void t3(List<Integer> i){
        i = new ArrayList<>();
        i.add(45);
        i.add(90);
    }

    //atribuição direta a um objeto recebido por parâmetro não altera o valor original, só altera fora da função se mudar os atributos do objeto
    public static void t4(Integer num){
    	num = 45;
    }
}
