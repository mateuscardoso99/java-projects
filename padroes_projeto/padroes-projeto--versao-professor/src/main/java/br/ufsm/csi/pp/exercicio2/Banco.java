package br.ufsm.csi.pp.exercicio2;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Banco implements BancoInterface {

    private Map<String, ContaBancaria> contas = new ConcurrentHashMap<>();

    private Serasa serasa;

    public Banco() {}

    private static BancoInterface INSTANCE;

        public static BancoInterface getInstance() {
        synchronized (Banco.class) {
            if (INSTANCE == null) {
                INSTANCE = new LogBancoDecorator(new Banco());
            }
        }
        return INSTANCE;
    }

    public Map<String, ContaBancaria> getContas() {
        return contas;
    }

    @Override
    public boolean excluiConta(String numero) {
        return contas.remove(numero) != null;
    }

    @Override
    public void saque(String numero, Double valor) throws MovimentacaoException {
        ContaBancaria contaBancaria = contas.get(numero);
        if (contaBancaria == null) {
            throw new MovimentacaoException("conta nao existente.");
        }
        contaBancaria.saque(valor);
    }

    @Override
    public void deposito(String numero, Double valor) {
        if (valor <= 0) {
            throw new IllegalArgumentException("valor nao permitido para deposito.");
        }
        ContaBancaria contaBancaria = contas.get(numero);
        if (contaBancaria == null) {
            throw new IllegalArgumentException("conta nao existente.");
        }
        contaBancaria.deposito(valor);
    }

    @Override
    public Double saldo(String numero) {
        ContaBancaria contaBancaria = contas.get(numero);
        if (contaBancaria == null) return null;
        return contaBancaria.getSaldo();
    }   

    @Override
    public String extrato(String numero) {
        ContaBancaria contaBancaria = contas.get(numero);
        if (contaBancaria == null) return null;
        return contaBancaria.extrato();
    }

    @Override
    public void transferencia(String contaOrigem, String contaDestino, Double valor) throws MovimentacaoException {
        saque(contaOrigem, valor);
        deposito(contaDestino, valor);
    }

    @Override
    public ContaBancaria criaConta(TipoConta tipo, Double saldoInicial, boolean especial, Double limite) {
        ContaBancaria conta = null;
        if (tipo == TipoConta.CC) {
            ContaCorrente cc = ContaCorrente.newInstance();
            cc.setEspecial(especial);
            cc.setLimite(limite);
            cc.setSaldo(saldoInicial);
            cc.setNumero(criaNumeroConta());
            conta = cc;
        } else if (tipo == TipoConta.POUPANCA) {
            Poupanca poupanca = Poupanca.newInstance();
            poupanca.setNumero(criaNumeroConta());
            poupanca.setSaldo(saldoInicial);
            conta = poupanca;
        } else if (tipo == TipoConta.RENDA_FIXA || tipo == TipoConta.RENDA_VARIAVEL) {
            FundosRenda fundosRenda = FundosRenda.newInstance();
            fundosRenda.setTipo(tipo == TipoConta.RENDA_FIXA ? FundosRenda.TipoFundo.RENDA_FIXA : FundosRenda.TipoFundo.RENDA_VARIAVEL);
            fundosRenda.setNumero(criaNumeroConta());
            fundosRenda.setSaldo(saldoInicial);
            conta = fundosRenda;
        }
        if (conta != null) {
            conta.adicionaObserver(serasa);
            contas.put(conta.getNumero(), conta);
        }
        return null;
    }

    private Long numConta = 1l;
    private String criaNumeroConta() {
        synchronized (this) {
            return String.valueOf(numConta++);
        }
    }

    public enum TipoConta {
        CC, POUPANCA, RENDA_FIXA, RENDA_VARIAVEL
    }

}
