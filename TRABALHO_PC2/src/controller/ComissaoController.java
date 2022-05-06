package controller;

import model.bean.Comissao;
import model.bean.Vendedor;
import model.dao.ComissaoDAO;

public class ComissaoController {
    public boolean create(double valor, String data, Vendedor v){
        Comissao cms = new Comissao();
        ComissaoDAO cd = new ComissaoDAO();
        
        cms.setValor(valor);
        cms.setData(data);
        cms.setVendedor(v);
        
        return cd.create(cms);
    }
}
