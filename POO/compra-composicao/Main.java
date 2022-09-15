//composição: relação todo/parte, o objeto pai é reponsável pela crição e destruição de suas partes
//usa-se quando uma classe não faz sentido sem a outra ex: produto e característica

public class Main{
    public static void main(String[] args) {
        Pessoa p1 = new Pessoa("joao", "233", "rua a", "caxias", "rs");
        Produto prod1 = new Produto(223, "abacaxi");
        Produto prod2 = new Produto(655, "mamao");

        p1.consultaEndereco();
        Compra c = new Compra(p1);
        c.comprar(p1, prod1);
        c.comprar(p1, prod2);
        c.verificarCompra();

        Pessoa p2 = new Pessoa("jonas", "233", "rua a", "alegrete", "rs");
        Compra c2 = new Compra(p2);
        p2.consultaEndereco();
        c2.comprar(p2, prod2);
        c2.verificarCompra();
    }
}
