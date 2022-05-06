package model.dao;

import conexao.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.bean.ItensVenda;
import model.bean.Produto;
import org.postgresql.util.PSQLException;

public class ItensVendaDAO {
    public boolean create(int id, Produto p, ItensVenda iv) throws SQLException{
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stat = null;
        
        try{
            stat = con.prepareStatement("INSERT INTO itensvenda (idvenda,idproduto,quantidade,totalitem) VALUES (?,?,?,?)");
            stat.setLong(1, id);
            stat.setLong(2, p.getId());
            stat.setInt(3, iv.getQuantidade());
            stat.setDouble(4, iv.getTotalitem());
            
            stat.executeUpdate();

            return true;
            
        }catch(PSQLException e){
            JOptionPane.showMessageDialog(null, "você já inseriu este produto", "", JOptionPane.ERROR_MESSAGE);
            return false;
        }finally{
            ConnectionFactory.closeConnection(con, stat);
        }
    }
    
    
    public ArrayList<ItensVenda> read(int idvenda){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stat = null;
        ResultSet rs = null;
        
        ArrayList<ItensVenda> array = new ArrayList<>();
        
        try{
            stat = con.prepareStatement("select produto.id, produto.descricao, itensvenda.quantidade, produto.preco from produto inner join \n" +
"itensvenda on(produto.id=itensvenda.idproduto) inner join venda \n" +
"on(venda.id=itensvenda.idvenda) where itensvenda.idvenda = ?");
            stat.setInt(1, idvenda);
            rs = stat.executeQuery();
            
            while(rs.next()){
                ItensVenda iv = new ItensVenda();
                iv.setQuantidade(rs.getInt("quantidade"));
                
                Produto prod = new Produto();
                prod.setId(rs.getInt("id"));
                prod.setDescricao(rs.getString("descricao"));
                prod.setPreco(rs.getDouble("preco"));
                
                iv.setIdproduto(prod);
                array.add(iv);
            }
            
        }catch(SQLException w){
            JOptionPane.showMessageDialog(null, "erro ao ler" +w, "", JOptionPane.ERROR_MESSAGE);
        }finally{
            ConnectionFactory.closeConnection(con, stat, rs);
        }
        
        return array;
    }
    
    
    public boolean delete(int idvenda, ItensVenda iv){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stat = null;
        
        try{
            stat = con.prepareStatement("DELETE FROM itensvenda WHERE idvenda = ? AND idproduto = ?");
            stat.setInt(1, idvenda);
            stat.setInt(2, iv.getIdproduto().getId());
            
            stat.executeUpdate();
            
            return true;
            
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "erro ao excluir", "erro", JOptionPane.ERROR_MESSAGE);
            return false;
        }finally{
           ConnectionFactory.closeConnection(con, stat);
        }
        
    }
    
    
    
    
    
    
}
