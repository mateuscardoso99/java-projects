/*
O Observer é um padrão de projeto comportamental que permite que um objeto notifique outros objetos sobre alterações em seu estado.
O padrão Observer fornece uma maneira de assinar e cancelar a assinatura desses eventos para qualquer objeto que implemente uma interface de assinante.

O padrão Observer é bastante comum no código Java, especialmente nos componentes da interface de usuário. 
Ele fornece uma maneira de reagir a eventos que acontecem em outros objetos sem acoplamento às suas classes.
Aqui estão alguns exemplos do padrão nas principais bibliotecas Java:
    - java.util.Observer/java.util.Observable (raramente usado no mundo real)
    - Todas as implementações de java.util.EventListener (praticamente em todos os componentes Swing)
    - javax.servlet.http.HttpSessionBindingListener
    - javax.servlet.http.HttpSessionAttributeListener
    - javax.faces.event.PhaseListener

O padrão pode ser reconhecido por métodos de assinatura, que armazenam objetos em uma lista e por chamadas para o método de atualização emitido para objetos nessa lista.

Neste exemplo, o padrão Observer estabelece colaboração indireta entre objetos de um editor de texto. Sempre que o objeto Editor é alterado, ele notifica seus assinantes. 
EmailNotificationListener e LogOpenListener reagem a essas notificações executando seus comportamentos principais.
As classes de assinante não são acopladas à classe do editor e podem ser reutilizadas em outras aplicações, se necessário. 
A classe Editor depende apenas da interface abstrata do assinante. Isso permite adicionar novos tipos de assinantes sem alterar o código do editor.
*/

public class Main {
    public static void main(String[] args) {
        Editor editor = new Editor();
        editor.events.subscribe("open", new LogOpenListener("/path/to/log/file.txt"));
        editor.events.subscribe("save", new EmailNotificationListener("admin@example.com"));

        try {
            editor.openFile("test.txt");
            editor.saveFile();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
