/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.projeto.servlet.crud.connection;

import java.sql.DriverManager;
import java.sql.*;

/**
 *
 * @author mateus
 */
public class ConnectionFactory {
    private static final String URL = "jdbc:postgresql://localhost:5432/trabalho";
    private static final String USER = "postgres";
    private static final String PASSWORD = "nattyDB";
      
    public static Connection getConnection(){
        try{
            DriverManager.registerDriver(new org.postgresql.Driver());
            return DriverManager.getConnection(URL,USER,PASSWORD);
        }catch(SQLException e){
            throw new RuntimeException(e.getMessage());
        }
    }
    
    public static void closeConnection(Connection con) {
        if (con != null) {
            try {
                con.close();
            } catch (SQLException ex) {
                System.err.println("erro ao fechar a conexão" + ex);
            }
        }
    }
}
