/*
O Command é um padrão de projeto comportamental que converte solicitações ou operações simples em objetos.

A conversão permite a execução adiada ou remota de comandos, armazenamento do histórico de comandos, etc.

O padrão Command é bastante comum no código Java. 
Na maioria das vezes, é usado como uma alternativa para retornos de chamada para parametrizar elementos da interface do usuário com ações. 
Também é usado para tarefas de enfileiramento, rastreamento de histórico de operações etc.

Aqui estão alguns exemplos do padrão Command nas principais bibliotecas Java:
    - Todas as implementações de java.lang.Runnable
    - Todas as implementações de javax.swing.Action

Identificação: O padrão Command é reconhecível por métodos comportamentais em um tipo abstrato/interface (remetente) que chama um método em uma implementação de um tipo 
abstrato/interface diferente (destinatário) que foi encapsulado pela implementação do comando durante a sua criação. As classes do Command geralmente são limitadas a ações específicas.

Comandos do editor de texto e desfazer
O editor de texto neste exemplo cria novos objetos comando sempre que um usuário interage com ele. Após executar suas ações, um comando é enviado para a pilha do histórico.

Agora, para executar a operação desfazer, o aplicativo obtém o último comando executado do histórico e executa uma ação inversa ou restaura o estado passado do editor, salvo por esse comando.
*/

public class Main {
    public static void main(String[] args) {
        Editor editor = new Editor();
        editor.init();
    }
}
