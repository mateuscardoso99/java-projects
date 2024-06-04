class Teste{
    public Object ola(){
        return "ola teste";
    }
    private Object ola2(){
        return "ola2 teste";
    }
}
class HelloWorld extends Teste{
    public String ola(){ //sobrescreve metodo da classe mãe mesmo o retorno não sendo Object, pois String é filha de Object então funciona
        return "ola 2";
    }
    public float ola(){ //erro, pois float é um tipo primitivo e não extende de Object
        return 2f;
    }
    private String ola(){//erro, pois na classe mãe ola() é publico, ola() não pode ser sobrescrito com um modificador mais rígido
        return "ola 2";
    }
    public String ola2(){ //funciona pois tá sendo sobrecrito com um modificador menos rígido
        return "ola 22";
    }
    public static void main(String[] args) {
        System.out.println("Hello, World!" + new HelloWorld().ola()); //vai chamar a implementação da classe mãe
        System.out.println("Hello, World!" + new Teste().ola()); //vai chamar a implementação da classe filha
    }
}
