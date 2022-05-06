package model.dao;

import conexao.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import model.bean.Venda;

public class VendaDAO {
    public boolean create(Venda v){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stat = null;
        
        try{
            stat = con.prepareStatement("INSERT INTO venda (valortotal,data,idcliente,idvendedor) VALUES (?,?,?,?)");
            stat.setDouble(1, 0);
            stat.setString(2, v.getData());
            stat.setLong(3, v.getCliente().getId());
            stat.setLong(4, v.getVendedor().getId());
            
            stat.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "venda inserida com sucesso", "", JOptionPane.INFORMATION_MESSAGE);
            return true;
            
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "erro ao inserir" +e, "", JOptionPane.ERROR_MESSAGE);
            return false;
        }finally{
            ConnectionFactory.closeConnection(con, stat);
        }
    }
    
    
     public boolean update(Venda v){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stat = null;
        
        try{
            stat = con.prepareStatement("UPDATE venda SET valortotal = ? WHERE id = ?");
            stat.setDouble(1, v.getValorTotal());
            stat.setLong(2, v.getId());
            
            stat.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "venda finalizada com sucesso", "", JOptionPane.INFORMATION_MESSAGE);
            return true;
            
        }catch(SQLException w){
             JOptionPane.showMessageDialog(null, "erro ao ler" +w, "", JOptionPane.ERROR_MESSAGE);
             return false;
        }finally{
            ConnectionFactory.closeConnection(con, stat);
        }    
    }
     
    
    public int selectIdVenda(){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stat = null;
        ResultSet rs = null;
        
        int id = 0;
        
        try{
            stat = con.prepareStatement("SELECT MAX(id) as id FROM venda");
            rs = stat.executeQuery();
            
            while(rs.next()){
            id = rs.getInt("id");
            }
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "erro ao ler" +e, "", JOptionPane.INFORMATION_MESSAGE);
            e.printStackTrace();
        }finally{
            ConnectionFactory.closeConnection(con, stat, rs);
        }
        
        return id;       
    }
     
}
