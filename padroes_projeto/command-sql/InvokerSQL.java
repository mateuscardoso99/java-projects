package com.example;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class InvokerSQL {
    private List<ComandoSQL> comandos = new ArrayList<>();

    public void adicionaComando(ComandoSQL c){
        comandos.add(c);
    }

    public void execute(Connection connection){
        try {
            for(ComandoSQL c : comandos){
                c.executa(connection);
            }
            connection.commit();
        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        }
    }
}
