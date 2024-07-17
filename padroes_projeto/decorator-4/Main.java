package com.example;

//O padrão Decorator é utilizado quando precisa-se anexar responsabilidades dinamicamente sem precisar de uma grande hierarquia de subclasses.

//Os decoradores(DecoradorBarraVertical.class, DecoradorBarraHorizontal.class) têm o mesmo supertipo (Janela.class) que os objetos que eles decoram (JanelaSimples.class);
//Uma vez que o decorador tem o mesmo supertipo que o objeto decorado, podemos passar um objeto decorado no lugar do objeto original (englobado);
//O decorador adiciona seu próprio comportamento antes e/ou depois de delegar o objeto que ele decora o resto do trabalho;

//As classes Decorator(JanelaDecorator.class, DecoradorBarraVertical.class, DecoradorBarraHorizontal.class) implementam a mesma interface abstrata (nesse exemplo é a classe abstrata Janela) que o componente que decorarão (Janela.class).

/**
 * Nesse exemplo criou-se uma janela simples (JanelaSimples.class) onde queremos adicionar mais coisas como barras de rolagem, caixas de texto, labels, etc. 
 * Assim, criou-se também a classe JanelaDecorador que será estendida pelos nossos decoradores que irão inserir propriedades na nossa janela.
 * 
 * No código temos um decorador que anexa uma barra vertical (DecoradorBarraVertical.class) ao nosso componente principal (JanelaSimples.class). 
 * Portanto, anexamos responsabilidades ao nosso componente base (JanelaSimples.class). Se quiséssemos criar uma barra horizontal, menus, botões, faríamos outros decoradores para anexar mais responsabilidades.
 * 
 * Assim tem-se um decorator anexando outras responsabilidades e formando uma cadeia de objetos com seus comportamentos e métodos específicos.
 * 
 * O padrão Decorator usa a herança apenas para ter uma correspondência de tipo e não para obter o comportamento. Assim, quando compõe-se um decorador com um componente, adiciona-se um novo comportamento, 
 * nota-se que estamos adquirindo um novo comportamento e não herdando-o de alguma superclasse. Isso nos dá muito mais flexibilidade para compor mais objetos sem alterar uma linha de código, tudo em tempo de execução e não em tempo de compilação como ocorre com a herança.
 */
public class Main {
    public static void main(String[] args) {
        Janela janelaDecorada = new DecoradorBarraVertical(new JanelaSimples());
	janelaDecorada.draw();

        Janela janelaDecorada2 = new DecoradorBarraHorizontal(new DecoradorBarraVertical(new JanelaSimples()));
        janelaDecorada2.draw();
    }
}
