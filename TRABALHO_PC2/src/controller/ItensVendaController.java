package controller;

import java.sql.SQLException;
import java.util.ArrayList;
import model.bean.ItensVenda;
import model.bean.Produto;
import model.dao.ItensVendaDAO;

public class ItensVendaController {
    public boolean create(int idvenda, Produto p, int qtd, double preco) throws SQLException{
        ItensVenda iv = new ItensVenda();
        ItensVendaDAO vd = new ItensVendaDAO();
        
        iv.setQuantidade(qtd);
        iv.setTotalitem(preco);
        
        return vd.create(idvenda, p, iv);
    }
    
    public ArrayList<ItensVenda> read(int idvenda){
        ItensVendaDAO id = new ItensVendaDAO();
        return id.read(idvenda);
    }
    
    public boolean delete(int idvenda, ItensVenda iv){
        ItensVendaDAO id = new ItensVendaDAO();
        return id.delete(idvenda, iv);
    }
}
