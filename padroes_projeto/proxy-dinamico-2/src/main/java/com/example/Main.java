package com.example;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

public class Main {
    public static void main(String[] args) throws SQLException {
        DataSource d = null;
        PoolDB poolGenerico = new PoolDB(d);

        Connection conn = poolGenerico.acquire();
        conn.close();
    }
}
