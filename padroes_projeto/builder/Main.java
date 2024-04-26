/* 
Diferente de outros padrões de criação, o Builder não exige que os produtos tenham uma interface comum. 
Isso torna possível produzir produtos diferentes usando o mesmo processo de construção.

É especialmente útil quando você precisa criar um objeto com muitas opções possíveis de configuração.

Neste exemplo, o padrão Builder permite a construção passo a passo de diferentes modelos de carros.
O exemplo também mostra como o Builder produz produtos de diferentes tipos (manual do carro) usando as mesmas etapas de construção.
O diretor controla a ordem da construção. Ele sabe quais etapas de construção chamar para produzir este ou aquele modelo de carro. 
Ele funciona com builders apenas por meio de sua interface comum. Isso permite passar diferentes tipos de builders para o diretor.
O resultado final é recuperado do objeto builder porque o diretor não pode saber o tipo de produto resultante. 
Somente o objeto builder sabe o que exatamente ele cria.


*/

public class Main {
    
    public static void main(String[] args) {
        Director director = new Director();
        
        // O Diretor obtém o objeto construtor concreto do cliente 
        // Isso porque o aplicativo sabe melhor qual construtor a ser usado para obter um produto específico.
        CarroBuilder carroBuilder = new CarroBuilder();
        director.constructCarroEsportivo(carroBuilder);

        //O produto final geralmente é recuperado de um objeto construtor, 
        //pois Diretor não está ciente e não depende de construtores concretos e produtos.
        Carro carro = carroBuilder.getResult();
        System.out.println("Carro construido: " + carro.getTipoCarro());

        CarroManualBuilder carroManualBuilder = new CarroManualBuilder();

        //O Diretor pode conhecer diversas formas de construção.
        director.constructCarroEsportivo(carroManualBuilder);

        Manual carroManual = carroManualBuilder.getResult();
        System.out.println("Carro manual construido: \n" + carroManual.print());
    }
}
