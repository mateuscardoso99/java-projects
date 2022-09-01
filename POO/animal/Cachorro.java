package animal;

public class Cachorro extends Animal{
    
    public Cachorro(String nome, String raca, double peso){
        super(nome, raca, peso);
    }

    public void emiteSom(){
        System.out.println("uauau");
    }
}
