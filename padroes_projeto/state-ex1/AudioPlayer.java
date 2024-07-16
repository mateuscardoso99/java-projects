/*
O estado de um objeto pode ser definido como sua condição exata em
qualquer ponto do tempo, dependendo dos valores de suas
propriedades ou atributos. 

O padrão State é útil na concepção de uma estrutura eficiente onde
podem existir muitos estados diferentes e exibir comportamentos
diferentes dependendo do estado em que se encontra.
*/


/*
Implementar um AudioPlayer (State) que possui métodos que atendem a uma
interface com o usuário, tais como: 

• Play(), Next(), Previous(), Lock() 
• A função executada por cada uma das teclas da interface dependem do estado em que o AudioPlayer está, por exemplo: 
– Se ele estiver bloqueado, nenhuma tecla faz nada exceto a tecla lock que fará o desbloqueio. 
– Se estiver tocando uma música, a tecla play fará a função de pause. 

• A função realmente executada pelo player deverá ser impressa na saída padrão.
*/
public class AudioPlayer {

    private PlayerState estadoAtual = new EstadoParado();

    public void play() {
        this.estadoAtual = estadoAtual.play();
    }

    public void previous() {
        this.estadoAtual = estadoAtual.previous();
    }

    public void next() {
        this.estadoAtual = estadoAtual.next();
    }

    public void lock() {
        this.estadoAtual = estadoAtual.lock();
    }

}
