import java.util.List;
class Animal{
    
}

class Gato extends Animal{
    
}

/*
? extends Animal: 
- qualquer classe que seja filha de Animal, ou ela própria
- para ler precisa ser com o tipo Animal, pq não se sabe que tipos estão dentro da lista, única certeza é que serão Animais
- ex: Animal a = list.get(0);
- ideal para leitura de dados, não inserção


? super Animal: 
- qualquer classe que seja mãe de Animal, ou ela própria
- para ler precisa ser com o tipo Object, pq não se sabe que tipos estão dentro da lista, única certeza é que serão Object, pq tudo extende de Object
- para ler como Animal teria que fazer cast
- ideal para inserção de dados, não leitura

*/

public class Main{
    public void teste1(List<? extends Animal> lista){
        //lista.add(new Object());//erro. pq se a lista passada for um List<Cachorro> adicionar um Object quebraria tudo
        //lista.add(new Animal());//erro. pq se a lista passada for um List<Cachorro> adicionar um Animal quebraria tudo
        //lista.add(new Gato());//erro. pq se a lista passada for um List<Cachorro> adicionar um Gato quebraria tudo
    }
    public void teste2(List<? super Animal> lista){
        //lista.add(new Object());//erro pq Object não é garantido que seja um Animal
        lista.add(new Gato());//funciona pq é um Animal pois herda dessa classe
        lista.add(new Animal());//funciona tbm
    }
	public static void main(String[] args) {
		System.out.println("Hello World");
	}
}
