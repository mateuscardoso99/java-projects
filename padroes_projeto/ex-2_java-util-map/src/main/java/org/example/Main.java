package org.example;

import org.example.banco.Banco;
import org.example.banco.conta.Conta;
import org.example.banco.conta.TipoConta;

/*
– Altere o exercício 2 e utilize Map para representar o
conjunto de contas existente no banco associado a
cada identificador de conta.
– Desenvolva uma classe que crie 10.000 contas,
inserindo uma a uma no banco e depois percorra
estas contas;
– Busque cada uma destas contas com o método get(),
enquanto percorre novamente o mapa;
– Contabilize o tempo gasto para inserir, percorrer o
Map e buscar todos os objetos em cada tipo de
implementação diferente do Map.
 */
public class Main {
    public static void main(String[] args) {
        Banco banco = new Banco();

        long t1 = System.currentTimeMillis();
        for(long i=1; i<=10000; i++){
            Conta c = new Conta();
            c.setSaldo(1000d);
            c.setNumero(i);
            c.setTipoConta(TipoConta.CONTA_CORRENTE);
            c.setLimite(300d);

            /*Movimentacao m1 = new Movimentacao();
            m1.setDescricao("teste");
            m1.setValor(35d);
            m1.setTipoMovimentacao(TipoMovimentacao.CREDITO);
            Movimentacao m2 = new Movimentacao();
            m2.setDescricao("teste");
            m2.setValor(35d);

            m2.setTipoMovimentacao(TipoMovimentacao.CREDITO);

            c.setMovimentacoes(Arrays.asList(m1,m2));*/
            banco.criarConta(c);
            //banco.extrato(i);
        }
        banco.transferir(3l, 5l, 34555d);
        //System.currentTimeMillis() retorna é um número (no caso, um long) que representa a quantidade de milissegundos que se passou desde este instante.
        //System.out.println("TEMPO USANDO HASHMAP: "+(System.currentTimeMillis() - t1)); // + ou - 3 milisegundos
        //System.out.println("TEMPO USANDO TREEMAP: "+(System.currentTimeMillis() - t1)); // + ou - 6 milisegundos
        System.out.println("TEMPO USANDO LINKED_HASH_MAP: "+(System.currentTimeMillis() - t1)); // + ou - 4 milisegundos
        System.out.println("TOTAL DE CONTAS: "+banco.getContas().size());
    }
}