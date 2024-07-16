/*
O estado de um objeto pode ser definido como sua condição exata em
qualquer ponto do tempo, dependendo dos valores de suas
propriedades ou atributos. 

O padrão State é útil na concepção de uma estrutura eficiente onde
podem existir muitos estados diferentes e exibir comportamentos
diferentes dependendo do estado em que se encontra.
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
