package controller;

import java.util.ArrayList;
import model.bean.Aula;
import model.dao.AulaDAO;

public class AulaController {
    public boolean iniciarAula(long idchave, long idprof, long idaluno,long idporteiro, String dataInicio){
        AulaDAO ad = new AulaDAO();
        return ad.iniciarAula(idchave, idprof, idaluno, idporteiro, dataInicio);
    }
    
    public ArrayList<Aula> read(){
        AulaDAO ad = new AulaDAO();
        return ad.read();
    }
    
    public boolean update(long id, String datafim){
        AulaDAO ad = new AulaDAO();
        return ad.update(id, datafim);
    }
    
    public void delete(long id){
        AulaDAO ad = new AulaDAO();
        ad.delete(id);
    }
}
