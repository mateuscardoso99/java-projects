import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

//As referências de método são um tipo especial de expressões lambda . Eles geralmente são usados ​​para criar expressões lambda simples referenciando métodos existentes.
//A referência do método é muito mais limpa e legível, pois nossa intenção é claramente mostrada pelo código
//só podem ser usados ​​para substituir uma expressão lambda de método único, ou seja se a expressão chamar apenas 1 metodo
//Em uma referência de método, se coloca o objeto (ou classe) que contém o método antes do :: e o nome do método depois dele sem argumentos

//Existem quatro tipos de referências de método:
//1-métodos estáticos
//2-Métodos de instância de objetos específicos
//3-Métodos de instância de um objeto arbitrário de um tipo particular 
//4-Construtor

public class ReferenceMethod{
    public static void main(String[] args) {
        //1-métodos estáticos
        //Começaremos com um exemplo bem simples, capitalizando e imprimindo uma lista de Strings :

        List<String> messages = Arrays.asList("hello", "baeldung", "readers!");
        
        //Podemos conseguir isso aproveitando uma expressão lambda simples chamando o método StringUtils.capitalize() diretamente:
        //messages.forEach(word -> StringUtils.capitalize(word));

        //Ou podemos usar uma referência de método para simplesmente nos referirmos ao método estático capitalize:
        //messages.forEach(StringUtils::capitalize);
        //** Nesse caso, quaisquer argumentos (se houver) obtidos pelo método (no caso o parametro word) são passados ​​automaticamente por baixo dos panos
    
    
        //2-Referência a um método de instância de um objeto específico
        BicycleComparator bikeFrameSizeComparator = new BicycleComparator();
        List<Bicycle> bikes = new ArrayList<>();

        //Poderíamos usar uma expressão lambda para classificar bicicletas por tamanho de quadro, mas precisaríamos especificar duas bicicletas para comparação:
        bikes.stream().sorted((a, b) -> bikeFrameSizeComparator.compare(a, b));

        //Em vez disso, podemos usar uma referência de método para que o parâmetro de manipulação do compilador passe para nós
        bikes.stream().sorted(bikeFrameSizeComparator::compare);//parametros do metodo compare sao passados automaticamente



        //3-Referência a um método de instância de um objeto arbitrário de um tipo particular
        //Esse tipo de referência de método é semelhante ao exemplo anterior, mas sem a necessidade de criar um objeto personalizado para realizar a comparação. Vamos criar uma  lista Integer que queremos classificar
        List<Integer> numbers = Arrays.asList(5, 3, 50, 24, 40, 2, 9, 18);
        
        //Se usarmos uma expressão lambda clássica, ambos os parâmetros precisam ser passados ​​explicitamente, enquanto usar uma referência de método é muito mais direto
        numbers.stream().sorted((a, b) -> a.compareTo(b));
        numbers.stream().sorted(Integer::compareTo);



        //4-Referência a um Construtor
        //Podemos referenciar um construtor da mesma forma que referenciamos um método estático em nosso primeiro exemplo. A única diferença é que usaremos a palavra-chave new .
        //Vamos criar um array Bicycle a partir de uma lista String com diferentes marcas:

        List<String> bikeBrands = Arrays.asList("Giant", "Scott", "Trek", "GT");
        //Em seguida, usaremos nosso novo construtor a partir de uma referência de método e criaremos um array Bicycle a partir da lista String original:
        
        bikeBrands.stream().map(Bicycle::new).toArray(Bicycle[]::new);

    
        //limitações:
        //a saída da expressão anterior precisa corresponder aos parâmetros de entrada da assinatura do método referenciado .

        bikes.forEach(b -> System.out.printf("Bike brand is '%s' and frame size is '%d'%n",b.getBrand(),b.getFrameSize()));
        //Este caso simples não pode ser expresso com uma referência de método, porque o método printf requer 3 parâmetros em nosso caso, e usar createBicyclesList().forEach() permitiria apenas que a referência de método inferisse um parâmetro (o objeto Bicycle ).
    }
}

class Bicycle {

    private String brand;
    private Integer frameSize;

    public Bicycle(String brand) {
        this.brand = brand;
        this.frameSize = 0;
    }    
    
    public String getBrand() {return brand;}
    public Integer getFrameSize() {return frameSize;}
    public void setBrand(String s) {brand=s;}
    public void setFrameSize(int s) {frameSize=s;}
}

class BicycleComparator implements Comparator<Bicycle> {

    @Override
    public int compare(Bicycle a, Bicycle b) {
        return a.getFrameSize().compareTo(b.getFrameSize());
    }

}