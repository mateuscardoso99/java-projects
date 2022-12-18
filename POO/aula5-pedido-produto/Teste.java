package view;

import model.*;

public class Teste {
    public static void main(String[] args) {
        Produto p1 = new Produto();
        p1.setNome("banana");
        p1.setPreco(1.99);

        Produto p2 = new Produto();
        p2.setNome("arroz");
        p2.setPreco(23.77);

        Produto p3 = new Produto();
        p3.setNome("uva");
        p3.setPreco(3.66);

        Produto p4 = new Produto();
        p4.setNome("feijao");
        p4.setPreco(4.55);

        Produto p5 = new Produto();
        p5.setNome("leite");
        p5.setPreco(6.45);

        Cliente cliente1 = new Cliente();
        cliente1.setNome("joao");
        cliente1.setCpf("234.234.111-77");

        Cliente cliente2 = new Cliente();
        cliente2.setNome("carlos");
        cliente2.setCpf("565.323.123-56");

        Cliente cliente3 = new Cliente();
        cliente3.setNome("cleber");
        cliente3.setCpf("434.222.422-54");

        Vendedor v1 = new Vendedor();
        v1.setNome("jonas");
        v1.setMatricula("34346536");

        Vendedor v2 = new Vendedor();
        v2.setNome("samanta");
        v2.setMatricula("6470044");

        ItemPedido itemPedido1 = new ItemPedido(p1,3);
        ItemPedido itemPedido2 = new ItemPedido(p2,4);
        ItemPedido itemPedido3 = new ItemPedido(p1,1);
        ItemPedido itemPedido4 = new ItemPedido(p5,7);
        ItemPedido itemPedido5 = new ItemPedido(p3, 54);
        ItemPedido itemPedido6 = new ItemPedido(p4, 4);
        ItemPedido itemPedido7 = new ItemPedido(p3, 3);

        Pedido pedido1 = new Pedido(cliente1, v1);
        pedido1.addItemPedido(itemPedido1);
        pedido1.imprimirPedido();

        Pedido pedido2 = new Pedido(cliente2, v2);
        pedido2.addItemPedido(itemPedido2);
        pedido2.addItemPedido(itemPedido3);
        pedido2.imprimirPedido();

        Pedido pedido3 = new Pedido(cliente3, v1);
        pedido3.addItemPedido(itemPedido4);
        pedido3.addItemPedido(itemPedido5);
        pedido3.addItemPedido(itemPedido1);
        pedido3.imprimirPedido();

        Pedido pedido4 = new Pedido(cliente3, v2);
        pedido4.addItemPedido(itemPedido7);
        pedido4.addItemPedido(itemPedido6);
        pedido4.addItemPedido(itemPedido3);
        pedido4.imprimirPedido();

        Pedido pedido5 = new Pedido(cliente1, v1);
        pedido5.addItemPedido(itemPedido3);
        pedido5.imprimirPedido();
    }
}
