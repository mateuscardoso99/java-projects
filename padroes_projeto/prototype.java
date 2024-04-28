/*
O Prototype é um padrão de projeto criacional que permite copiar objetos existentes sem fazer seu código ficar dependente de suas classes.


PROBLEMA:
Digamos que você tenha um objeto, e você quer criar uma cópia exata dele. Como você o faria? 
Primeiro, você tem que criar um novo objeto da mesma classe. Então você terá que ir por todos os campos do objeto 
original e copiar seus valores para o novo objeto.

Legal! Mas tem uma pegadinha. Nem todos os objetos podem ser copiados dessa forma porque alguns campos de objeto podem ser 
privados e não serão visíveis fora do próprio objeto.

Há ainda mais um problema com a abordagem direta. Uma vez que você precisa saber a classe do objeto para criar uma cópia, 
seu código se torna dependente daquela classe. Se a dependência adicional não te assusta, tem ainda outra pegadinha. 
Algumas vezes você só sabe a interface que o objeto segue, mas não sua classe concreta, quando, por exemplo, um parâmetro em um método aceita quaisquer objetos que seguem uma interface.


SOLUÇÃO:
O padrão Prototype delega o processo de clonagem para o próprio objeto que está sendo clonado. 
O padrão declara um interface comum para todos os objetos que suportam clonagem. 
Essa interface permite que você clone um objeto sem acoplar seu código à classe daquele objeto. 
Geralmente, tal interface contém apenas um único método clonar.

A implementação do método clonar é muito parecida em todas as classes. 
O método cria um objeto da classe atual e carrega todos os valores de campo para do antigo objeto para o novo. 
Você pode até mesmo copiar campos privados porque a maioria das linguagens de programação permite objetos acessar 
campos privados de outros objetos que pertençam a mesma classe.

Um objeto que suporta clonagem é chamado de um protótipo. Quando seus objetos têm dúzias de campos e centenas de possíveis 
configurações, cloná-los pode servir como uma alternativa à subclasses.

Funciona assim: você cria um conjunto de objetos, configurados de diversas formas. 
Quando você precisa um objeto parecido com o que você configurou, você apenas clona um protótipo ao invés de 
construir um novo objeto a partir do nada.
*/

import java.util.ArrayList;
import java.util.List;

abstract class Shape{
    protected int X;
    protected int Y;
    protected String color;
    
    public Shape(){}

    public Shape(Shape shape){
        this();
        this.X = shape.X;
        this.Y = shape.Y;
        this.color = shape.color;
    }

    abstract Shape clonar();
}

class Retangulo extends Shape{
    protected int width;
    protected int height;

    public Retangulo(){}

    public Retangulo(Retangulo retangulo){
        super(retangulo);
        this.width = retangulo.width;
        this.height = retangulo.height;
    }

    protected Retangulo clonar(){
        return new Retangulo(this);
    }
}

class Circulo extends Shape{
    protected int raio;

    public Circulo(){}

    public Circulo(Circulo circulo){
        super(circulo);
        this.raio = circulo.raio;
    }

    protected Circulo clonar(){
        return new Circulo(this);
    }
}

public class prototype {

    public static void main(String[] args) throws Exception {
        List<Shape> shapes = new ArrayList<>();

        Circulo c = new Circulo();
        c.X = 10;
        c.Y = 10;
        c.color = "branco";
        c.raio = 20;
        shapes.add(c);

        Circulo outroCirculo = c.clonar();
        shapes.add(outroCirculo);
        // A variável `outroCirculo` contém uma cópia exata do
        // objeto `c`.

        Retangulo rectangle = new Retangulo();
        rectangle.X = 6;
        rectangle.Y = 8;
        rectangle.color = "preto";
        rectangle.width = 10;
        rectangle.height = 20;
        shapes.add(rectangle);

        List<Shape> shapesCopia = new ArrayList<>();

        //graças ao polimorfismo, quando nós
        // chamamos o método `clone` em um shape, o programa
        // checa sua classe real e executa o método de clonagem
        // apropriado definido naquela classe. É por isso que
        // obtemos clones apropriados ao invés de um conjunto de
        // objetos Shape simples.
        shapes.forEach(s -> shapesCopia.add(s.clonar()));

        // O vetor `shapesCopia` contém cópias exatas dos filhos
        // do vetor `shape`.
    }
    
}