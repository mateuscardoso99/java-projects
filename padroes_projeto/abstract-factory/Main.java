/*
Abstract Factory é um padrão de design criacional que permite produzir famílias de objetos relacionados sem especificar suas classes concretas.

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



/*
Use o Abstract Factory quando seu código precisar trabalhar com diversas famílias de produtos relacionados, mas você não quiser que ele dependa das classes concretas 
desses produtos — eles podem ser desconhecidos de antemão ou você simplesmente deseja permitir extensibilidade futura.

O Abstract Factory fornece uma interface para criação de objetos de cada classe da família de produtos. 
Contanto que seu código crie objetos por meio dessa interface, você não precisa se preocupar em criar a variante errada de um produto que não corresponda aos 
produtos já criados pelo seu aplicativo.

Considere implementar o Abstract Factory quando você tiver uma classe com um conjunto de Factory Methods que confundem sua responsabilidade principal.
*/









/*
Espera-se que os mesmos elementos de UI em um aplicativo multiplataforma se comportem de maneira semelhante, mas pareçam um pouco diferentes em diferentes 
sistemas operacionais. Além disso, é sua função garantir que os elementos da IU correspondam ao estilo do sistema operacional atual. Você não gostaria que seu 
programa renderizasse controles do macOS quando fosse executado no Windows.

A interface Abstract Factory declara um conjunto de métodos de criação que o código do cliente pode usar para produzir diferentes tipos de elementos de UI. 
As fábricas concretas correspondem a sistemas operacionais específicos e criam os elementos da UI que correspondem a esse sistema operacional específico.

Funciona assim: quando um aplicativo é iniciado, ele verifica o tipo do sistema operacional atual. O aplicativo usa essas informações para criar um objeto de 
fábrica a partir de uma classe que corresponda ao sistema operacional. O restante do código usa esta fábrica para criar elementos de UI. 
Isso evita que os elementos errados sejam criados.

Com essa abordagem, o código do cliente não depende de classes concretas de fábricas e elementos de UI, desde que funcione com esses objetos por meio de suas 
interfaces abstratas. Isso também permite que o código do cliente suporte outras fábricas ou elementos de UI que você possa adicionar no futuro.

Como resultado, você não precisa modificar o código do cliente sempre que adicionar uma nova variação de elementos de UI ao seu aplicativo. 
Você só precisa criar uma nova classe de fábrica que produza esses elementos e modificar levemente o código de inicialização do aplicativo para que ele 
selecione essa classe quando apropriado.
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
