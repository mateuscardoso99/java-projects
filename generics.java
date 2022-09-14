/*
 * podemos criar uma classe só e, a partir dessa classe, instanciar objetos de diferentes tipos, 
 * de acordo com a nossa escolha
 */

//Antes do generics:
//Vamos criar uma classe que recebe um número inteiro e possui um método que retorna o quadrado do número
class MinhaClasse {
    public int num;
    
    public MinhaClasse(int num) {
        this.num = num;
    }

    public int aoQuadrado() {
        return num * num;
    } 
}

//No entanto, agora quero usar valores do tipo Double também. Poderíamos fazer assim:
class MinhaClasse2{
    public int num;
    public Double num1;
    
    public MinhaClasse2(int num) {
        this.num = num;
    }
    public MinhaClasse2(Double num1) {
        this.num1 = num1;
    }

    public int aoQuadradoInt() {
        return num * num;
    } 
    public Double aoQuadradoDouble() {
        return num1 * num1;
    } 
}

/*
 * Agora, se o tipo recebido no construtor for Double, o objeto será do tipo Double. 
 * Depois é só invocar com obj.aoQuadradoDouble(). Poderíamos também criar outra classe idêntica, 
 * só que para trabalhar com Double.
 * Mas perceba que o código na classe fica bagunçado e repetido. 
 * E o generics resolve muito bem esse problema. Então, vamos alterar a classe 
 * MinhaClasse para trabalhar com essa feature
 */


//GENERICS:
class MinhaClasse3<T> {
    T obj;
    
    public MinhaClasse3(T obj) {
        this.obj = obj;
    }

    public void printar() {
        System.out.println(obj);
    }
}


/*
Para usar generics, utilizamos o (<>) com um tipo genérico; aqui, utilizamos o T que é uma convenção, 
mas funcionaria com X por exemplo. Depois criamos um atributo obj do tipo T, criamos o construtor e um método que 
retorna o valor desse obj.
Agora, para instanciar o objeto, precisamos passar entre <> o tipo que vamos passar para o construtor; 
fizemos isso com Integer, Double e String(tipos primitivos não funcionam).
De agora em diante, decidimos em uma só classe criada o tipo do objeto que estamos criando.
*/


//Ao trabalhar com valores numéricos, precisamos fazer uma alteração para tudo funcionar corretamente
//O próprio Java vai nos prevenir de usar a multiplicação pro tipo genérico T; 
//afinal, podemos passar um String sem querer, por o uso de extends Number
class MinhaClasse4<T extends Number> { // T agora dá um extends na classe Number
    T numClasse;
    
    public MinhaClasse4(T numClasse) {
        this.numClasse = numClasse;
    }

    Double aoQuadrado() {
        return numClasse.intValue() * numClasse.doubleValue();
    }

   // Outro exemplo agora usando <?> que vou explicar abaixo
    boolean saoIguais(MinhaClasse4<?> obj) {
        if(Math.abs(numClasse.doubleValue()) == Math.abs(obj.numClasse.doubleValue())) {
            return true;
        }
        return false;
    }
}
/*
 * Eu coloquei um método a mais, chamado “saoIguais”, 
 * que checa se os dois valores absolutos são iguais. 
 * Se adicionarmos o T e não o ?, um erro será gerado, 
 * pois o Java esperará um inteiro, que é o valor do inteiro.saoIguais(), 
 * e se fizermos doubleTipo.saoIguais(), ele esperará um Double. Usando ?, 
 * deixamos claro pro Java que ele pode esperar tanto um inteiro quanto um 
 * double, ou seja: podemos misturar os tipos.
 */


class Main {

    public static void main(String[] args) {
        MinhaClasse3<Integer> inteiro = new MinhaClasse3<>(2);
        inteiro.printar();
        MinhaClasse3<Double> decimal = new MinhaClasse3<>(2.0);
        decimal.printar();
        MinhaClasse3<String> palavra = new MinhaClasse3<>("Sou uma String");
        palavra.printar();

        MinhaClasse4<Integer> inteiro2 = new MinhaClasse4<>(5);
        MinhaClasse4<Double> doubleTipo = new MinhaClasse4<>(5.0);
        System.out.println(inteiro2.aoQuadrado() + " | " + doubleTipo.aoQuadrado());
        System.out.println(inteiro2.saoIguais(doubleTipo));
    }
}

