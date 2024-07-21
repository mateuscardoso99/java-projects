package com.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SelecionaCommand implements ComandoSQL{
    private CallbackDAO callbackDAO;
    private long id;

    public SelecionaCommand(CallbackDAO callbackDAO, long id) {
        this.callbackDAO = callbackDAO;
        this.id = id;
    }

    @Override
    public void executa(Connection connection) throws SQLException {
        PreparedStatement ps = connection.prepareStatement("select * from tabela where id = ?");
        ps.setLong(1, id);
        ResultSet rs = ps.executeQuery();
        callbackDAO.callback(rs.next());
    }

    
}
