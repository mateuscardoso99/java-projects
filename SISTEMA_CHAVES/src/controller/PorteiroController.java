package controller;

import java.util.ArrayList;
import model.bean.Porteiro;
import model.dao.PorteiroDAO;

public class PorteiroController {
    public void inserir(String nome, String descr){
        Porteiro pt = new Porteiro();
        PorteiroDAO pdao = new PorteiroDAO();
        
        pt.setNome(nome);
        pt.setSituacao(descr);
        
        pdao.inserir(pt);
    }
    
    public ArrayList<Porteiro> read(){
        PorteiroDAO pdao = new PorteiroDAO();
        return pdao.read();
    }
    
    public ArrayList<Porteiro> porteirosAtivados(){
        PorteiroDAO pdao = new PorteiroDAO();
        return pdao.porteirosAtivados();
    }
    
    public boolean update(long id, String nome, String descr){
        Porteiro pt = new Porteiro();
        pt.setId(id);
        pt.setNome(nome);
        pt.setSituacao(descr);
        
        PorteiroDAO pdao = new PorteiroDAO();
        return pdao.update(pt);
    }
    
    public void delete(long id){
        Porteiro pt = new Porteiro();
        PorteiroDAO pdao = new PorteiroDAO();
        pt.setId(id);
        pdao.delete(pt);
    }
}
