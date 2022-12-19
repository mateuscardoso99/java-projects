public class Main{
    int x = 10;
    static int y = 67;

	public static void main(String[] args) {
		System.out.println(y);//atributo static pode ser acessado sem o nome da classe se tiver dentro da propria classe
		System.out.println(Main.y);
		System.out.println(x);//erro, como x nao eh static, pra acessa-lo tem que ser criado um objeto
	}
}
