/*
 * JDBC ou Java Database Connectivity é uma API Java para conectar e executar a consulta com o banco de dados
 */

//precisa baixar o driver do banco de dados e adicionar no classpath do projeto

import java.sql.*;

public class Conexao {
    private static final String DRIVER = "org.postgresql.Driver";
    private static final String URL = "jdbc:postgresql://localhost:5432/teste_2";
    private static final String USER = "postgres";
    private static final String SENHA = "nattyDB";

    public static Connection getConnection() {
        try {
            Class.forName(DRIVER);

            return DriverManager.getConnection(URL, USER, SENHA);
        } catch (ClassNotFoundException | SQLException ex) {
            throw new RuntimeException("falha ao conectar com o banco de dados", ex);
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

    public static void closeConnection(Connection con, PreparedStatement stat) {
        if (stat != null) {
            try {
                stat.close();
            } catch (SQLException ex) {
                System.err.println("erro ao fechar a conexão" + ex);
            }
        }

        closeConnection(con);
    }

    public static void closeConnection(Connection con, PreparedStatement stat, ResultSet rs) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException ex) {
                System.err.println("erro ao fechar a conexão" + ex);
            }
        }

        closeConnection(con, stat);
    }
}
