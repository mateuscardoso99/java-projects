/**
 * Em Java também é possível aninhar classes (uma classe dentro de uma classe). 
 * O objetivo das classes aninhadas é agrupar as classes que pertencem umas às outras, 
 * o que torna seu código mais legível e fácil de manter.
 * Para acessar a classe interna, crie um objeto da classe externa e, em seguida, crie um objeto da classe interna:
 * 
 */

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
//assim como atributos e métodos static, uma classe static interna não tem acesso aos membros da classe externa.
class OuterClass3 {
    int x = 10;
    
    static class InnerClass3 {
        int y = 5;
    }
}
  
class Main {
    public static void main(String[] args) {
        OuterClass3.InnerClass3 myInner = new OuterClass3.InnerClass3();
        System.out.println(myInner.y);
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