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
