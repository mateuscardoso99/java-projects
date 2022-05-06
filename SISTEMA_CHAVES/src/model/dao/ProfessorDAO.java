package model.dao;

import conexao.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.bean.Professor;

public class ProfessorDAO {
    public void inserir(Professor prof){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stat = null;
        
        try {
            stat = con.prepareStatement("INSERT INTO professor(nome,graduacao,situacao) VALUES (?,?,?)");
            stat.setString(1, prof.getNome());
            stat.setString(2, prof.getGraduacao());
            stat.setString(3, prof.getSituacao());
            
            stat.executeUpdate();
            JOptionPane.showMessageDialog(null, "Salvo com sucesso", "", JOptionPane.INFORMATION_MESSAGE);
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Não foi possível salvar"+e, "", JOptionPane.ERROR_MESSAGE);
        } finally{
            ConnectionFactory.closeConnection(con, stat);
        }
    }
    
    public ArrayList<Professor> read(){
        Connection con = ConnectionFactory.getConnection();
        
        PreparedStatement stat = null;
        ResultSet rs = null;
        
        ArrayList<Professor> professores = new ArrayList<>();
        
        try {
            stat = con.prepareStatement("SELECT * FROM professor");
            rs = stat.executeQuery();
            
            while(rs.next()){
                Professor prof = new Professor();
                prof.setId(rs.getLong("id"));
                prof.setNome(rs.getString("nome"));
                prof.setGraduacao(rs.getString("graduacao"));
                prof.setSituacao(rs.getString("situacao"));
                
                professores.add(prof);
            }
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Não foi possível ler os dados"+e, "", JOptionPane.ERROR_MESSAGE);
        }finally{
            ConnectionFactory.closeConnection(con, stat, rs);
        }
        
        return professores;
    }
    
    
    public boolean update(Professor prof){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stat = null;
        try {
            stat = con.prepareStatement("UPDATE professor SET nome = ?, graduacao = ?, situacao = ? WHERE id = ?");
            stat.setString(1, prof.getNome());
            stat.setString(2, prof.getGraduacao());
            stat.setString(3, prof.getSituacao());
            stat.setLong(4, prof.getId());
            
            stat.executeUpdate();
            
            return true;
        } catch (SQLException e) {
            return false;
        } finally{
            ConnectionFactory.closeConnection(con, stat);
        }
    }
    
    public void delete(Professor prof){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stat = null;
        try{
            stat = con.prepareStatement("DELETE FROM professor WHERE id = ?");
            stat.setLong(1, prof.getId());
            
            stat.executeUpdate();
            JOptionPane.showMessageDialog(null, "Apagado com sucesso", "", JOptionPane.INFORMATION_MESSAGE);        
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Não foi possível excluir" +e, "", JOptionPane.ERROR_MESSAGE);
        }finally{
            ConnectionFactory.closeConnection(con, stat);
        }
    }
    
    public ArrayList<Professor> professoresAtivados(){
        Connection con = ConnectionFactory.getConnection();
        
        PreparedStatement stat = null;
        ResultSet rs = null;
        
        ArrayList<Professor> professoresAtivados = new ArrayList<>();
        
        try {
            stat = con.prepareStatement("SELECT * FROM professor WHERE situacao = 'Ativado'");
            rs = stat.executeQuery();
            
            while(rs.next()){
                Professor prof = new Professor();
                prof.setId(rs.getLong("id"));
                prof.setNome(rs.getString("nome"));
                prof.setGraduacao(rs.getString("graduacao"));
                prof.setSituacao(rs.getString("situacao"));
                
                professoresAtivados.add(prof);
            }
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Não foi possível ler os dados"+e, "", JOptionPane.ERROR_MESSAGE);
        }finally{
            ConnectionFactory.closeConnection(con, stat, rs);
        }
        
        return professoresAtivados;
    }
}
