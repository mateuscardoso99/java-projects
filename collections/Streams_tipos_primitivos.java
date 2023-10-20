import java.util.Arrays;

class Teste{
    public static void main(String[] args) {
        String[] s = {"teste"};
        int[] i = {9,8,6,0,2};

        Arrays.stream(s).forEach(System.out::println);//Arrays.stream() funciona apenas para arrays primitivos do tipo int[], long[] e double[] e retorna IntStream, LongStream e DoubleStream
        Arrays.stream(i).filter(v->v%2==0).forEach(System.out::println);

        //Stream.of
        int arr[] = { 1, 2, 3, 4, 5 };
	    Stream<int[]> stream = Stream.of(arr);//Passando um array inteiro, o método Stream.of() retorna Stream enquanto Arrays.stream() retorna um IntStream
		stream.flatMapToInt(Arrays::stream).forEach(System.out::println);
    }
}
