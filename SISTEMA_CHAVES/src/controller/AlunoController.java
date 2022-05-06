package controller;

import java.util.ArrayList;
import model.dao.AlunoDAO;
import model.bean.Aluno;
import model.bean.Aluno;
import model.bean.Professor;

public class AlunoController {
    public void inserir(String nome, String curso, String situacao, Professor p){
        Aluno a = new Aluno();
        AlunoDAO ao = new AlunoDAO();
        
        a.setNome(nome);
        a.setCurso(curso);
        a.setSituacao(situacao);
        a.setProfessor(p);
        
        ao.inserir(a);
    }
    
    public ArrayList<Aluno> read(){
        AlunoDAO ao = new AlunoDAO();
        return ao.read();
    }
    
    public ArrayList<Aluno> alunosAtivados(){
        AlunoDAO ao = new AlunoDAO();
        return ao.alunosAtivados();
    }
    
    public boolean update(long id, String nome, String curso, String situacao, Professor p){
        Aluno a = new Aluno();
        AlunoDAO ao = new AlunoDAO();
        
        a.setId(id);
        a.setNome(nome);
        a.setCurso(curso);
        a.setSituacao(situacao);
        a.setProfessor(p);

        return ao.update(a);
    }
    
    public void delete(long id){
        AlunoDAO ao = new AlunoDAO();
        ao.delete(id);
    }
}
