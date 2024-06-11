package org.example;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Date;

public class LogBancoDecorator implements BancoInterface{
    private BancoInterface objetoDecorado; //referenciar sempre pela interface, pois se usar outro cliente diferente de Banco.class vai funcionar também
    private FileOutputStream arquivoLog;

    public LogBancoDecorator(BancoInterface objetoDecorado) { //nesse Exemplo LogBancoDecorator vai receber um objeto de Banco, mas o certo é referencia pela interface, pois daí qualquer classe que implementar BancoInterface pode usar LogBancoDecorator
        this.objetoDecorado = objetoDecorado;

        try {
            this.arquivoLog = new FileOutputStream("log.txt");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean excluiConta(String numero) {
        try {
            this.arquivoLog.write(("[" + new Date() + "]" + "excluiConta> " + numero + "\n").getBytes(StandardCharsets.UTF_8));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return objetoDecorado.excluiConta(numero);
    }

    @Override
    public void saque(String numero, Double valor){
        try {
            this.arquivoLog.write(("[" + new Date() + "]" + "saque> " + numero + ", " + valor + "\n").getBytes(StandardCharsets.UTF_8));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        objetoDecorado.saque(numero, valor);
    }

    @Override
    public void deposito(String numero, Double valor) {
        try {
            this.arquivoLog.write(("[" + new Date() + "]" + "deposito> " + numero + ", " + valor + "\n").getBytes(StandardCharsets.UTF_8));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        objetoDecorado.deposito(numero, valor);
    }

    @Override
    public Double saldo(String numero) {
        try {
            this.arquivoLog.write(("[" + new Date() + "]" + "saldo> " + numero + "\n").getBytes(StandardCharsets.UTF_8));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return objetoDecorado.saldo(numero);
    }

    @Override
    public String extrato(String numero) {
        try {
            this.arquivoLog.write(("[" + new Date() + "]" + "extrato> " + numero + "\n").getBytes(StandardCharsets.UTF_8));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return objetoDecorado.extrato(numero);
    }

    @Override
    public void transferencia(String contaOrigem, String contaDestino, Double valor) {
        try {
            this.arquivoLog.write(("[" + new Date() + "]" + "transferencia> " + contaOrigem + ", " + contaDestino +
                    ", " + valor + "\n").getBytes(StandardCharsets.UTF_8));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        objetoDecorado.transferencia(contaOrigem, contaDestino, valor);
    }

    @Override
    public ContaBancaria criaConta(Banco.TipoConta tipo, Double saldoInicial, boolean especial, Double limite) {
        try {
            this.arquivoLog.write(("[" + new Date() + "]" + "criaConta> " + tipo + ", " + saldoInicial +
                    ", " + especial + ", " + limite + "\n").getBytes(StandardCharsets.UTF_8));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return objetoDecorado.criaConta(tipo, saldoInicial, especial, limite);
    }
}
