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
