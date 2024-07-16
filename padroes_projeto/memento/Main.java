/*

O estado de um objeto pode ser definido como os valores de suas
propriedades ou atributos em qualquer ponto do tempo. 
– O Padrão Memento é útil para projetar um mecanismo para capturar e
armazenar o estado de um objeto para que, posteriormente, quando
necessário, o objeto pode ser colocado de volta a este estado (anterior)

o padrão memento sugere também delegar a criação desses objetos que guardam os estados ao proprietário desse estado

*/

public class MainApp {
    public static void main(String[] args) {

        Editor editor = new Editor();
        editor.write("Like and");
        editor.printText();
        editor.write("Like and Subscribe");
        editor.printText();
        editor.write("Like and Subscribe to Geekific!");
        editor.printText();
        editor.undo(); //ctrl-z
        editor.printText();
        editor.undo(); //ctrl-z
        editor.printText();
        editor.undo(); //ctrl-z
        editor.printText();

    }

}
