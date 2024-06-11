public class Main {
    public static void main(String[] args) {
        InterfaceApp interfaceApp = new App();
        interfaceApp.displayMenus(new XmlData()); //uso normal do app

        Adaptador adaptador = new Adaptador();
        adaptador.displayMenus(new XmlData()); //usando a nova biblioteca, praticamente nada muda
    }
}
