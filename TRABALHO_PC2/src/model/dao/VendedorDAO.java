package model.dao;

import conexao.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.bean.Vendedor;

public class VendedorDAO {
    
    public boolean insert(Vendedor v){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement st = null;
                
        try{
            st=con.prepareStatement("INSERT INTO vendedor(nome,endereco,cpf,salario,percentual) VALUES (?,?,?,?,?)");
            st.setString(1, v.getNome());
            st.setString(2, v.getEndereco());
            st.setString(3, v.getCpf());
            st.setDouble(4, v.getSalario());
            st.setDouble(5, v.getPercentual());
            
            st.executeUpdate();
            
            return true;
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "erro ao inserir" +e, "", JOptionPane.INFORMATION_MESSAGE);
            e.printStackTrace();
            return false;
        }finally{
            ConnectionFactory.closeConnection(con, st);
        }
    }
    
    
    public ArrayList<Vendedor> select(){
        Connection c = ConnectionFactory.getConnection();
        PreparedStatement st = null;
        ResultSet rs = null;
        
        ArrayList<Vendedor> array = new ArrayList<>();
        
        try{
            st=c.prepareStatement("SELECT * FROM vendedor");
            rs = st.executeQuery();
            
            while(rs.next()){
                Vendedor v = new Vendedor();
                v.setId(rs.getInt("id"));
                v.setNome(rs.getString("nome"));
                v.setEndereco(rs.getString("endereco"));
                v.setSalario(rs.getDouble("salario"));
                v.setCpf(rs.getString("cpf"));
                v.setPercentual(rs.getDouble("percentual"));
                
                array.add(v);
            }            
            
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "erro ao ler" +e, "", JOptionPane.INFORMATION_MESSAGE);
            e.printStackTrace();
        }finally{
            ConnectionFactory.closeConnection(c, st, rs);
        }
        
        return array;
    }
    
    
    public boolean apagar(Vendedor v){
        Connection c = ConnectionFactory.getConnection();
        PreparedStatement st = null;
        
        try{
            st=c.prepareStatement("DELETE FROM vendedor WHERE id = ?");
            st.setInt(1, v.getId());
            
            st.executeUpdate();
            
            return true;
            
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "erro ao ler" +e, "", JOptionPane.INFORMATION_MESSAGE);
            e.printStackTrace();
            return false;
        }finally{
            ConnectionFactory.closeConnection(c, st);
        }
    }
    
    
    
    public boolean update(Vendedor v){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement st = null;
                
        try{
            st=con.prepareStatement("UPDATE vendedor SET nome = ?, endereco =? ,cpf = ?,salario = ?,percentual = ? WHERE id = ?");
            st.setString(1, v.getNome());
            st.setString(2, v.getEndereco());
            st.setString(3, v.getCpf());
            st.setDouble(4, v.getSalario());
            st.setDouble(5, v.getPercentual());
            st.setInt(6, v.getId());
            
            st.executeUpdate();
            
            return true;
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "erro ao inserir" +e, "", JOptionPane.INFORMATION_MESSAGE);
            e.printStackTrace();
            return false;
        }finally{
            ConnectionFactory.closeConnection(con, st);
        }
    }
    
    
    public ArrayList<Vendedor> buscaPorNome(String nome){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stat = null;
        ResultSet rs = null;
        
        ArrayList<Vendedor> arrayNome = new ArrayList<>();
        
        try{
            stat = con.prepareStatement("SELECT * FROM vendedor WHERE nome = ?");
            stat.setString(1, nome);
            rs = stat.executeQuery();
            
            while(rs.next()){
                Vendedor v = new Vendedor();
                v.setId(rs.getInt("id"));
                v.setNome(rs.getString("nome"));
                v.setEndereco(rs.getString("endereco"));
                v.setSalario(rs.getDouble("salario"));
                v.setCpf(rs.getString("cpf"));
                v.setPercentual(rs.getDouble("percentual"));
                
                arrayNome.add(v);
            }
            
        }catch(SQLException w){
            JOptionPane.showMessageDialog(null, "erro ao buscar os dados" +w, "", JOptionPane.ERROR_MESSAGE);
        }finally{
            ConnectionFactory.closeConnection(con, stat, rs);
        }
        
        return arrayNome;
    }
    
    
    public ArrayList<Vendedor> buscaPorCPF(String cpf){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stat = null;
        ResultSet rs = null;
        
        ArrayList<Vendedor> arraycpf = new ArrayList<>();
        
        try{
            stat = con.prepareStatement("SELECT * FROM vendedor WHERE cpf = ?");
            stat.setString(1, cpf);
            rs = stat.executeQuery();
            
            while(rs.next()){
                Vendedor v = new Vendedor();
                v.setId(rs.getInt("id"));
                v.setNome(rs.getString("nome"));
                v.setEndereco(rs.getString("endereco"));
                v.setSalario(rs.getDouble("salario"));
                v.setCpf(rs.getString("cpf"));
                v.setPercentual(rs.getDouble("percentual"));
                
                arraycpf.add(v);
            }
            
        }catch(SQLException w){
            JOptionPane.showMessageDialog(null, "erro ao buscar os dados" +w, "", JOptionPane.ERROR_MESSAGE);
        }finally{
            ConnectionFactory.closeConnection(con, stat, rs);
        }
        
        return arraycpf;
    }
}
