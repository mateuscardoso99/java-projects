package model.dao;

import conexao.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.bean.Aluno;
import model.bean.Aula;
import model.bean.Chave;
import model.bean.Porteiro;
import model.bean.Professor;

public class AulaDAO {
    public boolean iniciarAula(long idchave, long idprof, long idaluno,long idporteiro, String dataInicio){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stat = null;
        
        try {
            stat = con.prepareStatement("INSERT INTO aula(idchave,idprofessor,idaluno,idporteiro,"
                    + "datainicio,datafim,status) VALUES (?,?,?,?,?,?,?)");
            stat.setLong(1, idchave);
            
            if(idprof == 0){
                stat.setNull(2, 0);
            }else{
                stat.setLong(2, idprof);
            }
            
            if(idaluno == 0){
                stat.setNull(3, 0);
            }else{
                stat.setLong(3, idaluno);
            }
            
            stat.setLong(4, idporteiro);
            stat.setString(5, dataInicio);
            stat.setString(6, "");
            stat.setString(7, "em andamento");
            
            stat.executeUpdate();
            return true;
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Não foi possível salvar"+e, "", JOptionPane.ERROR_MESSAGE);
            return false;
        } finally{
            ConnectionFactory.closeConnection(con, stat);
        }
    }
    
    public boolean update(long id, String datafim){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stat = null;
        try {
            stat = con.prepareStatement("UPDATE aula SET datafim = ?, status = ? WHERE id = ?");
            stat.setString(1, datafim);
            stat.setString(2, "Encerrada");
            stat.setLong(3, id);
            
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
            stat = con.prepareStatement("DELETE FROM aula WHERE id = ?");
            stat.setLong(1, id);
            
            stat.executeUpdate();
            JOptionPane.showMessageDialog(null, "Apagado com sucesso", "", JOptionPane.INFORMATION_MESSAGE);        
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Não foi possível excluir" +e, "", JOptionPane.ERROR_MESSAGE);
        }finally{
            ConnectionFactory.closeConnection(con, stat);
        }
    }
        
