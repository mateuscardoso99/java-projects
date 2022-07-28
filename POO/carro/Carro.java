package exercicios;
class Carro implements InterfaceCarro{
    private static int total;
    private String modelo;
    private boolean ligado = false;
    private double quilometragem;

    public Carro(){
        total++;
    }

    public static int getTotal(){
        return total;
    }

    public String getModelo(){
        return this.modelo;
    }

    public void setModelo(String modelo){
        this.modelo = modelo;
    }

    public boolean getLigado(){
        return this.ligado;
    }

    public double getQuilometragem(){
        return this.quilometragem;
    }

    public void setQuilometragem(double q){
        this.quilometragem = q;
    }

    public void ligar(){
        this.ligado = true;
    }

    public void desligar(){
        this.ligado = false;
    }    
}