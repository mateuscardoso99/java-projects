import java.util.Deque;
import java.util.LinkedList;

public class Editor {

    private final TextArea textArea;
    private final Deque<Memento> stateHistory; //deque é uma fila

    public Editor() {
        textArea = new TextArea();
        stateHistory = new LinkedList<>();
    }

    /*
        cada vez que o usuário digita algo no input é salvo na fila um snapshot (histórico)
    */
    public void write(String text) {
        textArea.set(text);
        stateHistory.offer(textArea.takeSnapshot());
    }

    /*
    quando o usuário digitar CTRL-Z busca no histórico e traz o mais recente, nesse caso o do topo da fila
    depois remove da fila esse registro do histórico e seta no input o valor dele. fazendo o efeito do CTRL-Z
    */
    public void undo() {
        if (stateHistory.isEmpty()) {
            return;
        }
        stateHistory.pollLast();
        textArea.restore(stateHistory.peekLast());
    }

    public void printText() {
        System.out.println(textArea.getText());
    }

}
