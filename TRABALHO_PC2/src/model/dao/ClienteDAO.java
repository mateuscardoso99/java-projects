package model.dao;

import conexao.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.bean.Cliente;

public class ClienteDAO {
    public boolean insert(Cliente c){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stat = null;
        
        try{
            stat = con.prepareStatement("INSERT INTO cliente (nome,endereco,cpf,telefone,aniversario) VALUES (?,?,?,?,?)");
            
            stat.setString(1, c.getNome());
            stat.setString(2, c.getEndereco());
            stat.setString(3, c.getCpf());
            stat.setString(4, c.getTelefone());
            stat.setString(5, c.getAniversario());
            
            stat.executeUpdate();
            
            return true;
            
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "erro", "erro", JOptionPane.ERROR_MESSAGE);
            return false;
        }finally{
            ConnectionFactory.closeConnection(con, stat);
        }
        
        
    }
    
    
    public ArrayList<Cliente> read(){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stat = null;
        ResultSet rs = null;
        
        ArrayList <Cliente> array = new ArrayList<>();
        
        try{
            stat = con.prepareStatement("SELECT * FROM cliente");
            rs = stat.executeQuery();
            
            while(rs.next()){
                Cliente c = new Cliente();
                c.setId(rs.getInt("id"));
                c.setNome(rs.getString("nome"));
                c.setEndereco(rs.getString("endereco"));
                c.setCpf(rs.getString("cpf"));
                c.setTelefone(rs.getString("telefone"));
                c.setAniversario(rs.getString("aniversario"));
                
                array.add(c);
            }
            
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "erro", "erro", JOptionPane.ERROR_MESSAGE);
        }finally{
            ConnectionFactory.closeConnection(con, stat, rs);
        }
        
        return array;
        
    }
    
    
    
    public boolean update(Cliente c){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stat = null;
        
        try{
            stat = con.prepareStatement("UPDATE cliente SET nome = ?, endereco = ?, cpf = ?, telefone = ?, aniversario = ? WHERE id = ?");
            stat.setString(1, c.getNome());
            stat.setString(2, c.getEndereco());
            stat.setString(3, c.getCpf());
            stat.setString(4, c.getTelefone());
            stat.setString(5, c.getAniversario());
            stat.setInt(6, c.getId());
            
            stat.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "atualizado com sucesso", "", JOptionPane.INFORMATION_MESSAGE);
            return true;
            
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "erro", "erro", JOptionPane.ERROR_MESSAGE);
            return false;
        }finally{
            ConnectionFactory.closeConnection(con, stat);
        }
 
    }
    
    
    
    public boolean delete(Cliente c){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stat = null;
        
        try{
            stat = con.prepareStatement("DELETE FROM cliente WHERE id = ?");
            stat.setInt(1, c.getId());
            
            stat.executeUpdate();
            
            return true;
            
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "erro", "erro", JOptionPane.ERROR_MESSAGE);
            return false;
        }finally{
           ConnectionFactory.closeConnection(con, stat);
        }
    
}
    
    
    public ArrayList<Cliente> buscaPorNome(String nome){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stat = null;
        ResultSet rs = null;
        
        ArrayList<Cliente> arrayNome = new ArrayList<>();
        
        try{
            stat = con.prepareStatement("SELECT * FROM cliente WHERE nome = ?");
            stat.setString(1, nome);
            rs = stat.executeQuery();
            
            while(rs.next()){
                Cliente c = new Cliente();
                c.setId(rs.getInt("id"));
                c.setNome(rs.getString("nome"));
                c.setEndereco(rs.getString("endereco"));
                c.setCpf(rs.getString("cpf"));
                c.setTelefone(rs.getString("telefone"));
                c.setAniversario(rs.getString("aniversario"));
                
                arrayNome.add(c);
            }
            
        }catch(SQLException w){
            JOptionPane.showMessageDialog(null, "erro ao buscar os dados" +w, "", JOptionPane.ERROR_MESSAGE);
        }finally{
            ConnectionFactory.closeConnection(con, stat, rs);
        }
        
        return arrayNome;
    }
    
    
    public ArrayList<Cliente> buscaPorCPF(String cpf){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stat = null;
        ResultSet rs = null;
        
        ArrayList<Cliente> arraycpf = new ArrayList<>();
        
        try{
            stat = con.prepareStatement("SELECT * FROM cliente WHERE cpf = ?");
            stat.setString(1, cpf);
            rs = stat.executeQuery();
            
            while(rs.next()){
                Cliente c = new Cliente();
                c.setId(rs.getInt("id"));
                c.setNome(rs.getString("nome"));
                c.setEndereco(rs.getString("endereco"));
                c.setCpf(rs.getString("cpf"));
                c.setTelefone(rs.getString("telefone"));
                c.setAniversario(rs.getString("aniversario"));
                
                arraycpf.add(c);
            }
            
        }catch(SQLException w){
            JOptionPane.showMessageDialog(null, "erro ao buscar os dados" +w, "", JOptionPane.ERROR_MESSAGE);
        }finally{
            ConnectionFactory.closeConnection(con, stat, rs);
        }
        
        return arraycpf;
    }
}
