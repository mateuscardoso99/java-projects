//associação: um objeto visualiza atributos ou adiciona os metodos de outro objeto
//ocorre quando um objeto usa outro, porém, sem que eles dependam um do outro
//usa-se quando as classes fazem sentido sozinhas tambem

public class Main{
    public static void main(String[] args) {
        Fabricante f1 = new Fabricante("teste", "rua c", "doc");
        Produto p1 = new Produto("uva", 450, f1);

        System.out.println("produto: "+p1.getNome());
        System.out.println("fabricante: "+p1.getFabricante().getNome());
    }
}
