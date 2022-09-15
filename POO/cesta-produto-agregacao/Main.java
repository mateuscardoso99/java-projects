//agregação: um objeto precisa de outro pra completar sua ação(todo/parte).
//um objeto agrega outro objeto, ou seja, torna um objeto externo parte de si mesmo pela
//utilização de um de seus metodos, usa-se quando uma classe não tem utilidade sozinha, ou seja,
//precisa de outra classe pra poder fazer sentido/completar sua ação

public class Main{
    public static void main(String[] args) {
        Produto p1 = new Produto("pera", 2.00);
        Produto p2 = new Produto("abacate", 1.78);
        Produto p3 = new Produto("arroz", 14.99);
        Produto p4 = new Produto("feijão", 4.00);

        Cesta c1 = new Cesta();
        c1.incluirItem(p1);
        c1.incluirItem(p2);
        c1.exibeCesta();
        System.out.printf("total: R$ %.2f\n",c1.fechaCompra());

        Cesta c2 = new Cesta();
        c2.incluirItem(p3);
        c2.incluirItem(p4);
        c2.exibeCesta();
        System.out.printf("total: R$ %.2f\n",c2.fechaCompra());
        //semelhante ao printf do c
    }
}
