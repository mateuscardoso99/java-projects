package model;

import java.util.ArrayList;
import java.util.List;

public class Pedido {
    private static int totalPedidos;
    private int identificador;
    private Cliente cliente;
    private Vendedor vendedor;
    private List<ItemPedido> itensPedido = new ArrayList<>();
    private double total;

    public Pedido(Cliente c, Vendedor v){
        Pedido.totalPedidos++;
        this.identificador = Pedido.totalPedidos;
        this.cliente = c;
        this.vendedor = v;
        this.total = 0;
    }

    public Cliente getCliente(){
        return cliente;
    }
    public void setCliente(Cliente c){
        cliente = c;
    }
    public Vendedor getVendedor(){
        return vendedor;
    }
    public void setVendedor(Vendedor v){
        vendedor = v;
    }
    public List<ItemPedido> getItensPedido(){
        return this.itensPedido;
    }
    public void addItemPedido(ItemPedido item){
        itensPedido.add(item);
        total += item.getTotal();
    }
    public double getTotal(){
        return total;
    }
    public void setTotal(double total){
        this.total = total;
    }

    public void imprimirPedido(){
        System.out.println("Id Pedido: "+identificador);
        System.out.println("Cliente: "+cliente.getNome());
        System.out.println("Vendedor: "+vendedor.getNome());

        System.out.println("\nITENS PEDIDO: ");
        itensPedido.stream().forEach(item -> {
            System.out.println("\nProduto: "+item.getProduto().getNome());
            System.out.println("Preço: R$ "+item.getProduto().getPreco());
            System.out.println("Quantidade: "+item.getQtd());
            System.out.printf("SubTotal: R$ %.2f\n",item.getTotal());
        });

        System.out.printf("\nTOTAL A PAGAR: R$ %.2f",total);

        System.out.println("\n\n\n");
    }
}
