package controller;

import java.util.ArrayList;
import model.bean.Chave;
import model.bean.Porteiro;
import model.dao.ChaveDAO;

public class ChaveController {
    public void inserir(String sala, Porteiro pt){
        Chave ch = new Chave();
        ChaveDAO chdao = new ChaveDAO();
        
        ch.setSala(sala);
        ch.setSituacao("Liberada");
        ch.setPorteiro(pt);
        
        chdao.inserir(ch);
    }
    
    public ArrayList<Chave> read(){
        ChaveDAO chdao = new ChaveDAO();
        return chdao.read();
    }
    
    public boolean update(long id, String sala, Porteiro pt){
        Chave ch = new Chave();
        ch.setId(id);
        ch.setSala(sala);
        ch.setPorteiro(pt);
        
        ChaveDAO chdao = new ChaveDAO();
        return chdao.update(ch);
    }
    
    public void delete(long id){
        Chave ch = new Chave();
        ChaveDAO chdao = new ChaveDAO();
        ch.setId(id);
        chdao.delete(ch);
    }
    
    public ArrayList<Chave> chavesLiberadas(){
        ChaveDAO chdao = new ChaveDAO();
        return chdao.chavesLiberadas();
    }
    
    public ArrayList<Chave> chavesOcupadas(){
        ChaveDAO chdao = new ChaveDAO();
        return chdao.chavesOcupadas();
    }
    
    public boolean updateSituacao(long id, String situacao){
        Chave ch = new Chave();
        ch.setId(id);
        ch.setSituacao(situacao);
        
        ChaveDAO chdao = new ChaveDAO();
        return chdao.updateSituacao(ch);
    }
}
