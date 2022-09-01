package animal;

public class Main {
    public static void main(String[] args) {
        Gato gato = new Gato("bob", "desconhecida", 10.4);
        Cachorro cachorro = new Cachorro("bolao", "bull", 12.78);

        Animal animal = new Gato("paulao", "gato", 4);//polimorfismo

        System.out.println("gato: "+gato.getNome()+" peso: "+gato.getPeso());
        System.out.println("cao: "+cachorro.getNome()+" peso: "+cachorro.getPeso());
        System.out.println("animal: "+animal.getNome()+" peso: "+animal.getPeso());
        
        gato.emiteSom();
        cachorro.emiteSom();
        animal.emiteSom();//polimorfismo
    }
}
