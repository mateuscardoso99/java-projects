package animal;

public class Animal {
    private String nome;
    private String raca;
    private double peso;

    public Animal(String nome, String raca, double peso){
        this.nome = nome;
        this.raca = raca;
        this.peso = peso;
    }

    public String getNome(){
        return this.nome;
    }
    public String getRaca(){
        return this.raca;
    }
    public double getPeso(){
        return this.peso;
    }
    public void setNome(String n){
        this.nome = n;
    }
    public void setRaca(String r){
        this.raca = r;
    }
    public void setPeso(double peso){
        this.peso = peso;
    }

    public void caminha(){
        this.peso--;
    }

    public void emiteSom(){
        System.out.println("som");
    }
}
