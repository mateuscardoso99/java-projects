//As fábricas concretas produzem uma família de produtos que pertencem
//a uma única variante. A fábrica garante que o
// os produtos resultantes são compatíveis. Assinaturas do
// métodos concreto da fábrica retornam um produto abstrato, enquanto dentro
// o método de um produto concreto é instanciado
public class WindowsFactory implements GUIFactory{

    @Override
    public Button createButton() {
        return new WindowsButton();
    }

    @Override
    public Checkbox createCheckbox() {
        return new WindowsCheckbox();
    }
    
}
