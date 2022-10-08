package view;

import model.Cliente;
import model.Conta;

public class Main {

    public static void main(String[] args) {
        Cliente cliente1 = new Cliente();
        cliente1.setNome("joao");
        cliente1.setEndereco("rua a");

        Conta c = new Conta("ert4334");
        c.setSaldo(-23);
        c.setSaldo(2);
        c.setCliente(cliente1);

        Conta c1 = new Conta("rt4545");
        c1.setSaldo(500);
        c1.setCliente(cliente1);

        System.out.println("numero: "+c.getNumero()+" cliente: "+c.getCliente().getNome());
        System.out.println("numero: "+c1.getNumero());
    }
}
