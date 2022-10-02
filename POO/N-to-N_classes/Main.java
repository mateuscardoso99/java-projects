package view;

import model.Cliente;
import model.Conta;
import model.ContaCliente;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static void lerCliente(Cliente c){
        Scanner s = new Scanner(System.in);

        System.out.print("nome: ");
        c.setNome(s.next());

        System.out.print("cpf: ");
        c.setCpf(s.next());
    }

    //simulando relacionamento N pra N
    public static void main(String[] args) {
        Conta c = new Conta();
        c.setNumero("ert4334");
        c.setSaldo(-23);
        c.setSaldo(2);

        Conta c1 = new Conta();
        c1.setNumero("rt4545");
        c1.setSaldo(500);

        Cliente cliente = new Cliente();
        Main.lerCliente(cliente);

        Cliente cliente2 = new Cliente();
        Main.lerCliente(cliente2);

        List<ContaCliente> listContaClientes = new ArrayList<>();

        ContaCliente contaCliente = new ContaCliente();
        contaCliente.setCliente(cliente);
        contaCliente.setConta(c);

        ContaCliente contaCliente2 = new ContaCliente();
        contaCliente2.setCliente(cliente);
        contaCliente2.setConta(c1);

        ContaCliente contaCliente3 = new ContaCliente();
        contaCliente3.setCliente(cliente2);
        contaCliente3.setConta(c);

        listContaClientes.add(contaCliente);
        listContaClientes.add(contaCliente2);
        listContaClientes.add(contaCliente3);

        listContaClientes.stream().forEach(relation -> {
            System.out.println("nome: "+relation.getCliente().getNome());
            System.out.println("conta: "+relation.getConta().getNumero());
        });

        for(ContaCliente cc : listContaClientes){
            System.out.println("nome: "+cc.getCliente().getNome());
            System.out.println("numero: "+cc.getConta().getNumero());
        }

        for(int i=0;i<listContaClientes.size();i++){
            System.out.println("nome: "+listContaClientes.get(i).getCliente().getNome());
            System.out.println("numero: "+listContaClientes.get(i).getConta().getNumero());
        }
    }
}
