package controller;

import model.bean.Cliente;
import model.bean.Venda;
import model.bean.Vendedor;
import model.dao.VendaDAO;

public class VendaController {
    public boolean create(String data, Cliente c, Vendedor v){
        Venda venda = new Venda();
        VendaDAO vd = new VendaDAO();
        
        venda.setData(data);
        venda.setCliente(c);
        venda.setVendedor(v);
        
        return vd.create(venda);
    }
    
    
    public boolean update(double valor, int id){
        Venda venda = new Venda();
        VendaDAO vd = new VendaDAO();
        
        venda.setValorTotal(valor);
        venda.setId(id);
        return vd.update(venda);
    }
    
    
    public int selectIdVenda(){
        VendaDAO vd = new VendaDAO();
        return vd.selectIdVenda();
    }
}
