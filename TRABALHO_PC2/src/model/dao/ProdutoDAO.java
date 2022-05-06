package model.dao;

import conexao.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.bean.Produto;

public class ProdutoDAO {
    
    public boolean create(Produto p){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stat = null;
        
        try{
            stat = con.prepareStatement("INSERT INTO produto (descricao,preco) VALUES (?,?)");
            stat.setString(1, p.getDescricao());
            stat.setDouble(2, p.getPreco());
            
            stat.executeUpdate();
            
            return true;
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "erro ao inserir" +e, "", JOptionPane.ERROR_MESSAGE);
            return false;
        }finally{
            ConnectionFactory.closeConnection(con, stat);
        }
    }
    
    
    public ArrayList<Produto> read(){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stat = null;
        ResultSet rs = null;
        
        ArrayList<Produto> array = new ArrayList<>();
        
        try{
            stat = con.prepareStatement("SELECT * FROM produto");
            rs = stat.executeQuery();
            
            while(rs.next()){
                Produto p = new Produto();
                p.setId(rs.getInt("id"));
                p.setDescricao(rs.getString("descricao"));
                p.setPreco(rs.getDouble("preco"));
                
                array.add(p);
            }
            
        }catch(SQLException w){
            JOptionPane.showMessageDialog(null, "erro ao inserir" +w, "", JOptionPane.ERROR_MESSAGE);
        }finally{
            ConnectionFactory.closeConnection(con, stat, rs);
        }
        
        return array;
    }
    
    
    public boolean update(Produto p){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stat = null;
        
        try{
            stat = con.prepareStatement("UPDATE produto SET descricao = ?, preco = ? WHERE id = ?");
            stat.setString(1, p.getDescricao());
            stat.setDouble(2, p.getPreco());
            stat.setInt(3, p.getId());
            
            stat.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "atualizado com sucesso", "", JOptionPane.INFORMATION_MESSAGE);
            return true;
            
        }catch(SQLException w){
             JOptionPane.showMessageDialog(null, "erro ao ler" +w, "", JOptionPane.ERROR_MESSAGE);
             return false;
        }finally{
            ConnectionFactory.closeConnection(con, stat);
        }    
    }
    
    
    public void delete(Produto p){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stat = null;
        
        try{
            stat = con.prepareStatement("DELETE FROM produto WHERE id = ?");
            stat.setInt(1, p.getId());
            
            stat.executeUpdate();
            
        }catch(SQLException q){
            JOptionPane.showMessageDialog(null, "erro ao apagar", "", JOptionPane.ERROR_MESSAGE);
        }finally{
            ConnectionFactory.closeConnection(con, stat);
        }
    }
    
    public ArrayList<Produto> buscaPorDescricao(String descr){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stat = null;
        ResultSet rs = null;
        
        ArrayList<Produto> arrayDescricao = new ArrayList<>();
        
        try{
            stat = con.prepareStatement("SELECT * FROM produto WHERE descricao = ?");
            stat.setString(1, descr);
            rs = stat.executeQuery();
            
            while(rs.next()){
                Produto p = new Produto();
                p.setId(rs.getInt("id"));
                p.setDescricao(rs.getString("descricao"));
                p.setPreco(rs.getDouble("preco"));
                
                arrayDescricao.add(p);
            }
            
        }catch(SQLException w){
            JOptionPane.showMessageDialog(null, "erro ao buscar os dados" +w, "", JOptionPane.ERROR_MESSAGE);
        }finally{
            ConnectionFactory.closeConnection(con, stat, rs);
        }
        
        return arrayDescricao;
    }
    
}
