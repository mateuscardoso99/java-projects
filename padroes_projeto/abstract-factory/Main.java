/*
 * O Abstract Factory é um padrão de projeto criacional, que resolve o problema de criar famílias inteiras de produtos sem especificar suas classes concretas.
 * O Abstract Factory define uma interface para criar todos os produtos distintos, mas deixa a criação real do produto para classes fábrica concretas. 
 * Cada tipo de fábrica corresponde a uma determinada variedade de produtos.
 * O código cliente chama os métodos de criação de um objeto fábrica em vez de criar produtos diretamente com uma chamada de construtor 
 * (usando operador new). Como uma fábrica corresponde a uma única variante de produto, todos os seus produtos serão compatíveis.
 * O código cliente trabalha com fábricas e produtos somente através de suas interfaces abstratas. 
 * Ele permite que o mesmo código cliente funcione com produtos diferentes. Você apenas cria uma nova classe fábrica concreta e a passa para o código cliente.
 */


/**
 * Neste exemplo, botões e caixas de seleção atuarão como produtos. Eles têm duas variantes: macOS e Windows.
 * O Abstract Factory define uma interface para criar botões e caixas de seleção. Existem duas fábricas concretas, 
 * que retornam ambos os produtos em uma única variante.
 * O código cliente trabalha com fábricas e produtos usando suas interfaces abstratas. 
 * Ele faz com que o mesmo código cliente funcione com muitas variantes de produtos, dependendo do tipo de objeto fábrica.
 */



// A aplicação escolhe o tipo de fábrica dependendo do 
// configuração atual ou configurações de ambiente e cria-as 
// em tempo de execução (geralmente no estágio de inicialização).
public class Main {

    private static Application configureApplication() {
        Application app;
        GUIFactory factory;
        String osName = System.getProperty("os.name").toLowerCase();
        if (osName.contains("mac")) {
            factory = new MacOSFactory();
        } else {
            factory = new WindowsFactory();
        }
        app = new Application(factory);
        return app;
    }

    public static void main(String[] args) {
        Application app = configureApplication();
        app.paint();
    }
}
