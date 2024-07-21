package com.example;

import java.sql.Connection;
import java.sql.SQLException;

public interface ComandoSQL {
    void executa(Connection connection) throws SQLException;
}
