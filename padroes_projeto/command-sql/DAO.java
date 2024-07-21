package com.example;

import java.sql.SQLException;

import javax.sql.DataSource;

public class DAO {
    private DataSource dataSource;
    private InvokerSQL invokerSQL = new InvokerSQL();

    public void insere(Object o, CallbackDAO callbackDAO){
        invokerSQL.adicionaComando(new InsereCommand());
    }
    public void atualiza(Object o, CallbackDAO callbackDAO){
        invokerSQL.adicionaComando(new AtualizaCommand());
    }
    public void remove(long id, CallbackDAO callbackDAO){
        invokerSQL.adicionaComando(new RemoveCommand(callbackDAO, id));
    }
    public void seleciona(long id, CallbackDAO callbackDAO){
        invokerSQL.adicionaComando(new SelecionaCommand(callbackDAO, id));
    }

    public void executaLote() throws SQLException{
        invokerSQL.execute(dataSource.getConnection());
        dataSource.getConnection().close();
        invokerSQL = new InvokerSQL(); //pra não executar dnv os comandos que já foram executados
    }
}
