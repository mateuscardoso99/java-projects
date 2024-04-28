// O código do cliente funciona apenas com fábricas e produtos 
// através de tipos abstratos: GUIFactory, Button e Checkbox. isso 
// permite passar qualquer fábrica ou subclasse de produto para o cliente 
// sem quebrar o código
public class Application {
    private Button button;
    private Checkbox checkbox;

    public Application(GUIFactory factory) {
        button = factory.createButton();
        checkbox = factory.createCheckbox();
    }

    public void paint() {
        button.paint();
        checkbox.paint();
    }
}
