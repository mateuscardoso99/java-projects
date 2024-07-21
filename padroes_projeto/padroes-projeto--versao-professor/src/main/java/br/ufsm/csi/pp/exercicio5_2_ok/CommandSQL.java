package br.ufsm.csi.pp.exercicio5_2_ok;

import lombok.SneakyThrows;

import java.sql.Connection;

public class CommandSQL {

    private String sql;
    private DaoConta.BuscaContaCallback callback;

    public CommandSQL(String sql) {
        this.sql = sql;
    }

    public CommandSQL(String sql, DaoConta.BuscaContaCallback callback) {
        this.sql = sql;
        this.callback = callback;
    }

    @SneakyThrows
    void execute(Connection connection) {
        connection.prepareStatement(sql).execute();
        if (callback != null) {
            //... new ContaBancaria...
            //callback.callback(conta);
        }
    }

}
