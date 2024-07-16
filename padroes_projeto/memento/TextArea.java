public class TextArea {
    private String text;

    public void set(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    //salva no histórico os valores digitados no input
    public Memento takeSnapshot() {
        return new Memento(this.text);
    }

    //quando der CTRL-Z então seta no input o valor do objeto memento mais recente dentro do histórico (que está no topo da fila)
    public void restore(Memento memento) {
        this.text = memento != null ? memento.getSavedText() : null;
    }

    /*
    o memento salva os dados que são importantes de se armazenar no histórico, nesse exemplo é o valor digitado no input
    */
    public static class Memento {
        private final String text;

        private Memento(String textToSave) {
            text = textToSave;
        }

        private String getSavedText() {
            return text;
        }
    }

}
