package model.dao;

import conexao.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.bean.Aluno;
import model.bean.Professor;

public class AlunoDAO {
    public void inserir(Aluno a){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stat = null;
        
        try {
            stat = con.prepareStatement("INSERT INTO aluno(nome,curso,situacao,idprofessor) VALUES (?,?,?,?)");
            stat.setString(1, a.getNome());
            stat.setString(2, a.getCurso());
            stat.setString(3, a.getSituacao());
            stat.setLong(4, a.getProfessor().getId());
            
            stat.executeUpdate();
            JOptionPane.showMessageDialog(null, "Salvo com sucesso", "", JOptionPane.INFORMATION_MESSAGE);
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Não foi possível salvar"+e, "", JOptionPane.ERROR_MESSAGE);
        } finally{
            ConnectionFactory.closeConnection(con, stat);
        }
    }
    
    public ArrayList<Aluno> read(){
        Connection con = ConnectionFactory.getConnection();
        
        PreparedStatement stat = null;
        ResultSet rs = null;
        
        ArrayList<Aluno> alunos = new ArrayList<>();
        
        try {
            stat = con.prepareStatement("SELECT aluno.id as ad, aluno.nome as anome, curso, aluno.situacao, idprofessor,"
                    + "professor.id as pid, professor.nome as pnome FROM aluno INNER JOIN professor"
                    + " ON aluno.idprofessor = professor.id");
            rs = stat.executeQuery();
            
            while(rs.next()){
                Aluno a = new Aluno();
                a.setId(rs.getLong("ad"));
                a.setNome(rs.getString("anome"));
                a.setCurso(rs.getString("curso"));
                a.setSituacao(rs.getString("situacao"));
                
                Professor prof = new Professor();
                prof.setId(rs.getLong("pid"));
                prof.setNome(rs.getString("pnome"));
                a.setProfessor(prof);
                
                alunos.add(a);
            }
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Não foi possível ler os dados"+e, "", JOptionPane.ERROR_MESSAGE);
        }finally{
            ConnectionFactory.closeConnection(con, stat, rs);
        }
        
        return alunos;
    }
    
    
    public boolean update(Aluno a){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stat = null;
        try {
            stat = con.prepareStatement("UPDATE aluno SET nome = ?, curso = ?, situacao = ?, idprofessor = ? WHERE id = ?");
            stat.setString(1, a.getNome());
            stat.setString(2, a.getCurso());
            stat.setString(3, a.getSituacao());
            stat.setLong(4, a.getProfessor().getId());
            stat.setLong(5, a.getId());
            stat.executeUpdate();
            
            return true;
        } catch (SQLException e) {
            return false;
        } finally{
            ConnectionFactory.closeConnection(con, stat);
        }
    }
    
    public void delete(long id){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stat = null;
        try{
            stat = con.prepareStatement("DELETE FROM aluno WHERE id = ?");
            stat.setLong(1, id);
            
            stat.executeUpdate();
            JOptionPane.showMessageDialog(null, "Apagado com sucesso", "", JOptionPane.INFORMATION_MESSAGE);        
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Não foi possível excluir" +e, "", JOptionPane.ERROR_MESSAGE);
        }finally{
            ConnectionFactory.closeConnection(con, stat);
        }
    }
    
    public ArrayList<Aluno> alunosAtivados(){
        Connection con = ConnectionFactory.getConnection();
        
        PreparedStatement stat = null;
        ResultSet rs = null;
        
        ArrayList<Aluno> alunosAtivados = new ArrayList<>();
        
        try {
            stat = con.prepareStatement("SELECT * FROM aluno WHERE situacao = 'Ativado'");
            rs = stat.executeQuery();
            
            while(rs.next()){
                Aluno a = new Aluno();
                a.setId(rs.getLong("id"));
                a.setNome(rs.getString("nome"));
                a.setCurso(rs.getString("curso"));
                a.setSituacao(rs.getString("situacao"));
                
                alunosAtivados.add(a);
            }
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Não foi possível ler os dados"+e, "", JOptionPane.ERROR_MESSAGE);
        }finally{
            ConnectionFactory.closeConnection(con, stat, rs);
        }
        
        return alunosAtivados;
    }
}
