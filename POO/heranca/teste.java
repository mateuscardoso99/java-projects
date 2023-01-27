class Teste{
    static int y=1;
    Teste(int x){
        this();y=y+2;
    }
    Teste(){y++;}
}
public class Main
{
    Main(){super(y);y=y*3;}
    
	public static void main(String[] args) {
		new Main();
		System.out.println(y);
	}
}

//construtor da classe filha chama construtor da classe mae que recebe um parametro passando o y que a classe Main recebeu por heranca;
//esse construtor chama o construtor vazio e dentro dele y passa a valer 2
//depois volta no construtor que recebe um parametro e y é incrementado em 2, entao y=4
//depois volta na classe Main e executa a linha seguinte, y = y*3; y=12
