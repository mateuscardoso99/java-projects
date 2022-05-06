package model.dao;

import conexao.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import model.bean.Comissao;

public class ComissaoDAO {
    public boolean create(Comissao com){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stat = null;
        
        try{
            stat = con.prepareStatement("INSERT INTO comissao (data,valor,idvendedor) VALUES (?,?,?)");
            stat.setString(1, com.getData());
            stat.setDouble(2, com.getValor());
            stat.setLong(3, com.getVendedor().getId());
            
            stat.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "comissão inserida com sucesso", "", JOptionPane.INFORMATION_MESSAGE);
            return true;
            
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "erro ao inserir comissão" +e, "", JOptionPane.ERROR_MESSAGE);
            return false;
        }finally{
            ConnectionFactory.closeConnection(con, stat);
        }
    }
}
