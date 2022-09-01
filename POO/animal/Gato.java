package animal;

public class Gato extends Animal{
    
    public Gato(String nome, String raca, double peso){
        super(nome, raca, peso);
    }

    public void emiteSom(){
        System.out.println("miau");
    }
}