    public ArrayList<Aula> read(){
        Connection con = ConnectionFactory.getConnection();
        
        PreparedStatement stat = null;
        PreparedStatement stat2 = null;
        ResultSet rs = null;
        ResultSet rs2 = null;
        
        ArrayList<Aula> aulas = new ArrayList<>();
        
        try {
            
            stat = con.prepareStatement("SELECT aula.id as aid, aula.idchave, aula.idprofessor, aula.idaluno,"
                    + " aula.idporteiro, datainicio, datafim, status, chave.id as cid, chave.sala, professor.id as pid, "
                    + "professor.nome as pnome, aluno.id as alunoid, aluno.nome as anome, porteiro.id as ptid, "
                    + "porteiro.nome as ptnome FROM aula "
                    + "INNER JOIN chave ON aula.idchave=chave.id "
                    + "INNER JOIN professor ON aula.idprofessor=professor.id "
                    + "INNER JOIN aluno ON aula.idaluno=aluno.id "
                    + "INNER JOIN porteiro ON aula.idporteiro=porteiro.id");
            rs = stat.executeQuery();
            
            while(rs.next()){
                Aula a = new Aula();
                a.setId(rs.getLong("aid"));
                a.setDataInicio(rs.getString("datainicio"));
                a.setDataFim(rs.getString("datafim"));
                a.setStatus(rs.getString("status"));
                
                Chave ch = new Chave();
                ch.setId(rs.getLong("cid"));
                ch.setSala(rs.getString("sala"));
                a.setChave(ch);
                
                Professor p = new Professor();
                p.setId(rs.getLong("pid"));
                p.setNome(rs.getString("pnome"));
                a.setProfessor(p);
                
                Aluno aluno = new Aluno();
                aluno.setId(rs.getLong("alunoid"));
                aluno.setNome(rs.getString("anome"));
                a.setAluno(aluno);
                
                Porteiro pt = new Porteiro();
                pt.setId(rs.getLong("ptid"));
                pt.setNome(rs.getString("ptnome"));
                a.setPorteiro(pt);
                
                aulas.add(a);
            }
            
            stat = con.prepareStatement("SELECT aula.id as aid, aula.idchave, aula.idprofessor, aula.idaluno,"
                    + " aula.idporteiro, datainicio, datafim, status, chave.id as cid, chave.sala, "
                    + "professor.id as pid, professor.nome as pnome, porteiro.id as ptid, "
                    + "porteiro.nome as ptnome FROM aula "
                    + "INNER JOIN chave ON aula.idchave=chave.id "
                    + "INNER JOIN professor ON aula.idprofessor=professor.id "
                    + "INNER JOIN porteiro ON aula.idporteiro=porteiro.id "
                    + "AND aula.idaluno is null");
            rs = stat.executeQuery();
            
            while(rs.next()){
                Aula a = new Aula();
                a.setId(rs.getLong("aid"));
                a.setDataInicio(rs.getString("datainicio"));
                a.setDataFim(rs.getString("datafim"));
                a.setStatus(rs.getString("status"));
                
                Chave ch = new Chave();
                ch.setId(rs.getLong("cid"));
                ch.setSala(rs.getString("sala"));
                a.setChave(ch);
                
                Professor p = new Professor();
                p.setId(rs.getLong("pid"));
                p.setNome(rs.getString("pnome"));
                a.setProfessor(p);
                
                Aluno aluno = new Aluno();
                aluno.setId(0);
                aluno.setNome("");
                a.setAluno(aluno);
                
                Porteiro pt = new Porteiro();
                pt.setId(rs.getLong("ptid"));
                pt.setNome(rs.getString("ptnome"));
                a.setPorteiro(pt);
                
                aulas.add(a);
            }
            
            stat = con.prepareStatement("SELECT aula.id as aid, aula.idchave, aula.idprofessor, aula.idaluno,"
                    + " aula.idporteiro, datainicio, datafim, status, chave.id as cid, chave.sala, "
                    + "aluno.id as alunoid, aluno.nome as anome, porteiro.id as ptid, "
                    + "porteiro.nome as ptnome FROM aula "
                    + "INNER JOIN chave ON aula.idchave=chave.id "
                    + "INNER JOIN aluno ON aula.idaluno = aluno.id "
                    + "INNER JOIN porteiro ON aula.idporteiro=porteiro.id "
                    + "WHERE aula.idprofessor IS NULL");
            rs = stat.executeQuery();
            
            while(rs.next()){
                Aula a = new Aula();
                a.setId(rs.getLong("aid"));
                a.setDataInicio(rs.getString("datainicio"));
                a.setDataFim(rs.getString("datafim"));
                a.setStatus(rs.getString("status"));
                
                Chave ch = new Chave();
                ch.setId(rs.getLong("cid"));
                ch.setSala(rs.getString("sala"));
                a.setChave(ch);
                
                Professor p = new Professor();
                p.setId(0);
                p.setNome("");
                a.setProfessor(p);
                
                Aluno aluno = new Aluno();
                aluno.setId(rs.getLong("alunoid"));
                aluno.setNome(rs.getString("anome"));
                a.setAluno(aluno);
                
                Porteiro pt = new Porteiro();
                pt.setId(rs.getLong("ptid"));
                pt.setNome(rs.getString("ptnome"));
                a.setPorteiro(pt);
                
                aulas.add(a);
            }
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Não foi possível ler os dados"+e, "", JOptionPane.ERROR_MESSAGE);
        }finally{
            ConnectionFactory.closeConnection(con, stat, rs);
        }
        /*
        try {
            Connection con = ConnectionFactory.getConnection();
            stat2 = con.prepareStatement("SELECT aula.id as aid, aula.idchave, aula.idprofessor, aula.idaluno,"
                    + " aula.idporteiro, datainicio, datafim, status, chave.id as cid, chave.sala, "
                    + "professor.id as pid, professor.nome as pnome, porteiro.id as ptid, "
                    + "porteiro.nome as ptnome FROM aula "
                    + "INNER JOIN chave ON aula.idchave=chave.id "
                    + "INNER JOIN professor ON aula.idprofessor=professor.id "
                    + "INNER JOIN porteiro ON aula.idporteiro=porteiro.id "
                    + "AND aula.idaluno is null");
            rs2 = stat.executeQuery();
            
            while(rs2.next()){
                Aula a = new Aula();
                a.setId(rs.getLong("aid"));
                a.setDataInicio(rs.getString("datainicio"));
                a.setDataFim(rs.getString("datafim"));
                a.setStatus(rs.getString("status"));
                
                Chave ch = new Chave();
                ch.setId(rs.getLong("cid"));
                ch.setSala(rs.getString("sala"));
                a.setChave(ch);
                
                Professor p = new Professor();
                p.setId(rs.getLong("pid"));
                p.setNome(rs.getString("pnome"));
                a.setProfessor(p);
                
                Porteiro pt = new Porteiro();
                pt.setId(rs.getLong("ptid"));
                pt.setNome(rs.getString("ptnome"));
                a.setPorteiro(pt);
                
                aulas.add(a);
            }
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Não foi possível ler os dados"+e, "", JOptionPane.ERROR_MESSAGE);
        }finally{
            ConnectionFactory.closeConnection(con, stat, rs2);
        }
        */
        return aulas;
    }
    
    
    
    /*public ArrayList<Aula> read2(){
        Connection con = ConnectionFactory.getConnection();
        
        PreparedStatement stat = null;
        ResultSet rs = null;
        
        ArrayList<Aula> aulas = new ArrayList<>();
        
        try {
            stat = con.prepareStatement("SELECT aula.id as aid, aula.idchave, aula.idprofessor, aula.idaluno,"
                    + " aula.idporteiro, datainicio, datafim, status, chave.id as cid, chave.sala,"
                    + " professor.id as pid, professor.nome as pnome, porteiro.id as ptid,"
                    + " porteiro.nome as ptnome FROM aula"
                    + " INNER JOIN chave ON aula.idchave=chave.id"
                    + " INNER JOIN professor ON aula.idprofessor=professor.id"
                    + " INNER JOIN porteiro ON aula.idporteiro=porteiro.id"
                    + " AND aula.idaluno is null");
            rs = stat.executeQuery();
            
            while(rs.next()){
                Aula a = new Aula();
                a.setId(rs.getLong("aid"));
                a.setDataInicio(rs.getString("datainicio"));
                a.setDataFim(rs.getString("datafim"));
                a.setStatus(rs.getString("status"));
                
                Chave ch = new Chave();
                ch.setId(rs.getLong("cid"));
                ch.setSala(rs.getString("sala"));
                a.setChave(ch);
                
                Professor p = new Professor();
                p.setId(rs.getLong("pid"));
                p.setNome(rs.getString("pnome"));
                a.setProfessor(p);
                
                Porteiro pt = new Porteiro();
                pt.setId(rs.getLong("ptid"));
                pt.setNome(rs.getString("ptnome"));
                a.setPorteiro(pt);
                
                aulas.add(a);
            }
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Não foi possível ler os dados"+e, "", JOptionPane.ERROR_MESSAGE);
        }finally{
            ConnectionFactory.closeConnection(con, stat, rs);
        }
        
        return aulas;
    }
    */
    
}
