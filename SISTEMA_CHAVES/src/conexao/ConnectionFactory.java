
package conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConnectionFactory {
    private static final String DRIVER = "org.postgresql.Driver";
    private static final String URL = "jdbc:postgresql://localhost:5432/bancoChaves";
    private static final String USER = "postgres";
    private static final String SENHA = "1234";

    public static Connection getConnection(){
        try{
            Class.forName(DRIVER);
            return DriverManager.getConnection(URL, USER, SENHA);
        }catch(ClassNotFoundException | SQLException ex){
            throw new RuntimeException("Erro ao Conectar com o Banco de Dados");
        }
    }
    
    public static void closeConnection(Connection con){
        if(con != null){
            try{
                con.close();
            }catch(SQLException ex){
                System.out.println("Erro ao fechar a conexão"+ex);
            }
        }
    }
    
    public static void closeConnection(Connection con, PreparedStatement stmt){
        if(stmt != null){
            try{
                stmt.close();
            }catch(SQLException ex){
                System.out.println("Erro ao fechar a conexão"+ex);
            }
        }
        closeConnection(con);
    }
    
    
    public static void closeConnection(Connection con, PreparedStatement stmt, ResultSet rs){
        if(rs != null){
            try{
                rs.close();
            }catch(SQLException ex){
                System.out.println("Erro ao fechar a conexão"+rs);
            }
        }
        closeConnection(con, stmt);
    }
}
