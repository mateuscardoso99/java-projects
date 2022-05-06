package controller;

import java.util.ArrayList;
import model.bean.Professor;
import model.dao.ProfessorDAO;

public class ProfessorController {
    public void inserir(String nome, String graduacao, String situacao){
        Professor prof = new Professor();
        ProfessorDAO pdao = new ProfessorDAO();
        
        prof.setNome(nome);
        prof.setGraduacao(graduacao);
        prof.setSituacao(situacao);
        
        pdao.inserir(prof);
    }
    
    public ArrayList<Professor> read(){
        ProfessorDAO pdao = new ProfessorDAO();
        return pdao.read();
    }
    
    public ArrayList<Professor> professoresAtivados(){
        ProfessorDAO pdao = new ProfessorDAO();
        return pdao.professoresAtivados();
    }
    
    public boolean update(long id, String nome, String graduacao, String situacao){
        Professor prof = new Professor();
        prof.setId(id);
        prof.setNome(nome);
        prof.setGraduacao(graduacao);
        prof.setSituacao(situacao);
        
        ProfessorDAO pdao = new ProfessorDAO();
        return pdao.update(prof);
    }
    
    public void delete(long id){
        Professor prof = new Professor();
        ProfessorDAO pdao = new ProfessorDAO();
        prof.setId(id);
        pdao.delete(prof);
    }
}
