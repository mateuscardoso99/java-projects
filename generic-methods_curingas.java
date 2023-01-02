/*

Métodos genéricos e classes genéricas (e interfaces)
permitem especificar, com uma única declaração de
método, um conjunto de métodos relacionados ou, com
uma única declaração de classe, um conjunto de tipos
relacionados, respectivamente.

*/

import java.util.List;
import java.util.ArrayList;

class Teste
{
    public static void print(Integer[] nums){
        for(Integer i:nums){
            System.out.println(i);
        }
    }
    
    public static void print(Double[] nums){
        for(Double i:nums){
            System.out.println(i);
        }
    }
    
    public static void print(Character[] nums){
        for(Character i:nums){
            System.out.println(i);
        }
    }
    
    public static <T> void generic(T[] nums){
        for(T t:nums){
            System.out.println(t);
        }
    }
    
	public static void main(String[] args) {
		Integer[] i = {5,4,2,8};
		Double[] d = {5.6,3.00,23.78};
		Character[] c = {'r','u','a'};
		print(i);
		print(d);
		print(c);
		generic(i);
		generic(d);
		generic(c);
	}
	
	/*
	Se as operações realizadas por vários métodos
    sobrecarregados forem idênticas para cada tipo de
    argumento, os métodos sobrecarregados podem ser
    codificados mais compacta e convenientemente com um
    método genérico.
     Você pode escrever uma única declaração de método
    genérico que pode ser chamada com argumentos de
    tipos diferentes.
     Com base nos tipos dos argumentos passados para o
    método genérico, o compilador trata cada chamada
    de método apropriadamente.
	*/
}






/*

Curingas:


Caracteres curinga de limite superior: Esses curingas podem ser usados quando você deseja relaxar as restrições de uma variável. 
Por exemplo, digamos que você queira escrever um método que funcione em List <integer>, List <double> e List <number>, 
você pode fazer isso usando um curinga de limite superior.
Para declarar um curinga de limite superior, use o caractere curinga ('?'), Seguido pela palavra-chave extends, seguido por seu limite superior.
public static void add (List <? extends Number> list)  //qualquer classe que seja filha de Number



Curingas de limite inferior: é expresso usando o caractere curinga ('?'), Seguido pela palavra-chave super, seguida por seu limite inferior: <? super A>.
Sintaxe: Collectiontype <? super A>  //qualquer clase que seja mãe de A
por exemplo se passar Integer em A os argumentos podem ser Inteiro ou superclasse de Inteiro (que é Number)



Curinga ilimitado: este tipo de curinga é especificado usando o caractere curinga (?), Por exemplo, Lista. Isso é chamado de lista de tipo desconhecido. E
les são úteis nos seguintes casos
Ao escrever um método que pode ser empregado usando a funcionalidade fornecida na classe Object.
Quando o código está usando métodos na classe genérica que não dependem do parâmetro de tipo

ex:
List<?> curinga = null;
List<String> string = Arrays.asList("Andrei", "skqo");
List<Integer> inteiros = Arrays.asList(1, 2);

curinga = string; // SEM PROBLEMAS
curinga = inteiros; // SEM PROBLEMAS
    
    
////////////////////


Suponha que se queira implementar um método genérico
sum que some os números de uma coleção
(ArrayList).
Qualquer valor int inserido seria auto-empacotado
como um objeto um objeto Integer e qualquer valor
double seria convertido por autoboxing em um
objeto Double.
O método deverá ser capaz somar todos os valores do
ArrayList independentemente dos seus tipos.
Assim, será declarado o arrayList com o argumento
do tipo <Number>.
*/


public class Main
{
    //recebe como parametro qualquer ArrayList que seja de uma classe filha de Number
    public static double sum(ArrayList<? extends Number> array){
        double total = 0;
        for(Number n : array){
            total+=n.doubleValue();
        }
        return total;
    }
    
	public static void main(String[] args) {
		ArrayList<Integer> i = new ArrayList<>();
		i.add(4);
		i.add(5);
		i.add(2);
		
		ArrayList<Double> d = new ArrayList<>();
		d.add(9.90);
		d.add(8.5);
		d.add(2.3);
		
		System.out.println(sum(i));
		System.out.println(sum(d));
	}
	/*
	Como o curinga (?) no cabeçalho do método não
    especifica um nome de parâmetro de tipo, você não pode
    utilizá-lo como um nome de tipo por todo o corpo do
    método (isto é, não pode substituir Number por ? na
    linha 127).
    Você pode, porém, declarar o método sum dessa maneira:
    public static<T extends Number> doublesum (ArrayList< T > list)
    Isso permite ao método receber uma ArrayList que
    contém elementos de qualquer subclasse Number
	*/
	
}

