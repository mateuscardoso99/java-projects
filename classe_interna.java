/**
 * Em Java também é possível aninhar classes (uma classe dentro de uma classe). 
 * O objetivo das classes aninhadas é agrupar as classes que pertencem umas às outras, 
 * o que torna seu código mais legível e fácil de manter.
 * Para acessar a classe interna, crie um objeto da classe externa e, em seguida, crie um objeto da classe interna:
 * 
 */

//esta classe é estática tambem
class OuterClass{
    int x = 10;

    class InnerClass {
        int y = 5;

        public int myInnerMethod() {
            return x; //classe interna pode acessar e alterar atributos da classe externa
        }
    }

    public static void main(String[] args) {
        OuterClass myOuter = new OuterClass(); //objeto classe externa
        OuterClass.InnerClass myInner = myOuter.new InnerClass(); //objeto classe interna
        System.out.println(myInner.y + myOuter.x);
        //myInner.x = 67; erro, x é uma propriedade da classe externa, não da interna
        System.out.println(myInner.myInnerMethod());
    }
}



public class Main {
    int x = 10;
    public class InnerClass3 {
        int y = 5;
        static int z = 1;
    }
    public static void main(String[] args) {
        //Uma instância de InnerClass3 pode existir apenas dentro de uma instância de Main e tem acesso direto aos métodos e campos de sua instância envolvente.
        
        //Para instanciar uma classe interna, primeiro deve instanciar a classe externa. Em seguida, crie o objeto interno dentro do objeto externo
        Main m = new Main();
        Main.InnerClass3 myInner = m.new InnerClass3();//craindo objeto da classe interna apartir da classe externa, objeto da classe interna não estatica depende da classe externa, ao contrário da classe interna estatica
        
        // InnerClass3 i = new InnerClass3();//erro, por ser classe não estatica, não pode criar objeto diretamente, objeto de classe interna está associado ao objeto de classe externa
        System.out.println(myInner.y);//5
        //System.out.println(i.y);//erro
        System.out.println("z "+InnerClass3.z);//z é um atributo static, então não precisa criar um objeto da classe pra acessá-lo
        System.out.println(myInner.z);
    }
}


class OuterClass2 {
    int x = 10;
  
    private class InnerClass2 {
      int y = 5;
    }
  
    public static void main(String[] args) { //funciona pois classe interna privada é acessada dentro da classe externa
        OuterClass2 myOuter = new OuterClass2();
        OuterClass2.InnerClass2 myInner = myOuter.new InnerClass2();
        System.out.println(myInner.y + myOuter.x);
    }
}

//erro classe InnerClass2 is not visible
// class Main {
//     public static void main(String[] args) {
//         OuterClass2 myOuter = new OuterClass2();
//         OuterClass2.InnerClass2 myInner = myOuter.new InnerClass2();
//         System.out.println(myInner.y + myOuter.x);
//         }
// }



//Classe Interna Estática
//assim como atributos e métodos static, uma classe static interna não tem acesso aos membros da classe externa que não sejam static.

//Uma classe aninhada estática interage com os membros da instância de sua classe externa (e outras classes) como qualquer outra classe de nível superior. 
//Na verdade, uma classe aninhada estática é comportamentalmente uma classe de nível superior que foi aninhada em outra classe de nível superior para 
//conveniência de empacotamento
public class Main {
    int x = 10;
    public static class InnerClass3 {
        int y = 5;
        static int z = 1;
        //int a = x; erro pois classe estatica por rodar em um contexto estatico, não pode acessar atributos não estaticos
    }
    public static void main(String[] args) {
        Main.InnerClass3 myInner = new Main.InnerClass3();//craindo objeto da classe estatica apartir da classe externa

        //Você instancia uma classe estática interna da mesma forma que uma classe de nível superior:
        InnerClass3 i = new InnerClass3();//pode criar objeto da classe static diretamente também, objeto de classe interna estática não está associado ao objeto de classe externa
        System.out.println(myInner.y);//5
        System.out.println(i.y);//5
        System.out.println(InnerClass3.z);//z é um atributo static, então não precisa criar um objeto da classe estatica pra acessá-lo
        System.out.println(x);//erro, classe interna estatica não acessa atributos não estaticos diretamente
        System.out.println(new Main().x);//solução é criar objeto da classe externa e acessar atributo por meio desse objeto
    }
}


//Classe interna não estática:
//Sem a existência de um objeto de classe externa, não pode haver um objeto de classe interna. Ou seja, o objeto de classe interna está sempre associado ao objeto de classe externa.
//Dentro da classe interna normal/regular, nao sao permitidos metodos ou variaveis estáticos.
//Como o método main() não pode ser declarado, a classe interna regular não pode ser chamada diretamente do prompt de comando.
//Os membros estáticos e não estáticos da classe externa podem ser acessados ​​diretamente.


//Classe interna estática
//Sem um objeto de classe externa ainda sim pode haver um objeto de classe interna estática. Ou seja, o objeto de classe interna estática não está associado ao objeto de classe externa.
//Dentro da classe interna estática, pode declarar metodos e variaveis estáticos.
//Como o método main() pode ser declarado, a classe aninhada estática pode ser chamada diretamente do prompt de comando.
//Somente membros estáticos da classe externa podem ser acessados diretamente.
