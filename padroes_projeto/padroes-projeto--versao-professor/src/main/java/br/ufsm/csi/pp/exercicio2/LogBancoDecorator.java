package br.ufsm.csi.pp.exercicio2;

import lombok.Data;
import lombok.SneakyThrows;

import java.io.File;
import java.io.FileOutputStream;
import java.nio.charset.StandardCharsets;
import java.util.Date;

public class LogBancoDecorator implements BancoInterface {

    private BancoInterface objetoDecorado;
    private FileOutputStream arquivoLog;

    @SneakyThrows
    public LogBancoDecorator(BancoInterface objetoDecorado) {
        this.objetoDecorado = objetoDecorado;
        this.arquivoLog = new FileOutputStream("log.txt");
    }

    @SneakyThrows
    @Override
    public boolean excluiConta(String numero) {
        this.arquivoLog.write(("[" + new Date() + "]" + "excluiConta> " + numero + "\n").getBytes(StandardCharsets.UTF_8));
        return objetoDecorado.excluiConta(numero);
    }

    @SneakyThrows
    @Override
    public void saque(String numero, Double valor) throws MovimentacaoException {
        this.arquivoLog.write(("[" + new Date() + "]" + "saque> " + numero + ", " + valor + "\n").getBytes(StandardCharsets.UTF_8));
        objetoDecorado.saque(numero, valor);
    }

    @SneakyThrows
    @Override
    public void deposito(String numero, Double valor) {
        this.arquivoLog.write(("[" + new Date() + "]" + "deposito> " + numero + ", " + valor + "\n").getBytes(StandardCharsets.UTF_8));
        objetoDecorado.deposito(numero, valor);
    }

    @SneakyThrows
    @Override
    public Double saldo(String numero) {
        this.arquivoLog.write(("[" + new Date() + "]" + "saldo> " + numero + "\n").getBytes(StandardCharsets.UTF_8));
        return objetoDecorado.saldo(numero);
    }

    @SneakyThrows
    @Override
    public String extrato(String numero) {
        this.arquivoLog.write(("[" + new Date() + "]" + "extrato> " + numero + "\n").getBytes(StandardCharsets.UTF_8));
        return objetoDecorado.extrato(numero);
    }

    @SneakyThrows
    @Override
    public void transferencia(String contaOrigem, String contaDestino, Double valor) throws MovimentacaoException {
        this.arquivoLog.write(("[" + new Date() + "]" + "transferencia> " + contaOrigem + ", " + contaDestino +
                ", " + valor + "\n").getBytes(StandardCharsets.UTF_8));
        objetoDecorado.transferencia(contaOrigem, contaDestino, valor);
    }

    @SneakyThrows
    @Override
    public ContaBancaria criaConta(Banco.TipoConta tipo, Double saldoInicial, boolean especial, Double limite) {
        this.arquivoLog.write(("[" + new Date() + "]" + "criaConta> " + tipo + ", " + saldoInicial +
                ", " + especial + ", " + limite + "\n").getBytes(StandardCharsets.UTF_8));
        return objetoDecorado.criaConta(tipo, saldoInicial, especial, limite);
    }

}
