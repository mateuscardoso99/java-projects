import java.util.concurrent.Callable;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * O Factory Method é um padrão criacional de projeto que fornece uma interface para criar objetos em uma superclasse, 
 * mas permite que as subclasses alterem o tipo de objetos que serão criados.
 * 
 * 
 * 
 * PROBLEMA:
 * Imagine que você está criando uma aplicação de gerenciamento de logística. 
 * A primeira versão da sua aplicação pode lidar apenas com o transporte de caminhões, portanto a maior parte do seu código fica dentro da classe Caminhão.
 * Depois de um tempo, sua aplicação se torna bastante popular. 
 * Todos os dias você recebe dezenas de solicitações de empresas de transporte marítimo para incorporar a logística marítima na aplicação.
 * 
 * Boa notícia, certo? Mas e o código? Atualmente, a maior parte do seu código é acoplada à classe Caminhão. 
 * Adicionar Navio à aplicação exigiria alterações em toda a base de código. Além disso, se mais tarde você decidir adicionar outro tipo de transporte à 
 * aplicação, provavelmente precisará fazer todas essas alterações novamente.
 * Como resultado, você terá um código bastante sujo, repleto de condicionais que alteram o comportamento da aplicação, 
 * dependendo da classe de objetos de transporte.
 * 
 * 
 * 
 * SOLUÇÃO:
 * O padrão Factory Method sugere que você substitua chamadas diretas de construção de objetos (usando o operador new) 
 * por chamadas para um método fábrica especial. Não se preocupe: os objetos ainda são criados através do operador new, 
 * mas esse está sendo chamado de dentro do método fábrica. Objetos retornados por um método fábrica geralmente são chamados de produtos.
 * 
 * À primeira vista, essa mudança pode parecer sem sentido: apenas mudamos a chamada do construtor de uma parte do programa para outra. 
 * No entanto, considere o seguinte: agora você pode sobrescrever o método fábrica em uma subclasse e alterar a classe de produtos 
 * que estão sendo criados pelo método.
 * Porém, há uma pequena limitação: as subclasses só podem retornar tipos diferentes de produtos se esses produtos tiverem uma 
 * classe ou interface base em comum. Além disso, o método fábrica na classe base deve ter seu tipo de retorno declarado como essa interface.
 * 
 * Por exemplo, ambas as classes Caminhão e Navio devem implementar a interface Transporte, que declara um método chamado entregar. 
 * Cada classe implementa esse método de maneira diferente: caminhões entregam carga por terra, navios entregam carga por mar. 
 * O método fábrica na classe LogísticaViária retorna objetos de caminhão, enquanto o método fábrica na classe LogísticaMarítima retorna navios.
 * 
 * O código que usa o método fábrica (geralmente chamado de código cliente) não vê diferença entre os produtos reais retornados por várias subclasses. 
 * O cliente trata todos os produtos como um Transporte abstrato. O cliente sabe que todos os objetos de transporte devem ter o método entregar, 
 * mas como exatamente ele funciona não é importante para o cliente.
 */




//Use o Factory Method quando não souber de antemão os tipos e dependências exatas dos objetos com os quais seu código deve funcionar.
//O Factory Method separa o código de construção do produto do código que realmente usa o produto. Portanto, é mais fácil estender o código de construção do produto independentemente do restante do código.
//Por exemplo, para adicionar um novo tipo de produto à aplicação, só será necessário criar uma nova subclasse criadora e substituir o método fábrica nela.





// A interface do produto declara as operações que todos os
// produtos concretos devem implementar.
interface Button{
    public void render();
    public void onClick();
}

// Produtos concretos fornecem várias implementações da interface do produto.
class WindowsButton implements Button{
    @Override
    public void render(){// Renderiza um botão no estilo Windows.
        System.out.println("botão windows renderizado");
    }
    
    @Override
    public void onClick(){// Vincula um evento de clique do SO nativo.
        System.out.println("botão windows clicado");
    }
}

class HTMLButton implements Button{
    @Override
    public void render(){// Renderiza um botão no estilo HTML.
        System.out.println("botão HTML renderizado");
    }
    
    @Override
    public void onClick(){// Vincula um evento de clique do SO nativo.
        System.out.println("botão HTML clicado");
    }
}


// A classe criadora declara o método fábrica que deve retornar
// um objeto de uma classe produto. As subclasses da criadora
// geralmente fornecem a implementação desse método.
abstract class Dialog{
    // A criadora também pode fornecer alguma implementação
    // padrão do Factory Method.
    abstract Button createButton();

    // Observe que, apesar do seu nome, a principal
    // responsabilidade da criadora não é criar produtos. Ela
    // geralmente contém alguma lógica de negócio central que
    // depende dos objetos produto retornados pelo método
    // fábrica. As subclasses pode mudar indiretamente essa
    // lógica de negócio ao sobrescreverem o método fábrica e
    // retornarem um tipo diferente de produto dele.
    void render(){
        // Chame o método fábrica para criar um objeto produto.
        Button okButton = createButton();
        // Agora use o produto.
        okButton.render();
        okButton.onClick();
    }
}


// Criadores concretos sobrescrevem o método fábrica para mudar
// o tipo de produto resultante.
class WindowsDialog extends Dialog{
    Button createButton(){
        return new WindowsButton();
    }
}

class WebDialog extends Dialog{
    Button createButton(){
        return new HTMLButton();
    }
}


/*
 * A classe base diálogo usa diferentes elementos da UI do usuário para renderizar sua janela. Em diferentes sistemas operacionais, 
 * esses elementos podem parecer um pouco diferentes, mas ainda devem se comportar de forma consistente. Um botão no Windows ainda é um botão no Linux.
 * Quando o método fábrica entra em ação, você não precisa reescrever a lógica da caixa de diálogo para cada sistema operacional. 
 * Se declararmos um método fábrica que produz botões dentro da classe base da caixa de diálogo, mais tarde podemos criar uma subclasse de caixa de 
 * diálogo que retorna botões no estilo Windows do método fábrica. A subclasse herda a maior parte do código da caixa de diálogo da classe base, mas, 
 * graças ao método fábrica, pode renderizar botões estilo Windows na tela.
 * Para que esse padrão funcione, a classe base da caixa de diálogo deve funcionar com botões abstratos: uma classe base ou uma interface que 
 * todos os botões concretos seguem. Dessa forma, o código da caixa de diálogo permanece funcional, independentemente do tipo de botão com o qual ela trabalha.
 * Obviamente, você também pode aplicar essa abordagem a outros elementos da UI. No entanto, com cada novo método fábrica adicionado à caixa de diálogo, 
 * você se aproxima do padrão Abstract Factory.
 */
public class factoryMethod {

    public static void main(String[] args) throws Exception{
        Dialog dialog;

        if (System.getProperty("os.name").startsWith("Windows"))
            dialog = new WindowsDialog();
        else if (System.getProperty("os.name").startsWith("Web"))
            dialog = new WebDialog();
        else
            throw new Exception("Error! Unknown operating system.");

        dialog.render();
    }
}