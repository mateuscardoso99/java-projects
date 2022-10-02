package FinalStatic;

public class Carro{
    private static String nome;
    private final String cor = "BRANCO";

    public String getNome(){
        return this.nome;
    }

    //se o metodo eh estatico, o this que se refere a instancia da classe(objeto) nao funciona
    //se o metodo eh estatico ele nao consegue acessar propriedades nao estaticas, pois elas vao pertencer a cada objeto
    // public static String getNome(){
    //     return this.nome;
    // }

    public static void setNome(String n){
        nome = n;
    }
}
