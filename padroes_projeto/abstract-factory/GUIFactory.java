// A interface abstrata de fábrica declara um conjunto de métodos que
// retorna diferentes produtos abstratos. Esses produtos são chamados
// uma família e estão relacionados por um tema ou conceito de alto nível.
// Produtos de uma família geralmente conseguem colaborar entre
// eles mesmos. Uma família de produtos pode ter diversas variantes,
// mas os produtos de uma variante são incompatíveis com o
// produtos de outra variante.
public interface GUIFactory {
    Button createButton();
    Checkbox createCheckbox();
}
