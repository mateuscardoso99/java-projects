package org.example;

/*
 * A interface Cloneable do Java é uma interface que marca, não tem nenhum método
 * A interface Cloneable não tem nenhum membro também, e é usada para indicar que a classe 
 * (que implementa a interface) permite uma clonagem bit a bit de um objeto, processo esse 
 * simplesmente chamado de "clonagem". Uma exceção conhecida como "CloneNotSupportedException" 
 * é mostrada se a função clone() é chamada numa classe em que não se implementou a interface Cloneable. 
 * No processo de clonagem o construtor do objeto não é chamado. Então, clonar pode ser definido como uma exata cópia do objeto original.
 * 
 * No processo de clonagem, o construtor não é chamado, ao invés disso, uma cópia exata do dito objeto é criada
 * 
 * Como vantagens da clonagem, tem-se que este mecanismo poupa tempo do desenvolvedor em caso de se precisar criar uma cópia de um objeto. Não seria necessário chamar um novo operador do objeto. Além disso, a clonagem poupa muita tarefas de desenvolvimento, pois um clone é uma cópia exata do objeto.
 
 * Como desvantagens da clonagem, tem-se que o tipo de retorno do método de clonagem é um Object. Assim, uma tipagem é requerida no objeto criado. 
 * Outra desvantagem, é que não é possível o acesso ao método de clonagem por um tipo abstrato. A maioria das interfaces e classes abstratas em Java não tem como 
 * especificar um método de clonagem público. Como resultado, o método de clonagem é somente usado se a verdadeira classe de um objeto é conhecida, o que é contra o 
 * princípio da abstração, de usar o tipo mais genérico possível. Por exemplo, se alguém tem uma referência List em Java, esta pessoa não pode invocar o método de 
 * clonagem nesta referência por que o List não especifica nenhum método clone() público. Implementações de fato de List como ArrayList e LinkedList todas geralmente têm 
 * seus próprios métodos de clonagem, mas isto é inconveniente e uma má abstração para carregar o tipo da classe com um objeto.
 
 * clonar é uma ação potencialmente perigosa, pois pode ter alguns efeitos colaterais não pretendidos, por exemplo, se o objeto que está sendo clonado contém uma referência a uma variável dizendo refObject, então no objeto clonado, refObject se referirá ao mesmo objeto que o objeto original estava se referindo. Se o clone faz uma mudança no conteúdo do seu refObject, então a mudança será refletida no objeto original também
 
 * Os efeitos colaterais causados pela clonagem são algumas vezes difíceis de identificar no começo. É fácil pensar que uma classe é segura para a clonagem quando na verdade não o é.
 * Em geral, NÃO É RECOMENTADO IMPLEMENTAR A INTERFACE CLONEABLE para qualquer classe sem ter um sério propósito.
 * 
 * Como alternativas para a clonagem, tem-se algumas alternativas, tais como copiar um construtor, um contrutor-cópia é um construtor que aceita outra 
 * instância da mesma classe como parâmetro, um método Factory, esses métodos não são sempre adequados quando o tipo concreto do objeto clonado não é conhecido primeiramente, 
 * e o uso a serialização e da desserialização é outra alternativa à clonagem.
 */
public class CloneClass implements Cloneable{
    int a;
    double b;

    // This method calls Object's clone().
    CloneClass getClone() {
        try {
            // call clone in Object.
            return (CloneClass) super.clone(); //cast pois chama o clone da classe object
        } catch (CloneNotSupportedException e) {
            System.out.println (" Cloning not allowed. " );
            return this;
        }
    }

    //outra forma fazendo override da classe mãe
    public Object clone() {
        try {
            // call clone in Object.
            return super.clone();
        } catch (CloneNotSupportedException e) {
            System.out.println("Cloning not allowed.");
            return this;
        }
    }

    public static void main(String[] args) {
        CloneClass x1 = new CloneClass();
        CloneClass x2;
        x1.a = 15;
        x1.b = 35.05;
        x2 = x1.getClone(); // clone x1
        System.out.println(" x1: " + x1.a + " " + x1.b);
        System.out.println(" x2: " + x2.a + " " + x2.b);

        CloneClass x3 = (CloneClass) x2.clone();
        System.out.println("x3: " + x3.a + " " + x3.b);
    }
}
