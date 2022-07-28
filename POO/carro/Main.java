package exercicios;
public class Main {
    public static void main(String[] args) {
        Carro carro = new Carro();
        
        carro.setModelo("fusca");
        carro.setQuilometragem(100.400);
        carro.ligar();

        System.out.println("modelo: "+carro.getModelo());
        System.out.println("KM: "+carro.getQuilometragem());
        System.out.println("ligado: "+carro.getLigado());

        carro.desligar();
        System.out.println("ligado: "+carro.getLigado());
        System.out.println("total de carros: "+Carro.getTotal());
    }
}
