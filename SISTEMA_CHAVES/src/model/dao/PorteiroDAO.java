package model.dao;

import conexao.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.bean.Porteiro;

public class PorteiroDAO {
    public void inserir(Porteiro pt){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stat = null;
        
        try {
            stat = con.prepareStatement("INSERT INTO porteiro(nome,situacao) VALUES (?,?)");
            stat.setString(1, pt.getNome());
            stat.setString(2, pt.getSituacao());
            
            stat.executeUpdate();
            JOptionPane.showMessageDialog(null, "Salvo com sucesso", "", JOptionPane.INFORMATION_MESSAGE);
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Não foi possível salvar"+e, "", JOptionPane.ERROR_MESSAGE);
        } finally{
            ConnectionFactory.closeConnection(con, stat);
        }
    }
    
    public ArrayList<Porteiro> read(){
        Connection con = ConnectionFactory.getConnection();
        
        PreparedStatement stat = null;
        ResultSet rs = null;
        
        ArrayList<Porteiro> porteiros = new ArrayList<>();
        
        try {
            stat = con.prepareStatement("SELECT * FROM porteiro");
            rs = stat.executeQuery();
            
            while(rs.next()){
                Porteiro pt = new Porteiro();
                pt.setId(rs.getLong("id"));
                pt.setNome(rs.getString("nome"));
                pt.setSituacao(rs.getString("situacao"));
                
                porteiros.add(pt);
            }
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Não foi possível ler os dados"+e, "", JOptionPane.ERROR_MESSAGE);
        }finally{
            ConnectionFactory.closeConnection(con, stat, rs);
        }
        
        return porteiros;
    }
    
    
    public ArrayList<Porteiro> porteirosAtivados(){
        Connection con = ConnectionFactory.getConnection();
        
        PreparedStatement stat = null;
        ResultSet rs = null;
        
        ArrayList<Porteiro> porteirosAtivados = new ArrayList<>();
        
        try {
            stat = con.prepareStatement("SELECT * FROM porteiro WHERE situacao = 'Ativado'");
            rs = stat.executeQuery();
            
            while(rs.next()){
                Porteiro pt = new Porteiro();
                pt.setId(rs.getLong("id"));
                pt.setNome(rs.getString("nome"));
                pt.setSituacao(rs.getString("situacao"));
                
                porteirosAtivados.add(pt);
            }
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Não foi possível ler os dados"+e, "", JOptionPane.ERROR_MESSAGE);
        }finally{
            ConnectionFactory.closeConnection(con, stat, rs);
        }
        
        return porteirosAtivados;
    }
    
    
    public boolean update(Porteiro pt){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stat = null;
        try {
            stat = con.prepareStatement("UPDATE porteiro SET nome = ?, situacao = ? WHERE id = ?");
            stat.setString(1, pt.getNome());
            stat.setString(2, pt.getSituacao());
            stat.setLong(3, pt.getId());
            
            stat.executeUpdate();
            
            return true;
        } catch (SQLException e) {
            return false;
        } finally{
            ConnectionFactory.closeConnection(con, stat);
        }
    }
    
    public void delete(Porteiro pt){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stat = null;
        try{
            stat = con.prepareStatement("DELETE FROM porteiro WHERE id = ?");
            stat.setLong(1, pt.getId());
            
            stat.executeUpdate();
            JOptionPane.showMessageDialog(null, "Apagado com sucesso", "", JOptionPane.INFORMATION_MESSAGE);        
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Não foi possível excluir" +e, "", JOptionPane.ERROR_MESSAGE);
        }finally{
            ConnectionFactory.closeConnection(con, stat);
        }
    }
    
}
