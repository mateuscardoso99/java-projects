interface Classificavel{
    public String variavel = "ola"; //variaveis em interfaces são sempre static e final mesmo que não sejam definidos esses modificadores
    public void teste();
    
    public default void metodo2(){ //default permite que a classe não implemente o metodo, definindo um comportamento padrão
        System.out.println("metodo 2");
    }
}

public class Main implements Classificavel{
    int idade;
    
    public void teste(){
        //Main p = (Main) c;
        Classificavel.super.metodo2(); //chamando metodo default da interface, não funciona dentro de metodos estaticos
    }
    
    public static void main(String[] args) {
        //Classificavel.variavel = "13"; erro
		System.out.println(Classificavel.variavel);
		Main m=new Main();
	    m.teste();
	    
	    Classificavel c = new Main();
	    c.metodo2(); // outra froma de chamar, um objeto do tipo da interface recebe uma instancia da classe que a implementa
	}
    
}
