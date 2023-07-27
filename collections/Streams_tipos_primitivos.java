import java.util.Arrays;

class Teste{
    public static void main(String[] args) {
        String[] s = {"teste"};
        int[] i = {9,8,6,0,2};

        Arrays.stream(s).forEach(System.out::println);
        Arrays.stream(i).filter(v->v%2==0).forEach(System.out::println);
    }
}