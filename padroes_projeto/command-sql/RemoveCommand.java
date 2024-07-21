package com.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RemoveCommand implements ComandoSQL{
    private CallbackDAO callbackDAO;
    private long id;

    public RemoveCommand(CallbackDAO callbackDAO, long id) {
        this.callbackDAO = callbackDAO;
        this.id = id;
    }

    @Override
    public void executa(Connection connection) throws SQLException {
        PreparedStatement ps = connection.prepareStatement("delete from tabela where id = ?");
        ps.setLong(1, id);
        int success = ps.executeUpdate();
        callbackDAO.callback(success);
    }
    
}
