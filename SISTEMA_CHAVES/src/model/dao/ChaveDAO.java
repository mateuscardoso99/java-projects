package model.dao;

import conexao.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.bean.Chave;
import model.bean.Porteiro;

public class ChaveDAO {
    public void inserir(Chave ch){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stat = null;
        
        try {
            stat = con.prepareStatement("INSERT INTO chave(sala,situacao,idporteiro) VALUES (?,?,?)");
            stat.setString(1, ch.getSala());
            stat.setString(2, ch.getSituacao());
            stat.setLong(3, ch.getPorteiro().getId());
            
            stat.executeUpdate();
            JOptionPane.showMessageDialog(null, "Salvo com sucesso", "", JOptionPane.INFORMATION_MESSAGE);
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Não foi possível salvar"+e, "", JOptionPane.ERROR_MESSAGE);
        } finally{
            ConnectionFactory.closeConnection(con, stat);
        }
    }
    
    public ArrayList<Chave> read(){
        Connection con = ConnectionFactory.getConnection();
        
        PreparedStatement stat = null;
        ResultSet rs = null;
        
        ArrayList<Chave> chaves = new ArrayList<>();
        
        try {
            stat = con.prepareStatement("SELECT chave.id as cid, chave.sala, chave.situacao,"
                    + " idporteiro, porteiro.id as pid, porteiro.nome FROM chave"
                    + " INNER JOIN porteiro ON porteiro.id=chave.idporteiro");
            rs = stat.executeQuery();
            
            while(rs.next()){
                Chave ch = new Chave();
                ch.setId(rs.getLong("cid"));
                ch.setSala(rs.getString("sala"));
                ch.setSituacao(rs.getString("situacao"));
                
                Porteiro pt = new Porteiro();
                pt.setId(rs.getLong("pid"));
                pt.setNome(rs.getString("nome"));
                ch.setPorteiro(pt);
                
                chaves.add(ch);
            }
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Não foi possível ler os dados"+e, "", JOptionPane.ERROR_MESSAGE);
        }finally{
            ConnectionFactory.closeConnection(con, stat, rs);
        }
        
        return chaves;
    }
    
    
    public boolean update(Chave ch){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stat = null;
        try {
            stat = con.prepareStatement("UPDATE chave SET sala = ?, idporteiro = ? WHERE id = ?");
            stat.setString(1, ch.getSala());
            stat.setLong(2, ch.getPorteiro().getId());
            stat.setLong(3, ch.getId());
            
            stat.executeUpdate();
            
            return true;
        } catch (SQLException e) {
            return false;
        } finally{
            ConnectionFactory.closeConnection(con, stat);
        }
    }
    
    public void delete(Chave ch){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stat = null;
        try{
            stat = con.prepareStatement("DELETE FROM chave WHERE id = ?");
            stat.setLong(1, ch.getId());
            
            stat.executeUpdate();
            JOptionPane.showMessageDialog(null, "Apagado com sucesso", "", JOptionPane.INFORMATION_MESSAGE);        
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Não foi possível excluir" +e, "", JOptionPane.ERROR_MESSAGE);
        }finally{
            ConnectionFactory.closeConnection(con, stat);
        }
    }
    
    public ArrayList<Chave> chavesLiberadas(){
        Connection con = ConnectionFactory.getConnection();
        
        PreparedStatement stat = null;
        ResultSet rs = null;
        
        ArrayList<Chave> chavesLiberadas = new ArrayList<>();
        
        try {
            stat = con.prepareStatement("SELECT chave.id as cid, chave.sala, chave.situacao, idporteiro,"
                    + " porteiro.id as pid, porteiro.nome FROM chave"
                    + " INNER JOIN porteiro ON chave.idporteiro=porteiro.id"
                    + " WHERE chave.situacao = 'Liberada'");
            rs = stat.executeQuery();

            while(rs.next()){
                Chave ch = new Chave();
                ch.setId(rs.getLong("cid"));
                ch.setSala(rs.getString("sala"));
                ch.setSituacao(rs.getString("situacao"));
            
                Porteiro pt = new Porteiro();
                pt.setId(rs.getLong("pid"));
                pt.setNome(rs.getString("nome"));
                ch.setPorteiro(pt);
                
                chavesLiberadas.add(ch);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Não foi possível ler os dados"+e, "", JOptionPane.ERROR_MESSAGE);
        }finally{
            ConnectionFactory.closeConnection(con, stat, rs);
        }
        
        return chavesLiberadas;
    }
    
    public ArrayList<Chave> chavesOcupadas(){
        Connection con = ConnectionFactory.getConnection();
        
        PreparedStatement stat = null;
        ResultSet rs = null;
        
        ArrayList<Chave> chavesOcupadas = new ArrayList<>();
        
        try {
            stat = con.prepareStatement("SELECT * FROM chave WHERE situacao = 'Ocupada'");
            rs = stat.executeQuery();

            while(rs.next()){
                Chave ch = new Chave();
                ch.setId(rs.getLong("id"));
                ch.setSala(rs.getString("sala"));
                ch.setSituacao(rs.getString("situacao"));
            
                chavesOcupadas.add(ch);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Não foi possível ler os dados"+e, "", JOptionPane.ERROR_MESSAGE);
        }finally{
            ConnectionFactory.closeConnection(con, stat, rs);
        }
        
        return chavesOcupadas;
    }
    
    public boolean updateSituacao(Chave ch){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stat = null;
        try {
            stat = con.prepareStatement("UPDATE chave SET situacao = ? WHERE id = ?");
            stat.setString(1, ch.getSituacao());
            stat.setLong(2, ch.getId());
            
            stat.executeUpdate();
            return true;
        } catch (SQLException e) {
            return false;
        } finally{
            ConnectionFactory.closeConnection(con, stat);
        }
    }
    
}
